package root;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundThread implements Runnable {
    private Clip clip;
    	
    public SoundThread(File file) {
       
        try {
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                setClip(AudioSystem.getClip());
                getClip().open(sound);
            }
            else {
                throw new RuntimeException("Sound: file not found: " + file);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }

    
    }
    
    public void play(){
        	clip.start();
    }
    
    public void loop(){
        	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(){
            clip.stop();
    }
    
	@Override
	public void run() {
		
		try {
			getClip().start();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}
}