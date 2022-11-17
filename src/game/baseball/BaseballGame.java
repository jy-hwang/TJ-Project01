package game.baseball;

import java.util.Random;
import commonUtil.CommonUtil;

public class BaseballGame {

    void showArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    int checkStrike(int[] computerArr, int[] myArr) {
        int strikeCnt = 0;
        for (int i = 0; i < computerArr.length; i++) {
            if (computerArr[i] == myArr[i]) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    int checkBall(int strikeCnt, int[] computerArr, int[] myArr) {
        int ballCnt = 0;
        if (strikeCnt < 3) {
            for (int i = 0; i < computerArr.length; i++) {
                for (int j = 0; j < myArr.length; j++) {
                    if (computerArr[i] == myArr[j]) {
                        ballCnt++;
                    }
                }
            }
        }
        return ballCnt;
    }

    void checkDup(int[] computerArr, Random random, int maxNum) {
        for (int i = 0; i < computerArr.length; i++) {
            for (int j = 0; j < computerArr.length; j++) {
                if (i != j) {
                    // System.out.println(computerArr[i] + " , " + computerArr[j]);
                    if (computerArr[i] == computerArr[j]) {
                        computerArr[j] = (random.nextInt(maxNum)) + 1;
                        // System.out.println(computerArr[j]);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        BaseballGame bg = new BaseballGame();

        int[] computerArr = new int[3];
        // int[] computerArr = {2, 2, 2};

        // int[] myArr = {2,3,8};
        int[] myArr = new int[3];


        /*
         * 1. 배열 3자리 만들기
         * 2. 난수 생성해서 배열에 넣기
         * 3. 중복제거하기.
         * 4. 
         */
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < computerArr.length; i++) {
            computerArr[i] = (random.nextInt(8)) + 1;
        }

        // 출력해보기
        // bg.showArr(computerArr);

        // 중복확인하기
        bg.checkDup(computerArr, random, 8);

        // 출력해보기
        bg.showArr(computerArr);

        int count = 0;
        while (count < 3) {
            int tempNum = CommonUtil.scanInt("배열에 입력할 수");
            myArr[count] = tempNum;
            count++;
        }

        /*
         * 각 자리수가 같으면 스트라이크
         */
        int strikeCnt = bg.checkStrike(computerArr, myArr);

        /*
         * 각 자리수가 3개 같으면 3 스트라이크로 게임이 끝나므로
         * 볼 처리할 필요가 없음.
         */
        int ballCnt = bg.checkBall(strikeCnt, computerArr, myArr);


        System.out.printf("%d 볼 , %d 스트라이크%n", ballCnt, strikeCnt);

    }
}
