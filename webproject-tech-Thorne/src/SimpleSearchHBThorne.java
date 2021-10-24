import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.DateThorne;
import util.Info;
import util.UtilDBThorne;

@WebServlet("/SimpleSearchHBThorne")
public class SimpleSearchHBThorne extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHBThorne() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();
    
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<DateThorne> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = UtilDBThorne.listEvents(keyword);
      } 
      
      else {
         listEmployees = UtilDBThorne.listEvents();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<DateThorne> listEmployees, PrintWriter out) {
      for (DateThorne employee : listEmployees) {
         System.out.println("[DBG] " + employee.getId() + ", " //
               + employee.getMonth() + ", " //
               + employee.getDay() + ", " //
               + employee.getEvent());

         out.println("<li>" + employee.getId() + ", " //
               + employee.getMonth() + ", " //
               + employee.getDay() + ", " //
               + employee.getEvent()+ "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
