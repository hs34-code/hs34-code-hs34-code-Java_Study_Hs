package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankMain {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mainInterface = "";
        
        // 메인 인터페이스 출력문구

        mainInterface = BankInputProsecutor.validate((
            "1 ~ 4 중 입력해주세요" +"\n" +
            "= = = = 메뉴 = = = =" +"\n" +
            "1. 신규 계좌 생성" +"\n" +
            "2. 계좌 및 비밀번호 찾기" +"\n" +
            "3. 잔액 조회" +"\n" +
            "4. 입금/출금/송금"), "^[1-4]$");

        BankUtility.clearConsole();
        String name, idNumberFront = "", idNumberBack = "", account = "", passward = "", money = "";
        String fullIdNumber = "", information = "";
        switch (mainInterface) {
            case "1" : // 1. 신규 계좌 생성
                name = BankInputProsecutor.validate("한글로 이름을 입력해주세요", "^[가-힣]+$");
                BankUtility.clearConsole();
                idNumberFront = BankInputProsecutor.validate(
                    "주민등록번호 앞 6자리를 입력해주세요", "^\\d{6}$");
                BankUtility.clearConsole();
                idNumberBack = BankInputProsecutor.validate(
                    "주민등록번호 뒤 7자리를 입력해주세요", "^\\d{7}$");
                BankUtility.clearConsole();
                passward = BankInputProsecutor.validate("설정할 비밀번호 4자리를 입력해주세요", "^\\d{4}$");
                BankUtility.clearConsole();
                BankInputProsecutor.matchPassward("확인을 위해 다시한번 비밀번호 4자리를 입력해주세요", passward);
                BankUtility.clearConsole();
                BankNewAccount newAccount = new BankNewAccount(name, idNumberFront, idNumberBack, account, passward, money);
                newAccount.MakeAccount();
                break;
            
            case "4" : //4. 입금/출금/송금
            account = BankInputProsecutor.validate(
                "계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
            BankSearchAccount searchAccount = new BankSearchAccount(account);


        } // mainInterface switch end
    } // main
} // class BankMain