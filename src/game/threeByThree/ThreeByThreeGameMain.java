package game.threeByThree;

import java.util.Scanner;

public class ThreeByThreeGameMain {

    public void gameStart(){
        ThreeByThreeGameMain tgm = new ThreeByThreeGameMain();
        ThreeByThreeManager tbtm = new ThreeByThreeManager();

        tbtm.makeThreeByThreeArray();

        Scanner scan = new Scanner(System.in);

        int maxGameCount = 100;
        int gameCount =100;
        boolean isTrue = true;
        while (isTrue) {

            tbtm.showStrArray();
            // gm.showStrArray(numArrayListTemp, strArray, po);
            System.out.println("w,a,s,d 중 입력하세요. 종료는 exit.남은 게임 횟수 : " + gameCount);

            String tempStr = scan.nextLine();

            gameCount--;
            System.out.println("입력한 키는 " + tempStr + "입니다.");
            if (tempStr.equalsIgnoreCase("w")) {
                // gm.inputW(strArray, po);
                tbtm.inputW();
            } else if (tempStr.equalsIgnoreCase("a")) {
                tbtm.inputA();
            } else if (tempStr.equalsIgnoreCase("s")) {
                tbtm.inputS();
            } else if (tempStr.equalsIgnoreCase("d")) {
                tbtm.inputD();
            } else if (tempStr.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                System.exit(0);
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }

            if(gameCount < 1){
               System.out.println("게임횟수가 모두 소진되었습니다.");
               System.out.println("재시작하시겠습니까?");
               String tmp = tgm.scanValue("y or n");
               if (tmp.equalsIgnoreCase("N")) {
                   System.exit(0);
               }else if(tmp.equalsIgnoreCase("Y")){
                   gameCount = maxGameCount;
                   continue;
               }
            }
            
            if (tbtm.checkAnswer()) {
                System.out.println("정답입니다!");
                tbtm.showStrArray();
                System.out.println("재시작하시겠습니까?");
                String tmp = tgm.scanValue("y or n");
                if (tmp.equalsIgnoreCase("N")) {
                    System.out.println("3 x 3 게임이 종료됩니다.");
                    isTrue = false;
                    
                    break;
                    //System.exit(0);
                }else{
                    gameCount = maxGameCount;
                    continue;
                }
            }
        }
    }

    
    String scanValue(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + " 을/를 입력>> ");
        String temp = scan.nextLine();
        System.out.println();
        return temp;
    }

    

}
