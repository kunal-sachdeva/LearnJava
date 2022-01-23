package Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    Map<Integer, Pair<String,Integer>> logs;
    Map<String, List<Integer>> stnDict;

    public UndergroundSystem() {
        logs=new HashMap<>();
        stnDict=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        logs.put(id,new Pair(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInDt=logs.get(id);
        int checkInTime=checkInDt.getValue();
        String checkInPlace=checkInDt.getKey();
        String stns=checkInPlace+"-"+stationName;
        List temp;
        if(!stnDict.containsKey(stns))
            temp=new ArrayList();
        else
            temp= stnDict.get(stns);
        temp.add(t - checkInTime);
        stnDict.put(stns,temp);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer>ll=stnDict.get(startStation+"-"+endStation);
        int res=0;
        for(int i:ll)
            res=res+i;
        return res;
    }
}
