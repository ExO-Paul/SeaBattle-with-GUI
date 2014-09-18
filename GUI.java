package Sokolchik.Paul.SeaBattle;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by sokolchik_p on 25.08.2014.
 */
public class GUI {

    public static void drawFrame() {
        MainFrame frame = new MainFrame();
    }

    static void winner(boolean win, String username, Container frame) {
        if (win)
            JOptionPane.showMessageDialog(frame, "You won, Admiral " + username + "!");
        else
            JOptionPane.showMessageDialog(frame, "Such a misfortune, " + username + " =(");
    }

    static String usernameEnter() {
        String username = JOptionPane.showInputDialog("Please, introduce yourself", "Stranger");
        return username;
    }


}
