package Event;

import Main.GameManager;

public class Event04 {
	
	public GameManager gm;

	public Event04(GameManager gm) {
	
	this.gm = gm;
	}
	public void runMoon() {
		
		gm.ui.messageText.setText("Running away is not an option!");
	}
	public void blockMoon() {
		
		if(gm.player.hasShield==0) {
			if((gm.player.playerLife==1)||(gm.player.playerLife==2)) {
				gm.ui.messageText.setText("By the time our hero realized that his royal cotton suit was useless against the enemy, it was too late.");
				gm.player.playerLife-=2;
				gm.playSE(gm.hurtSound);
				gm.sChanger.showGameOverScreen(4);
			}
			else {
			gm.ui.messageText.setText("You took the damage directly.\n(Your life point decreases two.)");
			gm.playSE(gm.wolfSound);
			gm.player.playerLife -= 2;
			gm.player.updatePlayerStatus();
			}
		}
		else {
			gm.playSE(gm.wolfSound);
			gm.ui.messageText.setText("You successfully blocked the monster's attack.");
		}
	}
	public void attackMoon() {
		if((gm.player.hasSword==1)&&(gm.player.hasShield==1)) {
			gm.ui.messageText.setText("Your attack was very effective..");
			gm.sChanger.wolfDefeatScreen(4);
		}
		else if((gm.player.hasSword==1)&&(gm.player.hasShield==0)) {
			gm.ui.messageText.setText("You successfully defeated the monster, but what cost...");
			gm.sChanger.showScreen5();
		}
	}
}