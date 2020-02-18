package net.skhu.array;

public class Example2 {

    static void print(int[] a) {
        for (int i : a)
            System.out.printf("%d ", i);
    }

    /**
     * 배열 a에서 index 위치 뒤의 값들을 한 칸씩 앞으로 당기고
     * 배열의 끝에 0을 대입하라.
     * 
     * @param a
     * @param index
     */
    static void remove(int[] a, int index) {
        for (int i = index; i < a.length-1; ++i)
            a[i] = a[i+1];
        a[a.length - 1] = 0;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = i;

        remove(a, 5);

        print(a);
    }
}
