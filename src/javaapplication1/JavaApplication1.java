/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javaaplication1.DAL.Utilizador;
import Utilizador.BLL.Utilizador_BLL;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author utilizador
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    
    private static final String PERSISTENCE_UNIT_NAME = "JavaApplication1PU";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //visualizar cliente
//        Utilizador usr = new Utilizador();
//        usr.read(9); 
//        System.out.println("ID " + usr.getIdUtilizador()+ " chama-se " + usr.getNome() + " e mora em " + usr.getMorada() + usr.getCod_postal());
 
//insert cliente
//        Utilizador userI = new Utilizador();
//        userI.setIdUtilizador(91);
//        userI.setNome("Joel BLL");
//        userI.setDistrito("Distrito");
//        userI.setCidade("Cidade");
//        userI.setMorada("Morada");
//        userI.setPortaAndar("Porta_andar");
//        userI.setCodPostal("4800-123"); 
//        userI.setNif(12312);
//        userI.setTelemovel(911111111);
//        userI.setEmail("email@ipvc.pt");
//        userI.setPasse("passe");
//        userI.setDataRegisto("22/01/2021");
//        Utilizador_BLL.create(userI);

                
          

//
//       try{
//        userI.create();
//        } catch (SQLException ex){
//                    System.out.println("Erro no Create: " + ex.getMessage());;
//        }
//               System.out.println("ID criado: " + userI.getIdUtilizador());

              
           //visualizar c/param   
       //  List<Utilizador> listaDeUtilizadores = Utilizador.find("");
        
       // for(Utilizador usr : listaDeUtilizadores)
        //    System.out.println("ID " + usr.getIdUtilizador()+ " chama-se " + usr.getNome() + " e mora em " + usr.getMorada());
        
     //   System.out.println("----------------------------------------------------------------------------------------");
       
        
       List<Utilizador> lista = Utilizador_BLL.readAll();
        for(Utilizador uti : lista){System.out.println(uti.getIdUtilizador() + "--" + uti.getNome()); }
    }
    
}
