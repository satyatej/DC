import java.rmi.*;
import java.rmi.server.*;

public class BankServer extends UnicastRemoteObject implements Bank{
	private float value = 10000;
	private int id = 0;
	private String name;

	public BankServer(String s) throws RemoteException{
		super(); name = s;
	}

	public synchronized int get_id() throws RemoteException{
		id++; return id;
	}

	public synchronized void deposit(int id, float amount) throws
		RemoteException{
			System.out.println("Deposit by:" + id);
			value += amount;
			System.out.println("Balance: " + value);
	}

	public synchronized void withdraw(int id, float amount) throws
		RemoteException{
		System.out.println("Withdrawn by:" + id);
		if (value < amount)	
			System.out.println("No!");
		else {
			value -= amount;
			System.out.println("Balance: " + value);
			}
	}

	public synchronized void check(int id) throws RemoteException{
		System.out.println("checked by: " + id);
		System.out.println("Balance: " + value);
	}

	public static void main(String args[]){
		System.setSecurityManager(new SecurityManager());
		try{
			System.out.println("Creating a Bank Server!");
			String name = "rmi://localhost:5000/BankServer";
			BankServer bank = new BankServer(name);
			System.out.println("BankServer: binding it to name: " +
			name);
			Naming.rebind(name, bank);
			System.out.println("Bank Server Ready!");
		} catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}


