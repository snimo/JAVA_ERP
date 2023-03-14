package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CertificacionProveedor;
import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.compras.da.DBProveedor;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProveedor extends FactoryObjetoLogico {

  public FactoryProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Proveedor proveedor = (Proveedor) objLog;
    proveedor.setOID(db.getInteger(DBProveedor.OID_PROVEEDOR));
    proveedor.setCodigo(db.getString(DBProveedor.CODIGO));
    proveedor.setRazonsocial(db.getString(DBProveedor.RAZON_SOCIAL));
    proveedor.setDireccion(db.getString(DBProveedor.DIRECCION));
    proveedor.setLocalidad(db.getString(DBProveedor.LOCALIDAD));
    proveedor.setCodigopostal(db.getString(DBProveedor.CODIGO_POSTAL));
    proveedor.setProvincia(Provincia.findByOidProxy(db.getInteger(DBProveedor.OID_PROVINCIA),getSesion()));
    proveedor.setHabitual(db.getBoolean(DBProveedor.HABITUAL));
    proveedor.setOrdencheque(db.getString(DBProveedor.ORDENCHEQUE));
    proveedor.setEnvocmail(db.getBoolean(DBProveedor.ENV_OC_MAIL));
    proveedor.setEncoccorreo(db.getBoolean(DBProveedor.ENV_OC_CORREO));
    proveedor.setEncocfax(db.getBoolean(DBProveedor.ENV_OC_FAX));
    proveedor.setCertprov(CertificacionProveedor.findByOidProxy(db.getInteger(DBProveedor.OID_CERT_PROV),getSesion()));
    proveedor.setMonedaoc(Moneda.findByOidProxy(db.getInteger(DBProveedor.OID_MONEDA_OC),getSesion()));
    proveedor.setPais(Pais.findByOidProxy(db.getInteger(DBProveedor.OID_PAIS),getSesion()));
    proveedor.setIdioma(Idioma.findByOidProxy(db.getInteger(DBProveedor.OID_IDIOMA),getSesion()));
    proveedor.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBProveedor.OID_SUJ_IMP),getSesion()));
    proveedor.setFechainhabilitacion(db.getDate(DBProveedor.FECHA_INHA));
    proveedor.setFormaPago(FormaPago.findByOidProxy(db.getInteger(DBProveedor.FORMA_PAGO),getSesion()));
    proveedor.setTipoDocumento(TipoDocumento.findByOidProxy(db.getInteger(DBProveedor.OID_TIPO_DOCU),getSesion()));
    proveedor.setActivo(db.getBoolean(DBProveedor.ACTIVO));
    proveedor.addOidValorClasif(new Integer(1),db.getInteger(DBProveedor.OID_CLASIF_01));
    proveedor.addOidValorClasif(new Integer(2),db.getInteger(DBProveedor.OID_CLASIF_02));
    proveedor.addOidValorClasif(new Integer(3),db.getInteger(DBProveedor.OID_CLASIF_03));
    proveedor.addOidValorClasif(new Integer(4),db.getInteger(DBProveedor.OID_CLASIF_04));
    proveedor.addOidValorClasif(new Integer(5),db.getInteger(DBProveedor.OID_CLASIF_05));
    proveedor.addOidValorClasif(new Integer(6),db.getInteger(DBProveedor.OID_CLASIF_06));
    proveedor.addOidValorClasif(new Integer(7),db.getInteger(DBProveedor.OID_CLASIF_07));
    proveedor.addOidValorClasif(new Integer(8),db.getInteger(DBProveedor.OID_CLASIF_08));
    proveedor.addOidValorClasif(new Integer(9),db.getInteger(DBProveedor.OID_CLASIF_09));
    proveedor.addOidValorClasif(new Integer(10),db.getInteger(DBProveedor.OID_CLASIF_10));
    proveedor.addOidValorClasif(new Integer(11),db.getInteger(DBProveedor.OID_CLASIF_11));
    proveedor.addOidValorClasif(new Integer(12),db.getInteger(DBProveedor.OID_CLASIF_12));
    proveedor.addOidValorClasif(new Integer(13),db.getInteger(DBProveedor.OID_CLASIF_13));
    proveedor.addOidValorClasif(new Integer(14),db.getInteger(DBProveedor.OID_CLASIF_14));
    proveedor.addOidValorClasif(new Integer(15),db.getInteger(DBProveedor.OID_CLASIF_15));
    proveedor.addOidValorClasif(new Integer(16),db.getInteger(DBProveedor.OID_CLASIF_16));
    proveedor.addOidValorClasif(new Integer(17),db.getInteger(DBProveedor.OID_CLASIF_17));
    proveedor.addOidValorClasif(new Integer(18),db.getInteger(DBProveedor.OID_CLASIF_18));
    proveedor.addOidValorClasif(new Integer(19),db.getInteger(DBProveedor.OID_CLASIF_19));
    proveedor.addOidValorClasif(new Integer(20),db.getInteger(DBProveedor.OID_CLASIF_20));
    proveedor.setTomarPrecioOC(db.getString(DBProveedor.TOMAR_PRECIO_OC));
    proveedor.setPermitirCambioTomarPrecioOC(db.getBoolean(DBProveedor.PERM_CAMBIAR_TP));
    proveedor.setViaDespacho(ViaDespacho.findByOidProxy(db.getInteger(DBProveedor.OID_VIA_DESPACHO),getSesion()));
    proveedor.setCondCompraImportacion(CondCompraImportacion.findByOidProxy(db.getInteger(DBProveedor.OID_COND_COMPRA_IMPO),getSesion()));
    proveedor.setDtoEnCascada(db.getBoolean(DBProveedor.DTO_EN_CASCADA));
    proveedor.setTomarPrecioOC1(db.getString(DBProveedor.TOMAR_PRECIO_OC_1));
    proveedor.setTomarPrecioOC2(db.getString(DBProveedor.TOMAR_PRECIO_OC_2));
    proveedor.setTomarPrecioOC3(db.getString(DBProveedor.TOMAR_PRECIO_OC_3));
    proveedor.setTomarPrecioOC4(db.getString(DBProveedor.TOMAR_PRECIO_OC_4));
    proveedor.setTomarPrecioOC5(db.getString(DBProveedor.TOMAR_PRECIO_OC_5));
    proveedor.setPermitirRecepProdSinOC(db.getBoolean(DBProveedor.PERMITIR_RECEP_PROD_SIN_OC));
    proveedor.setDomicilioDevolucionMerc(db.getBoolean(DBProveedor.DOM_DEV_MERC));
  }
}
