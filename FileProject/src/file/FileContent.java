/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author jgutierrez
 */
public abstract class FileContent {

    private String content;
    private int fileLines;
    
    public int getFileLines() {
        return fileLines;
    }

    public void setFileLines(int fileLines) {
        this.fileLines = fileLines;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
