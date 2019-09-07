import java.awt.Image;
import java.util.Date;

public class Main {

	public static void main(String [] args) {

		try {
			System.out.println("Prueba\n");
			Method mt = new Method();
			Image image = mt.takeScreenshoot();
			String encode = mt.encodeImageToString(image);
			System.out.println(encode);
			Thread.sleep(1000);
			Image imageTwo = mt.decodeStringToImage(encode, "\\C:\\ImagenesTemporal\\"+new Date().toString().replace(":", "").trim()+".jpg");
			System.err.println("resultado: "+image.equals(imageTwo));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
