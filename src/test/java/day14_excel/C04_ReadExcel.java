package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
       int sonSatir= workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);
        String satırdakiData="";

        // ingilizce baskentler sutununu yazdiralim
        for (int i = 0; i <=sonSatir ; i++) {
            satırdakiData=C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satırdakiData);
        }



    }
}
