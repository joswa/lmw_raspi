/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmwraspi;
/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  ListenGpioExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2016 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.wiringpi.GpioUtil;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example code demonstrates how to setup a listener
 * for GPIO pin state changes on the Raspberry Pi.
 *
 * @author Robert Savage
 */
public class ListenGpio  extends  Thread{
    private Thread t;
    public static String Total="Total times";
    public static String GreenHigh="GH~";
    public static String GreenLow="|GL~";
    public static String RedHigh="RH~";
    public static String RedLow="|RL~";
    public static String OrangeHigh="OH~";
    public static String OrangeLow="|OL~";
      static int  restrictgreen = 1;
      static int  restrictorange = 1;
      static int  restrictred = 1;
    
    ListenGpio() throws InterruptedException, UnknownHostException, SocketException{
        //main(null);
        
        
       
        
       
        
    }
    public void start () {
      System.out.println("Starting "  );
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
    }
    public static void main(String args[]) throws InterruptedException, UnknownHostException, SocketException {
       GpioUtil.enableNonPrivilegedAccess();
       
        ListenGpio listern = new ListenGpio();
        listern.start();
            
    }
        
    @Override
    public void run(){
         
        
        System.out.println("<--Pi4J--> GPIO Listen started.");
        GpioUtil.enableNonPrivilegedAccess();
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        final GpioPinDigitalInput Green = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput Orange = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput Red = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);
        // set shutdown state for this input pin
        Green.setShutdownOptions(true);
        Orange.setShutdownOptions(true);
        Red.setShutdownOptions(true);
        // create and register gpio pin listener
        Green.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
                PinState state = event.getState();
          
            if(restrictgreen==1){
                if(state.toString()=="HIGH"){
                    restrictgreen=2;
                    int i=0;
            while(i==0){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Green light high"); //2016/11/16 12:08:43
            GreenHigh += dateFormat.format(Startdate)+"~";
            log.main(GreenHigh);
            i++;
            }
                }
            }
            else if(restrictgreen==2){
                 if (state.toString()=="LOW"){
                     restrictgreen=1;
                    
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Green light Low"); //2016/11/16 12:08:43
            GreenLow += dateFormat.format(Startdate)+"~";        
            log.main(GreenLow);
                }
            }
            }

        });
        Red.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            PinState state = event.getState();
                      if(restrictred==1){
                if(state.toString()=="HIGH"){
                    restrictred=2;
                    int i=0;
            while(i==0){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Red light high"); //2016/11/16 12:08:43
            RedHigh += dateFormat.format(Startdate)+"~";
            i++;
            log.main(RedHigh);
            }
                }
            }
            else if(restrictred==2){
                 if (state.toString()=="LOW"){
                     restrictred=1;
                    
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Red light Low"); //2016/11/16 12:08:43
            RedLow += dateFormat.format(Startdate)+"~";        
            log.main(RedLow);
                }
            }
            }
            
        });
        Orange.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
                
            PinState state = event.getState();
          
            if(restrictorange==1){
                if(state.toString()=="HIGH"){
                    restrictorange=2;
                    int i=0;
            while(i==0){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Orange light high"); //2016/11/16 12:08:43
            OrangeHigh += dateFormat.format(Startdate)+"~";
            i++;
            log.main(OrangeHigh);
            }
                }
            }
            else if(restrictorange==2){
                 if (state.toString()=="LOW"){
                     restrictorange=1;
                    
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date Startdate = new Date();
            System.out.println(dateFormat.format(Startdate)+"Orange light Low"); //2016/11/16 12:08:43
            OrangeLow += dateFormat.format(Startdate)+"~";        
            log.main(OrangeLow);
                }
            }
            }
        });
        

        System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");
        System.out.println(Total);
        // keep program running until user aborts (CTRL-C)
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListenGpio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        // gpio.shutdown();   <--- implement this method call if you wish to terminate the Pi4J GPIO controller
    }
}
