package Main;

public class Player {
	
	GameManager gm;
	
	public int lifeCounter;
	public int knightCounter;
	public int knighttalkCounter;
	public int chestCounter;
	public int bartCounter;
	public int bartCounterBuy;
	public int littleGirlCount;
	
	public int playerMaxLife;
	public int playerLife;
	
	public int hasSword;
	public int hasShield;
	public int hasLantern;
	public int hasMeat;
	public int hasWolf;
	public int hasCard;
	
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
		hasMeat = 0;
		hasWolf = 0;
		hasCard = 0;
		
		lifeCounter = 0;
		knightCounter = 0;
		knighttalkCounter = 0;
		chestCounter = 0;
		bartCounter = 0;
		bartCounterBuy = 0;
		littleGirlCount = 0;
		
		
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
		
		
		if(hasMeat==0) {
			gm.ui.meatLabel.setVisible(false);
		}
		if(hasMeat==1) {
			gm.ui.meatLabel.setVisible(true);
		}
		
		
		if(hasWolf==0) {
			gm.ui.wolfLabel.setVisible(false);
		}
		if(hasWolf==1) {
			gm.ui.wolfLabel.setVisible(true);
		}
		
		
		if(hasCard==0) {
			gm.ui.cardLabel.setVisible(false);
		}
		if(hasCard==1) {
			gm.ui.cardLabel.setVisible(true);
		}
	}
	
}