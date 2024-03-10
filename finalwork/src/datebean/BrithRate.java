package datebean;

import java.io.Serializable;

/**
 * 全国生育率的对象
 */
public class BrithRate implements Serializable {


    //    private static final long serialVersionUID = 10078079L;
    public int date_Brith;
    public double brith_Years;

    public BrithRate() {
    }

    public BrithRate(int date_Brith, double brith_Years) {
        this.date_Brith = date_Brith;
        this.brith_Years = brith_Years;
    }

    public int getDate_Brith() {
        return date_Brith;
    }

    public void setDate_Brith(int date_Brith) {
        this.date_Brith = date_Brith;
    }

    public double getBrith_Years() {
        return brith_Years;
    }

    public void setBrith_Years(double brith_Years) {
        this.brith_Years = brith_Years;
    }

    @Override
    public String toString() {
        return "BrithRate{" +
                "date_Brith=" + date_Brith +
                ", brith_Years=" + brith_Years +
                '}';
    }
}
