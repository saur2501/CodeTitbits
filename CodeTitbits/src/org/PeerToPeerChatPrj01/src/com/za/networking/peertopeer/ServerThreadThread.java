package com.za.networking.peertopeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadThread extends Thread {
	private ServerThread serverThread;
	private Socket socket;
	private PrintWriter printWriter;
	public ServerThreadThread(Socket socket, ServerThread serverThread) {
		this.serverThread = serverThread;
		this.socket = socket;
	}
	public PrintWriter getPrintWriter() {
		return printWriter;
	}
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.printWriter = new PrintWriter(socket.getOutputStream(), true);
			while(true) serverThread.sendMessage(bufferedReader.readLine());
		} catch (Exception e) {
			serverThread.getServerThreadThreads().remove(this);
		}
		
	}
}
