import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor implements ITouchSubject
{
    static ArrayList<ITouchObserver> observers = new ArrayList<>();
    public int scoreUpdate;
    public int speedUpdate;
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    public int getScore() {
        return scoreUpdate;
    }
    public int getSpeed() {
        return speedUpdate;
    }
    public void setScoreSpeed(int score, int speed) {
        scoreUpdate = score;
        speedUpdate = speed;
        notifyObservers(scoreUpdate, speedUpdate);
    }
    public void attachObserver(ITouchObserver observer) {
        //System.out.println("add Observer");
        observers.add(observer);
    }
    public void removeObserver(ITouchObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(int score, int speed) {
        for (ITouchObserver obj: observers) {
            obj.updateScoreSpeed(score,speed);
        }
    }
    public void touched()
    {
    }
    public String getType() {
        return "";
    }
        
}
