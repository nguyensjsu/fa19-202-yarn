/**
 * Write a description of class InvincibleState here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class InvincibleState extends MagicState 
{

    /**
     * Constructor for objects of class InvincibleState
     */
    public InvincibleState(MagicStateManager msm)
    {
        super(msm);
    }

    public States getState()
    {
        return States.STAR;
    }  
}
