import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class Method {

	public Image takeScreenshoot() {
		
		Image image = null;
		
		 try { 
	            Thread.sleep(120); 
	            Robot r = new Robot(); 
	  
	            // Used to get ScreenSize and capture image 
	            Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
	            image = r.createScreenCapture(capture); 
	            System.out.println("Screenshot saved"); 
	        } 
	        catch (AWTException | InterruptedException ex) { 
	            System.out.println(ex); 
	        } 
		 
		 return image;
		
	}
	
	public String encodeImageToString(Image image) {
		
		byte[] fileContent = null;
		String encodedString = "";
		String path = "\\C:\\ImagenesTemporal\\"+new Date().toString().replace(":", "").trim()+".jpg";
		
		
		try {

			ImageIO.write((RenderedImage) image, "jpg", new File(path)); 
			
	        File inputFile = new File(path);
	        
			fileContent = FileUtils.readFileToByteArray(inputFile);
			
			 encodedString = Base64
					.getEncoder()
					.encodeToString(fileContent);
			
			 
//			 inputFile.delete();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return encodedString;
		
	}

	public Image decodeStringToImage(String encodeString, String path) {
		Image imageResult = null;
		
		try {
	        // decode the string and write to file
			File inputFile = new File(path);
			
	        byte[] decodedBytes = Base64
	          .getDecoder()
	          .decode(encodeString);
	        FileUtils.writeByteArrayToFile(inputFile, decodedBytes);
	        
	        imageResult = ImageIO.read(inputFile);

//	        inputFile.delete();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imageResult;
	}
	
}
