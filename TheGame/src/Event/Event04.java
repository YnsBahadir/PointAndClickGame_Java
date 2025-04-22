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
	public void guardMoon() {
		
		if(gm.player.hasShield==0) {
			gm.ui.messageText.setText("I don't have any Shield!");
		}
		else {
			gm.playSE(gm.wolfSound);
			gm.ui.messageText.setText("You successfully blocked the monster's attack.");
		}
	}
	public void attackMoon() {
		
		gm.ui.messageText.setText("The monster took damage.");
	}
}