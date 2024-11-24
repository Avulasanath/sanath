package com.neoteric.collection.streams.flatmapdemo;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {

    public static void main(String[] args) {


        List<Employee>employeeList= List.of (new Employee("ravi",11,56000,"Hr"),
                new Employee("shiva",12,64000,"IT"),
                new Employee("krishna",13,40000,"Finance"),
                new Employee("satish",14,85000,"Hr"),
                new Employee("dheeraj",15,97500,"IT"),
                new Employee("Hari",16,92000,"Finance"),
                new Employee("sam",17,35000,"finance"));

        List<Employee>employees = employeeList.stream().flatMap(employee -> employeeList.stream()).collect(Collectors.toList());

        Optional<Employee> maxSalary= employeeList.stream().flatMap(employee -> employeeList.stream()).collect(Collectors.toList()).stream().
                max(Comparator.comparing(Employee::getSalary));

        Optional<Employee> minSalary= employeeList.stream().flatMap(employee -> employeeList.stream()).collect(Collectors.toList()).stream().

                min(Comparator.comparing(Employee::getSalary));
        System.out.println("employees details:"+employees);
        System.out.println("MaximumSalary:"+ maxSalary );
        System.out.println("minimumSalary:"+minSalary);



    }
}
