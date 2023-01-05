package employeepayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		System.out.println("Enter how many employees do you have: ");
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		
		List<Employee> employees = new ArrayList<>();
		for (int i =0;i<N;i++) {
			System.out.printf("Employee #%d data \n",(i+1));
			System.out.println("Is your employee outsourced(y/n)?");
			char c = sc.next().charAt(0);
			System.out.println("Enter employee's name: ");
			sc.nextLine(); // consumes the pending line break from previous sc.next().charAt(0) 
			String name = sc.nextLine();
			System.out.println("Enter employee's hours worked: ");
			int hours = sc.nextInt();
			System.out.println("Enter employee's payment per hour: ");
			double paymentPerHour = sc.nextDouble();
			if(c == 'y') {
				System.out.println("Enter employee's additional charge:");
				double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, paymentPerHour, additionalCharge);
				employees.add(emp);
			}
			
			else if (c == 'n'){
				//Employee emp = new Employee(name, hours, paymentPerHour);
				// emp variable may be dismissed if we want
				employees.add(new Employee(name, hours, paymentPerHour));
			}
			
		}
		System.out.println();
		System.out.println("PAYMENTS: ");
		for (Employee emp: employees) {
			System.out.println(emp.getName() + ":"+" "+"$"+String.format("%.2f",emp.payment()));
		}
		sc.close();
	}

}
