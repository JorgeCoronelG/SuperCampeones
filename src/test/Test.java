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
        
        /*try {
            DtoEquipo dto = bnsEquipo.buscarEquipo("Necaxa");
            int puntos;
            puntos = dto.getPgEq() * 3;
            puntos += dto.getPeEq();
            puntos += dto.getPuntosEq();
            dto.setPuntosEq(puntos);
            if(bnsEquipo.actualizarPuntosEquipo(dto)){
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        
    }
    
}