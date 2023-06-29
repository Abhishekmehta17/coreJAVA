package Tester;

import static Validations.ValidationRules.validateAndParseOwner;
import static coreClass.IOUtils.storePropertyDetails;
import static coreClass.IOUtils.*;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import coreClass.Owner;

public class TestPropertyRentSystem {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Set<Owner> owner = new HashSet<Owner>();
			System.out.println("Enter File location..");
			String fileName = "C:/Users/dac/Desktop/OwnerDeatils.txt";
			//String fileName = sc.nextLine();
			File f1 = new File(fileName);

			if (f1.isFile() && f1.canRead() && f1.length() != 0) {
				owner = restorePropertyDetails(fileName);
			} else {
				System.out.println("File is Empty...");
			}
			

			boolean exit = false;

			while (!exit) {

				try {
					System.out.println("Enter choice..\n" + "1.Add Owner\n" + "2.Display all owner\n"
							+ "3.Delete Owner by Aaadhaar.\n" + "4.Sort Owner by Property Type..\n"
							+ "5.Book Property..\n" + "0.Exit..");

					switch (sc.nextInt()) {
					case 1:// "1.Add Owner\n"
							// aadhaarNo, firstname, lastname, email, address, mobno, validPropertyType,
							// validDate, rent
						System.out.println("Enter Owner Details...\n" + "1.Addhaar Number..\n" + "2.FirstName.."
								+ "3.LastName..\n" + "4.email\n" + "5.address\n" + "6.mobNo\n"
								+ "7.PropertyType..[ONE_RK,ONE_BHK,TWO_BHK,THREE_BHK,FOUR_BHK]\n" + "8.Available Date\n"
								+ "9.Rent\n");

						owner.add(validateAndParseOwner(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), sc.nextInt(), owner));
						System.out.println("Owner Added Successfully..");

						break;
					case 2:
						owner.stream().forEach(System.out::println);
						break;
					case 3:
						System.out.println("Enter aadhaarNo..");
						String aadhaar = sc.next();
						Iterator<Owner> itr = owner.iterator();
						while(itr.hasNext()) {
							if(itr.next().getAadhaarNo().equals(aadhaar)) {
								itr.remove();
								break;
							}
						}
						System.out.println("Owner removed Successfully...");
					
						break;
					case 4:
						owner.stream().sorted((o1,o2) -> {if(o1.getPropertyType().compareTo(o2.getPropertyType())!= 02)
						{
						return o1.getPropertyType().compareTo(o2.getPropertyType());
					}else{
						return o1.getEmail().compareTo(o2.getEmail());
					}}).forEach(System.out::println);
					break;

						
					case 5:
						//5.Book Property..\n
						
						

						break;
					case 0:
						System.out.println("Exit..");
						exit = true;
						storePropertyDetails(owner, fileName);
						break;

					default:
						System.out.println("Invalid Choice..");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
