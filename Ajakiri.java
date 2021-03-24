public class Ajakiri extends Teos{

    private int ilmumisAasta;

    public Ajakiri(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv, int ilmumisAasta) { //konstruktor
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
        this.ilmumisAasta = ilmumisAasta;
    }

    @Override
    boolean kasHoidlast() { //meetod mis tagastab väärtuse kas Ajakiri on hoidlast
        if(ilmumisAasta <=2000){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){ //Lisab ajakiri lisandi Teose toString meetodile
        return "Ajakiri :" + super.toString();
    }
}
