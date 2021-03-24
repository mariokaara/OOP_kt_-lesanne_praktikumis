import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Peaklass {


    /**
     * meetod mis võtab tekstifaili ja siis muudab selle meile kasutatavasse formaati
     * @param failinimi täpselt nagu nimi ütleb, muutuja failinimi
     * @return tagastab meile Listi, mis sisaldab Ajakirju ja Raamatuid
     * @throws Exception juhul kui meil on mingisugune error (näiteks faili lugemisega) siis visatakse meile erind
     */
    public static List<Teos> loeTeosed(String failinimi) throws Exception{
        List<String> read = Files.readAllLines(Path.of(failinimi));
        List<Teos> teosed = new ArrayList<>();

        for(String rida:read){
            String[] info = rida.split("; ");
            if(info[0].contains("/")){
                int aastaAlgus= info[0].indexOf('/');
                int aastaLopp = info[0].indexOf(',');
                String pealkiri = info[0].substring(0,aastaAlgus);
                teosed.add(new Ajakiri(pealkiri, info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[0].substring(aastaAlgus+1, aastaLopp))));
            }
            else{
                teosed.add(new Raamat(info[0], info[1], info[2], Integer.parseInt(info[3])));
            }
        }
        return teosed;
    }

    public static void main(String[] args) throws Exception {
        String failiNimi = "laenutus.txt";
        List<Teos> teosed = loeTeosed(failiNimi); //7. ül esimene punkt
        Collections.sort(teosed); // 7. ül teine punkt (kasutatakse compareTo ja sorteeritakse list)
        ViiviseHoiataja viiviseHoiataja = new ViiviseHoiataja(0.2); //7 ül kolmas punkt, loome vastavad isendid
        SuurimaViiviseLeidja suurimaViiviseLeidja = new SuurimaViiviseLeidja();

        for (Teos teos: teosed) {
            teos.arvutaViivis(viiviseHoiataja); //7. ül neljas punkt
        }
        System.out.println(viiviseHoiataja.getHoiatatavadLaenutajad()); //väljastame viivitajad ekraanile
        for(Teos teos: teosed){
            teos.arvutaViivis(suurimaViiviseLeidja); //7. ül viies punkt
        }
        suurimaViiviseLeidja.saadaHoiatus(); //väljsatame suurima viivitaja ekraanile

    }


}
