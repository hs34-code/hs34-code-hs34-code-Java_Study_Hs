package Past_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study_MaxNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력할 숫자의 수 : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println();
        
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            System.out.print(i+1 +"번째 수 : ");
            arr[i] = Integer.parseInt(br.readLine());

            System.out.print("현재까지 입력된 수 : ");
            for(int j=0; j < i+1; j++){
                System.out.print(arr[j] +" ");
            }
            System.out.println("\n");
        }
        int max = arr[0];
        for(int i =0; i<arr.length; i++){
        }
        System.out.println("제일 큰 수 : " +max);
    } //main
} // class
