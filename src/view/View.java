package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	JButton moveIn,moveOut,addH,enter,back,action,showTent;
	JTextField  tf1, tf2,tf3;
	JLabel label1,label2, label3,arrayLabel,roomLabel;
	JPanel buttonPanel,fieldPanel,labelPanel = new JPanel();
	classes.HumanArray humans = new classes.HumanArray();
	GridLayout layout;// = new GridLayout(6, 1);
	//JTextArea tf3;
	classes.Flat r1;
	int number, adress, index;
	public View() {
		super("Flat");
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		moveIn = new JButton("MoveIn");
		moveOut = new JButton("MoveOut");
		addH = new JButton("Add");
		enter = new JButton("Enter");
		back = new JButton("Back");
		action = new JButton("Action");
		showTent = new JButton("showRoom");
		
		
		JPanel buttonPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		buttonPanel.add(moveIn);
		buttonPanel.add(moveOut);
		buttonPanel.add(addH);
		buttonPanel.add(action);
		buttonPanel.add(showTent);
		add(buttonPanel, BorderLayout.SOUTH);
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		arrayLabel = new JLabel();
		roomLabel = new JLabel();
		
		//adress = (int) (1 + Math.random() * 21);
		
		r1 = new classes.Flat();
		
		if(classes.HumanArray.humans.isEmpty() == false) {
			arrayLabel.setText(humans.getArrayAsStringHTML());
			buttonPanel.add(action);
			action.setVisible(true);
			
			
		}else {
			arrayLabel.setText("List is empty!\n Plaese add human");
			action.setVisible(false);
			
			
		}
		labelPanel.add(arrayLabel);//, BorderLayout.CENTER);
		add(labelPanel, BorderLayout.CENTER);
		showTent.setVisible(false);
		addH.setVisible(true);	
		moveIn.setVisible(false);
		moveOut.setVisible(false);
		
		
		tf1 = new JTextField(11);
		tf2 = new JTextField(11);
		tf3 = new JTextField(11);
		
		
		
	
		addH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GridLayout layout = new GridLayout(6, 1);
				labelPanel.remove(arrayLabel);
				labelPanel.remove(roomLabel);
				arrayLabel.setVisible(false);
				label1.setVisible(true);
				
				label2.setVisible(true);
				label3.setVisible(true);
				tf1.setVisible(true);
				tf2.setVisible(true);
				tf3.setVisible(true);
				
				
				
				label1.setText("Choose Student or Workman: ");
				labelPanel.add(label1);//, BorderLayout.NORTH);
				
				label2.setText("Enter name: ");
				labelPanel.add(label2);//,BorderLayout.CENTER);
				
				label3.setText("Enter surname: ");
				labelPanel.add(label3);//, BorderLayout.SOUTH);
				
				labelPanel.setLayout(layout);
				add(labelPanel,BorderLayout.WEST);
				
				tf1.setText("");
				fieldPanel.add(tf1, BorderLayout.NORTH);
				tf2.setText("");
				fieldPanel.add(tf2, BorderLayout.CENTER);
				tf3.setText("");
				fieldPanel.add(tf3, BorderLayout.SOUTH);
				
				
				
				fieldPanel.setLayout(layout);
				add(fieldPanel, BorderLayout.CENTER);
				
				
			
				addH.setVisible(false);
				action.setVisible(false);
				buttonPanel.add(back);
				buttonPanel.add(enter);
				back.setVisible(true);
				enter.setVisible(true);
				showTent.setVisible(false);
		
			}
		});
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addH.setVisible(false);
				
				classes.Human hum = null;
				
				switch(tf1.getText()) {
				case "Student":
					hum = new classes.Student(tf1.getText(), tf2.getText(), tf3.getText());
					hum.setTypeH("Student");
					break;
				case "Workman":
					hum = new classes.Workman(tf1.getText(), tf2.getText(),tf3.getText());
					hum.setTypeH("Workman");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Incorrect input!","Error", JOptionPane.ERROR_MESSAGE);	
						
				}
				back();
				
				
			//enter.removeActionListener((ActionListener) this);
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
				
			}
		});
		
		showTent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//arrayLabel.setVisible(false);
				//labelPanel.remove(arrayLabel);
				//roomLabel.setVisible(true);
				r1.getStreet();
				String hum1 = "<html>Room ¹" + r1.getNumberOfRoom()+"("+ r1.getStreet()+" "+r1.getHouse()+")"
				+ "<br/>" + r1.showTent() + "/html";
				arrayLabel.setText(hum1);
				//roomLabel.setText(hum1);
				//labelPanel.add(roomLabel);//, BorderLayout.CENTER);
				//add(labelPanel, BorderLayout.CENTER);
				back.setVisible(true);
				moveIn.setVisible(false);
				moveOut.setVisible(false);
				
			}
		});
		
		moveIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adress = (int) (1 + Math.random() * 21);
				//r1 = new Flat(adress, humans.getHuman(index));//HumanArray.humans.get(index).toString());
				r1.acsseptTenat(adress, humans.getHuman(index));
				showTent.setVisible(true);
				//if(classes.Flat.tent.isEmpty() == false)
				//boolean empty = classes.Flat.flatIsEmpty();
				if(classes.Flat.flatIsEmpty() == false)
					moveOut.setVisible(true);
				
			}
		});
		
		moveOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1.letTenat(index);
				
				
			}
		});
		action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayLabel.setVisible(true);
				index = humans.getIndex();
				classes.HumanArray.humans.get(index);
				arrayLabel.setText(classes.HumanArray.humans.get(index).toString());
				
				moveIn.setVisible(true);
				if(classes.Flat.flatIsEmpty() == false)
					moveOut.setVisible(true);
				action.setVisible(false);
				addH.setVisible(false);
				back.setVisible(true);
				//showTent.setVisible(true);
				
			}
		});
		
	}
	public void back() {
		
		enter.setVisible(false);
		addH.setVisible(true);
		moveIn.setVisible(false);
		moveOut.setVisible(false);
		
		roomLabel.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		tf1.setVisible(false);
		tf2.setVisible(false);
		tf3.setVisible(false);
		
		if(classes.HumanArray.humans.isEmpty() == false) {
			arrayLabel.setText(humans.getArrayAsStringHTML());
			arrayLabel.setVisible(true);
			
			action.setVisible(true);
			
			
		}else {
			arrayLabel.setText("List is empty!\n Plaese add human");
			arrayLabel.setVisible(true);
			
		}
		if(classes.Flat.flatIsEmpty() == false)
			showTent.setVisible(true);
		//layout = new GridLayout(1, 1);
		labelPanel.add(arrayLabel);//, BorderLayout.CENTER);
		add(labelPanel, BorderLayout.NORTH);
		//arrayLabel.setVisible(true);
		
		back.setVisible(false);
	}

}
