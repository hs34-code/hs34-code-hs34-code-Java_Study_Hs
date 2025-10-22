package Project_Practice_Collection.Bank_Ver3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BankSearchAccount {
    private String name, idNumberFront, idNumberBack, account, passward, money;
    private String fullIdNumber, information;

    public BankSearchAccount(String account){
        boolean found = false;
        try{
        BufferedReader fr = new BufferedReader(new FileReader(BankManager.getPath()+BankManager.getFileName()));
        while ((information = fr.readLine()) != null) {
            if(information.contains(account)){
                found = true;
                break;
            }
        }
        fr.close();
        } catch (FileNotFoundException e){
            System.out.println("[ 계좌찾기 중 FileNotFoundException 오류 발생 ] : " +e.getMessage());
        } catch (IOException e){
            System.out.println("[ 계좌찾기 중 IOException 오류 발생 ] : " +e.getMessage());
        }
        if(!found){
            throw new IllegalArgumentException("존재하지 않는 계좌번호입니다.");
        } else{
            String[] tokens = information.split("/");
            this.name = tokens[0].replace("이름 :", "").trim();
            String [] fullIdNumber = tokens[1].split("-");
            this.idNumberFront = fullIdNumber[0].replace("주민등록번호 :", "").trim();
            this.idNumberBack = fullIdNumber[1].trim();
            this.account = tokens[2].replace("계좌번호 :", "").trim();
            this. passward = tokens[3].replace("비밀번호 :", "").trim();
            this.money = tokens[4].replace("잔액 :", "").replace("원", "").trim();
            BankUtility.clearConsole();
        }
    }
    // search 생성자에 강제 예외 있으므로 IllegalArgumentException 꼭 잡아주기

    public String getName() {
        return name;
    }
    public String getIdNumberFront() {
        return idNumberFront;
    }
    public String getIdNumberBack() {
        return idNumberBack;
    }
    public String getAccount() {
        return account;
    }
    public String getPassward() {
        return passward;
    }
    public String getMoney() {
        return money;
    }
    public void setPassward(String passward) {
        this.passward = passward;
    }
    public void setMoney(String money) {
        this.money = money;
    }

    public void Deposit(){
        
    }

    public void Withdrawal(){

    }

} // class
