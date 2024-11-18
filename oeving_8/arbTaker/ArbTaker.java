package arbTaker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ArbTaker {
    private Person personalia;
    private int arbTakerNr;
    private int hiredYear;
    private double salary;
    private double taxPercentage;

    public ArbTaker(Person personalia, int arbTakerNr, int hiredYear, double salary, double taxPercentage) {
        this.personalia = personalia;
        this.arbTakerNr = arbTakerNr;
        this.hiredYear = hiredYear;
        this.salary = salary;
        this.taxPercentage = taxPercentage;
    }

    public Person getPersonalia() {
        return personalia;
    }

    public int getArbTakerNr() {
        return arbTakerNr;
    }

    public int getHiredYear() {
        return hiredYear;
    }

    public double getSalary() {
        return salary;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void setHiredYear(int hiredYear) {
        this.hiredYear = hiredYear;
    }
    
    public double taxedSalary() {
        return getSalary() * getTaxPercentage();
    }

    public double grossYear() {
        return getSalary() * 12;
    }

    public double taxedYear() {
        return taxedSalary() * 11 + taxedSalary() * 0.5;
    }

    public String name() {
        return personalia.getFirstName() + ", " + personalia.getLastName();
    }

    public int age() {
        return currentYear() - personalia.getYearOfBirth();
    }

    public int yearsHired() {
        return currentYear() - getHiredYear();
    }

    public boolean hiredLonger(int year) {
        if (yearsHired() > year) {
            return true;
        }
        else return false;
    }

    public String toString() {
        String string = "Tax per month: " + taxedSalary()
            + "%nGross salary: " + grossYear()
            + "%nTax per year: " + taxedYear()
            + "%nName: " + name()
            + "%nAge: " + age()
            + "%nYears hired: " + yearsHired()
            + "%nHired more than five years: " + hiredLonger(5) + "%n";
        return string;
    }

    public static int currentYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }
    public static void main(String[] args) {
        Person person = new Person("Oscar", "Martins", 2004);
        ArbTaker arbTaker = new ArbTaker(person, 123, 2020, 37000, 0.48);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf(arbTaker.toString());
            System.out.println("Pick an option:");
            System.out.println("1. Change salary");
            System.out.println("2. Change tax percentage");
            System.out.println("3. Change year hired");
            System.out.println("4. Quit");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("What do you want to change the salary to:");

                boolean validSalary = false;

                while (!validSalary) {
                    try {
                        Double newSalary = scanner.nextDouble();
                        if (newSalary > 0) {
                            arbTaker.setSalary(newSalary);
                            validSalary = true;
                        }
                        else {
                            System.out.println("Salary has to be positive");
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Salary has to be a number");
                    }
                }
            }
            else if (option.equals("2")) {
                System.out.println("What do you want to change the tax percentage to:");

                boolean validTaxPercentage = false;

                while (!validTaxPercentage) {
                    try {
                        Double newTaxPercentage = scanner.nextDouble();
                        if (newTaxPercentage > 0 && newTaxPercentage < 1) {
                            arbTaker.setTaxPercentage(newTaxPercentage);
                            validTaxPercentage = true;
                        }
                        else {
                            System.out.println("Tax percentage has to be between 0.00 and 1.00");
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Tax percentage has to be a number");
                    }
                }
            }
            else if (option.equals("3")) {
                System.out.println("What do you want to change the year hired to:");

                boolean validYear = false;

                while (!validYear) {
                    try {
                        int newYear = scanner.nextInt();
                        if (newYear > 0 && newYear < currentYear()) {
                            arbTaker.setHiredYear(newYear);
                            validYear = true;
                        }
                        else {
                            System.out.println("Year hired has to be between year 0 and now");
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Year hired has to be a number");
                    }
                }
            }
            else if (option.equals("4")) {
                break;
            }
            else {
                System.out.println("Pick a valid option");
            }
        }
        scanner.close();
    }
}
