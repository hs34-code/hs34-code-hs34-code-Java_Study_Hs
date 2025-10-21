package Project_Practice_Collection.Bank_Ver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountTransaction {
    private String account_number;
    private String currentline;

    public AccountTransaction (String account_number){ // 찾고 계산
    this.account_number = account_number;

    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AccountSearch as = new AccountSearch(account_number);

        String line = as.getAccount_line();
        String transaction;

        do{
            System.out.println("입금시 \"입금\"을 입력해주세요");
            System.out.println("출금시 \"출금\"을 입력해주세요");
            transaction = br.readLine();
        }while(!(transaction.equals("입금")||transaction.equals("출금")));
        System.out.println("DEBUG line: [" + line + "]");

        String[] parts = line.split(",");
        String name = parts[0];
        String account = parts[1];
        String money = parts[2];
        int after_money = Integer.parseInt(money.replace("잔액 : ","").trim());
        int amount;
        switch(transaction){
            case "입금" : 
                amount = Integer.parseInt(br.readLine());
                after_money += amount;
                this.currentline = (name +"," +account +", 잔액 : "+after_money);
                System.out.println(currentline);
                updateAccountFile(account_number, currentline);
                break;
            case "출금" :
                amount = Integer.parseInt(br.readLine());
                after_money -= amount;
                this.currentline = (name +"," +account +", 잔액 : "+after_money);
                System.out.println(currentline);
                updateAccountFile(account_number, currentline);
                break;
        }

    } catch(ArrayIndexOutOfBoundsException e){
        System.out.println("입 출금 오류발생" +e.getMessage());
    } catch(IOException e){
        System.out.println("오류발생" +e.getMessage());
    }

    } // 찾고 계산 끝

private void updateAccountFile(String account_number, String newLine) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(
            "C:\\AI\\javaEx\\Normal\\Bank\\accounts.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(
            "C:\\AI\\javaEx\\Normal\\Bank\\accounts_temp.txt"));

        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.contains(account_number)) {
                writer.write(newLine);
            } else {
                writer.write(currentLine);
            }
            writer.newLine();
        }

        reader.close();
        writer.close();

        new File(
            "C:\\AI\\javaEx\\Normal\\Bank\\accounts.txt").delete();
        new File("C:\\AI\\javaEx\\Normal\\Bank\\accounts_temp.txt").renameTo(
            new File("C:\\AI\\javaEx\\Normal\\Bank\\accounts.txt"));

    } catch (IOException e) {
        System.out.println("파일 최신화 중 오류 발생: " + e.getMessage());
    }
    }
}// class 


               