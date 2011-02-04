package core;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GamePlayground extends GameObjects implements IGamePlayground
{
	protected JFrame frame						= new JFrame();

	public GamePlayground()
	{
		// Fenster schliessen
		GamePlayground.this.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//		this.frame.addWindowListener(new java.awt.event.WindowAdapter() {
//		    public void windowClosing(WindowEvent winEvt) {}
//		});	
	}

	public void closePlayground()
	{		
		GamePlayground.this.frame.setVisible( false );
		GamePlayground.this.game.closeEditor();
	}
	
	public void showPlayground() 
	{
		this.frame.setVisible( true );
	}
}
