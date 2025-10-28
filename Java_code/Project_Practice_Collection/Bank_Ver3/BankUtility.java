package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BankUtility {

    //콘솔창 비우기
    public static void clearConsole(){ 
        for(int i=0; i<10; i++){
            System.out.println();
        }
    }

    // 저장
    public static void save(String name, String idNumberFront, String idNumberBack, String account, String passward, String money){ 
    try{
        BufferedWriter fw = new BufferedWriter(new FileWriter(BankManager.getPath()+BankManager.getFileName(),true));
        fw.write("이름 : " +name
        +" / 주민등록번호 : " +idNumberFront +"-" +idNumberBack
        +" / 계좌번호 : " +account
        +" / 비밀번호 : " +passward
        +" / 잔액 : " +money +" 원");
        fw.newLine();
        fw.close();
    }catch (IOException e){
        System.out.println("[ 파일 저장 중 오류 발생 ] : " +e.getMessage());
    }
    }

    //수정후 저장 
    public static void  changeAndSave(String name, String idNumberFront, String idNumberBack, String account, String passward, String money){
        String newLine = "이름 : " +name
        +" / 주민등록번호 : " +idNumberFront +"-" +idNumberBack
        +" / 계좌번호 : " +account
        +" / 비밀번호 : " +passward
        +" / 잔액 : " +money +" 원";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(BankManager.getPath()+BankManager.getFileName()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(BankManager.getPath()+"\\temporary.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains(account)){
                    writer.write(newLine);
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
            reader.close();
            writer.close();
            new File(BankManager.getPath()+BankManager.getFileName()).delete();
            new File(BankManager.getPath()+"\\temporary.txt").renameTo(
                new File(BankManager.getPath()+BankManager.getFileName()));
        }catch (IOException e){
            System.out.println("[ 파일 변경 중 오류 발생 ] : " +e.getMessage());
        }
        



    }









}
