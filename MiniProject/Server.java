package MiniProject;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Server
{
	public static void main(String[] args)
	{
		int port = 8080;
		try(ServerSocket serverSocket = new ServerSocket(port))
		{
			System.out.println("Server is listening on port " + port);
			while(true)
			{
				System.out.println("New client connected");
				new ClientHandler(serverSocket.accept()).start();
			}
		}
		catch (IOException e)
		{
			System.out.println("Server exception: " + e.getMessage());
		}
	}
}

class ClientHandler extends Thread
{
	private final Socket socket;
	private final DataOutputStream dos;
	private final DataInputStream dis;

	public ClientHandler(Socket socket) throws IOException
	{
		this.socket = socket;
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());

		System.out.println("Connected to server.");
	}

	public String listener() throws IOException
	{
		System.out.println("listener is activated.");

		StringBuilder stringBuilder = new StringBuilder();
		int index = dis.read();

		while(index != 0)
		{
			stringBuilder.append((char)index);
			index = dis.read();
		}

		System.out.println("listener road command successfully.");
		return stringBuilder.toString();
	}

	public void writer(String write) throws IOException
	{
		dos.writeBytes(write);
		dos.flush();
		dos.close();

		dis.close();
		socket.close();

		System.out.println("write");
		System.out.println("command finished.");
	}

	@Override
	public void run()
	{
		super.run();

		String clientMessage;
		try
		{
			clientMessage = listener();

			System.out.println("Received command: " + clientMessage);
		}
		catch(IOException e)
		{
			System.out.println("Server exception: " + e.getMessage());
		}
	}
}