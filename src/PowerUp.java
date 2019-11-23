import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Item
{
    private MagicState.States state;
    private Item item;
    private Dog yarn;
    
    private ArrayList<ITouchObserver> observers = new ArrayList<>();
    
    PowerUp(Dog d, Item item, MagicState.States s)
    {
        this.yarn = d;
        this.item = item;
        this.state = s;
        //setImage() based on item type
        GreenfootImage powerup;
        if (this.item.getType() == "Bomb") {
            powerup = new GreenfootImage("bomb.png");
        } else {
            powerup = new GreenfootImage("ball.png");
        }
        
        powerup.scale(30, 30);
        setImage(powerup);
    }    
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Dog.class)){
            //System.out.println("Touch Dog");
            //super.setScoreSpeed(10,0);
            this.item.touched();// Add your action code here.
            notifyPlayer();
       }
    }
   
 
    
    private MagicState.States getMagicState()
    {
        return this.state;
    }
    
    private void notifyPlayer()
    {
        String type = this.item.getType();
        //System.out.print(type);
        
        if (type == "Ball")
            yarn.updateBallEaten(this.state);
        
        else if(type == "Bomb")  
            yarn.updateBombEaten(this.state);
        
    }    
}
