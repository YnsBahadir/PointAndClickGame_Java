package Event;

import java.net.URL;
import java.util.Random;

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
	public void enterHut() {
		gm.sChanger.showScreen6();
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic=gm.tavernMain;
		gm.playMusic(gm.currentMusic);
	}
	public void restHut() {
		
		if((gm.player.lifeCounter==0)&&(gm.player.playerLife != gm.player.playerMaxLife)) {
			gm.ui.messageText.setText("You realize you have enough gold to rest in this Tavern.\n(Your life has recovered.)");
			gm.player.playerLife++;
			gm.player.lifeCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(gm.healSound);
		}
		else if((gm.player.lifeCounter!=0)&&(gm.player.playerLife != gm.player.playerMaxLife)) {
			gm.ui.messageText.setText("You rest at the Tavern. \n(Your life has recovered.)");
			gm.player.playerLife++;
			gm.player.lifeCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(gm.healSound);
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
		gm.ui.messageText.setText("Need Something?\n(Skyrim Creatur.)");
		gm.playSE(gm.guardLook);
	}
	public void talkKnight() {
		
//		ENG/Random Music Player Code - TR/Rastgele Müzik Oynatıcı		
		URL[] villagerSounds = {
			    gm.villagerAccept,
			    gm.villagerHard,
			    gm.villager3,
			    gm.villager4,
			    gm.villager5,
			    gm.villager6
			};

			Random rand = new Random();
			int index = rand.nextInt(villagerSounds.length);
			
		if(gm.player.knighttalkCounter == 0) {
			gm.ui.messageText.setText("Guard: Hello Adventurer!");
			gm.player.knighttalkCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(villagerSounds[index]);
		}
		else if (gm.player.knighttalkCounter == 1) {
			gm.ui.messageText.setText("Guard: Theres some Monster in the caves, please save the Village!");
			gm.player.knighttalkCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(villagerSounds[index]);
		}
		else if ((gm.player.hasSword==0)&&(gm.player.knighttalkCounter==2)) {
			gm.ui.messageText.setText("Guard: Please take the sword from the chest next to me with you.");
			gm.player.knighttalkCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(villagerSounds[index]);
		}
		else if ((gm.player.hasSword==1)&&(gm.player.knighttalkCounter==2)) {
			gm.ui.messageText.setText("Guard: I see you have already taken the sword.");
			gm.player.knighttalkCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(villagerSounds[index]);
		}
		else if ((gm.player.hasSword==1)&&(gm.player.knighttalkCounter>=3)) {
			gm.ui.messageText.setText("Guard: Now go and save the village!");
			
			gm.playSE(villagerSounds[index]);
		}
	}
	public void attackKnight() {
		if(gm.player.hasShield==0) {
			if(gm.player.hasSword==0) {
				if(gm.player.playerLife!=1) {
				gm.ui.messageText.setText("Guard: Hey, Don't be stupid!\n(Guard hit you back and your life decreases one.)");
				gm.player.playerLife--;
				gm.playSE(gm.hurtSound);
				}
				else if(gm.player.playerLife==1) {
					gm.ui.messageText.setText("Our hero's final act of stupidity was to go face to face with a fully equipped knight.");
					gm.player.playerLife--;
					gm.playSE(gm.hurtSound);
					gm.sChanger.showGameOverScreen(1);
				}
			}
			else if(gm.player.hasSword==1) {
				gm.ui.messageText.setText("Guard: What the ..!?(Sounds of punching in the back.)\nYou earned the knight's shield in an questionable duel.");
				gm.player.hasShield = 1;
				
				gm.playSE(gm.guardPunch);
			}
			gm.player.updatePlayerStatus();
		}
		else if((gm.player.hasShield==1)&&(gm.player.knightCounter==0)){
			gm.ui.messageText.setText("Guard: Just LEAVE ME ALONE!");
			gm.player.knightCounter++;
			gm.player.updatePlayerStatus();
			
			gm.playSE(gm.guardLeave);
		}
		else if((gm.player.hasShield==1)&&(gm.player.knightCounter==1)){
			gm.ui.messageText.setText("More punching sounds..");
			
			gm.playSE(gm.guardPunch);
		}
	}
//	ENG/Chest Interactions - TR/Sandık Etkileşimleri
	public void lookChest() {
		gm.ui.messageText.setText("This chest look like from another dimension.");
	}
	public void talkChest() {
		String[] chestMessages = {
			    "*Some Chest Sounds...*",
			    "*Some More Chest Sounds...*",
			    "*Some More More Chest Sounds...*",
			    "*Some More More More Chest Sounds...*",
			    "*Some More More More More Chest Sounds...*",
			    "*Some More More More More More Chest Sounds...*",
			    "*Some More More More More More More Chest Sounds...*"
			};

			if (gm.player.chestCounter < chestMessages.length) {
			    gm.ui.messageText.setText(chestMessages[gm.player.chestCounter]);
			    gm.player.chestCounter++;
			    gm.player.updatePlayerStatus();
			}
			else {
				gm.ui.messageText.setText("You realize this chest is actualy a mimic!\nBecause he enjoyed your talk so much, it gave you enough money to buy a Kingdom.");
				gm.sChanger.showMimicEnding();
				
				gm.stopMusic(gm.currentMusic);
				gm.currentMusic = gm.money;
				gm.playMusic(gm.currentMusic);
			}

	}
	public void openChest() {
		if(gm.player.hasSword==0) {
			gm.ui.messageText.setText("You found a Sword*.");
			gm.player.hasSword=1;
			gm.player.updatePlayerStatus();
			
			gm.playSE(gm.chestSound);
		}
		else {
			gm.ui.messageText.setText("There's nothing left inside in it.");
			
			gm.playSE(gm.chestSound);
		}
	}
}