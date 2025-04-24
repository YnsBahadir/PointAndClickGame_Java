package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	
	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		
		this.gm = gm;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice){
//			ENG/Scene 1 Intreactions - TR/Sahne 1 etkileşimleri
			case "lookHut": gm.ev1.lookHut(); break;
			case "enterHut": gm.ev1.enterHut(); break;
			case "restHut": gm.ev1.restHut(); break;
			
			case "lookKnight": gm.ev1.lookKnight(); break;
			case "talkKnight": gm.ev1.talkKnight(); break;
			case "attackKnight": gm.ev1.attackKnight(); break;
			
			case "lookChest": gm.ev1.lookChest(); break;
			case "talkChest": gm.ev1.talkChest(); break;
			case "openChest": gm.ev1.openChest(); break;
			
//			Eng/Scene 2 Intreactions - TR/Sahne 2 etkileşimleri 
			case "lookCave": gm.ev2.lookCave(); break;
			case "talkCave": gm.ev2.talkCave(); break;
			case "enterCave": gm.ev2.enterCave(); break;
			
			case "lookMiniCave": gm.ev2.lookMiniCave(); break;
			case "talkMiniCave": gm.ev2.talkMiniCave(); break;
			case "searchMiniCave": gm.ev2.searchMiniCave(); break;
			
//			ENG/Scene 3 Intreactions - TR/Sahne 3 etkileşimleri
			case "lookWolf": gm.ev3.lookWolf(); break;
			case "talkWolf": gm.ev3.talkWolf(); break;
			case "attackWolf": gm.ev3.attackWolf(); break;
			
//			ENG/Scene 4 Intreactions - TR/Sahne 4 etkileşimleri
			case "runMoon": gm.ev4.runMoon(); break;
			case "blockMoon": gm.ev4.blockMoon(); break;
			case "attackMoon": gm.ev4.attackMoon(); break;
			
//			ENG/Scene 6 Intreactions - TR/Sahne 6 etkileşimleri
			case "lookTable": gm.ev6.lookTable(); break;
			case "talkTable": gm.ev6.talkTable(); break;
			case "joinTable": gm.ev6.joinTable(); break;
			
			case "lookGirl": gm.ev6.lookGirl(); break;
			case "talkGirl": gm.ev6.talkGirl(); break;
			case "giftGirl": gm.ev6.giftGirl(); break;
			
//			ENG/Change Scene - TR/Sahne Değiştirme
			case "goScene1": gm.sChanger.showScreen1(); break;
			case "goScene2": gm.sChanger.showScreen2(); break;
			case "goScene6": gm.sChanger.showScreen6(); break;
			case "goScene9": gm.sChanger.showScreen9(); break;
			
			//Delete
			case "goScene4": gm.sChanger.showScreen4(); break;
			
//			ENG/Others - TR/Diğerleri
			case "restart": gm.sChanger.exitGameOverScreen(); gm.sChanger.showScreen1(); break;
		}
		
	}

}
