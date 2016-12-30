/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Git;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mohan
 */
public class arrayconvertion {
    public static void main(String test,int colour) throws ArrayIndexOutOfBoundsException{
  // String test ="GH~2016/12/29 07:24:45~2016/12/29 07:24:46~2016/12/29 07:24:46~2016/12/29 07:24:46~2016/12/29 07:24:47~2016/12/29 07:24:47~|GL~2016/12/29 07:24:45~2016/12/29 07:24:46~2016/12/29 07:24:46~2016/12/29 07:24:46~2016/12/29 07:24:47~2016/12/29 07:24:47~\n" +
//"";     
       /* File x1 = new File("StatusGreen.txt");
         if (x1.exists()) {
             x1.delete();     
              }
            File x2 = new File("StatusRed.txt");
         if (x2.exists()) {
             x2.delete();     
              }
            File x3 = new File("StatusOrange.txt");
         if (x3.exists()) {
             x3.delete();     
              }
         */
         if(colour==1){
   String[] test1 = test.split("GL");
        System.out.println(test1[0]);
   String[] test2 = test1[0].split("~");
   String[] test3 = test1[1].split("~");
        System.out.println(test2.length);
        System.out.println(test3.length);
        for(int i=1 ;i<test2.length;i++){
        try{
            
            System.out.println(test2[i]+"::::::::::>");
            if(i<test3.length){
                System.out.println(test3[i]);
            }
            
               
              try(FileWriter fw = new FileWriter("StatusGreen.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    //out.println(test2[i]+"::::::::::>");
       
            out.println(test2[i]);
            if(i<test3.length){
                out.println("::::::::::>"+test3[i]);
            }
       
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
        
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
    }
         
    else if(colour==2){
    String[] test1 = test.split("RL");
        System.out.println(test1[0]);
   String[] test2 = test1[0].split("~");
   String[] test3 = test1[1].split("~");
        System.out.println(test2.length);
        System.out.println(test3.length);
        for(int i=1 ;i<test3.length;i++){
        try{
            
            System.out.println(test2[i]+"::::::::::>"+test3[i]);
            System.out.println(test3[i]);
               
              try(FileWriter fw = new FileWriter("StatusRed.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    
            out.println(test2[i]);
            if(i<test3.length){
                out.println("::::::::::>"+test3[i]);
            }
       
       
       
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
        
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
}
    
    else if(colour==3){
        String[] test1 = test.split("OL");
        System.out.println(test1[0]);
   String[] test2 = test1[0].split("~");
   String[] test3 = test1[1].split("~");
        System.out.println(test2.length);
        System.out.println(test3.length);
        for(int i=1 ;i<test3.length;i++){
        try{
            
            System.out.println(test2[i]+"::::::::::>"+test3[i]);
            System.out.println(test3[i]);
               
              try(FileWriter fw = new FileWriter("StatusOrange.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
            out.println(test2[i]);
            if(i<test3.length){
                out.println("::::::::::>"+test3[i]);
            }
       
       
} catch (IOException e) {
    //exception handling left as an exercise for the reader
}
        
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
    
}
    }
}   
