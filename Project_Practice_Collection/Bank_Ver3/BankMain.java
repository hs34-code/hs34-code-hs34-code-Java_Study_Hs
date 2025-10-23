package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.NameCallback;

public class BankMain {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mainInterface = "";
        BankUtility.clearConsole();
        while (true) {
        // 메인 인터페이스 출력문구
        mainInterface = BankInputProsecutor.validate(
            "\n" + "1 ~ 4 중 입력해주세요" +"\n" +
            "= = = = 메뉴 = = = =" +"\n" +
            "1. 신규 계좌 생성" +"\n" +
            "2. 계좌 및 비밀번호 찾기" +"\n" +
            "3. 잔액 조회" +"\n" +
            "4. 입금/출금/송금", "^[1-4]$");
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

            case "2" : // 계좌 및 비밀번호 찾기
                String case2Interface = BankInputProsecutor.validate((
                "1 ~ 2 중 입력해주세요" +"\n" +
                "= = = = 메뉴 = = = =" +"\n" +
                "1. 계좌 번호 찾기" +"\n" +
                "2. 비밀번호 찾기"), "^[1-2]$");
                BankUtility.clearConsole();
                    switch (case2Interface) {
                        case "1" : // 계좌번호 찾기
                            try{
                                BufferedReader fr = new BufferedReader(new FileReader(BankManager.getPath()+BankManager.getFileName()));
                                boolean found = false;
                                name = BankInputProsecutor.validate("한글로 이름을 입력해주세요", "^[가-힣]+$");
                                BankUtility.clearConsole();
                                idNumberFront = BankInputProsecutor.validate("주민등록번호 앞 6자리를 입력해주세요", "^\\d{6}$");
                                BankUtility.clearConsole();
                                idNumberBack = BankInputProsecutor.validate("주민등록번호 뒤 7자리를 입력해주세요", "^\\d{7}$");
                                fullIdNumber = idNumberFront +"-" +idNumberBack;
                                BankUtility.clearConsole();
                                while ((information = fr.readLine()) != null) {
                                    if(information.contains(name) && information.contains(fullIdNumber)){
                                        String[] tokens = information.split("/");
                                        System.out.println("계좌번호는 "+tokens[2].replace("계좌번호 :", "").trim() +" 입니다");
                                        found = true;
                                        break;
                                    }
                                }
                                if(found == false){
                                    BankUtility.clearConsole();
                                    System.out.println("해당하는 정보가 없습니다");
                                }
                                fr.close();
                                break;
                            }catch(FileNotFoundException e){
                                System.out.println("[ 계좌번호 찾기 중 FileNotFoundException 오류 발생 ] : " +e.getMessage());
                            } catch(IOException e){
                                System.out.println("[ 계좌번호 찾기 중 IOException 오류 발생 ] : " +e.getMessage());
                            }
                        case "2" : // 비밀번호찾기 
                                try{
                                BufferedReader fr = new BufferedReader(new FileReader(BankManager.getPath()+BankManager.getFileName()));
                                boolean found = false;
                                name = BankInputProsecutor.validate("한글로 이름을 입력해주세요", "^[가-힣]+$");
                                BankUtility.clearConsole();
                                idNumberFront = BankInputProsecutor.validate("주민등록번호 앞 6자리를 입력해주세요", "^\\d{6}$");
                                BankUtility.clearConsole();
                                idNumberBack = BankInputProsecutor.validate("주민등록번호 뒤 7자리를 입력해주세요", "^\\d{7}$");
                                fullIdNumber = idNumberFront +"-" +idNumberBack;
                                BankUtility.clearConsole();
                                account = BankInputProsecutor.validate("계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
                                BankUtility.clearConsole();
                                while ((information = fr.readLine()) != null) {
                                    if(information.contains(name) && information.contains(fullIdNumber) && information.contains(account)){
                                        BankUtility.clearConsole();
                                        String[] tokens = information.split("/");
                                        System.out.println("계좌번호 "+tokens[2].replace("계좌번호 :", "").trim() +" 의 ");
                                        System.out.println("비밀번호는 "+tokens[3].replace("비밀번호 :", "").trim() +" 입니다");
                                        found = true;
                                        break;
                                    }
                                }
                                if(found == false){
                                BankUtility.clearConsole();
                                System.out.println("해당하는 정보가 없습니다");
                                }
                                fr.close();
                                break;
                            }catch(FileNotFoundException e){
                                System.out.println("[ 계좌 비밀번호 찾기 중 FileNotFoundException 오류 발생 ] : " +e.getMessage());
                            } catch(IOException e){
                                System.out.println("[ 계좌 비밀번호 찾기 중 IOException 오류 발생 ] : " +e.getMessage());
                            }
                    }
                    break;
            case "3" : // 잔액 조회
                account = BankInputProsecutor.validate(
                "계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$"); 
                try{
                    BankSearchAccount searchAccount = new BankSearchAccount(account);
                    if(searchAccount.getPassward().equals(BankInputProsecutor.matchPassward("본인 확인을 위해 비밀번호 4자리를 입력해주세요", searchAccount.getPassward()))){
                    BankUtility.clearConsole();
                    System.out.println(searchAccount.getAccount()+" 번의 잔액은 " +searchAccount.getMoney() +"원 입니다");
                    }
                }catch(IllegalArgumentException e){
                    BankUtility.clearConsole();
                    System.out.println("존재하지 않는 계좌번호입니다");
                }
                break;
            case "4" : //4. 입금/출금/송금
                String case4Interface = BankInputProsecutor.validate((
                "1 ~ 3 중 입력해주세요" +"\n" +
                "= = = = 메뉴 = = = =" +"\n" +
                "1. 입금" +"\n" +
                "2. 출금" +"\n" +
                "3. 송금"), "^[1-3]$");
                BankUtility.clearConsole();
                switch (case4Interface) {
                    case "1" : // 입금
                        account = BankInputProsecutor.validate(
                "계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
                        try{
                            BankSearchAccount searchAccount = new BankSearchAccount(account);
                            searchAccount.Deposit();
                        }catch(IllegalArgumentException e){
                            BankUtility.clearConsole();
                            System.out.println("존재하지 않는 계좌번호입니다");
                        }
                        break;
                    case "2" : // 출금
                        account = BankInputProsecutor.validate(
                "계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
                        try{
                            BankSearchAccount searchAccount = new BankSearchAccount(account);
                            searchAccount.Withdrawal();
                        }catch(IllegalArgumentException e){
                            BankUtility.clearConsole();
                            System.out.println("존재하지 않는 계좌번호입니다");
                        }
                        break;
                    case "3" : // 송금
                        String myAccount = BankInputProsecutor.validate(
                "계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
                        try{
                            BankSearchAccount my = new BankSearchAccount(myAccount);
                            if(my.getPassward().equals(BankInputProsecutor.matchPassward(
                                "본인 확인을 위해 비밀번호 4자리를 입력해주세요", my.getPassward()))){
                            
                                BankUtility.clearConsole();
                                String youAccount = BankInputProsecutor.validate(
                    "입금 받을 계좌번호 10자리를 입력해주세요 \n예시) 12345-12345","^\\d{5}-\\d{5}$");
                                BankSearchAccount you = new BankSearchAccount(youAccount);
                                int inputMoney;
                                boolean check = false;
                                while (true) {
                                    inputMoney = Integer.parseInt(BankInputProsecutor.validate(
                                        "송금할 금액을 입력해주세요"
                                        +"\n보유 잔액 : " +my.getMoney() +" 원", "^[1-9][0-9]+$"));
                                    if(Integer.parseInt(my.getMoney()) > inputMoney ){
                                        check = true;
                                        break;
                                    }else {
                                        BankUtility.clearConsole();
                                        System.out.println("잔액이 부족합니다");
                                        System.out.println("보유 잔액 : " +my.getMoney() +" 원");
                                        System.out.println("다시한번 입력해주세요" +"\n");
                                    }
                                }
                                BankUtility.clearConsole();
                                if(check && my.getPassward().equals(BankInputProsecutor.matchPassward(
                                    "송금 전 본인 확인을 위해 비밀번호 4자리를 입력해주세요"
                                    + "\n송금 예정 금액 : "+inputMoney
                                    + "\n송금 후 잔액 : " +(Integer.parseInt(my.getMoney())-inputMoney), my.getPassward()))){
                                BankUtility.clearConsole();
                                System.out.println(inputMoney +" 원이 송금되었습니다");
                                my.setMoney(Integer.toString(Integer.parseInt(my.getMoney()) - inputMoney));
                                you.setMoney(Integer.toString(Integer.parseInt(you.getMoney()) + inputMoney));
                                BankUtility.changeAndSave(my.getName(), my.getIdNumberFront(), my.getIdNumberBack(), my.getAccount(), my.getPassward(), my.getMoney());
                                BankUtility.changeAndSave(you.getName(), you.getIdNumberFront(), you.getIdNumberBack(), you.getAccount(), you.getPassward(), you.getMoney());
                                System.out.println(my.getAccount() +" 번의 잔액은 " +my.getMoney() +" 원 입니다");
                                }
                                } //if end 
                        }catch(IllegalArgumentException e){
                            BankUtility.clearConsole();
                            System.out.println("존재하지 않는 계좌번호입니다");
                        }
                    break;
            }// case 4 switch end
            break;
        } // mainInterface switch end     
        }
    } // main
} // class BankMain