import java.util.*;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("I have a Number between 1 & 100 Take a guess");
        System.out.println("You Have 5 Chances");
        int k = 5;
        int ans = (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (k-- > 0) {
            int guess = sc.nextInt();
            if (guess == ans) {
                System.out.println("Congratulations You Won");
                flag = true;
                break;
            } else if (guess > ans) {
                System.out.println("Too High You Have " + (k) + " Chances Left");
            } else {
                System.out.println("Too Low You Have " + (k) + " Chances Left");
            }
        }
        if (!flag) {
            System.out.println("You Lost The Number Was " + ans);
        }
        sc.close();

    }
}
