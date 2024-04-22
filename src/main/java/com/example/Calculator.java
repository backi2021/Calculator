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
    JButton [] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Areal", Font.BOLD, 30);
    double num1= 0, num2 = 0, result =0;


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
       delButton = new JButton("Delete");
       clrButton = new JButton("Clear");


       functionButtons [0] = addButton;
       functionButtons [1]= subButton;
       functionButtons [2]= mulButton;
       functionButtons [3] = divButton;
       functionButtons [4]= decButton;
       functionButtons [5]= eqButton;
       functionButtons [6]=  delButton;
       functionButtons [7] = clrButton;


       for ( int i =0 ; i < 8; i++){
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

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);


        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(divButton);
        panel.add(mulButton);
        






       frame.add(textField);
       frame.add(clrButton);
       frame.add(delButton);
       frame.add(panel);
       frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    public void actionPerformed(ActionEvent e){

    }
}