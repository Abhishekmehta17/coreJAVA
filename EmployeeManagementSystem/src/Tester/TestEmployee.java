package Tester;

import static ValidationRules.ValidationRules.validateDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static IOUtils.IOUtils.*;

import com.employee.Employee;

import CustomExceptions.EmployeeHandlingException;
//C:\Users\abhi\Desktop\JavaOOPs\employee.txt
public class TestEmployee {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Employee> employee = new HashMap<>();
			int choice = 0;

			boolean exit = false;
			System.out.println("Enter FileLocation..");
			String fileLocation = sc.nextLine();
			System.out.println();
			employee = restoreEmployeeDetails(fileLocation);
			while (!exit) {

				System.out.println("Enter Choice..\n" + "1. Hire new emp\r\n" + "2. List all emp details\r\n"
						+ "3. Promote an emp\r\n" + "4. Delete emp details\r\n"
						+ "5. Sort emps as per join date n display the same.\r\n"
						+ "6. We can add many more options here.....\r\n" + "0. Exit");

				try {
					
					
					choice = sc.nextInt();

					switch (choice) {
					case 1:// Hire new emp..

						System.out.println(
								"Enter Employee Details\n" + "id,firstName,lastName,Department,JoiningDate,Salary");
						validateDetails(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								employee);
						storeEmployeeDetails(fileLocation, employee);
						System.out.println("Employee Added successfully..");
						break;
					case 2:// "2. List all emp details\r\n"
					//	employee = restoreEmployeeDetails(fileLocation);
						employee.forEach((k, v) -> System.out.println(v));

						break;
					case 3:// "3. Promote an emp\r\n"
						//enter id --> sal increase bt 10%..
						System.out.println("Enter employee id");
						String id = sc.next();
						double sal = employee.get(id).getSalary();
						employee.get(id).setSalary(sal*1.10);
						System.out.println("Promotion Success .. 10% hike in salary!!!");
						break;
					case 4:// "4. Delete emp details\r\n"
						System.out.println("Enter employee id");
						 id = sc.next();
						 Employee tempEmp = employee.remove(id) ;
						 if(tempEmp!= null) {
							 System.out.println(tempEmp);
							 System.out.println("Employee deleted succesfully..");
						 }else {
							 throw new EmployeeHandlingException("Employee not Found..");
						 }
						
						// +"\n Employee deleted succesfully.."
						
						
						break;
					case 5:// "5. Sort emps as per join date n display the same.\r\n"

						employee.values().stream()
								.sorted((e1, e2) -> e1.getJoiningDate().compareTo(e2.getJoiningDate()))
								.forEach(p -> System.out.println(p));

						break;
					case 0:
						System.out.println("Exit..");
						storeEmployeeDetails(fileLocation, employee);
						exit = true;
						break;

					default:
						System.out.println("Invalid Input..");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
