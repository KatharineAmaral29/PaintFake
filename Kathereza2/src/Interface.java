import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;

import javax.swing.*;

import java.util.*;

public class Interface extends JFrame {
	ArrayList<Figura> figs = new ArrayList<Figura>();
	
	public int totalFiguras = 0;
	Graphics g;
	/*Texto dos campos*/
	JTextField xc = new JTextField(10);
	JTextField yc = new JTextField(10); 
	JTextField raio = new JTextField(10);
	JTextField xr = new JTextField(10);
	JTextField yr = new JTextField(10);
	JTextField altura = new JTextField(10);
	JTextField largura = new JTextField(10);
	JTextField cx1 = new JTextField(10);
	JTextField cx2 = new JTextField(10);
	JTextField cy1 = new JTextField(10);
	JTextField cy2 = new JTextField(10);
	
	/*Mensagens*/
	JLabel circulo = new JLabel("Dados do circulo x, y e raio");
	JLabel retangulo = new JLabel("Dados do retangulo x, y, altura e largura");
	JLabel linha = new JLabel("Dados da linha x1, y1, x2 e y2");
	//JLabel quantidades = new JLabel("Nenhuma figura criada");
	JLabel informacoes = new JLabel("");
	JLabel informacoes2 = new JLabel("");
	JLabel informacoes3 = new JLabel("A INSPIRA��O COME�A AQUI!");
	JLabel instrucoes = new JLabel("Selecione a figura a ser removida");
	
	/*Botoes*/
	JButton CriarCirculo = new JButton("Criar Circulo");
	JButton CriarRetangulo = new JButton("Criar Retangulo");
	JButton CriarLinha = new JButton("Criar Linha");
	JButton Delete = new JButton("Remover");
	JButton Apagar = new JButton("Limpar");
	
	/*Botao de selecionar*/
	JComboBox corCirc;
	JComboBox corRet;
	JComboBox corLin;
	JComboBox selecDet;
	
	/*Variaveis para arquivo*/
	String figuras = "arquivo.txt";
	FileInputStream fis = null;
	ObjectInputStream in = null;
	FileOutputStream fos = null;
	ObjectOutputStream out = null;
	
	public void paint2(Figura f, Graphics g) {

		if(f instanceof Circulo){
			g.setColor(f.getCor());
			g.fillOval(f.getPosicao().getX(),f.getPosicao().getY(),((Circulo)f).getRaio(),((Circulo)f).getRaio());
		}
		if(f instanceof Retangulo){
			g.setColor(f.getCor());
			g.fillRect(f.getPosicao().getX(),f.getPosicao().getY(),((Retangulo)f).getLargura(),((Retangulo)f).getAltura());
		}
		if(f instanceof Linha){
			g.setColor(f.getCor());
			g.drawLine(f.getPosicao().getX(),f.getPosicao().getY(),((Linha)f).getX2(),((Linha)f).getY2());
		}
	}
	
	
	public void preencher(){
		try{
			fis = new FileInputStream(figuras); //abre arquivo
			in = new ObjectInputStream(fis); //abre arquivo de objeto
			figs = (ArrayList<Figura>)in.readObject(); //le os elementos do array
			in.close(); //fecha o arquivo de leitura
			repaint();
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
	
	public int totalCirculos(){ //retorna o total de circulos em figs
		int total = 0;
		for(int i=0; i<totalFiguras; i++)
			if((figs.get(i)).eCirculo())
				total++;
	return total;
	}
	
	public int totalRetangulos(){ //retorna o total de retangulos em figs
		int total = 0;
		for(int i=0; i<totalFiguras; i++)
			if((figs.get(i)).eRetangulo())
				total++;
	return total;
	}

	public int totalLinhas(){ //retorna o total de linhas em figs
		int total = 0;
		for(int i=0; i<totalFiguras; i++)
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
		for(int i=0; i<totalFiguras; i++)
				if((figs.get(i)).equals(c)){
							figs.remove(i);
							totalFiguras--;
				}
	}

	public void deleteRetangulo (Retangulo r){
		for(int i=0; i<totalFiguras; i++)
				if((figs.get(i)).equals(r)){
							figs.remove(i);
							totalFiguras--;
				}
	}

	public void deleteLinha (Linha l){
		for(int i=0; i<totalFiguras; i++)
				if((figs.get(i)).equals(l)){
							figs.remove(i);
							totalFiguras--;
				}
	}
	
	public void opcoesDelete(){
		Figura f = null;
		String op = null;
		for(int i=0; i <totalFiguras; i++){
			f = figs.get(i);
			if(f instanceof Circulo)
				op = "Circulo -> x: " + (((Circulo)f).getPosicao()).getX() + " | y: " + (((Circulo)f).getPosicao()).getY() + " | raio: " + ((Circulo)f).getRaio();
			if(f instanceof Retangulo)
				op = "Retangulo -> x: " + (((Retangulo)f).getPosicao()).getX() + " | y: " + (((Retangulo)f).getPosicao()).getY() + " | altura: " + ((Retangulo)f).getAltura() + " | largura: " + ((Retangulo)f).getLargura();
			if(f instanceof Linha)
				op = "Linha -> x1: " + (((Linha)f).getPosicao()).getX() + " | y1: " + (((Linha)f).getPosicao()).getY() + " | x2: " + ((Linha)f).getX2() + " | y2: " + ((Linha)f).getY2();
		selecDet.addItem(op);
			
		}
	}
	
	public Interface() {
		
		
	String[] cores = {"magenta", "cyan", "green", "orange", "red", "yellow", "pink", "blue" }; //Cores das figuras
	corCirc = new JComboBox(cores);
	corCirc.setSelectedIndex(0);
	corRet = new JComboBox(cores);	
	corRet.setSelectedIndex(0);
	corLin = new JComboBox(cores);
	corLin.setSelectedIndex(0);
	selecDet = new JComboBox();
		
	JFrame jFrame = new JFrame("Adicione circulos, retangulos e linhas"); //Titulo da janela
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Aperta X = FERCHA TELA
	jFrame.setSize(1200,800); //Define o tamanho da tela
	jFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); //Define o layout da tela
	jFrame.setResizable(true); //Impede alteracao no tamanho da tela	
	
	JPanel panel = new JPanel(); //Panel para dados
	JPanel panel2 = new JPanel(); //Panel para dados
	JPanel panel3 = new JPanel(); //Panel para dados
	panel.setSize(1200,300);
	panel.setLayout(new FlowLayout()); //Define o layout do panel
	panel.setLayout(new FlowLayout()); //Define o layout do panel	
	
	informacoes.setForeground(Color.red);
	informacoes2.setForeground(Color.blue);
	informacoes3.setForeground(Color.pink);
	
	
		xc.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para a coordenada X");
		}
		
		public void focusLost(FocusEvent e) {
			try{
				int x = Integer.parseInt(xc.getText());
			}			
			catch (NumberFormatException numberFormatException) {
				xc.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para X", "Title", JOptionPane.ERROR_MESSAGE);
			}
			catch (NegativoException n){
				xc.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}

		}
		});
	
		yc.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para a coordenada Y");
		}
		
		public void focusLost(FocusEvent arg0) {
			try{
				int y = Integer.parseInt(yc.getText());
			}
			catch (NumberFormatException numberFormatException) {
				yc.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para Y", "Title", JOptionPane.ERROR_MESSAGE);
			}
			catch (NegativoException n){
				yc.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
		}
		});
		
		raio.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para o RAIO");
		}

		public void focusLost(FocusEvent arg0) {
			try{
				int raios = Integer.parseInt(raio.getText());
				if(raios<=0)
					throw new NegativoException();
			}
			catch (NegativoException n){
				raio.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Raio menor que ZERO!", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException numberFormatException) {
				raio.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para o RAIO", "Title", JOptionPane.ERROR_MESSAGE);
			}		
		}
		});
	
		xr.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para o X");
		}
		
		public void focusLost(FocusEvent arg0) {
			try{
				int x = Integer.parseInt(xr.getText());
			}			
			catch (NumberFormatException numberFormatException) {
				xr.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para X", "Title", JOptionPane.ERROR_MESSAGE);
			}	
			catch (NegativoException n){
				xr.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
		}
		});
		
		yr.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para o Y");
		}
		
		public void focusLost(ActionEvent e) {
		}

		public void focusLost(FocusEvent arg0) {
			try{
				int y = Integer.parseInt(yr.getText());
			}			
			catch (NumberFormatException numberFormatException) {
				yr.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para o Y", "Title", JOptionPane.ERROR_MESSAGE);
			}		
			catch (NegativoException n){
				yr.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
		}
		});

		altura.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para a altura");
		}
		
		public void focusLost(FocusEvent arg0) {
			try{
				int alt = Integer.parseInt(altura.getText());
				
				if(alt<=0)
					throw new NegativoException();
			}	
			catch (NegativoException n){
				altura.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira numeros positivos para a ALTURA", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException numberFormatException) {
				altura.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira numeros para a ALTURA", "Title", JOptionPane.ERROR_MESSAGE);
			}
		}
		});

		largura.addFocusListener(new FocusListener(){
		public void focusGained(FocusEvent e) {	
			informacoes2.setText("Entre um valor numerico inteiro para a largura");
		}

		public void focusLost(FocusEvent arg0) {
			try{
				int larg = Integer.parseInt(largura.getText());
				if(larg <=0)
					throw new NegativoException();
			}			
			catch (NegativoException n){
				largura.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira numeros positivos para a LARGURA", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException numberFormatException) {
				largura.setText("");
				informacoes2.setText("");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos para a LARGURA", "Title", JOptionPane.ERROR_MESSAGE);
			}			
		}
		});		
	
	/*Criando o vigia para circulo*/
	ActionListener vigiaCirculo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			Object cores;
			Color colorido;
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			try{
				int x = Integer.parseInt(xc.getText());
				int y = Integer.parseInt(yc.getText());
				int raios = Integer.parseInt(raio.getText());
				if(raios<=0 || x<0 || y<0)
					throw new NegativoException();
				if((x < 1200 || y < 393 ) && (((393 - y) <= raios)&& ((1200 - x)<= raios)) || (((x - raios) < 0)&&((y -raios)<0)))
					throw new DesenhoException();
				cores = corCirc.getSelectedItem();
				colorido = parseCor(cores.toString());
				figs.add(new Circulo(x, y, raios, colorido));
				totalFiguras++;
				fos = new FileOutputStream(figuras);
				out = new ObjectOutputStream(fos);
				out.writeObject(figs);
				out.close();
				System.out.println("Object Persisted");
				JPanel areaDeInspiracao = new Desenho(figs);
				repaint();
			}
			catch (NegativoException n){
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog (null, "Insira valores numericos", "Title", JOptionPane.ERROR_MESSAGE);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (DesenhoException de){
				de.showMessage();
			}

			//quantidades.setText(totalCirculos() + " circulos | " + totalRetangulos() + " retangulos | " + totalLinhas() + " linhas");
			xc.setText("");
			yc.setText("");
			raio.setText("");
			informacoes.setText("");
			informacoes2.setText("");
			paint2(figs.get(figs.size()), g);
			JPanel areaDeInspiracao = new Desenho(figs);
			preencher();
			opcoesDelete();
		}
		
	};

	/*Criando o vigia para retangulo*/
	ActionListener vigiaRetangulo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object cores;
			Color colorido;
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			try{
				int x = Integer.parseInt(xr.getText());
				int y = Integer.parseInt(yr.getText());
				int alt = Integer.parseInt(altura.getText());
				int larg = Integer.parseInt(largura.getText());
				cores = corRet.getSelectedItem();
				colorido = parseCor(cores.toString());
				figs.add(new Retangulo(x, y, alt, larg, colorido));
				totalFiguras++;
				fos = new FileOutputStream(figuras);
				out = new ObjectOutputStream(fos);
				out.writeObject(figs);
				out.close();
				System.out.println("Object Persisted");
				preencher();
				JPanel areaDeInspiracao = new Desenho(figs);
				if(alt<=0 || x<0 || y<0 || larg<=0)
					throw new NegativoException();
				if(((x>=1200)||(y>=393))||((x+larg)>1200)||((y-alt)<0))
					throw new DesenhoException();
			}			
			catch (NegativoException n){
				//informacoes.setText("Insira valores positivos");
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
			catch (DesenhoException de){
				de.showMessage();
			}
			catch (NumberFormatException numberFormatException) {
				//informacoes.setText("Insira valores numericos");
				JOptionPane.showMessageDialog (null, "Insira apenas valores numericos", "Title", JOptionPane.ERROR_MESSAGE);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			
			//quantidades.setText(totalCirculos() + " circulos | " + totalRetangulos() + " retangulos | " + totalLinhas() + " linhas");	
			xr.setText("");
			yr.setText("");
			altura.setText("");
			largura.setText("");
			informacoes2.setText("");
			preencher();
			paint2(figs.get(figs.size()), g);
			JPanel areaDeInspiracao = new Desenho(figs);
			opcoesDelete();
		}
	};
	
	/*Criando o vigia para linha*/
	ActionListener vigiaLinha = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			/*Objeto para pegar a cor selecionada*/
			Object cores;
			Color colorido;
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			try{
				int x1 = Integer.parseInt(cx1.getText());
				int y1 = Integer.parseInt(cy1.getText());
				int x2 = Integer.parseInt(cx2.getText());
				int y2 = Integer.parseInt(cy2.getText());
				cores = corLin.getSelectedItem();
				colorido = parseCor(cores.toString());
				if(x1<0 || y1<0 || x2<0 || y2<0)
					throw new NegativoException();
				if(x1 > 1200 || y1 > 393 || x2 > 1200 || y2 > 393)
					throw new DesenhoException();
				else{
					figs.add(new Linha(x1, y1, x2, y2, colorido));
					totalFiguras++;
					fos = new FileOutputStream(figuras);
					out = new ObjectOutputStream(fos);
					out.writeObject(figs);
					out.close();
					System.out.println("Object Persisted");
					JPanel areaDeInspiracao = new Desenho(figs);
				}
			}
			catch (NegativoException n){
				JOptionPane.showMessageDialog (null, "Insira valores positivos", "Reinicie a operacao!", JOptionPane.ERROR_MESSAGE);
			}
			catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog (null, "Insira valores numericos", "Title", JOptionPane.ERROR_MESSAGE);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (DesenhoException de){
				de.showMessage();
			}
			cx1.setText("");
			cy1.setText("");
			cx2.setText("");
			cy2.setText("");
			raio.setText("");
			informacoes.setText("");
			informacoes2.setText("");
			preencher();
			paint2(figs.get(figs.size()), g);
			paint2(figs.get(totalFiguras),g);
			opcoesDelete();
		}
		
	};
	
	/*Criando o vigia para delete*/
	ActionListener vigiaDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			//Pega a opção do usuário no selecDet e faz remove(opção escolhida)
		}
		
	};

	/*Criando o vigia para apagartudo*/
	ActionListener vigiaApagar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			figs.removeAll(figs);
		}
		
	};
	
	
	CriarCirculo.addActionListener(vigiaCirculo); //Vigia os cliques no circulo
	CriarRetangulo.addActionListener(vigiaRetangulo); //Vigia os cliques no retangulo
	CriarLinha.addActionListener(vigiaLinha); //Vigia os cliques na linha
	
	preencher();
	panel.setPreferredSize(new Dimension(1050,110));
	panel2.setPreferredSize(new Dimension(1050,30));
	panel3.setPreferredSize(new Dimension(1050,20));
	JPanel areaDeInspiracao = new Desenho(figs); //Panel para desenhos
	//areaDeInspiracao.setBackground(Color.green);
	//areaDeInspiracao.setSize(1200,350);

	areaDeInspiracao.setPreferredSize(new Dimension(1200,393));
	
	panel.add(circulo);
	panel.add(xc);
	panel.add(yc);
	panel.add(raio);
	panel.add(corCirc);
	panel.add(CriarCirculo);
	panel.add(retangulo);
	panel.add(xr);
	panel.add(yr);
	panel.add(altura);
	panel.add(largura);
	panel.add(corRet);
	panel.add(CriarRetangulo);
	panel.add(linha);
	panel.add(cx1);
	panel.add(cy1);
	panel.add(cx2);
	panel.add(cy2);
	panel.add(corLin);
	panel.add(CriarLinha);
	panel.add(informacoes);
	panel.add(informacoes2);
	panel2.add(instrucoes);
	panel2.add(selecDet);
	panel2.add(Delete);
	panel2.add(Apagar);
	panel3.add(informacoes3);
	jFrame.add(panel);
	jFrame.add(panel2);
	jFrame.add(panel3);
	jFrame.add(areaDeInspiracao);
	jFrame.setVisible(true); //Permite a visualizacao da tela 
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
	
	public static void main(String[] args) {
		
		new Interface();
	}
	
	public class NegativoException extends RuntimeException{
		public NegativoException() {
			super("Numero negativo");
		}
		public void showMessage(){
		}
	}


	public class DesenhoException extends RuntimeException{
		public DesenhoException() {
			super("Nao cabe no desenho");
		}
		public void showMessage(){
			JOptionPane.showMessageDialog (null, "Valores informados para a figura não cabem no desenho! ", "Tente Novamente", JOptionPane.ERROR_MESSAGE);
		}
	}


}
