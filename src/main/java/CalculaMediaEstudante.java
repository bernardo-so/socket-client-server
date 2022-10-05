import java.util.List;

public class CalculaMediaEstudante {

    private List<Double> notas;
    private Double somatoriaNotas;

    CalculaMediaEstudante(List<Double> notas){
        this.notas = notas;
        this.somatoriaNotas = 0.0;
        setSomatoria();
    }

    private void setSomatoria(){
        for (Double nota: this.notas) {
            this.somatoriaNotas = somatoriaNotas + nota;
        }
    }

    Double getMedia() {
        return this.somatoriaNotas / this.notas.size();
    }

}