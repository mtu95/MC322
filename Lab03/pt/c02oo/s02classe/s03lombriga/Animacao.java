package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String sequencia = new String();
	int passo_atual = 6;
	AquarioLombriga lombriga;
	Animacao(String sequencia){
		this.sequencia = sequencia;
		this.lombriga = new AquarioLombriga(Integer.parseInt(this.sequencia.substring(0,2)),Integer.parseInt(this.sequencia.substring(2,4)),Integer.parseInt(this.sequencia.substring(4,6)),'L');
	}

	String apresenta() {
		return this.lombriga.apresenta();
	}
	void passo() {
		if (this.passo_atual < this.sequencia.length()) {
			switch(this.sequencia.substring(this.passo_atual,this.passo_atual+1)) {
			
			
			case "M":
				this.lombriga.mover();
				break;
			case "C":
				this.lombriga.crescer();
				break;
			case "V":
				this.lombriga.virar();
				break;
			}
			this.passo_atual++;
		}
	}
}
