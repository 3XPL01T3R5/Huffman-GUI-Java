package models;

/**
 *
 * @author Lucas
 */
public class HuffJob {
    
    private String origin;
    private String destination;
    private int progress;
    private int fileSize;
    private char operation;
    private String status;
    private String id;
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public char getOperation() {
        return operation;
    }
    
    public void setOperation(char operation) {
        this.operation = operation;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return retorna o id dessa tarefa
     */
    public String getId() {
        return id;
    }

    /**
     * @param id configura o id dessa tarefa
     */
    public void setId(String id) {
        this.id = id;
    }
}
