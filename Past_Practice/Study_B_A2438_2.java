package Past_Practice;
// 별찍기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Study_B_A2438_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        System.out.println("마름모 별의 수 : ");
        int numA = Integer.parseInt(br.readLine());
        numA = numA -1;
        // 마름모 위
        for(int i = numA; i >= 0; i--){
            for(int j = 0; j <= numA; j++){
                if(j<i)System.out.print("  ");
                else System.out.print("★ ");
            }
            for(int j = 0; j <= numA-i ; j++){
                System.out.print("★ ");
            }
            System.out.println();
        }

        // 마름모 아래
        for(int i = 0; i <= numA; i++){
            for(int j = 0; j <= numA; j++){
                if(j<i)System.out.print("  ");
                else System.out.print("★ ");
            }
            for(int j = numA; j>=i; j--){
                System.out.print("★ ");
            }
            System.out.println();
        }
    }catch (IOException e){
        e.printStackTrace();
    }
    } //main
} //class
