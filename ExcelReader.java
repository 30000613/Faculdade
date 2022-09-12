package Configurações;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;  
import java.util.Arrays;  



public class ExcelReader {
    
    String name = null;
    String descricao = null;
    String Data = null;
    String Tipo_equipamento = null;
  
    
    public ExcelReader(String inPath) throws FileNotFoundException, IOException, SQLException{
        
        String path = inPath;
     
        File file = new File(path);   //creating a new file instance  
        FileInputStream fis = new FileInputStream(file);  
        XSSFWorkbook wb = new XSSFWorkbook(fis); 
        XSSFSheet sheet = wb.getSheetAt(0); 

        Iterator<Row> itr = sheet.iterator(); 
        itr.next();
        while (itr.hasNext())                 
        {  
        Row row = itr.next(); 
        String[] ExcelValues = new String[0];
        String Target;
        ArrayList<String> ListValues = new ArrayList<String>(Arrays.asList(ExcelValues));
        Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                while (cellIterator.hasNext())   
                {  
                Cell cell = cellIterator.next(); 
                Target = cell.getStringCellValue();
                ListValues.add(Target);
                }
        if( ListValues.isEmpty() == false){  
            
            String codigo = ListValues.get(0);  // codigo    
            String unidade = ListValues.get(1);
            String subunidade = ListValues.get(2);
            String tipo = ListValues.get(3);
            String nome = ListValues.get(3);
            String descritivo = ListValues.get(3);


            ListValues.clear();

            InsertScoutMaterial_Excel NewMaterial = new InsertScoutMaterial_Excel();
            NewMaterial.InsertMaterial(codigo, unidade, subunidade, tipo,nome, descritivo );
        }
        
        
        }
        
        }};
    




