/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Repositorio;

import br.com.CadastroFuncionario.Model.Carros;
import connection.Conexão;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esdras Alves
 */
public class CarrosRepositorio {
    
    
    public void create(Carros c){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            stmt = con.prepareStatement("INSERT INTO carros (modelo,anofabricacao,placa"
                    + ",cor) VALUES (?,?,?,?) ");
            
            stmt.setString(1,c.getModelo());
            stmt.setInt(2, c.getAnoFabricacao());
            stmt.setString(3,c.getPlaca());
            stmt.setString(4,c.getCor());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
    
    
        
    }
    
    
    
      public List<Carros> read(){
          Connection con = Conexão.getConnection();
          PreparedStatement stmt = null;
    
         ResultSet rs = null;
         List<Carros> Carro = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM carros ");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Carros  Carros = new  Carros();
                
                Carros.setId(rs.getInt("id"));
                 Carros.setModelo(rs.getString("modelo"));
                 Carros.setAnoFabricacao(rs.getInt("anofabricacao"));
                 Carros.setPlaca(rs.getString("placa"));
                 Carros.setCor(rs.getString("cor"));
                Carro.add(Carros);
               
           }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            connection.Conexão.closeConnection(con, stmt, rs);
        }
        return Carro;
      }  
    
      
      
      public void update(Carros c){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            stmt = con.prepareStatement("UPDATE carros SET modelo = ?,anofabricacao = ? ,placa = ?,cor  = ? WHERE id =?");
            stmt.setString(1,c.getModelo());
            stmt.setInt(2, c.getAnoFabricacao());
            stmt.setString(3,c.getPlaca());
            stmt.setString(4,c.getCor());
            stmt.setInt(5,c.getId());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
      
      
      
      
      
      
      
      
      
      }
    
      
      
       public void delete(Carros C){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from carros WHERE id =?");
           
            stmt.setInt(1,C.getId());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
        }
        
               }
}
