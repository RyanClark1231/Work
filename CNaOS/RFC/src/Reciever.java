
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.DecimalFormat;
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
public class Reciever {

  private byte[] pIn = new byte[48];
  private byte leapIndicator, vNo, mode, stratum, poll;
  private double precision, referenceTimestamp, originateTimestamp, recieveTimestamp, transmitTimestamp;

  private byte[] rootDelay = new byte[4];
  private byte[] rootDispersion = new byte[4];
  private byte[] referenceIdentifier = new byte[4];
  byte[] replyBuff;
  SimpleDateFormat timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
  DecimalFormat df = new DecimalFormat(".00000");

  public Reciever(DatagramSocket sock) throws IOException {
    DatagramPacket reply = new DatagramPacket(pIn, pIn.length);
    sock.receive(reply);
    replyBuff = reply.getData();
    interpretResults(replyBuff);
  }

  private void interpretResults(byte[] reply) {

    leapIndicator = (byte) ((reply[0] >> 6) & 0x3);
    vNo = (byte) ((reply[0] >> 3) & 0x7);
    mode = (byte) (reply[0] & 0x7);
    stratum = reply[1];
    poll = (byte) Math.pow(2, reply[2]);
    precision = Math.pow(2, reply[3]);

    referenceTimestamp = (((byteToTimestamp(reply, 16)) - 2208988800.0) * 1000);
    originateTimestamp = (((byteToTimestamp(reply, 24)) - 2208988800.0)* 1000);
    recieveTimestamp = (((byteToTimestamp(reply, 32)) - 2208988800.0) * 1000);
    transmitTimestamp = (((byteToTimestamp(reply, 40)) - 2208988800.0) * 1000);

  }

  public double byteToTimestamp(byte[] byteArray, int index) {
    double timestamp = 0.0;
    int bitIndex = 31;
    //Take each byte then iterate over the bits working out the value corresponding to the overall index
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        timestamp += ((byteArray[index + i] >> 7 - j) & 0x1) * Math.pow(2, bitIndex);
        bitIndex--;
      }
    }
    return timestamp;
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
    return new DecimalFormat("0.##E0").format(precision);
  }

  public String getReferenceTimestamp() {
    return (timestamp.format(new Date((long) referenceTimestamp))+ df.format(referenceTimestamp - (long) referenceTimestamp));
  }

  public String getOriginateTimestamp() {
    return (timestamp.format(new Date((long) originateTimestamp))+ df.format(originateTimestamp - (long) originateTimestamp));
  }

  public String getRecieveTimestamp() {
    return (timestamp.format(new Date((long) recieveTimestamp))+ df.format(recieveTimestamp - (long) recieveTimestamp));
  }

  public String getTransmitTimestamp() {
    return (timestamp.format(new Date((long) transmitTimestamp))+ df.format(transmitTimestamp - (long) transmitTimestamp));
  }

}
