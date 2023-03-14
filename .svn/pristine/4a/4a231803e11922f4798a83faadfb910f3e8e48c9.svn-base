package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.da.DBListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaPrecios extends FactoryObjetoLogico {

  public FactoryListaPrecios() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaPrecios listaprecios = (ListaPrecios) objLog;
    listaprecios.setOID(db.getInteger(DBListaPrecios.OID_PRECIO_CAB));
    listaprecios.setCodigo(db.getString(DBListaPrecios.CODIGO));
    listaprecios.setDescripcion(db.getString(DBListaPrecios.DESCRIPCION));
    listaprecios.setComentario(db.getString(DBListaPrecios.COMENTARIO));
    listaprecios.setFec_vig_desde(db.getDate(DBListaPrecios.FEC_VIG_DESDE));
    listaprecios.setFec_vig_hasta(db.getDate(DBListaPrecios.FEC_VIG_HASTA));
    listaprecios.setActivo(db.getBoolean(DBListaPrecios.ACTIVO));
    listaprecios.setIncluyeIVA(db.getBoolean(DBListaPrecios.INCLUYE_IVA));
  }
}
