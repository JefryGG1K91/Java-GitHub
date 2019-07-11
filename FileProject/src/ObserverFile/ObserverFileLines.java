package ObserverFile;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author jgutierrez
 */
public class ObserverFileLines implements Observer{

    private ObservableFileLines observableFileLines;
    
    @Override
    public void update(Observable observable, Object arg) {
       observableFileLines = (ObservableFileLines) observable;
        System.out.println("Lines count is:"+observableFileLines.getFileLines());
    }
    
}
