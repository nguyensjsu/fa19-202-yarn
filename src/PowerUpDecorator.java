/**
 * Write a description of class PowerUpDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date
 */
public class PowerUpDecorator extends Item implements IDecorator  
{
    MagicStateManager magicSM = new MagicStateManager();
    public void powerUp(MagicState.States state, Dog yarn) {
        magicSM.setState(state);
        magicSM.doEffect(yarn);
    }
}
