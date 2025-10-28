package Project_Practice_Collection.Calculator_Swing_Ver1;

import java.util.Stack;

public class Calculator {

    public static Double CalculatorFunction(String line){
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operator = new Stack<>();  // stack LIFO (Last In, First Out) 구조 
        

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);  // 하나씩 읽기

            if (Character.isDigit(c)) { // 숫자인지 확인 isDigit 숫자면 실행
                StringBuilder num = new StringBuilder();
                while (i < line.length() && (Character.isDigit(line.charAt(i)) || line.charAt(i) == '.')) {
                        // i번째 부터 확인, line의 글자 수만큼 반복 &&하고  확인한 글자가 숫자 || 거나  .이면 계속 
                    num.append(line.charAt(i)); // 정보를 저장
                    i++;
                }
                i--; // while문에서 숫자가 아닐때까지 i++ 했기 때문에 다음을 위해 하나 줄이기 
                numbers.push(Double.parseDouble(num.toString())); //num을 String화 하고 Double화 하고 Stack<numbers>에 저장

            } else if(c == '('){    // '(' 바로 연산자 stack에 입력
                operator.push(c);

            } else if(c == ')'){
                 while (!operator.isEmpty() && operator.peek() != '(') { //'(' 나올때까지 계속 반복
                    double b = numbers.pop();   //Stack<number> 에서 2개 꺼낸다
                    double a = numbers.pop();
                    char op = operator.pop();   //Stack<operator> 에서 1개 꺼낸다
                    numbers.push(applyCalculation(a, b, op));   // 아래에서 계산 
                }
                operator.pop(); // '(' 제거

            } else if (c == '+' || c == '-' || c == 'x' || c == '÷' || c =='%') { // 연산자일경우 
                if( c == 'x') c = '*';
                if( c == '÷') c = '/';
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(c)) {
                    // Stack<opertor>가 비어있지 않고 && stack 맨 위 연산자의 우선순위가 현재 연산자c 보다 높거나 같으면 실행
                    if (operator.peek() == '(') break; // 만날시 안 건드림
                    double b = numbers.pop(); //Stack<number> 에서 2개 꺼낸다
                    double a = numbers.pop(); 
                    char op = operator.pop(); //Stack<operator> 에서 1개 꺼낸다
                    numbers.push(applyCalculation(a, b, op)); // 아래에서 계산 
                }
                operator.push(c);
            }
        }
        while (!operator.isEmpty()) {   //Stack<operator>가 비어있지 않을때까지
            double b = numbers.pop();   // Stack<Numbers>에서 2개 꺼낸다
            double a = numbers.pop();   
            char op = operator.pop();   // Stack<operator>에서 1개 꺼낸다
            numbers.push(applyCalculation(a, b, op));   // 아래에서 계산
        }
        return numbers.pop();
    }

    private static int precedence(char op) { // 순서 우선도 method 
        if (op == '+' || op == '-') return 1; 
        if (op == '*' || op == '/' || op == '%') return 2; 
        if (op == '(' || op ==')') return 3;
        return 0; 
    }

    private static double applyCalculation(double a, double b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
            case '%' : return a % b;
        }
        return 0;
    }

} // class
