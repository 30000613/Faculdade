/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurações;

/**
 *
 * @author Utilizador
 */
public class ObjectsExcel {
    
   private char unidadecod;
   private char subunidadecod;
   private char tipoCod;
   private String equipamentCod;
    
    
    public void setFullCodigo(String codigo_input){
        String[] codigoBatch =  codigo_input.split("[.]",codigo_input.length());
        
        char[] grupoDetail = codigoBatch[1].toCharArray();
        char[] equipmentDetail = codigoBatch[2].toCharArray();
        unidadecod = grupoDetail[0];
        subunidadecod = grupoDetail[1];
        tipoCod = equipmentDetail[0];
        equipamentCod = ""+equipmentDetail[1]+ equipmentDetail[2]; 
 
    }
    
    public char getUnitCode() {
        return unidadecod;
    }
    
    public char getSubUnitCode() {
        return subunidadecod;
    }
    
    public char gettipoCod() {
        return tipoCod;
    }
    
    public String getequipamentCod() {
    return equipamentCod;
}
    
    
           
    
}
