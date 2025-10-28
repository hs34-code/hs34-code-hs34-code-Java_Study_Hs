package Project_Practice_Collection.Calculator_Swing_Ver1;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;




public class Window {
    JFrame frame = new JFrame("계산기 연습"); // 창 생성
    
    JPanel top = new JPanel();  // 위 방 생성 
    JPanel bottom = new JPanel(); // 아래 방 생성

    // Top Panel
    JTextArea textHistoryDisplay, textInputNumbers; // 위 방에 이런 가구를 들여놓을 예정

    // Bottom Panel
    JButton[] buttonNum = new JButton[10]; // 아래 방에 이런 가구를 들여놓을 예정
    
    JButton blank, buttonRemainder, buttonDelete;
    JButton buttonParenthesesStrat, buttonParenthesesEnd, buttonClear, buttonDivide;
    JButton buttonMultiplication, buttonSubtraction,buttonAddition, buttonDecimal, buttonResult;
 
    public Window(){
        frame.setBounds(800, 200, 350 , 570); // 크기 설정
        
        frame.setLayout(new GridLayout(2, 1));  // 화면 top, bottom으로 가르기
        
        settingComponentNumButton();            // bottom 숫자 버튼 생성 및 수 입력     / Component 생성과 동시에 속성 설정
        settingComponentpOperatorButton();      // bottom 기호 버튼 생성 및 기호 입력   / Component 생성과 동시에 속성 설정
        settingTopomponents();      //top JTextAera 생성 및 폰트, 크기 설정             / Component 생성과 동시에 속성 설정
        
        settingNumButtonEvent();
        settingOperatorButtonEvent();
        
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

    JButton createBlankButton() { // 비어있는 버튼 생성
        blank = new JButton("");
        blank.setEnabled(false);
        buttonStyle(blank);
        return blank;
    }

    private void buttonStyle(JButton button){
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setBackground(new Color(230,230,230));
        button.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    }

    private void settingComponentNumButton(){ // 아래 방 숫자 가구 생성
        for(int i=0; i<10; i++){
            buttonNum[i] = new JButton(""+i);
            buttonStyle(buttonNum[i]);
        }
    }

    private void settingComponentpOperatorButton(){  // 아래 방 기호 가구 생성
        buttonRemainder = new JButton("나머지%");
        buttonDelete = new JButton("< DEL");

        buttonParenthesesStrat = new JButton("(");
        buttonParenthesesEnd = new JButton(")");
        buttonClear = new JButton("C");
        buttonDivide = new JButton("÷");

        buttonMultiplication = new JButton("x");
        buttonSubtraction = new JButton("-");
        buttonAddition = new JButton("+");
        buttonDecimal = new JButton(".");
        buttonResult = new JButton("=");

        buttonStyle(buttonRemainder);
        buttonStyle(buttonDelete);

        buttonStyle(buttonParenthesesStrat);
        buttonStyle(buttonParenthesesEnd);
        buttonStyle(buttonClear);
        buttonStyle(buttonDivide);

        buttonStyle(buttonMultiplication);
        buttonStyle(buttonSubtraction);
        buttonStyle(buttonAddition);
        buttonStyle(buttonDecimal);
        buttonStyle(buttonResult);

    }

    private void settingTopomponents(){ // 위 방 가구 생성 
        textHistoryDisplay = new JTextArea();
        textHistoryDisplay.setFont(new Font("돋움", Font.PLAIN, 20));
        textHistoryDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        textInputNumbers = new JTextArea("0");
        textInputNumbers.setFont(new Font("돋움", Font.BOLD, 35)); // 글자 크기 및 폰트 지정
        textInputNumbers.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textInputNumbers.setEditable(false); // 입력불가
    }

    private void settingPanel(){ // 각각 방 가구 배치
        //top
        top.setLayout(new GridLayout(2,1));
        top.add(textHistoryDisplay);
        top.add(textInputNumbers);

        // botto
        bottom.setLayout(new GridLayout(6,4));
        bottom.add(createBlankButton());
        bottom.add(createBlankButton());
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

        bottom.add(createBlankButton());
        bottom.add(buttonNum[0]);
        bottom.add(buttonDecimal);
        bottom.add(buttonResult);
    }

    // event 
    private void settingNumButtonEvent(){
        for(int i=0; i<10; i++){
            int num = i;
            buttonNum[i].addActionListener( e -> {  //람다 버튼 감지(Listener) -> Event 실행
                String currentInputText = textInputNumbers.getText();
                String currentHistoryText = textHistoryDisplay.getText();
                if (currentInputText.equals("0")) {  //맨 처음 초기값 0 일경우 0없애고 입력된 button 값 추가
                    textInputNumbers.setText("");
                    textInputNumbersUpdate(String.valueOf(num));
                    textHistoryDisplayUpdate(String.valueOf(num));
                } else if(currentHistoryText.contains("=")){
                    textHistoryDisplay.setText("");
                    textHistoryDisplay.setText(String.valueOf(num));
                    textInputNumbers.setText(String.valueOf(num));
                } else {
                    textInputNumbers.setText(currentInputText + num); // string+int 만날시 자동으로 string 변경 따라서 valueof 생략
                    textHistoryDisplayUpdate(String.valueOf(num));
                }
            });
        }
    }

    private void settingOperatorButtonEvent(){
        buttonRemainder.addActionListener(
            e -> {
                isOperator("%");
                textInputNumbers.setText("");
            }
        );

        buttonDivide.addActionListener(
            e -> {
                isOperator("÷");
                textInputNumbers.setText("");
            }
        );

        buttonMultiplication.addActionListener(
            e -> {
                isOperator("x");
                textInputNumbers.setText("");
            }
        );

        buttonSubtraction.addActionListener(
            e -> {
                isOperator("-");
                textInputNumbers.setText("");
            }
        );
        
        buttonAddition.addActionListener(
            e -> {
                isOperator("+");
                textInputNumbers.setText("");
            }
        );
        buttonDelete.addActionListener(
            e -> {
                String input = textInputNumbers.getText();
                String history = textHistoryDisplay.getText();
                if(!textInputNumbers.equals(0) && !input.isEmpty() && !history.isEmpty()){
                    textInputNumbers.setText(input.substring(0, input.length()-1));
                    textHistoryDisplay.setText(history.substring(0, history.length()-1));                       
                } 
            }
        );

        buttonParenthesesStrat.addActionListener(
            e -> {
                textHistoryDisplayUpdate("(");
            }
        );
        buttonParenthesesEnd.addActionListener(
            e ->{
                String history = textHistoryDisplay.getText();
                int openCount = 0;
                for(char c : history.toCharArray()){
                    if (c == '(') openCount++;
                }
                int closeCount = 0;
                for(char c : history.toCharArray()){
                    if (c == ')') closeCount++;
                }
                if (openCount > closeCount){
                    isOperator(")");
                }
            }
        );
        

        buttonDecimal.addActionListener(
            e -> {
                String history = textHistoryDisplay.getText();
                String input = textInputNumbers.getText();
                if(history.isEmpty() && input.equals("0")){
                    textHistoryDisplayUpdate("0.");
                    textInputNumbersUpdate(".");
                } else if(history.charAt(history.length()-1) != '.' && input.charAt(input.length()-1) != '.') {
                    textHistoryDisplayUpdate(".");
                    textInputNumbersUpdate(".");
                } else if(history.equals("0.") && input.equals("0.")){
                    textHistoryDisplay.setText("");
                    textInputNumbers.setText("0");
                } else {
                    textHistoryDisplay.setText(history.substring(0, history.length()-1));
                    textInputNumbers.setText(input.substring(0, input.length()-1));
                }
            }
        );

        buttonResult.addActionListener(
            e -> {
                String history = textHistoryDisplay.getText();
                int openCount = 0;
                for(char c : history.toCharArray()){
                    if (c == '(') openCount++;
                }
                int closeCount = 0;
                for(char c : history.toCharArray()){
                    if (c == ')') closeCount++;
                }
                if(openCount != closeCount){
                    int miss = openCount -closeCount;
                    for (int i=0; i<miss; i++){
                        textHistoryDisplayUpdate(")");
                    }
                }
                isOperator("=");
                history = textHistoryDisplay.getText();
                double result = Calculator.CalculatorFunction(history);
                if(result % 1 == 0){
                    textInputNumbers.setText(String.format( "%d", (long)result));
                } else {
                    BigDecimal bd = new BigDecimal(result);
                    int scale = Math.max(0, bd.stripTrailingZeros().scale());
                               // 음수여도 최소값을 0  // 뒤에 불필요한 0 제거, 그후 소수점 자리수 반환
                    if(scale <= 6 ){
                        textInputNumbers.setText(bd.stripTrailingZeros().toPlainString());
                                                // 뒤에 불필요한 0 제거, 지수표기 없이 출력 1e-4
                    }
                    else{
                        BigDecimal rounded = bd.setScale(6, RoundingMode.HALF_UP);
                                            // 소수점 6자리까지 맞추기 , 반올림
                        textInputNumbers.setText(rounded.toPlainString() + "...");
                                            // 그후 ... 붙이기
                    }
                }
            }
        );

        buttonClear.addActionListener(
            e -> {
                textHistoryDisplay.setText("");
                textInputNumbers.setText("0");
            }
        );
    }

    // event 기능
    private void isOperator(String operator){
        String history = textHistoryDisplay.getText();
        String input = textInputNumbers.getText();
        if(!history.isEmpty()){
            char c = history.charAt(history.length()-1);
            if(c == '+' || c == '-' || c=='%' || c == '=' || c == 'x' || c == '÷' ){
                textHistoryDisplay.setText(history.substring(0, history.length()-1));
                textHistoryDisplayUpdate(operator);
            } else if (c == '('){
                textHistoryDisplayUpdate( "0" +operator);
            } else {
                textHistoryDisplayUpdate(operator);
            }
        } else if(input .equals("0")){
            textHistoryDisplayUpdate( "0" +operator);
        }
    }

    private void textHistoryDisplayUpdate(String input){
        String current = textHistoryDisplay.getText();
        textHistoryDisplay.setText(current +input);
    }

    private void textInputNumbersUpdate(String input){
        String current = textInputNumbers.getText();
        textInputNumbers.setText(current +input);
    }
}
