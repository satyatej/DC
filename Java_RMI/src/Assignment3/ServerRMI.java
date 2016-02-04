package Assignment3;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.io.*;

public class ServerRMI extends UnicastRemoteObject implements RMI{

	private String temp=null;
	
	public ServerRMI() throws RemoteException{
		super();
	}
	public synchronized String[] allusers() throws RemoteException{
	
		String s[]=new String[100];
		ArrayList<String> al=new ArrayList<String>();
		temp="";
		int i=0;
		try{
			Process p=Runtime.getRuntime().exec("users");
			BufferedReader buff=new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((temp=buff.readLine())!=null){
				s[i]=temp;
				al.add(temp);
				i++;
			}
			
		}
		catch(IOException e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return s;
	}
	
	public synchronized String reversal(String s) throws RemoteException{
		temp=null;
		char ch[]=s.toCharArray();
		char d[]=new char[s.length()];
		int i=s.length()-1;
		for(int j=0;i>=0;j++,i--){
			d[j]=ch[i];	
		}
		temp=String.valueOf(d);	
		return temp;
	}
	
	public synchronized String encryption(String s) throws RemoteException{
		int d;
		temp=null;
		char ch[]=s.toCharArray();
		for(int i=0;i<s.length();i++){
			d=((int)ch[i]+4);
			ch[i]=(char)(d);	
		}
		temp=String.valueOf(ch);
		return temp;	
	}
	
	public synchronized boolean deletion(String s) throws RemoteException{
		
		File f=new File(s);
		boolean t=f.delete();
		return t;
	}
	
	public synchronized String concatenation(String x,String y) throws RemoteException{
		temp=null;
		temp=x.concat(y);
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setSecurityManager(new SecurityManager());
		try{
			System.out.println("Creating a RMI Server!");
			String name = "//pegasus.cs.iupui.edu:5008/RMIServer";
			ServerRMI rmiskeleton = new ServerRMI();
			System.out.println("RMIServer: binding it to name: " +name);
			Naming.rebind(name, rmiskeleton);
			System.out.println("RMI Server Ready!");
			
		}catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
