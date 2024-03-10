package servlet01;
import JDBCutils.QueryForMarry;
import com.google.gson.Gson;
import datebean.MarriageRate;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletMarr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        QueryForMarry forMarry = new QueryForMarry();
        ArrayList<MarriageRate> marr_cns;

        try {

            marr_cns = forMarry.SelectMany();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();

        String s1 = gson.toJson(marr_cns);

        resp.getWriter().write(s1);

        System.out.println("Marry的方法被调用了");

    }
}
