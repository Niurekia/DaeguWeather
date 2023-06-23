import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {


    GUI(){
        super("대구 날씨");
        setBounds(100,100,400,600);

        //Panel
        JPanel panel=new JPanel();
        panel.setLayout(null);

        //Icon
        JLabel sunIconLabel=new JLabel();
        //if(val==1)
        ImageIcon sunIcon=new ImageIcon("sun.png"); //아이콘 경로

        Image sunIconImage = sunIcon.getImage();
        Image rescaleImage=sunIconImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);  //아이콘 크기 재설정
        ImageIcon rescaleIcon =new ImageIcon(rescaleImage);


        sunIconLabel.setIcon(rescaleIcon);
        sunIconLabel.setBounds(20,20,200,200);  //창에서 아이콘 위치
        panel.add(sunIconLabel);

        //

        add(sunIconLabel);
        add(panel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
