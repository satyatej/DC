package Assignment3;

public interface RMI extends java.rmi.Remote{
	
	String[] allusers() throws java.rmi.RemoteException;
	String reversal(String s) throws java.rmi.RemoteException;
	String encryption(String s) throws java.rmi.RemoteException;
	boolean deletion(String s) throws java.rmi.RemoteException;
	String concatenation(String s, String y) throws java.rmi.RemoteException;
	
}
