package com.srn.erp.mensajero.op;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.DownLoadFile;
import framework.request.bl.Utils.MapDatos;

public class DownLoadSoundFile extends Operation {

	public DownLoadSoundFile() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fileName = mapaDatos.getString("file_name").trim();		
		DownLoadFile bajaArchivo = new DownLoadFile();	
		
		String path = "";
		if (mapaDatos.containsKey("path_archivo"))
			path = mapaDatos.getString("path_archivo");
		else {
			ValorParametro valorPathImagenesProd = ValorParametro.findByCodigoParametro("PATH_RING", this.getSesion());
			path = valorPathImagenesProd.getValorCadena();
		}
		
		bajaArchivo.setFieldPath(path);
		bajaArchivo.setFileName(fileName);
		bajaArchivo.setHttpServletRequest(this.getHttpServletRequest());
		bajaArchivo.setHttpServletResponse(this.getHttpServletResponse());
		bajaArchivo.setServletContext(this.getServletContext());
		bajaArchivo.downLoad();
				
		
	}

}
