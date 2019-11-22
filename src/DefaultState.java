/**
 * Write a description of class DefaultState here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class DefaultState extends MagicState 
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class DefaultState
     */
    public DefaultState(MagicStateManager msm)
    {
        super(msm);
    }
    /**
     * override doEffect()
     */
    public void doEffect(Dog yarn)
    {
        yarn.setSpeedUpdate(0);
        yarn.invincible= false;
        
    }


}
