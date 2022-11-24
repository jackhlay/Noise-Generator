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

    public void go(int q, int h, int w) throws IOException {
        FileWriter write = new FileWriter("OUT2.txt");
        coordinate[] cords = new coordinate[q];
        Arrays.fill(cords, new coordinate("",0));
        int count = 0;
        boolean ret=true;
        try {
            Scanner scan = new Scanner("OUT.txt");
            File file = new File(scan.nextLine());
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                System.out.println("SCAN HAS NEXT LINE");
                String line = scan.nextLine();
                System.out.println(line);
                for(int i=0; i<cords.length; i++) {
                    if(line.contains(cords[i].name)&& cords[i].name != ""){
                        System.out.println(cords[i].name + ", " + cords[i].count);
                        cords[i].count++;
                        ret=false;
                        break;
                    }
                    else{
                        ret=true;
                        continue;
                    }

                }
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
                for(int i =0; i< count; i++){

                        if(line.contains(cords[i].name)){
                            System.out.println("FOR 2");
                            cords[i].count++;
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
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (coordinate x : cords) {
                System.out.println(x.name + "," + x.count);
                write.write(x.name + "," + x.count +"\n");
                write.flush();
            }
        }

}
