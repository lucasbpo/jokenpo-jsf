package dao;

import java.util.LinkedList;
import java.util.List;

public class GenericDAO<T> {
    private int nextId = 0;
    
    private List<T> dados;
    
    public GenericDAO() {
        dados = new LinkedList<>();
    }
    
    public boolean inserir(T dado) {
        if (!dados.contains(dado)) {
            dados.add( dado );
            return true;
        }
        return false;
    }
    
    public boolean remover(T dado) {
        return dados.remove(dado);
    }
    
    public List<T> listar() {
        return dados;
    }
    
    public T buscar(T exemplo) {
        int pos = dados.indexOf(exemplo);
        if (pos >= 0) {
            return dados.get( pos );
        } else {
            return null;
        }
    }
    
    public int getNextId(){
        this.nextId++;
        return this.nextId;
    }
}
