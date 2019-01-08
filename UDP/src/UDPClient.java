import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int portN =11111;
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];
		String message;
		
		DatagramSocket socket = new DatagramSocket();
		//Packet bauen und addressieren
		
		InetAddress serverIp = InetAddress.getByName("localhost");
		outData="ping".getBytes();
		DatagramPacket out = new DatagramPacket(outData, outData.length, serverIp, portN);
		socket.send(out);
		//Antwort empfangen und ausgeben
		DatagramPacket in = new DatagramPacket(inData, inData.length);
		socket.receive(in);
		message = new String(in.getData(),0,in.getLength());
		System.out.println("Habe bekommen: " +message);
		socket.close();
	}

}
