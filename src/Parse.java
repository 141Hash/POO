import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parse {
    private RegistosUsers ru;
    private RegistosLojas rl;
    private RegistosTransportes rt;
    private RegistosVoluntarios rv;
    private EncomendasAceites ea;


    public Parse(){
        this.ru = new RegistosUsers();
        this.rl = new RegistosLojas();
        this.rt = new RegistosTransportes();
        this.rv = new RegistosVoluntarios();
        this.ea = new EncomendasAceites();
    }

    public Parse(RegistosUsers ru, RegistosLojas rl, RegistosTransportes rt, RegistosVoluntarios rv, EncomendasAceites ea){
        setRu(ru);
        setRl(rl);
        setRt(rt);
        setRv(rv);
        setEa(ea);
    }

    public Parse (Parse a){
        setRu(a.getRu());
        setRl(a.getRl());
        setRt(a.getRt());
        setRv(a.getRv());
        setEa(a.getEa());
    }

    public RegistosLojas getRl() {
        return new RegistosLojas(this.rl.getLojas());
    }

    public EncomendasAceites getEa() {
        return new EncomendasAceites(this.ea.getAceites());
    }

    public RegistosTransportes getRt() {
        return new RegistosTransportes(this.rt.getTransportes());
    }

    public RegistosUsers getRu() {
        return new RegistosUsers(this.ru.getUsers());
    }

    public RegistosVoluntarios getRv() {
        return new RegistosVoluntarios(this.rv.getVoluntarios());
    }

    public void setRl(RegistosLojas rl) {
        this.rl = new RegistosLojas();
        this.rl.setLojas(rl.getLojas());
    }

    public void setEa(EncomendasAceites ea) {
        this.ea = new EncomendasAceites();
        this.ea.setAceites(ea.getAceites());
    }

    public void setRt(RegistosTransportes rt) {
        this.rt = new RegistosTransportes();
        this.rt.setTransportes(rt.getTransportes());
    }

    public void setRu(RegistosUsers ru) {
        this.ru = new RegistosUsers();
        this.ru.setUsers(ru.getUsers());
    }

    public void setRv(RegistosVoluntarios rv) {
        this.rv = new RegistosVoluntarios();
        this.rv.setVoluntarios(rv.getVoluntarios());
    }

    public void parse(){
        List<String> ler = lerFicheiro("logs.txt");
        String[] linhaPartida;
        for (String linha : ler) {
            linhaPartida = linha.split(":", -1);
            switch(linhaPartida[0]){
                case "Utilizador":
                    Utilizador u = parseUtilizador(linhaPartida[1]);
                    this.ru.add(u);
                    break;
                case "Loja":
                    Loja l = parseLojas(linhaPartida[1]);
                    this.rl.add(l);
                    break;
                case "Transportadora":
                    EmpresaTransportes t = parseEmpresaTransportes(linhaPartida[1]);
                    this.rt.add(t);
                    break;
                case "Voluntario":
                    Voluntario v = parseVoluntarios(linhaPartida[1]);
                    this.rv.add(v);
                    break;
                case "Encomenda":
                    Encomenda e = parseEncomenda(linhaPartida[1]);
                    System.out.println(e.toString());
                    break;
                case "Aceite":
                    this.ea = parseEncomendasAceites(linhaPartida[1], ea);
                    break;
                default:
                    System.out.println("Linha inválida.");
                    break;
            }

        }

    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println("Erro ao dar load dos logs."); }
        return lines;
    }

    public EncomendasAceites parseEncomendasAceites(String linha, EncomendasAceites ea){
        List<String> aux = ea.getAceites();
        aux.add(linha);
        ea.setAceites(aux);
        return ea;
    }

    public Loja parseLojas(String input){
      String []campos = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      double latitude = Double.parseDouble(campos[2]);
      double longitude = Double.parseDouble(campos[3]);
      return new Loja(codigo, nome, false, 0, 0, 0, 0, latitude, longitude, new ArrayList<>());
    }

    public Utilizador parseUtilizador(String input){
      String []campos = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      double latitude = Double.parseDouble(campos[2]);
      double longitude = Double.parseDouble(campos[3]);
      return new Utilizador(codigo, nome, latitude, longitude, " ", " ");
    }

    public Voluntario parseVoluntarios(String input){
      String []campos = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      double latitude = Double.parseDouble(campos[2]);
      double longitude = Double.parseDouble(campos[3]);
      double raio_acao = Double.parseDouble(campos[4]);
      return new Voluntario(nome, codigo, false, latitude, longitude, LocalDate.now(), raio_acao, new ArrayList<>(), 0);
    }

    public EmpresaTransportes parseEmpresaTransportes(String input){
        String []campos = input.split(",");
        String codigo = campos[0];
        String nome = campos[1];
        double latitude = Double.parseDouble(campos[2]);
        double longitude = Double.parseDouble(campos[3]);
        int nif = Integer.parseInt(campos[4]);
        double raioDeAcao = Double.parseDouble(campos[5]);
        double custo_km = Double.parseDouble(campos[6]);
        return new EmpresaTransportes(codigo, nome, nif, custo_km, " ", latitude, longitude, raioDeAcao, new ArrayList<>(), new ArrayList<>(), 0, false);
    }

    public Encomenda parseEncomenda(String input){
        Map<String, LinhaEncomenda> produtos = new HashMap<>();
        String []campos = input.split("," );
        String codigo = campos[0];
        String codigo_user = campos[1];
        String codigo_loja = campos[2];
        double peso = Double.parseDouble(campos[3]);
        for(int i = 4; i < campos.length; i += 4){
            String aux = campos[i] + "," + campos[i+1] + "," + campos[i+2] + "," + campos[i+3];
            LinhaEncomenda le = parseLinhaEncomenda(aux);
            produtos.put(le.getCodigo(), le.clone());

        }
        return new Encomenda(codigo, codigo_user, codigo_loja, peso, " ", " ", produtos,false);
    }


    public LinhaEncomenda parseLinhaEncomenda(String input){
        String []campos = input.split(",");
        String codigo = campos[0];
        String descricao = campos[1];
        double quantidade = Double.parseDouble(campos[2]);
        double preco = Double.parseDouble(campos[3]);

        return new LinhaEncomenda(codigo, descricao, preco, quantidade, false);
    }
}
