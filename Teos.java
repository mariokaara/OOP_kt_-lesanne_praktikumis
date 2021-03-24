public abstract class Teos implements Comparable<Teos>{
    private String teoseKirjeldus;
    private String teoseTähis;
    private String laenutaja;
    private int päevadeArv;

    public Teos(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        this.teoseKirjeldus = teoseKirjeldus;
        this.teoseTähis = teoseTähis;
        this.laenutaja = laenutaja;
        this.päevadeArv = päevadeArv;
    }

    abstract boolean kasHoidlast();

    public double päevaneViivis(){
        if(teoseTähis.equals("roheline")){
            return 2.0;
        }
        else if(teoseTähis.equals("puudub")){
            return 0.15;
        }
        else if(teoseTähis.equals("kollane") || teoseTähis.equals("sinine")){
            return 0.05;
        }
        else{
            return 0;
        }
    }

    public int laenutusaeg(){
        if(teoseTähis.equals("roheline")){
            return 1;
        }
        else if(teoseTähis.equals("puudub")){
            return 14;
        }
        else if(teoseTähis.equals("kollane")){
            return 30;
        }
        else if(teoseTähis.equals("sinine")){
            return 60;
        }
        else{
            return 0;
        }
    }


    public String getTeoseTähis() {
        return teoseTähis;
    }

    public void setTeoseTähis(String teoseTähis) {
        this.teoseTähis = teoseTähis;
    }

    public int getPäevadeArv() {
        return päevadeArv;
    }

    public void setPäevadeArv(int päevadeArv) {
        this.päevadeArv = päevadeArv;
    }

    public void arvutaViivis(Kontrollija kontrollija){
        int üleLäinudPäevad = päevadeArv - laenutusaeg();
        if(üleLäinudPäevad > 0){
            double viivis = üleLäinudPäevad * päevaneViivis();
            kontrollija.salvestaViivis(laenutaja, teoseKirjeldus, viivis);
        }
    }

    @Override
    public String toString(){
        return "Teos{"+
                "teoseKirjeldus=" + teoseKirjeldus + "\n"+
                ", teoseTähis=" + teoseTähis + "\n" +
                ", laenutaja=" + laenutaja + "\n" +
                ", päevadeArv=" + päevadeArv + "\n" +
                ", kasHoidlast?=" + (kasHoidlast());
    }

    @Override
    public int compareTo(Teos o){
        return CharSequence.compare(teoseKirjeldus, o.teoseKirjeldus);
        // return teoseKirjeldus.compareTo(o.teoseKirjeldus);
    }

}
