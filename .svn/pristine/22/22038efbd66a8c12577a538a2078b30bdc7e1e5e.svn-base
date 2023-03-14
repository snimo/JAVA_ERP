package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.EsquemaBonifProdDet;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;
import com.srn.erp.ventas.da.DBEsquemaBonifProdDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaBonifProdDet extends FactoryObjetoLogico { 

  public FactoryEsquemaBonifProdDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaBonifProdDet esquemabonificacionproductodet = (EsquemaBonifProdDet) objLog;
    esquemabonificacionproductodet.setOID(db.getInteger(DBEsquemaBonifProdDet.OID_ESQ_BON_DET));
    esquemabonificacionproductodet.setEsquema_bonif_producto(EsquemaBonificacionProducto.findByOidProxy(db.getInteger(DBEsquemaBonifProdDet.OID_ESQ_BONIF_PROD),getSesion()));
    esquemabonificacionproductodet.setFec_desde(db.getDate(DBEsquemaBonifProdDet.FEC_DESDE));
    esquemabonificacionproductodet.setFec_hasta(db.getDate(DBEsquemaBonifProdDet.FEC_HASTA));
    esquemabonificacionproductodet.setPorc_bonif_1(db.getDouble(DBEsquemaBonifProdDet.PORC_BONIF_1));
    esquemabonificacionproductodet.setPorc_bonif_2(db.getDouble(DBEsquemaBonifProdDet.PORC_BONIF_2));
    esquemabonificacionproductodet.setPorc_bonif_3(db.getDouble(DBEsquemaBonifProdDet.PORC_BONIF_3));
    esquemabonificacionproductodet.setPorc_bonif_4(db.getDouble(DBEsquemaBonifProdDet.PORC_BONIF_4));
    esquemabonificacionproductodet.setPorc_bonif_5(db.getDouble(DBEsquemaBonifProdDet.PORC_BONIF_5));
    esquemabonificacionproductodet.setEn_cascada(db.getBoolean(DBEsquemaBonifProdDet.EN_CASCADA));
    esquemabonificacionproductodet.setActivo(db.getBoolean(DBEsquemaBonifProdDet.ACTIVO));

  }
}
