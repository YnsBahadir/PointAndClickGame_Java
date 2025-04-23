package Main;

public class Player {
	
	GameManager gm;
	
	public int lifeCounter;
	public int knightCounter;
	public int knighttalkCounter;
	public int talkOrScare;
	
	public int playerMaxLife;
	public int playerLife;
	
	public int hasSword;
	public int hasShield;
	public int hasLantern;
	
	public Player(GameManager gm) {
		this.gm = gm;
	}
	
	public void setPlayerDefaultStatus() {
		
//		Bu kısım ne zaman karakterin statlarını sıfırlamak istersem kullanmam için.
		playerMaxLife = 5;
		playerLife = 3;
		hasSword = 0;
		hasShield = 0;
		hasLantern = 0;
		
		lifeCounter = 0;
		knightCounter = 0;
		knighttalkCounter = 0;
		
		talkOrScare = 0;
		
		updatePlayerStatus();
	}
	
	public void updatePlayerStatus() {
		
//		ENG/Remove all life Icons - TR/Tüm Can Icon'larını kaldır
		int i = 1;
		while(i<6) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		
		int lifeCount = playerLife;
		while(lifeCount!=0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
		}
		
//		ENG/Check Player items - TR/Oyuncunun itemlerini kontrol et
		if(hasSword==0) {
			gm.ui.swordLabel.setVisible(false);
		}
		if(hasSword==1) {
			gm.ui.swordLabel.setVisible(true);
		}
		
		
		if(hasShield==0) {
			gm.ui.shieldLabel.setVisible(false);
		}
		if(hasShield==1) {
			gm.ui.shieldLabel.setVisible(true);
		}
		
		
		if(hasLantern==0) {
			gm.ui.lanternLabel.setVisible(false);
		}
		if(hasLantern==1) {
			gm.ui.lanternLabel.setVisible(true);
		}
	}
	
}
