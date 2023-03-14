package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.da.DBRecetaCab;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecetaCab extends FactoryObjetoLogico { 

  public FactoryRecetaCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  
	RecetaCab recetacab = (RecetaCab) objLog;
    recetacab.setOID(db.getInteger(DBRecetaCab.OID_REC_CAB));
    recetacab.setProduco(Producto.findByOidProxy(db.getInteger(DBRecetaCab.OID_PRODUCTO),getSesion()));
    recetacab.setBase_calculo(db.getDouble(DBRecetaCab.BASE_CALCULO));
    recetacab.setOid_um(UnidadMedida.findByOidProxy(db.getInteger(DBRecetaCab.OID_UM),getSesion()));
    recetacab.setAlternativa(db.getString(DBRecetaCab.ALTERNATIVA));
    recetacab.setActivo(db.getBoolean(DBRecetaCab.ACTIVO));

  }
}
