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

    public void go(int q) throws IOException {
        FileWriter write = new FileWriter("OUT2.txt");
        coordinate[] cords = new coordinate[q];
        Arrays.fill(cords, new coordinate("",0));
        int count =0;
        boolean ret=true;
        try {
            Scanner scan = new Scanner("OUT.txt");
            File file = new File(scan.nextLine());
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                for(coordinate o : cords) {
                    if(!o.name.contains(line)){
                        continue;
                    }
                    else if(o.name.contains(line)){
                        System.out.println("FOR 2");
                        o.count++;
                        ret=false;
                        break;
                    }

                }

            if(ret){
                if(count >= 90000){}
                else {
                    coordinate nc = new coordinate(line, 1);
                    cords[count] = nc;
                    count++;
                }
            }
            else{line = scan.nextLine();}

        }

            for (coordinate x : cords) {
                System.out.println(x.name + "," + x.count);
                write.write(x.name + ", " + x.count +"\n");
                write.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter write = new FileWriter("OUT2.txt");
        coordinate[] cords = new coordinate[1200];
        Arrays.fill(cords, new coordinate("",0));
        int count =0;
        try {
            Scanner scan = new Scanner("OUT.txt");
            File file = new File(scan.nextLine());
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for(coordinate o : cords) {
                    if(o.name.equals(line)){
                        System.out.println("FOR 2");
                        o.count++;
                        break;
                    }
                    else {
                        System.out.println("FOR 3");
                        coordinate nc = new coordinate(line, 1);
                        cords[count] = nc;
                        count++;
                        break;
                    }

                }
            }

            for (coordinate x : cords) {
                System.out.println(x.name + "," + x.count);
                write.write(x.name + "," + x.count +"\n");
                write.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
