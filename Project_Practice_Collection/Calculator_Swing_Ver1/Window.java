package Project_Practice_Collection.Calculator_Swing_Ver1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;


public class Window {
    JFrame frame = new JFrame("계산기 연습"); // 창 생성
    
    JPanel top = new JPanel();  // 위 방 생성 
    JPanel bottom = new JPanel(); // 아래 방 생성

    // Top Panel
    JTextArea textHistoryDisplay, textInputNumbers; // 위 방에 이런 가구를 들여놓을 예정

    // Bottom Panel
    JButton[] buttonNum = new JButton[10]; // 아래 방에 이런 가구를 들여놓을 예정
    
    JButton buttonBlank1, buttonBlank2, buttonRemainder, buttonDelete;
    JButton buttonParenthesesStrat, buttonParenthesesEnd, buttonClear, buttonDivide;
    JButton buttonMultiplication, buttonSubtraction,buttonAddition, buttonSignChange, buttonDecimal, buttonResult;
 
    public Window(){
        frame.setBounds(800, 200, 350 , 570); // 크기 설정
        
        frame.setLayout(new GridLayout(2, 1));  // 화면 top, bottom으로 가르기
        
        settingComponentNumButton();            // bottom 숫자 버튼 생성 및 수 입력     / Component 생성과 동시에 속성 설정
        settingComponentpOperatorButton();      // bottom 기호 버튼 생성 및 기호 입력   / Component 생성과 동시에 속성 설정
        settingTopomponents();      //top JTextAera 생성 및 폰트, 크기 설정             / Component 생성과 동시에 속성 설정
        
        settingPanel(); // 각 top, bottom 가구들을 각 방에 맞게 추가

        frame.add(top);         // top frame 추가           // 집에 위 방 추가
        frame.add(bottom);      // bottom frame 추가        // 집에 아래 방 추가

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //닫기 기능 추가
        frame.setVisible(true); // 창 표시              // 집 공개

        /*
        Component 생성                      │   JFrame  frame 은 집
        속성 설정 (이벤트및 문구)            │   JPanel  panel 은 방
        패널 추가                           │   JButton Button 및 TextArea 들은 가구
        프레임 설정                         
        화면 표시 순서      setVisible
        */
    }

    private void settingComponentNumButton(){ // 아래 방 가구 생성
        for(int i=0; i<10; i++){
            buttonNum[i] = new JButton(""+i);
        }
    }

    private void settingComponentpOperatorButton(){  // 아래 방 가구 생성
        buttonBlank1 = new JButton("");
        buttonBlank2 = new JButton("");
        buttonRemainder = new JButton("나머지");
        buttonDelete = new JButton("< DEL");

        buttonParenthesesStrat = new JButton("(");
        buttonParenthesesEnd = new JButton(")");
        buttonClear = new JButton("C");
        buttonDivide = new JButton("÷");

        buttonMultiplication = new JButton("x");
        buttonSubtraction = new JButton("-");
        buttonAddition = new JButton("+");
        buttonSignChange = new JButton("+/- ");
        buttonDecimal = new JButton(".");
        buttonResult = new JButton("=");
    }

    private void settingTopomponents(){ // 위 방 가구 생성 
        textHistoryDisplay = new JTextArea();
        textHistoryDisplay.setFont(new Font("돋움", Font.PLAIN, 20));
        textHistoryDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        textInputNumbers = new JTextArea("0");
        textInputNumbers.setFont(new Font("돋움", Font.BOLD, 35)); // 글자 크기 및 폰트 지정
        textInputNumbers.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // 오른쪽 - 왼쪽 입력
        textInputNumbers.setEditable(false); // 입력불가
    }

    private void settingPanel(){ // 각각 방 가구 배치
        //top
        top.setLayout(new GridLayout(2,1));
        top.add(textHistoryDisplay);
        top.add(textInputNumbers);

        // botto
        bottom.setLayout(new GridLayout(6,4));
        bottom.add(buttonBlank1);
        bottom.add(buttonBlank2);
        bottom.add(buttonRemainder);
        bottom.add(buttonDelete);

        bottom.add(buttonParenthesesStrat);
        bottom.add(buttonParenthesesEnd);
        bottom.add(buttonClear);
        bottom.add(buttonDivide);

        bottom.add(buttonNum[7]);
        bottom.add(buttonNum[8]);
        bottom.add(buttonNum[9]);
        bottom.add(buttonMultiplication);

        bottom.add(buttonNum[4]);
        bottom.add(buttonNum[5]);
        bottom.add(buttonNum[6]);
        bottom.add(buttonSubtraction);

        bottom.add(buttonNum[1]);
        bottom.add(buttonNum[2]);
        bottom.add(buttonNum[3]);
        bottom.add(buttonAddition);

        bottom.add(buttonSignChange);
        bottom.add(buttonNum[0]);
        bottom.add(buttonDecimal);
        bottom.add(buttonResult);
    }

    private void settingNumButtonEvent(){
        for(int i=0; i<10; i++){
            int num = i;
            buttonNum[i].addActionListener( e -> {
                String currentText = textInputNumbers.getText();
                if (currentText.equals("0")){
                    
                }
            });
        }
    }
}
