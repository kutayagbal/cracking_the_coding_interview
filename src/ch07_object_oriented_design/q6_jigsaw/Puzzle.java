package ch07_object_oriented_design.q6_jigsaw;

import java.util.HashSet;
import java.util.Set;

public class Puzzle {
	Set<Piece> usedPieces;
	Set<Piece> unUsedPieces;

	public Puzzle(HashSet<Piece> pieces) {
		this.unUsedPieces = pieces;
		this.usedPieces = new HashSet<>();
	}

	public void solvePuzzle() {
		Set<Piece> puzzlesEdges = getPuzzleEdges();
		
		completeEdges(puzzlesEdges);
		
		complete();
	}
	
	

	private void complete() {
		// loop over unused find in used complementary.
		
	}

	private void completeEdges(Set<Piece> puzzlesEdges) {
		for(Piece piece1 : puzzlesEdges) {
			for(Piece piece2 : puzzlesEdges) {
				if(piece1 != piece2) {
					if(piece1.getUpEdge() != EdgeType.Flat) {
						if(piece1.getUpComp() == null) {
							//check piece1 up with piece2's unoccupied edges. If ok, set corresponding complementary.
						}
					}
				}
			}
		}
	}

	private Set<Piece> getPuzzleEdges() {
		Set<Piece> puzzleEdges = new HashSet<Piece>();
		for (Piece p : unUsedPieces) {
			if (p.getUpEdge() == EdgeType.Flat || p.getDownEdge() == EdgeType.Flat || p.getLeftEdge() == EdgeType.Flat
					|| p.getRightEdge() == EdgeType.Flat) {
				puzzleEdges.add(p);
				unUsedPieces.remove(p);
			}
		}

		return puzzleEdges;
	}
	
	
}
