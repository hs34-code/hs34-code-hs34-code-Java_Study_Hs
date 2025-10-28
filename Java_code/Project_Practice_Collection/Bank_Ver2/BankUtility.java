package Project_Practice_Collection.Bank_Ver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class BankUtility {

    //콘솔창 비우기
    public static void clearConsole(){ 
        for(int i=0; i<10; i++){
            System.out.println();
        }
    }

    // 한글 검사
    public static boolean testKr(String input){ 
        boolean result  = input.matches("^[가-힣]+$");
            return result;
    } 

    // 숫자 검사
    public static boolean testNumber(String input){ 
        boolean result  = input.matches("^[0-9]+$");
            return result;
    } 

    // 이름 한글 입력 검증 / 반환 이름
    public static String testName(){ 
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String owner;
        while(true){ 
            System.out.println("한글로 이름을 입력해주세요");
            owner = br.readLine();
            if (BankUtility.testKr(owner)==true) {
                return owner;
            }
            else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
            }
        }
        }catch (IOException e){
            System.out.println("[ 예외 코드 BU idnumberback ] : " +e.getMessage());
            return "";
        }
    }

    // 주민등록번호 앞 6자리 입력 검증 / 반환 주민등록번호 앞 6자리
    public static String testIdNumberFront(){ 
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String idNumberFront;
        while(true){ 
            System.out.println("주민등록번호 앞 6자리를 입력해주세요");
            idNumberFront = br.readLine();
            if(idNumberFront.length()==6 && BankUtility.testNumber(idNumberFront)==true){
                return idNumberFront;
            } else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
            }
        }
        }catch (IOException e){
            System.out.println("[ 예외 코드 BU idnumberfront ] : " +e.getMessage());
            return "";
        }
    }

    // 주민등록번호 뒤 7자리 입력 검증 / 반환 주민등록번호 뒤 7자리
    public static String testIdNumberBack(){ 
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String idNumberBack;
        while(true){ // 주민등록번호 뒤
            System.out.println("주민등록번호 뒤 7자리를 입력해주세요");
            idNumberBack = br.readLine();
            if(idNumberBack.length()==7 && BankUtility.testNumber(idNumberBack)==true){
                return idNumberBack;
            } else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
            }
        }
        }catch (IOException e){
            System.out.println("[ 예외 코드 BU idnumberback ] : " +e.getMessage());
            return "";
        }
    }

    // 계좌번호 검증 / 반환 계좌번호
    public static String testAccount(){ 
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Account;
        while(true){
            System.out.println("계좌번호를 입력해주세요");
            System.out.println("ex) 12345-123445");
            Account = br.readLine();
            if(Account.matches("^\\d{5}-\\d{5}$")){
                return Account;
            } else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
            }
        }
        }catch (IOException e){
            System.out.println("[ 예외 코드 BU Account ] : " +e.getMessage());
            return "";
        }
    }

    // 비밀번호 4자리 검증 / 입력 문구 수정 / 비밀번호 4자리 반환
    public static String testPassward(String text){ 
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String passward;
        while(true){
            System.out.println(text +"비밀번호 숫자 4자리를 입력해주세요");
            passward = br.readLine();
            if(passward.length()==4 && BankUtility.testNumber(passward)==true){
                return passward;
            } else {
                BankUtility.clearConsole();
                System.out.println("잘못 입력하였습니다");
            }
    
        }
        }catch (IOException e){
            System.out.println("[ 예외 코드 BU passward ] : " +e.getMessage());
            return "";
        }
    }

    

    // 저장
    public static void save(String input){ 
    try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(BankManager.getPath()+BankManager.getFileName(),true ));
        bw.write(input);
        bw.newLine();
        bw.close();
    }catch (IOException e){
        System.out.println("[ 예외 코드 BU save] : " +e.getMessage());
    }
    }

    // 수정하여 저장
    public static void modifySave(String newAccount, String newAccountLine) {
    File original = new File(BankManager.getPath(), BankManager.getFileName());
    File temp = new File(BankManager.getPath(), "temporary.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(original));
         BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(newAccount)) {
                bw.write(newAccountLine);
            } else {
                bw.write(line);
            }
            bw.newLine();
        }

    } catch (IOException e) {
        System.out.println("파일 읽기/쓰기 오류: " + e.getMessage());
        return;
    }

    try {
        // 🔹 renameTo 대신 move 사용
        Files.move(temp.toPath(), original.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("✅ 파일 교체 완료 (move)");
    } catch (IOException e) {
        System.out.println("❌ 파일 교체 중 오류: " + e.getMessage());
    }
}
    
} // class
