package test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.business.BnsEquipo;
import model.business.BnsPartidoEquipo;
import model.dto.DtoEquipo;
import model.dto.DtoPartido;
import model.dto.DtoPartidoEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public class Test {
    
    public static void main(String[] args){
        try {
            BnsEquipo bnsEquipo = new BnsEquipo();
            BnsPartidoEquipo bnsPartidoEquipo = new BnsPartidoEquipo();
            
            /*if(bnsEquipo.actualizarPuntosEquipo(new DtoEquipo("América"))){
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }
            */
            
            
            /*if(bnsEquipo.actualizarGolesEquipo(new DtoEquipo("Necaxa"), 1, 1)){
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }*/
            
            DtoEquipo dtoEquipo = bnsEquipo.buscarEquipo("América");
            DtoPartidoEquipo dtoPartidoEquipo = new DtoPartidoEquipo(null, dtoEquipo, 0);
            List<DtoEquipo> lista = bnsPartidoEquipo.equiposDisponibles(dtoPartidoEquipo);
            for(int i = 0; i < lista.size(); i++){
                System.out.println(lista.get(i).getIdEq());
                System.out.println(lista.get(i).getNombreEq());
            }
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}