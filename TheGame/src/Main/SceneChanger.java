package Main;

public class SceneChanger {
	
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		
		this.gm = gm;
	}
	public void showScreen1() {
		
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.messageText.setText("Let's defeat the Demon and save the Town!");
	}
	public void showScreen2() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.messageText.setText("");
		
		if(gm.currentMusic == gm.bossMusic) {
			gm.stopMusic(gm.currentMusic);
			gm.currentMusic = gm.fieldMusic;
			gm.playMusic(gm.currentMusic);
		}
	}
	public void showScreen3() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.messageText.setText("You enter the cave. What is waiting for you inside...\n\n"
				+ "* This is the end of the DEMO. Thank you for playing. :3 *");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.bossMusic;
		gm.playMusic(gm.currentMusic);
	}
	public void showScreen4() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
		gm.ui.messageText.setText("I'm gonna KILL YOU!!");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.ashesOfWar;
		gm.playMusic(gm.currentMusic);
	}
	public void showGameOverScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("YOU DIED");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.gameOver;
		gm.playSE(gm.gameOver);
	}
	public void exitGameOverScreen() {
		
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefaultStatus();
		
		gm.currentMusic = gm.fieldMusic;
		gm.playMusic(gm.currentMusic);
	}
}