package Event;

import Main.GameManager;

public class Event03 {
	
		public GameManager gm;
	
		public Event03(GameManager gm) {
		
		this.gm = gm;
		}
		
		public void lookWolf() {
			
			gm.ui.messageText.setText("What is a dog doing in a cave?");
			gm.playSE(gm.dogSound);
		}
		public void talkWolf() {

			gm.sChanger.showScreen4();
		}
		public void attackWolf() {
			
			gm.sChanger.showScreen4();
		}
}