package yli6_p2EC;

public class Storage {
    private int[] position;
    private MessageDecoder[] list;
    private String[] filename;

    public Storage(int[] position, MessageDecoder[] list, String[] filename) {
        this.position = position;
        this.list = list;
        this.filename = filename;
    }
}
