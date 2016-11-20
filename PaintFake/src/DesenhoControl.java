import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DesenhoControl {
	String figuras = "arquivo.txt";
	FileInputStream fis = null;
	ObjectInputStream in = null;
	FileOutputStream fos = null;
	ObjectOutputStream out = null;
	ArrayList<Figura> figs;
	
	DesenhoModel modelo = new DesenhoModel();
	
	public DesenhoControl(){
		figs = modelo.getFigs();
	}
	
	public int totalCirculos(){ //retorna o total de circulos em figs
		int total = 0;
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
			if((figs.get(i)).eCirculo())
				total++;
	return total;
	}
	
	public int totalRetangulos(){ //retorna o total de retangulos em figs
		int total = 0;
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
			if((figs.get(i)).eRetangulo())
				total++;
	return total;
	}

	public int totalLinhas(){ //retorna o total de linhas em figs
		int total = 0;
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
			if((figs.get(i)).eLinha())
				total++;
	return total;
	}
	
	public void delete (Figura f){
		if(f.eCirculo())
			deleteCirculo((Circulo)f);
		if(f.eRetangulo())
			deleteRetangulo((Retangulo)f);
		if(f.eLinha())
			deleteLinha((Linha)f);
	}
	
	public void deleteCirculo (Circulo c){
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
				if((figs.get(i)).equals(c)){
							figs.remove(i);
				}
	}

	public void deleteRetangulo (Retangulo r){
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
				if((figs.get(i)).equals(r)){
							figs.remove(i);
				}
	}

	public void deleteLinha (Linha l){
		for(int i=0; i<modelo.getNumeroFiguras(); i++)
				if((figs.get(i)).equals(l)){
							figs.remove(i);
				}
	}
	
	public void opcoesDelete(){
		Figura f = null;
		String op = null;
		for(int i=0; i <modelo.getNumeroFiguras(); i++){
			f = figs.get(i);
			if(f instanceof Circulo)
				op = "Circulo -> x: " + (((Circulo)f).getPosicao()).getX() + " | y: " + (((Circulo)f).getPosicao()).getY() + " | raio: " + ((Circulo)f).getRaio();
			if(f instanceof Retangulo)
				op = "Retangulo -> x: " + (((Retangulo)f).getPosicao()).getX() + " | y: " + (((Retangulo)f).getPosicao()).getY() + " | altura: " + ((Retangulo)f).getAltura() + " | largura: " + ((Retangulo)f).getLargura();
			if(f instanceof Linha)
				op = "Linha -> x1: " + (((Linha)f).getPosicao()).getX() + " | y1: " + (((Linha)f).getPosicao()).getY() + " | x2: " + ((Linha)f).getX2() + " | y2: " + ((Linha)f).getY2();		
		}
	}
	
	public Color parseCor (String colors) {
		
		if(colors == "magenta")
			return Color.magenta;
		else if(colors == "cyan")
			return Color.cyan;
		else if(colors == "green")
			return Color.green;
		else if (colors == "orange")
			return Color.orange;
		else if (colors == "red")
			return Color.red;
		else if (colors == "yellow")
			return Color.yellow;
		else if (colors == "pink")
			return Color.pink;
		else if (colors == "blue")
			return Color.blue;
		return Color.white; //null
	
	}
	
	public ArrayList<Figura> getFigs(){
		return figs;
	}
	
	public void preencher(){
		try{
			fis = new FileInputStream(figuras); //abre arquivo
			in = new ObjectInputStream(fis); //abre arquivo de objeto
			figs = (ArrayList<Figura>)in.readObject(); //le os elementos do array
			in.close(); //fecha o arquivo de leitura
		}
		catch(IOException ioe){
			ioe.printStackTrace();			
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		
		/*if (totalCirculos() !=0 && totalRetangulos() !=0)
			quantidades.setText(totalCirculos() + " circulos | " + totalRetangulos() + " retangulos | " + totalLinhas() + " linhas");
		*/
	}
	
	public String getArquivo(){
		return figuras;
	}
	
}
