
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	JButton moveIn,moveOut,addH,enter,back,action,showTent;
	JTextField  tf1, tf2,tf3;
	JLabel label1,label2, label3,arrayLabel,roomLabel;
	JPanel buttonPanel,fieldPanel,labelPanel = new JPanel();
	HumanArray humans = new HumanArray();
	GridLayout layout;// = new GridLayout(6, 1);
	//JTextArea tf3;
	Flat r1;
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
		
		adress = (int) (1 + Math.random() * 21);
		r1 = new Flat(adress);
		
		if(HumanArray.humans.isEmpty() == false) {
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
				
				fieldPanel.add(tf1, BorderLayout.NORTH);
				fieldPanel.add(tf2, BorderLayout.CENTER);
				fieldPanel.add(tf3, BorderLayout.SOUTH);
				
				
				
				fieldPanel.setLayout(layout);
				add(fieldPanel, BorderLayout.CENTER);
				
				
			
				addH.setVisible(false);
				action.setVisible(false);
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
				arrayLabel.setVisible(false);
				roomLabel.setVisible(true);
				String hum1 = "<html>Room ¹" + r1.getNumberOfRoom() + "<br/>" + r1.showTent() + "/html";
				roomLabel.setText(hum1);
				labelPanel.add(roomLabel);//, BorderLayout.CENTER);
				//add(labelPanel, BorderLayout.NORTH);
				
				
			}
		});
		
		moveIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adress = (int) (1 + Math.random() * 21);
				//r1 = new Flat(adress, humans.getHuman(index));//HumanArray.humans.get(index).toString());
				r1.acsseptTenat(adress, humans.getHuman(index));
				showTent.setVisible(true);
				
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
				HumanArray.humans.get(index);
				arrayLabel.setText(HumanArray.humans.get(index).toString());
				
				moveIn.setVisible(true);
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
		
		if(HumanArray.humans.isEmpty() == false) {
			arrayLabel.setText(humans.getArrayAsStringHTML());
			arrayLabel.setVisible(true);
			
			action.setVisible(true);
			
			
		}else {
			arrayLabel.setText("List is empty!\n Plaese add human");
			arrayLabel.setVisible(true);
			
		}
		//layout.setColumns(1);
		//layout = new GridLayout(1, 1);
		labelPanel.add(arrayLabel);//, BorderLayout.CENTER);
		add(labelPanel, BorderLayout.NORTH);
		//arrayLabel.setVisible(true);
		
		back.setVisible(false);
	}

}
