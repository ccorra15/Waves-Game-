import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width, height;
	private float life;

	
	Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
		
	}

	
	public void tick() {
		
		if(this.alpha > life) {
			
			alpha -= (life - 0.01f);
			
		}
		
		else {
			
			handler.removeObject(this);
			
		}
	}

	
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(this.alpha));
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, 16);
		g2d.setComposite(makeTransparent(1));
		
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
