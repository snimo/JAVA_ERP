package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionClasifProd;
import com.srn.erp.ventas.da.DBEsquemaBonificacionClasifProd;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaBonificacionClasifProd extends FactoryObjetoLogico { 

  public FactoryEsquemaBonificacionClasifProd() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaBonificacionClasifProd esquemabonificacionclasifprod = (EsquemaBonificacionClasifProd) objLog;
    esquemabonificacionclasifprod.setOID(db.getInteger(DBEsquemaBonificacionClasifProd.OID_ESQ_BON_CLASIF));
    esquemabonificacionclasifprod.setFec_desde(db.getDate(DBEsquemaBonificacionClasifProd.FEC_DESDE));
    esquemabonificacionclasifprod.setEsquema_bonificacion(EsquemaBonificacion.findByOidProxy(db.getInteger(DBEsquemaBonificacionClasifProd.OID_ESQ_BONIF),getSesion()));
    esquemabonificacionclasifprod.setFec_hasta(db.getDate(DBEsquemaBonificacionClasifProd.FEC_HASTA));
    esquemabonificacionclasifprod.setPorc_bonif_1(db.getDouble(DBEsquemaBonificacionClasifProd.PORC_BONIF_1));
    esquemabonificacionclasifprod.setPorc_bonif_2(db.getDouble(DBEsquemaBonificacionClasifProd.PORC_BONIF_2));
    esquemabonificacionclasifprod.setPorc_bonif_3(db.getDouble(DBEsquemaBonificacionClasifProd.PORC_BONIF_3));
    esquemabonificacionclasifprod.setPorc_bonif_4(db.getDouble(DBEsquemaBonificacionClasifProd.PORC_BONIF_4));
    esquemabonificacionclasifprod.setPorc_bonif_5(db.getDouble(DBEsquemaBonificacionClasifProd.PORC_BONIF_5));
    esquemabonificacionclasifprod.setEn_cascada(db.getBoolean(DBEsquemaBonificacionClasifProd.EN_CASCADA));
    esquemabonificacionclasifprod.setActivo(db.getBoolean(DBEsquemaBonificacionClasifProd.ACTIVO));
    esquemabonificacionclasifprod.setValor_clasif_entidad(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEsquemaBonificacionClasifProd.OID_VAL_CLASIF_ENT),getSesion()));

  }
}
