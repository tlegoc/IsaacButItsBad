package gameWorld;

import gameobjects.*;
import resources.*;

public class StartRoom extends Room {

	public StartRoom(Hero hero,String type) {
		super(hero, type);

		StaticEntities.add(new StaticEntity(positionFromTileIndex(5, 5), RoomInfos.TILE_SIZE, ImagePaths.ROCK));
		StaticEntities.add(new StaticEntity(positionFromTileIndex(4, 6), RoomInfos.TILE_SIZE, ImagePaths.ROCK));
	}

}
