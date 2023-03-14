package com.srn.erp.mensajero.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.mensajero.bm.Maquina;
import com.srn.erp.mensajero.da.DBMaquina;

public class FactoryMaquina extends FactoryObjetoLogico {

	public FactoryMaquina() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Maquina maquina = (Maquina) objLog;
		maquina.setOID(db.getInteger(DBMaquina.OID_MAQUINA));
		maquina.setNombre(db.getString(DBMaquina.NOMBRE));
		maquina.setDescripcion(db.getString(DBMaquina.DESCRIPCION));
		maquina.setEs_ip_dinamica(db.getBoolean(DBMaquina.ES_IP_DINAMICA));
		maquina.setIp(db.getString(DBMaquina.IP));
		maquina.setActiva(db.getBoolean(DBMaquina.ACTIVA));

	}
}
