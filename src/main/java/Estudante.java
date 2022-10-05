import java.io.Serializable;
import java.util.List;

public class Estudante implements Serializable {

    private List<Double> notas;
    private String nome;
    private Double mediaNotas;

    public Estudante (List<Double> notas, String nome){
        this.notas = notas;
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(Double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }
}
