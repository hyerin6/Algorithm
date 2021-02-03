package java8Test;

public interface Calculator {
	
	public default int plus(int i, int j) {
		return i+j;
	}
    public default int multiple(int i, int j) {
    	return i*j;
    }

}
