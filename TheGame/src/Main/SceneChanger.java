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
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		gm.ui.messageText.setText("Let's go to Adventure!!");
		
		if(gm.currentMusic == gm.fieldMusic) {
			
		}
		else {
			gm.stopMusic(gm.currentMusic);
			gm.currentMusic=gm.fieldMusic;
			gm.playMusic(gm.currentMusic);
		}
	}
	public void showScreen2() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
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
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		gm.ui.messageText.setText("You enter the cave. What is waiting for you inside...");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.bossMusic;
		gm.playMusic(gm.currentMusic);
	}
	public void showScreen4() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.ashesOfWar;
		gm.playMusic(gm.currentMusic);
	}
	public void showScreen6() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(true);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		gm.ui.messageText.setText("Main Tavern");
	}
	public void showScreen9() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(true);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		gm.ui.messageText.setText("The Bar.");
	}
	public void showScreen10() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(true);
		gm.ui.bgPanel[11].setVisible(false);
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.bossMusic;
		gm.playMusic(gm.currentMusic);
	}
	public void showGameOverScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("YOU DIED");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.playSE(gm.gameOver);
	}
	
	public void wolfDefeatEnding(int currentBgNum) {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(true);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.playSE(gm.questComplete);
	}
	public void showEndingEgual() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(true);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.heroAndDogDeath;
		gm.playMusic(gm.currentMusic);
	}
	public void showMimicEnding() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(true);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(false);
		
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.playSE(gm.money);
	}
	public void showTrueEnding(int currentBgNum) {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.bgPanel[6].setVisible(false);
		gm.ui.bgPanel[7].setVisible(false);
		gm.ui.bgPanel[8].setVisible(false);
		gm.ui.bgPanel[9].setVisible(false);
		gm.ui.bgPanel[10].setVisible(false);
		gm.ui.bgPanel[11].setVisible(true);
		
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to Restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.playSE(gm.questComplete);
	}
	public void exitGameOverScreen() {
		
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefaultStatus();
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.fieldMusic;
		gm.playMusic(gm.currentMusic);
	}
}