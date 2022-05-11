/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;


import dao.GenericDAO;
import java.io.Serializable;
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
    
    private String nome, escolhaJogador, resultado;
    
    private final static GenericDAO<Jogador> jogadorDao = new GenericDAO<>();

    public JogadorController() {
    }

    public String getEscolhaJogador() {
        return escolhaJogador;
    }

    public void setEscolhaJogador(String escolhaJogador) {
        this.escolhaJogador = escolhaJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public String gerarResultado(){
        
        int escolhaComputador = new Random().nextInt(3) + 1; // Escolha do Computador
        switch((escolhaComputador - (Integer.parseInt(escolhaJogador) % 3))){
            case 0:
            case 3:
                this.resultado = "Empate";
                break; // Empate
            case 1:
                this.resultado = "Computador venceu";
                break; // Computador Venceu
            default:
                this.resultado = "Voce venceu";
                break; // Voce Venceu
        }
        return "resultado.xhtml";
    }
}
