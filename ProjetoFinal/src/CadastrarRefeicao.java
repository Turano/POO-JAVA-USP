import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface CadastrarRefeicao {
	JPanel panelCadastrarRefeicao = new JPanel(new GridLayout(5, 2));
	JPanel panelTitulos = new JPanel(new GridLayout(1, 2));
	JPanel panelInputs = new JPanel(new GridLayout(1, 2));

	JLabel labelAlimento = new JLabel("Alimento");
	JLabel labelQuantidade = new JLabel("Quantidade");

	JTextField inserirAlimento = new JTextField();
	JTextField inserirQuantidade = new JTextField();

}
