package com.srn.erp.estadisticaRaciones.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.estadisticaRaciones.bm.EstadisticaRaciones;
import com.srn.erp.estadisticaRaciones.da.DBEstadisticaRaciones;

public class FactoryEstadisticaRaciones extends FactoryObjetoLogico {

	public FactoryEstadisticaRaciones() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstadisticaRaciones estadisticaraciones = (EstadisticaRaciones) objLog;
		estadisticaraciones.setEmpresa(db.getString(DBEstadisticaRaciones.EMPRESA));
		estadisticaraciones.setFecha(db.getDate(DBEstadisticaRaciones.FECHA));
		estadisticaraciones.setTiporacion(db.getString(DBEstadisticaRaciones.TIPO_RACION));
		estadisticaraciones.setTipo(db.getString(DBEstadisticaRaciones.TIPO));
		estadisticaraciones.setCantidad(db.getInteger(DBEstadisticaRaciones.CANTIDAD));
		estadisticaraciones.setAnio(db.getInteger(DBEstadisticaRaciones.ANIO));
		estadisticaraciones.setMes(db.getInteger(DBEstadisticaRaciones.MES));
		estadisticaraciones.setDia(db.getString(DBEstadisticaRaciones.DIA));

	}
}