import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        System.out.print("Enter worker data: \n");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base Salary: ");
        Double salary = sc.nextDouble();

        System.out.println();
        Worker worker = new Worker(name, level, salary, new Department(department));

        System.out.print("How many contracts to this worker: ");
        int contracts = sc.nextInt();

        for (int i = 1; i <= contracts; i++) {
            System.out.print("Enter Contract #" + i + " data: \n");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (Hours): ");
            Integer hours = sc.nextInt();
            System.out.print("\n");

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("");

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String incomeData = sc.next();
        int month = Integer.parseInt(incomeData.substring(0,2));
        int year = Integer.parseInt(incomeData.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + incomeData + ": " + String.format("%.2f", worker.income(year,month)));
        sc.close();
    }
}