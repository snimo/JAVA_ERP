package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.CategoriaGanancia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.impuestos.da.DBSujetoImpositivo;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.CatRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySujetoImpositivo extends FactoryObjetoLogico {

  public FactorySujetoImpositivo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SujetoImpositivo sujetoimpositivo = (SujetoImpositivo) objLog;
  sujetoimpositivo.setOID(db.getInteger(DBSujetoImpositivo.OID_SUJ_IMP));
    sujetoimpositivo.setRazon(db.getString(DBSujetoImpositivo.RAZON_SOCIAL));
    sujetoimpositivo.setCuit(db.getString(DBSujetoImpositivo.CUIT));
    sujetoimpositivo.setExentoretiva(db.getBoolean(DBSujetoImpositivo.EXENTO_RET_IVA));
    sujetoimpositivo.setExentoretgan(db.getBoolean(DBSujetoImpositivo.EXENTO_RET_GAN));
    sujetoimpositivo.setExentoretib(db.getBoolean(DBSujetoImpositivo.EXENTO_RET_IB));
    sujetoimpositivo.setIngbrutos(db.getString(DBSujetoImpositivo.ING_BRUTOS));
    sujetoimpositivo.setDnrp(db.getString(DBSujetoImpositivo.DNRP));
    sujetoimpositivo.setCategiva(CategoriaIVA.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_IVA),getSesion()));
    sujetoimpositivo.setCategib(CategoriaIB.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_IB),getSesion()));
    sujetoimpositivo.setCateggan(CategoriaGanancia.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_GAN),getSesion()));
    sujetoimpositivo.setActivo(db.getBoolean(DBSujetoImpositivo.ACTIVO));
    sujetoimpositivo.setCatRetGan(CatRetGan.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_RET_GAN),getSesion()));
    sujetoimpositivo.setCatRetIVA(CatRetIVA.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_RET_IVA),getSesion()));
    sujetoimpositivo.setCatRetIB(CatRetIB.findByOidProxy(db.getInteger(DBSujetoImpositivo.OID_CAT_RET_IB),getSesion()));

  }
}
