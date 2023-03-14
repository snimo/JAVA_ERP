package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;
import com.srn.erp.ventas.da.DBPrecioPorEstrucLP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPrecioPorEstrucLP extends FactoryObjetoLogico { 

  public FactoryPrecioPorEstrucLP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PrecioPorEstrucLP precioporestruclp = (PrecioPorEstrucLP) objLog;
    precioporestruclp.setOID(db.getInteger(DBPrecioPorEstrucLP.OID_PRECIO_EST));
    precioporestruclp.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBPrecioPorEstrucLP.OID_PRECIO_CAB),getSesion()));
    precioporestruclp.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBPrecioPorEstrucLP.OID_UM),getSesion()));
    precioporestruclp.setCantidad(db.getDouble(DBPrecioPorEstrucLP.CANTIDAD));
    precioporestruclp.setMoneda(Moneda.findByOidProxy(db.getInteger(DBPrecioPorEstrucLP.OID_MONEDA),getSesion()));
    precioporestruclp.setPrecio(db.getDouble(DBPrecioPorEstrucLP.PRECIO));
    precioporestruclp.setValor_clasif_art1(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBPrecioPorEstrucLP.OID_CLASIF_ART_1),getSesion()));
    precioporestruclp.setValor_clasif_art2(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBPrecioPorEstrucLP.OID_CLASIF_ART_2),getSesion()));
    precioporestruclp.setActivo(db.getBoolean(DBPrecioPorEstrucLP.ACTIVO));
    precioporestruclp.setFecUltAct(db.getDate(DBPrecioPorEstrucLP.FEC_ULT_ACT));

  }
}
