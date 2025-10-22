package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedWriter;
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
    public static void save(String line){ 
    try{
        BufferedWriter fw = new BufferedWriter(new FileWriter(BankManager.getPath()+BankManager.getFileName(),true));
        fw.write(line);
        fw.newLine();
        fw.close();
    }catch (IOException e){
        System.out.println("[ 파일 저장 중 오류 발생 ] : " +e.getMessage());
    }
    }









}
