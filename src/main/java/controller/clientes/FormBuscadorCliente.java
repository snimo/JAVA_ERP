package controller.clientes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class FormBuscadorCliente extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		
		String razonSocial = arg0.getParameter("razon_social");
		
		if (razonSocial!=null)
			System.out.println(razonSocial);
		
		return new ModelAndView("BuscarCliente","","");
	}

}


