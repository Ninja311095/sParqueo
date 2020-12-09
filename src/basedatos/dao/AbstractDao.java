/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos.dao;

import basedatos.Database;
import java.util.ArrayList;

/**
 *
 * @author heracles
 */
abstract public class AbstractDao<T> {
    public final Database db = Database.obtenerInstancia();
    
    abstract public T obtener(int id);
    
    abstract public ArrayList<T> obtener();
    
    abstract public int agregar(T elemento);
    
    abstract public boolean modificar(T elemento);
    
    abstract public boolean eliminar(int id);
}
