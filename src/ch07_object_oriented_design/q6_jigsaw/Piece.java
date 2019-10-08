package ch07_object_oriented_design.q6_jigsaw;

public class Piece {
	private EdgeType upEdge;
	private EdgeType downEdge;
	private EdgeType leftEdge;
	private EdgeType rightEdge;

	private boolean complemented;

	private Piece upComp;
	private Piece downComp;
	private Piece leftComp;
	private Piece rightComp;

	public Piece(EdgeType upEdge, EdgeType downEdge, EdgeType rightEdge, EdgeType leftEdge) {

	}

	public EdgeType getUpEdge() {
		return upEdge;
	}

	public EdgeType getDownEdge() {
		return downEdge;
	}

	public EdgeType getLeftEdge() {
		return leftEdge;
	}

	public EdgeType getRightEdge() {
		return rightEdge;
	}

	public Piece getUpComp() {
		return upComp;
	}

	public void setUpComp(Piece upComp) {
		this.upComp = upComp;
	}

	public Piece getDownComp() {
		return downComp;
	}

	public void setDownComp(Piece downComp) {
		this.downComp = downComp;
	}

	public Piece getLeftComp() {
		return leftComp;
	}

	public void setLeftComp(Piece leftComp) {
		this.leftComp = leftComp;
	}

	public Piece getRightComp() {
		return rightComp;
	}

	public void setRightComp(Piece rightComp) {
		this.rightComp = rightComp;
	}

	public boolean isComplemented() {
		return complemented;
	}

	public void setComplemented(boolean complemented) {
		this.complemented = complemented;
	}

}
