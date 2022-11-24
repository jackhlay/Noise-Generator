import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel{
    public void go(int q, int h, int w) throws IOException {
        class coordinate{
            int count;
            int x;
            int y;

            coordinate(int x, int y){
                this.x = x;
                this.y = y;
                this.count = 1;
            }

        }
        ArrayList<coordinate> clst = new ArrayList<coordinate>(q);

        BufferedImage canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);

        JFrame frame = new JFrame() {
            {
                final JLabel label = new JLabel("", new ImageIcon(canvas), 0);
                add(label);
                pack();
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(true);
            }
        };

        FileWriter write = new FileWriter("OUT.txt");
        Random gen = new Random();

        for(int i=0; i<q; i++){
            frame.repaint();
            int x = gen.nextInt(w);
            int y = gen.nextInt(h);
            coordinate crd = new coordinate(x,y);

            int color = canvas.getRGB(crd.x, crd.y) + 0x0F000000;
            canvas.setRGB(crd.x, crd.y, color);

            write.write(""+x +  "," + y + "\n");
            write.flush();
        }

        write.close();
    }
    public void start(){
        JFrame start = new JFrame("Settings Configurator");
        start.add()
    }
}
