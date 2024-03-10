package servlet01;

import JDBCutils.QueryForGDP;
import JDBCutils.QueryForHouse;
import com.google.gson.Gson;
import datebean.GDP_CN;
import datebean.HouseRate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletHouse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        QueryForHouse forHouse = new QueryForHouse();
        ArrayList<HouseRate>house_cns;

        try {

            house_cns = forHouse.SelectMany();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();

        String s1 = gson.toJson(house_cns);

        resp.getWriter().write(s1);


        System.out.println("House的doget方法被调用了");

    }
}
