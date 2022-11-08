package game.threeByThree;

public class ThreeByThreeManager {

    String[] answerArr = {"1", "2", "3", "4", "5", "6", "7", "8", "x"};
    String[] strArr = {"x","1", "2", "5", "6", "3", "4", "7","8"};

    String[][] strArray = new String[3][3];

    Position po = null;

    void array3ToArray1() {
        int count = 0;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                strArr[count] = strArray[i][j];
                count++;
            }
        }
    }

    boolean checkAnswer() {
       // System.out.println("check Answer");
        array3ToArray1();
        int count = 0;
        for (int i = 0; i < answerArr.length; i++) {
            if (strArr[i] == answerArr[i]) {
                count++;
            }
        }

        if (9 == count) {
            return true;
        } else {
            return false;
        }
    }


    void inputW() {
        if (po.horizontal + 1 <= 2) {
            String temp = strArray[po.horizontal + 1][po.vertical];
            strArray[po.horizontal][po.vertical] = temp;
            strArray[po.horizontal + 1][po.vertical] = "x";
            po.setPosition(po.horizontal + 1, po.vertical);
        } else {
            System.out.println("움직일 수 없습니다.");
        }
    }

    void inputA() {
        if (po.vertical + 1 <= 2) {
            String temp = strArray[po.horizontal][po.vertical + 1];
            strArray[po.horizontal][po.vertical] = temp;
            strArray[po.horizontal][po.vertical + 1] = "x";
            po.setPosition(po.horizontal, po.vertical + 1);
        } else {
            System.out.println("움직일 수 없습니다.");
        }
    }

    void inputS() {
        if (po.horizontal - 1 >= 0) {
            String temp = strArray[po.horizontal - 1][po.vertical];
            strArray[po.horizontal][po.vertical] = temp;
            strArray[po.horizontal - 1][po.vertical] = "x";
            po.setPosition(po.horizontal - 1, po.vertical);
        } else {
            System.out.println("움직일 수 없습니다.");
        }

    }

    void inputD() {
        if (po.vertical - 1 >= 0) {
            String temp = strArray[po.horizontal][po.vertical - 1];
            strArray[po.horizontal][po.vertical] = temp;
            strArray[po.horizontal][po.vertical - 1] = "x";
            po.setPosition(po.horizontal, po.vertical - 1);
        } else {
            System.out.println("움직일 수 없습니다.");
        }
    }

    void showStrArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(strArray[i][j] + " ");
                if ("x".equalsIgnoreCase(strArray[i][j])) {
                    po.setPosition(i, j);
                }
            }
            System.out.println();
        }
    }


    

    void makeThreeByThreeArray() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ("x".equalsIgnoreCase(strArr[count].toString())) {
                    po = new Position(i, j);
                }
                strArray[i][j] = strArr[count].toString();
                count++;
            }
        }
    }


}
