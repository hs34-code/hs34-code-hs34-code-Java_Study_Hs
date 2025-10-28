GUI 만들기

JFrame 은 크게 2개 
    - 객체 생성     JFrame jr = new JFrame()
    - 상속          class ~ extends JFrame{}

JFrame은 건물전체 JPanel은 건물안의 방
전체창            창을 구획하는 컨테이너

레이아웃 
    - FlowLayout
        컴퍼넌트가 들어오면 순서대로 왼쪽에서 오른쪽 배치 
        배치가 불가능 해질경우 아래줄로 내려오며 크기 가변시 컴퍼넌트들도 움직인다

    - BorderLayout
        컨테이너의 공간을 동서남북 중앙영역으로 나누고 지정한 영역에 컨퍼넌트 배치 
        통상 홈페이지카테고리, 맨아래 정보 들은 보더 레이아웃을 씀

    - GridLayout
        엑셀 처럼 2차원 그리드로 나눈뒤 순서대로 배치 좌에서 우, 위에서 아래로 

    - CardLayout
        컴퍼넌트 겹치고 제일 위에만 보이기
        ex) 카드게임
    
    -AbsoluteLayout
        좌표를 직접 찍어 컴퍼넌트 배치
        크기 가변해도 컴퍼넌트 배치가 변경되지 않는다
        
        setLayout(null); 
        사이즈를 늘려도 버튼들 위치가 변하지 않음 

        setSize         width, height
        setLocation      x, y
        setBounds        x, y, width, height


- JLabel
     GUI상에서 직접 수정이 불가능한 텍스트 및 이미지 설정
    - JLabel() 기본 생성자 
    - JLabel(String) 텍스트 추가
    - JLabel(Icon) 아이콘 객체 , ImageIcon이미지 등

    - setText(String)
    - getText()
    -setIcon(Icon)
    -setHorizontalAlignment(int)

- JButteon
    컴퓨터와 나 사이의 상호작용을 위한 버튼 추가
        - setText()
        - getText()
        - addActionListener() 버튼 눌렀을때 실행될 내용 (event 추가 필요)

- JTextArea
    여러 줄의 문자열을 표현하기 위해 사용되는 컴포넌트 
    일반적인 설명문에 사용
        - setText()
        - append() 텍스트 뒤에 더 붙이기
        - setBackGroundColor

- JTextField ,JPasswardField 
    한줄의 문자열을 입력 받기 위해 주요 사용 
    로그인 화면 id, pw 입력
        - getText()
        - setText()

- JCheckBox
    여러 옵션 1개 이상 선택하기 위해 사용
    다중 선택 지원 하여 그룹 묶지 않고 사용
- JRadioButton
    여러 옵션중 한가지 선택 
    여러 영역에서 사용될 가능성으로 그룹으로 묶어서 사용(BuutonGroup)


이벤트 처리 
    - 이벤트 리스너 Event Listener
        이벤트 발생시 이벤트의 정보가 담긴 객체 생성
        객체에 대응 하여 작성된 이벤트 처리 객체
        인터페이스 구현 클래스와 이벤트 객체를 연결
    - 이벤트 핸들러 Event Handler
        이벤트 리스너에 전달된 이벤트를 실제로 처리하는 메서드