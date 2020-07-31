package Generics;

import java.util.ArrayList;

public class GenericClass {

      <X,Y> void genericDisp(X obj, Y obj1){
        System.out.println(obj.getClass().getName()+" = "+obj);
         System.out.println(" = "+obj1);
    }
    public static void main(String[] args){
            ArrayList ll= new ArrayList();
            ll.add("test");
            ll.add(10);
            ll.add(10.21);
            System.out.println(ll);
            GenericClass ob1= new GenericClass();
            ob1.genericDisp("K", null);

    }


}
