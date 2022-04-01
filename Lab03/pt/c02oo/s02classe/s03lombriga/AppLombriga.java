package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();

      String lombrigas[] = tk.recuperaLombrigas();
      //String lombrigas[] = new String[1];
      //lombrigas[0] = "151105MMMMVMMMMMCCV";
      Animacao lom[] = new Animacao[lombrigas.length];
      for (int l = 0; l < lombrigas.length; l++) {
    	  System.out.println(lombrigas[l]);
    	  lom[l] = new Animacao(lombrigas[l]);
    	  tk.gravaPasso("=====");
    	  tk.gravaPasso(lom[l].apresenta());
    	  //System.out.println(lom[l].apresenta());
    	  for(int m = 1; m < lombrigas[l].length()-5; m++ ) {
    		  lom[l].passo(); 
    		  //System.out.println(lom[l].apresenta());  
    		  tk.gravaPasso(lom[l].apresenta());
    	  }  
      }   
      tk.stop();
   }

}
