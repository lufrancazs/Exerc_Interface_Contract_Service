package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contract;
import Entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Among the contract data: ");
		
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Date: ");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments");
		int months = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, months);

		System.out.println("Parcelas: ");
		
		for(Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		
		sc.close();

	}

}
