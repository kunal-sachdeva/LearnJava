package Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCost {

    public static class Warehouse{
        public double pc;
        public double suCost;
        public double dist;
        public Warehouse(double pc, double suCost, double dist){
            this.pc=pc;
            this.suCost=suCost;
            this.dist=dist;
        }
    }
    public static void minCost(Warehouse warehouses1, Warehouse warehouse2, Warehouse warehouse3, double req, double tcCost){
        double cost;
        List<Double> arr=new ArrayList<>();
            for(int i=0; i<=warehouses1.pc; i++) {
                if (req - i > 0) {
                    for (int j = 0; j <= warehouse2.pc; j++) {
                        if (req - i -j > 0) {
                                double k = req-i-j;
                                cost=i*warehouses1.suCost+warehouses1.dist*tcCost+j*warehouse2.suCost+warehouse2.dist*tcCost
                                +j*warehouse3.suCost+warehouse3.dist*tcCost;
                                arr.add(cost);
                                System.out.println("warehouse1= " + i + ", warehouse2="+ j+ ", warehouse3="+ k+", cost=" +cost);
                                cost=0;
                            }
                        else{
                            cost=i*warehouses1.suCost+warehouses1.dist*tcCost+j*warehouse2.suCost+warehouse2.dist*tcCost;
                            arr.add(cost);
                            System.out.println("warehouse1= " + i + ", warehouse2="+ j+ ", cost=" +cost);
                            cost=0;
                        }
                    }
                }
                else {
                    cost=i*warehouses1.suCost+warehouses1.dist*tcCost;
                    arr.add(cost);
                    System.out.println("warehouse1= " + i + ", cost=" +cost);
                    cost=0;
                }
            }
        Collections.sort(arr);
            System.out.println(arr);
    }
    public static void main(String args[]){
        Warehouse warehouse1=new Warehouse(25,10,1.6);
        Warehouse warehouse2=new Warehouse(15,15,1);
        Warehouse warehouse3=new Warehouse(30,12,1.2);
        MinCost.minCost(warehouse1,warehouse2,warehouse3,10,20);

    }
}
