package Event;

import java.util.Random;

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
			if(gm.player.liarCounter2==1) {
				gm.ui.messageText.setText("Dead people can't talk..");
				gm.ui.messageText.setText("You see the bodies of those at the table being renewed.\nFoxy: If you want to play another hand, we're here.");
				gm.player.liarCounter2 = 2;
				gm.player.updatePlayerStatus();
			}
			else if(gm.player.liarCounter2==2){
				gm.ui.messageText.setText("You think it's not a good idea to talk to the crazy people at this table.\nSometimes you must forget the Gothic...");
			}
			else {
				if(gm.player.liarCounter==0) {
					gm.ui.messageText.setText("Foxy: Oh Hi, I guess you're new around here.\nFoxy: Do you wanna join the table?.");
					
					gm.player.liarCounter = 1;
					gm.player.updatePlayerStatus();
				}
				else if(gm.player.liarCounter==1) {
					gm.ui.messageText.setText("Toar: Look at the rookie. Did you change the diaper? Cuz you need that!\nScubby: Hey, nobody wants to come to our table because you act like that!");
					
					gm.player.liarCounter = 2;
					gm.player.updatePlayerStatus();
				}
				else if(gm.player.liarCounter==2) {
					gm.ui.messageText.setText("Foxy: Anyway, all you need to join us is good lying skills.");
					
					gm.player.liarCounter = 3;
					gm.player.updatePlayerStatus();
				}
				else if(gm.player.liarCounter==3) {
					gm.ui.messageText.setText("Foxy: Do you want to join or not?");
				}
			}
		}
		public void joinTable() {
			
			Random random = new Random();
	        int randomNumber = random.nextInt(5);
			if(gm.player.liarCounter2==0) {
				if(randomNumber==4) {
					gm.ui.messageText.setText("Congratulations, you WON!\nBut how did it feel to be the winner in a game where everyone else died?");
	        		gm.player.liarCounter2 = 1;
	        		gm.player.updatePlayerStatus();
	        	}
	        	else {
	        		gm.sChanger.showLiarEnd(12);
	        		gm.ui.messageText.setText("When you realized that it was all a game everyone was playing on his head, it was too late.\nBut who could say no to a Gothic girl?");
	        		
	        		gm.stopMusic(gm.currentMusic);
	        		gm.currentMusic = gm.liarMusic;
	        		gm.playMusic(gm.currentMusic);	
	        	}
			}
			else {
				gm.ui.messageText.setText("Is it really a good idea to join a table where everyone is dead?");
			}
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