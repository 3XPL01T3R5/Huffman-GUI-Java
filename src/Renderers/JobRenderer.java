/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderers;

import ExternalResources.HuffmanProgram;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author lucas
 */
public class JobRenderer extends JLabel implements ListCellRenderer<HuffmanProgram> {

    public JobRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends HuffmanProgram> list, HuffmanProgram hp, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon;
        if (hp.getHj().getStatus().startsWith("Ex")) {
            imageIcon = new ImageIcon(getClass().getResource("/images/run.png"));
        } else {
            imageIcon = new ImageIcon(getClass().getResource("/images/waiting.png"));
        }
        setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        Path p = Paths.get(hp.getHj().getOrigin());
        setText(hp.getHj().getId() + " - " + p.getFileName().toString());
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }

}
