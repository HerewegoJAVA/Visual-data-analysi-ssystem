package test;

import JDBCutils.QuertForCPI;
import datebean.CPI_CN;

import java.util.ArrayList;

public class CpiTest {
    public static void main(String[] args) throws Exception {
        QuertForCPI cpi = new QuertForCPI();

        ArrayList<CPI_CN> cpi_cns;

        cpi_cns=cpi.SelectMany();
        System.out.println(cpi_cns);

//        for (int i = 0; i < cpi_cns.size(); i++) {
//            int date_cpi = cpi_cns.get(i).getDate_CPI();
//            String jsonCpPuls = date_cpi+",";
//            System.out.print(jsonCpPuls);
//        }
    }
}
