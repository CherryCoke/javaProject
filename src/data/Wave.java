package data;

import java.util.ArrayList;
import static helpers.Clock.*;

public class Wave {
	/*
	 * Class to manage the spawn of waves/enemies in a wave
	 */
	
	//Declaring class variables
	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		
		//Initializing class variables
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;

		// For the first spawn the time since last spawn will be zero
		timeSinceLastSpawn = 0;

		// Initializes enemy list
		enemyList = new ArrayList<Enemy>();
		
		//Spawn first enemy instantly/as soon as the game starts
		Spawn();	
	}

	public void Update() {
		// Keep track of time since last spawn using Delta time
		timeSinceLastSpawn += Delta();

		// If time since last spawn is greater than the time between spawns
		if (timeSinceLastSpawn > spawnTime) {
			// Spawn an enemy
			Spawn();
			timeSinceLastSpawn = 0; // Reset timeSinceLastSpawn
		}

		for (Enemy e : enemyList) {
			// Only if the enemy is alive:
			if (e.isAlive()) {
				// For every enemy (e) in EnemyList
				e.Update();
				e.Draw();
			}
		}
	}

	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getTileGrid(), 64, 64, enemyType
				.getSpeed()));
	}

}
