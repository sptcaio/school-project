/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Repositorio;

import br.com.CadastroFuncionario.Model.Fornecedores;
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
public class FornecedorRepositorio {
    
    public void createfornecedor(Fornecedores f){
        
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO fornecedores (nome,telefone,cnpj)"
            + "VALUES (?,?,?)");
            
            stmt.setString(1,f.getNome());
            stmt.setInt(2,f.getTelefone());
            stmt.setInt(3,f.getCNPJ());
            
            stmt.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
          }
    
    
        
        
  
        
    }
    
    
    
    
    
     public List<Fornecedores> read(){
          Connection con = Conexão.getConnection();
          PreparedStatement stmt = null;
    
         ResultSet rs = null;
         List<Fornecedores> Fornecedor = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedores ");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Fornecedores  Fornecedores = new Fornecedores();
                
                Fornecedores.setID(rs.getInt("id"));
                 Fornecedores.setNome(rs.getString("nome"));
                 Fornecedores.setTelefone(rs.getInt("telefone"));
                 Fornecedores.setCNPJ(rs.getInt("cnpj"));
                Fornecedor.add(Fornecedores);
               
           }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            connection.Conexão.closeConnection(con, stmt, rs);
        }
        return Fornecedor;
      }  
    
    
    public void update(Fornecedores c4){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            stmt = con.prepareStatement("UPDATE fornecedores SET nome = ?,cnpj = ? ,telefone = ? WHERE id =?");
            stmt.setString(1,c4.getNome());
            stmt.setInt(3, c4.getTelefone());
            stmt.setInt(2,c4.getCNPJ());
           stmt.setInt(4,c4.getID());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
      
     
     
     
     
     
     
     
     
     
     
    }
     
      public void delete(Fornecedores F){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from fornecedores WHERE id =?");
           
            stmt.setInt(1,F.getID());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
        }
        
               }
        
     
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
