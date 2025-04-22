package Event;

import Main.GameManager;

public class Event03 {
	
		public GameManager gm;
	
		public Event03(GameManager gm) {
		
		this.gm = gm;
		}
		
		public void lookWolf() {
			
			gm.ui.messageText.setText("It's a Monster!");
		}
		public void talkWolf() {
			
			gm.ui.messageText.setText("Talking to a Monster is not a good idea.");
		}
		public void attackWolf() {
			
			gm.sChanger.showScreen4();
		}
}