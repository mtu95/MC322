package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Peca tab[][] = new Peca[7][7];
	Tabuleiro(){
		for (int x = 0; x < 7; x++ ) {
			for(int y = 0; y < 7; y++) {
				if( ((x == 0)&&(y == 0 || y == 1 || y == 5 || y == 6)) || ((x == 1)&&(y == 0 || y == 1 || y == 5 || y == 6)) ||
						((x == 5)&&(y == 0 || y == 1 || y == 5 || y == 6))  || ((x == 6)&&(y == 0 || y == 1 || y == 5 || y == 6))) {
					tab[x][y] = null;
				}
				else
					tab[x][y] = new Peca(String.valueOf(x)+String.valueOf(y));
			}
			
		}
	}
	void getCommand(String cmd) {
		
	}
	int convertPos(String pos) {
		int index=0;
		switch(pos.substring(0,1)) {
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

