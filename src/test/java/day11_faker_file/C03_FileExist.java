package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {

        //System.out.println(System.getProperty("user.dir"));

        //System.out.println(System.getProperty("user.home"));

        //
        // C:\Users\my\Downloads
        // C:\Users\my\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit
        // C:\Users\my\Desktop\text.txt
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
      //  System.out.println(dosyaYolu);

       // System.out.println("Files.exists(Paths.get(dosyaYolu)) = " + Files.exists(Paths.get(dosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
