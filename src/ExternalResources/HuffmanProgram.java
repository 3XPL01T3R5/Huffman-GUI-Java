package ExternalResources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
import models.HuffJob;

/**
 *
 * @author Lucas
 */
public class HuffmanProgram extends SwingWorker<Void, Integer> {

    private HuffJob hj;
    private String terminalInfo;
    private String operatingSystem;
    private final JobsQueue queue;
    private boolean didStart;
    private final DefaultListModel<HuffmanProgram> lm;

    public HuffmanProgram(HuffJob hj, DefaultListModel<HuffmanProgram> lm, JobsQueue queue) {
        this.hj = hj;
        this.queue = queue;
        terminalInfo = "";
        didStart = false;
        this.lm = lm;
    }

    @Override
    protected Void doInBackground() throws Exception {
        setStarted(true);
        try {
            String command;
            if (operatingSystem.toLowerCase().contains("win")) {
                command = "huffwin";
            } else {
                command = "./hufflinux";
            }
            ProcessBuilder builder = new ProcessBuilder(command, "-" + getHj().getOperation(), getHj().getOrigin(), getHj().getDestination());
            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            boolean vai = false;
            while ((line = reader.readLine()) != null && !isCancelled()) {
                if (line.equals("BEGIN_PROGRESS")) {
                    vai = true;
                    continue;
                } else if (line.equals("END_PROGRESS")) {
                    vai = false;
                    continue;
                }
                if (vai) {
                    publish(Integer.parseInt(line));
                } else {
                    terminalInfo += line + "\n";
                }

            }
            if (isCancelled()) {
                terminalInfo += "Codificação cancelada pelo usuário.\n";
                publish(0);
            } else {
                publish(100);
            }
            process.destroy();
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void process(List<Integer> vem) {
        getHj().setProgress(vem.get(vem.size() - 1));
        queue.requestUpdate(lm);
    }

    @Override
    protected void done() {
        queue.requestUpdate(lm);
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isStarted() {
        return didStart;
    }

    public HuffJob getHj() {
        return hj;
    }

    public void setHj(HuffJob hj) {
        this.hj = hj;
    }

    public void setStarted(boolean didStart) {
        this.didStart = didStart;
    }
}
