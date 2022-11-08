package game.threeByThree;

import java.util.ArrayList;

public class GameTest {

    public static void main(String[] args) {
        ThreeByThreeManager tbtm = new ThreeByThreeManager();

        int[] answerArr = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        int[][] numArr = {{1, 2, 3},{ 4, 5, 6},{ 7, 0, 8}};


        // int[] numArr = {1, 5, 2, 0, 7, 3, 4, 8, 6};
        // int[] numArr = {1, 2, 3, 4, 5, 6, 7, 0, 8};
        int[] numTemp = {};

        // System.arraycopy(numArr, 0, numTemp, 0, 0);;

        String[][] strArray = new String[3][3];
        ArrayList<Integer> numArrayList = new ArrayList<>();
        ArrayList<Integer> numArrayListTemp = new ArrayList<>();
        Position po = null;
        // tbtm.makeThreeByThreeArray();

       // tbtm.gameStart();

        //tbtm.makeThreeByThreeArray();

        //tbtm.showStrArray();

        System.out.println(numArr[1].length);
        

    }

}
