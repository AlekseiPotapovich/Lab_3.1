import java.util.*;

public class Flat extends Adres{
	private int room;
	private String tenants;
	List <Human> tent = new ArrayList<>();
	Human h;
	
	public Flat(int roomR) {//String tenantsR) {
		this.room = roomR;
		this.tenants = "";
		//this.tenants = tenantsR;
		//h = f;
		
	}
	public String showTent() {
		String hum1 = "<html>";
		int i = 0, g = 0;
		
		Object[] humanArray = tent.toArray();
		for(Object human: humanArray) {
			i++;
			System.out.println(tent);
			hum1 += i +") " + tent.get(g).toString() + "<br/>";
			g++;
		}
		hum1 += "</html>";
		System.out.println(hum1);
		return hum1;
		
		
	}
	public void acsseptTenat(int roomR, Human f) {
		//roomR = room;
		h = f;
		tent.add(f);
		
		System.out.println(room + "accept tenant");
		
		System.out.println("TYPE OF HUMAN: " + h.getType());
		tenants += h.toString() + "\n";
		//tenants += "\n";
		System.out.println("TENANTS OF ROOM: ¹" + room + ", "+ tenants);
		
		
		/*
		if(h.getType() == "Studen") {
			tent.add(new Student("type1", "name1", "surname1"));
		}else {
			tent.add(new Workman("type2", "name2", "surname2"));
		}
		*/
		
	}
	
	private void giveRoom() {
		
		
	}
	
	public void letTenat(int i) {
		//int i;
		//tent.get(i);
		tent.remove(i);
		
		
		
	}
	
	private void freeRoom() {
		
	}
	public int getNumberOfRoom() {
		return room;
	}
	public String getTenants() {
		return tenants;
	}

}
