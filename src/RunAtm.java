import java.util.*;

public class RunAtm {

    int search(Account[] acc, String U_ID) {
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(acc[i].u_id, U_ID)) {
                return i;
            }
        }
        return -1;
    }

    int search(Account[] acc, int ac_no) {
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(acc[i].a_no, ac_no)) {
                return i;
            }
        }
        return -1;
    }

    void run(Account[] acc) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\n*** WELCOME TO ATM ***\n");
        System.out.println("\nEnter Your Card Unique Id[U_ID] : ");
        String uniq_id = sc.nextLine();
        int i = search(acc, uniq_id);
        if (i == -1) {
            System.out.println("Account is Not Registered:");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter Your PIN : ");
            int pin = sc.nextInt();
            if (pin == acc[i].pin) {
                System.out.println("\nSELECT ONE OPTION");
                System.out.println(
                        "\n1.WITHDRAW \n\n2.DEPOSIT\n\n3.TRANSFER\n\n4.DISPLAY DETAILS\n\n5.QUIT");
                int op = sc.nextInt();
                ATM atm = new ATM();
                switch (op) {
                    case 1:
                        atm.withDraw(acc[i]);
                        break;
                    case 2:
                        atm.deposit(acc[i]);
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Enter the Account Number Of The Reciever :");
                        int acc2transfer = sc.nextInt();
                        int j = search(acc, acc2transfer);
                        if (j == -1) {
                            System.out.println("\nAccount Not Yet Registered");
                            return;
                        } else {
                            System.out.println("Enter Amount For Transferring Funds : ");
                            int amt = sc.nextInt();
                            atm.transfer(acc[i], acc[j], amt);
                        }
                    case 4:
                        atm.displayDetails(acc[i]);
                        break;
                    case 5:
                        atm.quit();

                }
            } else {
                System.out.println("Entered Wrong PIN\nTry Again!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

}
