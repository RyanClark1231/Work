
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

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

  private String serverName = "";
  private DatagramSocket sock;
  private byte[] pOut = new byte[48];
  private int sPort = 123;
  private byte[] timeBuff = new byte[8];
  long time;
  SimpleDateFormat timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

  public Client(int vNo, int mode, String serverName) {
    pOut[0] = (byte) (vNo << 3);
    pOut[0] += (byte) (mode);
    this.serverName = serverName;
    
    try {
      sock = new DatagramSocket();
      InetAddress nServ = InetAddress.getByName(serverName);
      time = System.currentTimeMillis();
      timeBuff = timestampToByte(2208988800.0 + (time / 1000.0));
      System.arraycopy(timeBuff, 0, pOut, 40, 8);
      DatagramPacket request = new DatagramPacket(pOut, pOut.length, nServ, sPort);
      sock.send(request);
      
    } catch (Exception ex) {

    }
  }

  public DatagramSocket getSock() {
    return sock;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public byte[] timestampToByte(double timeMillis) {
    byte[] byteArray = new byte[8];
    //extract the decimal part of the timestamp and move it so it is represented as a 32-bit integer
    double decimal = (timeMillis-(long)timeMillis)*4294967296L;
    //shift the time variable and get each byte starting with the highest index byte
    for (int i = 0; i < 4; i++) {
      byteArray[i] = (byte) ((long)timeMillis >> (24 - 8 * i) & 0xFF);
    }
    for (int j = 0; j < 4; j++) {
      byteArray[j+4] = (byte) ((long)decimal >> (24 - 8 * j) & 0xFF);
    }
    byteArray[7] = (byte) (Math.random()*255.0);
    return byteArray;
  }

  public String getTime() {
    return timestamp.format(new Date(time));
  }

}
