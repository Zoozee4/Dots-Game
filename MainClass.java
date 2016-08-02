import java.util.*;
import java.io.*;

public class MainClass {
	public static void main(String [] args) {
		Controller object = new Controller();		

		while (object.gameover == false)
		{
		object.grid.gridDisplay(object.scale, object.dotsDisplay);
		object.locator();
		object.gameover = object.gameover();
		}
	}
}
