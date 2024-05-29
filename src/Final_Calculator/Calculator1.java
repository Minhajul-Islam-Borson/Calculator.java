package Final_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//package calculator;

public class Calculator1 implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[14];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JButton foolButton,rootButton,powButton,logButton,sqrButton;
    JPanel panel;


    Font myFont=new Font("Times new Roman",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator1(){

        frame=new JFrame("Claculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,610);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        textField=new JTextField();
        textField.setBounds(20,25,300,50);
        textField.setFont(myFont);
        textField.setBackground(Color.YELLOW);
        textField.setEditable(false);

        addButton =new JButton("+");
        subButton =new JButton("-");
        mulButton =new JButton("*");
        divButton =new JButton("/");
        decButton =new JButton(".");
        equButton =new JButton("=");
        delButton = new JButton("Dl");
        clrButton =new JButton("Cl");
        negButton =new JButton("(-)");
        rootButton=new JButton("√");
        powButton=new JButton("^");
        logButton=new JButton("lg");
        sqrButton=new JButton("x²");
        foolButton=new JButton("*");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;
        functionButtons[9]=rootButton;
        functionButtons[10]=powButton;
        functionButtons[11]=logButton;
        functionButtons[12]=sqrButton;
        functionButtons[13]=foolButton;

        for(int i=0;i<14;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(Color.GREEN);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        /*
        rootButton.setBounds(30,430,90,50);
        negButton.setBounds(120,430,90,50);
        delButton.setBounds(210,430,90,50);
        clrButton.setBounds(300,430,90,50);
        powButton.setBounds(30,490,90,50);
        logButton.setBounds(120,490,90,50);*/

        panel = new JPanel();
        panel.setBounds(20,100,300,450);
        panel.setLayout(new GridLayout(6,4,5,5));
        panel.setBackground(Color.YELLOW);
        //1st line
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        //2nd line
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        //3rd line
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(foolButton);
        //4th line
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        //5th line
        panel.add(powButton);
        panel.add(rootButton);
        panel.add(delButton);
        panel.add(clrButton);
        //6th line
        panel.add(negButton);
        panel.add(logButton);
        panel.add(sqrButton);
        panel.add(mulButton);

        frame.add(panel);

        //frame.add(powButton);
        //frame.add(rootButton);
        //frame.add(negButton);
        //frame.add(delButton);
        //frame.add(clrButton);
        //frame.add(logButton);

        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator1 calc=new Calculator1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton){
            textField.setText((textField.getText().concat(".")));
        }

        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            //textField.setText((textField.getText().concat("+")));
            textField.setText("");
        }

        if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }

        if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if (e.getSource() == rootButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
            //return;
        }
        if(e.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator='^';
            textField.setText("");
        }
        if(e.getSource() == logButton){
            num1= Double.parseDouble(textField.getText());
            result=Math.log10(num1);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == sqrButton){
            num1=Double.parseDouble(textField.getText());
            result=num1*num1;
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == foolButton){
            textField.setText("");
            //num1=Double.parseDouble(textField.getText());
            //textField.setText("Boka chele 6th row 4th column dekh oita diye gun korte hobe");
            operator = '#';
        }

        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                case '^' :
                    result=Math.pow(num1,num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            //num1=result;
            switch(operator){
                case '#' :
                    textField.setText("Boka chele 6th row 4th column dekh oita diye gun korte hobe");
                    break;
            }
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt((i)));
            }
        }
        if(e.getSource()==negButton){
            double temp= Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
