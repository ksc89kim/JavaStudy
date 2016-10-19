import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientTest {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		System.out.println("������ ���� ���Դϴ�. ���� IP : " + serverIp);
		
		try {
			Socket socket = new Socket(serverIp,5000);
			
			// ������ �Է½�Ʈ���� ��´�.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            
         // �������� ���� ���� �����͸� ����Ѵ�.
            System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
            System.out.println("������ �����մϴ�.");
             
            
	        OutputStream out = socket.getOutputStream(); 
	        DataOutputStream dos = new DataOutputStream(out); // �⺻�� ������ ó���ϴ� ������Ʈ��
	        dos.writeUTF("ù��° Ŭ���̾�Ʈ ������");
	        dos.writeUTF("�ι�° Ŭ���̾�Ʈ ������");

            // ��Ʈ���� ������ �ݴ´�.
	        dos.close();
            dis.close();
            socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
