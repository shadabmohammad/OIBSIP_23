import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ATM {

    void withDraw(Account acc) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Amount TO WithDraw (Multiples of 100):");
        double amount = sc.nextDouble();
        if (amount % 100 == 0) {
            if (amount <= acc.balance) {
                acc.balance -= amount;
                try {
                    String filename = acc.a_no + ".txt";
                    FileWriter filewriter = new FileWriter(filename, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                    bufferedWriter.write("Date: " + new Date() + "\n");
                    bufferedWriter.write("WithDrawal: " + amount + "\n");
                    bufferedWriter.write("Account Number: " + acc.a_no + "\n");
                    bufferedWriter.write("Total Balance: " + acc.balance + "\n\n\n");
                    bufferedWriter.close();
                    filewriter.close();
                } catch (IOException e) {
                    System.out.println("An Error Occured While Writing to File");
                    e.printStackTrace();
                }
                System.out.println("\nProcessing Your Request");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Transaction Successfull\nThank You For Banking With Us");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else {
                System.out.println("Insufficient Funds");
            }
        } else {
            System.out.println("Please Enter Only Multiples of 100");
        }
    }

    void deposit(Account acc) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Amount TO Deposit :");
        double amount = sc.nextDouble();
        acc.balance += amount;
        try {
            String filename = acc.a_no + ".txt";
            FileWriter filewriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            bufferedWriter.write("Date : " + new Date() + "\n");
            bufferedWriter.write("Deposited : " + amount + "\n");
            bufferedWriter.write("Account Number : " + acc.a_no + "\n");
            bufferedWriter.write("Total Balance : " + acc.balance + "\n\n\n");
            bufferedWriter.close();
            filewriter.close();
        } catch (IOException e) {
            System.out.println("An Error Occured While Writing To File ");
            e.printStackTrace();
        }
        System.out.println("\nProcessing Transaction");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thank You For Banking With Us:");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void deposit_by_transfer(Account acc, double amount) {
        acc.balance += amount;
        try {
            String filename = acc.a_no + ".txt";
            FileWriter filewriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            bufferedWriter.write("Date : " + new Date() + "\n");
            bufferedWriter.write("Deposited : " + amount + "\n");
            bufferedWriter.write("Account Number : " + acc.a_no + "\n");
            bufferedWriter.write("Total Balance : " + acc.balance + "\n\n\n");
            bufferedWriter.close();
            filewriter.close();
        } catch (IOException e) {
            System.out.println("An Error Occured While Writing To File ");
            e.printStackTrace();
        }
    }

    void transfer(Account acc1, Account acc2, double amount) {
        if (acc1.balance >= amount) {
            acc1.balance -= amount;
            ATM a = new ATM();
            a.deposit_by_transfer(acc2, amount);
            try {
                String filename = acc1.a_no + ".txt";
                FileWriter filewriter = new FileWriter(filename, true);
                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
                bufferedWriter.write("Date : " + new Date() + "\n");
                bufferedWriter.write("Withdrawal : " + amount + "\n");
                bufferedWriter.write("Account Number : " + acc1.a_no + "\n");
                bufferedWriter.write("Total Balance : " + acc1.balance + "\n\n\n");
                bufferedWriter.close();
                filewriter.close();
            } catch (IOException e) {
                System.out.println("An Error Occured While Writing To File");
                e.printStackTrace();
            }
            System.out.println("\nProcessing Transaction");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thank You For Banking With Us:");
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    /**
     * @param acc
     */
    void displayDetails(Account acc) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Displaying Account Details");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String filename = acc.a_no + ".txt";
        File file = new File(filename);
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot Read File" + e.getMessage());
        }
        System.out.println("Screen Will Timeout In 30 Seconds");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void quit() {
        System.out.println("**Thank You For Banking With Us:**");
        return;
    }
}
