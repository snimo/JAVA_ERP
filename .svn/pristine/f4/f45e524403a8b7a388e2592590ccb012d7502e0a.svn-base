package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionRankear;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.da.DBSancionRankear;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySancionRankear extends FactoryObjetoLogico {

	public FactorySancionRankear() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		SancionRankear sancionrankear = (SancionRankear) objLog;
		sancionrankear.setOID(db.getInteger(DBSancionRankear.OID_SANCION_RANK));
		sancionrankear.setMotivo_sancion(SancionesRRHH.findByOidProxy(db.getInteger(DBSancionRankear.OID_MOT_SANCION), getSesion()));
		sancionrankear.setActivo(db.getBoolean(DBSancionRankear.ACTIVO));
		sancionrankear.setAplicar(db.getBoolean(DBSancionRankear.APLICAR));
		sancionrankear.setSuma_o_resta(db.getString(DBSancionRankear.SUMA_O_RESTA));
		sancionrankear.setCalif_en_puntos(db.getMoney(DBSancionRankear.CALIF_EN_PUNTOS));
		sancionrankear.setOid_rankear(RankearCab.findByOidProxy(db.getInteger(DBSancionRankear.OID_RANKEAR), getSesion()));
		sancionrankear.setAnalizar_ult_meses(db.getInteger(DBSancionRankear.ANALIZAR_ULT_MESES));
		sancionrankear.setPonderacion(db.getMoney(DBSancionRankear.PONDERACION));

	}
}
