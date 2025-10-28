package Project_Practice_Collection.Bank_Ver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.undo.StateEdit;

public class TextProsecutor {

    public static boolean ProsecutorKr(String input){
        boolean result  = input.matches("^[가-힣]+$");
            return result;
    } // 한글 검사 method 끝 

    public static boolean ProsecutorNu(String input){
        boolean result  = input.matches(".*[0-9]+.*");
            return result;
    } // 숫자 검사 method 끝 

    
    public static boolean ProsecutorPassWard(String passward){
            boolean result = (
                passward.matches(".*[0-9]+.*") && passward.length() == 4);
                return result;
    }
       
} // class




    // 
    // public void PrintName(String owner){
    //     try{
    //     while (true) {
    //         System.out.println("이름을 한글로 적어주세요");
    //         owner = br.readLine();
    //         boolean result = TextProsecutor.ProsecutorKr(owner);
    //         if(result == false) {
    //             ClearConsole.clear();
    //             System.out.println("잘못된 입력입니다. 1");
    //         } else break;
    //     }
    //     } catch (IOException e){
    //         e.printStackTrace();
    //     }
    // }
    // public void PrintName(String owner){
    //     try{
    //     while (true) {
    //         System.out.println("이름을 한글로 적어주세요");
    //         owner = br.readLine();
    //         boolean result = TextProsecutor.ProsecutorKr(owner);
    //         if(result == false) {
    //             ClearConsole.clear();
    //             System.out.println("잘못된 입력입니다. 1");
    //         } else break;
    //     }
    //     } catch (IOException e){
    //         e.printStackTrace();
    //     }
    // }

