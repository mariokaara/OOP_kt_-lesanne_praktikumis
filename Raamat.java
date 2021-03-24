public class Raamat extends Teos{

    public Raamat(String teoseKirjeldus, String teoseTähis, String laenutaja, int päevadeArv) {
        super(teoseKirjeldus, teoseTähis, laenutaja, päevadeArv);
    }

    @Override
    boolean kasHoidlast() { //Tagastab kas raamat on hoidlast
        if(super.getTeoseTähis().equals("kollane") || super.getTeoseTähis().equals("sinine")){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){ //Lisab raamatu sõne Teose toString() tagastusele otsa
        return "Raamat :" + super.toString();
    }
}
