/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import huffteste.FormPrincipal;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class DragDrop extends DropTarget {
    private FormPrincipal form;
    private char option;
    public DragDrop(FormPrincipal form, char option) {
        this.form = form;
        this.option = option;
    }
    @Override
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> arqs = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    arqs = arqs.stream().filter(f -> !f.isDirectory()).collect(Collectors.toList());
                    if (arqs.size() > 0) {
                        String det;
                        if (option == 'c')
                            det = "As versões comprimidas serão salvas no diretório de origem.";
                        else
                            det = "Certifique-se de que esses arquivos estejam comprimidos por Huff.";
                        int res;
                        if (arqs.size() > 1)
                            res = JOptionPane.showConfirmDialog(null, "Deseja inserir " + arqs.size() + " arquivos na fila? " + det, "Adicionar múltiplos arquivos", JOptionPane.YES_NO_OPTION);
                        else
                            res = JOptionPane.showConfirmDialog(null, "Deseja inserir " + arqs.size() + " arquivo na fila? " + det, "Adicionar arquivo", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            arqs.stream().forEach((f) -> {
                                if (option == 'c')
                                    form.addJob(option, f.getAbsolutePath(), f.getAbsolutePath() + ".huff");
                                else
                                    form.addJob(option, f.getAbsolutePath(), f.getAbsolutePath().replaceAll(".huff$", ""));
                            });
                        }
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();

                }
            }
}
