package Sokolchik.Paul.SeaBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by sokolchik_p on 10.09.2014.
 */
public class MainFrame extends JFrame {

    GamePanel gamePanel;
    MainFrame thisFrame;
    JMenuItem startMenuItem, restartMenuItem;


    public MainFrame() {

        super("SeaBattle");

        thisFrame = this;
        this.repaint(1);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dimension.width / 2, dimension.height / 2);
        this.setLocation((dimension.width - this.getWidth()) / 2, (dimension.height - this.getHeight()) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        final JMenu gameMenu = new JMenu("Game");

        startMenuItem = new JMenuItem("Start");
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel = new GamePanel();
                thisFrame.add(gamePanel, BorderLayout.CENTER);
                thisFrame.setVisible(true);
                startMenuItem.setVisible(false);
                restartMenuItem.setVisible(true);
            }
        });

        gameMenu.add(startMenuItem);

        restartMenuItem = new JMenuItem("Restart");
        restartMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisFrame.remove(gamePanel);
                gamePanel = new GamePanel();
                thisFrame.add(gamePanel, BorderLayout.CENTER);
                thisFrame.setVisible(true);
            }
        });

        restartMenuItem.setVisible(false);

        gameMenu.add(restartMenuItem);

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        gameMenu.add(quitMenuItem);

        menuBar.add(gameMenu);


        JMenu helpMenu = new JMenu("Help");

        JMenuItem howMenuItem = new JMenuItem("How to play");
        howMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        helpMenu.add(howMenuItem);

        menuBar.add(helpMenu);

        /*this.setLayout( new BorderLayout());*/

        this.add(menuBar, BorderLayout.NORTH);


        this.setVisible(true);


    }
}
