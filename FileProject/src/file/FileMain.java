package file;

import ObserverFile.ObservableFileLines;
import ObserverFile.ObserverFileLines;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jgutierrez
 */
public class FileMain {

    public static void main(String[] args) throws IOException {

//        FileController fc = new FileController();
//        List<FileEntity> result = fc.fileListFromFolder("C:\\Users\\jgutierrez\\Documents\\logs\\");
//        
//        for (int i = 0; i < result.size(); i++) {
//            ObservableFileLines observableFileLines = new ObservableFileLines(0);
//            ObserverFileLines observerFileLines = new ObserverFileLines();
//            observableFileLines.addObserver(observerFileLines);
//            observableFileLines.setFileLines(fc.countFileLines(result.get(i).getAbsolutePath()));
//        }
                File file = new File("C:\\Users\\jgutierrez\\Documents\\logs\\");
		System.out.println(file.getName() + " : " + getFileFolderSize(file));

    }
    
    public static double getFileFolderSize(File dir) {
		long size = 0;
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					size += file.length();
				} else
					size += getFileFolderSize(file);
			}
		} else if (dir.isFile()) {
			size += dir.length();
		}
		
                double sizeMB = (double) size / 1024 / 1024;
                
                if (sizeMB < 1) {
			sizeMB = (double) size / 1024;
		}
                
                return sizeMB;

	}
}
