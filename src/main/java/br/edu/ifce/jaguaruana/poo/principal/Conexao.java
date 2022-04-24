package br.edu.ifce.jaguaruana.poo.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.sql.ResultSet;

public class Conexao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	private String usuario;
	private String senha;
	private String servidor;
	private String banco;
	
	public Conexao(String usuario, String senha, String servidor, String banco) {
		this.usuario = usuario;
		this.senha = senha;
		this.servidor = servidor;
		this.banco = banco;
	}
	
	public boolean conecta() {
		try {
		    String url = "jdbc:mysql://"+servidor+"/"+banco+"?";
		    conn = DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return false;
		}		
		return true;
	}
	
	public void imprimeConsulta(String sql) {
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
    
		    while (rs.next()) {
		    	for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
		    		System.out.print("\t"+rs.getString(i+1));					
				}		        
		        System.out.println("");
		    }		    
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void executaSql(String sql) {
		try {
		    stmt = conn.createStatement();
		    stmt.execute(sql);		    
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}		
	}
}
