package servlet01;
import JDBCutils.QueryForBrith;
import com.google.gson.Gson;
import datebean.BrithRate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletBrith extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        QueryForBrith forBrith = new QueryForBrith();
        ArrayList<BrithRate> brithRate;
        try {
            brithRate = forBrith.SelectMany();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();

        String s1 = gson.toJson(brithRate);

        resp.getWriter().write(s1);


        System.out.println("BrithRate的doget方法被调用了");

    }


}
