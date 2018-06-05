package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        Account acc = new Account(request.getParameter("name"), request.getParameter("password"));

//        out.print("login-name: " + acc.getName() + "\nPassword: " + acc.getPassword()
//                + "\nLogin-hash: " + acc.getNameHash() + "\nPass-hash: " + acc.getPassHash());

        acc.setData(acc);

        request.setAttribute("id", acc.getId());
        request.setAttribute("login", request.getParameter("name"));
        request.setAttribute("login_hash", acc.getNameHash());
        request.setAttribute("password", request.getParameter("password"));
        request.setAttribute("password_hash", acc.getPassHash());

        request.getRequestDispatcher("/information.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Account acc = new Account(request.getParameter("name"), request.getParameter("password"));

        out.print("login-name: " + acc.getName() + "\nPassword: " + acc.getPassword()
                + "\nLogin-hash: " + acc.getNameHash() + "\nPass-hash: " + acc.getPassHash());

        acc.setData(acc);
    }



}
