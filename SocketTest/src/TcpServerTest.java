import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
             
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true)
		{
			try{
				System.out.println(getTime()+"���� ��û�� ��ٸ��ϴ�.");

				 Socket socket = serverSocket.accept();
	             System.out.println(getTime() + socket.getInetAddress() + " �κ��� �����û�� ���Խ��ϴ�.");
	             
	          // ������ ��½�Ʈ���� ��´�.
	           OutputStream out = socket.getOutputStream(); 
	           DataOutputStream dos = new DataOutputStream(out); // �⺻�� ������ ó���ϴ� ������Ʈ��
				
	           // ���� ����(remote socket)�� �����͸� ������.
               dos.writeUTF("ù��° ���� ������");
               System.out.println(getTime() + " �����͸� �����߽��ϴ�.");
               
               
   			// ������ �Է½�Ʈ���� ��´�.
               InputStream in = socket.getInputStream();
               DataInputStream dis = new DataInputStream(in);
               
            // �������� ���� ���� �����͸� ����Ѵ�.
               System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + dis.readUTF());
               System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + dis.readUTF());

               // ��Ʈ���� ������ �޾��ش�.
               dis.close();
               dos.close();
               socket.close();
			} catch (IOException e)
			{
				 e.printStackTrace();
			}
		}
		
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
	}
	
	

}
