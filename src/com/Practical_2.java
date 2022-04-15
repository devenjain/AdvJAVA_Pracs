package com;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class Practical_2 {

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

	public static void inetAddressFunc() {

		try {
			InetAddress ip = InetAddress.getByName("www.javatpoint.com");

			System.out.println("Host Name: " + ip.getHostName());
			System.out.println("IP Address: " + ip.getHostAddress());
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void urlAndURLclassDemo() {

		try {

			URL url = new URL("https://restapi2020.herokuapp.com/api/users.json");

			System.out.println("Protocol: " + url.getProtocol());

			System.out.println("Host Name: " + url.getHost());

			System.out.println("Port Number: " + url.getPort());

			System.out.println("File Name: " + url.getFile());

			URLConnection urlcon = url.openConnection();

			InputStream stream = urlcon.getInputStream();

			int i;

			while ((i = stream.read()) != -1) {

				System.out.print((char) i);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		Practical_2.studentData();
		Practical_2.inetAddressFunc();
		Practical_2.urlAndURLclassDemo();
	}
}
