package util.lotto;

import java.util.Random;

import util.sort.bubble.QuBubbleSort;
import util.sort.common.QuSort;

/**
 * 크기가 6인 배열을 생성한다. 
 * 1~45사이의 중복되지 않는 난수를 생성하여 1에서 생성한 배열에 추가한다. 
 * 버블정렬을 이용해서 오름차순 정렬한다. 
 * 최종 로또번호를 출력한다. 
 */
public class QuLottoArray {


    public static void makeLottoArray() {

        QuBubbleSort qbs = new QuBubbleSort();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int[] lottoArray = new int[6];

        System.out.println("### 배열 만들기 ###");
        QuSort.makeRandomNumberArray(lottoArray, random, 44);

        QuSort.dupCheck(lottoArray, random, 44);

        System.out.println("### 정렬 후 ###");
        QuSort.printArray(lottoArray);

    }

}
