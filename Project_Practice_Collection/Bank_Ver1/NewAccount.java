package Project_Practice_Collection.Bank_Ver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewAccount {
    private String owner;
    private int money;
    private String idNumberFront;
    private String idNumberBack;
    private String passward;
    private String account_number;

    public NewAccount(){ //이름에 따라 계좌 생성
    try{
        // 계좌 생성 - 민증번호 이름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("이름을 한글로 적어주세요");
            owner = br.readLine();
            boolean result = TextProsecutor.ProsecutorKr(owner);
            if(result == false) {
                ClearConsole.clear();
                System.out.println("잘못된 입력입니다. 1");
            } else break;
        }
        ClearConsole.clear();
        while (true) {
            System.out.println("주민번호 앞 6자리를 입력해주세요");
            idNumberFront = br.readLine();
            boolean result = TextProsecutor.ProsecutorNu(idNumberFront);
            if(result == false || idNumberFront.length() != 6) {
                ClearConsole.clear();
                System.out.println("잘못된 입력입니다. 2");
            } else break;
        }
        ClearConsole.clear();
        while (true) {
            System.out.println("주민번호 뒤 7자리를 입력해주세요");
            idNumberBack = br.readLine();
            boolean result = TextProsecutor.ProsecutorNu(idNumberBack);
            if(result == false || idNumberBack.length()!=7) {
                ClearConsole.clear();
                System.out.println("잘못된 입력입니다. 3");
            } else break;
        }
        ClearConsole.clear();

        while(true){ // 비밀번호 생성
            System.out.println("비밀번호 숫자 4자리를 입력해주세요");
            String passward = br.readLine();
            boolean result = TextProsecutor.ProsecutorPassWard(passward);
            if (result == true) {
            this.passward = passward;
            break;
            }
        }
        while(true){ // 비밀번호 재확인
            System.out.println("확인을 위해 다시 비밀번호 숫자 4자리를 입력해주세요");
            String passward = br.readLine();
            boolean result = TextProsecutor.ProsecutorPassWard(passward);
            System.out.println("[확인용 문구] : " +result);
            System.out.println("[확인용 문구] : " +this.passward);
            System.out.println("[확인용 문구] : " +passward);
            if (result == true) {
                if(this.passward.equals(passward)) {
                    System.out.println("확인 되었습니다");
                    break;
                } else{
                    System.out.println("비밀번호가 틀립니다");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        do{    
        for(int i=0; i<10; i++){    //계좌 10자리 생성
            sb.append((int)(Math.random()*10));
            if(i==4) sb.append(("-"));
        }
        account_number = sb.toString();
        }while (account_number);
        
        
        System.out.println();
        System.out.println("계좌가 생성되었습니다");
        System.out.println("예금주 : " +this.owner);
        System.out.println("계좌번호 : " +sb.toString());
        System.out.println("잔액 : " +this.money +"원");
        saveToFile(sb.toString());  
        
    }catch (IOException e){
        System.out.println("NewAccount 오류 1: " + e.getMessage());
    }

    }

        private void saveToFile(String accountNumber) { // 계좌 저장
        try {
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(
                "C:\\AI\\javaEx\\Normal\\Bank\\accounts.txt", true)); // 이어쓰기
            writer.write("예금주 : " + owner + ", 계좌번호 : " + accountNumber + ", 잔액 : " + money);
            writer.newLine();
            writer.close();
            System.out.println("계좌 정보가 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}

