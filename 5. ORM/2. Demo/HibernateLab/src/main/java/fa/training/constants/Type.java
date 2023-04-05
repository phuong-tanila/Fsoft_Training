package fa.training.constants;

public enum Type {
	LONG(120), MEDIUM(60), SHORT(30);

	private final int estimateTime;

	private Type(int estimateTime) {
		this.estimateTime = estimateTime;
	}

	public int getEstimateTime() {
		return estimateTime;
	}
}
