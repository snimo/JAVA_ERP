package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.ColumnaLibroIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.impuestos.da.DBConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoImpuesto extends FactoryObjetoLogico {

  public FactoryConceptoImpuesto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoImpuesto conceptoimpuesto = (ConceptoImpuesto) objLog;
    conceptoimpuesto.setOID(db.getInteger(DBConceptoImpuesto.OID_CONC_IMPU));
    conceptoimpuesto.setCodigo(db.getString(DBConceptoImpuesto.CODIGO));
    conceptoimpuesto.setDescripcion(db.getString(DBConceptoImpuesto.DESCRIPCION));
    conceptoimpuesto.setImpuesto(Impuesto.findByOidProxy(db.getInteger(DBConceptoImpuesto.OID_IMPUESTO),getSesion()));
    conceptoimpuesto.setColumnalibroiva(ColumnaLibroIVA.findByOidProxy(db.getInteger(DBConceptoImpuesto.OID_COL_LIBRO_IVA),getSesion()));
    conceptoimpuesto.setRegimen(db.getString(DBConceptoImpuesto.REGIMEN));
    conceptoimpuesto.setCuentaImputable(CuentaImputable.findByOidProxy(db.getInteger(DBConceptoImpuesto.OID_ANA_IMP),getSesion()));
    conceptoimpuesto.setActivo(db.getBoolean(DBConceptoImpuesto.ACTIVO));
    conceptoimpuesto.setProvincia(Provincia.findByOidProxy(db.getInteger(DBConceptoImpuesto.OID_PROVINCIA),getSesion()));
    conceptoimpuesto.setBaseImponible(db.getMoney(DBConceptoImpuesto.BASE_IMPONIBLE));
    conceptoimpuesto.setImpuestoMinimo(db.getMoney(DBConceptoImpuesto.IMPUESTO_MINIMO));
    conceptoimpuesto.setColImpreCompro(db.getString(DBConceptoImpuesto.COL_IMPRE_COMPRO));
    conceptoimpuesto.setCodigoAfip(db.getInteger(DBConceptoImpuesto.CODIGO_AFIP));
  }
}
