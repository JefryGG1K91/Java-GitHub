package property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author jgutierrez
 */
public class PropertyController {

    private static volatile PropertyController instance = null;

    private Properties properties = null;

    public PropertyController() {

        if (instance != null) {

            throw new RuntimeException("Use getInstance() method to create class object");

        }
    }

    public static PropertyController getInstance() {

        if (instance == null) {

            synchronized (PropertyController.class) {

                if (instance == null) {

                    instance = instance = new PropertyController();

                }

            }

        }

        return instance;
    }

    public void writePropertyFile(PropertyEntity fileEntity) {

        if (fileEntity != null) {

            if (fileEntity.getPath() != null) {

                File dir = new File(fileEntity.getPath());

                if (dir.exists() || dir.mkdir()) {

                    OutputStream outputStream = null;

                    try {

                        properties = new Properties();

                        File file = new File(fileEntity.getPath() + fileEntity.getFileName());

                        outputStream = new FileOutputStream(new File(fileEntity.getPath() + fileEntity.getFileName()));

                        properties.setProperty(PropertyEnum.path.name(), fileEntity.getPath());

                        properties.setProperty(PropertyEnum.fileName.name(), fileEntity.getFileName());

                        properties.setProperty(PropertyEnum.logPath.name(), fileEntity.getLogPath());

                        properties.setProperty(PropertyEnum.user.name(), fileEntity.getUser());

                        properties.store(outputStream, null);

                    } catch (IOException io) {

                        System.out.println(io.getMessage());

                    } finally {

                        if (outputStream != null) {

                            try {

                                outputStream.close();

                            } catch (IOException e) {

                                e.getMessage();

                            }
                        }
                    }
                } else {
                    System.out.println("controller.PropertyController.writePropertyFile()");
                }
            } else {
                System.out.println("'path' parameter is null.");
            }
        } else {
            System.out.println("File parameters null.");
        }

    }

    public PropertyEntity readConfigFile(String filePath) {

        try {

            InputStream input = new FileInputStream(filePath);

            properties = new Properties();

            properties.load(input);

            //String path, String fileName, String logPath, String user
            return new PropertyEntity(properties.getProperty(PropertyEnum.path.name()),
                    properties.getProperty(PropertyEnum.fileName.name()),
                    properties.getProperty(PropertyEnum.logPath.name()),
                    properties.getProperty(PropertyEnum.user.name())
            );

        } catch (IOException e) {

            e.getMessage();

        }

        return null;
    }

}
