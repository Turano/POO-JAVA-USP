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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Layout extends JFrame implements ActionListener, CadastrarRefeicao {

	private int count = 0;
	private JPanel panel, buttonsPanel, objetivoPanel, esqPanel, dirPanel, topPanel, contentPanel, pessoaInfoPanel,
			nomePanel, idadePanel, alturaPanel, pesoPanel, sexoPanel, freqAtivFisicaPanel;
	private JLabel label;
	private JLabel nomeLabel, objetivoLabel, idadeLabel, alturaLabel, pesoLabel, sexoLabel, freqAtivFisicaLabel;
	private JTextField nomeField, idadeField, alturaField, pesoField;
//	private JRadioButton radioButtonEmagrecimento, radioButtonGanhoPeso, radioButtonGanhoMassaMuscular,
//			radioButtonSaude;
	private JButton button, button1;
	private JComboBox<String> sexoDropDown, freqAtivFisicaDropDown, objetivoDropDown;

	private JPanel resultadosPanel, titlePanel, IMCPanel, consCalBasPanel, consCalDiarPanel, ingestaoPanel;
	private JLabel resultadosTituloLabel, calcIMCTitleLabel, calcIMCTextLabel, calcIMCText2Label, consCalBasTitleLabel,
			consCalBasTextLabel, consCalDiarTitleLabel, consCalDiarTextLabel, ingestaoTitleLabel, ingestaoTextLabel,
			consumoTitleLabel, consumoTextLabel, consumoTextSmallLable;

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

		resultadosPanel = new JPanel(new GridLayout(5, 1));
		titlePanel = new JPanel(new FlowLayout());
		IMCPanel = new JPanel(new GridLayout(4, 1));
		consCalBasPanel = new JPanel(new GridLayout(1, 2));
		consCalDiarPanel = new JPanel(new GridLayout(3, 1));
		ingestaoPanel = new JPanel(new GridLayout(3, 2));

		label = new JLabel("Bem vindo ao app do e-Saude");

		// ----------------- lado esquerdo ----------------------------------

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

		freqAtivFisicaLabel = new JLabel("Frequência de atividade física:");
		freqAtivFisicaDropDown = new JComboBox<String>();
		freqAtivFisicaDropDown.addItem("Escolha uma frequência semanal");
		freqAtivFisicaDropDown.addItem("Menos de 3 sessões");
		freqAtivFisicaDropDown.addItem("3 a 5 sessões");
		freqAtivFisicaDropDown.addItem("Mais de 5 sessões");

		objetivoLabel = new JLabel("Objetivo");
		objetivoDropDown = new JComboBox<String>();
		objetivoDropDown.addItem("Escolha um objetivo");
		objetivoDropDown.addItem("Emagrecimento");
		objetivoDropDown.addItem("Ganho de peso/massa muscular");
		objetivoDropDown.addItem("Saude");

		button = new JButton("Confirma");
		button1 = new JButton("Limpar");

		// panel
		topPanel.add(label);

		esqPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
		dirPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
		panel.add(topPanel);
		panel.add(contentPanel);
		contentPanel.add(esqPanel);
		contentPanel.add(dirPanel);

		// pessoaInfoPanel
		esqPanel.add(pessoaInfoPanel);
		dirPanel.add(resultadosPanel);

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
		objetivoPanel.add(objetivoDropDown);
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

		// ----------------- lado direito ----------------------------------

		dirPanel.setBorder(new LineBorder(Color.black, 3, true));

		resultadosTituloLabel = new JLabel("Resultados");

		calcIMCTitleLabel = new JLabel("Calculadora IMC");
		calcIMCTextLabel = new JLabel("Aqui ira aparecer o seu resultado!");
		calcIMCText2Label = new JLabel("Aqui ira aparecer o seu resultado 2!");

		consCalBasTitleLabel = new JLabel("Cálculo do seu consumo calórico basal:");
		consCalBasTextLabel = new JLabel("___ Kcal");

		consCalDiarTitleLabel = new JLabel("Cálculo do seu consumo calórico diário (basal + atividades físicas):");
		consCalDiarTextLabel = new JLabel("___ Kcal");

		ingestaoTitleLabel = new JLabel("META de ingestão de hoje:");
		ingestaoTextLabel = new JLabel("___ Kcal");

		consumoTitleLabel = new JLabel("Seu consumo hoje:");
		consumoTextLabel = new JLabel("___ Kcal");
		consumoTextSmallLable = new JLabel("Aqui aparecerá seu resultado!");

		// titlePanel + IMCPanel
		titlePanel.add(resultadosTituloLabel);
		IMCPanel.add(titlePanel);
		IMCPanel.add(calcIMCTitleLabel);
		IMCPanel.add(calcIMCTextLabel);
		IMCPanel.add(calcIMCText2Label);
		resultadosPanel.add(IMCPanel);

		// consCalBasPanel
		consCalBasPanel.add(consCalBasTitleLabel);
		consCalBasPanel.add(consCalBasTextLabel);
		resultadosPanel.add(consCalBasPanel);

		// consCalDiarPanel
		consCalDiarPanel.add(consCalDiarTitleLabel);
		consCalDiarPanel.add(consCalDiarTextLabel);
		resultadosPanel.add(consCalDiarPanel);

		// ingestaoPanel
		ingestaoPanel.add(ingestaoTitleLabel);
		ingestaoPanel.add(ingestaoTextLabel);
		ingestaoPanel.add(consumoTitleLabel);
		ingestaoPanel.add(consumoTextLabel);
		ingestaoPanel.add(consumoTextSmallLable);
		resultadosPanel.add(ingestaoPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
		CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();

		if ("confirma".equals(e.getActionCommand())) {
			String nome = nomeField.getText();
			String pesoString = pesoField.getText();
			String alturaString = alturaField.getText();
			String idadeString = idadeField.getText();
			String sexo = (String) sexoDropDown.getSelectedItem();
			String freqAtivFisica = (String) freqAtivFisicaDropDown.getSelectedItem();
			String objetivoSelecionado = (String) objetivoDropDown.getSelectedItem();

			double peso = Double.parseDouble(pesoString);
			double altura = Double.parseDouble(alturaString);
			int idade = Integer.parseInt(idadeString);

			NivelDeAtividadeFisica nivelAtivFis = null;

			if (freqAtivFisica.equals("Menos de 3 sessões")) {
				nivelAtivFis = NivelDeAtividadeFisica.LEVE;
			} else if (freqAtivFisica.equals("3 a 5 sessões")) {
				nivelAtivFis = NivelDeAtividadeFisica.MODERADA;
			} else if (freqAtivFisica.equals("Mais de 5 sessões")) {
				nivelAtivFis = NivelDeAtividadeFisica.INTENSA;
			}

			Objetivo objetivo = null;
			if (objetivoSelecionado.equals("Emagrecimento")) {
				objetivo = Objetivo.EMAGRECIMENTO;
			} else if (objetivoSelecionado.equals("Ganho de peso/massa muscular")) {
				objetivo = Objetivo.GANHO_MUSCULAR;
			} else if (objetivoSelecionado.equals("Saude")) {
				objetivo = Objetivo.SAUDE;
			}

			if (sexo.equals("Masculino")) {

				IndividuoMasculino indivMasc = new IndividuoMasculino(peso, altura, idade, nivelAtivFis, objetivo);

				calcIMCTextLabel.setText(nome + " de idade " + idade + " pesando " + peso + "kg, de altura " + altura
						+ "cm tem IMC: " + String.format("%.2f", calculadoraIMC.getIMC(indivMasc)) + " -> "
						+ calculadoraIMC.getHealthCondition(indivMasc));

				calcIMCText2Label.setText("nivel Ativ Fisica: " + nivelAtivFis + " e objetivo: " + objetivo);

			} else if (sexo.equals("Feminino")) {

				IndividuoFeminino indivFem = new IndividuoFeminino(peso, altura, idade, nivelAtivFis, objetivo);

				calcIMCTextLabel.setText(nome + " de idade " + idade + " pesando " + peso + "kg, de altura " + altura
						+ "cm tem IMC: " + String.format("%.2f", calculadoraIMC.getIMC(indivFem)) + " -> "
						+ calculadoraIMC.getHealthCondition(indivFem));

				calcIMCText2Label.setText("nivel Ativ Fisica: " + nivelAtivFis + " e objetivo: " + objetivo);
			}

		}

//		System.out.println(calculadoraIMC.getIMC(i1));
//		System.out.println(calculadoraIMC.getHealthCondition(i2));
//		System.out.println(NivelDeAtividadeFisica.LEVE);
//		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[0]);
//		System.out.println(NivelDeAtividadeFisica.LEVE.getFatorDeAtividade()[1]);
//		System.out.println(calculadoraMetabolica.getTMB(i1));
//		System.out.println(calculadoraMetabolica.getNDC(i2));
	}

}
