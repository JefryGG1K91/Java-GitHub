package property;

/**
 *
 * @author jgutierrez
 */
public class PropertyMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PropertyController controller = PropertyController.getInstance();

//        PropertyEntity entity = new PropertyEntity("C:\\"+System.getProperty("user.name")+"-LogConfigReader\\","config.properties","C:\\",System.getProperty("user.name"));
//        controller.writePropertyFile(entity);
//        System.out.println(controller.readConfigFile(entity.getPath()+entity.getFileName()));

        System.out.println(controller.readConfigFile("C:\\" + System.getProperty("user.name") + "-LogConfigReader\\config.properties").getLogPath());
    }

}
