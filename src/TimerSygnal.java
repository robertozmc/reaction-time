import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TimerSygnal extends TimerTask
{
	
	static int numerSygnalu;
	static long czasPojawienia;
		
	public void run()
	{
		
		numerSygnalu = (new Random().nextInt(4) + 1);
		if (numerSygnalu == 1)
		{
			
			MainWindow.light1.setIcon(MainWindow.redLight);
			MainWindow.light2.setIcon(MainWindow.redLight);
			MainWindow.light3.setIcon(MainWindow.redLight);
			MainWindow.light4.setIcon(MainWindow.redLight);
						
		} else if (numerSygnalu == 2)
		{
			
			MainWindow.light1.setIcon(MainWindow.yellowLight);
			MainWindow.light2.setIcon(MainWindow.yellowLight);
			MainWindow.light3.setIcon(MainWindow.yellowLight);
			MainWindow.light4.setIcon(MainWindow.yellowLight);
			
		} else if (numerSygnalu == 3)
		{
			
			MainWindow.light1.setIcon(MainWindow.greenLight);
			MainWindow.light2.setIcon(MainWindow.greenLight);
			MainWindow.light3.setIcon(MainWindow.greenLight);
			MainWindow.light4.setIcon(MainWindow.greenLight);
			
		} else if (numerSygnalu == 4)
		{
			try
			{
				
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("dzwiek.wav"));
				Clip dzwiek = AudioSystem.getClip();
				dzwiek.open(audioIn);
				dzwiek.start();
				
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				
				e.printStackTrace();
				
			}
			
		}
		
		czasPojawienia = System.nanoTime();
		
	}
	
}
