package util.sort.common;

import java.util.Random;

public class QuSort {

  //중복검사를 위한 메서드
    public static void dupCheck(int [] array, Random random, int maxNum){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i +1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = ((random.nextInt(maxNum)) + 1);
                }
            }
        }
    }
    
    //배열 출력하는 메서드
    public static void printArray(int [] array){
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    //난수로 배열을 만드는 메서드
    public static void makeRandomNumberArray(int [] arr, Random random, int maxNum){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((random.nextInt(maxNum)) + 1);
        }
    }
    
}
