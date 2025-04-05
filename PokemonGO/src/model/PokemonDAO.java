package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DbConnect;

public class PokemonDAO {

	public void carregar_dades_prova() throws SQLException {

		
        Connection conn = null;

        //ELS 3 pstmt de cada taula
        PreparedStatement pstmtEntrenador = null;
        PreparedStatement pstmtPokemon = null;
        PreparedStatement pstmtCaptura = null;
        
        
        try {
        	
            conn = DbConnect.getConnection();

            String sqlEntrenador = "INSERT INTO entrenadors (name, password) VALUES (?, ?)";
            pstmtEntrenador = conn.prepareStatement(sqlEntrenador);
            pstmtEntrenador.setString(1, "pau");
            pstmtEntrenador.setString(2, "passwd");
            pstmtEntrenador.executeUpdate();
            
            String sqlPokemon = "INSERT INTO pokemon (num_pokedex, name, type) VALUES (?, ?, ?)";
            pstmtPokemon = conn.prepareStatement(sqlPokemon);
            pstmtPokemon.setInt(1, 25); 
            pstmtPokemon.setString(2, "pikachuu");
            pstmtPokemon.setString(3, "electirc");
            pstmtPokemon.executeUpdate();
            
            String sqlPokemoncapturat = "INSERT INTO pokemons_capturats (entrenador_id, pokedex_number, forca_combat) VALUES (?, ?, ?)";
            pstmtCaptura = conn.prepareStatement(sqlPokemoncapturat);
            pstmtCaptura.setInt(1, 1);
            pstmtCaptura.setInt(2, 25);
            pstmtCaptura.setInt(3, 100);
            pstmtCaptura.executeUpdate();


            System.out.println("Tot s'ha afegit a la bd correctament");


        	
        	
		} catch (Exception e) {

            e.printStackTrace();

		} finally {
			
			//tancar els statements
			pstmtEntrenador.close();
			pstmtPokemon.close();
			pstmtCaptura.close();
			
		}
		
		
		
	}
	
	
	public void AltaPokemon(){}
	
	public void getPokemonRandom(){}
	public void getListPokemon(){}

	
	

}
