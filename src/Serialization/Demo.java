package Serialization;

import java.io.*;

public class Demo {
    public static void main(String args[]){
        SerializingDemo sd=new SerializingDemo(1,"Demo");
        String fileName= "file.ser";

        try {
            FileOutputStream file=new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(file);
             out.writeObject(sd);
             out.close();
             file.close();
             System.out.println("Object is Serialized"+sd) ;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SerializingDemo sd1=null;
        try {
            FileInputStream file1 = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file1);
            sd1= (SerializingDemo) in.readObject();
            in.close();
            file1.close();
            System.out.println("Deserialized Obj" +
                    sd1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(sd.equals(sd1)){
            System.out.println("Objects Matched");
        }
        else{
            System.out.println("Objects did not Matched");
        }
    }


}
