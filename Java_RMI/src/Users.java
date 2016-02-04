import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Users {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer out=new StringBuffer();
		String temp="";
		int i=0;
		try{
			
			Process p=Runtime.getRuntime().exec("who");
			BufferedReader buff=new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((temp=buff.readLine())!=null){
				out.append(temp+"\n");
			}
		}
		catch(IOException e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("All the users logged in are:"+out.toString());
	}

}
