import java.io.Serializable;
import java.awt.*;

public class Circulo extends Figura implements Serializable {

	private static int totalCirculos;
	private int raio;

	public Circulo(int x, int y, int r, Color cor) { //construtor com centro, raio e cor
		super (x,y,cor);
		raio = r;
		totalCirculos++;
	}

	public int getTotalCirculos(){ //retorna o numero de circulos instanciados
		return totalCirculos;
	}
	
	public int getRaio() { //retorna o raio de um circulo
		return raio;
	}

}