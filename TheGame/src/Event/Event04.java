package Event;

import Main.GameManager;

public class Event04 {
	
	public GameManager gm;

	public Event04(GameManager gm) {
	
	this.gm = gm;
	}
	public void runMoon() {
		if((gm.player.hasSword==0)&&(gm.player.hasMeat==0)) {
			gm.ui.messageText.setText("By the time hero realized that facing the monster barehanded was a mistake, it was too late.");
			gm.sChanger.showGameOverScreen(4);
		}
		else {
			gm.ui.messageText.setText("Running away is not an option!");
		}
	}
	public void blockMoon() {
		
		if(gm.player.hasMeat==0) {
			gm.ui.messageText.setText("You have nothing to distract the monster. ");
		}
		else {
			gm.ui.messageText.setText("You realized that the monster was very friendly for some reason when you gave her food to distract her.\nThe monster started chasing you*");
			gm.player.hasWolf = 1;
			gm.player.hasMeat = 0;
			gm.player.updatePlayerStatus();
			
			gm.sChanger.showScreen10();
		}
	}
	public void attackMoon() {
		if((gm.player.hasSword==1)&&(gm.player.hasShield==1)) {
			gm.ui.messageText.setText("Thanks to your difficult journey all the way here (attacking the Knight from behind), you saved the village!");
			gm.sChanger.wolfDefeatEnding(4);
		}
		else if((gm.player.hasSword==1)&&(gm.player.hasShield==0)) {
			if(gm.player.playerLife==1) {
				gm.stopMusic(gm.currentMusic);
				gm.currentMusic = gm.heroAndDogDeath;
				gm.playMusic(gm.currentMusic);
				gm.ui.messageText.setText("You defeated the monster, It cost your life but it's worth now the village is safe.\nRest in Peace");
				gm.sChanger.showEndingEgual();
			}
			else {
				gm.player.playerLife--;
				gm.player.updatePlayerStatus();
				gm.playSE(gm.wolfSound);
				gm.ui.messageText.setText("You deal damage to your opponent in exchange for taking damage!");
			}
		}
		else if(gm.player.hasSword==0) {
			gm.ui.messageText.setText("You have no weapons to attack with!");
		}
	}
}