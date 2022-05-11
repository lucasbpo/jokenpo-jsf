/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;


import dao.GenericDAO;
import java.io.Serializable;
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
    
    private int escolha;
    
    private final static GenericDAO<Jogador> jogadorDao = new GenericDAO<>();

    public JogadorController() {
    }

    public int getEscolha() {
        return escolha;
    }
    
    public int getEscolhaComputador(){
        return 0;
    }
    
}
