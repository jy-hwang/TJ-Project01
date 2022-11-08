package commonUtil;

import java.util.Scanner;

public class CommonUtil {

    public static String scanValue(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + " 을/를 입력>>");
        String tmp = scan.nextLine();
        return tmp;
    }

    public static int scanInt(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + " 을/를 입력>>");
        int tmp = scan.nextInt();
        scan.nextLine();
        return tmp;
    }

}
