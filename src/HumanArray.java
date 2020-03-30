import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HumanArray {
	static List<Human> humans = new ArrayList<>();
	
	public  String getArrayAsStringHTML() {
		String hum1 = "<html>";
		int i = 0, g = 0;
		
		Object[] humanArray = humans.toArray();
		for(Object human: humanArray) {
			i++;
			System.out.println(humans);
			hum1 += i +") " + humans.get(g).toString() + "<br/>";
			g++;
		}
		hum1 += "</html>";
		System.out.println(hum1);
		return hum1;
	}	
	
	public Human getHuman(int i) {
		Human h = null;
		Object[] humanArray = humans.toArray();
		for(Object human: humanArray) {
			h = humans.get(i);
		}
		 
		return h;
	}
	
	public  int getIndex() {
		int index = 0;
		
		while(index == 0 && humans.size() > 0) {
			try {				
				MyException.testEnterIndex (index = Integer.parseInt(JOptionPane.showInputDialog("Enter index of human")));				
			}
			catch(MyException e) {
				JOptionPane.showMessageDialog(null, "Error!\nYou can input number in iterval [1-" + humans.size() + "]","Error", JOptionPane.ERROR_MESSAGE, null );
				index = 0;
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error!\nYou can input only numbers","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		index--;
		
		return index;
	}
	public boolean isEmpty() {
		if(humans.size()>0)
			return true;
		else 
			return false;
		
		
	}

}
