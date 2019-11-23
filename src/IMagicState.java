/**
 * Interface for MagicStates
 * 
 * @author Yu Zhao 
 * @version (a version number or a date)
 */
public interface IMagicState  
{
    /**
     * reset to default state
     */
    void reset();
    
    /**
     * Switch to SpeedUp State
     */
    void toSpeedUp();
    
    /**
     * Switch to SpeedDown state
     */
    void toSpeedDown();
    
    /**
     * Switch to Invincible state
     */
    void toInvincible();
    
}
