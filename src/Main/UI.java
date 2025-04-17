package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class UI {
	
	GameManager gm;
	
	JFrame window;
	public JTextArea messageText;
	/*Alt kısımda array kullanıyorum çünkü backgrounları tek tek eklemekten daha işlevsel :/ */
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		generateScreen();
		
		window.setVisible(true);
		
	}
	
	public void createMainField() {
		 
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		messageText = new JTextArea("What the hell!?");
		messageText.setBounds(50,405,700,150);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		window.add(messageText);
		
	}
	public void createBackground(int bgNum, String bgFileName) {
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.green);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		
		
		
	}
	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
			String choice1Name, String choice2Name, String choice3Name, String  Choice1Command, String Choice2Command, String Choice3Command) {
		
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem menuItem[] = new JMenuItem[4]; //[1],[2],[3] kullanılacak 0 arada sorun çıkarıyor
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(Choice1Command);
		
		popMenu.add(menuItem[1]);
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(Choice2Command);
		
		popMenu.add(menuItem[2]);
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(Choice3Command);
		
		popMenu.add(menuItem[3]);
		
		
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objx, objy, objWidth, objHeight);
		
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);
		
		objectLabel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {	
				
				if(SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectLabel, e.getX(), e.getY());
				}
				
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {	}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		
		bgPanel[bgNum].add(objectLabel);
		bgPanel[bgNum].add(bgLabel[bgNum]);
		
	}
	public void generateScreen() {
		//Screen 1
		createBackground(1, "PanelTwo700.jpg");
		createObject(1, 450,50,200,200, "woodenshedP.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
		createObject(1, 48,55,200,300, "knight2x3.png", "Look", "Talk", "Attack", "lookKnight", "talkKnight", "attackKnight");
		createObject(1, 300,270,76,60, "chest76x60.png", "Look", "Talk", "Open", "lookChest", "talkChest", "openChest");
	}
}










