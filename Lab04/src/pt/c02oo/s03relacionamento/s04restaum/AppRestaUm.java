package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
	  AppRestaUm app = new AppRestaUm();
	  app.executaJogo();

   }

   public static void executaJogo() {
	   Tabuleiro tabuleiro = new Tabuleiro();
	   tabuleiro.connectPieces(tabuleiro);
	   Toolkit tk = Toolkit.start(null, null);
	   String commands[] = tk.retrieveCommands();
	   char board[][] = {
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
		         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
		         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
			   };
	   tk.writeBoard("Tabuleiro inicial", board);      
	   
	   for (int l = 0; l < commands.length; l++) {
		   
		   int initPos[] = new int[2];
		   int nextPos[] = new int[2];
		   initPos[1] = tabuleiro.convertPos(commands[l].substring(0,1));
		   initPos[0] = Integer.valueOf(commands[l].substring(1,2))-1;//index starts in zero.
		   nextPos[1] = tabuleiro.convertPos(commands[l].substring(3,4));
		   nextPos[0] = Integer.valueOf(commands[l].substring(4,5))-1;//index starts in zero
		   
		   if(tabuleiro.getPiece(initPos) == null || tabuleiro.getPiece(initPos).validMovement(nextPos) == false)
			   System.out.println("Comando inválido");
		   board = tabuleiro.convertToChar();
		   tk.writeBoard("source: "+commands[l].substring(0,2)+"; target: "+commands[l].substring(3,5), board); 

	   }
      

      
	   tk.stop();
   }
}
