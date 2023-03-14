package com.srn.erp.tesoreria.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.LiquidacionTarjetaDet;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveLiquidacionTarCab extends Operation { 
	
  HashTableDatos listaCotiz = null;
	
  public SaveLiquidacionTarCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	if (mapaDatos.containsKey("TCotizaciones"))
		listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
	  
    IDataSet dataset = mapaDatos.getDataSet("TLiquidacionCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        LiquidacionTarCab liquidaciontarcab = LiquidacionTarCab.findByOid(dataset.getInteger("oid_liqui_tar"),getSesion());
        
        Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
        liquidaciontarcab.addCotizacionesMonedas(listaCotiz);
        liquidaciontarcab.setTalonario(talonario);
        liquidaciontarcab.setContabiliza(true);
        liquidaciontarcab.setEmision(dataset.getDate("fecha"));
        liquidaciontarcab.setImputac(dataset.getDate("imputacion"));
        liquidaciontarcab.setTipoCompro(talonario.getTipo_comprobante());
        liquidaciontarcab.setLetra(talonario.getLetra());
        liquidaciontarcab.setLugarEmision(talonario.getLugar_emision());
        liquidaciontarcab.setNrolugemision(talonario.getLugar_emision().getLugemi());
        liquidaciontarcab.setComentario(dataset.getString("comentario"));
        liquidaciontarcab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        liquidaciontarcab.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja_liq"),getSesion()));
        liquidaciontarcab.setCotizacion(dataset.getCotizacion("cotizacion"));
        liquidaciontarcab.setNroext(dataset.getInteger("nro_ext"));
        
        TipoValor tipoValor = TipoValor.findByOidProxy(dataset.getInteger("oid_tipo_valor"),this.getSesion());
        liquidaciontarcab.setTipo_valor(tipoValor);
        liquidaciontarcab.setCompo_tipo_valor(tipoValor.getCompo());
        
        if (tipoValor.isTarjetaCredito())
        	liquidaciontarcab.setTarjeta_credito(TarjetaCredito.findByOidProxy(dataset.getInteger("oid_entidad"),this.getSesion()));
        
        if (tipoValor.isCuponTarjetaDebito())
        liquidaciontarcab.setBanco(Banco.findByOidProxy(dataset.getInteger("oid_entidad"),this.getSesion()));
        
        liquidaciontarcab.setFec_desde(dataset.getDate("fec_desde"));
        liquidaciontarcab.setFec_hasta(dataset.getDate("fec_hasta"));
        liquidaciontarcab.setFec_vto(dataset.getDate("fec_vto"));
        liquidaciontarcab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),this.getSesion()));
        liquidaciontarcab.setCotizacion(dataset.getCotizacion("cotizacion"));
        liquidaciontarcab.setImporte(dataset.getMoney("importe"));
        liquidaciontarcab.setConcepto_liq_tar(ConceptoLiqTarjeta.findByOidProxy(dataset.getInteger("oid_conc_liq_tc"),this.getSesion()));
        liquidaciontarcab.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),this.getSesion()));
        
        IDataSet dsDetalles = dataset.getDataSet("TValoresALiquidar");
        dsDetalles.first();
        while (!dsDetalles.EOF()){
        	
        	if (dsDetalles.getBoolean("sel").booleanValue()==false) {
        		dsDetalles.next();
        		continue;
        	}
        	
        	if ((dsDetalles.getMoney("importe_liquidado")!=null) && (dsDetalles.getMoney("importe_liquidado").doubleValue()==0)) {
        		dsDetalles.next();
        		continue;
        	}
        	
        	LiquidacionTarjetaDet liqTarDet =
        		LiquidacionTarjetaDet.findByOid(dsDetalles.getInteger("oid_det"), this.getSesion());
        	liqTarDet.setValor(Valor.findByOidProxy(dsDetalles.getInteger("oid_valor"), this.getSesion()));
        	liqTarDet.setLiquidacion_tar(liquidaciontarcab);
        	Money importeLiquidado = dsDetalles.getMoney("importe_liquidado");
        	liqTarDet.setImporte_liquidado(importeLiquidado);
        	
        	Money importeImpMonValor = dsDetalles.getMoney("importe_liquidado_mon_valor");
        	
        	liqTarDet.setActivo(new Boolean(true));
        	liqTarDet.setNroCuota(dsDetalles.getInteger("nro_cuota"));
        	liquidaciontarcab.addDetalleLiquidacion(liqTarDet);
        	
        	// Por cada Tarjeta si esta en Caja hacer el Movimiento de Salida
        	Valor valor = Valor.findByOid(dsDetalles.getInteger("oid_valor"),this.getSesion());
        	if (valor.isValorEnCartera())
        		sacarValorDeLaCaja(liquidaciontarcab,valor,importeLiquidado,importeImpMonValor);
        	
        	dsDetalles.next();
        	
        	
        	
        	
        	
        }
        
        
        
        addTransaccion(liquidaciontarcab);
        dataset.next();
    }
  }
  
  private void sacarValorDeLaCaja(LiquidacionTarCab liquidacionTarCab,Valor valor, Money importeLiquidado, Money importeLiqMonValor) throws BaseException {
	  MedioPago medioPago = liquidacionTarCab.addMedioPago();
	  medioPago.setIngresoEgreso(MedioPago.EGRESO);
	  medioPago.setFechaContable(liquidacionTarCab.getImputac());
	  medioPago.setFecEmision(liquidacionTarCab.getEmision());
	  medioPago.setTipoValor(valor.getTipovalor());
	  medioPago.setCaja(valor.getCaja());
      medioPago.setImporteMonedaPago(importeLiquidado);
      medioPago.setImporteMonedaValor(importeLiqMonValor);
      medioPago.setCaja(valor.getCaja());
      medioPago.setEstaLiquidando(true);
      medioPago.setImporteALiquidar(importeLiqMonValor);
      medioPago.setValor(valor);
      
  }
  
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda,valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
  
  
}
