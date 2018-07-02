/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CadastroFuncionario.Model;

import javax.swing.JOptionPane;

/**
 *
 * @author caio
 */
public class Funcionarios {
    
   private int id;
   private  String nomeF;
   private  String cargo;
   private  double salario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeF() {
        return nomeF;
    }

    public void setNomeF(String nomeF) {
        this.nomeF = nomeF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
       
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
       if (salario <954){
           JOptionPane.showMessageDialog(null, "Erro, o salário não pode ser menor que 954 reais.");
       }else{
        this.salario = salario;
    }}
   
   
   
   
   
    
}
