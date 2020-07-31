package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VotingMachine {
    public static Map<String, Integer> candidateList = new HashMap<>();
    private static void CastVote(int voterID, int candidateID){
        try(FileWriter fw = new FileWriter("votes.txt", true)){
            fw.write(Integer.toString(voterID)+','+Integer.toString(candidateID)+"\n");
            System.out.println("Vote successfully casted!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void populateList(){
        candidateList.put("Kunal", 1);
        candidateList.put("Tinku", 2);
        candidateList.put("Raj", 3);
    }
    public static void main(String...args){
        populateList();
        while(1 == 1){
            System.out.println("Enter Voter ID to initiate vote casting...");
            Scanner in  = new Scanner(System.in);
            int voterID=in.nextInt();
            System.out.println(candidateList+"\n"+"Enter candidate ID to cast vote...");
            Scanner in2  = new Scanner(System.in);
            int candidateID=in.nextInt();
            CastVote(voterID,candidateID);
        }
    }
}
