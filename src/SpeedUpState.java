/**
 * Write a description of class SpeedUpState here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class SpeedUpState extends MagicState 
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SpeedUpState
     */
    public SpeedUpState(MagicStateManager msm)
    {
        super(msm);
    }
    
    /**
     * override getState()
     */
    public States getState()
    {
        return States.UP;
    }  
    
    /**
     * override doEffect()
     */
    public void doEffect(Dog yarn)
    {
        yarn.addSpeedUpdate();
        yarn.invincible = false;
    }


}
