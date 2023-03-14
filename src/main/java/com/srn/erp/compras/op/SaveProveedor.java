package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CertificacionProveedor;
import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.CondCompraProv;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.ContactoProveedor;
import com.srn.erp.compras.bm.OtrasDireccionesProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaGanancia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.PorcLibRetGan;
import com.srn.erp.pagos.bm.PorcLibRetIB;
import com.srn.erp.pagos.bm.PorcLibRetIVA;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProveedor extends Operation {

  public SaveProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TProveedor");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {

      dataset.first();
      while (!dataset.EOF()) {
        String cuit = dataset.getString("cuit");
        Proveedor proveedor = Proveedor.findByOid(dataset.getInteger("oid_proveedor"),getSesion());
        proveedor.setOID(dataset.getInteger("oid_proveedor"));
        proveedor.setCodigo(dataset.getString("codigo"));
        proveedor.setRazonsocial(dataset.getString("razon_social"));
        proveedor.setDireccion(dataset.getString("direccion"));
        proveedor.setLocalidad(dataset.getString("localidad"));
        proveedor.setCodigopostal(dataset.getString("codigo_postal"));
        proveedor.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        proveedor.setHabitual(dataset.getBoolean("habitual"));
        proveedor.setOrdencheque(dataset.getString("ordencheque"));
        proveedor.setEnvocmail(dataset.getBoolean("env_oc_mail"));
        proveedor.setEncoccorreo(dataset.getBoolean("env_oc_correo"));
        proveedor.setEncocfax(dataset.getBoolean("env_oc_fax"));
        proveedor.setCertprov(CertificacionProveedor.findByOidProxy(dataset.getInteger("oid_cert_prov"),getSesion()));
        proveedor.setFormaPago(FormaPago.findByOidProxy(dataset.getInteger("oid_forma_pago"),getSesion()));
        proveedor.setTipoDocumento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"),getSesion()));
        proveedor.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(dataset.getInteger("oid_suj_imp"),getSesion()));
        proveedor.setMonedaoc(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_oc"),getSesion()));
        proveedor.setTomarPrecioOC(dataset.getString("tomar_precio_oc"));
        proveedor.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),getSesion()));
        proveedor.setIdioma(Idioma.findByOidProxy(dataset.getInteger("oid_idioma"),getSesion()));
        proveedor.setDtoEnCascada(dataset.getBoolean("dto_en_cascada"));
        if (dataset.getString("fecha_inha").trim().equals(""))
          proveedor.setFechainhabilitacion(null);
        else
          proveedor.setFechainhabilitacion(dataset.getDate("fecha_inha"));
        proveedor.setViaDespacho(ViaDespacho.findByOidProxy(dataset.getInteger("oid_via_despacho"),getSesion()));
        proveedor.setCondCompraImportacion(CondCompraImportacion.findByOidProxy(dataset.getInteger("oid_cond_comp_imp"),getSesion()));
        proveedor.setPermitirCambioTomarPrecioOC(dataset.getBoolean("perm_cambiar_tp"));
        proveedor.setTomarPrecioOC1(dataset.getString("tomar_precio_oc_1"));
        proveedor.setTomarPrecioOC2(dataset.getString("tomar_precio_oc_2"));
        proveedor.setTomarPrecioOC3(dataset.getString("tomar_precio_oc_3"));
        proveedor.setTomarPrecioOC4(dataset.getString("tomar_precio_oc_4"));
        proveedor.setTomarPrecioOC5(dataset.getString("tomar_precio_oc_5"));
        proveedor.setDomicilioDevolucionMerc(dataset.getBoolean("dom_dev_merca"));
        
        proveedor.setActivo(dataset.getBoolean("activo"));
        proveedor.setPermitirRecepProdSinOC(dataset.getBoolean("inf_rec_sin_oc"));

        // Grabar los Clasificadores
        grabarValoresClasif(proveedor,dataset);
        
        
        // Grabar Otras Direcciones
        grabarOtrasDirecciones(proveedor,dataset);

        // Leer las Condiciones de Compra
        IDataSet dataSetCondCompra = dataset.getDataSet("TCondCompraProv");
        dataSetCondCompra.first();
        while (!dataSetCondCompra.EOF()) {
          CondCompraProv condCompraProv =
              CondCompraProv.findByOid(dataSetCondCompra.getInteger("oid_cond_cp_prov"),
                                       getSesion());
          condCompraProv.setProveedor(Proveedor.findByOidProxy(dataSetCondCompra.getInteger("oid_proveedor"),getSesion()));
          condCompraProv.setCondcompra(CondicionCompra.findByOidProxy(dataSetCondCompra.getInteger("oid_cond_compra"),getSesion()));
          condCompraProv.setDescuento(dataSetCondCompra.getDouble("descuento"));
          condCompraProv.setRecargo(dataSetCondCompra.getDouble("recargo"));
          condCompraProv.setPorDefecto(dataSetCondCompra.getBoolean("por_defecto"));
          condCompraProv.setActivo(dataSetCondCompra.getBoolean("activo"));
          if (!condCompraProv.isActivo().booleanValue())
              condCompraProv.delete();
          proveedor.addCondicionCompra(condCompraProv);
          dataSetCondCompra.next();
        }

        // Leer los Contactos
        IDataSet dataSetContactos = dataset.getDataSet("TContactosProveedor");
        dataSetContactos.first();
        while (!dataSetContactos.EOF()) {
          ContactoProveedor contactoProveedor =
              ContactoProveedor.findByOid(dataSetContactos.getInteger("oid_contac_prov"),
                                          getSesion());
              contactoProveedor.setApellido(dataSetContactos.getString("apellido"));
              contactoProveedor.setNombre(dataSetContactos.getString("nombre"));
              contactoProveedor.setTelefonos(dataSetContactos.getString("telefonos"));
              contactoProveedor.setFax(dataSetContactos.getString("fax"));
              contactoProveedor.setDireccion(dataSetContactos.getString("direccion"));
              contactoProveedor.setLocalidad(dataSetContactos.getString("localidad"));
              contactoProveedor.setCodigopostal(dataSetContactos.getString("codigo_postal"));
              contactoProveedor.setProvincia(Provincia.findByOidProxy(dataSetContactos.getInteger("oid_provincia"),getSesion()));
              contactoProveedor.setPais(Pais.findByOidProxy(dataSetContactos.getInteger("oid_pais"),getSesion()));
              contactoProveedor.setMail(dataSetContactos.getString("mail"));
              contactoProveedor.setEnviooc(dataSetContactos.getBoolean("envio_oc"));
              contactoProveedor.setEnviopedcotiz(dataSetContactos.getBoolean("envio_ped_cotiz"));
              contactoProveedor.setProveedor(Proveedor.findByOidProxy(dataSetContactos.getInteger("oid_proveedor"),getSesion()));
              contactoProveedor.setSector(dataSetContactos.getString("sector"));
              contactoProveedor.setCargo(dataSetContactos.getString("cargo"));
              contactoProveedor.setActivo(dataSetContactos.getBoolean("activo"));
              if (!dataSetContactos.getBoolean("activo").booleanValue())
                  contactoProveedor.delete();
              proveedor.addContacto(contactoProveedor);
              dataSetContactos.next();
        }

        // Leer la Info del Sujeto Impositivo

        IDataSet dataSetSujetoImpositivo = dataset.getDataSet("TSujetoImpositivo");
        dataSetSujetoImpositivo.first();

        if ((!dataSetSujetoImpositivo.EOF()) && (!cuit.trim().equals(""))) {
          SujetoImpositivo sujetoImpositivo =
              SujetoImpositivo.findByCodigo(cuit, getSesion());
          if (sujetoImpositivo == null) sujetoImpositivo = SujetoImpositivo.
              getNew(getSesion());
          sujetoImpositivo.setRazon(dataSetSujetoImpositivo.getString(
              "razon_social"));
          sujetoImpositivo.setCuit(cuit);
          sujetoImpositivo.setExentoretiva(dataSetSujetoImpositivo.getBoolean(
              "exento_ret_iva"));
          sujetoImpositivo.setExentoretib(dataSetSujetoImpositivo.getBoolean(
              "exento_ret_ib"));
          sujetoImpositivo.setExentoretgan(dataSetSujetoImpositivo.getBoolean(
              "exento_ret_gan"));
          sujetoImpositivo.setIngbrutos(dataSetSujetoImpositivo.getString(
              "ing_brutos"));
          sujetoImpositivo.setDnrp(dataSetSujetoImpositivo.getString("dnrp"));
          sujetoImpositivo.setCategiva(CategoriaIVA.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_iva"), getSesion()));
          sujetoImpositivo.setCategib(CategoriaIB.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_ib"), getSesion()));
          sujetoImpositivo.setCateggan(CategoriaGanancia.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_gan"), getSesion()));
          sujetoImpositivo.setActivo(new Boolean(true));
          sujetoImpositivo.setCatRetGan(CatRetGan.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_ret_gan"), getSesion()));
          sujetoImpositivo.setCatRetIB(CatRetIB.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_ret_ib"), getSesion()));
          sujetoImpositivo.setCatRetIVA(CatRetIVA.findByOidProxy(
              dataSetSujetoImpositivo.getInteger("oid_cat_ret_iva"), getSesion()));
          proveedor.setSujetoimpositivo(sujetoImpositivo);

          IDataSet dsPorcLibRetIVA = dataSetSujetoImpositivo.getDataSet("TPorcLibRetIVA");
          dsPorcLibRetIVA.first();
          while (!dsPorcLibRetIVA.EOF()) {
            PorcLibRetIVA porcLibRetIVA = PorcLibRetIVA.findByOid(dsPorcLibRetIVA.getInteger("oid_lib_ret_iva"),getSesion());
            porcLibRetIVA.setSujetoimpositivo(sujetoImpositivo);
            porcLibRetIVA.setFechadesde(dsPorcLibRetIVA.getDate("fec_desde"));
            porcLibRetIVA.setFechahasta(dsPorcLibRetIVA.getDate("fec_hasta"));
            porcLibRetIVA.setPorcentaje(dsPorcLibRetIVA.getMoney("porc"));
            porcLibRetIVA.setActivo(dsPorcLibRetIVA.getBoolean("activo"));
            porcLibRetIVA.setDecreto(dsPorcLibRetIVA.getString("decreto"));
            sujetoImpositivo.addPorcentajeLibRetIVA(porcLibRetIVA);
            dsPorcLibRetIVA.next();
          }

          IDataSet dsPorcLibRetGan = dataSetSujetoImpositivo.getDataSet("TPorcLibRetGan");
          dsPorcLibRetGan.first();
          while (!dsPorcLibRetGan.EOF()) {
            PorcLibRetGan porcLibRetGan = PorcLibRetGan.findByOid(dsPorcLibRetGan.getInteger("oid_lib_ret_gan"),getSesion());
            porcLibRetGan.setSujetoimpositivo(sujetoImpositivo);
            porcLibRetGan.setFechadesde(dsPorcLibRetGan.getDate("fec_desde"));
            porcLibRetGan.setFechahasta(dsPorcLibRetGan.getDate("fec_hasta"));
            porcLibRetGan.setPorcentaje(dsPorcLibRetGan.getMoney("porc"));
            porcLibRetGan.setActivo(dsPorcLibRetGan.getBoolean("activo"));
            porcLibRetGan.setDecreto(dsPorcLibRetGan.getString("decreto"));
            sujetoImpositivo.addPorcentajeLibRetGan(porcLibRetGan);
            dsPorcLibRetGan.next();
          }

          IDataSet dsPorcLibRetIB = dataSetSujetoImpositivo.getDataSet("TPorcLibRetIB");
          dsPorcLibRetIB.first();
          while (!dsPorcLibRetIB.EOF()) {
            PorcLibRetIB porcLibRetIB = PorcLibRetIB.findByOid(dsPorcLibRetIB.getInteger("oid_lib_ret_ib"),getSesion());
            porcLibRetIB.setSujetoimpositivo(sujetoImpositivo);
            porcLibRetIB.setFechadesde(dsPorcLibRetIB.getDate("fec_desde"));
            porcLibRetIB.setFechahasta(dsPorcLibRetIB.getDate("fec_hasta"));
            porcLibRetIB.setPorcentaje(dsPorcLibRetIB.getMoney("porc"));
            porcLibRetIB.setActivo(dsPorcLibRetIB.getBoolean("activo"));
            porcLibRetIB.setDecreto(dsPorcLibRetIB.getString("decreto"));
            sujetoImpositivo.addPorcentajeLibRetIB(porcLibRetIB);
            dsPorcLibRetIB.next();
          }

        }


        addTransaccion(proveedor);
        dataset.next();
    }
  }

  private void grabarValoresClasif(Proveedor proveedor,IDataSet dsProveedor) throws BaseException {
    IDataSet dsValClasif = dsProveedor.getDataSet("TValoresClasificadores");
    dsValClasif.first();
    while (!dsValClasif.EOF()) {
      proveedor.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
                                 dsValClasif.getInteger("oid_val_clasif_ent"));
      dsValClasif.next();
    }

  }
  
  private void grabarOtrasDirecciones(Proveedor proveedor,IDataSet dsProveedor) throws BaseException {
	    IDataSet dsUnidades = dsProveedor.getDataSet("TUnidadesEdilicias");
	    dsUnidades.first();
	    while (!dsUnidades.EOF()) {
	    	OtrasDireccionesProveedor otraDireccion =
	    		OtrasDireccionesProveedor.findByOid(dsUnidades.getInteger("oid_uni_edi"), this.getSesion());
	    	otraDireccion.setProveedor(proveedor);
	    	otraDireccion.setCodigo(dsUnidades.getString("codigo"));
	    	otraDireccion.setCalle_y_nro(dsUnidades.getString("calle_y_nro"));
	    	otraDireccion.setLocalidad(dsUnidades.getString("localidad"));
	    	otraDireccion.setCodigo_postal(dsUnidades.getString("codigo_postal"));
	    	otraDireccion.setTipo_unidad(TipoUnidadEdilicia.findByOidProxy(dsUnidades.getInteger("oid_tipo_unidad"), this.getSesion()));
	    	otraDireccion.setTelefonos(dsUnidades.getString("telefonos"));
	    	otraDireccion.setProvincia(Provincia.findByOidProxy(dsUnidades.getInteger("oid_provincia"), this.getSesion()));
	    	otraDireccion.setContacto(dsUnidades.getString("contacto"));
	    	otraDireccion.setPais(Pais.findByOidProxy(dsUnidades.getInteger("oid_pais"), this.getSesion()));
	    	otraDireccion.setActivo(dsUnidades.getBoolean("activo"));
	    	otraDireccion.setDom_dev_mercaderia(dsUnidades.getBoolean("dom_dev_mercaderia"));
	    	if (!otraDireccion.isActivo())
	    		otraDireccion.delete();
	    			    	
	      proveedor.addOtrasDirecciones(otraDireccion);
	      dsUnidades.next();
	    }

	  }
  


}
