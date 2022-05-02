import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sort_Quantify {
    static class coordinate {
        coordinate(String i, int j) {
            this.name = i;
            this.count = j;
        }

        String name;
        int count;
    }

    public static void main(String[] args) throws IOException {
        FileWriter write = new FileWriter("OUT2.txt");
        Vector<coordinate> cords = new Vector<>();
        cords.addElement(new coordinate("s", 6));
        try {
            Scanner scan = new Scanner("OUT.txt");
            File file = new File(scan.nextLine());
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                for(coordinate o : cords) {
                    if(o.name.equals(line)){
                        o.count++;
                        break;
                    }
                    if(cords.get(0).name.equals("s")){
                        coordinate nc = new coordinate(line,1);
                        cords.set(0, nc);
                        break;
                    }
                    coordinate nc = new coordinate(line,1);
                    cords.addElement(nc);

                }
            }

            for (coordinate x : cords) {
                write.write(x.name + "," + x.count);
                write.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
