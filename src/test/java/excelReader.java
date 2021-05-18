import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class excelReader {

    public static Object[][] getDataFromExcel (int sheetNo) throws  Exception {


        File file = new File("D:\\sessionPrepration\\src\\test\\Data\\LoginBook1.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis); // .xslx   .xls
        Sheet sheet = wb.getSheetAt(sheetNo);
     //  sheet.getRow(2).getCell(1).toString();

        int rows = (sheet.getLastRowNum()+1);
        int colmns = sheet.getRow(0).getLastCellNum() ;

        Object data[][] = new Object[rows][colmns];

        for (int r=0; r<rows; r++)
        {
            for (int c=0; c<colmns; c++)
            {
                data[r][c]= sheet.getRow(r).getCell(c).toString();
              //  System.out.println(data[r][c]);
            }
        }
wb.close();
        return data;
    }
}
