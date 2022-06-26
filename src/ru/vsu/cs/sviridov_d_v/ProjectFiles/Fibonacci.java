package ru.vsu.cs.sviridov_d_v.ProjectFiles;

public class Fibonacci {

    public static SimpleLinkedList<Integer> fibonacci(int num) {
        SimpleLinkedList<Integer> result = new SimpleLinkedList<>();
        int n1 = 1, n2 = 1;
        for (int i = 1; i <= num; i ++) {
            if (i >= 3) {
                n2 += n1;
                n1 = n2 - n1;
            }
            result.addLast(n2);
        }

        return result;
    }
}