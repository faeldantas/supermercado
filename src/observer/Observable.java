package observer;

public interface Observable {
    public void registerObserver(Observer observer);
	public void notifyObservers(String produto);
	public void removeObserver(Observer observer);
}
