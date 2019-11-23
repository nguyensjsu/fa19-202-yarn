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
    /**
     * override getState()
     */
    public States getState()
    {
        return States.STAR;
    }
    /**
     * override doEffect()
     */
    public void doEffect(Dog yarn)
    {
        yarn.invincible = true;
    }
}
