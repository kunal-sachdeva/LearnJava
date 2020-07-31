package FileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static FileHandling.VotingMachine.candidateList;
import static FileHandling.VotingMachine.populateList;

public class CountVotes {
    private static Map<Integer, Integer> voteBox=new HashMap<>();
    private static void Count(String rawData){
            String[] data=rawData.split(",");
            voteBox.put( Integer.valueOf(data[1]), voteBox.getOrDefault( Integer.valueOf(data[1]),0)+1 );
            //System.out.println(voteBox);
    }
    private static void displayResult(){
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(voteBox.entrySet());
        if (pq.peek()!=null)
        System.out.println("Winner is: "+getCandidateName(pq.peek().getKey())+". Won by total votes: "+pq.peek().getValue());
    }
    private static String getCandidateName(Integer id){
        populateList();
        for(Map.Entry<String,Integer> m : candidateList.entrySet() ){
            if(id == m.getValue())
                return m.getKey();
        }
        return null;
    }
    public static void main(String[] args){
        String fileName="votes.txt";
        String line;
            try(RandomAccessFile rd=new RandomAccessFile(fileName,"r")){
                while(true){
                    if((line=rd.readLine())!=null){
                        //System.out.println(line);
                        Count(line);
                    }
                    else {
                        displayResult();
                        Thread.sleep(5000);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
