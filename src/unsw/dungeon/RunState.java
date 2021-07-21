package unsw.dungeon;

public class RunState implements EnemyState {

	@Override
	public EnemyState Run() {
		System.out.println("Run !!");
		return new RunState();
	}

	@Override
	public EnemyState Attack() {
		return new AttackState();
	}
	
}