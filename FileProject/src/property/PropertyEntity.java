package property;

/**
 *
 * @author jgutierrez
 */
public class PropertyEntity {

    private String path;
    private String fileName;
    private String logPath;
    private String user;

    public PropertyEntity(String path, String fileName, String logPath, String user) {
        this.path = path;
        this.fileName = fileName;
        this.logPath = logPath;
        this.user = user;
    }

    
    public PropertyEntity() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
        public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
    
        public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user+"\n"+logPath+"\n"+fileName+"\n"+path; 
    }
    
}
