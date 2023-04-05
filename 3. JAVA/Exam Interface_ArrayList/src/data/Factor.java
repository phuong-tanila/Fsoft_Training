package data;

public enum Factor {
	VUNG_MOT(1), VUNG_HAI(2), VUNG_BA(3), VUNG_BON(4), VUNG_NAM(5);

	private int value;

	private Factor(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
