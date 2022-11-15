package game.baseball;

import java.util.Random;

public class BaseballGame {

    public static void main(String[] args) {

        int[] computerArr = new int[3];
        // int[] computerArr = {2, 2, 2};

        int[] myArr = {5, 3, 7};

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
        for (int i : computerArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 중복확인하기
        for (int i = 0; i < computerArr.length; i++) {
            for (int j = 0; j < computerArr.length; j++) {
                if (i != j) {
                    System.out.println(computerArr[i] + " , " + computerArr[j]);
                    if (computerArr[i] == computerArr[j]) {
                        computerArr[j] = (random.nextInt(8)) + 1;
                        System.out.println(computerArr[j]);
                    }
                }
            }
        }

        // 출력해보기
        for (int i : computerArr) {
            System.out.print(i + " ");
        }
        System.out.println();


        /*
         * 각 자리수가 같으면 스트라이크
         */
        int strikeCnt = 0;
        for (int i = 0; i < computerArr.length; i++) {
            if (computerArr[i] == myArr[i]) {
                strikeCnt++;
            }
        }
        /*
         * 각 자리수가 3개 같으면 3 스트라이크로 게임이 끝나므로
         * 볼 처리할 필요가 없음.
         */
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

        System.out.printf("%d 볼 , %d 스트라이크%n", ballCnt, strikeCnt);

    }
}
