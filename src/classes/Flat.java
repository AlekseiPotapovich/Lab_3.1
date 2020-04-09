package classes;
import java.util.*;

public class Flat extends Adres{
	private int room;
	private String tenants;
	private static List <Human> tent = new ArrayList<Human>();
	private Human h;
	
	public Flat() {//String tenantsR) {
		this.room = giveRoom();
		//this.room = roomR;
		this.tenants = "";
		//this.street = "L.Bedy";
		this.setStreet("L.Bedy");
		this.setHouse(21);
		//this.house = 21;
		//this.tenants = tenantsR;
		//h = f;
		
	}
	public void setArray(Human j) {
		tent.add(j);
	}
	public static boolean flatIsEmpty() {
		boolean empty = true;
		if(tent.isEmpty() == false)
			empty = false;
		return empty;
	}
	public List<Human> getArray() {
		return tent;
	}
	public String showTent() {
		String hum1 = "<html>";
		int i = 0, g = 0;
		
		Object[] humanArray = tent.toArray();
		for(@SuppressWarnings("unused") Object human: humanArray) {
			i++;
			System.out.println(tent);
			hum1 += i +") " + tent.get(g).toString() + "<br/>";
			g++;
		}
		hum1 += "</html>";
		System.out.println(hum1);
		return hum1;
		
		
	}
	public void setHum(Human g) {
		h = g;
	}
	public Human getHum() {
		return h;
	}
	public void acsseptTenat(int roomR, Human f) {
		//roomR = room;
		//h = f;
		//f = getHum();
		setHum(f);
		tent.add(f);
		
		System.out.println(room + "accept tenant");
		
		//System.out.println("TYPE OF HUMAN: " + h.getType());
		tenants += h.toString() + "\n";
		//tenants += "\n";
		//System.out.println("TENANTS OF ROOM: �" + room + ", "+ tenants);
		
		
		/*
		if(h.getType() == "Studen") {
			tent.add(new Student("type1", "name1", "surname1"));
		}else {
			tent.add(new Workman("type2", "name2", "surname2"));
		}
		*/
		
	}
	
	private int giveRoom() {
		return room = (int) (1 + Math.random() * 21);
	}
	
	public void letTenat(int i) {
		//int i;
		//tent.get(i);
		tent.remove(i);
		
		
		
	}
	/*
	private void freeRoom() {
		tent.removeAll(tent);
	}
	*/
	public int getNumberOfRoom() {
		return room;
	}
	public String getTenants() {
		return tenants;
	}

}
