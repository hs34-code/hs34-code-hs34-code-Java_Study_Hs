package Past_Practice;
// 수 맞추기 게임 
// up / down 기회 3번  3라운드 진행
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study_Simple_UpDown_Game1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int result = 0;
    int num = 0;

    for (int i = 1; i < 4; i++){
        result = (int)(Math.random()*10)+1;
        System.out.println(i +"라운드");

        for (int j = 0; j <3; j++){
            System.out.print("수 : ");
            num = Integer.parseInt(br.readLine());

            if (result == num) {
                System.out.println("정답입니다");
                System.out.println(i +"라운드를 승리하였습니다");
                break;
            } else if (result > num){
                System.out.println(+num +" 보다 큽니다");
            } else {
                System.out.println(+num +" 보다 작습니다");
            }
            if(j == 3){
                System.out.println(i +"라운드를 패배하였습니다");
            }

        } // for
    } // for
    } // main
} // class
