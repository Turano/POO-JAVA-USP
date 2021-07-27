import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface CadastrarRefeicao {
	JPanel panelCadastrarRefeicao = new JPanel(new GridLayout(4, 1));
	JPanel panelTitulos = new JPanel(new GridLayout(1, 1));
	JPanel panelInputsProteina = new JPanel(new GridLayout(1, 2));
	JPanel panelInputsCarboidrato = new JPanel(new GridLayout(1, 2));
	JPanel panelInputsGordura = new JPanel(new GridLayout(1, 2));

	JLabel labelQuantidade = new JLabel("Quantidade (em g):");

	JLabel labelProteina = new JLabel("Proteina");
	JTextField proteinaField = new JTextField();

	JLabel labelCarboidrato = new JLabel("Carboidrato");
	JTextField carboidratoField = new JTextField();

	JLabel labelGordura = new JLabel("Gordura");
	JTextField gorduraField = new JTextField();

}