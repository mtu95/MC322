package pt.c02oo.s03relacionamento.s04restaum;

import java.util.Arrays;

public class Tabuleiro {
	private Peca pieces[][] = new Peca[7][7];
	
	public Tabuleiro(){
		
		for (int x = 0; x < 7; x++ ) {
			for(int y = 0; y < 7; y++) {
				if( ((x == 0)&&(y == 0 || y == 1 || y == 5 || y == 6)) || ((x == 1)&&(y == 0 || y == 1 || y == 5 || y == 6)) ||
						((x == 5)&&(y == 0 || y == 1 || y == 5 || y == 6))  || ((x == 6)&&(y == 0 || y == 1 || y == 5 || y == 6))) {
					pieces[x][y] = null;
				}
				else {
					pieces[x][y] = new Peca(x, y);
				}
			}
			
		}
		this.pieces[3][3].setState(false);// piece in the middle
	}
	public void connectPieces(Tabuleiro tab){
		for (int x = 2; x < 5; x++ ) {
			for(int y = 0; y < 7; y++) {
				if(x != 3 || y != 3) {
					this.pieces[x][y].connectBoard(tab);
					this.pieces[y][x].connectBoard(tab);
				}
			}
		}
	}
	public Peca getPiece(int[] pos) {
		
		for (int i = 2; i < 5; i++ ) {
			for(int j = 0; j < 7; j++) {
				if(Arrays.equals(this.pieces[i][j].getPosition(), pos) ) {
					return this.pieces[i][j];
				}
				else if(Arrays.equals(this.pieces[j][i].getPosition(), pos)) {
					return this.pieces[j][i];
				}
			}
		}
		return null;
		
	}
	public void removePiece(int pos[]) {
		this.pieces[pos[0]][pos[1]].setState(false);;
	}
	public void executeMovement(int initPos[], int nextPos[]) {
		Peca aux;
		
		aux = this.pieces[nextPos[0]][nextPos[1]];
		this.pieces[nextPos[0]][nextPos[1]] = this.pieces[initPos[0]][initPos[1]];
		this.pieces[initPos[0]][initPos[1]] = aux;
		this.pieces[nextPos[0]][nextPos[1]].setPosition(nextPos);
		this.pieces[initPos[0]][initPos[1]].setPosition(initPos);
	}
	public char[][] convertToChar(){
		
		   char board[][] = {
			         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
			         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
			         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
			         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
			         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
			         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
			         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
				   };
		for (int i = 2; i < 5; i++ ) {
			for(int j = 0; j < 7; j++) {
				if(this.pieces[i][j].getState() == true) {
					board[i][j] =  'P';
				}
				else {
					board[i][j] = '-';
				} 
					
				if(this.pieces[j][i].getState() == true) {
					board[j][i] =  'P';
				}
				else {
					
					board[j][i] = '-';
				}
			}
	      }
		
		
		
	    return board;
		
	}
	public int convertPos(String pos) {
		int index=0;
		switch(pos) {
		case("a"):
			index = 0;
			break;
		case("b"):
			index = 1;
			break;
		case("c"):
			index = 2;
			break;
		case("d"):
			index = 3;
			break;
		case("e"):
			index = 4;
			break;
		case("f"):
			index = 5;
			break;
		case("g"):
			index = 6;
			break;
		}
		return index;
	}
	
	
}

