package ch06_math_and_logic_puzzles.q9_poison.solution;

public class Bottle {
	private boolean isPoisoned = false;
	private int id;

	public Bottle(int id) {
		this.id = id;
	}

	public boolean isPoisoned() {
		return isPoisoned;
	}

	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
