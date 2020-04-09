package classes;

public class MyException extends Exception {
	
	public static void testEnterIndex(int index) throws MyException {
		if(index <= 0 || index > HumanArray.humans.size()) {
			throw new MyException();
		}
	}
	
	public static void testarrayIsEmpty() throws MyException{
		if(HumanArray.humans.isEmpty() == true) {
			throw new MyException();
		}
	}
	

}
