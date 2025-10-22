package Project_Practice_Collection.Bank_Ver3;

public class BankNewAccount {
    private String name, idNumberFront, idNumberBack, account, passward, money;
    private String fullIdNumber, information;

    public BankNewAccount(String name, String idNumberFront, String idNumberBack, String account, String passward, String money){
        this.name = name;
        this.idNumberFront = idNumberFront;
        this.idNumberBack = idNumberBack;
        this.account = account;
        this.passward = passward;
        this.money = money;
    }
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
    
    public void setAccount(String account) {
        this.account = account;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    
    public void MakeAccount(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append((int)(Math.random()*10));
            if(i==4) sb.append("-");
        }
        account = sb.toString();
        setAccount(account);
        setMoney("0");
        information = 
        "이름 : " +getName()
        +" / 주민등록번호 : " +getIdNumberFront() +"-" +getIdNumberBack()
        +" / 계좌번호 : " +getAccount() 
        +" / 비밀번호 : " +getPassward() 
        +" / 잔액 : " +getMoney() +" 원";
        BankUtility.save(information);
        System.out.println("계좌가 생성되었습니다");
        System.out.println("예금주 : " +getName());
        System.out.println("계좌번호 : " +getAccount());
    }
    





} // class
