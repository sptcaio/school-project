/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Model;

import javax.swing.JOptionPane;

/**
 *
 * @author Esdras Alves
 */
public class Clientes {
   
    private int ID;
    private String nome;
    private int telefone;
    private int CPF;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        
            
        
        
        
        return telefone;
    
    
    }

    public void setTelefone(int telefone) {
       if(telefone <8 ){
          JOptionPane.showMessageDialog(null, "Erro, o telefone do cliente não pode ter menos de 8 digitos");
       }
        
        this.telefone = telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
    
    
    
   
}
