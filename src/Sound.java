import java.io.*;
import javax.sound.sampled.*;


public class Sound {

	private static File die = new File("C:/Users/Cristian/Desktop/Workspace/Waves/src/Sound/die.wav");
	
	private static File hit = new File("C:/Users/Cristian/Desktop/Workspace/Waves/src/Sound/hit.wav");
	
	private static File levels1 = new File("C:/Users/Cristian/Desktop/Workspace/Waves/src/Sound/Level 1-10.wav");
	
	public static TimeKeep timer = new TimeKeep();
	
	private static Clip clip;
	
	public static void die() {
		
		play(die);
		
	}
	
	public static void hit() {
		
		play(hit);
		
	}
	
	public static void levels1() {
		timer.start();
		play(levels1);
		
		
	}
	
	private synchronized static void play(File sound) {
		
		try{
			
			clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			clip.open(ais);
			clip.start();
			
		} catch(LineUnavailableException e){
			
			e.printStackTrace();
			
		} catch(UnsupportedAudioFileException e){
			
			e.printStackTrace();
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
	

	}

}
