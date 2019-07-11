package socketConnection;

import java.util.Date;

/**
 *
 * @author jgutierrez
 */
public class FileEntity{

    private String absolutePath;
    private String name;
    private Date lastModified;
    private long length;
    private String parentFolder;

    public FileEntity(String absolutePath, String name, Date lastModified, long length, String parentFolder) {
        this.absolutePath = absolutePath;
        this.name = name;
        this.lastModified = lastModified;
        this.length = length;
        this.parentFolder = parentFolder;
    }

    public FileEntity() {
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(String parentFolder) {
        this.parentFolder = parentFolder;
    }

    @Override
    public String toString() {
        return  parentFolder + "\n" + absolutePath + "\n" + name + "\n" + lastModified + "\n" + length;
    }

}
