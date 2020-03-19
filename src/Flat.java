import java.util.*;

public class Flat extends Adres{
	private int room;
	private String tenants;
	List <Human> tent = new ArrayList<>();
	Human h;
	public void acsseptTenat(int roomR) {
		roomR = room;
		
		if(h.getType() == "Studen") {
			tent.add(new Student("type1", "name1", "surname1"));
		}else {
			tent.add(new Workman("type2", "name2", "surname2"));
		}
		
		
	}
	
	private void giveRoom() {
		
		
	}
	
	public void letTenat() {
		//int i = tent.getIndex();
		//tent.clearTent();
		
		
		
	}
	private void freeRoom() {
		
	}

}
