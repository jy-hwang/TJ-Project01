package util.sort.selection;

import java.util.Random;

import util.sort.common.QuSort;

public class QuSelectionSort {
    /**
     * 1. 선택정렬은 전체 요소 중에서 최소값을 찾아 "첫번째 자리"와 교환한다.
     * 2. 1회전을 수행하면 최소값이 맨 앞에 오게 되므로
     *    첫번째 자료를 제외한 나머지 자료에서 최소값을 찾아 "두번째 자리" 와 교환한다.
     * 3. 위 과정을 반복한다.
     * 4. 자료가 N 개 라면 교환은 (N - 1) 번 이루어진다.
     */
    
    public static void selectionSortStart() {

        /**
         * 저번에 버블정렬에서 만든 배열 만드는 메서드 및 중복체크하는 메서드를
         * QuSort 클래스에 따로 정의
         * static 메서드로 만들어서 클래스 명으로 직접 접근 가능
         */
        
        QuSelectionSort qss = new QuSelectionSort();
        
        int[] numArr = new int[10];
        
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        // 배열에 수 넣기
        QuSort.makeRandomNumberArray(numArr,random,99);

        // 중복확인 전 배열 출력
        QuSort.dupCheck(numArr, random,99);
        
        // 선택 정렬
        qss.selectionSort(numArr);
        // 정렬 후 출력
        QuSort.printArray(numArr);

    }
    //선택정렬 메서드
  public void selectionSort(int [] numArr){
        
        for (int i = 0; i < numArr.length - 1; i++) {

            int min_index = i;
            // 최소값의 위치 찾기
            
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[min_index] > numArr[j]) {
                    min_index = j;
                }
            }

            // 자리 바꾸기
            int temp = numArr[min_index];
            numArr[min_index] = numArr[i];
            numArr[i] = temp;
        }
        
    }
    
}
