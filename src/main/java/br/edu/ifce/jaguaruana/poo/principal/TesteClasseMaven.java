package br.edu.ifce.jaguaruana.poo.principal;

import org.apache.commons.lang3.StringUtils;

public class TesteClasseMaven {

	public static void main(String[] args) {	
		Conexao con = new Conexao("root", "ifcejaguaruana", "localhost", "agenda_telefonica_01");
		System.out.println(con.conecta());
		
		con.imprimeConsulta("select * from pessoas");
		con.executaSql("update pessoas set nome = 'Alisson Alencar' where id = 1");
		con.imprimeConsulta("select * from pessoas");
		con.executaSql("update pessoas set nome = 'Alisson Sampaio de C. Alencar' where id = 1");		

	}

}
