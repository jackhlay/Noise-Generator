import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        BufferedImage canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

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
        JPanel container = new JPanel();
        container.setVisible(true);
        start.setSize(600,600);
        JLabel l1 = new JLabel("# of attempts");
        JLabel l2 = new JLabel("Image Height");
        JLabel l3 = new JLabel("Image Width");

        JTextField T1 = new JTextField();
        JTextField T2 = new JTextField();
        JTextField T3 = new JTextField();

        JButton send = new JButton("Generate");

        start.setLayout(new BorderLayout());
        start.add(send, BorderLayout.SOUTH);
        start.add(container, BorderLayout.CENTER);
        container.setLayout(new GridLayout(3,2));
        container.add(l1);
        container.add(T1);
        container.add(l2);
        container.add(T2);
        container.add(l3);
        container.add(T3);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(T1.getText());
                int h = Integer.parseInt(T2.getText());
                int w = Integer.parseInt(T3.getText());
                try {
                    go(num, h, w);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        start.setVisible(true);


    }

    public static void main(String[] args) throws IOException {
        new Main().start();

    }
}
