package Past_Practice;
// 시간 계산기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study_B_A2884 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String time_str = null;
        int hour = 0, minute = 0;
        
        String operator = null;

        String add_time_str = null;
        int add_hour = 0, add_minute = 0;
        
        int st_total=0;
        int add_total = 0;
        int result =0;
        int rs_hour = 0, rs_minute = 0;
        String st_result = null;

        while (true) {  // 시작 시간 입력
            System.out.print("24시간제 시간 입력 : (TT:MM) ");
            time_str = br.readLine();

        if(time_str.length() == 5 && time_str.charAt(2) ==':'){             // 양식이 맞는지 확인 TT:MM
                StringTokenizer st = new StringTokenizer(time_str, ":");

                try{                                                // 입력이 문자인지 숫자인지 확인(try catch)
                hour = Integer.parseInt(st.nextToken());
                minute = Integer.parseInt(st.nextToken());

                if(hour >= 0 && hour <24 && minute >= 0 && minute < 60) {                       // 시간과 분이 맞는지 확인
                    break;
                } else System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");    // 시간과 분이 맞는지 확인

                } catch (NumberFormatException e){                              // 입력이 문자인지 숫자인지 확인(try catch)
                    System.out.println("시간을 숫자로 입력해주시기 바랍니다.");
                }
            } else System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");   // 양식이 맞는지 확인 TT:MM

        } // while 시간 입력
        
        while (true) {   // 연산자 입력
            System.out.print("계산할 연산자 : (+ 혹은 -)");
            operator = br.readLine();

            if(operator.equals("+") || operator.equals("-")){
                break;
            } else System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다");

        }

        while (true) {  // 계산 시간 입력
            System.out.print("계산할 24시간제 시간 입력 : (TT:MM) ");
            add_time_str = br.readLine();

        if(add_time_str.length() == 5 && add_time_str.charAt(2) ==':'){             // 양식이 맞는지 확인 TT:MM
                StringTokenizer st = new StringTokenizer(add_time_str, ":");

                try{                                                // 입력이 문자인지 숫자인지 확인(try catch)
                add_hour = Integer.parseInt(st.nextToken());
                add_minute = Integer.parseInt(st.nextToken());

                if(add_hour >= 0 && add_hour <24 && add_minute >= 0 && add_minute < 60) {                       // 시간과 분이 맞는지 확인
                    break;
                } else System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");    // 시간과 분이 맞는지 확인

                } catch (NumberFormatException e){                              // 입력이 문자인지 숫자인지 확인(try catch)
                    System.out.println("시간을 숫자로 입력해주시기 바랍니다.");
                }
            } else System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");   // 양식이 맞는지 확인 TT:MM

        } // while 시간 입력
        
        st_total = hour*60 + minute;
        add_total = add_hour*60 + add_minute;
        if (operator.equals("+")){
            result = st_total + add_total;
        } else{
            result = st_total - add_total;
        }

        result = ((result % 1440) + 1440) % 1440;

        rs_hour = result / 60;
        rs_minute = result % 60;

        st_result = (rs_hour < 10 ? "0" + rs_hour : rs_hour) + ":" 
                  + (rs_minute < 10 ? "0" + rs_minute : rs_minute);
        System.out.println("결과: " + st_result);
        
    } // main
} // class