package Project_Practice_Collection.Bank_Ver2;

public class BankAccount {
    private String owner;
    private String idNumberFront;
    private String idNumberBack;
    private String passward;
    private String account;

    public BankAccount(String owner, String idNumberFront, String idNumberBack, String passward) {
        this.owner = owner;
        this.idNumberFront = idNumberFront;
        this. idNumberBack = idNumberBack;
        this.passward = passward;
        this.MakeAccount();
    }

    public void MakeAccount(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append((int)(Math.random()*10));
            if(i==4) sb.append("-");
        }
        account = sb.toString(); //이후 중복 확인후 재설정 추가 필요

        BankUtility.clearConsole();
        System.out.println("계좌가 생성되었습니다");
        System.out.println("예금주 : " +owner);
        System.out.println("계좌번호 : " +account);
        String information = 
            "이름 : " +owner +" / 주민등록번호 : " +idNumberFront +"-" +idNumberBack +" / 비밀번호 : " +passward 
            +" / 계좌번호 : " +account +" / 잔액 : 0 원";
        BankUtility.save(information);
    }

}
