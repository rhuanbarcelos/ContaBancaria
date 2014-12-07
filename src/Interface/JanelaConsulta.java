package Interface;
import BancoDeDados.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JanelaConsulta {
	
	JFrame janc;
	JTextField tffiltro;
	JButton btncarregar;
	JTextArea areat;
	JPanel pn1;
	JPanel pn2;
	JPanel pn3;
	Statement statement = null;
	
	JanelaConsulta()
	{
		janc = new JFrame("Consulta");
		tffiltro = new JTextField(26);
		btncarregar = new JButton("Carregar");
		areat = new JTextArea(12,35);
		JScrollPane scrollPane = new JScrollPane(areat); 
		areat.setEditable(false);
		
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		
		pn1.add(tffiltro);
		pn1.add(btncarregar);
		
		pn2.add(areat);
		
		pn3.add(pn1);
		pn3.add(pn2);
		
		janc.add(pn3, BorderLayout.CENTER);;
		janc.setSize(420, 300);
		janc.setVisible(true);
		// para abrir ao centro da tela
		janc.setLocationRelativeTo(null);
		// para que não seja redimensionada
		janc.setResizable(false);
		
		TrataEvento te = new TrataEvento();
		btncarregar.addActionListener(te);
	}
	
	// CLASSE INTERNA PARA TRATAMENTO DOS EVENTOS
	   private class TrataEvento implements ActionListener
	   {
	   	public void actionPerformed(ActionEvent e)
	   	{
	   			ConectaBanco con = new ConectaBanco();
	   			String sql = "Select * from pessoa";
				ResultSet rs;
				try {
					rs = statement.executeQuery(sql);
					while(rs.next())
					 {
						 String cod = rs.getString("codigo");
						 String nome = rs.getString("nome");
						 areat.append(cod+""+nome+ "\n");
						 
					 }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
	 
			 }
	   	}
	  }

