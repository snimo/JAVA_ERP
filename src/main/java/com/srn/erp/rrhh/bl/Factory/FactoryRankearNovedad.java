package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RankearNovedad;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.da.DBRankearNovedad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRankearNovedad extends FactoryObjetoLogico {

	public FactoryRankearNovedad() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RankearNovedad rankearnovedad = (RankearNovedad) objLog;
		rankearnovedad.setOID(db.getInteger(DBRankearNovedad.OID_RANKEAR_NOV));
		rankearnovedad.setRankear(RankearCab.findByOidProxy(db.getInteger(DBRankearNovedad.OID_RANKEAR), getSesion()));
		rankearnovedad.setTipo_novedad(TipoNovedad.findByOidProxy(db.getInteger(DBRankearNovedad.OID_TIPO_NOV), getSesion()));
		rankearnovedad.setActivo(db.getBoolean(DBRankearNovedad.ACTIVO));
		rankearnovedad.setMotivo(MotivoTipoNov.findByOidProxy(db.getInteger(DBRankearNovedad.OID_MOTIVO), getSesion()));
		rankearnovedad.setAplicar(db.getBoolean(DBRankearNovedad.APLICAR));
		rankearnovedad.setSuma_o_resta(db.getString(DBRankearNovedad.SUMA_O_RESTA));
		rankearnovedad.setCalif_en_puntos(db.getMoney(DBRankearNovedad.CALIF_EN_PUNTOS));
		rankearnovedad.setAnalizar_ult_meses(db.getInteger(DBRankearNovedad.ANALIZAR_ULT_MESES));
		rankearnovedad.setPonderacion(db.getMoney(DBRankearNovedad.PONDERACION));

	}
}
