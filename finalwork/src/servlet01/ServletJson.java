package servlet01;
import JDBCutils.QuertForCPI;
import com.google.gson.Gson;
import datebean.CPI_CN;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        QuertForCPI forCPI = new QuertForCPI();
        ArrayList<CPI_CN> cpi_cns;
        try {
          cpi_cns = forCPI.SelectMany();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();

        String s1 = gson.toJson(cpi_cns);

        resp.getWriter().write(s1);

        System.out.println("CPI的doget方法被调用了");

    }


}
