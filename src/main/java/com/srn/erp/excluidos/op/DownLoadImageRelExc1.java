package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.RelacionExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageRelExc1 extends Operation {

	public DownLoadImageRelExc1() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();

		IndividuoExcluido individuo = IndividuoExcluido.findByOid(new Integer(fileName), this.getSesion());
		RelacionExcluido relacionExcluido = null;
		if (individuo!=null)
			relacionExcluido = RelacionExcluido.getRelacionExcluido(individuo, 1, this.getSesion());
		

		if (relacionExcluido == null) {
			DownLoadFile bajaArchivo = new DownLoadFile();
			bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
			bajaArchivo.setFileName("NULO_" + fileName);
			bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
			bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
			bajaArchivo.setServletContext(this.getServletContext());
			bajaArchivo.downLoad();
		} else {
			if (relacionExcluido.getIndividuo_rel() != null) {
				DownLoadFile bajaArchivo = new DownLoadFile();
				bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
				bajaArchivo.setFileName("FPE_1_" + relacionExcluido.getIndividuo_rel().getOIDInteger());
				bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
				bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
				bajaArchivo.setServletContext(this.getServletContext());
				bajaArchivo.downLoad();
			} else {
				DownLoadFile bajaArchivo = new DownLoadFile();
				bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
				bajaArchivo.setFileName("RE_1_" + fileName);
				bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
				bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
				bajaArchivo.setServletContext(this.getServletContext());
				bajaArchivo.downLoad();
			}
		}

	}

}
