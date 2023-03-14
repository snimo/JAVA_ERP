package com.srn.erp.excluidos.bm;







import java.util.List;

import com.srn.erp.excluidos.da.DBIndividuoExcluidoSinc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;


public class IndividuoExcluidoSinc extends IndividuoExcluido {
	
	Integer nroLote = null;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public IndividuoExcluidoSinc() {
	}
	

	public static String NICKNAME = "exc.IndividuoExcluidoSinc";


	public Integer get() {
		return nroLote;
	}

	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}

	@Override
	public String getNickName() {
		return NICKNAME;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return true;
	}


	public static List getExcluidosByNroLote(ISesion aSesion,Integer nroLote) throws BaseException {
		return DBIndividuoExcluidoSinc.getExcluidosByNroLote(aSesion,nroLote);
	}

}
