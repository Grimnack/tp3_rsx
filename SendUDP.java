/**
 *  TP1 Réseaux - UDP et Multicast
 *  Exercice 1
 *  Matthieu Caron
 *  Arnaud Cojez
 */

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

/**
 * Class used to send a message
 */
public class SendUDP {
    
    public static void main (String[] args) throws Exception {
	DatagramSocket socket= new DatagramSocket();
	DatagramPacket packetS;
	DatagramPacket packetR = new DatagramPacket(new byte[512], 512);
	InetAddress dst = InetAddress.getByName("172.18.12.9");
	int port = Integer.parseInt("53");
	byte[] message = { (byte) 0x08,(byte) 0xbb,(byte) 0x01,(byte) 0x00,
			   (byte) 0x00,(byte) 0x01,(byte) 0x00,(byte) 0x00,
			   (byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,
			   (byte) 0x03,(byte) 0x77,(byte) 0x77,(byte) 0x77,
			   (byte) 0x04,(byte) 0x6c,(byte) 0x69,(byte) 0x66,
			   (byte) 0x6c,(byte) 0x02,(byte) 0x66,(byte) 0x72,
			   (byte) 0x00,
			   (byte) 0x00,(byte) 0x01,
			   (byte) 0x00,(byte) 0x01 };

	packetS = new DatagramPacket(message, message.length, dst, port);
	socket.send(packetS);
	socket.receive(packetR);
	System.out.println("paquet reçu de " + packetR.getAddress() + " port " + packetR.getPort() + " taille " + packetR.getLength());
	byte array[] = packetR.getData();
	for(int i = 0; i<packetR.getLength();i++){
	    System.out.print(","+Integer.toHexString((array[i])&0xff));
	    if ((i+1)%16==0)
		System.out.println("");
	}
	System.out.println("");
	//String str = new String(array);
	//System.out.println(str);
	socket.close(); 
    }
}
