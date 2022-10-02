import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingLogo {
    private Timer timer;
    private int x = 0;
    private int y = 0;
    private int xVeloicty = 10;
    private int yVeloicty = 10;
    public static void main(String[] args) {
        new BouncingLogo();
    }

    public BouncingLogo() {
        Image icon = new ImageIcon("Icon_128x128.png").getImage();
        JFrame frame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.fillRect(0, 0, icon.getWidth(null), icon.getWidth(null));
                g.drawImage(icon, 0, 0, null);
            }
        };
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x > 2048 - icon.getWidth(null) || x < 0)
                    xVeloicty = xVeloicty * -1;
                if (y > 1152 - icon.getHeight(null) || y < 0)
                    yVeloicty = yVeloicty * -1;
                x += xVeloicty;
                y += yVeloicty;
                frame.setLocation(x, y);
            }
        });
        timer.start();
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);
        frame.setSize(icon.getWidth(null), icon.getWidth(null));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }
}
