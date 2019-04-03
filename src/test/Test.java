package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.business.BnsEquipo;
import model.dto.DtoEquipo;

/**
 *
 * @author Jorge Coronel González
 */
public class Test {
    
    public static void main(String[] args){
        BnsEquipo bnsEquipo = new BnsEquipo();
        
        DtoEquipo dto = new DtoEquipo("América");
        try {
            /*if(bnsEquipo.actualizarPuntosEquipo(dto)){
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }*/
            DtoEquipo dtoEquipo = bnsEquipo.buscarEquipo("América");
            System.out.println(dtoEquipo.getNombreEq());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}