package IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.employee.Employee;

public interface IOUtils {
	// writing the data..
	// javaApp -> ObjectOutputStream -> FileOutputStream -> bin file..
	static void storeEmployeeDetails(String fileName, Map<String, Employee> employee) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// to retrieve data (Read data) from file (Deserialization)

	// javaApplication <- ObjectInputStream <- FileinputStream <- filename..

	@SuppressWarnings("unchecked")
	static Map<String, Employee> restoreEmployeeDetails(String fileName) {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {

			return (Map<String, Employee>) in.readObject();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error during De Serialization.." +e);
			return new HashMap<String, Employee>();
		}

		

	}

}
