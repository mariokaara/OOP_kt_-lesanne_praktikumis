import java.util.ArrayList;
import java.util.List;

public class ViiviseHoiataja implements Kontrollija{
    private List<String> hoiatatavadLaenutajad = new ArrayList<>(); //Listi peab initializema, sest muidu tuleb nullpointerException
    private double lubatudViivis;

    public ViiviseHoiataja(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    public List<String> getHoiatatavadLaenutajad() {
        return hoiatatavadLaenutajad;
    }

    @Override //lisame meetodi salvestaViivis, mis eksisteerib Kontrollijas
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if(viiviseSuurus > lubatudViivis && !getHoiatatavadLaenutajad().contains(laenutajaNimi) ){
            hoiatatavadLaenutajad.add(laenutajaNimi);
        }
    }
}
