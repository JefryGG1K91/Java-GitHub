package file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jgutierrez
 */
public class FileController {

    public FileController() {

    }

    public List<FileEntity> fileListFromFolder(String path) {
        if (!path.equals("")) {
            List<FileEntity> result = new ArrayList<>();
            File file = new File(path);
            File[] files = file.listFiles();
            for (File file1 : files) {
                result.add(new FileEntity(file1.getAbsolutePath(), file1.getName(), new Date(file1.lastModified()), file1.length() / 1024, file1.getParent()));
            }
            return result;
        }
        return null;
    }

    public String readFile(String fileName) {
        
        String content = null;
        
        try {
            
            DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
            byte[] datainBytes = new byte[dis.available()];
            dis.readFully(datainBytes);
            dis.close();
            content = new String(datainBytes, 0, datainBytes.length);
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
        }
        
        return content;
    }

    public int countFileLines(String path) throws IOException{
        
        int lines = 0;
        
        if (path!=null) {
            
          lines  = (int)  Files.lines(Paths.get(new File(path).getPath())).count();
    
        }
        
        return lines;
    }
    
    public String showLines(String path, int lastLineRequired) throws IOException {
        
        String line = null;
        int currentLineNo = 0;
        int endLine = countFileLines(path);
        int startLine = endLine - lastLineRequired;
        BufferedReader in = null;
        String result = "";

        if ((startLine > 0) && (endLine > 0) && (endLine > startLine)) {
            try {
                in = new BufferedReader(new FileReader(path));
                //read to startLine
                while (currentLineNo < startLine) {
                    if (in.readLine() == null) {
                        // oops, early end of file
                        throw new IOException("File too small");
                    }
                    currentLineNo++;
                }
                //read until endLine
                while (currentLineNo <= endLine) {
                    line = in.readLine();
                    if (line != null) {
                        result += line + "\n";
                    }
                        currentLineNo++;
                }

            } catch (IOException ex) {
                System.out.println("Problem reading file.\n" + ex.getMessage());
                result = "";
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ignore) {
                    result = "";
                }
            }
        }else{
        
           result = readFile(path);
        
        }
        return result;
    }
 
}
