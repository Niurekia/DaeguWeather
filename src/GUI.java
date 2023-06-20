import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GUI extends JFrame implements ActionListener {

    JButton Jung;
    JButton Dong;
    JButton Seo;
    JButton Nam;
    JButton Buk;
    JButton Dalseo;
    JButton Dalseong;
    JButton Suseong;







    //연결정보 저장용 변수
//    String id="root";
//    String pw="1234";
//    String url="jdbc:mysql://localhost:3306/임시";

    //jdbc 참조변수
//    Connection conn=null; //DB연결용 참조변수
//    PreparedStatement pstmt=null; //SQL쿼리 전송용 참조변수
//    ResultSet rs=null; //SQL 쿼리 결과(SELECT결과) 수신용 참조변수

    GUI(){
        super("대구 날씨");
        setBounds(100,100,400,600);

        //Panel
        JPanel panel=new JPanel();
        panel.setLayout(null);

        //Icon
        JLabel sunIconLabel=new JLabel();
        ImageIcon sunIcon=new ImageIcon("C:\\임베디드웹과정임시공유폴더\\DaeguWeather\\src\\sun.png");

        Image sunIconImage = sunIcon.getImage();
        Image rescaleImage=sunIconImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon rescaleIcon =new ImageIcon(rescaleImage);


        sunIconLabel.setIcon(rescaleIcon);
        sunIconLabel.setBounds(20,20,200,200);
        panel.add(sunIconLabel);

        add(sunIconLabel);
        add(panel);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
