// Code by nathaliarmolina
// https://github.com/nathaliarmolina

package main;

// libraries

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSimpleCalculator implements ActionListener {
	
	// elements
	
	JButton [] numberButtons = new JButton[10];
	JButton [] functionButtons = new JButton[9];
	JButton addButton, subButton, multButton, divButton;
	JButton equalsButton, decimalButton, clearButton, deleteButton, negativeButton;
	JComboBox<String> comboBoxColors;
	JPanel headerPanel, bodyPanel, buttonsPanel;
	JFrame frame;
	JLabel title;
	JTextField visorTxtField;
	
	double number1, number2, result;
	char operator;
	
	// constructor
	public JavaSimpleCalculator() {
		
		
	// combobox of themes
	String[] colors = {"Change Theme", "Joy", "Love", "Aqua", "Nature", "Vampire", "Dark", "Light"};
        comboBoxColors = new JComboBox<String>(colors);
        
         
        // font types
        Font fontType = new Font("Candara",Font.BOLD,20);
        Font fontTitle = new Font("Candara",Font.BOLD,26);
        Font font2 = new Font("Candara",Font.BOLD,17);
        
        
        // frame settings
        frame = new JFrame("Java Simple Calculator"); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close window
	frame.setSize(400, 570); // size
	frame.setLayout(null); // type of Layout
	frame.setLocationRelativeTo(null); // centralize program
	frame.setResizable(false); // disable window resize
		
	// header panel settings
	headerPanel = new JPanel();
	headerPanel.setBounds(0,0, 400, 120); // coordinates and size
	headerPanel.setBackground(Color.white); // color background
	headerPanel.setLayout(null); // type of Layout
	frame.add(headerPanel); // adding headerPanel to frame
		
	// body panel settings
	bodyPanel = new JPanel();
	bodyPanel.setBounds(0,110, 400, 450); // coordinates and size
	bodyPanel.setBackground(Color.white); // color background
	bodyPanel.setLayout(null); // type of Layout
	frame.add(bodyPanel); // adding bodyPanel to frame
		
	// buttons panel settings
	buttonsPanel = new JPanel();
	buttonsPanel.setBounds(70,25, 250, 295); // coordinates and size
	buttonsPanel.setBackground(Color.white); // color background
	buttonsPanel.setLayout(null); // type of Layout
	bodyPanel.add(buttonsPanel); // adding buttonsPanel to bodyPanel
		
		
	// visor textField
        visorTxtField = new JTextField();
        visorTxtField.setFont(fontType);
        visorTxtField.setEditable(false);
        visorTxtField.setBounds(70, 50, 250, 50); // coordinates and size
        headerPanel.add(visorTxtField); // adding txtField to headerPanel
        
        // title
        title = new JLabel("Java Simple Calculator");
        title.setBounds(70, 5, 270, 50); // coordinates of title
        title.setFont(fontTitle);
        headerPanel.add(title); // adding title to headerPanel
		

		
	// creating and setting numberButtons
	for(int i =0; i<10; i++) {

		numberButtons[i] = new JButton(String.valueOf(i)); // create button and capture the number in the button and set its text
		numberButtons[i].setFont(fontType); // set font type
		numberButtons[i].setFocusable(false); // no focusable
		numberButtons[i].setBackground(Color.pink); // buttons color
		numberButtons[i].addActionListener(this); //action listener to the clicking event
		buttonsPanel.add(numberButtons[i]); // add buttons to buttonsPanel

	} // end for
		
		//functionButtons
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("*");
		divButton = new JButton("/");
		decimalButton = new JButton(".");
		equalsButton = new JButton("=");
		deleteButton = new JButton("Del"); 
		clearButton = new JButton("Clear");
		negativeButton = new JButton("(-)");

		
		//setting buttons on the functionButtons array
		functionButtons[0] = addButton; 
		functionButtons[1] = subButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decimalButton;
		functionButtons[5] = equalsButton;
		functionButtons[6] = deleteButton;
		functionButtons[7] = clearButton;
		functionButtons[8] = negativeButton;
		
		//setting functionButtons
		for(int i =0; i<9; i++) {

			functionButtons[i].setFont(fontType); // set font type
			functionButtons[i].setFocusable(false); // no focusable
			functionButtons[i].addActionListener(this); //action listener to the clicking event
			buttonsPanel.add(functionButtons[i]); // add functionButtons to buttonsPanel
		}
		
	
		//buttons coordinates and size
		
		numberButtons[7].setBounds(10,5,50,50); // number 7
		numberButtons[8].setBounds(70,5,50,50); // number 8
		numberButtons[9].setBounds(130,5,50,50); // number 0
		functionButtons[0].setBounds(190,5,50,50); // add button
		
		numberButtons[4].setBounds(10,65,50,50); // number 4
		numberButtons[5].setBounds(70,65,50,50); // number 5
		numberButtons[6].setBounds(130,65,50,50); // number 6
		functionButtons[1].setBounds(190,65,50,50); // subtraction button
		
		numberButtons[1].setBounds(10,125,50,50); // number 1
		numberButtons[2].setBounds(70,125,50,50); // number 2
		numberButtons[3].setBounds(130,125,50,50); // number 4
		functionButtons[2].setBounds(190,125,50,50); // multiply button
		
		functionButtons[4].setBounds(10,185,50,50); // decimal button
		numberButtons[0].setBounds(70,185,50,50); // number 0
		functionButtons[5].setBounds(130,185,50,50); // equals button
		functionButtons[3].setBounds(190,185,50,50); // division button
		
		functionButtons[6].setBounds(9,250,73,40); // delete button
		functionButtons[6].setFont(font2);         // delete button font
		functionButtons[8].setBounds(87,250,73,40); // negative button
		functionButtons[8].setFont(font2);          // negative button font
		functionButtons[7].setBounds(166,250,73,40); // clear button
		functionButtons[7].setFont(font2); // clear button font
		
		//comboxColors settings
		comboBoxColors.setBounds(130, 360, 140,30); // coordinates and site
		comboBoxColors.setFont(font2); // font type
		bodyPanel.add(comboBoxColors); // add comboBoxColors to bodyPanel
		
		// color Themes Action Listener	
		comboBoxColors.addActionListener(this);
		
		frame.setVisible(true); // visible true at the end of elements

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	// THEME COLOR EVENTS
	// Changes the color of buttons, panels and text when theme is selected
		
		
	// get the chosen item from comoBoxColor and sets it to a String
	String selectedItem = (String) comboBoxColors.getSelectedItem(); 
		
        // Aqua Theme - Cyan
        if (selectedItem.equals("Aqua")) {
        	for(int i =0; i<10; i++) { 
    			numberButtons[i].setBackground(Color.cyan);
    			numberButtons[i].setForeground(Color.black);
    		}
        	headerPanel.setBackground(Color.white);
        	bodyPanel.setBackground(Color.white);
        	buttonsPanel.setBackground(Color.white);
        	title.setForeground(Color.black);
        } 

        // Love Theme - Pink
        if (selectedItem.equals("Love")) {
        	for(int i =0; i<10; i++) {
    			numberButtons[i].setBackground(Color.pink);
    			numberButtons[i].setForeground(Color.black);
    		}
        	headerPanel.setBackground(Color.white);
        	bodyPanel.setBackground(Color.white);
        	buttonsPanel.setBackground(Color.white);
        	title.setForeground(Color.black);
        	} 
        
        // Joy Theme - Orange
        if (selectedItem.equals("Joy")) {
        	for(int i =0; i<10; i++) {
    			numberButtons[i].setBackground(Color.orange);
    			numberButtons[i].setForeground(Color.black);
    			}
        	headerPanel.setBackground(Color.white);
        	bodyPanel.setBackground(Color.white);
        	buttonsPanel.setBackground(Color.white);
        	title.setForeground(Color.black);
       	 	}
        
        // Nature Theme - Green
        if (selectedItem.equals("Nature")) {
        	for(int i =0; i<10; i++) {
    			numberButtons[i].setBackground(Color.green);
    			numberButtons[i].setForeground(Color.black);
    			}
        	headerPanel.setBackground(Color.white);
        	bodyPanel.setBackground(Color.white);
        	buttonsPanel.setBackground(Color.white);
        	title.setForeground(Color.black);
        	}
        
        // Vampire Theme - Red and Black
        if (selectedItem.equals("Vampire")) {
        	for(int i =0; i<10; i++) {
    			numberButtons[i].setBackground(Color.red);
    			numberButtons[i].setForeground(Color.black);
    			}
        	headerPanel.setBackground(Color.black);
        	bodyPanel.setBackground(Color.black);
        	buttonsPanel.setBackground(Color.black);
        	title.setForeground(Color.red);
	        }
        
        // Dark Theme - Black and Orange
        if (selectedItem.equals("Dark")) {
        	for(int i =0; i<10; i++) {
    			numberButtons[i].setBackground(Color.darkGray);
    			numberButtons[i].setForeground(Color.orange);
    			}
        	headerPanel.setBackground(Color.black);
        	bodyPanel.setBackground(Color.black);
        	buttonsPanel.setBackground(Color.black);
        	title.setForeground(Color.orange);
        	
       		}
        	
        if (selectedItem.equals("Light")) {
            for(int i =0; i<10; i++) {
        		numberButtons[i].setBackground(Color.white);
        		numberButtons[i].setForeground(Color.darkGray);
        		}
            headerPanel.setBackground(Color.lightGray);
            bodyPanel.setBackground(Color.lightGray);
            buttonsPanel.setBackground(Color.lightGray);
            title.setForeground(Color.black);
            }
        	

		
	// CALCULATOR EVENTS
        
	//get the pressed number and set it to textField visor
	for (int i = 0; i < 10; i++) {
			
		if(e.getSource() == numberButtons[i]) {
			visorTxtField.setText(visorTxtField.getText().concat(String.valueOf(i)));
			}
		}
				
		//get the first number to set the addition		
		if(e.getSource() == addButton) {
			number1 = Double.parseDouble(visorTxtField.getText());
			operator = '+';
			visorTxtField.setText("");
			}
				
		//get the first number to set the subtraction		
		if(e.getSource() == subButton) {
			number1 = Double.parseDouble(visorTxtField.getText());
			operator = '-';
			visorTxtField.setText("");
			}
				
		//get the first number to set the multiplication		
		if(e.getSource() == multButton) {
			number1 = Double.parseDouble(visorTxtField.getText());
			operator = '*';
			visorTxtField.setText("");
		}
				
		//get the first number to set the division
		if(e.getSource() == divButton) {
			number1 = Double.parseDouble(visorTxtField.getText());
			operator = '/';
			visorTxtField.setText("");
		}
				
		// equals sign event to do the calculation
		if(e.getSource() == equalsButton) {
					
			// gets the second number
			number2 = Double.parseDouble(visorTxtField.getText());
					
			// do the calculation
			switch(operator) {
					
				// addition
				case '+':
					result = number1 + number2;
					break;
						
				// subtraction
				case '-':
					result = number1 - number2;
					break;
						
				// multiply	
				case '*':
					result = number1 * number2;
					break;
						
				// division	
				case '/':
					result = number1 / number2;
					break;

				} // end switch
					
			// show result
			visorTxtField.setText(String.valueOf(result));
		}
				
			// clear button - clear the visor 
		if(e.getSource() == clearButton) {
			visorTxtField.setText("");
			number1 = 0;
			number2 = 0;	
		}
				
		// delete button - delete last number
		if(e.getSource() == deleteButton) {
			String string = visorTxtField.getText();
			visorTxtField.setText("");
					
			for (int i=0; i<string.length()-1; i++) {
				visorTxtField.setText(visorTxtField.getText()+string.charAt(i)); //set the last text - 1 char 
					}	
				} // end delete button		
				
		// decimal sign
		if(e.getSource() == decimalButton) {
			visorTxtField.setText(visorTxtField.getText() + '.');
		}
				
				
		// negative sign
		if(e.getSource() == negativeButton) {
			number1 = -1;
			visorTxtField.setText("-");
		}
					
        } // end ActionPerformed
	
	// main method to initiate program
	public static void main (String[] args) {
			
		JavaSimpleCalculator calculator = new JavaSimpleCalculator();

	} // end main method

	
} // end class
