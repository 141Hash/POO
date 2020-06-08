import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EmpresaTransportes extends UtilizadorSistema implements Serializable {
    private int nif;
    private double custo_km;
    private int velocidade;
    private int minutosDeEspera;
    private String local;
    private double raioDeAcao;
    private double classificao;
    private int avaliacoes;
    private ArrayList<Encomenda> registos;
    private int numeroMinimoEncomenda;
    private boolean transporteMedico;
    private boolean disponivel;


    public EmpresaTransportes(){
        super();
        this.nif = 0;
        this.custo_km = 0;
        this.local = " ";
        this.raioDeAcao = 0.0;
        this.registos = new ArrayList<>();
        this.numeroMinimoEncomenda = 0;
        this.avaliacoes = 0;
        this.classificao = 0;
        this.transporteMedico = false;
        this.disponivel = false;
        this.minutosDeEspera = 0;
        this.velocidade = 0;
    }

    public EmpresaTransportes(String email,String password,String codigo, String nome, int nif, double custo_km, String local,double latitude, double longitude, double raioDeAcao, ArrayList<Encomenda> registos, int numeroMinimoEncomenda,
                              boolean transporteMedico, double classificao, int avaliacoes, boolean disponivel, int minutosDeEspera, int velocidade){
        super(email, password, "Transportadora", codigo, nome, latitude, longitude);
        this.nif = nif;
        this.custo_km = custo_km;
        this.local = local;
        this.raioDeAcao = raioDeAcao;
        this.setRegistos(registos);
        this.numeroMinimoEncomenda = numeroMinimoEncomenda;
        this.transporteMedico = transporteMedico;
        this.classificao = classificao;
        this.avaliacoes = avaliacoes;
        this.disponivel = disponivel;
        this.minutosDeEspera = minutosDeEspera;
        this.velocidade = velocidade;
    }

    public EmpresaTransportes(EmpresaTransportes a){
        super(a);
        this.nif = a.getNif();
        this.custo_km = a.getCusto_km();
        this.local = a.getLocal();
        this.raioDeAcao = a.getRaioDeAcao();
        this.setRegistos(a.getRegistos());
        this.numeroMinimoEncomenda = a.getNumeroMinimoEncomenda();
        this.transporteMedico = a.aceitoTransporteMedicamentos();
        this.avaliacoes = a.getAvaliacoes();
        this.classificao = a.getClassificao();
        this.disponivel = a.isDisponivel();
        this.minutosDeEspera = a.getMinutosDeEspera();
        this.velocidade = a.getVelocidade();
    }

    public int getMinutosDeEspera() {
        return this.minutosDeEspera;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public boolean aceitoTransporteMedicamentos(){
        return this.transporteMedico;
    }

    public void aceitaMedicamentos(boolean state){
        this.transporteMedico = state;
    }

    public String getCodigo(){
      return super.getCodigo();
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public double getClassificao() {
        return classificao;
    }

    public String getNome(){
      return super.getNome();
    }

    public int getNif(){
      return this.nif;
    }

    public double getCusto_km(){
      return this.custo_km;
    }

    public String getLocal() {
        return local;
    }

    public double getLatitude() {
        return super.getLatitude();
    }

    public double getLongitude() {
        return super.getLongitude();
    }

    public double getRaioDeAcao() {
        return raioDeAcao;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public ArrayList<Encomenda> getRegistos() {
        return this.registos.stream().map(Encomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumeroMinimoEncomenda() {
        return numeroMinimoEncomenda;
    }


    public void setMinutosDeEspera(int minutosDeEspera) {
        this.minutosDeEspera = minutosDeEspera;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setCodigo(String codigo) {
        super.setCodigo(codigo);
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setClassificao(double classificao) {
        this.classificao = classificao;
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setCusto_km(double custo_km) {
        this.custo_km = custo_km;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setNumeroMinimoEncomenda(int numeroMinimoEncomenda) {
        this.numeroMinimoEncomenda = numeroMinimoEncomenda;
    }

    public void setRaioDeAcao(double raioDeAcao) {
        this.raioDeAcao = raioDeAcao;
    }

    public void setRegistos(ArrayList<Encomenda> registos) {
        this.registos = new ArrayList<>();
        ArrayList<Encomenda> aux = new ArrayList<Encomenda>();
        for(Encomenda e: registos){
            this.registos.add(e.clone());
        }
    }

    public void setTransporteMedico(boolean transporteMedico) {
        this.transporteMedico = transporteMedico;
    }

    public EmpresaTransportes clone(){
        return  new EmpresaTransportes(this);
    }

    public boolean equals(Object obj){
        if (obj == this )return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        EmpresaTransportes e = (EmpresaTransportes) obj;
        return  super.equals(obj) &&
                this.nif == e.getNif() &&
                this.custo_km == e.getCusto_km() &&
                this.local.equals(e.getLocal()) &&
                this.raioDeAcao == e.getRaioDeAcao() &&
                this.numeroMinimoEncomenda == e.getNumeroMinimoEncomenda() &&
                this.registos.equals(e.getRegistos()) &&
                this.transporteMedico == e.aceitoTransporteMedicamentos();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Código de empresa: ");
        sb.append(getCodigo() + "\n");
        sb.append("Nome: ");
        sb.append(getNome() + "\n");
        sb.append("Nif: ");
        sb.append(this.nif + "\n");
        sb.append("Custo por km: ");
        sb.append(this.custo_km + "\n");
        sb.append("Local: ");
        sb.append(this.local + "\n");
        sb.append("Latitude: ");
        sb.append(getLatitude() + "\n");
        sb.append("Longitude: ");
        sb.append(getLongitude() + "\n");
        sb.append("Raio de ação: ");
        sb.append(this.raioDeAcao + "\n");
        sb.append("Registos de encomendas: ");
        sb.append(this.registos.toString());
        sb.append("Número mínimo de encomendas: ");
        sb.append(this.numeroMinimoEncomenda+"\n");
        sb.append("Apta para transportes médicos: ");
        sb.append(this.transporteMedico+"\n");

        return sb.toString();
    }

    /**
     * Método que atualiza a classificação da empressa
     * @param classificacao
     */
    public void updateRate(Double classificacao){
        double total = this.classificao* this.avaliacoes + classificacao;
        this.avaliacoes++;
        this.classificao = total / this.avaliacoes;
    }

    /**
     * Método que adiciona uma encomenda aos registos de encomendas
     * @param e
     */
    public void addEncomenda (Encomenda e){
        this.registos.add(e.clone());
    }

    /**
     * Método que devolve o número de encomendas efetuadas pelo voluntário entre 2 datas
     * @param d1
     * @param d2
     * @return
     */
    public String getInfoEncomendas(LocalDateTime d1, LocalDateTime d2){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Set<String> lojas = new TreeSet<>();
        for(Encomenda e: this.registos){
            LocalDateTime date = e.getData();
            if(date.compareTo(d1) >= 0 && date.compareTo(d2) <= 0){
                lojas.add(e.getCodigo_loja());
                count++;
            }
        }
        String s1 = d1.getDayOfMonth() + "/" + d1.getMonthValue() + "/" + d1.getYear();
        String s2 = d2.getDayOfMonth() + "/" + d2.getMonthValue() + "/" + d2.getYear();

        sb.append("Entre as datas " + s1 + " e " + s2 + " foram realizadas " + count + " encomendas pela empresa " + getNome() +"\n");
        sb.append("Efetuou encomendas em " + lojas.size() + " lojas");
        return sb.toString();
    }


    /**
     * Método que devolve o total faturado por uma empresa entre duas datas
     * @param d1
     * @param d2
     * @param bd
     * @return
     */

    public String getFaturacao(LocalDateTime d1, LocalDateTime d2, BDGeral bd){
        StringBuilder sb = new StringBuilder();
        double total = 0;
        for(Encomenda e: this.registos){
            double unit = 0;
            double kms = 0;
            LocalDateTime date = e.getData();
            if(date.compareTo(d1) >= 0 && date.compareTo(d2) <= 0){
                unit += e.getPeso() * 0.2;
                try {
                    Utilizador userEnc = bd.getUtilizadores().getUsers().get(bd.getUtilizadores().getEmail(e.getCodigo_user()));
                    Loja lojaEnc = bd.getLojas().getLojas().get(bd.getLojas().getEmail(e.getCodigo_loja()));
                    kms += DistanceCalculator.distance(this.getLatitude(), lojaEnc.getLatitude(), this.getLongitude(), lojaEnc.getLongitude());
                    kms += DistanceCalculator.distance(lojaEnc.getLatitude(), userEnc.getLatitude(), lojaEnc.getLongitude(), userEnc.getLongitude());

                    unit += kms * this.getCusto_km();

                } catch (UserNotFoundException enc){
                    System.out.println("User not found");
                } catch (LojaNotFoundException enc){
                    System.out.println("Loja not found");
                }
            }
            total += unit;
        }

        String s1 = d1.getDayOfMonth() + "/" + d1.getMonthValue() + "/" + d1.getYear();
        String s2 = d2.getDayOfMonth() + "/" + d2.getMonthValue() + "/" + d2.getYear();

        sb.append("A sua empresa faturou " + total + " entre as datas " + s1 + " e " + s2 );
        return sb.toString();
    }

    public int getKms(BDGeral bd){
        int total = 0;
        for(Encomenda e: this.registos){
            try {
                Utilizador u = bd.getUtilizadores().getUsers().get(bd.getUtilizadores().getEmail(e.getCodigo_user())).clone();
                Loja j = bd.getLojas().getLojas().get(bd.getLojas().getEmail(e.getCodigo_loja())).clone();

                double dist1 = DistanceCalculator.distance(this.getLatitude(), j.getLatitude(), this.getLongitude(), j.getLongitude());
                double dist2 = DistanceCalculator.distance(j.getLatitude(), u.getLatitude(), j.getLongitude(), u.getLongitude());
                int kms = (int) (dist1 + dist2);
                total += kms;

            } catch (UserNotFoundException exp){

            } catch (LojaNotFoundException exp){

            }
        }

        return total;
    }

    public String getPreparadas(){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Encomenda s: this.registos){
            if(!s.isEntregue() && !s.isLevantada() && s.isPreparada()){
                sb.append(s);
                count++;
            }
        }
        if(count == 0) sb.append("0");
        return sb.toString();
    }

    public Encomenda getEncomenda(String cod) throws EncomendaNotFoundException{
        for(Encomenda s: this.registos){
            if(cod.equals(s.getCodigo())) return s;
        }
        throw new EncomendaNotFoundException();
    }

    public void updateEncomendaLoja(Encomenda enc){
        ArrayList<Encomenda> aux = new ArrayList<>();
        enc.setLevantada(true);
        aux.add(enc);
        for(Encomenda e: this.registos){
            if(!e.getCodigo().equals(enc.getCodigo())){
                aux.add(e);
            }
        }
        setRegistos(aux);
    }

    public String getNaoEntregue(){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Encomenda s: this.registos){
            if(!s.isEntregue() && s.isLevantada()){
                sb.append(s);
                count++;
            }
        }
        if(count == 0) sb.append("0");
        return sb.toString();
    }

    public void updateEncomenda(Encomenda enc){
        ArrayList<Encomenda> aux = new ArrayList<>();
        enc.setLevantada(true);
        aux.add(enc);
        for(Encomenda e: this.registos){
            if(!e.getCodigo().equals(enc.getCodigo())){
                aux.add(e);
            }
        }
        setRegistos(aux);
    }

    public void updateEncomendaPreparada(Encomenda enc){
        ArrayList<Encomenda> aux = new ArrayList<>();
        enc.setPreparada(true);
        aux.add(enc);
        for(Encomenda e: this.registos){
            if(!e.getCodigo().equals(enc.getCodigo())){
                aux.add(e);
            }
        }
        setRegistos(aux);
    }


}
