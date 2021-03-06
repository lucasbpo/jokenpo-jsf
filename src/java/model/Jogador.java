/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author lucasbpo
 */
public class Jogador implements Serializable {
    private String nome;
    private int partidas;
    private int vitorias;
    private int derrotas;
    private int empates;
    private double percentualVitorias;
    
    public Jogador() {
    }

    public Jogador(String nome, int partidas, int vitorias, int derrotas, int empates) {
        this.nome = nome;
        this.partidas = partidas;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.percentualVitorias = percentualVitorias;
    }
    
    public Jogador(String nome, int partidas, int vitorias, double percentualVitorias) {
        this.nome = nome;
        this.partidas = partidas;
        this.vitorias = vitorias;
        this.percentualVitorias = percentualVitorias;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPartidas() {
        return partidas;
    }
    
    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public double getPercentualVitorias() {
        return percentualVitorias;
    }

    public void incrementarVitoria(){
        partidas++;
        vitorias++;
        calcularPercentual();
    }
    
    public void incrementarDerrota(){
        partidas++;
        derrotas++;
        calcularPercentual();
    }
    
    public void incrementarEmpate(){
        partidas++;
        empates++;
        calcularPercentual();
    }
    
    public void calcularPercentual(){
        percentualVitorias = (vitorias / partidas) * 100;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogador other = (Jogador) obj;
        return Objects.equals(this.nome, other.nome);
    }
}