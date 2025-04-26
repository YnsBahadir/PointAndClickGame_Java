package Event;

import Main.GameManager;

public class Event09 {
	
	public GameManager gm;
	
	public Event09(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void lookBart() {
		
		gm.ui.messageText.setText("There is a bartender at the bar. Looks familiar.");
	}
	public void talkBart() {
		if(gm.player.bartCounter==0) {
			gm.ui.messageText.setText("Bartender: Do you know someone Ron, first name Mo?");
			gm.player.bartCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.bartCounter==1) {
			gm.ui.messageText.setText("Bartender: Do I know someone Ron, first name Mo?");
			gm.player.bartCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.bartCounter==2) {
			gm.ui.messageText.setText("Bartender: Wait a second... Mo... Ron...");
			gm.player.bartCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.bartCounter==3) {
			gm.ui.messageText.setText("Bartender: MORON!!!!\nBartender: Dang it that child messing with me again.");
			gm.player.bartCounter++;
			gm.player.updatePlayerStatus();
		}
		else if(gm.player.bartCounter>=4) {
			gm.ui.messageText.setText("Bartender: Anyway...\nBartender: Do you know someone Myass, firs name Eat?");
		}
	}
	public void buyBart() {
		if(gm.player.bartCounterBuy==0) {
			if(gm.player.hasCard==0) {
				gm.ui.messageText.setText("Bartender: We only sell dried meat, would you like to buy it?\nUnfortunately you don't have any money.");
				gm.player.bartCounterBuy++;
				gm.player.updatePlayerStatus();
			}
			else {
				gm.ui.messageText.setText("Bartender: We only sell dried meat, would you like to buy it?\nYou are lucky that the card you found(stole) has contactless payment.");
				gm.player.bartCounterBuy++;
				gm.player.updatePlayerStatus();
			}
		}
		else if(gm.player.bartCounterBuy==1) {
			if(gm.player.hasCard==0) {
			gm.ui.messageText.setText("Bartender: You don't have any money, did you?");
			}
			else {
				gm.ui.messageText.setText("Bartender: It costs 5.99\nYou: Why so cheap!?\nBartender: We don't live in Türkiye, do we?\nYou earned a Meat*");
				gm.player.hasCard = 0;
				gm.player.hasMeat = 1;
				gm.player.updatePlayerStatus();
			}
		}
	}
	public void lookSteve() {
		if(gm.player.steveCounter==1) {
			gm.ui.messageText.setText("A strange man is standing next to the bar.\nYou think his name is steve.");
		}
		else {
			gm.ui.messageText.setText("A strange man is standing next to the bar.");
		}
	}
	public void talkSteve() {
		gm.ui.messageText.setText("When you try to talk the only response you get is:\nI.. Am... STEVE...");
		
		gm.playSE(gm.iAmSteve);
		
		gm.player.steveCounter = 1;
		gm.player.updatePlayerStatus();
	}
}