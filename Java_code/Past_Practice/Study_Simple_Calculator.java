package Past_Practice;
// 간단한 계산기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study_Simple_Calculator {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("수 입력 : ");
        double result = Double.parseDouble(br.readLine());
        double num = 0;
        String operator = null;

  
        while(true) {
            System.out.print("연산자 입력( +, -, *, /, % ), ( = ) : ");
            operator = br.readLine();

            if (!(operator.equals("+") 
            || operator.equals("-") 
            || operator.equals("*") 
            || operator.equals("/") 
            || operator.equals("%")
            || operator.equals("="))) {
                 System.out.println("잘못된 연산자입니다.");
                continue;
            }

            if(operator.equals("=")){
                if (result % 1 == 0) System.out.println((int) result);
                else System.out.println(result);
            break;
            }
            
            try{

            System.out.print("수 입력 : ");
            num = Double.parseDouble(br.readLine());

            } catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다.");
            continue;
            }
            
            switch(operator){
                case "+" : result += num; break;
                case "-" : result -= num; break;
                case "*" : result *= num; break;
                case "/" : 
                    if(num == 0) System.out.println("0으로는 나눌 수 없습니다.");
                    else result /= num; 
                    break;
                case "%" : 
                    if(num == 0) System.out.println("0으로는 나눌 수 없습니다.");
                    else result %= num;
                    break;
            } // switch
        if(num == 0) break;
        } // while
    } //main 
} // class