package commonUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonUtil {

    public static String scanValue(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + " 을/를 입력>>");
        
        String  tmp ="";
        try {
            tmp = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("문자를 입력하세요.");
        }
        tmp.trim();
        return tmp;
    }

    public static int scanInt(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + " 을/를 입력>>");
        int tmp = 0;
        try {
            tmp = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력하세요.");
        }
        return tmp;
    }

}
