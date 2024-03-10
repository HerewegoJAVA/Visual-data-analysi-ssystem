package datebean;

/**
 * 全国房地产上市公司A股指数
 */
public class HouseRate {
    private int date_House;
    private double rate_House;
    public HouseRate(int date_House, double rate_House) {
        this.date_House = date_House;
        this.rate_House = rate_House;
    }

    public HouseRate() {
    }

    public int getDate_House() {
        return date_House;
    }

    public double getRate_House() {
        return rate_House;
    }

    public void setDate_House(int date_House) {
        this.date_House = date_House;
    }

    public void setRate_House(double rate_House) {
        this.rate_House = rate_House;
    }

    @Override
    public String toString() {
        return "HouseRate{" +
                "date_House=" + date_House +
                ", rate_House=" + rate_House +
                '}';
    }


}
