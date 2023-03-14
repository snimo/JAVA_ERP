package com.srn.erp.ventas.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
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
import com.srn.erp.ventas.bm.EsquemaBonificacionVigSuj;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.EstadoSituacion;
import com.srn.erp.ventas.bm.ListaPrecioSujeto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Rubro;
import com.srn.erp.ventas.bm.SectorDireccion;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujeto
    extends Operation {

  public TraerSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    if (mapaDatos.containsKey("inicializarClasificadores")) {
      inicializarClasif(mapaDatos);
      return;
    }


    Sujeto sujeto = null;
    if (mapaDatos.containsKey("oid")) {
      Integer oid = mapaDatos.getInteger("oid");
      sujeto = Sujeto.findByOid(oid, getSesion());
    }
    else {
      String codigo = mapaDatos.getString("codigo");
      sujeto = Sujeto.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetSujeto = getDataSetSujeto();
    IDataSet datasetUniEdi = getDataSetUnidadEdilicia();
    IDataSet datasetSujImp = getDataSetSujetoImpositivo();
    IDataSet datasetContacto = getDataSetContactoSujeto();
    IDataSet datasetBonifRecar = getDataSetBonifRecar();
    IDataSet datasetListaPrecios = getDataSetListaDePrecios();
    IDataSet datasetValClasif = getDataSetValClasif();
    IDataSet datasetEsqBonifVigSuj = getDataSetEsqBonifVigSuj();
    IDataSet dsLibImpuSuj = this.getDataSetLiberacionImpuestos();

    if (sujeto != null) {
      cargarRegistroSujeto(datasetSujeto,
                           sujeto.getOIDInteger(),
                           sujeto.getCodigo(),
                           sujeto.getRazon_social(),
                           sujeto.getTipo_documento(),
                           sujeto.getNro_documento(),
                           sujeto.getSexo(),
                           sujeto.getFecha_nacimiento(),
                           sujeto.getFecha_ingreso(),
                           sujeto.getE_mail(),
                           sujeto.getNacionalidad(),
                           sujeto.getTelefonos(),
                           sujeto.getSujeto_impositivo(),
                           sujeto.getFax(),
                           sujeto.getSector_empresa(),
                           sujeto.getCargo(),
                           sujeto.getVendedor_tecnico(),
                           sujeto.getVendedor_comercial(),
                           sujeto.getWeb(),
                           sujeto.getEstado_situacion(),
                           sujeto.getZonadireccion(),
                           sujeto.getFec_est_situ_desde(),
                           sujeto.getFec_est_situ_hasta(),
                           sujeto.getFisica_juridica(),
                           sujeto.getProfesion(),
                           sujeto.isEs_cliente(),
                           sujeto.isEs_socio(),
                           sujeto.getDireccion_web(),
                           sujeto.getCobrador(),
                           sujeto.getRubro(),
                           sujeto.getEstado_civil(),
                           sujeto.getContacto(),
                           sujeto.getCalle_y_nro(),
                           sujeto.getSector_domilicio(),
                           sujeto.getLocalidad(),
                           sujeto.getCodigo_postal(),
                           sujeto.getProvincia(),
                           sujeto.getPais(),
                           sujeto.isDomicilio_entrega(),
                           sujeto.getZona_venta(),
                           sujeto.getCanal(),
                           sujeto.getClasificacionsujeto(),
                           sujeto.getCuenta_bancaria(),
                           sujeto.getTarjeta_credito(),
                           sujeto.getNro_medio_pago(),
                           sujeto.getResponsable_ctacte(),
                           sujeto.getModalidad_pago(),
                           sujeto.isPermite_otras_modalidades_pago(),
                           sujeto.getCondicionPago(),
                           sujeto.getSub_modalidad_pago(),
                           sujeto.isActivo(),
                           sujeto.isEs_contacto(),
                           sujeto.isEs_prospecto(),
                           sujeto.isBonifEnCascada(),
                           sujeto.getTransporte(),
                           sujeto.getMonedaCotizacion(),
                           sujeto.getMonedaPedido(),
                           sujeto.getMonedaFactura(),
                           sujeto.getIdioma(),
                           sujeto.isHabilitarLimiteCredito(),
                           sujeto.getMontoLimiteCredito(),
                           sujeto.getMonedaLimiteCredito(),
                           sujeto.isSusceptiblePercIBBsAs(),
                           sujeto.isSusceptiblePercIBCapFed(),
                           sujeto.isSusceptiblePercIVA(),
                           sujeto.isDomicilioCobraza(),
                           sujeto.getPasarACobrar(),
                           sujeto.getReclamarPagos(),
                           sujeto.getTipoImpresionFact()
                           );

      // Devolver valores de Clasificadores
      traerValoresDatosClasif(datasetValClasif,sujeto);

      // Sujeto Impositivo
      if (sujeto.getSujeto_impositivo() != null)
        cargarRegistroSujetoImpositivo(datasetSujImp, sujeto.getOIDInteger(),
                                       sujeto.getSujeto_impositivo());

      Iterator iterUnidadesEdilicas =
          sujeto.getUnidadesEdilicias().iterator();
      while (iterUnidadesEdilicas.hasNext()) {
        UnidadEdilicia unidadEdilicia =
            (UnidadEdilicia) iterUnidadesEdilicas.next();
        cargarRegistroUnidadEdilicia(datasetUniEdi,
                                     unidadEdilicia.getOIDInteger(),
                                     unidadEdilicia.getCodigo(),
                                     unidadEdilicia.getDescripcion(),
                                     unidadEdilicia.getCalle_y_mro(),
                                     unidadEdilicia.getLocalidad(),
                                     unidadEdilicia.getCodigo_postal(),
                                     unidadEdilicia.getTipo_unidad(),
                                     unidadEdilicia.getTelefonos(),
                                     unidadEdilicia.getProvincia(),
                                     unidadEdilicia.isDom_ent(),
                                     unidadEdilicia.getContacto(),
                                     unidadEdilicia.getSujeto_alta(),
                                     unidadEdilicia.getPais(),
                                     unidadEdilicia.getZona(),
                                     unidadEdilicia.isActivo(),
                                     unidadEdilicia.isDomicilioCobranza());

      }

      Iterator iterBonifRecar = sujeto.getBonifRecar().iterator();
      while (iterBonifRecar.hasNext()) {
        BonifRecarSujeto bonifRecarSuj =
            (BonifRecarSujeto) iterBonifRecar.next();
        cargarRegistroBonifRecar(datasetBonifRecar,
                                 bonifRecarSuj.getOIDInteger(),
                                 bonifRecarSuj.getFec_vig_desde(),
                                 bonifRecarSuj.getFec_vig_hasta(),
                                 bonifRecarSuj.getBonif1(),
                                 bonifRecarSuj.getBonif2(),
                                 bonifRecarSuj.getBonif3(),
                                 bonifRecarSuj.getBonif4(),
                                 bonifRecarSuj.getBonif5(),
                                 bonifRecarSuj.isEn_cascada_bonif(),
                                 bonifRecarSuj.getReca1(),
                                 bonifRecarSuj.getReca2(),
                                 bonifRecarSuj.getReca3(),
                                 bonifRecarSuj.getReca4(),
                                 bonifRecarSuj.getReca5(),
                                 bonifRecarSuj.isEn_cascada_reca(),
                                 bonifRecarSuj.getSujeto().getOIDInteger());
      }

      Iterator iterListasDePrecios =
          sujeto.getListasDePrecios().iterator();
      while (iterListasDePrecios.hasNext()) {
        ListaPrecioSujeto listaPrecioSujeto =
            (ListaPrecioSujeto) iterListasDePrecios.next();
        cargarListaDePrecios(datasetListaPrecios,
                             listaPrecioSujeto.getOIDInteger(),
                             listaPrecioSujeto.getLista_precio(),
                             sujeto,
                             listaPrecioSujeto.getFecha_desde(),
                             listaPrecioSujeto.getFecha_hasta(),
                             listaPrecioSujeto.isActivo());
      }


      Iterator iterContactos =
          sujeto.getContactos().iterator();
      while (iterContactos.hasNext()) {
        ContactoSujeto contactoSujeto =
            (ContactoSujeto) iterContactos.next();
        cargarRegistroContactoSujeto(datasetContacto,
                                     contactoSujeto.getOIDInteger(),
                                     contactoSujeto.getDescripcion(),
                                     contactoSujeto.getProvincia(),
                                     contactoSujeto.getPais(),
                                     contactoSujeto.getApellido(),
                                     contactoSujeto.getNombre(),
                                     contactoSujeto.getTelefonos(),
                                     contactoSujeto.getFax(),
                                     contactoSujeto.getDireccion(),
                                     contactoSujeto.getLocalidad(),
                                     contactoSujeto.getCodigo_postal(),
                                     contactoSujeto.getMail(),
                                     contactoSujeto.getSector(),
                                     contactoSujeto.getCargo(),
                                     sujeto,
                                     contactoSujeto.isActivo(),
                                     contactoSujeto.isPasarACobrar(),
                                     contactoSujeto.isReclamarPago()
                                     );

      }
      
      Iterator iterEsqBonifVigSuj = sujeto.getListasBonifVigSuj().iterator();
      while (iterEsqBonifVigSuj.hasNext()) {
    	  EsquemaBonificacionVigSuj esqBonifVigSuj = (EsquemaBonificacionVigSuj) iterEsqBonifVigSuj.next();
    	  cargarEsqBonifVigSuj(datasetEsqBonifVigSuj,esqBonifVigSuj);
      }
      
      Iterator iterLibImpu = sujeto.getLiberacionesImpuestos().iterator();
      while (iterLibImpu.hasNext()) {
      	LiberacionImpuestoSujeto libImpuSuj = (LiberacionImpuestoSujeto) iterLibImpu.next();
      	cargarRegistroLibimpu(dsLibImpuSuj,libImpuSuj);
      }

    }
    writeCliente(datasetSujeto);
    writeCliente(datasetUniEdi);
    writeCliente(datasetSujImp);
    writeCliente(datasetContacto);
    writeCliente(datasetBonifRecar);
    writeCliente(datasetListaPrecios);
    writeCliente(datasetValClasif);
    writeCliente(datasetEsqBonifVigSuj);
    writeCliente(dsLibImpuSuj);
    
  }

  private void cargarRegistroUnidadEdilicia(IDataSet dataset,
                                            Integer oid_uni_edi,
                                            String codigo,
                                            String descripcion,
                                            String calle_y_nro,
                                            String localidad,
                                            String codigo_postal,
                                            TipoUnidadEdilicia tipo_unidad,
                                            String telefonos,
                                            Provincia provincia,
                                            Boolean dom_ent,
                                            String contacto,
                                            Sujeto sujeto_alta,
                                            Pais pais,
                                            com.srn.erp.ventas.bm.Zona zona,
                                            Boolean activo,
                                            Boolean domCobranza) {
    dataset.append();
    dataset.fieldValue("oid_uni_edi", oid_uni_edi);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("calle_y_nro", calle_y_nro);
    dataset.fieldValue("localidad", localidad);
    if (codigo_postal != null)
      dataset.fieldValue("codigo_postal", codigo_postal);
    else
      dataset.fieldValue("codigo_postal", "");

    if (tipo_unidad != null)
      dataset.fieldValue("oid_tipo_unidad", tipo_unidad.getOID());
    else
      dataset.fieldValue("oid_tipo_unidad", 0);

    if (telefonos != null)
      dataset.fieldValue("telefonos", telefonos);
    else
      dataset.fieldValue("telefonos", "");

    if (provincia != null)
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
    else
      dataset.fieldValue("oid_provincia", 0);

    if (dom_ent != null)
      dataset.fieldValue("dom_ent", dom_ent);
    else
      dataset.fieldValue("dom_ent", new Boolean(false));

    if (contacto != null)
      dataset.fieldValue("contacto", contacto);
    else
      dataset.fieldValue("contacto", "");

    if (sujeto_alta != null)
      dataset.fieldValue("oid_sujeto_alta", sujeto_alta.getOIDInteger());
    else
      dataset.fieldValue("oid_sujeto_alta", 0);

    if (pais != null)
      dataset.fieldValue("oid_pais", pais.getOIDInteger());
    else
      dataset.fieldValue("oid_pais", 0);

    if (zona != null)
      dataset.fieldValue("oid_zona", zona.getOIDInteger());
    else
      dataset.fieldValue("oid_zona", 0);

    dataset.fieldValue("activo", activo);
    dataset.fieldValue("dom_cobranza", domCobranza);
  }

  private IDataSet getDataSetSujeto() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TSujeto");
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 80));
    dataset.fieldDef(new Field("oid_tipo_documento", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_documento", Field.STRING, 20));
    dataset.fieldDef(new Field("sexo", Field.STRING, 1));
    dataset.fieldDef(new Field("fec_nac", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_ingreso", Field.STRING, 10));
    dataset.fieldDef(new Field("e_mail", Field.STRING, 50));
    dataset.fieldDef(new Field("nacionalidad", Field.STRING, 30));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 50));
    dataset.fieldDef(new Field("fax", Field.STRING, 30));
    dataset.fieldDef(new Field("sector", Field.STRING, 30));
    dataset.fieldDef(new Field("cargo", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_vend_tec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vend_tec", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_vend_tec", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_vend_com", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vend_com", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_vend_com", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_est_situacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_est_situacion", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_est_situacion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_zona", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_zona", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_zona", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_est_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_est_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("fisica_juridica", Field.STRING, 1));
    dataset.fieldDef(new Field("profesion", Field.STRING, 30));
    dataset.fieldDef(new Field("es_cliente", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_socio", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("direccion_web", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cobrador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cobrador", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_cobrador", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_rubro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_rubro", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_rubro", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_estado_civil", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_estado_civil", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_estado_civil", Field.STRING, 50));
    dataset.fieldDef(new Field("contacto", Field.STRING, 30));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_sector_dir", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sector_dir", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_sector_dir", Field.INTEGER, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("dom_entrega", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_zona_vta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_zona_vta", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_zona_vta", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_canal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_canal", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_canal", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_clasif_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_sujeto", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_clasif_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_suj_resp_cc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_suj_resp_cc", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_suj_resp_cc", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cond_pago", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_cond_pago", Field.STRING, 50));
    dataset.fieldDef(new Field("moda_pago", Field.STRING, 10));
    dataset.fieldDef(new Field("sub_moda_pago", Field.STRING, 10));
    dataset.fieldDef(new Field("nro_medio_pago", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_entidad", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_entidad", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuit", Field.STRING, 11));
    dataset.fieldDef(new Field("permite_otras_mp", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_contacto", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_prospecto", Field.BOOLEAN, 0));    
    dataset.fieldDef(new Field("bonif_en_cascada", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_transporte", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda_cotiz", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda_pedido", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda_factura", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_idioma", Field.INTEGER, 0));
    dataset.fieldDef(new Field("hab_lim_cre",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("monto_lim_cre",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_mon_lim_cre",Field.INTEGER, 0));
    dataset.fieldDef(new Field("es_sus_perc_ib_ba",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_sus_perc_ib_cf",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_sus_perc_iva",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("dom_cobranza",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("pasar_a_cobrar",Field.STRING, 1000));
    dataset.fieldDef(new Field("reclamar_pagos",Field.STRING, 1000));
    dataset.fieldDef(new Field("tipo_impresion_fact",Field.STRING, 20));
    
    
    return dataset;
  }

  private IDataSet getDataSetUnidadEdilicia() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadesEdilicias");
    dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 20));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 30));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_tipo_unidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_provincia", Field.STRING, 0));
    dataset.fieldDef(new Field("dom_ent", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("contacto", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_sujeto_alta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_zona", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("dom_cobranza", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetListaDePrecios() {
    IDataSet dataset = new TDataSet();
    dataset.create("TListasDePrecios");
    dataset.fieldDef(new Field("oid_lp_suj", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_precio_cab", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_precio_cab", Field.STRING, 60));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarListaDePrecios(IDataSet dataset,
                                    Integer oidLP,
                                    ListaPrecios listaPrecios,
                                    Sujeto sujeto,
                                    Date fechaDesde,
                                    Date fechaHasta,
                                    Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lp_suj", oidLP);
    dataset.fieldValue("oid_precio_cab", listaPrecios.getOIDInteger());
    dataset.fieldValue("cod_precio_cab", listaPrecios.getCodigo());
    dataset.fieldValue("desc_precio_cab", listaPrecios.getDescripcion());
    dataset.fieldValue("oid_sujeto", sujeto.getOID());
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fechaDesde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fechaHasta));
    dataset.fieldValue("activo", activo);

  }


  private void cargarRegistroSujeto(IDataSet dataset,
                                    Integer oid_sujeto,
                                    String codigo,
                                    String razon_social,
                                    TipoDocumento tipoDocumento,
                                    String nro_documento,
                                    String sexo,
                                    java.util.Date fec_nac,
                                    java.util.Date fec_ingreso,
                                    String e_mail,
                                    String nacionalidad,
                                    String telefonos,
                                    SujetoImpositivo suj_imp,
                                    String fax,
                                    String sector,
                                    String cargo,
                                    Vendedor vend_tec,
                                    Vendedor vend_com,
                                    String web,
                                    EstadoSituacion estado_situacion,
                                    com.srn.erp.general.bm.Zona zona_direccion,
                                    java.util.Date fec_est_desde,
                                    java.util.Date fec_est_hasta,
                                    String fisica_juridica,
                                    String profesion,
                                    Boolean es_cliente,
                                    Boolean es_socio,
                                    String direccion_web,
                                    Cobrador cobrador,
                                    Rubro rubro,
                                    EstadoCivil estado_civil,
                                    String contacto,
                                    String calle_y_nro,
                                    SectorDireccion sector_dir,
                                    String localidad,
                                    String codigo_postal,
                                    Provincia provincia,
                                    Pais pais,
                                    Boolean dom_entrega,
                                    com.srn.erp.ventas.bm.Zona zona_vta,
                                    Canal canal,
                                    ClasifSujeto clasif_sujeto,
                                    CuentaBancaria cta_bancaria,
                                    TarjetaCredito tar_credito,
                                    String nro_medio_pago,
                                    Integer suj_resp_cc,
                                    String moda_pago,
                                    Boolean permite_otras_mp,
                                    CondicionPago condicionPago,
                                    String sub_moda_pago,
                                    Boolean activo,
                                    Boolean esContacto,
                                    Boolean esProspecto,
                                    Boolean bonifEnCascada,
                                    Transporte transporte,
                                    Moneda monedaCotizacion,
                                    Moneda monedaPedido,
                                    Moneda monedaFactura,
                                    Idioma idioma,
                                    Boolean habLimCre,
                                    Money montoLimCre,
                                    Moneda monedaLimCre,
                                    boolean es_sus_perc_ib_ba,
                                    boolean es_sus_perc_ib_cf,
                                    boolean es_sus_perc_iva,
                                    Boolean domCobranza,
                                    String pasarACobrar,
                                    String reclamarPagos,
                                    String tipoImpresionFact) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_sujeto", oid_sujeto);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social", razon_social);

    if (tipoDocumento != null) {
      dataset.fieldValue("oid_tipo_documento", tipoDocumento.getOID());
    }
    else {
      dataset.fieldValue("oid_tipo_documento", 0);

    }
    if (nro_documento != null) {
      dataset.fieldValue("nro_documento", nro_documento);
    }
    else {
      dataset.fieldValue("nro_documento", nro_documento);

    }
    if (sexo != null) {
      dataset.fieldValue("sexo", sexo);
    }
    else {
      dataset.fieldValue("sexo", "");

    }
    if (fec_nac != null) {
      dataset.fieldValue("fec_nac", Fecha.getddmmyyyy(fec_nac));
    }
    else {
      dataset.fieldValue("fec_nac", Fecha.FECHA_NULA());

    }
    if (fec_ingreso != null) {
      dataset.fieldValue("fec_ingreso", Fecha.getddmmyyyy(fec_ingreso));
    }
    else {
      dataset.fieldValue("fec_ingreso", Fecha.FECHA_NULA());

    }
    if (e_mail != null) {
      dataset.fieldValue("e_mail", e_mail);
    }
    else {
      dataset.fieldValue("e_mail", "");

    }
    if (nacionalidad != null) {
      dataset.fieldValue("nacionalidad", nacionalidad);
    }
    else {
      dataset.fieldValue("nacionalidad", "");

    }
    if (telefonos != null) {
      dataset.fieldValue("telefonos", telefonos);
    }
    else {
      dataset.fieldValue("telefonos", "");
    }

    if (fax != null) {
      dataset.fieldValue("fax", fax);
    }
    else {
      dataset.fieldValue("fax", "");

    }
    if (sector != null) {
      dataset.fieldValue("sector", sector);
    }
    else {
      dataset.fieldValue("sector", "");

    }
    if (cargo != null) {
      dataset.fieldValue("cargo", cargo);
    }
    else {
      dataset.fieldValue("cargo", "");
    }

    if (vend_tec != null) {
      dataset.fieldValue("oid_vend_tec", vend_tec.getOID());
      dataset.fieldValue("cod_vend_tec", vend_tec.getCodigo());
      dataset.fieldValue("desc_vend_tec", vend_tec.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_vend_tec", 0);
      dataset.fieldValue("cod_vend_tec", "");
      dataset.fieldValue("desc_vend_tec", "");
    }

    if (vend_com != null) {
      dataset.fieldValue("oid_vend_com", vend_com.getOID());
      dataset.fieldValue("cod_vend_com", vend_com.getCodigo());
      dataset.fieldValue("desc_vend_com", vend_com.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_vend_com", 0);
      dataset.fieldValue("cod_vend_com", "");
      dataset.fieldValue("desc_vend_com", "");
    }

    if (estado_situacion != null) {
      dataset.fieldValue("oid_est_situacion", estado_situacion.getOID());
      dataset.fieldValue("cod_est_situacion", estado_situacion.getCodigo());
      dataset.fieldValue("desc_est_situacion", estado_situacion.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_est_situacion", 0);
      dataset.fieldValue("cod_est_situacion", "");
      dataset.fieldValue("desc_est_situacion", "");
    }

    if (zona_direccion != null) {
      dataset.fieldValue("oid_zona", zona_direccion.getOID());
      dataset.fieldValue("cod_zona", zona_direccion.getCodigo());
      dataset.fieldValue("desc_zona", zona_direccion.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_zona", 0);
      dataset.fieldValue("cod_zona", "");
      dataset.fieldValue("desc_zona", "");
    }

    if (fec_est_desde != null) {
      dataset.fieldValue("fec_est_desde", Fecha.getddmmyyyy(fec_est_desde));
    }
    else {
      dataset.fieldValue("fec_est_desde", Fecha.FECHA_NULA());

    }
    if (fec_est_hasta != null) {
      dataset.fieldValue("fec_est_hasta", Fecha.getddmmyyyy(fec_est_hasta));
    }
    else {
      dataset.fieldValue("fec_est_hasta", Fecha.FECHA_NULA());
    }

    if (fisica_juridica != null) {
      dataset.fieldValue("fisica_juridica", fisica_juridica);
    }
    else {
      dataset.fieldValue("fisica_juridica", "");
    }

    if (profesion != null) {
      dataset.fieldValue("profesion", profesion);
    }
    else {
      dataset.fieldValue("profesion", "");
    }

    if (es_cliente != null) {
      dataset.fieldValue("es_cliente", es_cliente);
    }
    else {
      dataset.fieldValue("es_cliente", new Boolean(false));

    }
    if (es_socio != null) {
      dataset.fieldValue("es_socio", es_socio);
    }
    else {
      dataset.fieldValue("es_socio", new Boolean(false));
    }

    if (direccion_web != null) {
      dataset.fieldValue("direccion_web", direccion_web);
    }
    else {
      dataset.fieldValue("direccion_web", "");
    }

    if (cobrador != null) {
      dataset.fieldValue("oid_cobrador", cobrador.getOID());
      dataset.fieldValue("cod_cobrador", cobrador.getOID());
      dataset.fieldValue("desc_cobrador", cobrador.getOID());
    }
    else {
      dataset.fieldValue("oid_cobrador", 0);
      dataset.fieldValue("cod_cobrador", "");
      dataset.fieldValue("desc_cobrador", "");
    }

    if (rubro != null) {
      dataset.fieldValue("oid_rubro", rubro.getOID());
      dataset.fieldValue("cod_rubro", rubro.getCodigo());
      dataset.fieldValue("desc_rubro", rubro.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_rubro", 0);
      dataset.fieldValue("cod_rubro", "");
      dataset.fieldValue("desc_rubro", "");
    }

    if (estado_civil != null) {
      dataset.fieldValue("oid_estado_civil", estado_civil.getOID());
      dataset.fieldValue("cod_estado_civil", estado_civil.getCodigo());
      dataset.fieldValue("desc_estado_civil", estado_civil.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_estado_civil", 0);
      dataset.fieldValue("cod_estado_civil", "");
      dataset.fieldValue("desc_estado_civil", "");
    }

    if (contacto != null)
      dataset.fieldValue("contacto", contacto);
    else
      dataset.fieldValue("contacto", "");

    if (calle_y_nro != null)
      dataset.fieldValue("calle_y_nro", calle_y_nro);
    else
      dataset.fieldValue("calle_y_nro", "");

    if (sector_dir != null) {
      dataset.fieldValue("oid_sector_dir", sector_dir.getOID());
      dataset.fieldValue("cod_sector_dir", sector_dir.getCodigo());
      dataset.fieldValue("desc_sector_dir", sector_dir.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_sector_dir", 0);
      dataset.fieldValue("cod_sector_dir", "");
      dataset.fieldValue("desc_sector_dir", "");
    }

    if (localidad != null)
      dataset.fieldValue("localidad", localidad);
    else
      dataset.fieldValue("localidad", "");

    if (codigo_postal != null)
      dataset.fieldValue("codigo_postal", codigo_postal);
    else
      dataset.fieldValue("codigo_postal", "");

    if (pais != null) {
      dataset.fieldValue("oid_pais", pais.getOIDInteger());
      dataset.fieldValue("cod_pais", pais.getCodigo());
      dataset.fieldValue("desc_pais", pais.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_pais", 0);
      dataset.fieldValue("cod_pais", "");
      dataset.fieldValue("desc_pais", "");
    }

    if (provincia != null) {
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
      dataset.fieldValue("cod_provincia", provincia.getCodigo());
      dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_provincia", 0);
      dataset.fieldValue("cod_provincia", "");
      dataset.fieldValue("desc_provincia", "");
    }

    if (dom_entrega != null)
      dataset.fieldValue("dom_entrega", dom_entrega);
    else
      dataset.fieldValue("dom_entrega", new Boolean(false));

    if (zona_vta != null) {
      dataset.fieldValue("oid_zona_vta", zona_vta.getOIDInteger());
      dataset.fieldValue("cod_zona_vta", zona_vta.getCodigo());
      dataset.fieldValue("desc_zona_vta", zona_vta.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_zona_vta", 0);
      dataset.fieldValue("cod_zona_vta", "");
      dataset.fieldValue("desc_zona_vta", "");
    }

    if (canal != null) {
      dataset.fieldValue("oid_canal", canal.getOIDInteger());
      dataset.fieldValue("cod_canal", canal.getCodigo());
      dataset.fieldValue("desc_canal", canal.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_canal", 0);
      dataset.fieldValue("cod_canal", "");
      dataset.fieldValue("desc_canal", "");
    }

    if (clasif_sujeto != null) {
      dataset.fieldValue("oid_clasif_sujeto", clasif_sujeto.getOIDInteger());
      dataset.fieldValue("cod_clasif_sujeto", clasif_sujeto.getCodigo());
      dataset.fieldValue("desc_clasif_sujeto", clasif_sujeto.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_clasif_sujeto", 0);
      dataset.fieldValue("cod_clasif_sujeto", "");
      dataset.fieldValue("desc_clasif_sujeto", "");
    }

    if ( (suj_resp_cc != null) && (suj_resp_cc.intValue() > 0)) {
      Sujeto sujetoRespCtaCte = Sujeto.findByOidProxy(suj_resp_cc, getSesion());
      dataset.fieldValue("oid_suj_resp_cc", sujetoRespCtaCte.getOIDInteger());
      dataset.fieldValue("cod_suj_resp_cc", sujetoRespCtaCte.getCodigo());
      dataset.fieldValue("desc_suj_resp_cc", sujetoRespCtaCte.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_suj_resp_cc", 0);
      dataset.fieldValue("cod_suj_resp_cc", "");
      dataset.fieldValue("desc_suj_resp_cc", "");
    }

    if (condicionPago != null) {
      dataset.fieldValue("oid_cond_pago", condicionPago.getOIDInteger());
      dataset.fieldValue("cod_cond_pago", condicionPago.getCodigo());
      dataset.fieldValue("desc_cond_pago", condicionPago.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_cond_pago", 0);
      dataset.fieldValue("cod_cond_pago", "");
      dataset.fieldValue("desc_cond_pago", "");
    }

    if (moda_pago != null) {
      dataset.fieldValue("moda_pago", moda_pago);
    }
    else {
      dataset.fieldValue("moda_pago", "");
    }

    if (sub_moda_pago != null) {
      dataset.fieldValue("sub_moda_pago", sub_moda_pago);
    }
    else {
      dataset.fieldValue("sub_moda_pago", "");
    }

    if (nro_medio_pago != null) {
      dataset.fieldValue("nro_medio_pago", nro_medio_pago);
    }
    else {
      dataset.fieldValue("nro_medio_pago", "");
    }

    if (cta_bancaria != null) {
      dataset.fieldValue("oid_entidad", cta_bancaria.getOID());
      dataset.fieldValue("cod_entidad", cta_bancaria.getCodigo());
      dataset.fieldValue("desc_entidad", cta_bancaria.getDescripcion());
    }
    else
    if (tar_credito != null) {
      dataset.fieldValue("oid_entidad", tar_credito.getOID());
      dataset.fieldValue("cod_entidad", tar_credito.getCodigo());
      dataset.fieldValue("desc_entidad", tar_credito.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_entidad", 0);
      dataset.fieldValue("cod_entidad", "");
      dataset.fieldValue("desc_entidad", "");
    }

    if (suj_imp != null) {
      dataset.fieldValue("oid_suj_imp", suj_imp.getOID());
      dataset.fieldValue("cuit", suj_imp.getCuit());
    }
    else {
      dataset.fieldValue("oid_suj_imp", 0);
      dataset.fieldValue("cuit", "");

    }

    if (permite_otras_mp != null) {
      dataset.fieldValue("permite_otras_mp", permite_otras_mp);
    }
    else {
      dataset.fieldValue("permite_otras_mp", new Boolean(false));
    }

    dataset.fieldValue("activo", activo);
    dataset.fieldValue("es_contacto", esContacto);
    dataset.fieldValue("es_prospecto", esProspecto);
    
    if (bonifEnCascada!=null)
    	dataset.fieldValue("bonif_en_cascada",bonifEnCascada);
    else
    	dataset.fieldValue("bonif_en_cascada",new Boolean(false));
    
    if (transporte!=null) {
    	dataset.fieldValue("oid_transporte",transporte.getOIDInteger());
    	dataset.fieldValue("cod_transporte",transporte.getCodigo());
    	dataset.fieldValue("desc_transporte",transporte.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_transporte",0);
    	dataset.fieldValue("cod_transporte","");
    	dataset.fieldValue("desc_transporte","");
    }
    
    if (monedaCotizacion!=null) 
    	dataset.fieldValue("oid_moneda_cotiz",monedaCotizacion.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda_cotiz",0);
    
    if (monedaPedido!=null)
    	dataset.fieldValue("oid_moneda_pedido",monedaPedido.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda_pedido",0);
    
    if (monedaFactura!=null)
    	dataset.fieldValue("oid_moneda_factura",monedaFactura.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda_factura",0);
    
    if (idioma!=null)
    	dataset.fieldValue("oid_idioma",idioma.getOIDInteger());
    else
    	dataset.fieldValue("oid_idioma",0);
    
    if (habLimCre!=null)
    	dataset.fieldValue("hab_lim_cre", habLimCre);
    else
    	dataset.fieldValue("hab_lim_cre", new Boolean(false));
    if (montoLimCre!=null)
    	dataset.fieldValue("monto_lim_cre",montoLimCre);
    else
    	dataset.fieldValue("monto_lim_cre",new Money(0));
    if (monedaLimCre!=null)
    	dataset.fieldValue("oid_mon_lim_cre",monedaLimCre.getOIDInteger());
    else
    	dataset.fieldValue("oid_mon_lim_cre",new Integer(0));
    
    dataset.fieldValue("es_sus_perc_ib_ba",new Boolean(es_sus_perc_ib_ba));
    dataset.fieldValue("es_sus_perc_ib_cf",new Boolean(es_sus_perc_ib_cf));
    dataset.fieldValue("es_sus_perc_iva",new Boolean(es_sus_perc_iva));
    
    dataset.fieldValue("dom_cobranza", domCobranza);
    dataset.fieldValue("pasar_a_cobrar",pasarACobrar);
    dataset.fieldValue("reclamar_pagos",reclamarPagos);
    dataset.fieldValue("tipo_impresion_fact" , tipoImpresionFact);
    
    
  }

  private void cargarRegistroSujetoImpositivo(IDataSet dataset,
                                              Integer oidSujeto,
                                              SujetoImpositivo sujetoImpositivo) throws
      BaseException {
    dataset.append();
    dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
    dataset.fieldValue("razon_social", sujetoImpositivo.getRazon());
    dataset.fieldValue("cuit", sujetoImpositivo.getCuit());
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

    dataset.fieldValue("oid_sujeto", oidSujeto);
    dataset.fieldValue("activo", sujetoImpositivo.isActivo());
  }

  private IDataSet getDataSetSujetoImpositivo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSujetoImpositivo");
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    dataset.fieldDef(new Field("cuit", Field.STRING, 20));
    dataset.fieldDef(new Field("ing_brutos", Field.STRING, 20));
    dataset.fieldDef(new Field("dnrp", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarRegistroLibimpu(IDataSet ds,
  		LiberacionImpuestoSujeto libImpuSuj) throws BaseException {
  	ds.append();  	
  	ds.fieldValue("oid_lib_impu", libImpuSuj.getOIDInteger());
  	ds.fieldValue("oid_sujeto", libImpuSuj.getSujeto().getOIDInteger());
  	ds.fieldValue("fec_vig_desde", libImpuSuj.getFec_vig_desde());
  	ds.fieldValue("fec_vig_hasta", libImpuSuj.getFec_vig_hasta());
  	ds.fieldValue("porc_lib", libImpuSuj.getPorc_lib());
  	ds.fieldValue("nuevo_porc", libImpuSuj.getNuevo_porc());
  	ds.fieldValue("tipo_impuesto", libImpuSuj.getTipo_impuesto());
  	ds.fieldValue("activo", libImpuSuj.isActivo());

  }
  
  private IDataSet getDataSetLiberacionImpuestos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLiberacionImpuestos");
    dataset.fieldDef(new Field("oid_lib_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vig_desde", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vig_hasta", Field.DATE, 0));
    dataset.fieldDef(new Field("porc_lib", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("nuevo_porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("tipo_impuesto", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  

  private IDataSet getDataSetContactoSujeto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TContactos");
    dataset.fieldDef(new Field("oid_contac_suj", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("apellido", Field.STRING, 25));
    dataset.fieldDef(new Field("nombre", Field.STRING, 25));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 25));
    dataset.fieldDef(new Field("fax", Field.STRING, 25));
    dataset.fieldDef(new Field("direccion", Field.STRING, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("mail", Field.STRING, 50));
    dataset.fieldDef(new Field("sector", Field.STRING, 30));
    dataset.fieldDef(new Field("cargo", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("pasar_a_cobrar", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("reclamar_pago", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetBonifRecar() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBonifRecar");
    dataset.fieldDef(new Field("oid_bonif_recar", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vig_desde", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vig_hasta", Field.DATE, 0));
    dataset.fieldDef(new Field("bonif1", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("bonif2", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("bonif3", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("bonif4", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("bonif5", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("en_cascada_bonif", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("reca1", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("reca2", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("reca3", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("reca4", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("reca5", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("en_cascada_reca", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroBonifRecar(IDataSet dataset,
                                        Integer oid_bonif_recar,
                                        java.util.Date fechaVigDesde,
                                        java.util.Date fechaVigHasta,
                                        Decimal bonif1,
                                        Decimal bonif2,
                                        Decimal bonif3,
                                        Decimal bonif4,
                                        Decimal bonif5,
                                        Boolean en_cascada_bonif,
                                        Decimal reca1,
                                        Decimal reca2,
                                        Decimal reca3,
                                        Decimal reca4,
                                        Decimal reca5,
                                        Boolean en_cascada_reca,
                                        Integer oid_sujeto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_bonif_recar", oid_bonif_recar);
    dataset.fieldValue("fec_vig_desde", Fecha.getddmmyyyy(fechaVigDesde));
    dataset.fieldValue("fec_vig_hasta", Fecha.getddmmyyyy(fechaVigHasta));
    if (bonif1!=null)
      dataset.fieldValue("bonif1", bonif1);
    else
      dataset.fieldValue("bonif1", 0);
    if (bonif2!=null)
      dataset.fieldValue("bonif2", bonif2);
    else
      dataset.fieldValue("bonif2", 0);
    if (bonif3!=null)
      dataset.fieldValue("bonif3", bonif3);
    else
      dataset.fieldValue("bonif3", 0);
    if (bonif4!=null)
      dataset.fieldValue("bonif4", bonif4);
    else
      dataset.fieldValue("bonif4", 0);
    if (bonif5!=null)
      dataset.fieldValue("bonif5", bonif5);
    else
      dataset.fieldValue("bonif5", 0);
    dataset.fieldValue("en_cascada_bonif", en_cascada_bonif);
    if (reca1!=null)
      dataset.fieldValue("reca1", reca1);
    else
      dataset.fieldValue("reca1", 0);
    if (reca2!=null)
      dataset.fieldValue("reca2", reca2);
    else
      dataset.fieldValue("reca2", 0);
    if (reca3!=null)
      dataset.fieldValue("reca3", reca3);
    else
      dataset.fieldValue("reca3", 0);
    if (reca4!=null)
      dataset.fieldValue("reca4", reca4);
    else
      dataset.fieldValue("reca4", 0);
    if (reca5!=null)
      dataset.fieldValue("reca5", reca5);
    else
      dataset.fieldValue("reca5", 0);
    dataset.fieldValue("en_cascada_reca", en_cascada_reca);
    dataset.fieldValue("oid_sujeto", oid_sujeto);

  }




  private void cargarRegistroContactoSujeto(IDataSet dataset,
                         Integer oid_contac_suj,
                         String descripcion,
                         Provincia provincia,
                         Pais pais,
                         String apellido,
                         String nombre,
                         String telefonos,
                         String fax,
                         String direccion,
                         String localidad,
                         String codigo_postal,
                         String mail,
                         String sector,
                         String cargo,
                         Sujeto sujeto,
                         Boolean activo,
                         Boolean pasarACobrar,
                         Boolean reclamarPago) {
    dataset.append();
    dataset.fieldValue("oid_contac_suj", oid_contac_suj);

    if (descripcion!=null)
      dataset.fieldValue("descripcion", descripcion);
    else
      dataset.fieldValue("descripcion", "");

    if (provincia!=null)
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
    else
      dataset.fieldValue("oid_provincia", 0);

    if (pais!=null)
      dataset.fieldValue("oid_pais", pais.getOIDInteger());
    else
      dataset.fieldValue("oid_pais", 0);

    dataset.fieldValue("apellido", apellido);
    dataset.fieldValue("nombre", nombre);

    if (telefonos!=null)
      dataset.fieldValue("telefonos", telefonos);
    else
      dataset.fieldValue("telefonos", "");

    if (fax!=null)
      dataset.fieldValue("fax", fax);
    else
      dataset.fieldValue("fax", "");

    if (direccion!=null)
      dataset.fieldValue("direccion", direccion);
    else
      dataset.fieldValue("direccion", "");

    if (localidad!=null)
      dataset.fieldValue("localidad", localidad);
    else
      dataset.fieldValue("localidad", "");

    if (codigo_postal!=null)
      dataset.fieldValue("codigo_postal", codigo_postal);
    else
      dataset.fieldValue("codigo_postal", "");

    if (mail!=null)
      dataset.fieldValue("mail", mail);
    else
      dataset.fieldValue("mail", "");

    if (sector!=null)
      dataset.fieldValue("sector", sector);
    else
      dataset.fieldValue("sector", "");

    if (cargo!=null)
      dataset.fieldValue("cargo", cargo);
    else
      dataset.fieldValue("cargo", "");

    dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("pasar_a_cobrar", pasarACobrar);
    dataset.fieldValue("reclamar_pago", reclamarPago);
    
  }

  private IDataSet getDataSetValClasif() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresClasificadores");
    dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
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
                                 Integer oidSujeto,
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
    dataset.fieldValue("oid_sujeto", oidSujeto);
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

  private void traerValoresDatosClasif(IDataSet ds,Sujeto aSujeto) throws BaseException {
    int oid = 0;
    Iterator iterClasifEnt = aSujeto.getClasificadoresEntidad().iterator();
    while (iterClasifEnt.hasNext()) {
      ClasificadorEntidad clasifEnt =
          (ClasificadorEntidad) iterClasifEnt.next();
      ValorClasificadorEntidad valClasifEntidad =
          aSujeto.getValorClasifEnt(clasifEnt);
      if (valClasifEntidad!=null)
        cargarDSValClasif(ds,new Integer(++oid),aSujeto.getOIDInteger(),
                       clasifEnt.getOIDInteger(),valClasifEntidad.getOIDInteger(),
                       clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
                       valClasifEntidad.getCodigo(),valClasifEntidad.getDescripcion(),
                       clasifEnt.getNickname(),
                       new Boolean(true),
                       clasifEnt.getDescripcion());
     else
       cargarDSValClasif(ds,new Integer(++oid),aSujeto.getOIDInteger(),
                      clasifEnt.getOIDInteger(),new Integer(-1),
                      clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
                      "","",
                      clasifEnt.getNickname(),
                      new Boolean(true),
                      clasifEnt.getDescripcion());
    }

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
  
  private IDataSet getDataSetEsqBonifVigSuj() {
	IDataSet dataset = new TDataSet();
	dataset.create("TEsqBonifVigSuj");
	dataset.fieldDef(new Field("oid_esq_bon_suj", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_esq_bonif",Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_esq_bonif",Field.STRING, 50));
	dataset.fieldDef(new Field("desc_esq_bonif",Field.STRING, 100));
	dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
	dataset.fieldDef(new Field("fec_vig_desde",Field.DATE, 0));
	dataset.fieldDef(new Field("fec_vig_hasta",Field.DATE, 0));
	dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	return dataset;
  }
  
  private void cargarEsqBonifVigSuj(IDataSet dataset,EsquemaBonificacionVigSuj esqBonifVigSuj) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_esq_bon_suj", esqBonifVigSuj.getOIDInteger());
	  dataset.fieldValue("oid_esq_bonif", esqBonifVigSuj.getEsquema_bonificacion().getOIDInteger());
	  dataset.fieldValue("cod_esq_bonif", esqBonifVigSuj.getEsquema_bonificacion().getCodigo());
	  dataset.fieldValue("desc_esq_bonif", esqBonifVigSuj.getEsquema_bonificacion().getDescripcion());
	  dataset.fieldValue("oid_sujeto", esqBonifVigSuj.getSujeto().getOIDInteger());
	  dataset.fieldValue("fec_vig_desde", esqBonifVigSuj.getFec_vig_desde());
	  dataset.fieldValue("fec_vig_hasta", esqBonifVigSuj.getFec_vig_hasta());
	  dataset.fieldValue("activo", esqBonifVigSuj.isActivo());
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
    Iterator iterClasifEnt = Sujeto.getClasificadoresEntidad(getSesion()).iterator();
    while (iterClasifEnt.hasNext()) {
      ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
      cargarRegistroClasificadorEntidad(dsClasifEnt,clasifEnt);
    }
    writeCliente(dsClasifEnt);
  }




}
