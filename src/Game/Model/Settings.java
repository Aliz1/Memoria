package Game.Model;

/**
 *Handles the settings and help gui so you can only have one window open at the time.
 * @author Karl
 * 
 */
public class Settings {
    
    private boolean windowOpen = false; //karl

    public void setWindowOpen(boolean windowOpen){
        this.windowOpen = windowOpen;
    }
    public boolean getWindowOpen (){
        return windowOpen;
    }
}
