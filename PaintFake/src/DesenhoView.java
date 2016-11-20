import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;

import javax.swing.*;
import java.util.*;

public class DesenhoView extends JPanel{
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
	JLabel informacoes3 = new JLabel("A INSPIRA«√O COME«A AQUI!");
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
	
	Figura aux;
	
	DesenhoControl controle = new DesenhoControl();
	ArrayList<Figura> copia = controle.getFigs();
	ArrayList<Figura> figs = copia;
	
	public DesenhoView (ArrayList <Figura> arrayListConst){
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
	

	
	public DesenhoView() {
		
		
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
	jFrame.setResizable(false); //Impede alteracao no tamanho da tela	
	
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
					colorido = controle.parseCor(cores.toString());
					figs.add(new Circulo(x, y, raios, colorido));
					fos = new FileOutputStream(controle.getArquivo());
					out = new ObjectOutputStream(fos);
					out.writeObject(figs);
					out.close();
					System.out.println("Object Persisted");
					JPanel areaDeInspiracao = new DesenhoView(figs);
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
				JPanel areaDeInspiracao = new DesenhoView(figs);
				controle.opcoesDelete();
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
					colorido = controle.parseCor(cores.toString());
					figs.add(new Retangulo(x, y, alt, larg, colorido));
					fos = new FileOutputStream(controle.getArquivo());
					out = new ObjectOutputStream(fos);
					out.writeObject(figs);
					out.close();
					System.out.println("Object Persisted");
					JPanel areaDeInspiracao = new DesenhoView(figs);
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
				paint2(figs.get(figs.size()), g);
				JPanel areaDeInspiracao = new DesenhoView(figs);
				controle.opcoesDelete();
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
					colorido = controle.parseCor(cores.toString());
					if(x1<0 || y1<0 || x2<0 || y2<0)
						throw new NegativoException();
					if(x1 > 1200 || y1 > 393 || x2 > 1200 || y2 > 393)
						throw new DesenhoException();
					else{
						figs.add(new Linha(x1, y1, x2, y2, colorido));
						fos = new FileOutputStream(controle.getArquivo());
						out = new ObjectOutputStream(fos);
						out.writeObject(figs);
						out.close();
						System.out.println("Object Persisted");
						JPanel areaDeInspiracao = new DesenhoView(figs);
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
				paint2(figs.get(figs.size()), g);
				controle.opcoesDelete();
			}
			
		};
	
	/*Criando o vigia para delete*/
	ActionListener vigiaDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			//Pega a op√ß√£o do usu√°rio no selecDet e faz remove(op√ß√£o escolhida)
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
	
	panel.setPreferredSize(new Dimension(1050,110));
	panel2.setPreferredSize(new Dimension(1050,30));
	panel3.setPreferredSize(new Dimension(1050,20));
	JPanel areaDeInspiracao = new DesenhoView(figs); //Panel para desenhos
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

}
