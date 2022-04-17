package com;

import java.io.*;
import java.net.*;

public class Assignment_1_Client {
	Socket socket;
	BufferedReader sock_in,kdb_in; PrintWriter sock_out;
	String str;
	
	public Assignment_1_Client(){
		
		try{
		
			Socket socket=new Socket("127.0.0.1",8765);
			kdb_in=new BufferedReader(new InputStreamReader(System.in)); sock_in=new BufferedReader(new	InputStreamReader(socket.getInputStream()));
			sock_out=new PrintWriter(socket.getOutputStream());
			
			while(true){
				
				System.out.println("Enter the msg"); str=kdb_in.readLine(); sock_out.println(str); sock_out.flush(); System.out.println("Msg from Server"); str=sock_in.readLine(); System.out.println(str); if(str.equals("bye"))
					break;
			} //while over socket.close();
		}
		catch (Exception e) { System.out.println(e);} //try-catch over
	} //constructor over

	public static void main(String[] args) {
	 
		new Assignment_1_Client();
	}

}

