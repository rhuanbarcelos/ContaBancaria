package BancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


	public class ManipulaBanco {
		Connection connection = null; 
		ResultSet resultSet = null; 
		Statement statement = null; 
		public List <String> resp;
		
		// Metodo IDA - Inserir, Deletar e Alterar
		public void ida(String sql){
			 try{
				 statement = connection.createStatement();
				 statement.executeUpdate(sql);
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		
		// Metodo Pesquisa
		public void consulta(String sql){
		 try{
			 	resp = new ArrayList<String>();
			 	statement = connection.createStatement(); 
			 	resultSet = statement.executeQuery(sql);
			 	while (resultSet.next()) {
				 	resp.add(resultSet.getString("nome"));
				 	resp.add(resultSet.getString("telefone"));
			 	}
			 	for(int i=0; i<resp.size(); i++){
				 	System.out.println(resp.get(i));
			 	}
		 		} catch (Exception e) { 
		 			e.printStackTrace(); 
		 		}
			}
	 

}
