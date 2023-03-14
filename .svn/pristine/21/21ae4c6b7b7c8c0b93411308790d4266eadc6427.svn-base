package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadImageFotoExcluidoPrinci extends Operation {

	public DownLoadImageFotoExcluidoPrinci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		try {

			String fileName = mapaDatos.getString("file_name").trim();

			IndividuoExcluido indi = IndividuoExcluido.findByOid(new Integer(fileName), this.getSesion());

			Integer nroFoto = 1;
			if (indi.getFotoPrincipal() != null)
				if (indi.getFotoPrincipal()!=0)
					nroFoto = indi.getFotoPrincipal();

			DownLoadFile bajaArchivo = new DownLoadFile();
			bajaArchivo.setFieldPath(IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion()));
			bajaArchivo.setFileName("FPE_" + nroFoto + "_" + fileName);
			bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
			bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
			bajaArchivo.setServletContext(this.getServletContext());
			bajaArchivo.downLoad();

		} catch (Exception e) {
		}

	}

}
