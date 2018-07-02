/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Repositorio;

import br.com.CadastroFuncionario.Model.Clientes;
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
public class ClienteRepositorio {
    
    public void creatcliente(Clientes c1){
        
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nomecliente,cpf,telefone) VALUES (?,?,?) ");
            
            stmt.setString(1,c1.getNome());
            stmt.setInt(2,c1.getCPF());
            stmt.setInt(3,c1.getTelefone());
            
            stmt.executeUpdate();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
          }
            
           
    
    }
    
     public List<Clientes> read(){
          Connection con = Conexão.getConnection();
          PreparedStatement stmt = null;
    
         ResultSet rs = null;
         List<Clientes> Cliente = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes ");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Clientes  Clientes = new  Clientes();
                
                Clientes.setID(rs.getInt("id"));
                 Clientes.setNome(rs.getString("nomecliente"));
                Clientes.setCPF(rs.getInt("cpf"));
                Clientes.setTelefone(rs.getInt("telefone"));
                Cliente.add(Clientes);
               
           }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            connection.Conexão.closeConnection(con, stmt, rs);
        }
        return Cliente;
     }
     
     
     
        public void update(Clientes c2){
        
        Connection con = Conexão.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nomecliente = ?,cpf = ? ,telefone = ? WHERE id =?");
            stmt.setString(1,c2.getNome());
            stmt.setInt(3, c2.getTelefone());
            stmt.setInt(2,c2.getCPF());
           stmt.setInt(4,c2.getID());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
     
     
   
        }
     
         public void delete(Clientes CI){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from clientes WHERE id =?");
           
            stmt.setInt(1,CI.getID());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
        }
        
               }
        
        
        
        
        
     }
