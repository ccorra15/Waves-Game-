import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	private Handler handler;
	
	FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		vX = 13;
		vY = 13;
		
	
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int) x, (int) y, 16, 16);
		
	}
	
	public void tick() {
		
		x += vX;
		y += vY;
		
		if(y <= 0 || y >= Game.HEIGHT - 40) vY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 10) vX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN,16, 16, 0.1f, handler));
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillRect((int) x, (int) y, 16, 16);
		
	}

}
