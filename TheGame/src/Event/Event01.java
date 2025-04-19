package Event;

import Main.GameManager;

public class Event01 {
	
	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void lookHut() {
		gm.ui.messageText.setText("This Hut should be Local Tavern. If I have enough coin, I can rest here.");
	}
	public void talkHut() {
		gm.ui.messageText.setText("What the hell am I doing..\nHuts can't talk, can they?");
	}
	public void restHut() {
		gm.ui.messageText.setText("You realize you have enough gold to rest in this Tavern.\n(Your life has recovered.)");
	}
	
	/*Knight mesajları*/

	public void lookKnight() {
		gm.ui.messageText.setText("Look Something?\n(Skyrim Creatur.)");
	}
	public void talkKnight() {
		gm.ui.messageText.setText("Guard: Don't go any further without weapon!");
	}
	public void attackKnight() {
		gm.ui.messageText.setText("Guard: Hey, Don't be stupid!");
	}		

	/*Sandık mesajları*/
	
	public void lookChest() {
		gm.ui.messageText.setText("This chest look like from another dimension.");
	}
	public void talkChest() {
		gm.ui.messageText.setText("*Some Chest Sounds...*");
	}
	public void openChest() {
		gm.ui.messageText.setText("You found a Sword*.");
	}
}