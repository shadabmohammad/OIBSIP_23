import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**      WELCOME TO ATM      **");

        Account[] acc = new Account[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("      Account Create Mode:      ");
            acc[i] = new Account();
            acc[i].createAccount();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        RunAtm obj = new RunAtm();
        for (;;) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            obj.run(acc);
        }
    }
}
