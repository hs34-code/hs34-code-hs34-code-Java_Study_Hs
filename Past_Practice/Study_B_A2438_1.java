package Past_Practice;
// 별찍기

public class Study_B_A2438_1 {
    public static void main(String[] args) {
        int numA = 5;

        // 마름모 왼쪽 위
        for(int i = numA; i > 0; i--){
            for(int j = 0; j <= numA; j++){
                if(j<i)System.out.print("  ");
                else System.out.print("★ ");
            }
            System.out.println();
        }
        System.out.println();

        // // 마름모 오른쪽 위
        for(int i = 0; i <= numA; i++){
            for(int j = 0; j<i; j++){
                System.out.print("★ ");
            }
            System.out.println();
        }
        System.out.println();

        // 마름모 왼쪽 아래
        for(int i = 0; i <= numA; i++){
            for(int j = 0; j < numA; j++){
                if(j<i)System.out.print("  ");
                else System.out.print("★ ");
            }
            System.out.println();
        }
        System.out.println();

        // 마름모 오른쪽 아래
        for(int i = numA; i > 0; i--){
            for(int j = 0; j<i; j++){
                System.out.print("★ ");
            }
            System.out.println();
        }

    } //main
} //class
