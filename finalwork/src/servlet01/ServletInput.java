package servlet01;

import JDBCutils.QueryForBrith;
import JDBCutils.UpdateForBrith;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletInput extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

         String yearBrith = req.getParameter("inputYear");
         int brithYear = Integer.parseInt(yearBrith);
        String table = req.getParameter("table");
        String option = req.getParameter("option");
        System.out.println("想要操作的数据表是:"+table);
        System.out.println("想要操作的数据表是:"+option);

        String rateBrith = req.getParameter("inputRate");
        double brithRate = Double.parseDouble(rateBrith);
        UpdateForBrith forBrith = new UpdateForBrith();
        try {
            forBrith.Insert(brithYear,brithRate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("utf-8");
        String prompt = "数据插入成功";
        resp.getWriter().write(prompt);


        System.out.println(yearBrith);
        System.out.println(rateBrith);

    }
}
