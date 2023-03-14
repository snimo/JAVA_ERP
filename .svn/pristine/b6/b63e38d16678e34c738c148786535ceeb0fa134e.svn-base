package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.EsqHabProdUsu;
import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.compras.da.DBEsqHabProdUsu;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryEsqHabProdUsu extends FactoryObjetoLogico { 

  public FactoryEsqHabProdUsu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsqHabProdUsu esquemahabilitacionproductousuario = (EsqHabProdUsu) objLog;
    esquemahabilitacionproductousuario.setOID(db.getInteger(DBEsqHabProdUsu.OID_ESQ_HAB_USU));
    esquemahabilitacionproductousuario.setEsquema_habilitacion(EsquemaHabilitacionProducto.findByOidProxy(db.getInteger(DBEsqHabProdUsu.OID_ESQ_HAB_PROD),getSesion()));
    esquemahabilitacionproductousuario.setValor_clasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEsqHabProdUsu.OID_VAL_CLASIF_ENT),getSesion()));
    esquemahabilitacionproductousuario.setUsuario(Usuario.findByOidProxy(db.getInteger(DBEsqHabProdUsu.OID_USUARIO),getSesion()));

  }
}
