package servlet01;
import JDBCutils.QueryForGDP;
import com.google.gson.Gson;
import datebean.GDP_CN;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletGDP extends HttpServlet {

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            QueryForGDP forGDP = new QueryForGDP();
            ArrayList<GDP_CN> gdp_cns;
            try {
                gdp_cns = forGDP.SelectMany();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            Gson gson = new Gson();

            String s1 = gson.toJson(gdp_cns);

            resp.getWriter().write(s1);


            System.out.println("BrithRate的doget方法被调用了");

        }

}
