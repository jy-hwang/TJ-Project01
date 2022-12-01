package util.sort.bubble;

import java.util.Random;

import util.sort.common.QuSort;

public class QuBubbleSort {

	 public static void bubbleSortStart() {

        QuBubbleSort qbs = new QuBubbleSort();
        
        /**
         * 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
         * 오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
         * 버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
         * 단, 정렬되는 과정을 모두 출력해야 한다.
         * 위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.
         */
        int[] numArr = new int[10];
        
        // 난수 생성시 컴퓨터 밀리시간으로 씨드 만들기 #2
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        // 배열에 수 넣기
        QuSort.makeRandomNumberArray(numArr,random,99);

        // 중복확인 전 배열 출력
        QuSort.dupCheck(numArr, random,99);
        
        // 중복확인 후 배열 출력
        // 버블정렬 시작
        qbs.bubbleSortAsc(numArr);
        // 정렬 후 출력
        QuSort.printArray(numArr);
    }

    
    //버블 정렬을 위한 메서드(오름차순)
    public void bubbleSortAsc(int [] array){
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // 정렬과정 출력해보기
            QuSort.printArray(array);
        }
    }
    //버블 정렬을 위한 메서드(내림차순)
    void bubbleSortDesc(int [] array){
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // 정렬과정 출력해보기
            QuSort.printArray(array);
        }
    }
    
    
    
}
