package com.srn.erp.cubo.bl.Factory;

import com.srn.erp.cubo.bm.DimensionCubo;
import com.srn.erp.cubo.da.DBDimensionCubo;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;
import framework.xlook.bm.Select;

public class FactoryDimensionCubo extends FactoryObjetoLogico { 

  public FactoryDimensionCubo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DimensionCubo dimensioncubo = (DimensionCubo) objLog;
    dimensioncubo.setOID(db.getInteger(DBDimensionCubo.OID_DIMENSION));
    dimensioncubo.setCodigo(db.getString(DBDimensionCubo.CODIGO));
    dimensioncubo.setDescripcion(db.getString(DBDimensionCubo.DESCRIPCION));
    dimensioncubo.setTipo_dimension(db.getString(DBDimensionCubo.TIPO_DIMENSION));
    dimensioncubo.setSelect(Select.findByOidProxy(db.getInteger(DBDimensionCubo.OID_SELECT),getSesion()));
    dimensioncubo.setNombre_oper(db.getString(DBDimensionCubo.NOMBRE_OPER));
    dimensioncubo.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(db.getInteger(DBDimensionCubo.OID_CLASIF_ENT),getSesion()));
    dimensioncubo.setActivo(db.getBoolean(DBDimensionCubo.ACTIVO));

  }
}
