import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Zhi Wang
 * @version 11/15/2018
 * @see RotatorGUI
 * <p>
 * This RotatorGUI class  extends JFrame and contain 4 methods
 */
public class RotatorGUI extends JFrame {
    /**
     * @param delayValue                the delay value
     * @param angleValue                the angle
     * @param change                        the angle to change
     * @param fileName                  the file name
     */
    public static int delayValue = 10;
    public int angleValue = 0;
    private int change;
    private final String fileName = "Round.png";

    /**
     * RotatorGUI method to set gui and added key event and timer
     */
    public RotatorGUI() {
        new FlowLayout();
        JPanel i = new JPanel();
        JLabel image = new JLabel();
        JLabel angleinput = new JLabel("angle: ");
        JTextField angleTxt = new JTextField(15);
        JLabel delayinput = new JLabel("delay is 100ms");
        JLabel warnning = new JLabel("");
        warnning.setSize(25, 1);
        add(i);
        i.add(angleinput);
        i.add(angleTxt);
        i.add(delayinput);
        i.add(image);
        i.add(warnning);

        angleTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String result1 = angleTxt.getText();
                try {
                    angleValue = Integer.parseInt(result1);
                    if (angleValue > 360 || angleValue < -360) {
                        angleValue = angleValue % 360;
                        warnning.setText("Pls input abs value < 360");
                    } else {
                        warnning.setText("");
                    }
                    System.out.println(change);
                } catch (NumberFormatException error) {
                    warnning.setText("Please input a number");
                    angleValue = 0;
                }
                change = angleValue;
            }
        });
        Timer timer = new Timer(delayValue, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image.setIcon(new ImageIcon(rotate(angleValue)));//setIcon
                angleValue = angleValue + change;
            }
        });
        timer.setDelay(delayValue);
        timer.start();
    }

    /**
     * rotate method to set gui and added key event and timer
     *
     * @param angle the angle needs to rotate
     * @return the rotated image
     */
    public BufferedImage rotate(int angle) {
        BufferedImage image;
        //System.out.println("Your angle: " +angle);
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File location = new File(classLoader.getResource(fileName).getFile());
            image = ImageIO.read(location);

            BufferedImage rImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics2D g = rImage.createGraphics();
            g.rotate(Math.toRadians(angle), image.getWidth() / 2, image.getHeight() / 2);
            g.drawImage(image, null, null);
            g.dispose();
            return rImage;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

