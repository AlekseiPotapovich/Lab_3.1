import javax.swing.JOptionPane;

public class Student extends Human {
	public Student(String typeS, String nameS, String surnameS) {
		name = nameS;
		surname = surnameS;
		type = typeS;
		//setType("student");
		
		
	}
	public void createStudent() {
		Student student = new Student(this.getType(), this.getName() ,this.getSurname());
		HumanArray.humans.add(student);
			
	}
	
	public void toStudy() {
		
	}
	
//	public void setType(String typeS) {
//		typeS = type;
//	}

}
