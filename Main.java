import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel{
    public void go(int q) throws IOException {
        JFrame window = new JFrame();
        window.setSize(300,300);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        FileWriter write = new FileWriter("OUT.txt");
        Random gen = new Random();

        for(int i=0; i<q; i++){
            int x = gen.nextInt(300);
            int y = gen.nextInt(300);
            System.out.println(x+","+y);
            write.write(""+x +  "," + y + "\n");
            write.flush();
        }
        write.close();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        g.setColor(Color.red);
        g.drawLine(0,0,300,300);
    }

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        window.setSize(300,300);
        window.setVisible(true);
        FileWriter write = new FileWriter("OUT.txt");
        Random gen = new Random();

        for(int i=0; i<900; i++){
            int x = gen.nextInt(300);
            int y = gen.nextInt(300);
            System.out.println("("+x+","+y+")");
            write.write("("+x+","+y+")\n");
            write.flush();
        }
        write.close();
    }

}
