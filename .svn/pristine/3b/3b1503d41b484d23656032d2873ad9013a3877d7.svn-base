package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaGanancia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.LiberacionImpuestoSujeto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.ventas.bm.BonifRecarSujeto;
import com.srn.erp.ventas.bm.Canal;
import com.srn.erp.ventas.bm.ClasifSujeto;
import com.srn.erp.ventas.bm.Cobrador;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionVigSuj;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.EstadoSituacion;
import com.srn.erp.ventas.bm.ListaPrecioSujeto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Rubro;
import com.srn.erp.ventas.bm.SectorDireccion;
import com.srn.erp.ventas.bm.SubModalidadPago;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSujeto extends Operation {

  public SaveSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TSujeto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Sujeto sujeto = Sujeto.findByOid(dataset.getInteger("oid_sujeto"),
                                         getSesion());
        
        sujeto.setTipoImpresionFact(dataset.getString("tipo_impresion_fact"));
        sujeto.setOID(dataset.getInteger("oid_sujeto"));
        sujeto.setCodigo(dataset.getString("codigo"));
        sujeto.setRazon_social(dataset.getString("razon_social"));
        sujeto.setTipo_documento(TipoDocumento.findByOidProxy(dataset.getInteger(
            "oid_tipo_documento"), getSesion()));
        sujeto.setNro_documento(dataset.getString("nro_documento"));
        sujeto.setSexo(dataset.getString("sexo"));
        sujeto.setFecha_nacimiento(dataset.getDate("fec_nac"));
        sujeto.setFecha_ingreso(dataset.getDate("fec_ingreso"));
        sujeto.setE_mail(dataset.getString("e_mail"));
        sujeto.setNacionalidad(dataset.getString("nacionalidad"));
        sujeto.setTelefonos(dataset.getString("telefonos"));
        sujeto.setSujeto_impositivo(SujetoImpositivo.findByOidProxy(dataset.
            getInteger("oid_suj_imp"), getSesion()));
        sujeto.setFax(dataset.getString("fax"));
        sujeto.setSector_empresa(dataset.getString("sector"));
        sujeto.setCargo(dataset.getString("cargo"));
        sujeto.setVendedor_tecnico(Vendedor.findByOidProxy(dataset.getInteger(
            "oid_vend_tec"), getSesion()));
        sujeto.setVendedor_comercial(Vendedor.findByOidProxy(dataset.getInteger(
            "oid_vend_com"), getSesion()));
        sujeto.setWeb(dataset.getString("direccion_web"));
        sujeto.setEstado_situacion(EstadoSituacion.findByOidProxy(dataset.
            getInteger("oid_est_situacion"), getSesion()));
        sujeto.setZonadireccion(com.srn.erp.general.bm.Zona.findByOidProxy(
            dataset.getInteger("oid_zona"), getSesion()));
        sujeto.setFec_est_situ_desde(dataset.getDate("fec_est_desde"));
        sujeto.setFec_est_situ_hasta(dataset.getDate("fec_est_hasta"));
        sujeto.setFisica_juridica(dataset.getString("fisica_juridica"));
        sujeto.setProfesion(dataset.getString("profesion"));
        sujeto.setEs_cliente(dataset.getBoolean("es_cliente"));
        sujeto.setEs_socio(dataset.getBoolean("es_socio"));
        sujeto.setDireccion_web(dataset.getString("direccion_web"));
        sujeto.setCobrador(Cobrador.findByOidProxy(dataset.getInteger(
            "oid_cobrador"), getSesion()));
        sujeto.setRubro(Rubro.findByOidProxy(dataset.getInteger("oid_rubro"),
                                             getSesion()));
        sujeto.setEstado_civil(EstadoCivil.findByOidProxy(dataset.getInteger(
            "oid_estado_civil"), getSesion()));
        sujeto.setContacto(dataset.getString("contacto"));
        sujeto.setCalle_y_nro(dataset.getString("calle_y_nro"));
        sujeto.setSector_domilicio(SectorDireccion.findByOidProxy(dataset.
            getInteger("oid_sector_dir"), getSesion()));
        sujeto.setLocalidad(dataset.getString("localidad"));
        sujeto.setCodigo_postal(dataset.getString("codigo_postal"));
        sujeto.setProvincia(Provincia.findByOidProxy(dataset.getInteger(
            "oid_provincia"), getSesion()));
        sujeto.setTransporte(Transporte.findByOidProxy(dataset.getInteger(
        "oid_transporte"), getSesion()));        
        sujeto.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),
                                           getSesion()));
        sujeto.setIdioma(Idioma.findByOidProxy(dataset.getInteger("oid_idioma"),
            getSesion()));        
        sujeto.setDomicilio_entrega(dataset.getBoolean("dom_entrega"));
        sujeto.setZona_venta(com.srn.erp.ventas.bm.Zona.findByOidProxy(dataset.
            getInteger("oid_zona_vta"), getSesion()));
        sujeto.setCanal(Canal.findByOidProxy(dataset.getInteger("oid_canal"),
                                             getSesion()));
        sujeto.setCondicionPago(CondicionPago.findByOidProxy(dataset.getInteger(
            "oid_cond_pago"), getSesion()));
        sujeto.setClasificacionsujeto(ClasifSujeto.findByOidProxy(dataset.
            getInteger("oid_clasif_sujeto"), getSesion()));
        sujeto.setEs_prospecto(dataset.getBoolean("es_prospecto"));
        sujeto.setEs_contacto(dataset.getBoolean("es_contacto"));
        sujeto.setHabilitarLimiteCredito(dataset.getBoolean("hab_lim_cre"));
        sujeto.setMontoLimiteCredito(dataset.getMoney("monto_lim_cre"));
        sujeto.setMonedaLimiteCredito(Moneda.findByOidProxy(dataset.getInteger("oid_mon_lim_cre"),
            getSesion()));
        sujeto.setEsSusceptiblePercIVA(dataset.getBoolean("es_sus_perc_iva").booleanValue());
        
        Integer oidEntidad = dataset.getInteger("oid_entidad");
        if (oidEntidad != null) {
          String subModPago = dataset.getString("sub_moda_pago");
          if (subModPago != null) {
            if (subModPago.equals(SubModalidadPago.CUENTA))
              sujeto.setCuenta_bancaria(CuentaBancaria.findByOidProxy(oidEntidad,
                  getSesion()));
            else
            if (subModPago.equals(SubModalidadPago.TARJETA))
              sujeto.setTarjeta_credito(TarjetaCredito.findByOidProxy(oidEntidad,
                  getSesion()));
          }
        }

        sujeto.setBonifEnCascada(dataset.getBoolean("bonif_en_cascada"));
        sujeto.setNro_medio_pago(dataset.getString("nro_medio_pago"));
        sujeto.setResponsable_ctacte(dataset.getInteger("oid_suj_resp_cc"));
        sujeto.setModalidad_pago(dataset.getString("moda_pago"));
        sujeto.setPermite_otras_modalidades_pago(dataset.getBoolean(
            "permite_otras_mp"));
        sujeto.setSub_modalidad_pago(dataset.getString("sub_moda_pago"));
        sujeto.setMonedaCotizacion(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_cotiz"),getSesion()));
        sujeto.setMonedaPedido(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_pedido"),getSesion()));
        sujeto.setMonedaFactura(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_factura"),getSesion()));
        sujeto.setSusceptiblePercIBBsAs(dataset.getBoolean("es_sus_perc_ib_ba").booleanValue());
        sujeto.setSusceptiblePercIBCapFed(dataset.getBoolean("es_sus_perc_ib_cf").booleanValue());
        sujeto.setActivo(dataset.getBoolean("activo"));
        sujeto.setIsDomicilioCobranza(dataset.getBoolean("dom_cobranza"));
        sujeto.setPasarACobrar(dataset.getString("pasar_a_cobrar"));
        sujeto.setReclamarPagos(dataset.getString("reclamar_pagos"));

        grabrarOtrosDomicilios(sujeto, dataset);
        grabarSujetoImpositivo(dataset.getInteger("oid_suj_imp"),dataset.getString("cuit"),sujeto,dataset);
        grabrarContactos(sujeto,dataset);
        grabrarBonifRecar(sujeto,dataset);
        grabrarListaDePrecios(sujeto,dataset);
        grabarValoresClasif(sujeto,dataset);
        grabarEsqBonifVigSuj(sujeto,dataset);
        grabarLiberacionImpu(sujeto,dataset);

        addTransaccion(sujeto);
        dataset.next();
    }
  }

  private void grabarSujetoImpositivo(Integer oidSujImp,String cuit,Sujeto sujeto,IDataSet dsSujeto) throws BaseException {

    IDataSet dsSujetoImpositivo = dsSujeto.getDataSet("TSujetoImpositivo");
    dsSujetoImpositivo.first();

    if ((!dsSujetoImpositivo.EOF()) ) {
    	
    	SujetoImpositivo sujetoImpositivo = null;
    	if ((oidSujImp!=null) && (oidSujImp.intValue()>0))
        sujetoImpositivo =
          SujetoImpositivo.findByOid(oidSujImp, getSesion());
    	else {	
    		if ((cuit!=null) && (!cuit.trim().equals("")))
    			sujetoImpositivo = SujetoImpositivo.findByCodigo(cuit, getSesion());
    	}
    	
      if (sujetoImpositivo == null) 
      	sujetoImpositivo = SujetoImpositivo.getNew(getSesion());
      
      sujetoImpositivo.setRazon(dsSujetoImpositivo.getString(
          "razon_social"));
      sujetoImpositivo.setCuit(cuit);
      sujetoImpositivo.setIngbrutos(dsSujetoImpositivo.getString(
          "ing_brutos"));
      sujetoImpositivo.setDnrp(dsSujetoImpositivo.getString("dnrp"));
      sujetoImpositivo.setCategiva(CategoriaIVA.findByOidProxy(
          dsSujetoImpositivo.getInteger("oid_cat_iva"), getSesion()));
      sujetoImpositivo.setCategib(CategoriaIB.findByOidProxy(
          dsSujetoImpositivo.getInteger("oid_cat_ib"), getSesion()));
      sujetoImpositivo.setCateggan(CategoriaGanancia.findByOidProxy(
          dsSujetoImpositivo.getInteger("oid_cat_gan"), getSesion()));
      sujetoImpositivo.setActivo(new Boolean(true));
      sujeto.setSujeto_impositivo(sujetoImpositivo);
    }

  }
  
  private void grabarLiberacionImpu(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
  	IDataSet ds = dsSujeto.getDataSet("TLiberacionImpuestos");
  	ds.first();
  	while (!ds.EOF()) {
  		LiberacionImpuestoSujeto libImpuSuj = 
  			LiberacionImpuestoSujeto.findByOid(ds.getInteger("oid_lib_impu"),getSesion());
  		libImpuSuj.setSujeto(Sujeto.findByOidProxy(ds.getInteger("oid_sujeto"),getSesion()));
  		libImpuSuj.setFec_vig_desde(ds.getDate("fec_vig_desde"));
  		libImpuSuj.setFec_vig_hasta(ds.getDate("fec_vig_hasta"));
  		libImpuSuj.setPorc_lib(ds.getPorcentaje("porc_lib"));
  		libImpuSuj.setNuevo_porc(ds.getPorcentaje("nuevo_porc"));
  		libImpuSuj.setTipo_impuesto(ds.getString("tipo_impuesto"));
  		libImpuSuj.setActivo(ds.getBoolean("activo"));
  		
  		if (ds.getBoolean("activo").booleanValue()==false)
  			libImpuSuj.delete();
  		
  		sujeto.addLiberacionImpuesto(libImpuSuj);
  		
  		ds.next();
  	}
  }

  private void grabrarOtrosDomicilios(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsUniEdi = dsSujeto.getDataSet("TUnidadesEdilicias");
    dsUniEdi.first();
    while (!dsUniEdi.EOF()) {
      UnidadEdilicia unidadEdilicia = UnidadEdilicia.findByOid(dsUniEdi.getInteger("oid_uni_edi"),getSesion());
      unidadEdilicia.setCodigo(dsUniEdi.getString("codigo"));
      unidadEdilicia.setDescripcion(dsUniEdi.getString("descripcion"));
      unidadEdilicia.setCalle_y_mro(dsUniEdi.getString("calle_y_nro"));
      unidadEdilicia.setLocalidad(dsUniEdi.getString("localidad"));
      unidadEdilicia.setCodigo_postal(dsUniEdi.getString("codigo_postal"));
      unidadEdilicia.setTipo_unidad(TipoUnidadEdilicia.findByOidProxy(dsUniEdi.getInteger("oid_tipo_unidad"),getSesion()));
      unidadEdilicia.setTelefonos(dsUniEdi.getString("telefonos"));
      unidadEdilicia.setProvincia(Provincia.findByOidProxy(dsUniEdi.getInteger("oid_provincia"),getSesion()));
      unidadEdilicia.setDom_ent(dsUniEdi.getBoolean("dom_ent"));
      unidadEdilicia.setContacto(dsUniEdi.getString("contacto"));
      unidadEdilicia.setPais(Pais.findByOidProxy(dsUniEdi.getInteger("oid_pais"),getSesion()));
      unidadEdilicia.setZona(com.srn.erp.ventas.bm.Zona.findByOidProxy(dsUniEdi.getInteger("oid_zona"),getSesion()));
      unidadEdilicia.setActivo(dsUniEdi.getBoolean("activo"));
      unidadEdilicia.setSujeto_alta(Sujeto.findByOidProxy(dsUniEdi.getInteger("oid_sujeto_alta"),getSesion()));
      unidadEdilicia.setIsDomicilioCobranza(dsUniEdi.getBoolean("dom_cobranza"));

      sujeto.addUnidadEdilicia(unidadEdilicia);
      dsUniEdi.next();
    }

  }

  private void grabrarContactos(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsContactos = dsSujeto.getDataSet("TContactos");
    dsContactos.first();
    while (!dsContactos.EOF()) {
      ContactoSujeto contactoSujeto = ContactoSujeto.findByOid(dsContactos.getInteger("oid_contac_suj"),getSesion());
      contactoSujeto.setDescripcion(dsContactos.getString("descripcion"));
      contactoSujeto.setProvincia(Provincia.findByOidProxy(dsContactos.getInteger("oid_provincia"),getSesion()));
      contactoSujeto.setPais(Pais.findByOidProxy(dsContactos.getInteger("oid_pais"),getSesion()));
      contactoSujeto.setApellido(dsContactos.getString("apellido"));
      contactoSujeto.setNombre(dsContactos.getString("nombre"));
      contactoSujeto.setTelefonos(dsContactos.getString("telefonos"));
      contactoSujeto.setFax(dsContactos.getString("fax"));
      contactoSujeto.setDireccion(dsContactos.getString("direccion"));
      contactoSujeto.setLocalidad(dsContactos.getString("localidad"));
      contactoSujeto.setCodigo_postal(dsContactos.getString("codigo_postal"));
      contactoSujeto.setMail(dsContactos.getString("mail"));
      contactoSujeto.setSector(dsContactos.getString("sector"));
      contactoSujeto.setCargo(dsContactos.getString("cargo"));
      contactoSujeto.setSujeto(Sujeto.findByOidProxy(dsContactos.getInteger("oid_sujeto"),getSesion()));
      contactoSujeto.setActivo(dsContactos.getBoolean("activo"));
      contactoSujeto.setReclamarPago(dsContactos.getBoolean("reclamar_pago"));
      contactoSujeto.setPasarACobrar(dsContactos.getBoolean("pasar_a_cobrar"));

      sujeto.addContacto(contactoSujeto);
      dsContactos.next();
    }

  }
  
  private void grabarEsqBonifVigSuj(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
	  IDataSet dsEsqBonifVigSuj = dsSujeto.getDataSet("TEsqBonifVigSuj");
	  dsEsqBonifVigSuj.first();
	  while (!dsEsqBonifVigSuj.EOF()) {
		  EsquemaBonificacionVigSuj esqBonifVigSuj = EsquemaBonificacionVigSuj.findByOid(dsEsqBonifVigSuj.getInteger("oid_esq_bon_suj"),getSesion());
		  esqBonifVigSuj.setSujeto(sujeto);
		  esqBonifVigSuj.setEsquema_bonificacion(EsquemaBonificacion.findByOid(dsEsqBonifVigSuj.getInteger("oid_esq_bonif"),getSesion()));
		  esqBonifVigSuj.setFec_vig_desde(dsEsqBonifVigSuj.getDate("fec_vig_desde"));
		  esqBonifVigSuj.setFec_vig_hasta(dsEsqBonifVigSuj.getDate("fec_vig_hasta"));
		  esqBonifVigSuj.setActivo(dsEsqBonifVigSuj.getBoolean("activo"));
		  
		  sujeto.addEsquemaBonifVigSuj(esqBonifVigSuj);
		  
		  dsEsqBonifVigSuj.next();
	  }
	    	  
  }

  private void grabrarListaDePrecios(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsListasDePrecios = dsSujeto.getDataSet("TListasDePrecios");
    dsListasDePrecios.first();
    while (!dsListasDePrecios.EOF()) {
      ListaPrecioSujeto listaPrecioSujeto = ListaPrecioSujeto.findByOid(dsListasDePrecios.getInteger("oid_lp_suj"),getSesion());
      listaPrecioSujeto.setFecha_desde(dsListasDePrecios.getDate("fec_desde"));
      listaPrecioSujeto.setFecha_hasta(dsListasDePrecios.getDate("fec_hasta"));
      listaPrecioSujeto.setActivo(dsListasDePrecios.getBoolean("activo"));
      listaPrecioSujeto.setSujeto(sujeto);
      listaPrecioSujeto.setLista_precio(ListaPrecios.findByOidProxy(dsListasDePrecios.getInteger("oid_precio_cab"),getSesion()));

      sujeto.addListaPrecioSujeto(listaPrecioSujeto);
      dsListasDePrecios.next();
    }

  }


  private void grabrarBonifRecar(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsBonifRecar = dsSujeto.getDataSet("TBonifRecar");
    dsBonifRecar.first();
    while (!dsBonifRecar.EOF()) {
      BonifRecarSujeto bonifRecar = BonifRecarSujeto.findByOid(dsBonifRecar.getInteger("oid_bonif_recar"),getSesion());
      bonifRecar.setFec_vig_desde(dsBonifRecar.getDate("fec_vig_desde"));
      bonifRecar.setFec_vig_hasta(dsBonifRecar.getDate("fec_vig_hasta"));
      bonifRecar.setBonif1(dsBonifRecar.getDecimal("bonif1"));
      bonifRecar.setBonif2(dsBonifRecar.getDecimal("bonif2"));
      bonifRecar.setBonif3(dsBonifRecar.getDecimal("bonif3"));
      bonifRecar.setBonif4(dsBonifRecar.getDecimal("bonif4"));
      bonifRecar.setBonif5(dsBonifRecar.getDecimal("bonif5"));
      bonifRecar.setEn_cascada_bonif(dsBonifRecar.getBoolean("en_cascada_bonif"));
      bonifRecar.setReca1(dsBonifRecar.getDecimal("reca1"));
      bonifRecar.setReca2(dsBonifRecar.getDecimal("reca2"));
      bonifRecar.setReca3(dsBonifRecar.getDecimal("reca3"));
      bonifRecar.setReca4(dsBonifRecar.getDecimal("reca4"));
      bonifRecar.setReca5(dsBonifRecar.getDecimal("reca5"));
      bonifRecar.setEn_cascada_reca(dsBonifRecar.getBoolean("en_cascada_reca"));
      bonifRecar.setSujeto(sujeto);

      sujeto.addBonifRecar(bonifRecar);
      dsBonifRecar.next();
    }

  }

  private void grabarValoresClasif(Sujeto sujeto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
    dsValClasif.first();
    while (!dsValClasif.EOF()) {
      sujeto.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
                               dsValClasif.getInteger("oid_val_clasif_ent"));
      dsValClasif.next();
    }

  }


}
