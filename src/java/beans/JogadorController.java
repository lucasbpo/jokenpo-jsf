/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;


import dao.GenericDAO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Jogador;

/**
 *
 * @author lucasbpo
 */
@Named(value = "jogadorController")
@SessionScoped
public class JogadorController implements Serializable {
    
    private String escolhaJogador, resultado;
    private int escolhaComputador;
    
    Jogador jogador;
    
    private List<Jogador> jogadores;
    private List<Jogador> rankings;
    private final static GenericDAO<Jogador> jogadorDao = new GenericDAO<>();

    public JogadorController() {
        jogador = new Jogador();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public String getEscolhaJogador() {
        return escolhaJogador;
    }

    public void setEscolhaJogador(String escolhaJogador) {
                jogadorDao.inserir(jogador);
        this.escolhaJogador = escolhaJogador;
    }

    public int getEscolhaComputador() {
        return escolhaComputador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public String gerarResultado(){
        escolhaComputador = new Random().nextInt(3) + 1; // Escolha do Computador
        switch((escolhaComputador - (Integer.parseInt(escolhaJogador) % 3))){
            case 0:
            case 3:
                this.resultado = "Empate";
                this.jogador.incrementarEmpate();
                break; // Empate
            case 1:
                this.resultado = "Computador venceu";
                this.jogador.incrementarDerrota();
                break; // Computador Venceu
            default:
                this.resultado = "Voce venceu";
                this.jogador.incrementarVitoria();
                break; // Voce Venceu
        }
        
        
        return "resultado.xhtml";
    }
    
    public List<Jogador> getJogadores(){
        if(jogadores == null){
            jogadores = new LinkedList<>();
            for(Jogador j : jogadorDao.listar()){
                jogadores.add(new Jogador(j.getNome(), j.getPartidas(), j.getVitorias(), j.getDerrotas(), j.getEmpates()));
            }
        }
        return jogadores;
    }
    
    public List<Jogador> getRankings(){
        if(rankings == null){
            rankings = new LinkedList<>();
            for(Jogador j : rankings){
                jogadores.add(new Jogador(j.getNome(), j.getPartidas(), j.getVitorias(), j.getPercentualVitorias()));
            }
        }
        return rankings;
    }
}
