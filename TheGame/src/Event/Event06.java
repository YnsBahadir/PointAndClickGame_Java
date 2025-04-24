package Event;

import Main.GameManager;

public class Event06 {
		
		public GameManager gm;
		
		public Event06(GameManager gm) {
			
			this.gm = gm;
		}
		public void lookTable() {
			
			gm.ui.messageText.setText("Some people play a game about lying there.");
		}
		public void talkTable() {
			
			gm.ui.messageText.setText("Player ?: Do you want to join?");
		}
		public void joinTable() {
	
			gm.ui.messageText.setText("You Die! :/ ");
		}
		
		public void lookGirl() {
			
			gm.ui.messageText.setText("A sad little girl is looking towards you.");
		}
		public void talkGirl() {
			
			gm.ui.messageText.setText("Little Girl: Have you seen my doggie?");
		}
		public void giftGirl() {
	
			gm.ui.messageText.setText("Yippie!");
		}
}
