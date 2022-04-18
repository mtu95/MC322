package pt.c02oo.s03relacionamento.s04restaum;
	 
public class Peca {
	private boolean state; // True stands for piece in the game
	private int position[] = new int[2]; // I decided to work with int instead of String
	private Tabuleiro tab;
	Peca(int p1,int p2){
		this.state = true;
		this.position[0] = p1;
		this.position[1] = p2;
		
	}
	public boolean validMovement(int nextPos[]){
		
		int[] nearPos = new int[2];
		
		Peca piece1, piece2;
		//inside of the valid zone;
		if ( ((nextPos[0]>=2 || nextPos[0] <=4) && (nextPos[1]>=0 || nextPos[1] <= 6)) || 
				((nextPos[1]>=2 || nextPos[1] <=4) && (nextPos[0]>=0 || nextPos[0] <= 6))) {
			//The next position is valid. Is there a piece between our path. is there a free space after the piece
			if (this.position[0] == nextPos[0]) {//same line
				nearPos[0] = this.position[0];
				nearPos[1] = (this.position[1] + nextPos[1])/2;
				
				if(Math.abs(nearPos[1] - this.position[1]) > 1)//the next position is too far
					return false;
				
				piece1 = tab.getPiece(nearPos);
				piece2 = tab.getPiece(nextPos);
				if(piece1.getState() == true && piece2.getState() == false ) {//check if there is a piece between initial position and the final position. Moreover, the final position must be free
					tab.removePiece(nearPos);
					tab.executeMovement(this.position, nextPos);
					//ask to the board eliminate the piece, update the new position, open a free space	
				}
				else
					return false;
			}
			else if (this.position[1] == nextPos[1]) {//same column
				
				nearPos[1] = this.position[1];
				nearPos[0] = (this.position[0] + nextPos[0])/2;
				if(Math.abs(nearPos[0] - this.position[0]) > 1)//the next position is too far
					return false;
				piece1 = tab.getPiece(nearPos);
				piece2 = tab.getPiece(nextPos);
				if(piece1.getState() == true && piece2.getState() == false ) {//check if there is a piece between initial position and the final position. Moreover, the final position must be free
					tab.removePiece(nextPos);
					tab.removePiece(nearPos);
					tab.executeMovement(this.position, nextPos);
					
				}
				else
					return false;
			}
		}
		
		else
			return false;
		return true;
	}
	
	public boolean getState() {
		return this.state;
	}
	public int[] getPosition() {
		return this.position;
	}
	public void setPosition(int pos[]) {
		this.position = pos;
	}
	public void setState(boolean state) { 
		this.state = state;
	}
	public void connectBoard(Tabuleiro tab) {
		this.tab = tab;
		
	}
	
}

