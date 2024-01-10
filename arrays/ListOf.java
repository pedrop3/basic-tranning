package arrays;

import java.util.List;

public class ListOf {

    public static void main(String[] args) {
        List<Employee> emList = List.of(new Employee(1),
                new Employee(2),
                new Employee(3));

        emList.get(0).setId(10); // Suported. The list is imutable, not the object inside the list. If you like turn the object imutable, 
        // emList.set(0, 12); // Not Suported
        // emList.add(new Employee(10)); // Not Suported

        for (Employee employee : emList) {
            System.out.println(employee.getId());

        }
    }

}

/**
 * Employee
 */
class Employee {
    

    private int id;

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
