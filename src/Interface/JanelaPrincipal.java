package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import BancoDeDados.ConectaBanco;
import BancoDeDados.ManipulaBanco;
import Cliente.ContaCorrente;
import Cliente.ContaPoupanca;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;

import Excecao.ExcecaoCC;
import Excecao.ExcecaoCNPJ;
import Excecao.ExcecaoCP;
import Excecao.ExcecaoCPF;
import Excecao.ExcecaoCidade;
import Excecao.ExcecaoEstado;
import Excecao.ExcecaoIE;
import Excecao.ExcecaoNome;
import Excecao.ExcecaoSexo;
import Excecao.ExcecaoTelefone;

public class JanelaPrincipal {

	JFrame janela;
	ConectaBanco con = new ConectaBanco();
	ManipulaBanco man = new ManipulaBanco();
	

	String nome;
	String tel;
	String cpf;
	String sexo;
	String cnpj;
	String ie;
	String cidade;
	String estado;

	// RADIO BUTTON
	JRadioButton rbPF;
	JRadioButton rbPJ;
	JRadioButton rbCP;
	JRadioButton rbCC;

	// LABELS
	JLabel lblcod;
	JLabel lblnome;
	JLabel lbltel;
	JLabel lblcpf;
	JLabel lblsexo;
	JLabel lblcnpj;
	JLabel lblie;
	JLabel lblcidade;
	JLabel lblestado;
	JLabel lblnconta;
	JLabel lblsaldo;
	JLabel lblvalor;

	// TEXTFIELD
	JTextField tfcod;
	JTextField tfnome;
	JTextField tftel;
	JTextField tfcpf;
	JTextField tfcnpj;
	JTextField tfie;
	JTextField tfcidade;
	JTextField tfsaldo;
	JTextField tfvalor;
	JTextField tfnconta;

	// COMBOBOX
	JComboBox<String> cbsexo;
	JComboBox<String> cbestado;

	// BUTTON
	JButton btnnovo;
	JButton btnexcluir;
	JButton btnprox;
	JButton btnant;
	JButton btnfiltro;
	JButton btnsalvar;
	JButton btnlimpar;
	JButton btncarregar;
	JButton btndebitar;
	JButton btncreditar;
	JButton btnalterar;

	// PANELS
	JPanel pGeral;
	JPanel pn1;
	JPanel pn2;
	JPanel pn3;
	JPanel pn4;
	JPanel pn5;
	JPanel pn6;
	JPanel pn7;
	JPanel pn8;
	JPanel pn9;
	JPanel pn10;
	JPanel pn11;
	JPanel pn12;

	// CONSTRUTOR
	public JanelaPrincipal() {
		janela = new JFrame("Sistema Banco");

		// RADIO PESSOA
		rbPF = new JRadioButton("Pessoa Física");
		rbPF.setSelected(true);

		rbPJ = new JRadioButton("Pessoa Jurídica");

		// SERVER PARA QUANDO TIVER UM SELECIONADO O OUTRO Nï¿½O FICA
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbPF);
		bg.add(rbPJ);

		// BOTOES
		btnnovo = new JButton("Novo");
		btnexcluir = new JButton("Excluir");
		btnant = new JButton("Anterior");
		btnprox = new JButton("Próximo");
		btnfiltro = new JButton("Consultar");
		btnsalvar = new JButton("Salvar");
		btnlimpar = new JButton("Limpar");
		btncarregar = new JButton("Carregar");
		btndebitar = new JButton("Debitar");
		btncreditar = new JButton("Creditar");
		btnalterar = new JButton("Alterar");

		// CODIGO
		lblcod = new JLabel("Código");
		tfcod = new JTextField(5);

		// NOME
		lblnome = new JLabel("Nome");
		tfnome = new JTextField(25);

		// TELEFONE
		lbltel = new JLabel("Telefone");
		tftel = new JTextField(15);

		// CPF
		lblcpf = new JLabel("CPF");
		tfcpf = new JTextField(10);

		// SEXO
		lblsexo = new JLabel("Sexo");
		cbsexo = new JComboBox<String>();
		cbsexo.addItem("");
		cbsexo.addItem("Masculino");
		cbsexo.addItem("Feminino");

		// CNPJ
		lblcnpj = new JLabel("CNPJ");
		tfcnpj = new JTextField(10);

		// INSCRIï¿½ï¿½O ESTADUAL
		lblie = new JLabel("Inscrição Estadual");
		tfie = new JTextField(10);

		// CIDADE
		lblcidade = new JLabel("Cidade");
		tfcidade = new JTextField(10);

		// ESTADO
		lblestado = new JLabel("Estado");
		cbestado = new JComboBox<String>();
		cbestado.addItem("");
		cbestado.addItem("AC");
		cbestado.addItem("AL");
		cbestado.addItem("AP");
		cbestado.addItem("AM");
		cbestado.addItem("BA");
		cbestado.addItem("CE");
		cbestado.addItem("DF");
		cbestado.addItem("ES");
		cbestado.addItem("GO");
		cbestado.addItem("MA");
		cbestado.addItem("MT");
		cbestado.addItem("MS");
		cbestado.addItem("MG");
		cbestado.addItem("PA");
		cbestado.addItem("PB");
		cbestado.addItem("PR");
		cbestado.addItem("PE");
		cbestado.addItem("PI");
		cbestado.addItem("RJ");
		cbestado.addItem("RN");
		cbestado.addItem("RS");
		cbestado.addItem("RO");
		cbestado.addItem("RR");
		cbestado.addItem("SC");
		cbestado.addItem("SP");
		cbestado.addItem("SE");
		cbestado.addItem("TO");

		// CONTAS
		rbCP = new JRadioButton("Conta Poupança");
		rbCC = new JRadioButton("Conta Corrente");
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rbCP);
		bg2.add(rbCC);

		// NUMERO DA CONTA
		lblnconta = new JLabel("N° Conta");
		tfnconta = new JTextField(10);

		// SALDO DA CONTA
		lblsaldo = new JLabel("Saldo");
		tfsaldo = new JTextField(10);

		// VALOR
		lblvalor = new JLabel("Valor");
		tfvalor = new JTextField(10);

		// PAINELS
		pGeral = new JPanel();
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		pn4 = new JPanel();
		pn5 = new JPanel();
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		pn4 = new JPanel();
		pn5 = new JPanel();
		pn6 = new JPanel();
		pn7 = new JPanel();
		pn8 = new JPanel();
		pn9 = new JPanel();
		pn10 = new JPanel();
		pn11 = new JPanel();
		pn12 = new JPanel();

		pGeral.setLayout(new GridLayout(12, 2));
		pn1.setLayout (new FlowLayout()); pn2.setLayout (new FlowLayout());
 		pn3.setLayout (new FlowLayout()); pn4.setLayout (new FlowLayout());
 		pn5.setLayout (new FlowLayout()); pn6.setLayout (new FlowLayout());
 		pn7.setLayout (new FlowLayout()); pn8.setLayout (new FlowLayout());
		pn9.setLayout (new FlowLayout()); pn10.setLayout (new FlowLayout());
		pn11.setLayout (new FlowLayout()); pn12.setLayout (new FlowLayout());

		// LINHA 1
		pn1.add(rbPF);
		pn1.add(rbPJ);

		// LINHA 2
		pn2.add(lblcod);
		pn2.add(tfcod);
		pn2.add(btncarregar);

		// LINHA 3
		pn3.add(lblnome);
		pn3.add(tfnome);



		// LINHA 4
		pn4.add(lbltel);
		pn4.add(tftel);
		// LINHA 5
		pn5.add(lblcpf);
		pn5.add(tfcpf);
		pn5.add(lblsexo);
		pn5.add(cbsexo);

		// LINHA 5
		pn6.add(lblcnpj);
		pn6.add(tfcnpj);
		pn6.add(lblie);
		pn6.add(tfie);

		// LINHA 7
		pn7.add(lblcidade);
		pn7.add(tfcidade);
		pn7.add(lblestado);
		pn7.add(cbestado);
		
		//LINHA 8
		pn8.add(lblnconta);
		pn8.add(tfnconta);
		pn8.add(lblvalor);
		pn8.add (tfvalor);

		
		
		//LINHA 9
		pn9.add (rbCC);
		pn9.add (rbCP);		

		//LINHA 10

		
		pn10.add(btncreditar);
		pn10.add (btndebitar);
		
		//LINHA 11
		pn11.add (lblsaldo);
		pn11.add (tfsaldo);


		// LINHA 12
		pn12.add(btnsalvar);
		pn12.add(btnexcluir);
		pn12.add(btnalterar);
		pn12.add(btnfiltro);
		pn12.add(btnlimpar);

		pGeral.add(pn1);
		pGeral.add(pn2);
		pGeral.add(pn3);
		pGeral.add(pn4);
		pGeral.add(pn5);
		pGeral.add(pn6);
		pGeral.add(pn7);
		pGeral.add(pn8);
		pGeral.add(pn9);
		pGeral.add(pn10);
		pGeral.add(pn11);
		pGeral.add(pn12);

		// EVENTOS BOTOES
		TrataEvento te = new TrataEvento();
		btnsalvar.addActionListener(te);
		btnfiltro.addActionListener(te);
		btnlimpar.addActionListener(te);
		btncarregar.addActionListener(te);
		btnsalvar.addActionListener(te);
		btnexcluir.addActionListener(te);
		rbPJ.addActionListener(te);
		rbPF.addActionListener(te);


		

		janela.add(pGeral, BorderLayout.CENTER);
		janela.setLocationRelativeTo(null);
		janela.setSize(550, 550);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
	}

	// METODO PARA RETORNA O ID
	public int RetornaId() {
		int id = 0;

		try {
			id = con.getLastId();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			con.desconecta();
		}
		return id;
	}

	// CLASSE QUE PEGA E TRATA OS CAMPOS PREENCHIDOS NA JANELA
	public void PegarDados() {
		PessoaFisica pf = new PessoaFisica();
		try {
			pf.setNome(tfnome.getText());
			pf.setTelefone(tftel.getText());
			pf.end.setCidade(tfcidade.getText());
			pf.end.setEstado(cbestado.getSelectedItem());
		} catch (ExcecaoNome e1) {
			JOptionPane.showMessageDialog(null, e1.nomeDigitado());
		} catch (ExcecaoTelefone e1) {
			JOptionPane.showMessageDialog(null, e1.telefoneDigitado());
		} catch (ExcecaoCidade e1) {
			JOptionPane.showMessageDialog(null, e1.cidadeDigitado());
		} catch (ExcecaoEstado e1) {
			JOptionPane.showMessageDialog(null, e1.estadoDigitado());
		}finally{
			con.desconecta();
		}
		nome = pf.getNome();
		tel = pf.getTelefone();
		cidade = pf.end.getCidade();
		estado = pf.end.getEstado();

		// SE FOR SELECIONADO PESSOA FISICA
		if (rbPF.isSelected()) {
			try {
				pf.setCPF(tfcpf.getText());
				pf.setSexo(cbsexo.getSelectedItem());
			} catch (ExcecaoCPF e1) {
				JOptionPane.showMessageDialog(null, e1.cpfDigitado());
			} catch (ExcecaoSexo e1) {
				JOptionPane.showMessageDialog(null, e1.sexoDigitado());
			}finally{
				con.desconecta();
			}
			cpf = pf.getCPF();
			sexo = pf.getSexo();
		}

		// SE FOR SELECIONADO PESSOA JURIDICA
		if (rbPJ.isSelected()) {
			// cnpj = "78.425.986/0036-15";
			// ie = "123456789101";
			PessoaJuridica pj = new PessoaJuridica();
			try {
				pj.setCnpj(tfcnpj.getText());
				pj.setIe(tfie.getText());
			} catch (ExcecaoCNPJ e1) {
				JOptionPane.showMessageDialog(null, e1.cnpjDigitado());
			} catch (ExcecaoIE e1) {
				JOptionPane.showMessageDialog(null, e1.ieDigitado());
			}finally{
				con.desconecta();
			}

			cnpj = pj.getCnpj();
			ie = pj.getIe();
		}
		
		if (rbCC.isSelected()) {
			ContaCorrente cc = new ContaCorrente();
			try {
				cc.setNconta(tfnconta.getText());
			} catch (ExcecaoCC e1) {
				JOptionPane.showMessageDialog(null, e1.ncontaDigitado());
			}finally{
				con.desconecta();
			}
		}

	}

	private class TrataEvento implements ActionListener {
		
		public TrataEvento() {

		}
		
		

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnsalvar) {

				con.conecta();
				PegarDados();

				// INSERE NA TABELA PESSOA
				man.ida("INSERT INTO PESSOA (NOME, TELEFONE, CIDADE, ESTADO) VALUES('"+nome+ "','"+ tel+ "','"+ cidade+ "','"+ estado+ "')");
				
				// PEGA ULTIMO ID
				int id = RetornaId();

				// SE PF ESTIVER ATIVO INSERE NA TABELA FISICA
				if (rbPF.isSelected()) {
					man.ida("INSERT INTO FISICA (CODIGO, CPF, SEXO) VALUES('"+ id + "','" + cpf + "','" + sexo + "')");
				}

				// SE PJ ESTIVER ATIVO INSERE NA TABELA JURIDICA
				if (rbPJ.isSelected()) {
					man.ida("INSERT INTO JURIDICA (CODIGO, CNPJ, IE) VALUES ('"+ id + "', '" + cnpj + "', '" + ie + "')");
				}

				// PARA LIMPAR OS CAMPOS APOS SALVAR NO BANCO.
				tfnome.setText("");
				tftel.setText("");
				tfcpf.setText("");
				tfcidade.setText("");
				lblestado.setText("");
				tfnconta.setText("");
				tfsaldo.setText("");
				tfvalor.setText("");
			}
			
			if(e.getSource() == rbPJ){
				tfcpf.setEnabled(false);
				cbsexo.setEnabled(false);
				tfie.setEnabled(true);
				tfcnpj.setEnabled(true);

			}
			if(e.getSource() == rbPF){
				tfie.setEnabled(false);
				tfcnpj.setEnabled(false);
				tfcpf.setEnabled(true);
				cbsexo.setEnabled(true);

			}
			
			if (e.getSource() == btnexcluir) {
				con.conecta();
				String cod = tfcod.getText();
				man.ida("DELETE FROM PESSOA WHERE CODIGO = '" + cod + "')");
				con.desconecta();
			}

			if (e.getSource() == btncreditar) {
				ContaPoupanca c = new ContaPoupanca();
				String sal = tfsaldo.getText();
				String val = tfvalor.getText();
				double saldo = Double.parseDouble(sal);
				double valor = Double.parseDouble(val);
				saldo = c.creditar(saldo, valor);
				if (saldo < 0) {
					tfsaldo.setForeground(Color.red);
				}
				tfsaldo.setText("" + saldo);
				JOptionPane.showMessageDialog(null, "R$" + valor+ " creditado com sucesso!");
			}

			if (e.getSource() == btnalterar) {
				con.conecta();
				PegarDados();
				String cod = tfcod.getText();
				man.ida("UPDATE PESSOA SET NOME = '" + nome + "', TELEFONE = '"+ tel + "', CIDADE = '" + cidade + "', ESTADO = '"+ estado + "' WHERE CODIGO = '" + cod + "')");
				con.desconecta();
			}

			if (e.getSource() == btnfiltro) {
				JanelaConsulta jc = new JanelaConsulta();
			}

			if (e.getSource() == btnlimpar) {
				tfnome.setText("");
				tftel.setText("");
				tfcpf.setText("");
				tfcidade.setText("");
				lblestado.setText("");
				tfnconta.setText("");
				tfsaldo.setText("");
				tfvalor.setText("");

			}
		}
	}
}
