package gameWorld;

import java.util.ArrayList;
import java.util.List;

import gameobjects.*;
import libraries.StdDraw;
import resources.Controls;
import resources.HeroInfos;
import resources.RoomInfos;

public class GameWorld
{
	private Room currentRoom;
	private Hero hero;
	private List<Tear> Tears = new ArrayList<Tear>();

	// A world needs a hero
	public GameWorld(Hero hero)
	{
		this.hero = hero;
		currentRoom = new Room(hero);
	}

	public void processUserInput()
	{
		processKeysForMovement();
		processKeysForShooting();
	}

	public boolean gameOver()
	{
		return false;
	}

	public void updateGameObjects()
	{
		currentRoom.updateRoom();
	}
	
	public void processPhysics() {
		currentRoom.processPhysics();
	}

	public void drawGameObjects()
	{
		currentRoom.drawRoom();
	}

	/*
	 * Keys processing
	 */

	private void processKeysForMovement()
	{
		if (StdDraw.isKeyPressed(Controls.goUp))
		{
			hero.goUpNext();
		}
		if (StdDraw.isKeyPressed(Controls.goDown))
		{
			hero.goDownNext();
		}
		if (StdDraw.isKeyPressed(Controls.goRight))
		{
			hero.goRightNext();
		}
		if (StdDraw.isKeyPressed(Controls.goLeft))
		{
			hero.goLeftNext();
		}
	}

	private void processKeysForShooting()
	{
		if (StdDraw.isKeyPressed(Controls.shootUp))
		{
			Tear tear = new Tear(hero.getPosition(), HeroInfos.ISAAC_SIZE, HeroInfos.ISAAC_SPEED, "images/tear.png");
			Tears.add(tear);
			tear.shootUpNext();
		}
		if (StdDraw.isKeyPressed(Controls.shootDown))
		{
			Tear tear = new Tear(hero.getPosition(), HeroInfos.ISAAC_SIZE, HeroInfos.ISAAC_SPEED, "images/tear.png");
			Tears.add(tear);
			tear.shootDownNext();
		}
		if (StdDraw.isKeyPressed(Controls.shootRight))
		{
			Tear tear = new Tear(hero.getPosition(), HeroInfos.ISAAC_SIZE, HeroInfos.ISAAC_SPEED, "images/tear.png");
			Tears.add(tear);
			tear.shootRightNext();
		}
		if (StdDraw.isKeyPressed(Controls.shootLeft))
		{
			Tear tear = new Tear(hero.getPosition(), HeroInfos.ISAAC_SIZE, HeroInfos.ISAAC_SPEED, "images/tear.png");
			Tears.add(tear);
			tear.shootLeftNext();
		}

		if (Tears != null) {
			for (Tear larme : Tears) {
				if (larme != null)
					larme.drawGameObject();
					larme.updateGameObject();
			}
		}
	}
}
