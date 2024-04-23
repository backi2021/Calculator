package com.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton [] numberButtons = new JButton[10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton,
            divButton, decButton, eqButton,
            delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Areal", Font.BOLD, 25);
    double num1= 0, num2 = 0, result =0;
    char operator;
    boolean operationSelected = false;


    Calculator(){
       frame = new JFrame("Calculator");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(420,550);
       frame.setLayout(null);


       textField = new JTextField();
       textField.setBounds(50,25,300,50);
       textField.setFont(myFont);
       textField.setEditable(false);


       addButton = new JButton("+");
       subButton = new JButton("-");
       mulButton = new JButton("*");
       divButton = new JButton("/");
       decButton = new JButton(".");
       eqButton = new JButton("=");
       delButton = new JButton("Del");
       clrButton = new JButton("C");
       negButton = new JButton("(-)");


       functionButtons [0] = addButton;
       functionButtons [1]= subButton;
       functionButtons [2]= mulButton;
       functionButtons [3] = divButton;
       functionButtons [4]= decButton;
       functionButtons [5]= eqButton;
       functionButtons [6]=  delButton;
       functionButtons [7] = clrButton;
       functionButtons [8] = negButton;


       for ( int i =0 ; i < 9; i++){
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(myFont);
           functionButtons[i].setFocusable(false);
        }

        for ( int i =0 ; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);


        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.LIGHT_GRAY);


        // add the frame and panel

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(mulButton);
        panel.add(eqButton);

       frame.add(textField);
       frame.add(negButton);
       frame.add(clrButton);
       frame.add(delButton);
       frame.add(panel);
       frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }


    // The functionalities
    @Override
    public void actionPerformed(ActionEvent e){

        // collect the values
        for( int i =0 ; i < 10 ; i++){
            if(e.getSource() == numberButtons [i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            // convert string to double
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            // clear
            textField.setText("");
            operationSelected = true;
        }
        if(e.getSource() == subButton){
            // convert string to double
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            // clear
            textField.setText("");
            operationSelected = true;
        }
        if(e.getSource() == mulButton){
            // convert string to double
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            // clear
            textField.setText("");
            operationSelected = true;
        }
        if(e.getSource() == divButton){
            // convert string to double
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            // clear
            textField.setText("");
            operationSelected = true;
        }

        if(e.getSource() == eqButton){
            if(operationSelected){
                num2 = Double.parseDouble(textField.getText());

                switch (operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                // update the text field
                textField.setText(String.valueOf(result));
                num1 = result;
                operationSelected = false;
            } else {
                textField.setText(textField.getText()); // Just display the last number
            }
        }

        if(e.getSource() == clrButton){
            textField.setText("");
        }

        if (e.getSource()== delButton){
            String s = textField.getText();
            textField.setText("");
            for(int i= 0; i < s.length()-1 ; i++){
                textField.setText(textField.getText()+ s.charAt(i));
            }
        }
        if (e.getSource()== negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *=-1;
            textField.setText(String.valueOf(temp));
        }

    }
}