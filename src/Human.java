
public abstract class Human extends Adres {
	protected String name;
	protected String surname;
	protected String type;
	
	public void moveIn() {
		
		
	}
	
	public void moveOut() {
		
	}
	public void setType(String typeH) {
		type = typeH;
		System.out.println(type);
		switch(type) {
		case "Student":
			Student s = new Student(this.getType(), this.getName(), this.getSurname());
			s.createStudent();
			System.out.println("1Student");
			break;
		case "Workman":
			Workman w = new Workman(this.getType(), this.getName(), this.getSurname());
			w.createWorkman();
			System.out.println("2Workman");
			break;
		}
		
		
	}
	public String toString() {
		return type + "- name: " + name + ", surname: " + surname;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String nameH, String surnameH) {
		name = nameH;
		surname = surnameH;
	}
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}

}
