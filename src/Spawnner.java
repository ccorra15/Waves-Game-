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
		
		if(scoreKeep >= 500) {
			
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			

			if(hud.getLevel() == 2) {
			
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.BasicEnemy, handler));
				
			}
			
			if(hud.getLevel() == 3) {
			
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.BasicEnemy, handler));
				
			}
			
			if(hud.getLevel() == 4) {
				
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.FastEnemy, handler));
				
			}
			
			if(hud.getLevel() == 5) {
				
				handler.addObject(new SmartEnemy(100, 100, ID.SmartEnemy, handler));
				
			}
			
			
		}
		
	}
	
}
