package Past_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구구단 출력하기

public class Study_B_A2739 {
    public static void main(String[] args) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("출력할 구구단 단 수 : ");
    try{
    int numA = Integer.parseInt(br.readLine());
    int numB = 0;
    for(int i = 1; i <10; i++){
        numB = numA * i;
        System.out.println(numA +" * " +i +" = " +numB);
    }
    }catch (IOException e){
        e.printStackTrace();
    }
 
    }
}
