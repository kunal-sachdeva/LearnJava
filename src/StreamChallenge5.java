import Practice.Palindrome;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.*;
import java.lang.System;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
    public class StreamChallenge5 extends Thread{
        public void run(){
            for(int i=1;i<=5;i++){
                try{
                    Thread.sleep(500);
                }catch(Exception e){System.out.println(e);}
                System.out.println(i);
            }
        }
        public static void main(String args[]){
            StreamChallenge5 t1=new StreamChallenge5();
            StreamChallenge5 t2=new StreamChallenge5();
            StreamChallenge5 t3=new StreamChallenge5();
            t1.start();
            try{
                t1.join();
                System.out.println("t1 completed");
            }catch(Exception e){System.out.println(e);}

            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t3.start();
        }

    }
