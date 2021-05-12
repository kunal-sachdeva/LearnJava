package Random;

public class Employee {
    Integer parentId;
    int id;
    String name;

    public Employee(int id, Integer parentId, String name){
        this.id=id;
        this.name=name;
        this.parentId=parentId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
