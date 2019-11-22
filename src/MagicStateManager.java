/**
 * Write a description of class StateManager here.
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public class MagicStateManager  
{
    private MagicState defaultState;
    private MagicState upState;
    private MagicState downState;
    private MagicState starState;
    private MagicState currentState;
    //private DisplayComponent display;

    public MagicStatusDisplay getMagicStatusDisplay() {
        return magicStatusDisplay;
    }

    public void setMagicStatusDisplay(MagicStatusDisplay magicStatusDisplay) {
        this.magicStatusDisplay = magicStatusDisplay;
    }

    private MagicStatusDisplay magicStatusDisplay;
    
    /**
     * Constructor for objects of class StateManager
     */
    public MagicStateManager()
    {
        this.defaultState = new DefaultState(this);
        this.upState = new SpeedUpState(this);
        this.downState = new SpeedDownState(this);
        this.starState = new InvincibleState(this);
        this.currentState = this.defaultState;
        this.magicStatusDisplay = new MagicStatusDisplay();
    }
    
    /**
     * reset to default state
     */
    public void reset()
    {
        this.currentState.reset();
        this.notifyDisplay();
    }
    
    /**
     * switch to speedup
     */
    public void speedup()
    {
        this.currentState.toSpeedUp();
        this.notifyDisplay();
    }
    
    /**
     * switch to speeddown
     */
    public void speeddown()
    {
        this.currentState.toSpeedDown();
        this.notifyDisplay();
    }
    
    /**
     * switch to invincible
     */
    public void invincible()
    {
        this.currentState.toInvincible();
        this.notifyDisplay();
    } 
    
    /**
     * set State (called by each state)
     */
    public void setState(MagicState.States nextstate)
    {
        switch(nextstate) {
            case UP: this.currentState = upState; break;
            case DOWN: this.currentState = downState; break;
            case STAR: this.currentState = starState; break;
            case OFF: this.currentState = defaultState; break;
        }

        this.notifyDisplay();
    } 
    
    /**
     * get current magic state
     */
    public MagicState.States getCurrentState()
    {
        return this.currentState.getState();
    }
    
     /**
     * Apply current magic state on yarn
     */
    public void doEffect(Dog yarn)
    {
        this.currentState.doEffect(yarn);
    }    
   

    
    /**
     * Notify Magic Status Display
     */
    public void notifyDisplay()
    {
        this.magicStatusDisplay.updateMagicStatus(this.currentState.getState());

    }


}
