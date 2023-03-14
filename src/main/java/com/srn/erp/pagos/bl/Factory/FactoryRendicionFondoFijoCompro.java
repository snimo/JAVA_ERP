package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.da.DBRendicionFondoFijoCompro;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFondoFijoCompro extends FactoryObjetoLogico {

  public FactoryRendicionFondoFijoCompro() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFondoFijoCompro rendFFCompro = (RendicionFondoFijoCompro) objLog;    
    rendFFCompro.setOID(db.getInteger(DBRendicionFondoFijoCompro.OID_REND_FF_DET));
    rendFFCompro.setRendicion_fondo(RendicionFondoFijo.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_REND_FONDO),getSesion()));
    rendFFCompro.setComprobante_proveedor(ComproProveedor.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_CCO_PROV),getSesion()));
    rendFFCompro.setNetoGravado(db.getMoney(DBRendicionFondoFijoCompro.NETO_GRAVADO));
    rendFFCompro.setNetoNoGravado(db.getMoney(DBRendicionFondoFijoCompro.NETO_NO_GRAVADO));
    rendFFCompro.setIVA(db.getMoney(DBRendicionFondoFijoCompro.IVA));
    rendFFCompro.setPercIVA(db.getMoney(DBRendicionFondoFijoCompro.PERC_IVA));
    rendFFCompro.setPercIB(db.getMoney(DBRendicionFondoFijoCompro.PERC_IB));
    rendFFCompro.setOtrosImp(db.getMoney(DBRendicionFondoFijoCompro.OTROS_IMP));
    rendFFCompro.setTotal(db.getMoney(DBRendicionFondoFijoCompro.TOTAL));
    rendFFCompro.setMoneda(Moneda.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_MONEDA),getSesion()));
    rendFFCompro.setConcFactProv(ConcFactProv.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_CONC_FACT_PROV),getSesion()));
    rendFFCompro.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_CONC_IMPU_IVA),getSesion()));
    rendFFCompro.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_CONC_IMPU_PIVA),getSesion()));
    rendFFCompro.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRendicionFondoFijoCompro.OID_CONC_IMPU_PIB),getSesion()));
  }
}
