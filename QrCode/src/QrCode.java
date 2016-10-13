import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;



public class QrCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            File file = null;
            // ť���̹����� ������ ���丮 ����
            file = new File("D:\\qrtest");
            if(!file.exists()) {
                file.mkdirs();
            }
            // �ڵ��νĽ� ��ũ�� URL�ּ�
            String codeurl = new String("CPID10101".getBytes("UTF-8"), "ISO-8859-1");
            // ť���ڵ� ���ڵ� ����
            int qrcodeColor =   0xFF2e4e96;
            // ť���ڵ� ������
            int backgroundColor = 0xFFFFFFFF;
             
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4��° parameter�� : width/height�� ����
            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,200, 200);
            // 
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO�� ����� ���ڵ� ���Ͼ���
            ImageIO.write(bufferedImage, "png", new File("D:\\qrtest\\qrcode.png"));
             
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}

}
