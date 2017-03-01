package DefiningClassesExr.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Double>> departments = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();

        Integer n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            String currentName = input[0];
            Double currentSalary = Double.parseDouble(input[1]);
            String currentPosition = input[2];
            String currentDepartment = input[3];
            String currentEmail = null;
            Integer currentAge = null;
            switch (input.length) {
                case 5:
                    currentEmail = input[4].contains("@") ? input[4] : null;
                    currentAge = !input[4].contains("@") ? Integer.parseInt(input[4]) : null;
                    break;
                case 6:
                    currentEmail = input[4];
                    currentAge = Integer.parseInt(input[5]);
                    break;
            }
            Employee employee = new Employee(currentName, currentSalary, currentPosition, currentDepartment, currentEmail, currentAge);
            if (!departments.containsKey(currentDepartment)) {
                departments.put(currentDepartment, new ArrayList<>());
            }
            departments.get(currentDepartment).add(currentSalary);
            employeeList.add(employee);
        }
        HashMap<String, Double> averages = new HashMap<>();
        departments.entrySet().stream().forEach(e -> {
            double a = e.getValue().stream().mapToDouble(i -> i).average().getAsDouble();
            averages.put(e.getKey(), a);
        });
        String departmentWithHighestSalary =
                Collections.max(averages.entrySet(), (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).getKey();

        System.out.printf("Highest Average Salary: %s\n",departmentWithHighestSalary);

        employeeList.stream()
                .filter(e -> e.getDepartment().equals(departmentWithHighestSalary))
                .sorted((e1,e2)-> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(System.out::println);
    }
}
