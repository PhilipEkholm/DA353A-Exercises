package laboration7;

public class EvenNumbers implements Filter<Integer>{
	@Override
	public boolean accept(Integer element) {
		return (element % 2 == 0);
	}
	
}
