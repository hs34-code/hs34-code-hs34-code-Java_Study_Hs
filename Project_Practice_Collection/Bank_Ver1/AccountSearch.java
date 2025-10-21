package Project_Practice_Collection.Bank_Ver1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AccountSearch{
    private String account_number;
    private String line;

    public AccountSearch(String account_number){
        this.account_number = account_number;
    } // 생성자

    public void search(String account_number) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(
                "C:\\AI\\javaEx\\Normal\\Bank\\accounts.txt"));
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null){ 
                // br.readLine(지정된 경로 파일에서)으로 한줄 읽기, 빈공간이 나올때까지
                if (line.contains(account_number)) { //읽힌 한줄에서 맞는지 비교
                    System.out.println("찾음");     
                    System.out.println(line);
                    this.line = line;
                    found = true;
                    break;
                } //if 끝
            } // while 끝
            if(found == false){
                System.out.println("찾을 수 없음");
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    } // method

    public String getAccount_line() {
        return line;
    } // getter 

} // class
