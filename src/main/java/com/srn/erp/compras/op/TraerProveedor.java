package com.srn.erp.compras.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.compras.bm.CertificacionProveedor;
import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.CondCompraProv;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.ContactoProveedor;
import com.srn.erp.compras.bm.OtrasDireccionesProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.PorcLibRetGan;
import com.srn.erp.pagos.bm.PorcLibRetIB;
import com.srn.erp.pagos.bm.PorcLibRetIVA;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProveedor extends Operation {

  public TraerProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    if (mapaDatos.containsKey("inicializarClasificadores")) {
      inicializarClasif(mapaDatos);
      return;
    }

    Proveedor proveedor = null;
    if (mapaDatos.containsKey("oid")) {
      Integer oid = mapaDatos.getInteger("oid");
      proveedor = Proveedor.findByOid(oid, getSesion());
    }
    else {
      String codigo = mapaDatos.getString("codigo");
      proveedor = Proveedor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetProveedor = getDataSetProveedor();
    IDataSet datasetCondCompra = getDataSetCondicionCompra();
    IDataSet datasetContactos = getDataSetContactos();
    IDataSet datasetSujetoImpo = getDataSetSujetoImpositivo();
    IDataSet datasetPorcLibRetIVA = getDataSetPorcLibRetIVA();
    IDataSet datasetPorcLibRetGan = getDataSetPorcLibRetGan();
    IDataSet datasetPorcLibRetIB = getDataSetPorcLibRetIB();
    IDataSet datasetValClasif = getDataSetValClasif();
    IDataSet datasetUnidades = getDataSetUnidades();

    String cuit = "";
    if (proveedor.getSujetoimpositivo() != null)
      cuit = proveedor.getSujetoimpositivo().getCuit();
    if (proveedor != null) {
      cargarRegistroProveedor(datasetProveedor,
                              proveedor.getOIDInteger(),
                              proveedor.getCodigo(),
                              proveedor.getRazonsocial(),
                              proveedor.getDireccion(),
                              proveedor.getLocalidad(),
                              proveedor.getCodigopostal(),
                              proveedor.getProvincia(),
                              proveedor.isHabitual(),
                              proveedor.getOrdencheque(),
                              proveedor.isEnvocmail(),
                              proveedor.isEncoccorreo(),
                              proveedor.isEncocfax(),
                              proveedor.getCertprov(),
                              proveedor.getMonedaoc(),
                              proveedor.getPais(),
                              proveedor.getIdioma(),
                              proveedor.getSujetoimpositivo(),
                              proveedor.getFechainhabilitacion(),
                              proveedor.getFormaPago(),
                              proveedor.isActivo(),
                              cuit,
                              proveedor.getTomarPrecioOC(),
                              proveedor.isPermitirCambioTomarPrecioOC(),
                              proveedor.getViaDespacho(),
                              proveedor.getCondCompraImpo(),
                              proveedor.isDtoEnCascada(),
                              proveedor.getTipoDocumento(),
                              proveedor.getTomarPrecioOC1(),
                              proveedor.getTomarPrecioOC2(),
                              proveedor.getTomarPrecioOC3(),
                              proveedor.getTomarPrecioOC4(),
                              proveedor.getTomarPrecioOC5(),
                              proveedor.isPermitirRecepProdSinOC(),
                              proveedor.isDomicilioDevolucionMerc()
                              );

      // Devolver valores de Clasificadores
      traerValoresDatosClasif(datasetValClasif,proveedor);
      
      // Devolver valores de Unidades
      traerUnidades(datasetUnidades,proveedor);
      

      // Traer condiciones de Compra
      Iterator iterCondCompra = proveedor.getCondicionesDeCompra().iterator();
      while (iterCondCompra.hasNext()) {
        CondCompraProv condCompraProv = (CondCompraProv) iterCondCompra.next();
        cargarRegistroCondCompra(datasetCondCompra,
                                 condCompraProv.getOIDInteger(),
                                 condCompraProv.getProveedor(),
                                 condCompraProv.getCondcompra(),
                                 condCompraProv.getDescuento(),
                                 condCompraProv.getRecargo(),
                                 condCompraProv.isPorDefecto(),
                                 new Boolean(true));
      }

      // Traer contactos del Proveedor
      Iterator iterContectos = proveedor.getContactos().iterator();
      while (iterContectos.hasNext()) {
        ContactoProveedor contactoProveedor =
            (ContactoProveedor) iterContectos.next();
        cargarRegistroContacto(datasetContactos,
                               contactoProveedor.getOIDInteger(),
                               contactoProveedor.getApellido(),
                               contactoProveedor.getNombre(),
                               contactoProveedor.getTelefonos(),
                               contactoProveedor.getFax(),
                               contactoProveedor.getDireccion(),
                               contactoProveedor.getLocalidad(),
                               contactoProveedor.getCodigopostal(),
                               contactoProveedor.getProvincia(),
                               contactoProveedor.getPais(),
                               contactoProveedor.getMail(),
                               contactoProveedor.isEnviooc(),
                               contactoProveedor.isEnviopedcotiz(),
                               contactoProveedor.getProveedor(),
                               contactoProveedor.getSector(),
                               contactoProveedor.getCargo());
      }

      // Traer los Datos del Sujeto Impositovo
      cargarRegistroSujetoImpositivo(datasetSujetoImpo,
                                     datasetPorcLibRetIVA,
                                     datasetPorcLibRetGan,
                                     datasetPorcLibRetIB,
                                     proveedor,
                                     proveedor.getSujetoimpositivo());

    }
    
    writeCliente(datasetProveedor);
    writeCliente(datasetCondCompra);
    writeCliente(datasetContactos);
    writeCliente(datasetSujetoImpo);
    writeCliente(datasetPorcLibRetIVA);
    writeCliente(datasetPorcLibRetIB);
    writeCliente(datasetPorcLibRetGan);
    writeCliente(datasetValClasif);
    writeCliente(datasetUnidades);
    
  }

  private IDataSet getDataSetProveedor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProveedor");
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 80));
    dataset.fieldDef(new Field("direccion", Field.STRING, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 50));

    dataset.fieldDef(new Field("habitual", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ordencheque", Field.STRING, 100));
    dataset.fieldDef(new Field("env_oc_mail", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("env_oc_correo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("env_oc_fax", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_cert_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cert_prov", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_cert_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_moneda_oc", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cod_moneda_oc", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_moneda_oc", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_idioma", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_idioma", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_idioma", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha_inha", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cuit", Field.STRING, 15));
    dataset.fieldDef(new Field("tomar_precio_oc",Field.STRING, 10));
    dataset.fieldDef(new Field("perm_cambiar_tp",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_via_despacho",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_comp_imp",Field.INTEGER, 0));
    dataset.fieldDef(new Field("dto_en_cascada",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_tipo_docu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tomar_precio_oc_1",Field.STRING, 10));
    dataset.fieldDef(new Field("tomar_precio_oc_2",Field.STRING, 10));
    dataset.fieldDef(new Field("tomar_precio_oc_3",Field.STRING, 10));
    dataset.fieldDef(new Field("tomar_precio_oc_4",Field.STRING, 10));
    dataset.fieldDef(new Field("tomar_precio_oc_5",Field.STRING, 10));
    dataset.fieldDef(new Field("inf_rec_sin_oc",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("dom_dev_merca",Field.BOOLEAN, 0));
    
    
    return dataset;
  }

  private void cargarRegistroProveedor(IDataSet dataset,
                                       Integer oid_proveedor,
                                       String codigo,
                                       String razon_social,
                                       String direccion,
                                       String localidad,
                                       String codigo_postal,
                                       Provincia provincia,
                                       Boolean habitual,
                                       String ordencheque,
                                       Boolean env_oc_mail,
                                       Boolean env_oc_correo,
                                       Boolean env_oc_fax,
                                       CertificacionProveedor
                                       cetificacionProveedor,
                                       Moneda monedaOC,
                                       Pais pais,
                                       Idioma idioma,
                                       SujetoImpositivo sujetoImpositivo,
                                       java.util.Date fechaInhabilitacion,
                                       FormaPago formaPago,
                                       Boolean activo,
                                       String cuit,
                                       String tomarPrecioOC,
                                       Boolean permitirCambiarTP,
                                       ViaDespacho viaDespacho,
                                       CondCompraImportacion condCompraImp,
                                       Boolean dtoEnCascada,
                                       TipoDocumento tipoDocumento,
                                       String tomarPrecioOC1,
                                       String tomarPrecioOC2,
                                       String tomarPrecioOC3,
                                       String tomarPrecioOC4,
                                       String tomarPrecioOC5,
                                       Boolean infRecSinOC,
                                       Boolean domDevMerc) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_proveedor", oid_proveedor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social", razon_social);
    dataset.fieldValue("direccion", direccion);
    dataset.fieldValue("localidad", localidad);
    dataset.fieldValue("codigo_postal", codigo_postal);

    if (provincia != null) {
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
      dataset.fieldValue("cod_provincia", provincia.getCodigo());
      dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_provincia", new Integer(0));
      dataset.fieldValue("cod_provincia", "");
      dataset.fieldValue("desc_provincia", "");
    }

    dataset.fieldValue("habitual", habitual);
    dataset.fieldValue("ordencheque", ordencheque);
    dataset.fieldValue("env_oc_mail", env_oc_mail);
    dataset.fieldValue("env_oc_correo", env_oc_correo);
    dataset.fieldValue("env_oc_fax", env_oc_fax);

    if (cetificacionProveedor != null) {
      dataset.fieldValue("oid_cert_prov", cetificacionProveedor.getOIDInteger());
      dataset.fieldValue("cod_cert_prov", cetificacionProveedor.getCodigo());
      dataset.fieldValue("desc_cert_prov", cetificacionProveedor.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_cert_prov", new Integer(0));
      dataset.fieldValue("cod_cert_prov", "");
      dataset.fieldValue("desc_cert_prov", "");
    }

    if (monedaOC != null) {
      dataset.fieldValue("oid_moneda_oc", monedaOC.getOIDInteger());
      dataset.fieldValue("cod_moneda_oc", monedaOC.getCodigo());
      dataset.fieldValue("desc_moneda_oc", monedaOC.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_moneda_oc", new Integer(0));
      dataset.fieldValue("cod_moneda_oc", "");
      dataset.fieldValue("desc_moneda_oc", "");
    }

    if (pais != null) {
      dataset.fieldValue("oid_pais", pais.getOIDInteger());
      dataset.fieldValue("cod_pais", pais.getCodigo());
      dataset.fieldValue("desc_pais", pais.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_pais", new Integer(0));
      dataset.fieldValue("cod_pais", "");
      dataset.fieldValue("desc_pais", "");
    }

    if (idioma != null) {
      dataset.fieldValue("oid_idioma", idioma.getOIDInteger());
      dataset.fieldValue("cod_idioma", idioma.getCodigo());
      dataset.fieldValue("desc_idioma", idioma.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_idioma", new Integer(0));
      dataset.fieldValue("cod_idioma", "");
      dataset.fieldValue("desc_idioma", "");
    }
    if (sujetoImpositivo != null)
      dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
    else
      dataset.fieldValue("oid_suj_imp", new Integer(0));
    if (fechaInhabilitacion != null)
      dataset.fieldValue("fecha_inha", Fecha.getddmmyyyy(fechaInhabilitacion));
    else
      dataset.fieldValue("fecha_inha", "");

    if (formaPago != null)
      dataset.fieldValue("oid_forma_pago", formaPago.getOID());
    else
      dataset.fieldValue("oid_forma_pago", 0);

    dataset.fieldValue("activo", activo);
    dataset.fieldValue("cuit", cuit);
    dataset.fieldValue("tomar_precio_oc", tomarPrecioOC);
    dataset.fieldValue("perm_cambiar_tp", permitirCambiarTP);
    if (viaDespacho!= null)
    	dataset.fieldValue("oid_via_despacho",viaDespacho.getOIDInteger());
    else
    	dataset.fieldValue("oid_via_despacho",0);
    
    if (condCompraImp!=null)
    	dataset.fieldValue("oid_cond_comp_imp",condCompraImp.getOIDInteger());
    else
    	dataset.fieldValue("oid_cond_comp_imp",0);
    
    if (dtoEnCascada!=null)
    	dataset.fieldValue("dto_en_cascada",dtoEnCascada);
    else
    	dataset.fieldValue("dto_en_cascada", new Boolean(false));
    
    if (tipoDocumento!=null)
    	dataset.fieldValue("oid_tipo_docu",tipoDocumento.getOID());
    else
    	dataset.fieldValue("oid_tipo_docu", 0);
    
    dataset.fieldValue("tomar_precio_oc_1", tomarPrecioOC1);
    dataset.fieldValue("tomar_precio_oc_2", tomarPrecioOC2);
    dataset.fieldValue("tomar_precio_oc_3", tomarPrecioOC3);
    dataset.fieldValue("tomar_precio_oc_4", tomarPrecioOC4);
    dataset.fieldValue("tomar_precio_oc_5", tomarPrecioOC5);
    
    dataset.fieldValue("inf_rec_sin_oc", infRecSinOC);
    dataset.fieldValue("dom_dev_merca", domDevMerc);
    
  }

  private void cargarRegistroCondCompra(IDataSet dataset,
                                        Integer oidCondCPProv,
                                        Proveedor proveedor,
                                        CondicionCompra condicionCompra,
                                        Double porcDescuento,
                                        Double porcRecargo,
                                        Boolean porDefecto,
                                        Boolean activo) throws BaseException {

    dataset.append();
    dataset.fieldValue("oid_cond_cp_prov", oidCondCPProv);
    dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
    dataset.fieldValue("oid_cond_compra", condicionCompra.getOIDInteger());
    dataset.fieldValue("descuento", porcDescuento);
    dataset.fieldValue("recargo", porcRecargo);
    dataset.fieldValue("por_defecto", porDefecto);
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetCondicionCompra() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondCompraProv");
    dataset.fieldDef(new Field("oid_cond_cp_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("recargo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("por_defecto", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetContactos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TContactosProveedor");
    dataset.fieldDef(new Field("oid_contac_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("apellido", Field.STRING, 25));
    dataset.fieldDef(new Field("nombre", Field.STRING, 25));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 25));
    dataset.fieldDef(new Field("fax", Field.STRING, 25));
    dataset.fieldDef(new Field("direccion", Field.STRING, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("mail", Field.INTEGER, 50));
    dataset.fieldDef(new Field("envio_oc", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("envio_ped_cotiz", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("sector", Field.STRING, 30));
    dataset.fieldDef(new Field("cargo", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroContacto(IDataSet dataset,
                                      Integer oidContacProv,
                                      String apellido,
                                      String nombre,
                                      String telefonos,
                                      String fax,
                                      String direccion,
                                      String localidad,
                                      String codigoPostal,
                                      Provincia provincia,
                                      Pais pais,
                                      String mail,
                                      Boolean envioOC,
                                      Boolean envioPedCotiz,
                                      Proveedor proveedor,
                                      String sector,
                                      String cargo) throws BaseException {

    dataset.append();
    dataset.fieldValue("oid_contac_prov", oidContacProv);
    dataset.fieldValue("apellido", apellido);
    dataset.fieldValue("nombre", nombre);
    dataset.fieldValue("telefonos", telefonos);
    dataset.fieldValue("fax", fax);
    dataset.fieldValue("direccion", direccion);
    dataset.fieldValue("localidad", localidad);
    dataset.fieldValue("codigo_postal", codigoPostal);
    if (provincia == null)
      dataset.fieldValue("oid_provincia", 0);
    else
      dataset.fieldValue("oid_provincia", provincia.getOID());
    if (pais == null)
      dataset.fieldValue("oid_pais", 0);
    else
      dataset.fieldValue("oid_pais", pais.getOID());
    dataset.fieldValue("mail", mail);
    dataset.fieldValue("envio_oc", envioOC);
    dataset.fieldValue("envio_ped_cotiz", envioPedCotiz);
    dataset.fieldValue("oid_proveedor", proveedor.getOID());
    dataset.fieldValue("sector", sector);
    dataset.fieldValue("cargo", cargo);
    dataset.fieldValue("activo", new Boolean(true));
  }

  private void cargarRegistroSujetoImpositivo(IDataSet dataset,
                                              IDataSet datasetPorcLibRetIVA,
                                              IDataSet datasetPorcLibRetGan,
                                              IDataSet datasetPorcLibRetIB,
                                              Proveedor proveedor,
                                              SujetoImpositivo sujetoImpositivo) throws
      BaseException {
    dataset.append();

    if (sujetoImpositivo == null) {
      dataset.fieldValue("oid_suj_imp", 0);
      dataset.fieldValue("razon_social", "");
      dataset.fieldValue("cuit", "");
      dataset.fieldValue("exento_ret_iva", new Boolean(false));
      dataset.fieldValue("exento_ret_gan", new Boolean(false));
      dataset.fieldValue("exento_ret_ib", new Boolean(false));
      dataset.fieldValue("ing_brutos", "");
      dataset.fieldValue("dnrp", "");
      dataset.fieldValue("oid_cat_iva", 0);
      dataset.fieldValue("oid_cat_gan", 0);
      dataset.fieldValue("oid_cat_ib", 0);
      dataset.fieldValue("oid_cat_ret_iva", 0);
      dataset.fieldValue("oid_cat_ret_gan", 0);
      dataset.fieldValue("oid_cat_ret_ib", 0);
      dataset.fieldValue("oid_proveedor", proveedor.getOID());
      dataset.fieldValue("activo", new Boolean(true));
    }
    else {
      dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
      dataset.fieldValue("razon_social", sujetoImpositivo.getRazon());
      dataset.fieldValue("cuit", sujetoImpositivo.getCuit());
      dataset.fieldValue("exento_ret_iva", sujetoImpositivo.isExentoretiva());
      dataset.fieldValue("exento_ret_gan", sujetoImpositivo.isExentoretgan());
      dataset.fieldValue("exento_ret_ib", sujetoImpositivo.isExentoretib());
      dataset.fieldValue("ing_brutos", sujetoImpositivo.getIngbrutos());
      dataset.fieldValue("dnrp", sujetoImpositivo.getDnrp());
      if (sujetoImpositivo.getCategiva() == null)
        dataset.fieldValue("oid_cat_iva", 0);
      else
        dataset.fieldValue("oid_cat_iva", sujetoImpositivo.getCategiva().getOID());
      if (sujetoImpositivo.getCateggan() == null)
        dataset.fieldValue("oid_cat_gan", 0);
      else
        dataset.fieldValue("oid_cat_gan", sujetoImpositivo.getCateggan().getOID());
      if (sujetoImpositivo.getCategib() == null)
        dataset.fieldValue("oid_cat_ib", 0);
      else
        dataset.fieldValue("oid_cat_ib", sujetoImpositivo.getCategib().getOID());

      if (sujetoImpositivo.getCatRetIVA() == null)
        dataset.fieldValue("oid_cat_ret_iva", 0);
      else
        dataset.fieldValue("oid_cat_ret_iva",
                           sujetoImpositivo.getCatRetIVA().getOID());

      if (sujetoImpositivo.getCatRetGan() == null)
        dataset.fieldValue("oid_cat_ret_gan", 0);
      else
        dataset.fieldValue("oid_cat_ret_gan",
                           sujetoImpositivo.getCatRetGan().getOID());

      if (sujetoImpositivo.getCatRetIB() == null)
        dataset.fieldValue("oid_cat_ret_ib", 0);
      else
        dataset.fieldValue("oid_cat_ret_ib",
                           sujetoImpositivo.getCatRetIB().getOID());

      dataset.fieldValue("oid_proveedor", proveedor.getOID());
      dataset.fieldValue("activo", sujetoImpositivo.isActivo());

      Iterator iterPorcLibRetIVA = sujetoImpositivo.getPorcentajesLibRetIVA().iterator();
      while (iterPorcLibRetIVA.hasNext()) {
        PorcLibRetIVA porcLibRetIVA = (PorcLibRetIVA) iterPorcLibRetIVA.next();
        cargarRegistroPorcLibRetIVA(
                  datasetPorcLibRetIVA,
                  porcLibRetIVA.getOIDInteger(),
                  sujetoImpositivo,
                  porcLibRetIVA.getFechadesde(),
                  porcLibRetIVA.getFechahasta(),
                  porcLibRetIVA.getPorcentaje(),
                  porcLibRetIVA.isActivo(),
                  porcLibRetIVA.getDecreto());
      }

      Iterator iterPorcLibRetGan = sujetoImpositivo.getPorcentajesLibRetGan().iterator();
      while (iterPorcLibRetGan.hasNext()) {
        PorcLibRetGan porcLibRetGan = (PorcLibRetGan) iterPorcLibRetGan.next();
        cargarRegistroPorcLibRetGan(
                  datasetPorcLibRetGan,
                  porcLibRetGan.getOIDInteger(),
                  sujetoImpositivo,
                  porcLibRetGan.getFechadesde(),
                  porcLibRetGan.getFechahasta(),
                  porcLibRetGan.getPorcentaje(),
                  porcLibRetGan.isActivo(),
                  porcLibRetGan.getDecreto());
      }

      Iterator iterPorcLibRetIB = sujetoImpositivo.getPorcentajesLibRetIB().iterator();
      while (iterPorcLibRetIB.hasNext()) {
        PorcLibRetIB porcLibRetIB = (PorcLibRetIB) iterPorcLibRetIB.next();
        cargarRegistroPorcLibRetIB(
                  datasetPorcLibRetIB,
                  porcLibRetIB.getOIDInteger(),
                  sujetoImpositivo,
                  porcLibRetIB.getFechadesde(),
                  porcLibRetIB.getFechahasta(),
                  porcLibRetIB.getPorcentaje(),
                  porcLibRetIB.isActivo(),
                  porcLibRetIB.getDecreto());
      }





    }
  }

  private IDataSet getDataSetSujetoImpositivo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSujetoImpositivo");
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    dataset.fieldDef(new Field("cuit", Field.STRING, 20));
    dataset.fieldDef(new Field("exento_ret_iva", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("exento_ret_gan", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("exento_ret_ib", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ing_brutos", Field.STRING, 20));
    dataset.fieldDef(new Field("dnrp", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));

    return dataset;
  }

  private IDataSet getDataSetPorcLibRetIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPorcLibRetIVA");
    dataset.fieldDef(new Field("oid_lib_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("decreto", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroPorcLibRetIVA(IDataSet dataset,
                                           Integer oid,
                                           SujetoImpositivo sujetoImpositivo,
                                           Date fechaDesde,
                                           Date fechaHasta,
                                           Money porc,
                                           Boolean activo,
                                           String decreto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lib_ret_iva", oid);
    dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fechaDesde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fechaHasta));
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("decreto", decreto);
  }

  private IDataSet getDataSetPorcLibRetGan() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPorcLibRetGan");
    dataset.fieldDef(new Field("oid_lib_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("decreto", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroPorcLibRetGan(IDataSet dataset,
                                           Integer oid,
                                           SujetoImpositivo sujetoImpositivo,
                                           Date fechaDesde,
                                           Date fechaHasta,
                                           Money porc,
                                           Boolean activo,
                                           String decreto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lib_ret_gan", oid);
    dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fechaDesde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fechaHasta));
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("decreto", decreto);
  }

  private IDataSet getDataSetPorcLibRetIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPorcLibRetIB");
    dataset.fieldDef(new Field("oid_lib_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("decreto", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroPorcLibRetIB(IDataSet dataset,
                                           Integer oid,
                                           SujetoImpositivo sujetoImpositivo,
                                           Date fechaDesde,
                                           Date fechaHasta,
                                           Money porc,
                                           Boolean activo,
                                           String decreto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lib_ret_ib", oid);
    dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fechaDesde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fechaHasta));
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("decreto", decreto);
  }

  private IDataSet getDataSetValClasif() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresClasificadores");
    dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
    dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
    dataset.fieldDef(new Field("nickname", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));

    return dataset;
  }

  private void cargarDSValClasif(IDataSet dataset,
                                 Integer oidValorClasif,
                                 Integer oidProveedor,
                                 Integer oidClasifEnt,
                                 Integer oidValClasifEnt,
                                 Integer nroClasif,
                                 String descGrupoClasif,
                                 String codValor,
                                 String descValor,
                                 String nickname,
                                 Boolean activo,
                                 String descClasificador) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_valor_clasif", oidValorClasif);
    dataset.fieldValue("oid_proveedor", oidProveedor);
    dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
    dataset.fieldValue("oid_val_clasif_ent", oidValClasifEnt);
    dataset.fieldValue("nro_clasif", nroClasif);
    dataset.fieldValue("desc_grupo_clasif", descGrupoClasif);
    dataset.fieldValue("cod_valor", codValor);
    dataset.fieldValue("desc_valor", descValor);
    dataset.fieldValue("nickname", nickname);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("desc_clasificador", descClasificador);
  }
  
  private void traerUnidades(IDataSet ds,Proveedor aProveedor) throws BaseException {
	    Iterator iterOtrasDirecciones = aProveedor.getOtrasDirecciones().iterator();
	    while (iterOtrasDirecciones.hasNext()) {
	      OtrasDireccionesProveedor otrasDirecciones =
	          (OtrasDireccionesProveedor) iterOtrasDirecciones.next();
	      cargarRegistroOtrasDirecciones(otrasDirecciones,ds);
	    }
  }
  
  private void traerValoresDatosClasif(IDataSet ds,Proveedor aProveedor) throws BaseException {
    int oid = 0;
    Iterator iterClasifEnt = aProveedor.getClasificadoresEntidad().iterator();
    while (iterClasifEnt.hasNext()) {
      ClasificadorEntidad clasifEnt =
          (ClasificadorEntidad) iterClasifEnt.next();
      ValorClasificadorEntidad valClasifEntidad =
          aProveedor.getValorClasifEnt(clasifEnt);
      if (valClasifEntidad!=null)
        cargarDSValClasif(ds,new Integer(++oid),aProveedor.getOIDInteger(),
                       clasifEnt.getOIDInteger(),valClasifEntidad.getOIDInteger(),
                       clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
                       valClasifEntidad.getCodigo(),valClasifEntidad.getDescripcion(),
                       clasifEnt.getNickname(),
                       new Boolean(true),
                       clasifEnt.getDescripcion());
     else
       cargarDSValClasif(ds,new Integer(++oid),aProveedor.getOIDInteger(),
                      clasifEnt.getOIDInteger(),new Integer(-1),
                      clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
                      "","",
                      clasifEnt.getNickname(),
                      new Boolean(true),
                      clasifEnt.getDescripcion());
    }

  }
  
  private IDataSet getDataSetUnidades() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TUnidadesEdilicias");
	    dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
	    dataset.fieldDef(new Field("localidad", Field.STRING, 50));
	    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
	    dataset.fieldDef(new Field("oid_tipo_unidad", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("telefonos", Field.STRING, 30));
	    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("contacto", Field.STRING, 50));
	    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("dom_dev_mercaderia", Field.BOOLEAN, 0));
	    return dataset;
	  }
  
  private void cargarRegistroOtrasDirecciones(OtrasDireccionesProveedor otrasDirecciones, IDataSet dataset) throws BaseException {
	  
	    dataset.append();
	    dataset.fieldValue("oid_uni_edi", otrasDirecciones.getOIDInteger());
	    dataset.fieldValue("codigo", otrasDirecciones.getCodigo());
	    dataset.fieldValue("calle_y_nro", otrasDirecciones.getCalle_y_nro());
	    dataset.fieldValue("localidad", otrasDirecciones.getLocalidad());
	    dataset.fieldValue("codigo_postal", otrasDirecciones.getCodigo_postal());
	    if (otrasDirecciones.getTipo_unidad()!=null)
	    	dataset.fieldValue("oid_tipo_unidad", otrasDirecciones.getTipo_unidad().getOIDInteger());
	    else
	    	dataset.fieldValue("oid_tipo_unidad", new Integer(0));
	    dataset.fieldValue("telefonos", otrasDirecciones.getTelefonos());
	    if (otrasDirecciones.getProvincia()!=null)
	    	dataset.fieldValue("oid_provincia", otrasDirecciones.getProvincia().getOIDInteger());
	    else
	    	dataset.fieldValue("oid_provincia", "");
	    dataset.fieldValue("contacto", otrasDirecciones.getContacto());
	    if (otrasDirecciones.getPais()!=null)
	    	dataset.fieldValue("oid_pais", otrasDirecciones.getPais().getOIDInteger());
	    else
	    	dataset.fieldValue("oid_pais", "");
	    dataset.fieldValue("activo", otrasDirecciones.isActivo());
	    dataset.fieldValue("oid_proveedor", otrasDirecciones.getProveedor().getOIDInteger());
	    dataset.fieldValue("dom_dev_mercaderia", otrasDirecciones.isDom_dev_mercaderia());
	  
	  
}


  

  private IDataSet getDataSetClasificadorEntidad() {
    IDataSet dataset = new TDataSet();
    dataset.create("TClasificadorEntidad");
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nickname", Field.STRING, 30));
    dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroClasificadorEntidad(IDataSet dataset,
                                                 ClasificadorEntidad clasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
    dataset.fieldValue("codigo", clasifEnt.getCodigo());
    dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
    dataset.fieldValue("nickname", clasifEnt.getNickname());
    dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
    dataset.fieldValue("activo", clasifEnt.isActivo());
    dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
    dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
    dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
    dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

  }

  private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
    IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
    Iterator iterClasifEnt = Proveedor.getClasificadoresEntidad(getSesion()).iterator();
    while (iterClasifEnt.hasNext()) {
      ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
      cargarRegistroClasificadorEntidad(dsClasifEnt,clasifEnt);
    }
    writeCliente(dsClasifEnt);
  }



}
