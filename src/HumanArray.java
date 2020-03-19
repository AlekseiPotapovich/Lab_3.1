import java.util.ArrayList;
import java.util.List;

public class HumanArray {
	static List<Human> humans = new ArrayList<>();
	
	public  String getArrayAsStringHTML() {
		String hum1 = "<html>";
		int i = 0, g = 0;
		
		Object[] humanArray = humans.toArray()	;
		for(Object human: humanArray) {
			i++;
			System.out.println(humans);
			hum1 += i +") " + humans.get(g).toString() + "<br/>";
			//System.out.println(humans.get(g).getType());
			g++;
		}
		hum1 += "</html>";
		System.out.println(hum1);
		return hum1;
	}	
	
	public boolean isEmpty() {
		if(humans.size()>0)
			return true;
		else 
			return false;
		
		
	}

}
