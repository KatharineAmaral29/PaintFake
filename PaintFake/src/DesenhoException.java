import javax.swing.JOptionPane;

public class DesenhoException extends RuntimeException{
		public DesenhoException() {
			super("Nao cabe no desenho");
		}
		public void showMessage(){
			JOptionPane.showMessageDialog (null, "Valores informados para a figura não cabem no desenho! ", "Tente Novamente", JOptionPane.ERROR_MESSAGE);
		}
	}