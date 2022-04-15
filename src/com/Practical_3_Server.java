package com;

import java.net.*;
import java.io.*;

public class Practical_3_Server {
	
	public static void studentData() {
		System.out.println();
		System.out.println("===================================================");
		System.out.println("                   Student Data                         ");
		System.out.println("===================================================");
		System.out.println("Name       : Chopra Deven M");
		System.out.println("Class      : 6CE-A1");
		System.out.println("Enrollment : 190130107018");
		System.out.println("Subject    : Advance Java");
		System.out.println("Practical  : 2");
		System.out.println("===================================================");
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Practical_3_Server.studentData();
		int count = 1;
		System.out.println("Server is running...................");
		ServerSocket ss = new ServerSocket(7878);
		while (true) {
			new RevThread(ss.accept(), count).start();
			System.out.println(count + " client connected");
			count++;
		}
	}
}

class RevThread extends Thread {
	Socket s = null;
	int n;

	public RevThread(Socket socket, int count) {
		s = socket;
		n = count;
	}

	public void run() {
		try {
			while (true) {
				System.out.println("receiving from client " + n);
				DataInputStream din = new DataInputStream(s.getInputStream());
				String str = din.readUTF();
				System.out.println("processing data of Client " + n);
				StringBuffer rev = new StringBuffer();
				rev = rev.append(str);
				rev = rev.reverse();
				String revStr = new String(rev);
				System.out.println("sending to client " + n);
				DataOutputStream dout = new DataOutputStream(s.getOutputStream());
				dout.writeUTF(revStr);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
