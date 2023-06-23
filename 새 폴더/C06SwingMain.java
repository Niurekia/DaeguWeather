import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;

public class C06SwingMain {
    public static void main(String[] args) {
        new C06GUI();
    }
}

class C06GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
    JButton btn1;
    JButton btn2;
    JTextField txt1;
    JTextField txt2;
    JTextArea area1;
    JScrollPane scroll1;

    C06GUI(){
        //Frame
        super("여섯번째 프레임창입니다");
        setBounds(125,120,1600,900);

        //Panel
        JPanel panel = new JPanel();	//패널생성
        panel.setLayout(null);

        //btn Component
        btn1=new JButton("Button1");
        btn1.setBounds(10,10,100,30);
        panel.add(btn1);

        btn2=new JButton("Button2");
        btn2.setBounds(112,10,100,30);
        panel.add(btn2);

        //txt Component
        txt1=new JTextField();
        txt1.setBounds(10,41,100,30);
        panel.add(txt1);
        txt2=new JTextField();
        txt2.setBounds(112,41,100,30);
        panel.add(txt2);

        //TxtArea Component
        area1 = new JTextArea("텍스트 영역\n");
        area1.setEditable(true);
        area1.setBounds(10,90,204,300);
        area1.setFont(new Font("NanumGothic", Font.BOLD, 30));
        panel.add(area1);

        //ScrollPan Component
        scroll1=new JScrollPane(area1);
        scroll1.setBounds(10,90,204,300);
        panel.add(scroll1);

        //Event처리
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        txt1.addKeyListener(this);
        txt2.addKeyListener(this);
//        txt1.addActionListener(this);
        area1.addMouseListener(this);



        //
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Label영역");
        panel.add(label, BorderLayout.CENTER);
        label.setFont(new Font("NanumGothic", Font.BOLD, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);


        //배경색지정
        Color col=new Color(123,197,73,255); //RGB
        panel.setBackground(col);


        //Frame
        add(panel);	//프레임에 panel추가

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //ActionListener

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1) {
            System.out.println("과거행 버튼");
        }else if(e.getSource()==btn2){
            System.out.println("미래행 버튼");
        }

    }

    //KeyListener

    @Override
    public void keyTyped(KeyEvent e) {
        //키를 떼었을 때(Unicode 지원)
        if(e.getSource()==txt1){
            System.out.println("keyTyped: "+e.getKeyChar());
        }else if(e.getSource()==txt2){
            System.out.println("keyTyped: "+e.getKeyCode());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //키를 눌렀을 때
        if(e.getSource()==txt1){
            System.out.println("keyPressed: "+e.getKeyChar());
            if(e.getKeyCode()==10){
                System.out.println("txt1:엔터 입력");
                String str1=txt1.getText();
                area1.append(str1+"\n");
                txt1.setText("");
            }
        }else if(e.getSource()==txt2){
            System.out.println("keyPressed: "+e.getKeyCode());
            if(e.getKeyCode()==10){
                System.out.println("txt2:엔터 입력");
                String str2=txt2.getText();
                area1.append(str2+"\n");
                txt2.setText("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //키를 떼었을 때(Unicode 미지원)
        if(e.getSource()==txt1){
            System.out.println("keyReleased: "+e.getKeyChar());
        }else if(e.getSource()==txt2){
            System.out.println("keyReleased: "+e.getKeyCode());
        }
    }

    //MouserListener

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("클릭");
        System.out.println(e.getPoint().x+" "+e.getPoint().y);
        int offset=area1.viewToModel2D(e.getPoint());
        System.out.println("offset: "+offset);

        try {
            int row=area1.getLineOfOffset(offset);
            System.out.println("row: "+row);
            int startOffset=area1.getLineStartOffset(row);
            int endOffset=area1.getLineEndOffset(row);
            System.out.println("Start Offset: "+startOffset);
            System.out.println("End Offset: "+endOffset);
            String txt=area1.getText(startOffset,endOffset-startOffset);
            System.out.println("txt: "+txt);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("Exited");
    }
}