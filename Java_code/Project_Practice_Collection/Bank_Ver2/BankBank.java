package Project_Practice_Collection.Bank_Ver2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BankBank {

    private String owner;
    private String idNumberFront;
    private String idNumberBack;
    private String passward;
    private String account;
    private String money;
    
    //메모장에서 정보 가져온뒤 처리 생성자
    // * 처리 이전
    public BankBank(String information){
        String[] tokens = information.split("/");

        this.owner = tokens[0].replace("이름 :", "").trim();
        String [] fullIdNumber = tokens[1].split("-");
        this.idNumberFront = fullIdNumber[0].replace("주민등록번호 :", "").trim();
        this.idNumberBack = fullIdNumber[1].trim();
        this. passward = tokens[2].replace("비밀번호 :", "").trim();
        this.account = tokens[3].replace("계좌번호 :", "").trim();   
        this.money = tokens[4].replace("잔액 :", "").replace("원", "").trim();
    }
    public String getOwner() {
        return owner;
    }
    public String getIdNumberFront() {
        return idNumberFront;
    }
    public String getIdNumberBack() {
        return idNumberBack;
    }
    public String getPassward() {
        return passward;
    }
    public String getAccount() {
        return account;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = Integer.toString(money);
    }

    //searchAccount 계좌번호로 찾기
    public static String searchAccount(String account){ 
    try{
        BufferedReader br = new BufferedReader(new FileReader(BankManager.getPath()+BankManager.getFileName()));
        String information; // 읽고 가져온 정보 변수
        boolean found = false;
        while ((information = br.readLine()) != null) {
            if(information.contains(account)){
                BankBank ba = new BankBank(information);
                found = true;
                return information;
            }
        }
        if(found == false){
            br.close();
            return "";
        }
        return "";

    }catch (FileNotFoundException e){
        System.out.println("[ 예외 코드 BB S1] : " +e.getMessage());
        return "";
    }catch(IOException e){
        System.out.println("[ 예외 코드 BB S2] : " +e.getMessage());
        return "";
    }
    } 

    // searchToAccount - 이름, 주민등록번호
    public static void searchToAccount(String owner, String fullIdNumber){ 
    try{
        BufferedReader br = new BufferedReader(new FileReader(BankManager.getPath()));
        String information; // 읽고 가져온 정보 변수
        boolean found = false;
        while ((information = br.readLine()) != null) {
            if(information.contains(owner)&&information.contains(fullIdNumber)){
                BankBank ba = new BankBank(information);
                System.out.println(ba.getOwner() +"님의 계좌번호는  "+ba.getAccount() +"  입니다");
                found = true;
                break;
            }
        }
        if(found == false){
            System.out.println("해당하는 정보가 없습니다");
            br.close();
        }

    }catch (FileNotFoundException e){
        System.out.println("[ 예외 코드 BB S1] : " +e.getMessage());
    }catch(IOException e){
        System.out.println("[ 예외 코드 BB S2] : " +e.getMessage());
    }
    } 
    
    // searchTopassward - 이름, 주민등록번호, 계좌번호
    public static void searchToPassward(String owner, String fullIdNumber, String account){
    try{
        BufferedReader br = new BufferedReader(new FileReader(BankManager.getPath()));
        String information; // 읽고 가져온 정보 변수
        boolean found = false;
        while ((information = br.readLine()) != null) {
            if(information.contains(owner)&&information.contains(fullIdNumber)&&information.contains(account)){
                BankBank ba = new BankBank(information);
                System.out.println(ba.getOwner() +"님의 비밀번호는  "+ba.getPassward() +"  입니다");
                found = true;
                break;
            }
        }
        if(found == false){
            System.out.println("해당하는 정보가 없습니다");
            br.close();
        }

    }catch (FileNotFoundException e){
        System.out.println("[ 예외 코드 BB S1] : " +e.getMessage());
    }catch(IOException e){
        System.out.println("[ 예외 코드 BB S2] : " +e.getMessage());
    }
    } 


} // class
