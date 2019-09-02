package hashtable;

import java.util.Arrays;

// Q. 해시 테이블의 크기가 소수이어야 하는 이유는 ? 
// A. 배열의 크기와 건너뛸 간격이 서로 소 이어야만, 모든 칸들을 방문할 수 있게 된다.  
public class Example8 {

    public static void main(String[] args) {
        int hashTableSize = 13;
        int step = 4;
        int startIndex = 3;
        int[] a = new int[hashTableSize];

        for (int i = 0; i < hashTableSize; ++i) {
            int index = (startIndex + (step * i)) % hashTableSize;
            a[i] = index;
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
