import java.util.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Territory extends Polygon {

	private Player player;
	private Node path;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	public Territory(Node path, Player player){
		this.path = path;
		this.player = player;
	}

	public void checkPath(Grid grid) {

		boolean validTerritory = false;
		int minX = path.getSavedDot().getPosX();
		int minY = path.getSavedDot().getPosY();
		int maxX = path.getSavedDot().getPosX();
		int maxY = path.getSavedDot().getPosY();

		while (path != null) {

			addPoint(path.getSavedDot().getPosX(), path.getSavedDot().getPosY());

			if (path.getSavedDot().getPosX() < minX)
				minX = path.getSavedDot().getPosX();

			if (path.getSavedDot().getPosY() < minY)
				minY = path.getSavedDot().getPosY();

			if (path.getSavedDot().getPosX() > maxX)
				maxX = path.getSavedDot().getPosX();

			if (path.getSavedDot().getPosY() > maxY)
				maxY = path.getSavedDot().getPosY();

			path = path.getFather();
		}

		this.setBox(minX, minY, maxX, maxY);

		for (int y = minY; y <= maxY; y ++)
			for (int x = minX; x <= maxX; x ++)
			{
				if (this.contains(x, y) && grid.getDotsDisplay() [x][y] == ' ')
					validTerritory = true;
				else if (this.contains(x, y) && grid.getDotsDisplay() [x][y] != ' ' && grid.getDotsDisplay() [x][y] != player.getSymbol())
					validTerritory = true;
			}

		if (validTerritory)
			checkTerritory(this, grid);

	}

	public void checkTerritory(Territory territory, Grid grid) {

		boolean unclaimedTerritory = false;
		boolean claimedTerritory = false;

		for (int y = territory.getMinY(); y <= territory.getMaxY(); y ++)
			for (int x = territory.getMinX(); x <= territory.getMaxX(); x ++)
			{
				if (!claimedTerritory && !unclaimedTerritory && territory.contains(x, y) && grid.getDotsDisplay() [x][y] == ' ')
					unclaimedTerritory = true;
				else if (!claimedTerritory && territory.contains(x, y) && grid.getDotsDisplay() [x][y] != ' ' && grid.getDotsDisplay() [x][y] != player.getSymbol())
					claimedTerritory = true;
					unclaimedTerritory = false;
			}

		if (unclaimedTerritory)
			grid.getUnclaimedTerritories().add(territory);
		else if (claimedTerritory)
		{
			for (int y = territory.getMinY(); y <= territory.getMaxY(); y ++)
				for (int x = territory.getMinX(); x <= territory.getMaxX(); x ++)
				{
					if (territory.contains(x, y) && grid.getDotsDisplay() [x][y] == ' ')
						grid.addUnplayableSpace(x, y);
					else if (territory.contains(x, y) && grid.getDotsDisplay() [x][y] != ' ' && grid.getDotsDisplay() [x][y] != player.getSymbol())
						territory.getPlayer().addScore();
				}

			grid.getClaimedTerritories().add(territory);
		}
	}

	public void checkUnclaimedTerritories(Grid grid) {
		
		ArrayList<Territory> unclaimedTerritories = grid.getUnclaimedTerritories();
		boolean transfer = false;
		Iterator<Territory> iterator = unclaimedTerritories.iterator();
		Territory territory = null;

		while (iterator.hasNext()) {

			territory = iterator.next();

			for (int y = territory.getMinY(); y <= territory.getMaxY(); y ++)
				for (int x = territory.getMinX(); x <= territory.getMaxX(); x ++)
				{
					if (territory.contains(x, y) && grid.getDotsDisplay() [x][y] != ' ' && grid.getDotsDisplay() [x][y] != player.getSymbol())
						transfer = true;
				}

			if (transfer) {

				for (int y = territory.getMinY(); y <= territory.getMaxY(); y ++)
					for (int x = territory.getMinX(); x <= territory.getMaxX(); x ++)
					{
						if (territory.contains(x, y) && grid.getDotsDisplay() [x][y] == ' ')
							grid.addUnplayableSpace(x, y);
						else if (territory.contains(x, y) && grid.getDotsDisplay() [x][y] != ' ' && grid.getDotsDisplay() [x][y] != player.getSymbol())
							territory.getPlayer().addScore();
					}
				
				grid.getUnclaimedTerritories().remove(territory);
				grid.getClaimedTerritories().add(territory);
			}
		}
	}

	public void setPath(Node path) {
		this.path = path;
	}

	public Node getPath() {
		return path;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setBox(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}
}
