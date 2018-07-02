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
public class Fornecedores {
    private int ID;
    private String nome;
    private int telefone;
    private int CNPJ; 

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
       if (telefone <8){
           JOptionPane.showMessageDialog(null, "Erro, o telefone não pode ter menos de 8 dígitos.");
       } 
        this.telefone = telefone;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        if (CNPJ <14){
           JOptionPane.showMessageDialog(null, "Erro, o CNPJ não pode ter menos que 14 dígitos.");
       }
        this.CNPJ = CNPJ;
    }
    
    
}
