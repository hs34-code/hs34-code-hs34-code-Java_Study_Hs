package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankInputProsecutor {

    // 한글 검사
    public static boolean testKr(String input){ 
        boolean result  = input.matches("^[가-힣]+$");
            return result;
    } 

    // 숫자 검사
    public static boolean testNumber(String input){ 
        boolean result  = input.matches("^[0-9]+$");
            return result;
    }

    // 입력 검증 될때까지 반복문
    // 안내 메세지, 검증 정규식 각각 String String 필요
    public static String validate(String promptMessage, String regex){
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(true){ 
            System.out.println(promptMessage);
            input = br.readLine();
            if (input.matches(regex)) {
                return input;
            }
            else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
                System.out.println("다시한번 입력해주세요" +"\n");
            }
        }
        }catch (IOException e){
            System.out.println("[ 입력 검증 중 오류 발생 ] : " +e.getMessage());
            return "";
        }
    }
 
    // 비밀번호 확인 기회 3번
    public static String matchPassward(String promptMessage, String storedPassward){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(promptMessage);
            String input;
            for( int i=1; i<4; i++){
                System.out.println();
                input = br.readLine();
                if(storedPassward.equals(input)){
                    return input;
                }else{
                    BankUtility.clearConsole();
                    System.out.println("입력하신 비밀번호가 다릅니다");
                    System.out.println(i+"번 틀리셨습니다");
                    System.out.println("3번 틀릴경우 초기 화면으로 돌아갑니다");
                }
            }
            return "";
        }catch (IOException e){
            System.out.println("[ 비밀번호 확인 중 오류 발생 ] : " +e.getMessage());
            return "";
        }
    }
  

}   // class