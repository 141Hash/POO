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


}
