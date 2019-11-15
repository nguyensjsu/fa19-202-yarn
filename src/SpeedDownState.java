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
    
    public States getState()
    {
        return States.DOWN;
    } 
    
    public void doEffect(Dog yarn)
    {
        if(yarn.speed > 1)
             yarn.speedUpdate= -1;
    }
    


}
