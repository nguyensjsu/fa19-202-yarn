/**
 * Interface 
 * 
 * @author (Yu Zhao) 
 * @version (a version number or a date)
 */
public interface ITouchObserver  
{
    /**
     * update both speed and score for each touch event
     */
    public void updateScoreSpeed(int update_score, int update_speed);

}
