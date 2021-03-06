package gameWorld;

import java.util.Random;

import gameobjects.*;
import libraries.Vector2;
import monsters.Monstre;
import monsters.Monstre.MONSTER_TYPE;
import resources.*;

public class MonsterRoom extends Room {
    private boolean hasFinishedCalled = false;

    // Initialise une salle avec des monstres aléatoires
    public MonsterRoom(Hero hero) {
        super(hero);

        StaticEntities
                .add(new StaticEntity(RoomInfos.positionFromTileIndex(2, 5), RoomInfos.TILE_SIZE, ImagePaths.ROCK));
        StaticEntities
                .add(new StaticEntity(RoomInfos.positionFromTileIndex(3, 8), RoomInfos.TILE_SIZE, ImagePaths.ROCK));
        StaticEntities
                .add(new StaticEntity(RoomInfos.positionFromTileIndex(7, 5), RoomInfos.TILE_SIZE, ImagePaths.ROCK));
        StaticEntities
                .add(new StaticEntity(RoomInfos.positionFromTileIndex(5, 3), RoomInfos.TILE_SIZE, ImagePaths.ROCK));

        for (int i = 0; i < 4; i++) {
            int monstre = new Random().nextInt(2);
            if (monstre == 1) {
                monstres.add(Monstre.CreateMonster(new Vector2(0.5, 0.5), MONSTER_TYPE.FLY));
            } else {
                monstres.add(Monstre.CreateMonster(new Vector2(0.5, 0.5), MONSTER_TYPE.SPIDER));
            }
        }
    }

    @Override
    public void updateRoom() {
        super.updateRoom();
        if (roomFinished && !hasFinishedCalled) {
            hasFinishedCalled = true;
            ObjectPickable
                    .add(new ObjectOnGround(new Vector2(0.4, 0.5), RoomInfos.HALF_TILE_SIZE, ImagePaths.COIN));
            ObjectPickable
                    .add(new ObjectOnGround(new Vector2(0.6, 0.5), RoomInfos.HALF_TILE_SIZE, ImagePaths.NICKEL));
            ObjectPickable
                    .add(new ObjectOnGround(new Vector2(0.5, 0.6), RoomInfos.HALF_TILE_SIZE, ImagePaths.DIME));
            ObjectPickable
                    .add(new ObjectOnGround(new Vector2(0.5, 0.4), RoomInfos.HALF_TILE_SIZE, ImagePaths.HEART_PICKABLE));
        }
    }
}
