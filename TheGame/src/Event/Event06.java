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
			if(gm.player.littleGirlCount==0) {
				gm.ui.messageText.setText("Little Girl: Excuse me sir.");
				gm.player.littleGirlCount++;
				gm.player.updatePlayerStatus();
			}
			else if(gm.player.littleGirlCount==1) {
				gm.ui.messageText.setText("Little Girl: Have you seen my doggie?");
				gm.player.littleGirlCount++;
				gm.player.updatePlayerStatus();
			}
			else if(gm.player.littleGirlCount==2) {
				gm.ui.messageText.setText("Little Girl: She must be hiding somewhere, hungry and scared.");
				gm.player.littleGirlCount++;
				gm.player.updatePlayerStatus();
			}
			else if(gm.player.littleGirlCount==3) {
				gm.ui.messageText.setText("Little Girl: If you see her, can you let me know?");
				gm.player.littleGirlCount++;
				gm.player.updatePlayerStatus();
			}
			else if(gm.player.littleGirlCount==4) {
				gm.ui.messageText.setText("More crying girl sounds*");
			}
		}
		public void giftGirl() {
			
			if(gm.player.hasWolf==1) {
				gm.sChanger.showTrueEnding(11);
				gm.ui.messageText.setText("Congratulations!\nYou reached the true ending of the game by bringing the monster to the little girl.!\nBaraya: I hope you enjoyed the game :3");
			}
			else {
				gm.ui.messageText.setText("You don't have any gift to give the little girl.");
			}
		}
}