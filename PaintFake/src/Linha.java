import java.io.Serializable;
import java.awt.*;

public class Linha extends Figura implements Serializable{
	private Ponto pontoFim;

	public Linha(int x1, int y1, int x2, int y2, Color cor){
		super (x1,y1,cor);
		this.pontoFim = new Ponto(x2,y2);
	}

	public int getX2(){
		return pontoFim.getX();
	}

	public int getY2(){
		return pontoFim.getY();
	}
}
