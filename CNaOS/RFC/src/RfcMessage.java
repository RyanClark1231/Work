/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class RfcMessage {
  public byte leapIndicator, vNo, mode;
  public byte stratum, poll, precision;
  public byte[] rootDelay, rootDispersion, referenceIdentifier, referenceTimestamp, originateTimestamp, recieveTimestamp, transmitTimestamp;
  public byte[] message = new byte[48];
  
  public RfcMessage() {
    }
  
  public RfcMessage(int vNo, int mode){
    this.vNo = (byte) vNo;
    this.mode = (byte) mode;
  }
  
  public void createMessage(){
    message[0] = (byte) mode;
    message[0] += (byte) vNo << 3;
    message[0] += (byte) leapIndicator << 6; 
  }
  
  
}
