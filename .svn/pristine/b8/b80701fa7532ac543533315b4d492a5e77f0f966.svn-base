package com.srn.erp.general.op;

import framework.applicarionServer.bl.Configuracion.DefTemplateForm;
import framework.applicarionServer.bm.Seguridad.Programa;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadDFMZipeado extends Operation {

	public DownLoadDFMZipeado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {


	      Integer oidPrograma = mapaDatos.getInteger("file_name");
	      Programa programa = Programa.findByOid(oidPrograma,getSesion());
	      String template = programa.getClase();
		
	      DefTemplateForm defTemplateForm = 
	      	this.getServicios().getServicioDicTemplateForm().getDiccionarioTemplateForm().getDefTemForm(template);
	      
	      String archivoRelativo = defTemplateForm.getZipFile();
	      
	      String nombreReal = this.getServletContext().getRealPath(archivoRelativo);
	      
	      DownLoadFile bajaArchivo = new DownLoadFile();
	      bajaArchivo.setFieldPath(nombreReal);
	      bajaArchivo.setFileName("");
	      bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
	      bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
	      bajaArchivo.setServletContext(this.getServletContext());
	      bajaArchivo.downLoad();
		
		
		
	}

}
