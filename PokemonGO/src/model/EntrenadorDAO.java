package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DbConnect;

public class EntrenadorDAO {

			//TO DO
			//Lògica del AltaEntrenador al menu
	
			//ExisteixEntrenador ( donat el nom et diu les altres caracterisitques )
			//esborrarEntrenador
	
    public boolean AltaEntrenador(Entrenador entrenador) {
    	
        Connection conn = null;
        PreparedStatement pstmtEntrenador = null;
    	

        
        try {
        	
            conn = DbConnect.getConnection();
            
            String sql = "INSERT INTO entrenadors (name, password) VALUES (?, ?)";

            pstmtEntrenador = conn.prepareStatement(sql);
            pstmtEntrenador.setString(1, entrenador.getNombre());
            pstmtEntrenador.setString(2, entrenador.getContrasena());
            pstmtEntrenador.executeUpdate();

            int lineas_modificades = pstmtEntrenador.executeUpdate();
            
            return lineas_modificades > 0;
            
			
		} catch (SQLException  e) {

	        // com hem ficat la restricció al sql no cal fer-la aquí, només cal ficar-ho dins dels catches
	        if (e.getMessage().contains("unique_name")) {
	            System.out.println("L'entrenador ja existeix amb aquest nom.");
	            return false;  
	        }


	        System.err.println("Error a la base de dades: " + e.getMessage());
	        e.printStackTrace();
	        return false;
			

		}    
      
        
        
    }
    
    
    	public List<Entrenador> LlistarEntrenadors() throws SQLException {
    		
    		
    		Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet result_set = null;
            
            List<Entrenador> entrenadors = new ArrayList<>();
            
            
            try {
				
                conn = DbConnect.getConnection();
                String sql = "SELECT id, name, password FROM entrenadors";
                pstmt = conn.prepareStatement(sql);

                result_set = pstmt.executeQuery();

                while (result_set.next()) {
                    Entrenador entrenador = new Entrenador();
                    entrenador.setId(result_set.getInt("id"));
                    entrenador.setNombre(result_set.getString("name"));
                    entrenador.setContrasena(result_set.getString("password"));
                    
                    entrenadors.add(entrenador);
                }
                
                return entrenadors;
                
            	
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
