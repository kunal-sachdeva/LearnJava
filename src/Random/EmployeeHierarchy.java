package Random;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHierarchy {
    int id;
    String name;
    Integer parentId;
    //EmployeeHierarchy parent;
    List<EmployeeHierarchy> children;

    public EmployeeHierarchy(){}
    public EmployeeHierarchy(int id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        children=new ArrayList<>();
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

/*    public EmployeeHierarchy getParent() {
        return parent;
    }

    public void setParent(EmployeeHierarchy parent) {
        this.parent = parent;
    }*/

    public List<EmployeeHierarchy> getChildren() {
        return children;
    }

    public void setChildren(List<EmployeeHierarchy> children) {
        this.children = children;
    }
    public void addChildren(EmployeeHierarchy children) {
        this.children.add(children);
    }

    @Override
    public String toString() {
        return "EmployeeHierarchy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}
