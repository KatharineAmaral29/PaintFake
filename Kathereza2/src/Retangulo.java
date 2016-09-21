import java.io.Serializable;
import java.awt.*;

public class Retangulo extends Figura implements Serializable{
	
	private static int totalRetangulos;
	private int largura; //largura do retangulo
	private int altura; //altura do retangulo 
	
	public Retangulo(int x, int y, int l, int a, Color c){
		super (x,y,c);
		if(l > 0 && a > 0){
			largura = l;
			altura = a;
			totalRetangulos++;
		}
	}
	
	public static int getTotalRetangulos(){ //retorna o numero de retangulos instanciados
		return totalRetangulos;
	}
	
	public int getLargura (){
		return largura;
	}
	
	public int getAltura (){
		return altura;
	}
}