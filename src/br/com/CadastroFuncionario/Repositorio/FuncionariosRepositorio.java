/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Repositorio;

import connection.Conexão;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.CadastroFuncionario.Model.Funcionarios;

/**
 *
 * @author caio
 */
public class FuncionariosRepositorio {

    public static IFuncionarios getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void create(Funcionarios F){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO funcionarios(nomeF,cargo,salario) VALUES (?,?,?) ");
            stmt.setString(1,F.getNomeF());
            stmt.setString(2,F.getCargo());
            stmt.setDouble(3,F.getSalario());
            
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
    }
}
    
      public List<Funcionarios> read(){
          Connection con = Conexão.getConnection();
          PreparedStatement stmt = null;
    
         ResultSet rs = null;
         List<Funcionarios> Funcionario = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios ");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
                Funcionarios  Funcionarios = new  Funcionarios();
                
                Funcionarios.setId(rs.getInt("id"));
                Funcionarios.setNomeF(rs.getString("nomeF"));
                Funcionarios.setCargo(rs.getString("cargo"));
                Funcionarios.setSalario(rs.getDouble("salario"));
                Funcionario.add(Funcionarios);
               
           }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            connection.Conexão.closeConnection(con, stmt, rs);
        }
        return Funcionario;
      }  
          

     public void update(Funcionarios F){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE funcionarios SET nomeF = ?,cargo = ? ,salario = ? WHERE id =?");
            stmt.setString(1,F.getNomeF());
            stmt.setString(2,F.getCargo());
            stmt.setDouble(3,F.getSalario());
            stmt.setInt(4,F.getId());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
     
            
            
            
            
            }





}

    public void delete(Funcionarios F){
    
    Connection con = Conexão.getConnection();
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from funcionarios WHERE id =?");
           
            stmt.setInt(1,F.getId());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexão.closeConnection(con,stmt);
        
        }
        
               }
               
}



               