package com.example.programmingexercise.practicequestions;

public class Binary {
    public static int solution(int[] a) {
        int[] one = new int[a.length];
        int[] two = new int[a.length];
        one[0] = 1;
        two[0] = 0;
        int countOne = 0;
        int countTwo = 0;
        for(int i=0; i<a.length; i++){
            if(i % 2 == 0){
                one[i] = 1;
                two[i] = 0;
            }
            else{
                one[i] = 0;
                two[i] = 1;
            }
            if(a[i] != one[i]){
                countOne++;
            }
            if(a[i] != two[i]){
                countTwo++;
            }
        }
        return Math.min(countOne, countTwo);
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,1};
        int[] e = {1,1,0,1,1};
        int[] b = {0,1,0};
        int[] c = {0,1,1,0};
        int[] d = {1,1,1,1,1,1};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
        System.out.println(solution(e));
    }
}
