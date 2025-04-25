package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
//	ENG/Using array more functional more than added background one by one - TR/Alt kısımda array kullanıyorum çünkü backgrounları tek tek eklemekten daha işlevsel
	public JPanel bgPanel[] = new JPanel[15];
	public JLabel bgLabel[] = new JLabel[15];
	

//	Player UI	
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel swordLabel, shieldLabel, lanternLabel, meatLabel, wolfLabel, cardLabel;
	
	
//	GAME OVER UI
	public JLabel titleLabel;
	public JButton restartButton;
	
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createPlayerField();
		createGameOverField();
		generateScene();
		
		window.setVisible(true);
		
	}
	
	public void createMainField() {
		 
		window = new JFrame("Adventure Asylum I.");
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
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setLayout(null);
		bgPanel[bgNum].setVisible(false);
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		
	}
	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
			String choice1Name, String choice2Name, String choice3Name, String  Choice1Command, String Choice2Command, String Choice3Command) {
		
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem menuItem[] = new JMenuItem[4]; //[1],[2],[3] kullanılacak 0 arada sorun çıkarabiliyormuş.
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
		
		//Png Arka Plan görme Kodu
		objectLabel.setOpaque(false);
		objectLabel.setBackground(Color.green);
		
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
		
		
	}
	
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
			ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
			
			JButton arrowButton = new JButton();
			arrowButton.setBounds(x, y, width, height);
			arrowButton.setBackground(null);
			arrowButton.setContentAreaFilled(false);
			arrowButton.setFocusPainted(false);
			arrowButton.setIcon(arrowIcon);
			arrowButton.addActionListener(gm.aHandler);
			arrowButton.setActionCommand(command);
			arrowButton.setBorderPainted(false);
			
			bgPanel[bgNum].add(arrowButton);
	}
	
	public void createPlayerField() {
		
		lifePanel = new JPanel();
		lifePanel.setBounds(50, 0, 250, 50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1,5));
		window.add(lifePanel);
		
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("cHeart35x35.png"));
		
		/*Bu kısımda olması gerekenden büyük en-boy oranında bir resmi kod ile Scale ederek istediğim boyuta getiriyorum.
		Ama kullanılması tavsiye edilmiyor genel olarak gördüğüm kadarıyla. 
		Resim kalitesinin farkını kendi gözlerimle görüp 35x35 bir şekilde koymaya karar verdim. Aşağıdaki kod deneyim olması amacıyla yorum olarak bırakılmıştır. 
	
		Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lifeIcon = new ImageIcon(image);*/
		
		int i=1;
		while(i<6) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
		}
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(545, 0, 210, 50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,5));
		window.add(inventoryPanel);
		
		//Create Items 
		swordLabel = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("rBlade35x35.png"));
		swordLabel.setIcon(swordIcon);
		inventoryPanel.add(swordLabel); 
		
		shieldLabel = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("rShield35x35.png"));
		shieldLabel.setIcon(shieldIcon);
		inventoryPanel.add(shieldLabel);
		
		lanternLabel = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lFlame35x35.png"));
		lanternLabel.setIcon(lanternIcon);
		inventoryPanel.add(lanternLabel);
		
		meatLabel = new JLabel();
		ImageIcon meatIcon = new ImageIcon(getClass().getClassLoader().getResource("meat35x35.png"));
		meatLabel.setIcon(meatIcon);
		inventoryPanel.add(meatLabel);
		
		wolfLabel = new JLabel();
		ImageIcon wolfIcon = new ImageIcon(getClass().getClassLoader().getResource("wolfLove35x35.png"));
		wolfLabel.setIcon(wolfIcon);
		inventoryPanel.add(wolfLabel);
		
		cardLabel = new JLabel();
		ImageIcon cardIcon = new ImageIcon(getClass().getClassLoader().getResource("card35x35.png"));
		cardLabel.setIcon(cardIcon);
		inventoryPanel.add(cardLabel);
	}
	
	public void createGameOverField() {
		
		titleLabel = new JLabel("", JLabel.CENTER);
		titleLabel.setBounds(200, 150, 400, 200);
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 80));
		titleLabel.setVisible(false);
		window.add(titleLabel);
		
		restartButton = new JButton();
		restartButton.setBounds(340, 320, 120, 50);
		restartButton.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 3));
		restartButton.setBackground(Color.white);
		restartButton.setForeground(Color.black);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		window.add(restartButton);
	}
	public void generateScene() {
		
		//Scene 1
		createBackground(1, "PanelOne700.jpg");
		createObject(1, 450,50,200,200, "woodenshedP.png", "Look", "Enter", "Rest", "lookHut", "enterHut", "restHut");
		createObject(1, 90,55,120,300, "knight120x300.png", "Look", "Talk", "Attack", "lookKnight", "talkKnight", "attackKnight");
		createObject(1, 300,270,76,60, "chest76x60.png", "Look", "Talk", "Open", "lookChest", "talkChest", "openChest");
		createArrowButton(1, 0, 150, 50, 50, "leftArrow60x50HandMade.png", "goScene2");
		bgPanel[1].add(bgLabel[1]);
		
		//Scene 2 
		createBackground(2, "caveEnter700x350.jpg");
		createObject(2, 170,50,170,230, "blank100x100.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
		createObject(2, 450,130,90,120, "blank100x100.png", "Look", "Talk", "Search", "lookMiniCave", "talkMiniCave", "searchMiniCave");
		createArrowButton(2, 650, 150, 50, 50, "rightArrow60x50HandMade.png", "goScene1");
		bgPanel[2].add(bgLabel[2]);
		
		//Scene 3 
		createBackground(3, "Cave700x350.jpg");
		createArrowButton(3, 650, 150, 50, 50, "rightArrow60x50HandMade.png", "goScene2");
		createObject(3, 290,140,165,230, "wolfBack165x230.png", "Look", "Talk", "Scare", "lookWolf", "talkWolf", "attackWolf");
		bgPanel[3].add(bgLabel[3]);
		
		//Scene 4 ↸𝙹リℸ ̣ ∷⚍ リ
		createBackground(4, "Cave700x350.jpg");
		createObject(4, 170,50,355,315, "Moonless360x315.png", "Run","Block", "Attack", "runMoon", "blockMoon", "attackMoon");
		bgPanel[4].add(bgLabel[4]);
		
		//Scene 6
		createBackground(6, "taverna700x350.png");
		createArrowButton(6, 650, 150, 50, 50, "rightArrow60x50HandMade.png", "goScene9");
		createArrowButton(6, 320, 300, 50, 60, "downArrow50x60.png", "goScene1");
		createObject(6, 320,150,185,125, "liarTable185x125.png", "Look", "Talk", "Join", "lookTable", "talkTable", "joinTable");
		createObject(6, 135,170,91,180, "fearGirl91x180.png", "Look", "Talk", "Gift", "lookGirl", "talkGirl", "giftGirl");
		bgPanel[6].add(bgLabel[6]);
		
		//Scene 9
		createBackground(9, "tavernBar700x350.jpg");
		createArrowButton(9, 0, 150, 50, 50, "leftArrow60x50HandMade.png", "goScene6");
		createObject(9, 250,95,140,120, "bartender213x120.png", "Look","Talk", "Buy", "lookBart", "talkBart", "buyBart");
		bgPanel[9].add(bgLabel[9]);
		
		//Ending 5
		createBackground(5, "heroDeath350x350.jpg");
		bgLabel[5].setBounds(175, 0, 350, 350);
		bgPanel[5].add(bgLabel[5]);
		
		//Ending 7
		createBackground(7, "mimic465x360.jpg");
		bgLabel[7].setBounds(120, 0, 465, 360);
		bgPanel[7].add(bgLabel[7]);
		
		createBackground(8, "ending526x350.jpg");
		bgLabel[8].setBounds(120, 0, 465, 360);
		bgPanel[8].add(bgLabel[8]);
	}
}







