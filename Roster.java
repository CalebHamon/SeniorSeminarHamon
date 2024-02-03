public class Roster {
    
    private String emailIn;
    private String nameIn;
    private String firIn;
    private String secIn;
    private String thiIn;
    private String fouIn;
    private String fifIn;

    public Roster(String nameG, String emailG, String firCh, String secCh, String thiCh, String fouCh, String fifCh){
        emailIn = emailG;
        nameIn = nameG;
        firIn = firCh;
        secIn = secCh;
        thiIn = thiCh;
        fouIn = fouCh;
        fifIn = fifCh;
    }

    public String toString(){
        return nameIn + " '" + emailIn + "' with first choice " + firIn;
    }

    public String retEmail(){
        return emailIn;
    }

    public String retName(){
        return nameIn;
    }

    public String retFir(){
        return firIn;
    }

    public void changeFir(){
        firIn = "";
    }
    
    public String retSec(){
        return secIn;
    }

    public void changeSec(){
        secIn = "";
    }

    public String retThi(){
        return thiIn;
    }

    public void changeThi(){
        thiIn = "";
    }

    public String retFou(){
        return fouIn;
    }

    public void changeFou(){
        fouIn = "";
    }

    public String retFif(){
        return fifIn;
    }

    public void changeFif(){
        fifIn = "";
    }
}

