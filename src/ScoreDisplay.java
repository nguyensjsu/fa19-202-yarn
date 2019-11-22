import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends DisplayComponent implements ITouchObserver
{
    
    private int score = 0;
    public ScoreDisplay()
    {
        score = 0;
        setImage(new GreenfootImage("Score: " + score, 20, Color.WHITE, Color.BLACK));
    }

    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpScore(int amount)
    {
        score += amount;
        setImage(new GreenfootImage("Score: " + score, 20, Color.WHITE, Color.BLACK));
    }
    public int getScore()
    {
        return score;
        
    }

    public void updateScoreSpeed(int update_score, int update_speed){
        score += update_score;
        setImage(new GreenfootImage("Score: " + score, 20, Color.WHITE, Color.BLACK));
    }
}
