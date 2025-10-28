package Past_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Study_StringBufferStudy {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // System.out.print("테스트용 문장 : ");

        StringBuffer sb = new StringBuffer("학교에 다니다가 대학교로 가고 싶어요 !!!");


        // System.out.print("추가 할 내용 : ");
        // sb.append(br.readLine());
        // System.out.println(sb);

        System.out.print("내용 변경 하고 싶은 위치 : ");
        
        String str = br.readLine();      // 변경하고 싶은 문자 입력
        int start = sb.indexOf(str);     // 변경전 앞자리 번호 찾기
        int last = start + str.length(); // 변경전 뒷자리 번호 찾기

        if(start == -1){    // 해당 내용이 없다
            System.out.println("해당 내용이 없습니다");


        } else if (sb.indexOf(str) == sb.lastIndexOf(str)){ // 해당 내용이 하나
        System.out.print("변경 할 내용 : ");    
        String bstr = br.readLine();    // 변경 할 내용

        sb.replace(start, last, bstr);   // 변경 전 앞번호, 변경전 뒷번호, 변경 할 내용
        System.out.println(sb);


        } else { // 해당 내용이 중복
            System.out.println("해당 내용이 중복입니다");

            int ver = -1;
            int count = 0;
            for (int i =0; sb.indexOf(str,i) != ver; i++){
                count++;
                ver = sb.indexOf(str);
            }
            

            System.out.print("중복된 단어의 몇번째 ? : ");
            int num = Integer.parseInt(br.readLine());  //중복된 단어 번째 입력

            for(int i=0; i<num; i++){          
                start = sb.indexOf(str, i);
                last = start + str.length();
            }

            System.out.print("변경 할 내용 : ");    
            String bstr = br.readLine();    // 변경 할 내용
            sb.replace(start, last, bstr);
            System.out.println(sb);
        }
    }
}
