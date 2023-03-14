package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.da.DBConceptoImpuestoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoImpuestoProducto extends FactoryObjetoLogico {

  public FactoryConceptoImpuestoProducto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoImpuestoProducto conceptoimpuestoproducto = (ConceptoImpuestoProducto) objLog;
    conceptoimpuestoproducto.setOID(db.getInteger(DBConceptoImpuestoProducto.OID_CONC_IMPU_PROD));
    conceptoimpuestoproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBConceptoImpuestoProducto.OID_PRODUCTO),getSesion()));
    conceptoimpuestoproducto.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBConceptoImpuestoProducto.OID_CONC_IMPU),getSesion()));
    conceptoimpuestoproducto.setFecha_vigencia(db.getDate(DBConceptoImpuestoProducto.FECHA_VIGENCIA));
    conceptoimpuestoproducto.setValClasifEnt(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBConceptoImpuestoProducto.OID_VAL_CLASIF_ENT),getSesion()));

  }
}
