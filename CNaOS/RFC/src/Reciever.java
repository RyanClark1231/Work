
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public class Reciever {

  private byte[] pIn = new byte[48];
  
  private byte leapIndicator, vNo, mode;
  private byte stratum, poll;
  private double precision;
  private String precisionStr;
  private byte[] referenceTimestamp = new byte[8];
  private byte[] originateTimestamp = new byte[8];
  private byte[] recieveTimestamp = new byte[8];
  private byte[] transmitTimestamp = new byte[8];
  private byte[] rootDelay = new byte[4];
  private byte[] rootDispersion = new byte[4];
  private byte[] referenceIdentifier = new byte[4];

  public Reciever(DatagramSocket sock) throws IOException {
    DatagramPacket reply = new DatagramPacket(pIn, pIn.length);
    sock.receive(reply);
    interpretResults(reply.getData());
  }

  private void interpretResults(byte[] reply) {

    leapIndicator = (byte) ((reply[0] >> 6) & 0x3);
    vNo = (byte) ((reply[0] >> 3) & 0x7);
    mode = (byte) (reply[0] & 0x7);
    stratum = reply[1];
    poll = (byte) Math.pow(2, reply[2]);
    precisionStr =  new DecimalFormat("0.##E0").format(Math.pow(2, reply[3]));

  }

  public byte getLeapIndicator() {
    return leapIndicator;
  }

  public byte getvNo() {
    return vNo;
  }

  public byte getMode() {
    return mode;
  }

  public byte getStratum() {
    return stratum;
  }

  public byte getPoll() {
    return poll;
  }

  public String getPrecision() {
    return precisionStr;
  }
}
