import java.util.Random;

public class Spawnner {

	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	
	public Spawnner(Handler handler, HUD hud) {
		
		this.handler = handler;
		this.hud = hud;
		
	}
	
	public void tick() {
		
		Random r = new Random();
		
		scoreKeep++;
		Sound.timer.seconds++;
		
		//System.out.println(Sound.timer.seconds);
		
		if(scoreKeep >= 500) {
			
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
		}
		
		if(hud.getLevel() <= 10) {
			
			levels1();
			
		}
	}
	
	public void levels1() {
		
		if(Sound.timer.getSec() == 370) {
			
			handler.addObject(new BasicEnemy(100, 100, ID.BasicEnemy, handler));
	
			
		}
		
		if(Sound.timer.seconds == 550) {
		
			handler.addObject(new BasicEnemy(400, 400, ID.BasicEnemy, handler));
			
		}
		
		if(Sound.timer.seconds == 1380) {
			
			remove(ID.BasicEnemy);
			
			handler.addObject(new FastEnemy(100, 100, ID.FastEnemy, handler));
			
		}
		
		if(Sound.timer.seconds == 1450) {
			
			remove(ID.BasicEnemy);
			handler.object.remove(ID.BasicEnemy);
			handler.addObject(new FastEnemy(100, 100, ID.FastEnemy, handler));
			
		}
		
		if(Sound.timer.seconds == 1540) {
			
			handler.addObject(new FastEnemy(100, 100, ID.FastEnemy, handler));
			
		}
		
	}
	
	private void remove(ID id) {
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject x = handler.object.get(i);
			
			if(x.getID() == id) {
				
				handler.object.remove(x);
				
			}
			
		}
		
	}
	
}
