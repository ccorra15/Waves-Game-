import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 800, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = true;
	private Handler handler;
	private HUD hud;
	private Spawnner spawnner;
	
	public Game() {
		
		this.requestFocus();
		
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Waves", this);
		
		hud = new HUD();
		
		spawnner = new Spawnner(handler, hud);
		
		Random r = new Random();
		Sound.levels1();
	
		handler.addObject(new Player(370, 250, ID.Player, handler));
		handler.addObject(new HorizontalEnemy(10, 250, ID.HorizontalEnemy, handler));
		handler.addObject(new HorizontalEnemy(750, 70, ID.HorizontalEnemy, handler));
		handler.addObject(new HorizontalEnemy(750, 450, ID.HorizontalEnemy, handler));
		handler.addObject(new VerticalEnemy(150, 10, ID.VerticalEnemy, handler));
		handler.addObject(new VerticalEnemy(400, 540, ID.VerticalEnemy, handler));
		handler.addObject(new VerticalEnemy(600, 10, ID.VerticalEnemy, handler));
		
		
	}
	
	public synchronized void start() {
		
		thread = new Thread(this);
		setFocusable(true);
		thread.start();
		
	}
	
	public synchronized void stop() {
		
		try{
			thread.join();
			running = false;
		}catch(Exception e) { }
		
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double delta = 0;
		double ns = 1000000000 / amountOfTicks;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				
				tick();
				delta--;
				
			}
			
			if(running) {
				
				render();
				
			}
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				frames = 0;
				
			}
			
		}
		
		stop();
		
	}
	
	private void tick() {
		
		handler.tick();
		hud.tick();
		spawnner.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		
		new Game();

	}


}
