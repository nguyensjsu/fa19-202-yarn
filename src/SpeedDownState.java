/**
 * Write a description of class SpeedDownState here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class SpeedDownState extends MagicState 
{

    /**
     * Constructor for objects of class SpeedDownState
     */
    public SpeedDownState(MagicStateManager msm)
    {
        super(msm);
    }
    /**
     * override getState()
     */
    public States getState()
    {
        return States.DOWN;
    } 
    
    /**
     * override doEffect()
     */
    public void doEffect(Dog yarn)
    {
        yarn.setSpeedUpdate(-1);
    }
    


}
