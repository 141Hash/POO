import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parse {

    public void parse(){
        List<String> ler = lerFicheiro("logs.txt");
        EncomendasAceites ea = new EncomendasAceites();
        String[] linhaPartida;
        for (String linha : ler) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Utilizador":
                    Utilizador u = parseUtilizador(linhaPartida[1]);
                    System.out.println(u.toString());
                    break;
                case "Loja":
                    Lojas l = parseLoja(linhaPartida[1]);
                    System.out.println(l.toString());
                    break;
                case "Transportadora":
                    break;
                case "Voluntario":
                    break;
                case "Encomenda":
                    break;
                case "Aceite":
                    ea = parseEncomendasAceites(linhaPartida[1], ea);
                    System.out.println(ea.toString());
                default:
                    System.out.println("Linha inválida.");
                    break;
            }

        }
        System.out.println("done!");
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

    public Lojas parseLojas(String input){
      String campos[] = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      String latitude = Double.parseDouble(campos[2]);
      String longitude = Double.parseDouble(campos[3]);
      boolean tempo_espera = false;
      return new Lojas(codigo, nome, false, 0, 0, 0, 0, latitude, longitude, new ArrayList<>());
    }

    public Utilizador parseUtilizador(String input){
      String campos[] = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      double latitude = Double.parseDouble(campos[2]);
      double longitude = Double.parseDouble(campos[3]);
      return new Utilizador(codigo, nome, latitude, longitude);
    }

    public Voluntarios parseVoluntarios(String input){
      String campos[] = input.split(",");
      String codigo = campos[0];
      String nome = campos[1];
      double latitude = Double.parseDouble(campos[2]);
      double longitude = Double.parseDouble(campos[3]);
      double raio_acao = Double.parseDouble(campos[4]);
      return new Voluntarios(nome, codigo, false, latitude, longitude, LocalDate.now(), raio_acao, new ArrayList<>(), 0);
    }

    public EmpresaTransportes parseEmpresaTransportes(String input){
        String campos[] = input.split(",");
        String codigo = campos[0];
        String nome = campos[1];
        double latitude = Double.parseDouble(campos[2]);
        double longitude = Double.parseDouble(campos[3]);
        int nif = Int.parseInt(campos[4]);
        double raioDeAcao = Double.parseDouble(campos[5]);
        double custo_km = Double.parseDouble(campos[6]);
        return new EmpresaTransportes(codigo, nome, nif, custo_km, " ", latitude, longitude, raioDeAcao, new ArrayList<>(), new ArrayList<>(), 0, false);
    }

    public Encomenda parseEncomenda(String input){
        String campos[] = input.split(",");
        String codigo = campos[0];
        String codigo_user = campos[1];
        String codigo_loja = campos[2];
        double peso = Double.parseDouble(campos[3]);
        Map<String, LinhaEncomenda> produtos = new HashMap<>();
        return new Encomenda(codigo, codigo_user, codigo_loja, peso, " ", " ", ,false);
    }

}
