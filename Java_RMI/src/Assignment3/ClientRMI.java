package Assignment3;
import java.rmi.*;
import java.util.Scanner;

public class ClientRMI {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output;
		String outarray[]=null;
		String input,input1;
		long start,end;
		System.setSecurityManager(new SecurityManager());
		Scanner s=new Scanner(System.in);
		try{
			
			String name = "//pegasus.cs.iupui.edu:5008/RMIServer";
			RMI rmistub = (RMI) Naming.lookup(name);
			while(true){
			System.out.println("   MENU   ");
			System.out.println("----------");
			System.out.println("1. All Users logged in");
			System.out.println("2. String Reversal");
			System.out.println("3. String Encryption");
			System.out.println("4. File Deletion");
			System.out.println("5. String Concatenation");
			System.out.println("6. Exit");
			System.out.println("Select your choice:");
			
			int d=s.nextInt();
			switch(d){
			case 1: 
				start=System.nanoTime();
				outarray=rmistub.allusers();
				end=System.nanoTime() - start;
				System.out.println("Users logged in the system are: ");
				int i=0;
				while(outarray[i]!=null){
					System.out.println(outarray[i]);
					i++;
				}
				System.out.println("Total duration is:"+end);
				break;
			case 2: 
				System.out.println("Enter the String to reverse: ");
				input=s.nextLine();
				start=System.nanoTime();
				output=rmistub.reversal(input);
				end=System.nanoTime() - start;
				System.out.println("The final Reversed string is:" +output);
				break;
			case 3:
				System.out.println("Enter the String to encrypt: ");
				input=s.next();
				output=rmistub.encryption(input);
				System.out.println("The final Encrypted string is:" +output);
				break;
			case 4:
				System.out.println("Enter the name of file to delete: ");
				input=s.next();
				boolean status=rmistub.deletion(input);
				if(status){
					System.out.println("The file is deleted successfully!!");
				}
				else{
					System.out.println("The file is not deleted!!");
				}
				break;
			case 5:
				System.out.println("Enter the First String: ");
				input=s.next();
				System.out.println("Enter the Second String: ");
				input1=s.next();
				output=rmistub.concatenation(input,input1);
				System.out.println("The final Concatenated string is:" +output);
				break;
			
			case 6: System.exit(0);
			}
		}
			
		}
		catch(Exception e){
			System.out.println("The Exception is: " +e.getMessage());
			e.printStackTrace();
		}
		System.exit(0);
	}

}
