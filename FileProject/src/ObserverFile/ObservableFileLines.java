package ObserverFile;

import java.util.Observable;

/**
 *
 * @author jgutierrez
 */
public class ObservableFileLines extends Observable {

    private int fileLines;

    public ObservableFileLines(int fileLines) {
        this.fileLines = fileLines;
    }
    
     public int getFileLines() {
        return fileLines;
    }

    public void setFileLines(int fileLines) {
        this.fileLines = fileLines;
        setChanged();
        notifyObservers();
    }
}
