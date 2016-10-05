import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.imageio.ImageIO;

public class ImageUtils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	    //ImageWrite write....
        //BufferedImage newImg;
        //newImg = decodeToImage(res_radio_disable);
        //ImageIO.write(newImg, "png", new File("files/img/res_radio_disable.png"));
		
        createImageResourceJava();
	}
	
    /**
     * Decode string to image
     * @param imageString The string to decode
     * @return decoded image
     * @throws IOException 
     */
	public static void createImageResourceJava() throws IOException {
        FileUtils fileUtils = new FileUtils();
        fileUtils.createJavaFile("ImageResource");
		String path = "files/img/";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File = " + listOfFiles[i].getName());
				BufferedImage img = null;
				String imageFormat = getFormate(listOfFiles[i].getName());
				System.out.println("File format = " + imageFormat);
				img = ImageIO.read(new File(path+listOfFiles[i].getName()));
		        String imgstr = encodeToString(img, imageFormat);
				System.out.println("imgstr = " + imgstr);
				fileUtils.addImageString(listOfFiles[i].getName(), imgstr);
			}
		}
        fileUtils.closeJavaFile();
	}
	
	public static String getFormate(String ImageName) {
		String subString = ImageName.substring(ImageName.indexOf('.'),ImageName.length());
		String format = "";
	    switch(subString)
	    {
	        case ".png": format = "PNG"; break;
	        case ".gif": format = "GIF"; break;
	        case ".tiff": format = "TIFF"; break;
	        case ".jpg": format = "JPG"; break;
	        case ".jpeg": format = "JPEG"; break;
	        case ".PNG": format = "PNG"; break;
	        case ".GIF": format = "GIF"; break;
	        case ".TIFF": format = "TIFF"; break;
	        case ".JPG": format = "JPG"; break;
	        case ".JPEG": format = "JPEG"; break;
	    }
	    return format;
	}

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
        	Decoder decoder = Base64.getDecoder();
            imageByte = decoder.decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

        	Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    
}
