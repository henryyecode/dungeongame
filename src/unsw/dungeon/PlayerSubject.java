package unsw.dungeon;

public interface PlayerSubject {
	public void addEnemy(Enemy E);
	public void removeEnemy(Enemy E);
	public void notifyEnemies();
}
