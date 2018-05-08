import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{

	private Handler handler;
	private GameObject player;
	
	SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(GameObject z: handler.object) {
			
			if(z.getID() == id.Player) {
				
				this.player = z;
				
			}
			
		}
		
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int) x, (int) y, 16, 16);
		
	}
	
	public void tick() {
		
		x += vX;
		y += vY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		
		float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX()) + (y-player.getY())*(y - player.getY()));
		
		vX = (float) ((-1.0 / distance) * diffX);
		vY = (float) ((-1.0 / distance) * diffY);
		
		if(y <= 0 || y >= Game.HEIGHT - 40) vY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 10) vX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.BLUE,16, 16, 0.1f, handler));
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}
