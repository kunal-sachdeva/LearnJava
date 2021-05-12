package Random;



import java.util.*;

public class FlatToHierarchyJson {
  /*  public static List<EmployeeHierarchy> flatToHierarchy(List<Employee>records){
        List<EmployeeHierarchy> result=new ArrayList<>();
        Map<Integer, EmployeeHierarchy> dict=new HashMap<>();
        for(Employee record:records)
            dict.put(record.id, new EmployeeHierarchy(record.id,record.name,record.parentId));
        for(EmployeeHierarchy record: dict.values()){
            EmployeeHierarchy tempParent;
            if(record.parentId!=null){
                tempParent=dict.get(record.parentId);
                record.setParent(tempParent);
                if(tempParent!=null)
                    tempParent.addChildren(record);
            }
        }
        for(EmployeeHierarchy record: dict.values()){
            if(record.parent!=null)
                result.add(record);
        }
        return result;
    }*/

    public static List<EmployeeHierarchy> flatToHierarchySecond(List<Employee>records){
        List<EmployeeHierarchy> result=new ArrayList<>();
        Map<Integer, EmployeeHierarchy> dict=new HashMap<>();
        long start=System.currentTimeMillis();
        for(Employee record:records)
            dict.put(record.id, new EmployeeHierarchy(record.id,record.name,record.parentId));


        for(EmployeeHierarchy record: dict.values()){
            EmployeeHierarchy tempParent;
            if(record.parentId!=null){
                tempParent=dict.get(record.parentId);
                if(tempParent!=null) {
                    tempParent.addChildren(record);
                } else
                    result.add(record);
            } else
            result.add(record);
        }
        long end=System.currentTimeMillis();
        System.out.println("Took time to make hierarchy of resposne in: "+(end-start) +" ms");
        return result;
    }
    public static void main(String[] args){
        List<Employee> records=new ArrayList<>(Arrays.asList(
                new Employee(1,null,"parent1"),
                new Employee(2,1,"child1"),
                new Employee(3,1,"child1"),
                new Employee(4,1,"child1"),
                new Employee(5,null,"parent2"),
                new Employee(6,5,"child2"),
                new Employee(7,5,"child2"),
                new Employee(8,5,"child2"),
                new Employee(9,5,"child2"),
                new Employee(10,9,"child22"),
                new Employee(11,null,"parent3"),
                new Employee(12,15,"child4")
        ));

        List<EmployeeHierarchy> result=flatToHierarchySecond(records);
        /*for(EmployeeHierarchy i:result) {
            ObjectMapper mapper=new ObjectMapper();
            try {
                String str=mapper.writeValueAsString(i);
                System.out.println(str+",");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }*/



    }
}
