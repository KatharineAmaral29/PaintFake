import java.util.ArrayList;


public class DesenhoModel {
	ArrayList<Figura> figs;
	
	public DesenhoModel(){
		figs = new ArrayList<Figura>();
	}
	
	public ArrayList<Figura> getFigs(){
		return figs;
	}
	
	public int getNumeroFiguras(){
		return figs.size();
	}
}
