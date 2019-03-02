package S2;

public class Freshman extends HSStudent {

    private int referrals;

    public Freshman() {
        super();
    }

    public Freshman(String fn, String ln, int g, double q, int r) {
        super(fn, ln, g, q);
        referrals = r;
    }

    public int getReferrals() {
        return referrals;
    }

    public void setReferrals(int r) {
        referrals = r;
    }

    public String convertGrade(int input) {
        if (input == 9) {
            return "S2.Freshman";
        } else {
            return Integer.toString(input);
        }
    }

    public String toString() {
        return super.toString() + "\nDiscipline Referrals in Middle School: " + referrals;
    }

}
