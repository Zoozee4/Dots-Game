import java.util.*;
import java.io.*;

public class MainClass {
	public static void main(String [] args) {
		Controller object = new Controller();		

		while (object.gameover() != true)
		{
		object.grid.gridDisplay(object.getScale(), object.getMatrix());
		object.locator();
		}
	}
}
