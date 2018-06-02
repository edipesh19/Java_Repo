/*package whatever //do not write package name here */
package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static String isSumPresent(int[] a, int size, int val){
        int st = 0;
        int end = size-1;
        Arrays.sort(a);
        while(st < end){
            int sum = a[st] + a[end];
            if(sum > val) end--;
            else if(sum < val) st++;
            else return "Yes";
        }
        return "No";
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        String[] output = new String[testcase];
        sc.nextLine();
        for(int i = 0; i < testcase; i++){
            String[] narr = sc.nextLine().split(" ");
            int[] n = new int[2];
            n[0] = Integer.parseInt(narr[0]);
            n[1] = Integer.parseInt(narr[1]);
            int[] arr = new int[n[0]];
            String[] carr = sc.nextLine().split(" ");
            for(int j = 0; j < n[0]; j++){
                arr[j] = Integer.parseInt(carr[j]);
            }

            output[i] = isSumPresent(arr,n[0], n[1]);
        }
        for(int i = 0; i < testcase; i++){
            System.out.println(output[i]);
        }
    }
}