package unsw.dungeon;

public class SwitchOn implements SwitchState {

	@Override
	public SwitchState activateSwitchState() {
		//System.out.println("Switch ON");
		return new SwitchOn();
	}

	@Override
	public SwitchState deactivateSwitchState() {
		//System.out.println("Switch OFF");
		return new SwitchOff();
	}
	
}
