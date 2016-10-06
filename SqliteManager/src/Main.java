
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SqliteManager manager = SqliteManager.getInstance();
        if(manager.checkPhoneNumber("01059290033"))
        {
        	System.out.println("중복된번호입니다.");
        	return;
        }
        manager.insertPhoneData("01059290033");
    	System.out.println("성공!");
	}

}
