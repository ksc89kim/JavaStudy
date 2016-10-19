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
			System.out.println(getTime() + "서버가 준비되었습니다.");
             
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true)
		{
			try{
				System.out.println(getTime()+"연결 요청을 기다립니다.");

				 Socket socket = serverSocket.accept();
	             System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
	             
	          // 소켓의 출력스트림을 얻는다.
	           OutputStream out = socket.getOutputStream(); 
	           DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림
				
	           // 원격 소켓(remote socket)에 데이터를 보낸다.
               dos.writeUTF("첫번째 서버 데이터");
               System.out.println(getTime() + " 데이터를 전송했습니다.");
               
               
   			// 소켓의 입력스트림을 얻는다.
               InputStream in = socket.getInputStream();
               DataInputStream dis = new DataInputStream(in);
               
            // 소켓으로 부터 받은 데이터를 출력한다.
               System.out.println("클라이언트로 받은 메세지 : " + dis.readUTF());
               System.out.println("클라이언트로 받은 메세지 : " + dis.readUTF());

               // 스트림과 소켓을 달아준다.
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
