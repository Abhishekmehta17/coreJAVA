package ValidationRules;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.employee.Department;
import com.employee.Employee;

import CustomExceptions.EmployeeHandlingException;

public class ValidationRules {

//	2.3 Let's say that : Company is only 3 years old. (so think of a validation rule on joining date)
//
//	2.4 Add required parsing / validation methods n custom exceptions
//
//	2.5 Ask yourself : where will you perform serialization n de-serialization ?

	public static Map<String, Employee> validateDetails(String id, String firstName, String lastName, String dept,
			String joiningDate, double salary, Map<String, Employee> newEmployee) throws EmployeeHandlingException {
		validateDup(id, newEmployee);
		LocalDate validDate = validateAndParseJoinDate(joiningDate);
		Department validDept = validateAndParseDept(dept);
		newEmployee.put(id, new Employee(id, firstName, lastName, validDept, validDate, salary));
		return newEmployee;

	}

	public static void validateDup(String id, Map<String, Employee> employees) throws EmployeeHandlingException {
		if (employees.containsKey(id)) {
			throw new EmployeeHandlingException("Duplicate Employee..");
		}
	}

	public static LocalDate validateAndParseJoinDate(String joiningDate) throws EmployeeHandlingException {

		LocalDate parse = LocalDate.parse(joiningDate);
		if (parse.isBefore(LocalDate.of(2020, 05, 9))) {
			throw new EmployeeHandlingException("Invalid date...");
		}
		return parse;

	}

	public static Department validateAndParseDept(String dept) {
		return Department.valueOf(dept.toUpperCase());
	}

}
