import java.util.TimerTask;
import java.util.*;

public class TimeKeep {

	public int seconds = 0;
	
	private Timer timer = new Timer();
	private TimerTask task = new TimerTask() {
			
		public void run() {
				seconds++;
				
		}
			
	};

	
	public void start() {
		
		timer.scheduleAtFixedRate(task, 1000, 1000);
		
	}
	
	public int getSec() {
		
		return this.seconds;
		
	}
	
}
