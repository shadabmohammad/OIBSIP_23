import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Account {

    static int acc_no = 1111;
    String acc_HolderName;
    int pin;
    String u_id;
    double balance;
    int a_no;

    void createAccount() {
        a_no = acc_no;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name:");
        acc_HolderName = sc.nextLine();
        System.out.print("\nEnter UserName:");
        u_id = sc.nextLine();
        int length = 0;
        do {
            System.out.println("\nEnter Secret 4 Digit Pin:");
            pin = sc.nextInt();
            length = String.valueOf(pin).length();
        } while (length != 4);
        System.out.println("Enter The Initial Deposit Amount:");
        balance = sc.nextDouble();
        System.out.println("Congratulations Account Created Successfully");
        System.out.println("Account Details :\n" + "Account Number : " + a_no + "\nAccount Holder Name: "
                + acc_HolderName + "\nUser Id: " + u_id +
                "\nPin :" + pin + "\nAvailable Balance :" + balance + "\nThank You");
        String filename = acc_no + ".txt";
        File file = new File(filename);
        try {
            file.createNewFile();
            FileWriter filewriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            bufferedWriter.write("Date: " + new Date() + "\n");
            bufferedWriter.write("Account Created\n");
            bufferedWriter.write("Account Number :" + acc_no + "\n");
            bufferedWriter.write("Account Holder Name :" + acc_HolderName + "\n");
            bufferedWriter.write("User Name :" + u_id + "\n");
            bufferedWriter.write("Secret Pin: " + pin + "\n");
            bufferedWriter.write("Balance : " + balance + "\n\n\n");

            bufferedWriter.close();
            filewriter.close();
        } catch (Exception e) {
            System.out.println("Error Occured While Creating the File" + filename);
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        acc_no++;
    }
}
