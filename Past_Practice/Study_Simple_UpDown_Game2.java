package Past_Practice;
// 수 맞추기 게임 
// up / down 기회 3번  3라운드 진행
// 배팅 추가
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study_Simple_UpDown_Game2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int result = 0;
    int num = 0;
    int h_money = 500, c_money = 500;
    int betting = 0;

    for (int i = 1; i < 4; i++){
        result = (int)(Math.random()*10)+1;
        
        while(true){
            System.out.println(i +"번째 게임");
            System.out.println("자신 : " +h_money +"\t" +"상대 : "+c_money);
            System.out.print("배팅 금액 : ");
            try{
                betting = Integer.parseInt(br.readLine());
                if (betting <= 0 ){
                    System.out.println( "0혹은 음수는 배팅이 안됩니다 \n" );
                    continue;
                } else if (h_money < betting ){
                    System.out.println("보유 중인 금액이 부족합니다 \n");
                    continue;
                } else if ( c_money < betting ){
                    System.out.println("상대 보유 금액이 부족합니다 \n");
                    continue;
                } else {
                    System.out.println(betting +" 배팅 되었습니다 \n");
                    break;
                }
            } catch(NumberFormatException e){
                System.out.println("정수로 입력해주시기 바랍니다 \n");
            }
        }

        for (int j = 1; j <4; j++){
            System.out.println(i +"번째 게임 " +j +"라운드");
            System.out.print("수 : ");
            try{
            num = Integer.parseInt(br.readLine());
            } catch(NumberFormatException e){
                System.out.println("정수로 입력해주시기 바랍니다 ( 1 ~ 10 )\n");
            }
            if (result == num) {
                System.out.println("정답입니다");
                System.out.println(i +"번째 게임을 승리하였습니다 \n");
                h_money += betting;
                c_money -= betting;
                break;
            } else if (result > num){
                System.out.println(+num +" 보다 큽니다 \n");
            } else {
                System.out.println(+num +" 보다 작습니다 \n");
            }
            if(j == 3){
                System.out.println(i +"번째 게임을 패배하였습니다 \n");
                c_money += betting;
                h_money -= betting;
            }
            if(c_money == 0){
                System.out.println("게임에서 총 승리하였습니다");
                break;
            } else if (h_money == 0){
                System.out.println("게임에서 총 패배하였습니다");
                break;
            }

        } // for
    } // for
    } // main
} // class
