import java.rmi.*;

public class BankClient{
	static int id;

	public static void main(String args[]){
		System.setSecurityManager(new SecurityManager());

		try{
			String name = "rmi://localhost:5000/BankServer";
			Bank myBank = (Bank) Naming.lookup(name);
			id = myBank.get_id();
			System.out.println("My Id: " + id);	
			myBank.check(id);
			myBank.deposit(id, 500);
			myBank.withdraw(id, 200);
			
		} catch(Exception e){
			System.out.println("BankClient Exception: " +
			e.getMessage());
			e.printStackTrace();
		}
		System.exit(0);
	}
}
