public class SuurimaViiviseLeidja implements Kontrollija{
    private String suurimViivitaja;
    private String suurimaViivitajaTeoseKirjeldus;
    private double suurimViivis;

    public void saadaHoiatus(){
        System.out.println(suurimViivitaja + " palun too tagasi teos kirjeldusega " + suurimaViivitajaTeoseKirjeldus);
    }

    @Override
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if(suurimViivis < viiviseSuurus){ //kui hetkel vaadeldav viivis on suurem kui suuremViivis siis asendame selle
            this.suurimViivitaja = laenutajaNimi;
            this.suurimaViivitajaTeoseKirjeldus = teoseKirjeldus;
            this.suurimViivis = viiviseSuurus;
        }
    }
}
