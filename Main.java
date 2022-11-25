import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel{
    public void go(int q, int h, int w, String c) throws IOException {

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
        Graphics2D    graphics = canvas.createGraphics();

        if(c == null){
            graphics.setPaint ( Color.BLACK );
        }
        else {

            switch (c) {
                case "RED":
                    graphics.setPaint(Color.RED);
                case "GREEN":
                    graphics.setPaint(Color.GREEN);
                case "BLUE":
                    graphics.setPaint(Color.BLUE);
                case "YELLOW":
                    graphics.setPaint(Color.YELLOW);
                case "CYan":
                    graphics.setPaint(Color.CYAN);
                case "MAGENTA":
                    graphics.setPaint(Color.MAGENTA);
                case "WHITE":
                    graphics.setPaint(Color.WHITE);
                case "GRAY":
                    graphics.setPaint(Color.GRAY);
                case "LIGHT_GRAY":
                    graphics.setPaint(Color.LIGHT_GRAY);
                case "DARK_GRAY":
                    graphics.setPaint(Color.DARK_GRAY);
                case "ORANGE":
                    graphics.setPaint(Color.ORANGE);
                case "Pink":
                    graphics.setPaint(Color.PINK);
            }
        }

        graphics.fillRect ( 0, 0, canvas.getWidth(), canvas.getHeight() );

        JPanel save = new JPanel();
        JTextField nam = new JTextField();
        JButton sb = new JButton("Save Image");
        save.setLayout(new GridLayout(1,2));
        save.add(nam);
        save.add(sb);

        JFrame frame = new JFrame() {
            {
                setLayout(new BorderLayout());
                final JLabel label = new JLabel("", new ImageIcon(canvas), 0);
                add(label, BorderLayout.CENTER);
                add(save, BorderLayout.SOUTH);
                pack();
                setVisible(true);
            }
        };

        sb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = nam.getText() + ".png";
                File outputfile = new File(str);
                try {
                    ImageIO.write(canvas, "png", outputfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        FileWriter write = new FileWriter("coords.txt");
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
        JLabel l2 = new JLabel("Image Width");
        JLabel l3 = new JLabel("Image Height");
        JLabel l4 = new JLabel("Color");



        JTextField T1 = new JTextField("810000");
        JTextField T2 = new JTextField("900");
        JTextField T3 = new JTextField("900");
        String C[] = {"RED", "GREEN", "BLUE", "YELLOW", "CYAN","MAGENTA", "WHITE", "BLACK", "GRAY",
                "LIGHT_GRAY", "DARK_GRAY", "ORANGE", "PINK"};
        JList clr = new JList(C);

        JButton send = new JButton("Generate");

        start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        start.setLayout(new BorderLayout());
        start.add(send, BorderLayout.SOUTH);
        start.add(container, BorderLayout.CENTER);
        container.setLayout(new GridLayout(4,2));
        container.add(l1);
        container.add(T1);
        container.add(l2);
        container.add(T2);
        container.add(l3);
        container.add(T3);
        container.add(l4);
        container.add(clr);
        container.add(new JScrollPane(clr));

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(T1.getText());
                int h = Integer.parseInt(T3.getText());
                int w = Integer.parseInt(T2.getText());
                String c = (String) clr.getSelectedValue();
                try {
                    go(num, h, w, c);
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
