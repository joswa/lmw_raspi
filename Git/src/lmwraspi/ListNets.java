/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmwraspi;

/**
 *
 * @author joswa
 */
import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;
import javax.swing.JOptionPane;

public class ListNets {
   
    
   static String IP = "";
    public ListNets() throws SocketException
    {
       
        main(null);
    }

    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
//            JOptionPane.showMessageDialog(null, inetAddress);
        IP = inetAddress.toString().concat(IP);
            JFLogin.IPall = IP;
           
            JOptionPane.showMessageDialog(null, IP);
        }
        out.printf("\n");
     }
} 