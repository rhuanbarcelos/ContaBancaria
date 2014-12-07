package BancoDeDados;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaBanco {
		Connection connection = null; 
		ResultSet resultSet = null; 
		Statement statement = null; 

		 
		 //Metodo Conecta Banco
		 public void conecta() { 
			 try { 
				 Class.forName("org.h2.Driver");
				 connection = DriverManager.getConnection("jdbc:h2:lib//bdAplicacao","sa","");
			 } catch (Exception e) { 
				 e.printStackTrace(); 
			 }
			 
		 }
		 
		//Metodo Desconecta Banco
		 public void desconecta(){
			 try {
				 //statement.close();
				 connection.close();
			 } catch (SQLException e) {
				 e.printStackTrace();

			 }
		 }
		 
		 public int getLastId() throws SQLException{ 
			 String sql = "SELECT MAX(CODIGO) as id FROM PESSOA"; 
			 PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql); 
			 ResultSet rs = stmt.executeQuery(); 
			 rs.next(); 
			 int lastId = rs.getInt("id"); 

			 ///rs.close(); 
			 //stmt.close(); 
			 //desconecta();
			 return lastId; 
			 } 
		 
		 public void carregarCampos(String sql) throws SQLException
		 {
			 ResultSet rs = statement.executeQuery(sql);
			 try  
	            {  
	  
	                        rs.first();  
	                      //  tfnome.setText(rs.getString("NOME"));
	            }  
	  
	            catch(SQLException ex)  
	            {  
	                ex.printStackTrace();  
	            }  
			 //desconecta();
		 }

 }
		 


