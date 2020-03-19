
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	JButton moveIn,moveOut,addH,enter,back;
	JTextField  tf1, tf2,tf3;
	JLabel label1,label2, label3;
	//JTextArea tf3;
	int number;
	public View() {
		super("Flat");
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		moveIn = new JButton("MoveIn");
		moveOut = new JButton("MoveOut");
		addH = new JButton("Add");
		enter = new JButton("Enter");
		back = new JButton("Back");
		
		JPanel buttonPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		buttonPanel.add(moveIn);
		buttonPanel.add(moveOut);
		buttonPanel.add(addH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		
		HumanArray humans = new HumanArray();
		if(HumanArray.humans.isEmpty() == false) {
			label1.setText(humans.getArrayAsStringHTML());
			
		}else {
			label1.setText("List is empty!\n Plaese add human");
			
		}
		labelPanel.add(label1, BorderLayout.SOUTH);
		add(labelPanel, BorderLayout.CENTER);
		
		addH.setVisible(true);	
		moveIn.setVisible(false);
		moveOut.setVisible(false);
		
		
		tf1 = new JTextField(11);
		tf2 = new JTextField(11);
		tf3 = new JTextField(11);
		
		
		moveIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			GridLayout layout = new GridLayout(6, 1);
				
			label1.setText("Choose Sudent or Workman: ");
			labelPanel.add(label1);//, BorderLayout.NORTH);
			
			label2.setText("Enter name: ");
			labelPanel.add(label2);//,BorderLayout.CENTER);
			
			label3.setText("Enter surname: ");
			labelPanel.add(label3);//, BorderLayout.SOUTH);
			
			labelPanel.setLayout(layout);
			add(labelPanel,BorderLayout.WEST);
			
			fieldPanel.add(tf1, BorderLayout.NORTH);
			fieldPanel.add(tf2, BorderLayout.CENTER);
			fieldPanel.add(tf3, BorderLayout.SOUTH);
			
			
			
			fieldPanel.setLayout(layout);
			add(fieldPanel, BorderLayout.CENTER);
				
			buttonPanel.add(addH);
			
			moveIn.setVisible(false);
			moveOut.setVisible(false);
			
			}
		});
	
		addH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GridLayout layout = new GridLayout(6, 1);
				fieldPanel.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				
				label1.setText("Choose Student or Workman: ");
				labelPanel.add(label1);//, BorderLayout.NORTH);
				
				label2.setText("Enter name: ");
				labelPanel.add(label2);//,BorderLayout.CENTER);
				
				label3.setText("Enter surname: ");
				labelPanel.add(label3);//, BorderLayout.SOUTH);
				
				labelPanel.setLayout(layout);
				add(labelPanel,BorderLayout.WEST);
				
				fieldPanel.add(tf1, BorderLayout.NORTH);
				fieldPanel.add(tf2, BorderLayout.CENTER);
				fieldPanel.add(tf3, BorderLayout.SOUTH);
				
				
				
				fieldPanel.setLayout(layout);
				add(fieldPanel, BorderLayout.CENTER);
				
				
			
				addH.setVisible(false);
				buttonPanel.add(back);
				buttonPanel.add(enter);
				back.setVisible(true);
				enter.setVisible(true);
		
			}
		});
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addH.setVisible(false);
				
				Human hum = null;
				
				switch(tf1.getText()) {
				case "Student":
					hum = new Student(tf1.getText(), tf2.getText(), tf3.getText());
					hum.setType("Student");
					break;
				case "Workman":
					hum = new Workman(tf1.getText(), tf2.getText(),tf3.getText());
					hum.setType("Workman");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Incorrect input!","Error", JOptionPane.ERROR_MESSAGE);	
						
				}
				
				
			//enter.removeActionListener((ActionListener) this);
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enter.setVisible(false);
				addH.setVisible(true);
				label2.setVisible(false);
				label3.setVisible(false);
				
				//labelPanel.setVisible(false);
				fieldPanel.setVisible(false);
				if(HumanArray.humans.isEmpty() == false) {
					label1.setText(humans.getArrayAsStringHTML());
					
				}else {
					label1.setText("List is empty!\n Plaese add human");
					
				}
				back.setVisible(false);
				
			}
		});
		
		moveOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
