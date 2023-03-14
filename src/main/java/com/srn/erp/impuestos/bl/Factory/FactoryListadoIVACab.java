package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.impuestos.da.DBListadoIVACab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListadoIVACab extends FactoryObjetoLogico { 

  public FactoryListadoIVACab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListadoIVACab listadoivacab = (ListadoIVACab) objLog;
    listadoivacab.setOID(db.getInteger(DBListadoIVACab.OID_LISTADO_IVA));
    listadoivacab.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBListadoIVACab.OID_CCO),getSesion()));
    listadoivacab.setRazon_social(db.getString(DBListadoIVACab.RAZON_SOCIAL));
    listadoivacab.setCategoria_iva(CategoriaIVA.findByOidProxy(db.getInteger(DBListadoIVACab.OID_CAT_IVA),getSesion()));
    listadoivacab.setCuit(db.getString(DBListadoIVACab.CUIT));
    listadoivacab.setNeto_gravado(db.getMoney(DBListadoIVACab.NETO_GRAVADO));
    listadoivacab.setNeto_no_gravado(db.getMoney(DBListadoIVACab.NETO_NO_GRAVADO));
    listadoivacab.setTotal(db.getMoney(DBListadoIVACab.TOTAL));
    listadoivacab.setTipo_listado(db.getString(DBListadoIVACab.TIPO_LISTADO));
    listadoivacab.setSujetoImpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBListadoIVACab.OID_SUJ_IMP),getSesion()));
  }
}
