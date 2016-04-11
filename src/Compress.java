import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Compress implements IHuffModel
{
    int charTotal = 0;
    int currentChar = 0;
    Comparator<String> comp = new CharCountComparator();
    int [] counter=new int[256];
   // private PriorityQueue<String> a = new PriorityQueue<String>(charTotal, comp);


    public Compress() {
        for(int i=0; i<255; i++) {
            counter[i]=0;
        }
    }
    @Override
    public void showCodings()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCounts()
    {
        // TODO Auto-generated method stub
        for(int i=0; i<255; i++) {
            System.out.print((char)i + ": " + counter[i] + "  ");
            if ((i+1) % 20 == 0) System.out.println();
        }


    }

    @Override
    public void initialize(InputStream stream) throws IOException
    {
        // TODO Auto-generated method stub
        BitInputStream bis = new BitInputStream(stream);
        currentChar = bis.read();
        while (currentChar != -1) {
            try {
                counter[currentChar]++;
                currentChar = bis.read();
            }
            catch(IOException e){
                stream.close();
                throw e;

            }

        }

    }

    @Override
    public void write(InputStream stream, File file, boolean force)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void uncompress(InputStream in, OutputStream out)
    {
        // TODO Auto-generated method stub

    }

    public class CharCountComparator implements Comparator<String>
    {
        @Override
        public int compare(String x, String y)
        {
            // Assume neither string is null. Real code should
            // probably be more robust
            // You could also just return x.length() - y.length(),
            // which would be more efficient.
            if (x.length() < y.length())
            {
                return -1;
            }
            if (x.length() > y.length())
            {
                return 1;
            }
            return 0;
        }
    }

}
