/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizador.BLL;
    
import java.util.ArrayList;
import java.util.List;
import javaaplication1.DAL.Utilizador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author utilizador
 */
public class Utilizador_BLL {
    private static final String PERSISTENCE_UNIT_NAME = "JavaApplication1PU";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    
    public static void create(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(uti);
        em.getTransaction().commit();
    }
    
    public static Utilizador read(int idUtilizador){
        Utilizador uti = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        Query q1 = em.createNamedQuery("Utilizador.findByIdUtilizador");
        q1.setParameter("id_utilizador", idUtilizador);
        Object obj = q1.getSingleResult();
        
        if(obj != null){
            uti = ((Utilizador)obj);
        }
        else
            return null;
        
        
        return uti;
    }
    
    
    public static List<Utilizador> readAll(){
        List<Utilizador> listaUti = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        Query q1 = em.createNamedQuery("Utilizador.findAll");
        List<Object> result = q1.getResultList();
        
        for(Object uti : result){
            listaUti.add((Utilizador)uti);
        }
        
        return listaUti;
    }
    
    
    public static List<Utilizador> readAll(String nome){
        List<Utilizador> listaNome = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        Query q1 = em.createNamedQuery("Utilizador.findAllByNome");
        q1.setParameter("nome", "%"+nome+"%");
        List<Object> result = q1.getResultList();
        
        for(Object uti : result){
            listaNome.add((Utilizador)uti);
        }
        
        return listaNome;
    }
     
    public static void update(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(uti);
        em.getTransaction().commit();
    }
    
    public static void delete(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        if (em == null) em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.remove(uti);
        em.getTransaction().commit();
    }
    

}
