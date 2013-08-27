/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hostinformation;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroArnoldo
 */
public class HostInformation {

    /**
     * @param args the command line arguments
     */
    String ip, mac;
    
    public HostInformation(){
        try {
            //Obtener dirección IP
            InetAddress inetAddress = InetAddress.getLocalHost();
            this.ip = inetAddress.getHostAddress();
            
            //Obtener MAC Address
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<hardwareAddress.length; i++){
                stringBuilder.append(String.format("%02X%s", hardwareAddress[i], (i<(hardwareAddress.length-1)) ? "-" : ""));
            }
            this.mac = stringBuilder.toString();
            
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(HostInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        HostInformation hostInformation = new HostInformation();
        
        System.out.println("Dirección IP: "+hostInformation.ip+" Dirección MAC: "+hostInformation.mac);
    }
}
