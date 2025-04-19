package Main;

public class SceneChanger {
	
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void showScreen1() {
		
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.messageText.setText("Let's defeat the Demon and save the Town!");
	}
	
	public void showScreen2() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.messageText.setText("So this is Scene 2, HUH! ");
	}
}
