package Project_Practice_CalculatorSwing_Ver1;

import javax.swing.JFrame; // 스윙 관련 클래스 
import javax.swing.JLabel; // 레이아웃 등 그래픽 관련 
import javax.swing.SwingConstants; 

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("연습용 창 1"); // 창 생성
        frame.setSize(400, 300); // 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 작동 설정

        JLabel label = new JLabel("Hello Swing!", SwingConstants.CENTER); // 텍스트
        frame.add(label); // 창에 라벨 추가

        frame.setVisible(true); // 창 표시

    }
}