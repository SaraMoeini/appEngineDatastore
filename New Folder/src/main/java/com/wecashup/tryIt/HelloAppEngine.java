package com.wecashup.tryIt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.utils.SystemProperty;

@WebServlet(name = "servlet")
public class HelloAppEngine extends HttpServlet {

  private static final long serialVersionUID = 1L;

  User user = new User();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    Properties properties = System.getProperties();

    response.setContentType("text/plain");
    response.getWriter().println("Hello App Engine - Standard using " + SystemProperty.version.get() + " Java "
        + properties.get("java.specification.version"));
  }

  /********** POST METHOD ************/

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    user.setEmail(request.getParameter("email"));
    user.setFirstname(request.getParameter("firstname"));
    user.setLastname(request.getParameter("lastname"));
    // user.setPassword(request.getParameter("password"));
    user.setPassword(String.valueOf((request.getParameter("password")).hashCode()));

    Writer w = new Writer();
    w.save(user);
    boolean r = w.save(user);

   // response.getWriter().println("person " + user.getFirstname() + " " + user.getLastname() + " saved successfully : " + r);
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    if (r) 
      out.println("Successfully done.");
    else
      out.println("Unsuccessfully terminated.");
    out.println("<h3><a href='/'>Return to a new form</a></h3>");
    out.println("</body></html>");
  }

}
