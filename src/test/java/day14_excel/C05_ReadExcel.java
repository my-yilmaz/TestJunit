package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // sayfa 2'ye gidip
        // satir sayisinin , kullanilan satir sayisinin ise 16 oldugunu test edin

        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedSS=21;
        Assert.assertEquals(expectedSS,sonSatirIndex);

        int kullanilanSSayis=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedKSS=16;
        Assert.assertEquals(expectedKSS,kullanilanSSayis);
    }
}
