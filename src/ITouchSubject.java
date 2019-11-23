/**
 * Write a description of class ITouchSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ITouchSubject  
{
    void attachObserver(ITouchObserver observer);
    void removeObserver(ITouchObserver observer);
    void notifyObservers(int score, int speed);
}
