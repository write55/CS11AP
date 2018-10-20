/*
Aaron Wu
 */

public class Registration {

    // CONSTANTS
    public static final int BATIK_LIMIT = 6;
    public static final int CALIGRAPHY_LIMIT = 4;
    public static final int PAINTING_LIMIT = 7;
    public static final int SCULTURE_LIMIT = 4;
    public static final int WEAVING_LIMIT = 5;
    public static final int SENTINEL = 0;
    public static final int CLASS_LIMIT = 2;

    // PRIVATE DATA
    private int batik = 0;
    private int caligraphy = 0;
    private int painting = 0;
    private int sculpture = 0;
    private int weaving = 0;

    // CONSTRUCTOR (No Arguments)
    public Registration() {

    }

    // GETTERS
    public int getBatik() {
        return batik;
    }

    public int getCaligraphy() {
        return caligraphy;
    }

    public int getPainting() {
        return painting;
    }

    public int getSculpture() {
        return sculpture;
    }

    public int getWeaving() {
        return weaving;
    }

    // SETTERS
    public void setBatik(int batik) {
        this.batik = batik;
    }

    public void setCaligraphy(int caligraphy) {
        this.caligraphy = caligraphy;
    }

    public void setPainting(int painting) {
        this.painting = painting;
    }

    public void setSculpture(int sculpture) {
        this.sculpture = sculpture;
    }

    public void setWeaving(int weaving) {
        this.weaving = weaving;
    }



}
