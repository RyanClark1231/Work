
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

  private DatagramSocket sock;
  private byte[] pOut = new byte[48];
  private int sPort = 123;

  public Client(int vNo, int mode) {
    pOut[0] = (byte) (vNo << 3);
    pOut[0] += (byte) (mode);

    try {
      sock = new DatagramSocket();
      InetAddress nServ = InetAddress.getByName("0.uk.pool.ntp.org");
      DatagramPacket request = new DatagramPacket(pOut, pOut.length, nServ, sPort);
      sock.send(request);
      

      //System.out.println(reply.getAddress());
    } catch (Exception ex) {

    }
  }

  public DatagramSocket getSock() {
    return sock;
  }

}
