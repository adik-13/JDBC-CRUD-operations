import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) throws SQLException {
    EmployeeDao EmployeeDao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);


        boolean flag = true;
        while(flag){
            System.out.println("**************");
            System.out.println("select from the option below");
            System.out.println("**************");
            System.out.println("PRESS 1 : Add Employee");
            System.out.println("PRESS 2 : Update Employee");
            System.out.println("PRESS 3 : Delete Employee");
            System.out.println("PRESS 4 : Get all Employee");
            System.out.println("PRESS 5 : Get Employee by id");
            System.out.println("PRESS 6 : Exit");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Enter the id :");
                    int id = scanner.nextInt();
                    System.out.println("Enter name : ");
                    String name = scanner.next();
                    System.out.println("Enter email : ");
                    String email = scanner.next();
                    Employee employee = new Employee(id, name, email);
                    EmployeeDao.addEmployee(employee);

                }
                case 2 -> {
                    System.out.println("Enter the id :");
                    int empId = scanner.nextInt();
                    System.out.println("Enter the updated employee name :");
                    String empName = scanner.next();
                    System.out.println("Enter the updated employee email :");
                    String empEmail = scanner.next();
                    Employee employee = new Employee(empId, empName, empEmail);
                    EmployeeDao.updateEmployee(employee);

                }
                case 3 -> {
                    System.out.println("Enter the employee id to delete : ");
                    int id = scanner.nextInt();
                    EmployeeDao.deleteEmployee(id);
                }
                case 4 -> {
                    List<Employee> employees = EmployeeDao.getEmployee();
                    for (Employee emp : employees) {
                        System.out.println(emp.toString());
                    }
                }
                case 5 -> {
                    System.out.println("Enter the id : ");
                    int id = scanner.nextInt();
                    System.out.println(EmployeeDao.getEmployeeById(id).toString());
                }
                case 6 -> {
                    System.out.println("Exiting");
                    flag = false;
                }
            }

        }
    }
}
