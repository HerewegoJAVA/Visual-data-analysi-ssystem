package datebean;

/**
 * 中国历年GDP对象
 */
public class GDP_CN {
    public GDP_CN() {
    }

    private int date_GDP;
    private double gdp_Number;
    private double world_Rate;

    @Override
    public String toString() {
        return "GDP_CN{" +
                "date_GDP=" + date_GDP +
                ", gdp_Number=" + gdp_Number +
                ", world_Rate=" + world_Rate +
                '}';
    }

    public int getDate_GDP() {
        return date_GDP;
    }

    public void setDate_GDP(int date_GDP) {
        this.date_GDP = date_GDP;
    }

    public double getGdp_Number() {
        return gdp_Number;
    }

    public void setGdp_Number(double gdp_Number) {
        this.gdp_Number = gdp_Number;
    }

    public double getWorld_Rate() {
        return world_Rate;
    }

    public void setWorld_Rate(double world_Rate) {
        this.world_Rate = world_Rate;
    }

    public GDP_CN(int date_GDP, double gdp_Number, double world_Rate) {
        this.date_GDP = date_GDP;
        this.gdp_Number = gdp_Number;
        this.world_Rate = world_Rate;
    }
}
