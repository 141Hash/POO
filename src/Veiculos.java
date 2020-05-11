import java.time.LocalDate;

public class Veiculos {
    private String matricula;
    private boolean disponivel;
    private LocalDate partida;
    private LocalDate chegada;
    private double precoTransporte;
    private double distancia;
    private double tempoEspera;
    private double velocidade;
    private double custo;
    private boolean aceitaEncomendaMedica;

    public Veiculos(){
        this.matricula = " ";
        this.disponivel = true;
        this.partida = LocalDate.now();
        this.chegada = LocalDate.now();
        this.precoTransporte = 0.0;
        this.distancia = 0.0;
        this.tempoEspera = 0.0;
        this.velocidade = 0.0;
        this.custo = 0.0;
        this.aceitaEncomendaMedica = true;
    }

    public Veiculos(String matricula, boolean disponivel, double precoTransporte, double distancia, double tempoEspera, double velocidade, double custo, boolean aceitaEncomendaMedica){
        this.matricula = matricula;
        this.disponivel = disponivel;
        this.partida = LocalDate.now();
        this.chegada = LocalDate.now();
        this.precoTransporte = precoTransporte;
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.velocidade = velocidade;
        this.custo = custo;
        this.aceitaEncomendaMedica = aceitaEncomendaMedica;
    }

    public Veiculos(Veiculos a){
        this.matricula = a.getMatricula();
        this.disponivel = a.isDisponivel();
        this.partida = a.getPartida();
        this.chegada = a.getChegada();
        this.precoTransporte = a.getPrecoTransporte();
        this.distancia = a.getDistancia();
        this.tempoEspera = a.getTempoEspera();
        this.velocidade = a.getVelocidade();
        this.custo = a.getCusto();
        this.aceitaEncomendaMedica = a.isAceitaEncomendaMedica();
    }

    public String getMatricula() {return matricula; }

    public boolean isDisponivel() {return this.disponivel; }

    public LocalDate getPartida() {
        return this.partida;
    }

    public LocalDate getChegada() {
        return this.chegada;
    }

    public double getPrecoTransporte() {
        return this.precoTransporte;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getTempoEspera() {
        return this.tempoEspera;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public double getCusto() {
        return this.custo;
    }

    public boolean isAceitaEncomendaMedica() {
        return this.aceitaEncomendaMedica;
    }

    public void setMatricula(String matricula) {this.matricula = matricula; }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setPartida(LocalDate partida) {
        this.partida = partida;
    }

    public void setChegada(LocalDate chegada) {
        this.chegada = chegada;
    }

    public void setPrecoTransporte(double precoTransporte) {
        this.precoTransporte = precoTransporte;
    }

    public void setAceitaEncomendaMedica(boolean aceitaEncomendaMedica) {
        this.aceitaEncomendaMedica = aceitaEncomendaMedica;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setTempoEspera(double tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculos t = (Veiculos) o;
        return  this.matricula.equals(t.getMatricula()) &&
                isDisponivel() == t.isDisponivel() &&
                t.getCusto() == this.getCusto() &&
                t.getDistancia() == this.getDistancia() &&
                t.getPrecoTransporte() == this.precoTransporte &&
                t.getVelocidade() == this.getVelocidade() &&
                t.getTempoEspera() == this.getTempoEspera() &&
                isAceitaEncomendaMedica() == t.isAceitaEncomendaMedica() &&
                getPartida().equals(t.getPartida()) &&
                getChegada().equals(t.getChegada());
    }

    public Veiculos clone(){
        return new Veiculos(this);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Matrícula: ");
        sb.append(this.matricula+"\n");
        sb.append("Disponibilidade: ");
        sb.append(this.disponivel+"\n");
        sb.append("Hora Partida: ");
        sb.append(this.partida+"\n");
        sb.append("Hora Chegada: ");
        sb.append(this.chegada+"\n");
        sb.append("PrecoTransporte: ");
        sb.append(this.precoTransporte+"\n");
        sb.append("Distancia: ");
        sb.append(this.distancia+"\n");
        sb.append("Tempo de espera: ");
        sb.append(this.tempoEspera +"\n");
        sb.append("Velocidade: ");
        sb.append(this.velocidade +"\n");
        sb.append("Custo: ");
        sb.append(this.custo +"\n");
        sb.append("Aceita encomenda médica: ");
        sb.append(this.aceitaEncomendaMedica +"\n");

        return sb.toString();
    }




}