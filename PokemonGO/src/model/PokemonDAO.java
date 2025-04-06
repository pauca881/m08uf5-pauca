package model;

import model.Pokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

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
	
	
	public boolean AltaPokemon(Pokemon pokemon){
		
		
		 Connection conn = null;
	        PreparedStatement pstmtPokemon = null;
	    	

	        
	        try {
	        	
	            conn = DbConnect.getConnection();
	            
	            String sql = "INSERT INTO pokemon (name, type) VALUES (?, ?)";

	            //NOTA: No fico la numero_pokedex perque ho he ficat al sql perque sigui id autoincremental
	            
	            pstmtPokemon = conn.prepareStatement(sql);
	            pstmtPokemon.setString(1, pokemon.getName());
	            pstmtPokemon.setString(2, pokemon.getType());
	            pstmtPokemon.executeUpdate();

	            int lineas_modificades = pstmtPokemon.executeUpdate();
	            
	            return lineas_modificades > 0;
	            
				
			} catch (SQLException  e) {

		        // com hem ficat la restricció al sql no cal fer-la aquí, només cal ficar-ho dins dels catches
		        if (e.getMessage().contains("unique_pokemon_name")) {
		            System.out.println("El Pokemon ja existeix amb aquesta nom.");
		            return false;  
		        }


		        System.err.println("Error a la base de dades: " + e.getMessage());
		        e.printStackTrace();
		        return false;
				

			}    
		
		
		
		
	}
	
	public void getPokemonRandom(){

		//Creació numero random
		Random random = new Random();
		int numero_random = random.nextInt(10);

		   // Connexió
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet result_set = null;
	    
	    try {
	        conn = DbConnect.getConnection();
	        String sql = "SELECT * FROM pokemon WHERE num_pokedex = ?";
	        pstmt = conn.prepareStatement(sql);
	
	        pstmt.setInt(1, numero_random);
	        result_set = pstmt.executeQuery();
	
	        if(result_set.next()) {
	            String name = result_set.getString("name");
	            String type = result_set.getString("type");
	            int numPokedex = result_set.getInt("num_pokedex");
	            System.out.println("El pokemon aleatori es: " + name + " amb tipus " + type + " amb el numero de pokedex " + numPokedex);
	        } else {
	            System.out.println("No hi ha cap pokemon amb el mateix id que el numero generat");
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		

		
	}

	
	public void getListPokemon() throws SQLException {



		Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet result_set = null;
            
            List<Pokemon> pokemons = new ArrayList<>();
            
            
            try {
				
                conn = DbConnect.getConnection();
                String sql = "SELECT * FROM pokemon";
                pstmt = conn.prepareStatement(sql);

                result_set = pstmt.executeQuery();

                while (result_set.next()) {
                    Pokemon pokemon = new Pokemon();
		pokemon.setNumero_pokedex(result_set.getInt("numero_pokedex"));
                pokemon.setName(result_set.getString("name"));
                pokemon.setType(result_set.getString("type"));

                    
                    pokemons.add(pokemon);
                }
                
                return pokemons;
                
            	
			} catch (Exception e) {

				System.err.println("Error a la base de dades: " + e.getMessage());
	            e.printStackTrace();
	            return null; 

			
			} finally {
				
				
				result_set.close();

				pstmt.close();

				conn.close();
				
				
			}
            



			



		
	}

	
	

}
