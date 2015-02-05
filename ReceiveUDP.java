/**
 *  TP1 Réseaux - UDP et Multicast
 *  Exercice 1
 *  Matthieu Caron
 *  Arnaud Cojez
 */

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.lang.String;

/**
 * Class used to Receive a Message
 */
public class ReceiveUDP {

    public static void main (String[] args) throws Exception {
	DatagramSocket socket = new DatagramSocket();
	DatagramPacket packet = new DatagramPacket(new byte[512], 512);

	socket.receive(packet);

	System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());

	byte array[] = packet.getData();
	String str = new String(array);
	System.out.println(str);
	
	socket.close();
    }
}
