package lightbeam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import core.Core;
import core.Game;
import custom.components.ImagePanel;

// Spiel "Lightbeam"
// Klasse Lightbeam entspricht dem Packagenamen,
// da der GameBuilder dies verlangt.
public class Lightbeam extends Game  
{
	// GUI Elemente:
	private JFrame frame 			= new JFrame();
	private ImagePanel panel		= null;

	// Konstruktor:
	public Lightbeam()
	{
		// Erzeugen des Map-Editors:
		this.createGUIMenu();
	}
	
	// Aufgerufen durch den GameBuilder ( ab hier belibt alles dem Programmierer �berlassen ):
	public void execute()					{ this.showGUIMenu();	}
	public String getName()					{ return "Lightbeam";	}
	public ImageIcon getIcon()				{ return new ImageIcon( "src/fx/Lightbeam/Icon/lightbeam.png" );	}
	
	private void createGUIMenu()
	{
		this.panel			= new ImagePanel( "./src/fx/Lightbeam/bg/laser.jpg" );
		
		this.frame.setTitle( "Hauptmen�" );
		this.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.frame.setAlwaysOnTop(true);
		this.frame.setLayout( new BorderLayout() );
		this.frame.setResizable( false );
		this.frame.setSize( 406, 200 );
//		Entfernt, siehe DefaultCloseOperation
//		this.frame.addWindowListener(new WindowAdapter(){
//			public void windowClosing( WindowEvent e ) {
//				Lightbeam.this.closeGUIMenu();
//			}
//		});

		this.panel.setSize( this.frame.getWidth(), this.frame.getHeight() );
		
		JButton playGame 	= new JButton( "Spiel spielen" );
		playGame.setContentAreaFilled( false );
		playGame.setBackground( new Color( 0, 0, 0, 25 ) );
		playGame.setForeground( new Color( 73, 185, 66, 255 ) );
		playGame.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		playGame.setBounds( 10 , 15, 200, 40 );
		playGame.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e) 
		{
			Lightbeam.this.closeGUIMenu();
		}});		

		JButton createGame	= new JButton( "Spiel erstellen" );
		createGame.setContentAreaFilled( false );
		createGame.setBackground( new Color( 0, 0, 0, 25 ) );
		createGame.setForeground( new Color( 73, 185, 66, 255 ) );
		createGame.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		createGame.setBounds( 10 , 60, 200, 40 );
		createGame.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e) 
		{
			Lightbeam.this.closeGUIMenu();
			Lightbeam.this.openEditor();
		}});
		
		JButton closeGame	= new JButton( "Beenden" );
		closeGame.setContentAreaFilled( false );
		closeGame.setBackground( new Color( 0, 0, 0, 25 ) );
		closeGame.setForeground( new Color( 73, 185, 66, 255 ) );
		closeGame.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		closeGame.setBounds( 10 , 105, 200, 40 );
		closeGame.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e) 
		{
			Lightbeam.this.closeGUIMenu();
			Core.showScreener();
			
		}});
		
		this.panel.add( playGame, null );
		this.panel.add( createGame, null );
		this.panel.add( closeGame, null );
		
		this.frame.add( panel, BorderLayout.CENTER );
		
		// Screener mittig anzeigen:
	}
	
	public void closeEditor()
	{
		this.showGUIMenu();
	}
	
	private void showGUIMenu()
	{
		// Screener mittig anzeigen:
		this.frame.setLocationRelativeTo( null );
		this.frame.setVisible( true );		
		this.frame.setFocusable( true );
	}
	
	private void closeGUIMenu()	{ this.frame.setVisible( false );	}	
}