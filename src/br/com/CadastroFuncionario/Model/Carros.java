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
public class Carros {
    private int id;
    private String modelo;
    private int anoFabricacao;
    private String placa;
    private String cor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
       if (anoFabricacao < 1900){
           JOptionPane.showMessageDialog(null, "Erro, o ano do veículo não poder ser menor que 1900.");
       }else{
        this.anoFabricacao = anoFabricacao;
       }
       
       }

    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
    
    
    
    
}
