package block6pathvariableheaders;

public class Saludo {
    private int id;
    private String content;

    public Saludo(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Saludo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
