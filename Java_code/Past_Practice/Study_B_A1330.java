package Past_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 수 비교하기

public class Study_B_A1330 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("두 수를 입력 해주세요");

        try{
        double numA = Integer.parseInt(br.readLine());
        double numB = Integer.parseInt(br.readLine());
        if (numA > numB){
            System.out.println(" > ");
        }else if (numA < numB){
            System.out.println(" < ");
        } else {
            System.out.println( " == ");
        }
        }catch (IOException e){
            e.printStackTrace();
        }

    } //main
} //class