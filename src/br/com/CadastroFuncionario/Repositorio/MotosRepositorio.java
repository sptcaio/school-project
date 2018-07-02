/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Repositorio;

import br.com.CadastroFuncionario.Model.Motos;
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
public class MotosRepositorio {
   
    public void createmotos(Motos M){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO motos (modelo,anofabricacao,placa,cor) VALUES (?,?,?,?)");
            
            stmt.setString(1,M.getModelo());
            stmt.setString(3, M.getPlaca());
            stmt.setInt(2,M.getAnoFabricacao());
            stmt.setString(4,M.getCor());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MotosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
          }
        
        
        
        
        
    }
    
      
       public List<Motos> read(){
          Connection con = Conexão.getConnection();
          PreparedStatement stmt = null;
    
         ResultSet rs = null;
         List<Motos> moto = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM motos ");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Motos  Motos = new Motos();
                
                Motos.setId(rs.getInt("id"));
                 Motos.setModelo(rs.getString("modelo"));
                 Motos.setAnoFabricacao(rs.getInt("anofabricacao"));
                 Motos.setPlaca(rs.getString("placa"));
                 Motos.setCor(rs.getString("cor"));
                moto.add(Motos);
               
           }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            connection.Conexão.closeConnection(con, stmt, rs);
        }
        return moto;
      }  
    
    public void update(Motos c3){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            stmt = con.prepareStatement("UPDATE motos SET modelo = ?,anofabricacao = ? ,placa = ?,cor  = ? WHERE id =?");
            stmt.setString(1,c3.getModelo());
            stmt.setInt(2, c3.getAnoFabricacao());
            stmt.setString(3,c3.getPlaca());
            stmt.setString(4,c3.getCor());
            stmt.setInt(5,c3.getId());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
     
    
    }  
    public void delete(Motos M){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from motos WHERE id =?");
           
            stmt.setInt(1,M.getId());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
        }
        
               }
        






}
