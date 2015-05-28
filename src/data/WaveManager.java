package data;

public class WaveManager {

	/*
	  Handles/Initiates all code related to the spawning of 
	  waves/enemies in waves
	 */
	
	//Setting class variables
	private float timeSinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy enemyType;
	private Wave currentWave;
	
	
	public WaveManager(Enemy enemyType, float timeBetweenEnemies, 
				int enemiesPerWave) {
			
			//Initializing class variables
			this.enemyType = enemyType;
			this.enemiesPerWave = enemiesPerWave;
			this.timeSinceLastWave = 0;
			this.waveNumber = 0; //Always will start on Wave 0
			this.timeBetweenEnemies = timeBetweenEnemies;
			
			this.currentWave = null; //Just to start off
			
			newWave(); 
			
	}
	
	public void update(){
		//If wave is not done, continue to update
		if (!currentWave.isCompleted()){ //! is not
			currentWave.Update();
		}
		
		else 
			newWave();
	}
	
	private void newWave(){
		
		currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave);
		waveNumber++; //Add one to the current wave
		System.out.println("Beginning Wave " + waveNumber);//Give current wave
	}
	
	public Wave getCurrentWave() {
		return currentWave;
	}
}
