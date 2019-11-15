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
    
    public States getState()
    {
        return States.UP;
    }  
    
    public void doEffect(Dog yarn)
    {
        yarn.speedUpdate++;
    }


}
