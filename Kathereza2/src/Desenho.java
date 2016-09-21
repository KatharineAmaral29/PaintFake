import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Desenho extends JPanel{
	ArrayList <Figura> copia = new ArrayList <Figura>();
	Figura aux; //Figura auxiliar
	//Circulo c = new Circulo(1,2,500, Color.blue);
	//aux = ((Figura)c);

	public Desenho (ArrayList <Figura> arrayListConst){
		copia = arrayListConst;
	}
	
	public void paint(Graphics g) {
		for(int i=0; i<copia.size(); i++){
			aux = copia.get(i);
			if(copia.get(i).eCirculo()){
				g.setColor(aux.getCor());
				g.fillOval(aux.getPosicao().getX(),aux.getPosicao().getY(),((Circulo)aux).getRaio(),((Circulo)aux).getRaio());
			}
			if(copia.get(i).eRetangulo()){
				g.setColor(aux.getCor());
				g.fillRect(aux.getPosicao().getX(),aux.getPosicao().getY(),((Retangulo)aux).getLargura(),((Retangulo)aux).getAltura());
			}
			if(copia.get(i).eLinha()){
				g.setColor(aux.getCor());
				g.drawLine(aux.getPosicao().getX(),aux.getPosicao().getY(),((Linha)aux).getX2(),((Linha)aux).getY2());
			}
		}
	}
	

	
	/* FUNCIONANDO -> SOBRAL
	public void paint(Graphics g) {
		g.setColor(g.getColor());
		g.drawRect(0, 0, 200, 100);
		g.setColor(Color.GREEN);
		g.drawRect(400, 100, 100, 200);
		g.setColor(Color.BLUE);
		g.drawRect(600, 200, 200, 200);
	}
	*/	
		
		/* NÃO FUNCIONANDO AINDA -> BRUNO
		public void desenha(Graphics umaDim){
			Graphics2D segDim = (Graphics2D) umaDim;
			setBackground(Color.green);
			setVisible(true);
			for(int i=0; i<copia.size(); i++){
				aux = copia.get(i);
				if(copia.get(i).eCirculo()){
					segDim.setColor(((Circulo)copia.get(i)).getCor());
					segDim.fillOval(((Circulo)copia.get(i)).getPosicao().getX(),((Circulo)copia.get(i)).getPosicao().getY(),((Circulo)copia.get(i)).getRaio(),((Circulo)copia.get(i)).getRaio());
				}
				if(copia.get(i).eRetangulo()){
					segDim.setColor(((Retangulo)copia.get(i)).getCor());
					segDim.fillRect(((Retangulo)copia.get(i)).getPosicao().getX(),((Retangulo)copia.get(i)).getPosicao().getY(),((Retangulo)copia.get(i)).getLargura(),((Retangulo)copia.get(i)).getAltura());
				}
				if(copia.get(i).eLinha()){
					segDim.setColor(((Linha)copia.get(i)).getCor());
					segDim.drawLine(((Linha)copia.get(i)).getPosicao().getX(),((Linha)copia.get(i)).getPosicao().getY(),((Linha)copia.get(i)).getX2(),((Linha)copia.get(i)).getY2());
				}
			}
				
		}
		
		public void paintComponent(Graphics umaDim)
		{
			super.paintComponent(umaDim);
			desenha(umaDim);
		}
		*/		
		
		
		

	

}
