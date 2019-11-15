/**
 * Write a description of class MagicState here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class MagicState implements IMagicState  
{
    // instance variables - replace the example below with your own
    MagicStateManager ms_manager;
    
    public enum States
    {
        UP, DOWN, OFF, STAR
    }
    
    /**
     * Constructor for objects of class MagicState
     */
    public MagicState(MagicStateManager msm)
    {
        ms_manager = msm;
    }

    /**
     * reset to Default State
     */
    public void reset()
    {
        ms_manager.setState(States.OFF);
    }
    
    /**
     * switch to SpeedUp
     */
    public void toSpeedUp()
    {
        ms_manager.setState(States.UP);
    }
    
    /**
     * switch to SpeedDown
     */
    public void toSpeedDown()
    {
        ms_manager.setState(States.DOWN);
    }
    
    /**
     * switch to Invincible
     */
    public void toInvincible()
    {
        ms_manager.setState(States.STAR);
    }
    
    public States getState()
    {
        return States.OFF;
    }
    
    public void doEffect(Dog yarn)
    {
    }
}    
