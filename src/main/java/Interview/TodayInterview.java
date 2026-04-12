package Interview;

import java.util.ArrayList;
import java.util.List;

public class TodayInterview {

    public static void main(String[] args) {
        Employee emp=new Employee("Alice",  "Engineering", 95000d);
        Employee emp2=new Employee("Harshit",  "CS", 14000d);
        Employee emp3=new Employee("Dev",  "Physics", 34000d);
        Employee emp4=new Employee("Milind",  "ENT", 3500d);
        Employee emp5=new Employee("Raghav",  "Eyes", 10000d);

        List<Employee> empList=new ArrayList<>();
        empList.add(emp);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        Employee highestSalEmp=empList.stream().sorted((x,y)->Double.compare(x.getSalary(),y.getSalary())).findFirst().get();
        System.out.println(highestSalEmp.salary);
    }
}
class Employee{
    String name;
    String branch;
    Double salary;

    Employee(String name, String branch, Double salary){
        this.name=name;
        this.branch=branch;
        this.salary=salary;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

//        .collect(Collectors.groupingBy(
//        Employee::department,
//                     Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
//        ))
//        .entrySet().stream()
//              .map(entry -> entry.getValue()
//                  .<Result>map(emp -> new Result.Found(entry.getKey(), emp))
//        .orElse(new Result.NotFound(entry.getKey()))
//        )
//        .toList();
//
//          results.forEach(result -> {
//        // Pattern matching in switch — Java 21
//        switch (result) {
//        case Result.Found(var dept, var emp) ->
//        System.out.printf("Department: %-15s | Top Earner: %-10s | Salary: $%.0f%n",
//                          dept, emp.name(), emp.salary());
//        case Result.NotFound(var dept) ->
//        System.out.println("Department: " + dept + " | No employees found");
//              }
//                      });
//