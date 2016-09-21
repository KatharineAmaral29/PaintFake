import java.awt.*;
import java.io.Serializable;

public abstract class Figura implements Serializable{
	// atributos de Figura
	
	protected Ponto posicao;
	protected Color cor;
	
	// metodos de Figura
	
	public Figura(int x, int y, Color cor) {
	// construtor de Figura;
		posicao = new Ponto(x,y);
		this.cor = cor;
	}
	
	public Color getCor(){
		return cor;
	}
		
	public Ponto getPosicao(){
		return posicao;
	}
	
	public boolean eCirculo(){ //retorna true se a figura for um circulo
		if(this instanceof Circulo)
			return true;
		else 
			return false;
	}

	public boolean eRetangulo(){ //retorna true se a figura for um retangulo
		if(this instanceof Retangulo)
			return true;
		else
			return false;
	}

	public boolean eLinha(){ //retorna true se a figura for uma linha
		if(this instanceof Linha)
			return true;
		else
			return false;
	}
}