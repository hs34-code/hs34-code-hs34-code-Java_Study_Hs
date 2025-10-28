package Project_Practice_Collection.Bank_Ver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankSystem {
    public static void main(String[] args) {

    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test;
        do{// 은행 창 계속 띄우기 무한반복
            String mainInterface;
            BankUtility.clearConsole();
            while (true) { // switch 메인 화면 반복문
                System.out.println("1 ~ 4 중 입력해주세요" +"\n");
                System.out.println("= = = = 메뉴 = = = =");
                System.out.println("1. 신규 계좌 생성");
                System.out.println("2. 계좌 및 비밀번호 찾기");
                System.out.println("3. 잔액 조회");
                System.out.println("4. 입금/출금/송금");

                mainInterface = br.readLine();
                if(mainInterface.matches("^[1-4]$")){
                    break;
                } else {
                    BankUtility.clearConsole();
                }
            }
            String owner;
            String idNumberFront;
            String idNumberBack;
            String passward;
            String account;
            String fullIdNumber;
            String information;
            switch(mainInterface){
                case "1" : // 신규 계좌 생성
                    BankUtility.clearConsole();
                    owner = BankUtility.testName(); // 이름 입력 
                    BankUtility.clearConsole();
                    idNumberFront = BankUtility.testIdNumberFront(); // 주민등록번호 앞
                    BankUtility.clearConsole();
                    idNumberBack = BankUtility.testIdNumberBack(); // 주민등록번호 뒤
                    BankUtility.clearConsole();
                    passward = BankUtility.testPassward("설정할");
                    BankUtility.clearConsole();
                    while(true){
                        if (passward.equals(BankUtility.testPassward("확인을 위해 다시한번 "))){
                            break;
                        } else {
                            BankUtility.clearConsole();
                            System.out.println("입력하신 비밀번호가 다릅니다");
                        }
                    }
                    BankAccount ac = new BankAccount(owner, idNumberFront, idNumberBack, passward);
                    break;

                case "2" : // 계좌 및 비밀번호 찾기
                    String searchInterface;
                    BankUtility.clearConsole();
                    while(true){ // switch 계좌 비밀번호 찾기 화면 반복문
                        System.out.println("1 ~ 2 중 입력해주세요" +"\n");
                        System.out.println("= = = = 메뉴 = = = =");
                        System.out.println("1. 계좌번호 찾기");
                        System.out.println("2. 비밀번호 찾기");
                        searchInterface = br.readLine();
                        if(searchInterface.matches("^[1-2]$")){
                            break;
                        } else {
                            BankUtility.clearConsole();
                        }
                    }
                        switch (searchInterface) {
                            case "1" : //계좌번호 찾기 = 이름 + 주민등록번호
                                BankUtility.clearConsole();
                                owner = BankUtility.testName();
                                BankUtility.clearConsole();
                                idNumberFront = BankUtility.testIdNumberFront();
                                BankUtility.clearConsole();
                                idNumberBack = BankUtility.testIdNumberBack();
                                BankUtility.clearConsole();
                                fullIdNumber = idNumberFront +"-" +idNumberBack;
                                BankBank.searchToAccount(owner, fullIdNumber);
                                break;

                            case "2" : //비밀번호 찾기 = 이름 + 주민등록번호 + 계좌번호
                                BankUtility.clearConsole();
                                owner = BankUtility.testName();
                                BankUtility.clearConsole();
                                idNumberFront = BankUtility.testIdNumberFront();
                                BankUtility.clearConsole();
                                idNumberBack = BankUtility.testIdNumberBack();
                                BankUtility.clearConsole();
                                account= BankUtility.testAccount();
                                BankUtility.clearConsole();
                                fullIdNumber = idNumberFront +"-" +idNumberBack;
                                BankBank.searchToPassward(owner, fullIdNumber, account);
                                break;
                        } // searchInterface
                    break;
                case "3" : // 잔액 조회
                    BankUtility.clearConsole();
                    information = BankBank.searchAccount(BankUtility.testAccount());
                    if(information!=null && !information.equals("")){
                        BankBank ba = new BankBank(information);
                        BankUtility.clearConsole();
                        for(int i=1; i<4; i++){
                            if(ba.getPassward().equals(BankUtility.testPassward("본인 확인을 위해 "))){
                                BankUtility.clearConsole();
                                System.out.println(ba.getAccount()+" 번의 잔액은 " +ba.getMoney() +" 원입니다");
                                break;
                            } else {
                                BankUtility.clearConsole();
                                System.out.println("입력하신 비밀번호가 다릅니다");
                                System.out.println(i+"번 틀리셨습니다");
                                System.out.println("3번 틀릴경우 초기 화면으로 돌아갑니다");
                            }
                        }
                    }else{
                        BankUtility.clearConsole();
                        System.out.println("계좌 정보가 없습니다");
                    }
                    break;
                case "4" :
                    String moneyInterface;
                    BankUtility.clearConsole();
                    while(true){ // switch 계좌 비밀번호 찾기 화면 반복문
                        System.out.println("1 ~ 2 중 입력해주세요" +"\n");
                        System.out.println("= = = = 메뉴 = = = =");
                        System.out.println("1. 입금");
                        System.out.println("2. 출금");
                        System.out.println("3. 송금");
                        moneyInterface = br.readLine();
                        if(moneyInterface.matches("^[1-3]$")){
                            break;
                        } else {
                            BankUtility.clearConsole();
                        }
                    }
                    switch (moneyInterface) {
                        case "1" : // 입금 
                        
                        case "2" : // 출금
                            BankUtility.clearConsole();
                            information = BankBank.searchAccount(BankUtility.testAccount());
                            if(information!=null && !information.equals("")){
                                BankBank ba = new BankBank(information);
                                BankUtility.clearConsole();
                                int withdrawal;
                                while(true){
                                    System.out.println("보유금액 : " +ba.getMoney());
                                    System.out.println("출금할 금액을 입력해주세요");
                                    withdrawal = Integer.parseInt(br.readLine());
                                    
                                    if(BankUtility.testNumber(Integer.toString(withdrawal)) 
                                        && Integer.parseInt(ba.getMoney()) 
                                        >= withdrawal && 0 < withdrawal){
                                        ba.setMoney(Integer.parseInt(ba.getMoney())-withdrawal);
                                        break;
                                   } else if ( withdrawal == 0){
                                    BankUtility.clearConsole();
                                    System.out.println("0원 이상 입력해주세요");
                                   } else {
                                    BankUtility.clearConsole();
                                    System.out.println("보유 금액보다 낮은 금액을 입력해주세요");
                                   }
                                }
                                BankUtility.clearConsole();
                                boolean save=false;
                                    for(int i=1; i<4; i++){
                                        if(ba.getPassward().equals(BankUtility.testPassward("본인 확인을 위해 "))){
                                            BankUtility.clearConsole();
                                            System.out.println(withdrawal +"원이 출금 되었습니다");
                                            System.out.println("잔액은 " +ba.getMoney() +" 원입니다");
                                            save=true;
                                            break;
                                        } else {
                                            BankUtility.clearConsole();
                                            System.out.println("입력하신 비밀번호가 다릅니다");
                                            System.out.println(i+"번 틀리셨습니다");
                                            System.out.println("3번 틀릴경우 초기 화면으로 돌아갑니다");
                                        }
                                    }
                                    if(save){
                                    BankUtility.modifySave(ba.getAccount(), 
                                            ("이름 : " +ba.getOwner() 
                                            +" / 주민등록번호 : " +ba.getIdNumberFront() +"-" +ba.getIdNumberBack() 
                                            +" / 비밀번호 : " +ba.getPassward() 
                                            +" / 계좌번호 : " +ba.getAccount() 
                                            +" / 잔액 : " +ba.getMoney() +" 원"));
                                    }
                                
                            }else{
                            BankUtility.clearConsole();
                            System.out.println("계좌 정보가 없습니다");
                            }
                            break;
                            
                        case "3" : // 송금
                    }
            } // switch 끝


            System.out.println("\n"+"다시 할려면 1을 눌러주세요");
            test = br.readLine();
        } while(test.equals("1"));// 은행 창 계속 띄우기 무한반복 끝
    }catch (IOException e){
        System.out.println("[ 예외 코드 main ] : " +e.getMessage());
    }

        
    } // main
} // class
