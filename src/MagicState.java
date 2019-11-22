



/**
 * Parent Class: Magic State
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */

import java.util.Random;

public class MagicState implements IMagicState  
{   
    MagicStateManager ms_manager;
   
    public enum States
    {
        UP, DOWN, OFF, STAR
    }
    /**
     * get a random Magic State
     */
    public static States getRandomState2() {
       States random = (new Random().nextInt()<0) ? States.DOWN : States.STAR;
       return random;
    }  
    
    /**
    * get a random Magic State out of four state
    */
    public static States getRandomState() {
        int pick = new Random().nextInt(States.values().length);
        return States.values()[pick];
    }

     /**
     * Constructor for objects of class MagicState
     */
    public MagicState(MagicStateManager msm)
    {
        this.ms_manager = msm;
    }

    /**
     * reset to Default State
     */
    public void reset()
    {
        this.ms_manager.setState(States.OFF);
    }
    
    /**
     * switch to SpeedUp
     */
    public void toSpeedUp()
    {
        this.ms_manager.setState(States.UP);
    }
    
    /**
     * switch to SpeedDown
     */
    public void toSpeedDown()
    {
        this.ms_manager.setState(States.DOWN);
    }
    
    /**
     * switch to Invincible
     */
    public void toInvincible()
    {
        this.ms_manager.setState(States.STAR);
    }
    /**
     * get current State, default return is States.OFF
     * to be overrided by child classes
     */
    public States getState()
    {
        return States.OFF;
    }
    
    /**
     * Apply magic effect on Yarn
     */
    public void doEffect(Dog yarn)
    {
    }
}    
