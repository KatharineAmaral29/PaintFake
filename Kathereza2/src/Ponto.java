import java.io.Serializable;

public class Ponto implements Serializable{

	private int x, y; // Posicao atual do ponto
	private Ponto pa; // Posicao anterior do ponto

	public Ponto(int x, int y) { //construtor com dois atributos
		this.x = x;
		this.y = y;
		pa = null;
	}
	
	public Ponto(int x, int y,Ponto pa) { //construtor com dois atributos
		this.x = x;
		this.y = y;
		this.pa = pa;
	}
	
	public Ponto() { //construtor que zera os atributos
		x = 0;
		y = 0;
	}

	public Ponto(int a) { //construtor que coloca os dois atributos com valores iguais
		x = a;
		y = a;
	}

	public int getX() { //retorna o valor de x atual
		return x;
	}

	public int getY() { //retorna o valor de y atual
		return y;
	}
	
	public int getXant() { //retorna o valor de x anterior
		return pa.getX();
	}

	public int getYant() { //retorna o valor de  y anterior
		return pa.getY();
	}

	public Ponto getPa() { //retorna o ponto anterior de um ponto
		return pa;
	}

	public String strPosAnt() {
		String coordenada;
			if(pa.getXant() != 0 && pa.getYant() != 0) 
				coordenada = "(" + pa.getXant() + ", " + pa.getYant() + ")";
			else
				coordenada = "";
			return coordenada;
	}
	
	public double distPontos(Ponto p) { // calcula distancia entre os pontos do ultimo deslocamento
		return Math.sqrt(Math.pow(p.x - this.getX(), 2)
				+ Math.pow(p.y - this.getY(), 2));
	}
	
	private double distDesloc(Ponto p) { // calcula distancia entre os pontos do ultimo deslocamento
		return Math.sqrt(Math.pow(p.x - p.pa.getX(), 2)
				+ Math.pow(p.y - p.pa.getY(), 2));
	}
	
	public double distMovimento(Ponto p) { //calcula a distancia total entre o movimento
		Ponto pt = p;
		double dist = 0;
		while (pt != null){
			dist += distDesloc(pt);
			pt = pt.getPa();
		}
		return dist;
	}
	
}