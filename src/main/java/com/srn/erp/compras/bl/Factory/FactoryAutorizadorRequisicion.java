package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AutorizadorRequisicion;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBAutorizadorRequisicion;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizadorRequisicion extends FactoryObjetoLogico { 

  public FactoryAutorizadorRequisicion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizadorRequisicion autorizadorrequisicion = (AutorizadorRequisicion) objLog;
    autorizadorrequisicion.setOID(db.getInteger(DBAutorizadorRequisicion.OID_AUTORIZ_REQ));
    autorizadorrequisicion.setEsquema_autorizacion(EsquemaAutorizCompras.findByOidProxy(db.getInteger(DBAutorizadorRequisicion.OID_ESQ_AUTORIZ),getSesion()));
    autorizadorrequisicion.setSector_emisor(SectorCompra.findByOidProxy(db.getInteger(DBAutorizadorRequisicion.OID_SECTOR_EMISOR),getSesion()));
    autorizadorrequisicion.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBAutorizadorRequisicion.OID_ROL_AUTORIZ),getSesion()));
    autorizadorrequisicion.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAutorizadorRequisicion.OID_VAL_CLASIF_ENT),getSesion()));
    autorizadorrequisicion.setTipoAutoriz(db.getString(DBAutorizadorRequisicion.TIPO_AUTORIZ));
    autorizadorrequisicion.setActivo(new Boolean(true));
  }
}
