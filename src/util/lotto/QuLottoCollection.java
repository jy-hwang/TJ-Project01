package util.lotto;

import java.util.Random;
import java.util.TreeSet;

/**
 * 배열을 이용한 버전과 동일한 조건으로 제작하되 Set<E> 컬렉션을 이용한다.
 * Set<E> 계열의 컬렉션은 중복이 자동으로 제거된다.
 * 하지만 순서를 보장하지 않으므로 TreeSet<E>을 사용하면 된다.
 */
public class QuLottoCollection {

    public static void makeLottoCollection() {

        TreeSet<Integer> treeSet = new TreeSet<>();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        while(treeSet.size() <6 ){
            treeSet.add((random.nextInt(44)) + 1);
        }
        
        System.out.println(treeSet);
      
    }

}
