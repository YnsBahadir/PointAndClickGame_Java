/*BU Class Hub içindir,
 * diğer tüm sınıflar bu huba bağlı olacak
 * Important: Hocam Kendi Ellerimle Yazdım :)
 *
 * */

package Main;

import java.net.URL;

import Event.Event01;
import Event.Event02;
import Event.Event03;
import Event.Event04;
import Event.Event06;
import Event.Event09;

public class GameManager {

	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	Music music = new Music();
	SE se = new SE(); 
	
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	public Event03 ev3 = new Event03(this);
	public Event04 ev4 = new Event04(this);
	public Event06 ev6 = new Event06(this);
	public Event09 ev9 = new Event09(this);
	
//	Sounds
	public URL ashesOfWar = getClass().getClassLoader().getResource("audio/AshesOfWar2.wav");
	public URL bossMusic = getClass().getClassLoader().getResource("audio/CuthuluBoss.wav");
	public URL gameOver = getClass().getClassLoader().getResource("audio/gameOver.wav");
	public URL heroAndDogDeath = getClass().getClassLoader().getResource("audio/heroDeathMusic.wav");
	public URL iAmSteve = getClass().getClassLoader().getResource("audio/iAmSteve.wav");
	public URL itemFound = getClass().getClassLoader().getResource("audio/itemFound.wav");
	public URL fieldMusic = getClass().getClassLoader().getResource("audio/medAbbey.wav");
	public URL guardLeave = getClass().getClassLoader().getResource("audio/LeaveMePunch.wav");
	public URL liarMusic = getClass().getClassLoader().getResource("audio/liarMusic.wav");
	public URL chestSound = getClass().getClassLoader().getResource("audio/MinecraftChest.wav");
	public URL money = getClass().getClassLoader().getResource("audio/money.wav");
	public URL guardLook = getClass().getClassLoader().getResource("audio/needSomething.wav");
	public URL guardPunch = getClass().getClassLoader().getResource("audio/punchGame.wav");
	public URL questComplete = getClass().getClassLoader().getResource("audio/questComplete.wav");
	public URL trueEndSound = getClass().getClassLoader().getResource("audio/seeYou.wav");
	public URL healSound = getClass().getClassLoader().getResource("audio/SnoreCut.wav");
	public URL hurtSound = getClass().getClassLoader().getResource("audio/steveHurt.wav");
	public URL tavern1 = getClass().getClassLoader().getResource("audio/tavern1.wav");
	public URL tavern2 = getClass().getClassLoader().getResource("audio/tavern2.wav");
	public URL tavern3 = getClass().getClassLoader().getResource("audio/tavern3.wav");
	public URL tavern4 = getClass().getClassLoader().getResource("audio/tavern4.wav");
	public URL tavernMain = getClass().getClassLoader().getResource("audio/tavernMain.wav");
	public URL villagerHard = getClass().getClassLoader().getResource("audio/vilagerHard.wav");
	public URL villager3 = getClass().getClassLoader().getResource("audio/villager3.wav");
	public URL villager4 = getClass().getClassLoader().getResource("audio/villager4.wav");
	public URL villager5 = getClass().getClassLoader().getResource("audio/villager5.wav");
	public URL villager6 = getClass().getClassLoader().getResource("audio/villager6.wav");
	public URL villagerAccept = getClass().getClassLoader().getResource("audio/villagerAccept.wav");
	public URL wolfSound = getClass().getClassLoader().getResource("audio/WolfSound.wav");
	public URL dogSound = getClass().getClassLoader().getResource("audio/wtDogDoin.wav");
	public URL currentMusic;
	
	public static void main(String[] args) {
		
		new GameManager();
	
	}
	public GameManager() {
		
		currentMusic = fieldMusic;
		playMusic(currentMusic);
		
		player.setPlayerDefaultStatus();
		sChanger.showScreen1();
	}
	public void playSE(URL url) {
		
		se.setFile(url);
		se.play(url);
	}
	public void playMusic(URL url) {
		
		music.setFile(url);
		music.play(url);
		music.loop(url);
	}
	public void stopMusic(URL url) {
		
		music.stop(url);
	}
}