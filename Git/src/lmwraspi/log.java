/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmwraspi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mohan
 */
public class log {

    public log() {
    }
    public static void logwrite(String log){
        try(FileWriter fw = new FileWriter("Log.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println(log);
    
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    } 
    
    
    public static void main(String log) {
        logwrite(log);
        
    }
    
}
