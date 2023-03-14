package com.srn.erp.bancos.op;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.bm.ConciliacionDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConciliacionBanco extends Operation { 

  HashTableDatos listaCotiz = null;
	
  public SaveConciliacionBanco() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	if (mapaDatos.containsKey("TCotizaciones"))
		listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
		
    IDataSet dataset = mapaDatos.getDataSet("TConciliacionCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
      dataset.first(); 
      while (!dataset.EOF()) { 
        ConciliacionCab conciliacioncab = ConciliacionCab.findByOid(dataset.getInteger("oid_conciliacion"),getSesion());
        
        Talonario talonario = ConciliacionCab.getTalonatioConciliacionBanco(this.getSesion());
        
        if (listaCotiz!=null)
        	conciliacioncab.addCotizacionesMonedas(listaCotiz);
        conciliacioncab.setTalonario(talonario);
        conciliacioncab.setContabiliza(true);
        conciliacioncab.setEmision(Fecha.getFechaActual());
        conciliacioncab.setImputac(dataset.getDate("fecha"));
        conciliacioncab.setTipoCompro(talonario.getTipo_comprobante());
        conciliacioncab.setLetra(talonario.getLetra());
        conciliacioncab.setLugarEmision(talonario.getLugar_emision());
        conciliacioncab.setNrolugemision(talonario.getLugar_emision().getLugemi());
        conciliacioncab.setComentario("");
        conciliacioncab.setCodigo("");
        conciliacioncab.setDescripcion("");
        conciliacioncab.setConciliado_al(dataset.getDate("conciliado_al"));
        conciliacioncab.setFec_desde(dataset.getDate("fecha_desde"));
        conciliacioncab.setCuenta_bancaria(CuentaBancaria.findByOidProxy(dataset.getInteger("oid_cta_bancaria"),this.getSesion()));
        conciliacioncab.setObs_generales(dataset.getString("obs_generales"));
        conciliacioncab.setSaldo_ini_extrac(new Double(0));
        conciliacioncab.setActivo(dataset.getBoolean("activo"));
        if (!conciliacioncab.isActivo())
        	conciliacioncab.delete();
        
        IDataSet dsConciliacionDet =
        	dataset.getDataSet("TConciliacionDet");
        dsConciliacionDet.first();
        while (!dsConciliacionDet.EOF()) {
        	ConciliacionDet conciliacionDet = (ConciliacionDet)
        		ConciliacionDet.findByOid(dsConciliacionDet.getInteger("oid_conciliacion_det"), this.getSesion());
        	conciliacionDet.setConciliacion_cab(conciliacioncab);
        	conciliacionDet.setConciliado(dsConciliacionDet.getBoolean("conciliado"));
        	MovimientoCtaBancaria movCtaBancaria =
        		MovimientoCtaBancaria.findByOidProxy(dsConciliacionDet.getInteger("oid_mov_cta_bco"), this.getSesion());
        	conciliacionDet.setMovimiento_cuenta(movCtaBancaria);
        	conciliacionDet.setFecha(dsConciliacionDet.getDate("fecha"));
        	conciliacionDet.setTipo_mov(dsConciliacionDet.getString("tipo_mov"));
        	conciliacionDet.setNro_valor(dsConciliacionDet.getInteger("nro"));
        	conciliacionDet.setA_conciliar(dsConciliacionDet.getDouble("impo_contable"));
        	conciliacionDet.setExtracto(dsConciliacionDet.getDouble("impo_extracto"));
        	conciliacionDet.setNuevo_mov(dsConciliacionDet.getBoolean("nuevo_mov"));
        	conciliacionDet.setObservacion(dsConciliacionDet.getString("comentario"));
        	conciliacionDet.setCuenta_contable(CuentaImputable.findByOidProxy(dsConciliacionDet.getInteger("oid_ana_imp"), this.getSesion()));
        	conciliacionDet.setEsSaldoInicial(dsConciliacionDet.getBoolean("es_saldo_inicial"));

        	
        	conciliacioncab.addConciliacionDet(conciliacionDet);
        	
        	dsConciliacionDet.next();
        }
        
        	
        addTransaccion(conciliacioncab);
        dataset.next();
    }
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
