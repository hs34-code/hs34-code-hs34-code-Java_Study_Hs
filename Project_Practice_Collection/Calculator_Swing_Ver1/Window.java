package Project_Practice_Collection.Calculator_Swing_Ver1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;


public class Window {
    JFrame frame = new JFrame("계산기 연습"); // 창 생성
    
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();

    // Top Panel
    JTextArea textHistoryDisplay = new JTextArea();
    JTextArea textInputNumbers = new JTextArea();

    // Bottom Panel
    JButton buttonNum0 = new JButton();
    JButton buttonNum1 = new JButton();
    JButton buttonNum2 = new JButton();
    JButton buttonNum3 = new JButton();
    JButton buttonNum4 = new JButton();
    JButton buttonNum5 = new JButton();
    JButton buttonNum6 = new JButton();
    JButton buttonNum7 = new JButton();
    JButton buttonNum8 = new JButton();
    JButton buttonNum9 = new JButton();
    JButton buttonBlank1 = new JButton();
    JButton buttonBlank2 = new JButton();
    JButton buttonRemainder = new JButton();
    JButton buttonDelete = new JButton();

    JButton buttonParenthesesStrat = new JButton();
    JButton buttonParenthesesEnd = new JButton();
    JButton buttonClear = new JButton();
    JButton buttonDivide = new JButton();

    JButton buttonMultiplication = new JButton();
    JButton buttonSubtraction = new JButton();
    JButton buttonAddition = new JButton();
    JButton buttonSignChange = new JButton();
    JButton buttonDecimal = new JButton();
    JButton buttonResult = new JButton();
 
    public Window(){
        frame.setBounds(800, 200, 350 , 570); // 크기 설정
        
        settingTopomponents();
        settingBottomComponents();
        settingPanel();


        frame.setLayout(new GridLayout(2, 1));
        frame.add(top);
        frame.add(bottom);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // 창 표시
    }

    private void settingPanel(){
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

        bottom.add(buttonNum7);
        bottom.add(buttonNum8);
        bottom.add(buttonNum9);
        bottom.add(buttonMultiplication);

        bottom.add(buttonNum4);
        bottom.add(buttonNum5);
        bottom.add(buttonNum6);
        bottom.add(buttonSubtraction);

        bottom.add(buttonNum1);
        bottom.add(buttonNum2);
        bottom.add(buttonNum3);
        bottom.add(buttonAddition);

        bottom.add(buttonSignChange);
        bottom.add(buttonNum0);
        bottom.add(buttonDecimal);
        bottom.add(buttonResult);
    }


    private void settingTopomponents(){
        textHistoryDisplay.setFont(new Font("돋움", Font.PLAIN, 20));
        textHistoryDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        textInputNumbers.setText("0"); // 초기 입력값
        textInputNumbers.setFont(new Font("돋움", Font.BOLD, 35)); // 글자 크기 및 폰트 지정
        textInputNumbers.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // 오른쪽 - 왼쪽 입력
        textInputNumbers.setEditable(false); // 입력불가
    }

    private void settingBottomComponents() {
        buttonBlank1.setText("");
        buttonBlank2.setText("");
        buttonRemainder.setText("나머지");
        buttonDelete.setText("< DEL");

        buttonParenthesesStrat.setText("(");
        buttonParenthesesEnd.setText(")");
        buttonClear.setText("C");
        buttonDivide.setText("÷");

        buttonMultiplication.setText("x");
        buttonSubtraction.setText("-");
        buttonAddition.setText("+");
        buttonSignChange.setText("+/- ");
        buttonDecimal.setText(".");
        buttonResult.setText("=");

        buttonNum0.setText("0");
        buttonNum1.setText("1");
        buttonNum2.setText("2");
        buttonNum3.setText("3");
        buttonNum4.setText("4");
        buttonNum5.setText("5");
        buttonNum6.setText("6");
        buttonNum7.setText("7");
        buttonNum8.setText("8");
        buttonNum9.setText("9");
    }




}
