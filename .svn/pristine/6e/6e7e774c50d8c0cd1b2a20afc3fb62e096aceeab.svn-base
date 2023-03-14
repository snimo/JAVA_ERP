package com.srn.erp.general.bl.Factory;

import com.srn.erp.contabilidad.bm.Leyenda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBTipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoComprobante extends FactoryObjetoLogico {

  public FactoryTipoComprobante() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoComprobante tipocomprobante = (TipoComprobante) objLog;
    tipocomprobante.setOID(db.getInteger(DBTipoComprobante.OID_TC));
    tipocomprobante.setTcexterno(db.getString(DBTipoComprobante.TC_EXT));
    tipocomprobante.setDescripcion(db.getString(DBTipoComprobante.DESCRIPCION));
    tipocomprobante.setIdentificacion(db.getString(DBTipoComprobante.IDENTIFICACION));
    tipocomprobante.setLeyenda(Leyenda.findByOidProxy(db.getInteger(DBTipoComprobante.OID_LEYENDA),getSesion()));
    tipocomprobante.setActivo(db.getBoolean(DBTipoComprobante.ACTIVO));
    tipocomprobante.setTipoComprobanteAnulador(TipoComprobante.findByOidProxy(db.getInteger(DBTipoComprobante.OID_TIPO_COMPRO_ANU),getSesion()));
    tipocomprobante.setCodigoParaCodigoBarra(db.getString(DBTipoComprobante.TC_PARA_COD_BARRA));
    tipocomprobante.setDescTituAsiLibroDiario(db.getString(DBTipoComprobante.DESC_TITU_ASI_LIBRO_DIARIO));
  }
}
