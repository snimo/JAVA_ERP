package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<!--\r\n");
      out.write("Design by Free CSS Templates\r\n");
      out.write("http://www.freecsstemplates.org\r\n");
      out.write("Released for free under a Creative Commons Attribution 2.5 License\r\n");
      out.write("\r\n");
      out.write("Title      : Newfangled\r\n");
      out.write("Version    : 1.0\r\n");
      out.write("Released   : 20070331\r\n");
      out.write("Description: A three-column fixed-width template ideal for 1024x768 pixel resolution. Suitable for blogs and small business websites.\r\n");
      out.write("\r\n");
      out.write("-->\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Newfangled by Free Css Templates</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div id=\"logo\">\r\n");
      out.write("\t\t<h1><a href=\"#\">MasSoftWEB</a></h1>\r\n");
      out.write("\t\t<h2><a href=\"http://www.freecsstemplates.org/\"></a></h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"menu\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"#\" title=\"\">Principal</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"http://localhost:8080/ERP/ctacteprov.htm\" title=\"\">Cuenta Corriente</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\" title=\"\">Productos</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"http://localhost:8080/ERP/BuscarCliente.htm\" title=\"\">Clientes</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\" title=\"\">Soporte</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<div id=\"sidebar\">\r\n");
      out.write("\t\t<div id=\"login\" class=\"boxed\">\r\n");
      out.write("\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t<h2>Ingreso al Sistema MasSoft</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<form id=\"form1\" method=\"post\" action=\"/ERP/j_spring_security_check\">\r\n");
      out.write("\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t<legend>Sign-In</legend>\r\n");
      out.write("\t\t\t\t\t<label for=\"inputtext1\">Usuario:</label>\r\n");
      out.write("\t\t\t\t\t<input id=\"inputtext1\" type=\"text\" name=\"j_username\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t<label for=\"inputtext2\">Clave:</label>\r\n");
      out.write("\t\t\t\t\t<input id=\"inputtext2\" type=\"password\" name=\"j_password\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t<label for=\"inputtext3\">Recordcar </label>\r\n");
      out.write("\t\t\t\t\t<input id=\"inputtext3\" type=\"checkbox\" name=\"_spring_security_remember_me\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<input id=\"inputsubmit1\" type=\"submit\" value=\"Ingresar\" />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<p><a href=\"/spring_security_login\">Olvido su clave?</a></p>\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #login -->\r\n");
      out.write("\t\t<div id=\"updates\" class=\"boxed\">\r\n");
      out.write("\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t<h2>Recent Updates</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<h3>March 5, 2007</h3>\r\n");
      out.write("\t\t\t\t\t\t<p><a href=\"#\">In posuere eleifend odio quisque semper augue mattis wisi maecenas ligula&#8230;</a></p>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<h3>March 3, 2007</h3>\r\n");
      out.write("\t\t\t\t\t\t<p><a href=\"#\">Quisque dictum integer nisl risus, sagittis convallis, rutrum id, congue, and nibh&#8230;</a></p>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<h3>February 28, 2007</h3>\r\n");
      out.write("\t\t\t\t\t\t<p><a href=\"#\">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue rutrum&#8230;</a></p>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<h3>February 25, 2007</h3>\r\n");
      out.write("\t\t\t\t\t\t<p><a href=\"#\">Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam nequea&#8230;</a></p>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<h3>February 20, 2007</h3>\r\n");
      out.write("\t\t\t\t\t\t<p><a href=\"#\">Vivamus fermentum nibh in augue. Praesent a lacus at urna congue rutrum. Nulla enim eros&#8230;</a></p>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #updates -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end #sidebar -->\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div id=\"welcome\" class=\"post\">\r\n");
      out.write("\t\t\t<h2 class=\"title\"><span>Bienvenido a MasSoft</span></h2>\r\n");
      out.write("\t\t\t<h3 class=\"date\"><span class=\"month\">Mar.</span> <span class=\"day\">8</span><span class=\"year\">, 2007</span></h3>\r\n");
      out.write("\t\t\t<div class=\"story\"><img src=\"images/img09.gif\" alt=\"\" width=\"120\" height=\"120\" class=\"left\" />\r\n");
      out.write("\t\t\t\t<p><strong>MasSoftWEB</strong> en el sistema que le permite conocer en todo momento sus transacciones pendientes. <em>Gracias por visitarnos :)</em></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"meta\">\r\n");
      out.write("\t\t\t\t<p>Posted by Jane Anderson under <a href=\"#\">Uncategorized</a>, <a href=\"#\">Daily Journal</a><br />\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">Trackback URI</a> | <a href=\"#\">No Comments</a> | <a href=\"#\">Permalink</a></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #welcome -->\r\n");
      out.write("\t\t<div id=\"example\" class=\"post\">\r\n");
      out.write("\t\t\t<h2 class=\"title\"><span>Udted podra consultar</span></h2>\r\n");
      out.write("\t\t\t<h3 class=\"date\"><span class=\"month\">Feb.</span> <span class=\"day\">24</span><span class=\"year\">, 2007</span></h3>\r\n");
      out.write("\t\t\t<div class=\"story\">\r\n");
      out.write("\t\t\t\t<p>Accediendo al sistema:</p>\r\n");
      out.write("\t\t\t\t<blockquote>\r\n");
      out.write("\t\t\t\t\t<p>&ldquo;Las siguientes transacciones: Ordenes de Compras, Facturas imputadas , Pagos Autorizados.&rdquo;</p>\r\n");
      out.write("\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t<h3>Importante</h3>\r\n");
      out.write("\t\t\t\t<p>Si no es usuario registrado, por favor siga los siguientes pasos:</p>\r\n");
      out.write("\t\t\t\t<p>Pasos para su registración:</p>\r\n");
      out.write("\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t\t<li>1- Envie un e-mai a ... solicitando la registracion como usuario indicando su nombre completo y la firma a la que pertence </li>\r\n");
      out.write("\t\t\t\t\t<li>1- Un representante se contactara con la empresa para verificar su identidad</li>\r\n");
      out.write("\t\t\t\t\t<li>1- Usted recibira un mail de confirmacion con el usuario y clave para poder acceder al sistema </li>\r\n");
      out.write("\t\t\t\t\t<li>2- Podra cambiar su usuario y clave para que se adapte mejor a su operatoria</li>\r\n");
      out.write("\t\t\t\t</ol>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"meta\">\r\n");
      out.write("\t\t\t\t<p>Posted by Jane Anderson under <a href=\"#\">Samples</a><br />\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">Trackback URI</a> | <a href=\"#\">No Comments</a> | <a href=\"#\">Permalink</a></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #example -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end #main -->\r\n");
      out.write("\t<div id=\"sidebar2\">\r\n");
      out.write("\t\t<div id=\"sponsors\" class=\"boxed\">\r\n");
      out.write("\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t<h2>OTROS LINKS</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li> <a href=\"#\">MasSoft</a></li>\r\n");
      out.write("\t\t\t\t\t<li> <a href=\"#\">Quisque dictum </a></li>\r\n");
      out.write("\t\t\t\t\t<li> <a href=\"#\">Donec leo, vivamus </a></li>\r\n");
      out.write("\t\t\t\t\t<li> <a href=\"#\">Nam pede erat porta </a></li>\r\n");
      out.write("\t\t\t\t\t<li> <a href=\"#\">Vivamus fermentum </a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #sponsors -->\r\n");
      out.write("\t\t<div id=\"ad120x600\"><a href=\"#\"><img src=\"images/ad_120x600.jpg\" alt=\"\" width=\"120\" height=\"600\" /></a></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end #sidebar2 -->\r\n");
      out.write("<!-- end #content -->\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\t<p id=\"legal\">Copyright &copy; 2007 Newfangled. All Rights Reserved. Designed by <a href=\"http://www.freecsstemplates.org/\">Free CSS Templates</a>.</p>\r\n");
      out.write("\t<p id=\"links\"><a href=\"#\">Privacy Policy</a> | <a href=\"#\">Terms of Use</a></p>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
