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
		System.out.println("서버에 연결 중입니다. 서버 IP : " + serverIp);
		
		try {
			Socket socket = new Socket(serverIp,5000);
			
			// 소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            
         // 소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");
             
            
	        OutputStream out = socket.getOutputStream(); 
	        DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림
	        dos.writeUTF("첫번째 클라이언트 데이터");
	        dos.writeUTF("두번째 클라이언트 데이터");

            // 스트림과 소켓을 닫는다.
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
