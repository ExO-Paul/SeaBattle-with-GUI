package Sokolchik.Paul.SeaBattle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sokolchik_p on 10.09.2014.
 */
public class FieldPanel extends JPanel {

    Player player;
    Field field;
    int cellSize;

    public FieldPanel(Dimension size, Player player, boolean isMap) {
        super();

        this.setSize(size);
        this.setOpaque(true);
        this.setBackground(new Color(166, 180, 255));
        this.player = player;
        if (isMap)
            field = player.getMap();
        else
            field = player.getField();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(new Color(206, 220, 255));
        cellSize = (Math.min(this.getHeight(), this.getWidth())) / 10;
        for (int i = 0; i < 11; i++) {
            g2d.drawLine((cellSize * i), 0, (cellSize * i), cellSize * 10);
            g2d.drawLine(0, (cellSize * i), cellSize * 10, (cellSize * i));
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field.getCell(j, i).occupied) {
                    if (field.getCell(j, i).wasShot) {
                        g2d.setColor(new Color(199, 112, 20));
                        g2d.drawRect((cellSize * j), (cellSize * i), cellSize, cellSize);
                    } else {
                        g2d.setColor(new Color(199, 112, 20));
                        g2d.fillRect((cellSize * j), (cellSize * i), cellSize, cellSize);
                    }
                } else if (field.getCell(j, i).wasShot) {
                    g2d.setColor(new Color(255, 255, 255));
                    g2d.fillOval((int) (cellSize * (j + 0.4)), (int) (cellSize * (i + 0.4)), cellSize / 5, cellSize / 5);
                } else {
                    if (field.getCell(j, i).wasMarked) {
                        g2d.setColor(new Color(199, 112, 20));
                        g2d.drawRect((cellSize * j) + cellSize / 4, (cellSize * i) + cellSize / 4, cellSize / 2, cellSize / 2);
                    }

                }
            }
        }
    }

}



