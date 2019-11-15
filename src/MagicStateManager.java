/**
 * Write a description of class StateManager here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class MagicStateManager  
{
    // instance variables - replace the example below with your own
    private MagicState defaultState;
    private MagicState upState;
    private MagicState downState;
    private MagicState starState;
    private MagicState currentState;


    /**
     * Constructor for objects of class StateManager
     */
    public MagicStateManager()
    {
        defaultState = new DefaultState(this);
        upState = new SpeedUpState(this);
        downState = new SpeedDownState(this);
        starState = new InvincibleState(this);
        currentState = defaultState;
    }
    
    public void reset()
    {
        currentState.reset();
    }
    
    public void speedup()
    {
        currentState.toSpeedUp();
    }
    
    public void speeddown()
    {
        currentState.toSpeedDown();
    }
    
    public void invincible()
    {
        currentState.toInvincible();
    } 
    
    public void setState(MagicState.States nextstate)
    {
        switch(nextstate) {
            case UP: currentState = upState; break;
            case DOWN: currentState = downState; break;
            case STAR: currentState = starState; break;
            case OFF: currentState = defaultState; break;
        }
    }    

    public MagicState.States getCurrentState()
    {
        return currentState.getState();
    }
    
 
}
