import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Layout extends JFrame implements ActionListener, CadastrarRefeicao {

	private int count = 0;
	private JPanel panel, buttonsPanel, objetivoPanel, esqPanel, dirPanel, topPanel, contentPanel, pessoaInfoPanel,
			nomePanel, idadePanel, alturaPanel, pesoPanel, sexoPanel, freqAtivFisicaPanel;
	private JLabel label;
	private JLabel nomeLabel, objetivoLabel, idadeLabel, alturaLabel, pesoLabel, sexoLabel, freqAtivFisicaLabel;
	private JTextField nomeField, idadeField, alturaField, pesoField;
	private JRadioButton radioButtonEmagrecimento, radioButtonGanhoPeso, radioButtonGanhoMassaMuscular,
			radioButtonSaude;
	private JButton button, button1;
	private JComboBox<String> sexoDropDown, freqAtivFisicaDropDown;

	public Layout() {
		super("e-Saude");
		panel = (JPanel) this.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		buttonsPanel = (JPanel) this.getContentPane();

		topPanel = new JPanel(new FlowLayout());
		contentPanel = new JPanel(new GridLayout(1, 2));

		esqPanel = new JPanel(new GridLayout(5, 1));
		dirPanel = new JPanel(new GridLayout(1, 1));

		pessoaInfoPanel = new JPanel(new GridLayout(3, 2));
		nomePanel = new JPanel(new GridLayout(2, 1));
		idadePanel = new JPanel(new GridLayout(2, 1));
		alturaPanel = new JPanel(new GridLayout(2, 1));
		pesoPanel = new JPanel(new GridLayout(2, 1));
		sexoPanel = new JPanel(new GridLayout(2, 1));
		freqAtivFisicaPanel = new JPanel(new GridLayout(2, 1));

		objetivoPanel = new JPanel(new GridLayout(5, 1));
		buttonsPanel = new JPanel(new FlowLayout());

		//
		panel.setBackground(Color.red);

		label = new JLabel("Bem vindo ao app do e-Saude");

		nomeLabel = new JLabel("Digite seu nome:");
		nomeField = new JTextField();

		idadeLabel = new JLabel("Digite sua idade");
		idadeField = new JTextField();

		alturaLabel = new JLabel("Digite sua altura:");
		alturaField = new JTextField();

		pesoLabel = new JLabel("Digite seu peso:");
		pesoField = new JTextField();

		sexoLabel = new JLabel("Selecione o seu sexo:");
		sexoDropDown = new JComboBox<String>();
		sexoDropDown.addItem("Masculino");
		sexoDropDown.addItem("Feminino");
		sexoDropDown.addItem("Outro");

		freqAtivFisicaLabel = new JLabel("Frequência de atividade física:");
		freqAtivFisicaDropDown = new JComboBox<String>();
		freqAtivFisicaDropDown.addItem("Menos de 3 sessões");
		freqAtivFisicaDropDown.addItem("3 a 5 sessões");
		freqAtivFisicaDropDown.addItem("Mais de 5 sessões");

		objetivoLabel = new JLabel("Objetivo");
		radioButtonEmagrecimento = new JRadioButton("Emagrecimento", false);
		radioButtonGanhoPeso = new JRadioButton("Ganho de peso", false);
		radioButtonGanhoMassaMuscular = new JRadioButton("Ganho de massa muscular", false);
		radioButtonSaude = new JRadioButton("Saude", false);

		button = new JButton("Confirma");
		button1 = new JButton("Limpar");

		// panel
		topPanel.add(label);

//		esqPanel.setBackground(Color.blue);
//		dirPanel.setBackground(Color.green);
//		topPanel.setBackground(Color.pink);
		esqPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
		panel.add(topPanel);
		panel.add(contentPanel);
		contentPanel.add(esqPanel);
		contentPanel.add(dirPanel);

		// pessoaInfoPanel
		esqPanel.add(pessoaInfoPanel);

		// nomePanel
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeField);
		pessoaInfoPanel.add(nomePanel);

		// idadePanel
		idadePanel.add(idadeLabel);
		idadePanel.add(idadeField);
		pessoaInfoPanel.add(idadePanel);

		// alturaPanel
		alturaPanel.add(alturaLabel);
		alturaPanel.add(alturaField);
		pessoaInfoPanel.add(alturaPanel);

		// pesoPanel
		pesoPanel.add(pesoLabel);
		pesoPanel.add(pesoField);
		pessoaInfoPanel.add(pesoPanel);

		// sexoPanel
		sexoPanel.add(sexoLabel);
		sexoPanel.add(sexoDropDown);
		pessoaInfoPanel.add(sexoPanel);

		// freqAtivFisicaPanel
		freqAtivFisicaPanel.add(freqAtivFisicaLabel);
		freqAtivFisicaPanel.add(freqAtivFisicaDropDown);
		esqPanel.add(freqAtivFisicaPanel);

		// objetivoPanel
		objetivoPanel.add(objetivoLabel);
		objetivoPanel.add(radioButtonEmagrecimento);
		objetivoPanel.add(radioButtonGanhoPeso);
		objetivoPanel.add(radioButtonGanhoMassaMuscular);
		objetivoPanel.add(radioButtonSaude);
		esqPanel.add(objetivoPanel);

		// cadastrarRefeicaoPanel
		esqPanel.add(panelCadastrarRefeicao);
		panelCadastrarRefeicao.add(panelTitulos);
		panelCadastrarRefeicao.add(panelInputs);
		panelCadastrarRefeicao.add(panelInputs1);
		panelTitulos.add(labelAlimento);
		panelTitulos.add(labelQuantidade);
		panelInputs.add(inserirAlimento);
		panelInputs.add(inserirQuantidade);
		panelInputs1.add(inserirAlimento1);
		panelInputs1.add(inserirQuantidade1);

		// buttonsPanel
		buttonsPanel.add(button);
		buttonsPanel.add(button1);
		esqPanel.add(buttonsPanel);

		button.addActionListener(this);
		button.setActionCommand("confirma");
		button1.addActionListener(this);
		button1.setActionCommand("limpa");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean preenchido;
		if ("confirma".equals(e.getActionCommand())) {
			String cor = nomeField.getText();
//			if (radioButtonTrue.isSelected()) {
			preenchido = true;
//			} else {
//				preenchido = false;
//			}
			String valorString = idadeField.getText();
			int raio = Integer.parseInt(valorString);

//			Circulo circulo = new Circulo(cor, preenchido, raio);
//			double areaCirculo = circulo.calculaArea(circulo);
			double areaCirculo = 10;

			if (preenchido == true) {
				label.setText("Circulo de cor " + cor + " e de area " + areaCirculo);
			} else {
				label.setText("Circulo de area " + areaCirculo);
			}

		} else if ("limpa".equals(e.getActionCommand())) {
			nomeField.setText("");
			label.setText("Bem vindo");

		}

	}

}
