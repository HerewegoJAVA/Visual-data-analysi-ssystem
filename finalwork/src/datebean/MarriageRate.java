package datebean;

/**
 * 中国历年结婚统计
 */
public class MarriageRate {
    private int date_Marr;
    private double marr_Rate;

    public MarriageRate() {
    }

    public MarriageRate(int date_Marr, double marr_Rate) {
        this.date_Marr = date_Marr;
        this.marr_Rate = marr_Rate;
    }

    public int getDate_Marr() {
        return date_Marr;
    }

    public void setDate_Marr(int date_Marr) {
        this.date_Marr = date_Marr;
    }

    public double getMarr_Rate() {
        return marr_Rate;
    }

    public void setMarr_Rate(double marr_Rate) {
        this.marr_Rate = marr_Rate;
    }

    @Override
    public String toString() {
        return "MarriageRate{" +
                "date_Marr=" + date_Marr +
                ", marr_Rate=" + marr_Rate +
                '}';
    }
}
