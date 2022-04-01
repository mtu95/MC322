package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int lombrigaSize, aquarioSize, headPosition;
	char side; //R - right, L - left
	AquarioLombriga (int aquarioSize, int lombrigaSize,  int headPosition, char side){
		if (headPosition < 1 || headPosition > aquarioSize) // you cannot put the lombriga's head outside of the aquarium
			this.headPosition = 1;
		else
			this.headPosition = headPosition;
		this.side = side;
		this.aquarioSize = aquarioSize;
		//ensure that lombriga will fit inside of the aquarium (e.g., you cannot put a lombriga bigger than the aquarium size
		if (lombrigaSize > this.aquarioSize){
			this.lombrigaSize = this.aquarioSize;
			if(this.side == 'R')
				this.headPosition = aquarioSize;
			else
				this.headPosition = 1;
		}
		else
			this.lombrigaSize = lombrigaSize;
		// shift the lombriga's head to fit it inside the aquarium if necessary. At this point, lombriga's length is shorter than aquarium's length
		if(this.lombrigaSize+this.headPosition-1 > this.aquarioSize) 
			this.headPosition = this.headPosition - (this.lombrigaSize+this.headPosition-1-this.aquarioSize);
		//Actually, the lombriga's head starts always towards left
		//else if(this.lombrigaSize - this.headPosition > 0 && side == 'R' )
		//	this.headPosition = this.headPosition + (this.lombrigaSize-this.headPosition);
	}
	void virar() {
		if(this.side == 'R') {
			this.side = 'L';
			this.headPosition = this.headPosition - this.lombrigaSize + 1;
		}
		else {
			this.side = 'R';
			this.headPosition = this.headPosition +this.lombrigaSize - 1;
		}
	}
	void crescer () {
		if ((this.side == 'L' &&  this.lombrigaSize+this.headPosition-1< this.aquarioSize)||
				(this.side == 'R' &&  this.headPosition-this.lombrigaSize > 0))
			this.lombrigaSize++;
	
	}
	void mover () {
		if (this.side == 'L' && this.headPosition > 1) {
			this.headPosition--;
		}
		else if (this.side == 'R' && this.headPosition < this.aquarioSize) {
			this.headPosition++;
		}
	}
	String apresenta () {
		String lombriga = new String();
		int aux; //it'll store the lombriga's size before loop
		if(this.side == 'R') {
			//System.out.println(this.headPosition - this.lombrigaSize);
			for(int count = 1; count <= (this.headPosition - this.lombrigaSize); count++ ) {
				lombriga = lombriga + '#';
			}
			for(int count = 1; count < this.lombrigaSize; count++ ) {
				lombriga = lombriga + '@';
			}
			lombriga = lombriga + '0';
			aux = lombriga.length();
			for(int count = 1; count <= (this.aquarioSize - aux); count++ ) {
				lombriga = lombriga + '#';
			}
		}
		else { //head towards left side
			for(int count = 1; count < (this.headPosition); count++ ) {
				lombriga = lombriga + '#';
			}
			lombriga = lombriga + '0';
			for(int count = 1; count < this.lombrigaSize; count++ ) {
				lombriga = lombriga + '@';
			}
			aux = lombriga.length();
			for(int count = 1; count <= (this.aquarioSize - aux); count++ ) {
				lombriga = lombriga + '#';
				
			}
		}
	return lombriga;
	}
	
}
