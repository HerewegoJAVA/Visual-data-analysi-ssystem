package datebean;

public class CPI_CN {
    private int date_CPI;
    private double cpi_Rate;

    public CPI_CN(int date_CPI, double cpi_Rate) {
        this.date_CPI = date_CPI;
        this.cpi_Rate = cpi_Rate;
    }

    public CPI_CN() {
    }

    @Override
    public String toString() {
        return "CPI_CN{" +
                "date_CPI=" + date_CPI +
                ", cpi_Rate=" + cpi_Rate +
                '}';
    }

    public int getDate_CPI() {
        return date_CPI;
    }

    public void setDate_CPI(int date_CPI) {
        this.date_CPI = date_CPI;
    }

    public double getCpi_Rate() {
        return cpi_Rate;
    }

    public void setCpi_Rate(double cpi_Rate) {
        this.cpi_Rate = cpi_Rate;
    }
}
