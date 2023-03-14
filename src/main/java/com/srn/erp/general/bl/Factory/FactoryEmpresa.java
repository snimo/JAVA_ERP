package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.da.DBEmpresa;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresa extends FactoryObjetoLogico {

  public FactoryEmpresa() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Empresa empresa = (Empresa) objLog;
    empresa.setOID(db.getInteger(DBEmpresa.OID_EMPRESA));
    empresa.setRazon_social(db.getString(DBEmpresa.RAZON_SOCIAL));
    empresa.setNombre_fantasia(db.getString(DBEmpresa.NOMBRE_FANTASIA));
    empresa.setCalle_y_nro(db.getString(DBEmpresa.CALLE_Y_NRO));
    empresa.setLocalidad(db.getString(DBEmpresa.LOCALIDAD));
    empresa.setCodigo_postal(db.getString(DBEmpresa.CODIGO_POSTAL));
    empresa.setProvincia(Provincia.findByOidProxy(db.getInteger(DBEmpresa.OID_PROVINCIA),getSesion()));
    empresa.setPais(Pais.findByOidProxy(db.getInteger(DBEmpresa.OID_PAIS),getSesion()));
    empresa.setCategoria_iva(CategoriaIVA.findByOidProxy(db.getInteger(DBEmpresa.OID_CAT_IVA),getSesion()));
    empresa.setCategoria_ib(CategoriaIB.findByOidProxy(db.getInteger(DBEmpresa.OID_CAT_IB),getSesion()));
    empresa.setCuit(db.getString(DBEmpresa.CUIT));
    empresa.setNro_ing_brutos(db.getString(DBEmpresa.NRO_ING_BRUTOS));
    empresa.setAgen_ret_iva(db.getBoolean(DBEmpresa.AGEN_RET_IVA));
    empresa.setAgen_ret_gan(db.getBoolean(DBEmpresa.AGEN_RET_GAN));
    empresa.setAgen_ret_ib(db.getBoolean(DBEmpresa.AGEN_RET_IB));
    empresa.setArchivo_logo(db.getString(DBEmpresa.ARCHIVO_LOGO));
    empresa.setActivo(db.getBoolean(DBEmpresa.ACTIVO));
    empresa.setCodigo(db.getString(DBEmpresa.CODIGO));
    empresa.setArchXMLPoolBD(db.getString(DBEmpresa.ARCH_XML_POOL_BD));
    empresa.setInicioActividad(db.getDate(DBEmpresa.INICIO_ACTIVIDAD));
    empresa.setAgentePercIBBsAs(db.getBoolean(DBEmpresa.ES_AGE_PERC_IB_BA).booleanValue());
    empresa.setAgentePercIBCapFed(db.getBoolean(DBEmpresa.ES_AGE_PERC_IB_CF).booleanValue());
    empresa.setAgentePercIVA(db.getBoolean(DBEmpresa.ES_AGE_PERC_IVA).booleanValue());
  }
}
