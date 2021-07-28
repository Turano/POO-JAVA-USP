import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

	private JPanel panel, buttonsPanel, objetivoPanel, esqPanel, dirPanel, topPanel, contentPanel, pessoaInfoPanel,
			nomePanel, idadePanel, alturaPanel, pesoPanel, sexoPanel, freqAtivFisicaPanel;
	private JLabel label;
	private JLabel nomeLabel, objetivoLabel, idadeLabel, alturaLabel, pesoLabel, sexoLabel, freqAtivFisicaLabel;
	private JTextField nomeField, idadeField, alturaField, pesoField;
	private JButton button;
	private JComboBox<String> sexoDropDown, freqAtivFisicaDropDown, objetivoDropDown;

	private JPanel resultadosPanel, titlePanel, IMCPanel, consCalBasPanel, consCalDiarPanel, ingestaoPanel;
	private JLabel resultadosTituloLabel, calcIMCTitleLabel, calcIMCTextLabel, calcIMCSintomasTextLabel,
			calcIMCText2Label, consCalBasTitleLabel, consCalBasTextLabel, consCalDiarTitleLabel, consCalDiarTextLabel,
			ingestaoTitleLabel, ingestaoTextLabel, consumoTitleLabel, consumoTextLabel;

	public Layout() {
		super("e-Saude: Monitor de gasto calorico");
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
		freqAtivFisicaPanel = new JPanel(new GridLayout(3, 1));
		objetivoPanel = new JPanel(new GridLayout(3, 1));
		buttonsPanel = new JPanel(new FlowLayout());

		resultadosPanel = new JPanel(new GridLayout(5, 1));
		titlePanel = new JPanel(new FlowLayout());
		IMCPanel = new JPanel(new GridLayout(5, 1));
		consCalBasPanel = new JPanel(new GridLayout(1, 2));
		consCalDiarPanel = new JPanel(new GridLayout(1, 1));
		ingestaoPanel = new JPanel(new GridLayout(3, 2));

		label = new JLabel("Bem vindo ao app do e-Saude");
		label.setFont(new Font("Roboto", Font.PLAIN, 25));

		// ----------------- lado esquerdo ----------------------------------

		nomeLabel = new JLabel("Digite seu nome:");
		nomeLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		nomeField = new JTextField();

		idadeLabel = new JLabel("Digite sua idade:");
		idadeLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		idadeField = new JTextField();

		alturaLabel = new JLabel("Digite sua altura (em cm):");
		alturaLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		alturaField = new JTextField();

		pesoLabel = new JLabel("Digite seu peso (em kg):");
		pesoLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		pesoField = new JTextField();

		sexoLabel = new JLabel("Selecione o seu sexo:");
		sexoLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		sexoDropDown = new JComboBox<String>();
		sexoDropDown.addItem("Masculino");
		sexoDropDown.addItem("Feminino");

		freqAtivFisicaLabel = new JLabel("Frequencia de atividade fisica:");
		freqAtivFisicaLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		freqAtivFisicaDropDown = new JComboBox<String>();
		freqAtivFisicaDropDown.addItem("Menos de 3 sessoes");
		freqAtivFisicaDropDown.addItem("3 a 5 sessoes");
		freqAtivFisicaDropDown.addItem("Mais de 5 sessoes");

		objetivoLabel = new JLabel("Objetivo:");
		objetivoLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		objetivoDropDown = new JComboBox<String>();
		objetivoDropDown.addItem("Emagrecimento");
		objetivoDropDown.addItem("Ganho de peso/massa muscular");
		objetivoDropDown.addItem("Saude");

		button = new JButton("Confirma");

		// panel
		topPanel.add(label);

		esqPanel.setBorder(BorderFactory.createEmptyBorder(40, 15, 15, 15));
		dirPanel.setBorder(BorderFactory.createEmptyBorder(40, 15, 15, 15));
		panel.add(topPanel);
		panel.add(contentPanel);
		contentPanel.add(esqPanel);
		contentPanel.add(dirPanel);

		// pessoaInfoPanel
		esqPanel.add(pessoaInfoPanel);
		dirPanel.add(resultadosPanel);
		resultadosPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

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
		panelCadastrarRefeicao.add(panelInputsProteina);
		panelCadastrarRefeicao.add(panelInputsCarboidrato);
		panelCadastrarRefeicao.add(panelInputsGordura);

		labelQuantidade.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelTitulos.add(labelQuantidade);

		labelProteina.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelInputsProteina.add(labelProteina);
		panelInputsProteina.add(proteinaField);

		labelCarboidrato.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelInputsCarboidrato.add(labelCarboidrato);
		panelInputsCarboidrato.add(carboidratoField);

		labelGordura.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelInputsGordura.add(labelGordura);
		panelInputsGordura.add(gorduraField);

		// buttonsPanel
		buttonsPanel.add(button);
		esqPanel.add(buttonsPanel);

		button.addActionListener(this);
		button.setActionCommand("confirma");

		// ----------------- lado direito ----------------------------------

		dirPanel.setBorder(new LineBorder(Color.gray, 4, true));

		resultadosTituloLabel = new JLabel("Resultados");
		resultadosTituloLabel.setFont(new Font("Roboto", Font.PLAIN, 22));

		calcIMCTitleLabel = new JLabel("Calculadora IMC");
		calcIMCTitleLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		calcIMCTextLabel = new JLabel("Aqui aparecera o seu resultado!");
		calcIMCTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		calcIMCSintomasTextLabel = new JLabel("");
		calcIMCSintomasTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		calcIMCText2Label = new JLabel("");
		calcIMCText2Label.setFont(new Font("Roboto", Font.PLAIN, 14));

		consCalBasTitleLabel = new JLabel("Calculo do seu consumo calorico basal:");
		consCalBasTitleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		consCalBasTextLabel = new JLabel("___ Kcal");
		consCalBasTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));

		consCalDiarTitleLabel = new JLabel(
				"<html><p>Calculo do seu consumo calorico diario (basal + atividades fisicas):</p></html>");
		consCalDiarTitleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		consCalDiarTextLabel = new JLabel("___ Kcal");
		consCalDiarTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));

		ingestaoTitleLabel = new JLabel("Meta de ingestao de hoje:");
		ingestaoTitleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		ingestaoTextLabel = new JLabel("___ Kcal");
		ingestaoTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));

		consumoTitleLabel = new JLabel("Seu consumo hoje:");
		consumoTitleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		consumoTextLabel = new JLabel("___ Kcal");
		consumoTextLabel.setFont(new Font("Roboto", Font.PLAIN, 14));

		// titlePanel + IMCPanel
		titlePanel.add(resultadosTituloLabel);
		IMCPanel.add(titlePanel);
		IMCPanel.add(calcIMCTitleLabel);
		IMCPanel.add(calcIMCTextLabel);
		IMCPanel.add(calcIMCSintomasTextLabel);
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
		ingestaoPanel.add(consumoTitleLabel);
		ingestaoPanel.add(consumoTextLabel);
		ingestaoPanel.add(ingestaoTitleLabel);
		ingestaoPanel.add(ingestaoTextLabel);
		resultadosPanel.add(ingestaoPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
		CalculadoraMetabolica calculadoraMetabolica = new CalculadoraMetabolica();
		Refeicao refeicao;

		if ("confirma".equals(e.getActionCommand())) {
			String nome = nomeField.getText();
			String pesoString = pesoField.getText();
			String alturaString = alturaField.getText();
			String idadeString = idadeField.getText();
			String sexo = (String) sexoDropDown.getSelectedItem();
			String freqAtivFisica = (String) freqAtivFisicaDropDown.getSelectedItem();
			String objetivoSelecionado = (String) objetivoDropDown.getSelectedItem();
			String porcaoDeProteinaString = (String) proteinaField.getText();
			String porcaoDeCarboidratoString = (String) carboidratoField.getText();
			String porcaoDeGorduraString = (String) gorduraField.getText();

			double peso = Double.parseDouble(pesoString);
			double altura = Double.parseDouble(alturaString);
			int idade = Integer.parseInt(idadeString);

			int porcaoDeProteina = Integer.parseInt(porcaoDeProteinaString);
			int porcaoDeCarboidrato = Integer.parseInt(porcaoDeCarboidratoString);
			int porcaoDeGordura = Integer.parseInt(porcaoDeGorduraString);

			NivelDeAtividadeFisica nivelAtivFis = null;
			if (freqAtivFisica.equals("Menos de 3 sessoes")) {
				nivelAtivFis = NivelDeAtividadeFisica.LEVE;
			} else if (freqAtivFisica.equals("3 a 5 sessoes")) {
				nivelAtivFis = NivelDeAtividadeFisica.MODERADA;
			} else if (freqAtivFisica.equals("Mais de 5 sessoes")) {
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

			refeicao = new Refeicao(porcaoDeCarboidrato, porcaoDeProteina, porcaoDeGordura);

			consumoTextLabel.setText(String.format("%.2f", refeicao.getCalorias()) + " Kcal");

			if (sexo.equals("Masculino")) {

				IndividuoMasculino indivMasc = new IndividuoMasculino(peso, altura, idade, nivelAtivFis, objetivo);

				calcIMCTextLabel.setText("<html><p>" + nome + ", seu IMC tem valor "
						+ String.format("%.2f", calculadoraIMC.getIMC(indivMasc)) + ", assim sendo classificado como: "
						+ calculadoraIMC.getHealthCondition(indivMasc).getTituloDaClassificacao() + "</p></html>");

				calcIMCSintomasTextLabel.setText((String.format("<html><p>%s<br/></p></html>",
						calculadoraIMC.getHealthCondition(indivMasc).getSintomas())));

				calcIMCText2Label.setText(
						String.format("<html><p>%s<br/></p></html>", calculadoraIMC.getSugestaoDePeso(indivMasc)));

				consCalBasTextLabel.setText(String.format("%.2f", calculadoraMetabolica.getTMB(indivMasc)) + " Kcal");

				consCalDiarTextLabel.setText(String.format("%.2f", calculadoraMetabolica.getNDC(indivMasc)) + " Kcal");

				if (refeicao.getCalorias() < calculadoraMetabolica.getNDC(indivMasc)) {

					ingestaoTextLabel.setText("<html><p>Voce ainda deve consumir "
							+ String.format("%.2f", (calculadoraMetabolica.getNDC(indivMasc) - refeicao.getCalorias()))
							+ " Kcal.</p></html>");

				} else {

					ingestaoTextLabel.setText(
							"<html><p>Parabens, voce consumiu a quantidade de calorias necessarias!<br/></p></html>");

				}

			} else if (sexo.equals("Feminino")) {

				IndividuoFeminino indivFem = new IndividuoFeminino(peso, altura, idade, nivelAtivFis, objetivo);

				calcIMCTextLabel.setText("<html><p>" + nome + ", seu IMC tem valor "
						+ String.format("%.2f", calculadoraIMC.getIMC(indivFem)) + ", assim sendo classificado como: "
						+ calculadoraIMC.getHealthCondition(indivFem).getTituloDaClassificacao() + "</p></html>");

				calcIMCSintomasTextLabel.setText((String.format("<html><p>%s<br/></p></html>",
						calculadoraIMC.getHealthCondition(indivFem).getSintomas())));

				calcIMCText2Label.setText(
						String.format("<html><p>%s<br/></p></html>", calculadoraIMC.getSugestaoDePeso(indivFem)));

				consCalBasTextLabel.setText(String.format("%.2f", calculadoraMetabolica.getTMB(indivFem)) + " Kcal");

				consCalDiarTextLabel.setText(String.format("%.2f", calculadoraMetabolica.getNDC(indivFem)) + " Kcal");

				if (refeicao.getCalorias() < calculadoraMetabolica.getNDC(indivFem)) {

					ingestaoTextLabel.setText("<html><p>Voce ainda deve consumir "
							+ String.format("%.2f", (calculadoraMetabolica.getNDC(indivFem) - refeicao.getCalorias()))
							+ " Kcal.</p></html>");

				} else {

					ingestaoTextLabel.setText(
							"<html><p>Parabens, voce consumiu a quantidade de calorias necessarias!<br/></p></html>");

				}

			}

		}
	}

}