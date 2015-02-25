
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public class Client {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    DatagramSocket sock;
    byte[] pOut = new byte[48];
    byte[] pIn = new byte[48];
    int sPort = 123;

    pOut[0] = (byte) 0b0100011;

    try {
      sock = new DatagramSocket();
      InetAddress nServ = InetAddress.getByName("0.uk.pool.ntp.org");
      DatagramPacket request = new DatagramPacket(pOut, pOut.length, nServ, sPort);
      sock.send(request);
      DatagramPacket reply = new DatagramPacket(pIn, pIn.length);
      sock.receive(reply);
      interpretResults(reply.getData());
    } catch (Exception ex) {

    }
  }

  private static void interpretResults(byte[] reply) {
    byte leapIndicator, vNo, mode;
    byte stratum, poll, precision;
    byte[] referenceTimestamp = new byte[8];
    byte[] originateTimestamp = new byte[8];
    byte[] recieveTimestamp = new byte[8];
    byte[] transmitTimestamp = new byte[8];
    byte[] rootDelay = new byte[4];
    byte[] rootDispersion = new byte[4];
    byte[] referenceIdentifier = new byte[4];

    leapIndicator = (byte) ((reply[0] >> 6) & 0x3);
    vNo = (byte) ((reply[0] >> 3) & 0x7);
    mode = (byte) (reply[0] & 0x7);
    stratum = reply[1];
    poll = reply[2];
    precision = reply[3];
    
  }
}
