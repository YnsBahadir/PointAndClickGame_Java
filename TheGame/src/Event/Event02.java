package Event;

import Main.GameManager;

public class Event02 {
	
	public GameManager gm;
	
	public Event02(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void lookCave() {
		gm.ui.messageText.setText("It's a cave");
	}
	public void talkCave() {
		gm.ui.messageText.setText("You hear the echo of your voice.");
	}
	public void enterCave() {
		gm.ui.messageText.setText("It's too dark to enter.");
	}
	
	
	public void lookMiniCave() {
		gm.ui.messageText.setText("This place also looks like a cave, but it's smaller inside.");
	}
	public void talkMiniCave() {
		gm.ui.messageText.setText("How are you, little hole?\n(Of course there is no response.");
	}
	public void searchMiniCave() {
		gm.ui.messageText.setText("You found some old Lantern.*");
	}

}
