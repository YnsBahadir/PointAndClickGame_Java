package Event;

import Main.GameManager;

public class Event01 {
	
	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
	}
	
//	ENG/Hut Interactions - TR/Kulübe Etkileşimleri
	public void lookHut() {
		gm.ui.messageText.setText("This Hut should be Local Tavern. If I have enough coin, I can rest here.");
	}
	public void talkHut() {
		gm.ui.messageText.setText("What the hell am I doing..\nHuts can't talk, can they?");
	}
	public void restHut() {
		
		if((gm.player.lifeCounter==0)&&(gm.player.playerLife != gm.player.playerMaxLife)) {
			gm.ui.messageText.setText("You realize you have enough gold to rest in this Tavern.\n(Your life has recovered.)");
			gm.player.playerLife++;
			gm.player.lifeCounter++;
			gm.player.updatePlayerStatus();	
		}
		else if((gm.player.lifeCounter!=0)&&(gm.player.playerLife != gm.player.playerMaxLife)) {
			gm.ui.messageText.setText("You rest at the Tavern. \n(Your life has recovered.)");
			gm.player.playerLife++;
			gm.player.lifeCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.lifeCounter==6) {
			gm.ui.messageText.setText("Creater: You're a lazy one, huh?");
			gm.player.lifeCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.lifeCounter==7) {
			gm.ui.messageText.setText("Creater: Can't you do something heroic?");
		}
		else {
			gm.ui.messageText.setText("Your Life is full.");
			gm.player.lifeCounter++;
		}
	}
	
//	ENG/Knight Interactions - TR/Şovalye Etkileşimleri
	public void lookKnight() {
		gm.ui.messageText.setText("Look Something?\n(Skyrim Creatur.)");
	}
	public void talkKnight() {
		gm.ui.messageText.setText("Guard: Don't go any further without weapon!");
	}
	public void attackKnight() {
		if(gm.player.hasShield==0) {
			if(gm.player.hasSword==0) {
				if(gm.player.playerLife!=1) {
				gm.ui.messageText.setText("Guard: Hey, Don't be stupid!\n(Guard hit you back and your life decreases one.)");
				gm.player.playerLife--;
				}
				else if(gm.player.playerLife==1) {
					gm.ui.messageText.setText("Guard: What a fool one...");
					gm.player.playerLife--;
					gm.sChanger.showGameOverScreen(1);
				}
			}
			else if(gm.player.hasSword==1) {
				gm.ui.messageText.setText("Guard: What the ..!?(Sounds of stabbing in the back.)\nYou earned the knight's shield in an questionable duel.");
				gm.player.hasShield = 1;
			}
			gm.player.updatePlayerStatus();
		}
		else if((gm.player.hasShield==1)&&(gm.player.knightCounter==0)){
			gm.ui.messageText.setText("Guard: Just LEAVE ME ALONE!");
			gm.player.knightCounter++;
			gm.player.updatePlayerStatus();
		}
		else if((gm.player.hasShield==1)&&(gm.player.knightCounter==1)){
			gm.ui.messageText.setText("More stabbing sounds..");
		}
	}

//	ENG/Chest Interactions - TR/Sandık Etkileşimleri
	public void lookChest() {
		gm.ui.messageText.setText("This chest look like from another dimension.");
	}
	public void talkChest() {
		gm.ui.messageText.setText("*Some Chest Sounds...*");
	}
	public void openChest() {
		if(gm.player.hasSword==0) {
			gm.ui.messageText.setText("You found a Sword*.");
			gm.player.hasSword=1;
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("There's nothing left inside in it.");
		}
		
	}
}