/*BU Class Hub içindir,
 * diğer tüm sınıflar bu huba bağlı olacak
 * Important: Hocam Kendi Ellerimle Yazdım :)
 *
 * */

package Main;

import java.net.URL;

import Event.Event01;
import Event.Event02;

public class GameManager {

	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	Music music = new Music();
	SE se = new SE(); 
	
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	
//	Sounds
	public URL bossMusic = getClass().getClassLoader().getResource("audio//CuthuluBoss.wav");
	public URL gameOver = getClass().getClassLoader().getResource("audio//gameOver.wav");
	public URL iAmSteve = getClass().getClassLoader().getResource("audio//iAmSteve.wav");
	public URL itemFound = getClass().getClassLoader().getResource("audio//itemFound.wav");
	public URL fieldMusic = getClass().getClassLoader().getResource("audio//medAbbey.wav");
	public URL guardLeave = getClass().getClassLoader().getResource("audio//LeaveMePunch.wav");
	public URL chestSound = getClass().getClassLoader().getResource("audio//MinecraftChest.wav");
	public URL guardLook = getClass().getClassLoader().getResource("audio//needSomething.wav");
	public URL guardPunch = getClass().getClassLoader().getResource("audio//punchGame.wav");
	public URL healSound = getClass().getClassLoader().getResource("audio//SnoreCut.wav");
	public URL hurtSound = getClass().getClassLoader().getResource("audio//steveHurt.wav");
	public URL dogSound = getClass().getClassLoader().getResource("audio//wtDogDoin.wav");
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












