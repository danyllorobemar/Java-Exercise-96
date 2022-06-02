package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("how many employee will be registered?");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>(); 
		
		for(int i=1; i<=n; i++ ) {
			System.out.println("Employee #" + i + ":");
			System.out.println("Id:");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id already taken, try again: ");
				id = sc.nextInt();
			}
			System.out.println("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary:");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			list.add(emp);	
			
		}
		
		System.out.println();
		System.out.println("Enter the Employee id that will have the salary increase: ");
		int idSalary = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist.");
		}else {
			System.out.println("Enter the percentage:");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		
		sc.close();
			

	}

	private static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

