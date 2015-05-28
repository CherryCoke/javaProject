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
	private boolean waveCompleted;

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		
		//Initializing class variables
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;

		// For the first spawn the time since last spawn will be zero
		this.timeSinceLastSpawn = 0;

		// Initializes enemy list
		this.enemyList = new ArrayList<Enemy>();
		this.waveCompleted = false; //be default it is set to zero
		
		//Spawn first enemy instantly/as soon as the game starts
		Spawn();	
	}

	public void Update() {
		
		boolean allEnemiesDead = true; //by default enemies have no spawned
		
		if (enemyList.size() < enemiesPerWave){
		
		// Keep track of time since last spawn using Delta time
		timeSinceLastSpawn += Delta();

		// If time since last spawn is greater than the time between spawns
		if (timeSinceLastSpawn > spawnTime) {
			// Spawn an enemy
			Spawn();
			timeSinceLastSpawn = 0; // Reset timeSinceLastSpawn
		}
		}

		for (Enemy e : enemyList) {
			// Only if the enemy is alive:
			if (e.isAlive()) {
				//If an enemy is alive update allEnemiesDead
				allEnemiesDead = false;
				
				// For every enemy (e) in EnemyList
				e.Update();
				e.Draw();
			}
		}
		
		/*
		 When all enemies from a wave are dead, mark as true that that wave is
		 completed.
		 */
		if (allEnemiesDead)
			waveCompleted = true;
	}

	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getTileGrid(), 64, 64, enemyType
				.getSpeed()));
	}
	
	public boolean isCompleted(){
		return waveCompleted;
	}
	
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

}
