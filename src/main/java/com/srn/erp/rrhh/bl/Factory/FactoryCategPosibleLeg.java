package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.da.DBCategPosibleLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategPosibleLeg extends FactoryObjetoLogico {

	public FactoryCategPosibleLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CategPosibleLeg categposibleleg = (CategPosibleLeg) objLog;
		categposibleleg.setOID(db.getInteger(DBCategPosibleLeg.OID_CATEG_POS_LEG));
		categposibleleg.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCategPosibleLeg.OID_LEGAJO), getSesion()));
		categposibleleg.setCateg_posible(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBCategPosibleLeg.OID_CATEG_POSIBLE), getSesion()));
		categposibleleg.setFec_desde(db.getDate(DBCategPosibleLeg.FEC_DESDE));
		categposibleleg.setFec_hasta(db.getDate(DBCategPosibleLeg.FEC_HASTA));
		categposibleleg.setActivo(db.getBoolean(DBCategPosibleLeg.ACTIVO));
		categposibleleg.setRankearCab(RankearCab.findByOidProxy(db.getInteger(DBCategPosibleLeg.OID_RANKEAR),this.getSesion()));
	}
}
