package Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {
    public static boolean r=true;
    public static int musicflag=1;
    String musicLocation;
    Clip clip;

    public Music(String musicLocation){
        this.musicLocation=musicLocation;
        File music = new File(musicLocation);
        try
        {
            if(music.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        playMusic();
    }

    public void playMusic()               //播放音乐
    {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopMusic()              //关闭音乐
    {
        clip.stop();
    }
}

