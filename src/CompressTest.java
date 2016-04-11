import student.TestCase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CompressTest extends TestCase
{


    public static void main(String[] args) throws IOException {
       Compress c = new Compress();

        System.out.println(new File("poe.text").getAbsolutePath());

       BitInputStream bits = new BitInputStream(new FileInputStream("C:\\Users\\Eymir\\workspace\\FinalProject\\src\\poe.txt"));
        try
        {
            c.initialize(bits);
        }
        catch (IOException e)
        {
            throw e;
        }
        c.showCounts();
    }
}
