package Project_Practice_Collection.Bank_Ver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainConsole {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ClearConsole.clear();
        System.out.println("= = = = 메뉴 = = = =");
        System.out.println("1. 신규 계좌 생성");
        System.out.println("2. 계좌 및 비밀번호 찾기");
        System.out.println("3. 잔액 조회");
        System.out.println("4. 입금/출금/송금");

        switch(br.readLine()){
            case "1" :
                NewAccount na = new NewAccount();
            case "2" :
            case "3" :
            case "4" :
        }
        
        // 계좌 생성
        while (true){          
        String owner = br.readLine();
        int money = Integer.parseInt(br.readLine());
        NewAccount na = new NewAccount(owner, money);
        }

        //계좌 조회
        System.out.print("조회할 계좌번호 : ");
        String account_number = br.readLine();
        AccountSearch as = new AccountSearch(account_number);
        
        // 계좌 거래 
        String account_number = br.readLine();
        AccountTransaction at = new AccountTransaction(account_number);

    }
}
