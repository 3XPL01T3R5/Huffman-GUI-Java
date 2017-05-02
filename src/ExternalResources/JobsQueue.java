package ExternalResources;

import huffteste.FormPrincipal;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import models.HuffJob;
import util.GeradorID;

/**
 *
 * @author lucas
 */
public class JobsQueue {

    private ArrayList<HuffmanProgram> fila;
    private ArrayList<HuffmanProgram> threads;
    private final JFrame form;
    private int slots;
    private double removed = 0;
    public JobsQueue(JFrame form) {
        fila = new ArrayList<>();
        threads = new ArrayList<>();
        this.form = form;
    }

    public void addJob(HuffJob hj, DefaultListModel<HuffmanProgram> lm) {
        String id = GeradorID.getID();
        HuffmanProgram hp = new HuffmanProgram(hj, lm, this);
        hp.setOperatingSystem(System.getProperty("os.name"));
        hp.getHj().setId(id);
        if (getFila().isEmpty() && getThreads().isEmpty()) {
            ((FormPrincipal) form).notify(0);
            removed = 0;
        }            
        if (getThreads().size() >= getSlots()) {
            getFila().add(hp);
            hp.getHj().setStatus("Em Fila de Espera");
        } else {
            getThreads().add(hp);
        }
        lm.addElement(hp);
        requestUpdate(lm);
    }

    public void requestUpdate(DefaultListModel<HuffmanProgram> lm) {
        double soma = 0;
        if (getThreads().size() < getSlots()) {
            int slotss = getSlots() - getThreads().size();
            for (int i = getFila().size() - 1; i >= 0; i--) {
                if (slotss-- == 0)
                    break;
                getThreads().add(getFila().get(0));
                getFila().remove(0);
            }
        }
        for (int i = getThreads().size() - 1; i >= 0; i--) {
            if (!threads.get(i).isStarted()) {
                getThreads().get(i).execute();
                getThreads().get(i).getHj().setStatus("Executando");
                lm.setElementAt(getThreads().get(i), i);
            } else if (getThreads().get(i).isDone()) {
                if (!getThreads().get(i).isCancelled())
                    getThreads().get(i).getHj().setStatus("Finalizado");
                else
                    getThreads().get(i).getHj().setStatus("Tarefa Cancelada");
                getThreads().remove(i);
                lm.removeElementAt(i);
                removed++;
            } else {
                soma += getThreads().get(i).getHj().getProgress();
            }
        }
        soma+=100*removed;
        double qt = getFila().size() + getThreads().size() + removed;
        if (qt > 0) {
            ((FormPrincipal) form).notify((int) (soma / qt));
        } else {
            ((FormPrincipal) form).notify(0);
            removed = 0;
        }
    }

    /**
     * @return the fila
     */
    public ArrayList<HuffmanProgram> getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(ArrayList<HuffmanProgram> fila) {
        this.fila = fila;
    }

    /**
     * @return the threads
     */
    public ArrayList<HuffmanProgram> getThreads() {
        return threads;
    }

    /**
     * @param threads the threads to set
     */
    public void setThreads(ArrayList<HuffmanProgram> threads) {
        this.threads = threads;
    }

    /**
     * @return the slots
     */
    public int getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(int slots) {
        this.slots = slots;
    }
}
