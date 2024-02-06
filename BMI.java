import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;


public class BMI extends JFrame {
    
    private Container c;
    private JLabel imgLabel,hLabel,wLabel,gLabel;
    private ImageIcon img;
    private Font f;
    private JTextField tf1,tf2;
    private JButton b1,b2;
    private JRadioButton male,female;
    String height="",weight="",result="";
    
    
    BMI(){
        initComponents();
       
    }

    
    public void initComponents(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        img = new ImageIcon("G:\\Java\\java swing\\New folder\\abc.png");
        imgLabel = new JLabel(img);
        this.setIconImage(img.getImage()); 
        
        imgLabel.setBounds(130,30,img.getIconWidth(),img.getIconHeight());
        c.add(imgLabel);

        f = new Font("Arial",Font.ITALIC+Font.BOLD,14);

        hLabel = new JLabel();
        hLabel.setText("HEIGHT(m) ");
        hLabel.setBounds(80, 120, 90, 20);
        hLabel.setFont(f);
        hLabel.setOpaque(true);
        hLabel.setBackground(Color.GRAY);
        hLabel.setToolTipText("e.g 1.60");
        c.add(hLabel);


        wLabel = new JLabel();
        wLabel.setText("WEIGHT(kg) ");
        wLabel.setBounds(80, 170, 95, 20);
        wLabel.setFont(f);
        wLabel.setOpaque(true);
        wLabel.setBackground(Color.GRAY);
        wLabel.setToolTipText("e.g 65");
        c.add(wLabel);

        gLabel = new JLabel();
        gLabel.setText("GENDER :");
        gLabel.setBounds(30, 230, 75, 20);
        gLabel.setFont(f);
        gLabel.setOpaque(true);
        gLabel.setBackground(Color.GRAY);
        c.add(gLabel);

        tf1 = new JTextField();
        tf1.setBounds(185, 120, 50, 20);
        c.add(tf1);

        tf2 = new JTextField();
        tf2.setBounds(185, 170, 50, 20);
        c.add(tf2);

        b1 = new JButton("Submit");
        b1.setFont(f);
        b1.setBounds(40, 280, 100, 50);
        c.add(b1);
        
        b2 = new JButton("Reset");
        b2.setFont(f);
        b2.setBounds(200, 280, 100, 50);
        c.add(b2);

        male = new JRadioButton("Male");
        male.setFont(f);
        male.setOpaque(true);
        male.setBackground(Color.GRAY);
        male.setBounds(120, 230, 95, 20);
        c.add(male);

        
        female = new JRadioButton("Female");
        female.setFont(f);
        female.setOpaque(true);
        female.setBackground(Color.GRAY);
        female.setBounds(230, 230, 95, 20);
        c.add(female);


        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf1.setText("");
                tf2.setText("");
                if(male.isSelected()) male.setSelected(false);
                else female.setSelected(false);
            }
        });




        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               cal_bmi();
            }
        });

    }


    public void cal_bmi() {
        if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || !(male.isSelected() || female.isSelected()))
          {error();
          return;
          }
        double h,w,r;
        height = tf1.getText();
        weight = tf2.getText();
       
        h=Double.parseDouble(height);
        w=Double.parseDouble(weight);
        r=w/Math.pow(h, 2);
        DecimalFormat df = new DecimalFormat("###.##");
        result="";
        result+=String.valueOf(df.format(r));
        if (r >= 25)
         result+="\t Overweight \n You have a higher than normal body weight. \nTry to exercise more.";
        else if (r > 18.5)
         result+="\t Normal \n You have normal body weight.\n Good Job!.";
        else
          result+="\t Underweight \n You have a lower than normal body weight.\n You can eat a bit more.";
        JFrame f =new JFrame();  
          JOptionPane.showMessageDialog(f,result);      
      }
      public void error() {
        JFrame f =new JFrame();  
          JOptionPane.showMessageDialog(f,"Fill all the details","Alert",JOptionPane.WARNING_MESSAGE);  
      }
    
    

    public static void main(String[] args) {
        BMI frame = new BMI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,350,400);
        frame.setTitle("BMI CALCULATOR by 2003140");
    }

}
