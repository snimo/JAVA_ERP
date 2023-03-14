package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;
import com.srn.erp.conciTarjeta.bm.TerminalConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AltaMovManuPOSNET extends Operation { 

  EmpresaConciTar empresa = null;	
	
  public AltaMovManuPOSNET() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	if (empresa == null)
		throw new ExceptionValidation(null,"Debe seleccionar la empresa");
    IDataSet dataset = mapaDatos.getDataSet("TInput"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	ArchLoteConciDet archLoteConciDet = null;   
    dataset.first(); 
      while (!dataset.EOF()) { 
    	
    	archLoteConciDet = (ArchLoteConciDet)
    		ArchLoteConciDet.getNew(ArchLoteConciDet.NICKNAME, this.getSesion());
    	archLoteConciDet.setAltaManual(true);
		archLoteConciDet.setArch_lot_cab(null);
		archLoteConciDet.setModo_transmision("MA");
		archLoteConciDet.setTipo_operacion("MANUAL");
		archLoteConciDet.setFecha_oper("");
		archLoteConciDet.setHora_oper("");
		
		TarjetaConciTar tarjeta =
			TarjetaConciTar.findByOidProxy(dataset.getInteger("oid_tarjeta"), this.getSesion());
		
		if (tarjeta == null) 
			throw new ExceptionValidation(null,"Debe ingresar la Tarjeta");
		
		archLoteConciDet.setTipo_tarjeta(tarjeta.getTipoTarjeta());
		
		String tarjetaAlta = TarjetaConciTar.getEquivAutTarjConi(tarjeta.getIdentif_tarj());
		if (tarjetaAlta == null)
			throw new ExceptionValidation(null,"No pudo tomar la equivalencia para la tarjeta "+tarjeta.getDescripcion());
		archLoteConciDet.setTarjeta(tarjetaAlta);		
		
		archLoteConciDet.setTarjetaOri(tarjeta.getCodigoPosnet());
		archLoteConciDet.setTarjetaConciliacion(tarjeta);
		if (dataset.getInteger("nro_tarjeta")!=null)
			archLoteConciDet.setNro_tarjeta(dataset.getInteger("nro_tarjeta").toString());
		else
			archLoteConciDet.setNro_tarjeta("");
		archLoteConciDet.setBanda_manual("");
		archLoteConciDet.setCod_autoriz("");
		if (dataset.getInteger("cupon")!=null)
			archLoteConciDet.setTicket(dataset.getInteger("cupon").toString());
		else
			archLoteConciDet.setTicket(null);
		archLoteConciDet.setMoneda("-$-");
		archLoteConciDet.setMonto(dataset.getDouble("importe"));
		archLoteConciDet.setTipo_cta_deb("");
		archLoteConciDet.setPlan_y_cuota("");
		archLoteConciDet.setCod_comercio("");
		
		TerminalConciTar terminal =
			TerminalConciTar.findByOidProxy(dataset.getInteger("oid_terminal"), this.getSesion());
		if (terminal!=null)
			archLoteConciDet.setNro_terminal(terminal.getNro_terminal());
		else
			archLoteConciDet.setNro_terminal("");
		archLoteConciDet.setTicket_sec("");
		archLoteConciDet.setCodigo_lista("");
		archLoteConciDet.setMonto_sec(new Double(0));
		archLoteConciDet.setFecha_sec(null);
		archLoteConciDet.setFactura("");
		archLoteConciDet.setNro_host("");
		archLoteConciDet.setNro_lote(dataset.getInteger("lote"));
		archLoteConciDet.setActivo(true);
		archLoteConciDet.setPresentado(false);

		archLoteConciDet.setEmpresa(empresa);
		if ((terminal!=null) && (terminal.getUni_neg()!=null))
			archLoteConciDet.setUnidad_negocio(terminal.getUni_neg());
		else
			archLoteConciDet.setUnidad_negocio(null);
		archLoteConciDet.setFecOperDate(dataset.getDate("fec_origen"));
		archLoteConciDet.setFecCierre(dataset.getDate("fec_cierre"));
		
		if (archLoteConciDet.getFecOperDate()==null)
			archLoteConciDet.setFecOperDate(archLoteConciDet.getFecCierre());
		
		archLoteConciDet.setPresentado(false);
		archLoteConciDet.setConciliado(false);
		archLoteConciDet.setLiquidado(false);
		archLoteConciDet.setPreContabilizado(false);
		archLoteConciDet.setContabilizado(false);
		archLoteConciDet.setContaAsiACobrar(false);
		archLoteConciDet.setContaAsiLiq(false);
		archLoteConciDet.setUltimosNrosTarjeta(dataset.getInteger("nro_tarjeta"));
		archLoteConciDet.save();    	
    	
        dataset.next();
    }
      
    IDataSet ds = getDataSetNuevoRegCupon();
    cargarRegCupon(ds, archLoteConciDet);
    writeCliente(ds);
      
  }
  
	private IDataSet getDataSetNuevoRegCupon() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetNuevoCuponPOSNET");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_arch_lote_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("modo_transmision", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_operacion", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha_oper", Field.STRING, 100));
		dataset.fieldDef(new Field("hora_oper", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("banda_manual", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_autoriz", Field.STRING, 100));
		dataset.fieldDef(new Field("ticket", Field.STRING, 100));
		dataset.fieldDef(new Field("moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("Monto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_cta_deb", Field.STRING, 100));
		dataset.fieldDef(new Field("plan_y_cuota", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_comercio", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_terminal", Field.STRING, 100));
		dataset.fieldDef(new Field("ticket_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("codigo_lista", Field.STRING, 100));
		dataset.fieldDef(new Field("monto_sec", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fecha_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("factura", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_host", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_lote", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("presentado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_uni_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_oper_date", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_cierre", Field.DATE, 0));		
		dataset.fieldDef(new Field("fec_presen_cupon", Field.DATE, 0));
		dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0)); 
		dataset.fieldDef(new Field("fec_conciliado", Field.DATE, 0));
		dataset.fieldDef(new Field("liquidado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_liquidado", Field.DATE, 0));
		dataset.fieldDef(new Field("preContabilizado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fecPreContabilizado", Field.DATE, 0));
		dataset.fieldDef(new Field("contabilizado" , Field.BOOLEAN, 0)); 
		dataset.fieldDef(new Field("fecContabilizado",  Field.DATE, 0));		
		dataset.fieldDef(new Field("agrupador",  Field.STRING, 50));
		dataset.fieldDef(new Field("ult_nros_tarj",  Field.INTEGER, 0));
		dataset.fieldDef(new Field("marcar_preconci",  Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_conciliacion",  Field.INTEGER, 0));
		dataset.fieldDef(new Field("pre_conci", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_conci_aut", Field.INTEGER, 0));
		dataset.fieldDef(new Field("preconci_dudoso", Field.STRING, 1));
		return dataset;
	}
	
	private void cargarRegCupon(IDataSet dsCupon,ArchLoteConciDet archLoteConciDet) throws BaseException {
		
		if (archLoteConciDet == null)
			throw new ExceptionValidation(null,"No se ingreso ningún dato para el cupón.");
		
		dsCupon.append();
		dsCupon.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
		if (archLoteConciDet.getArch_lot_cab()!=null)
			dsCupon.fieldValue("oid_arch_lote_cab", archLoteConciDet.getArch_lot_cab().getOIDInteger());
		else
			dsCupon.fieldValue("oid_arch_lote_cab", "");
		dsCupon.fieldValue("modo_transmision", archLoteConciDet.getModo_transmision());
		dsCupon.fieldValue("tipo_operacion", archLoteConciDet.getTipo_operacion());
		dsCupon.fieldValue("fecha_oper", archLoteConciDet.getFecha_oper());
		dsCupon.fieldValue("hora_oper", archLoteConciDet.getHora_oper());
		dsCupon.fieldValue("tipo_tarjeta", archLoteConciDet.getTipo_tarjeta());
		dsCupon.fieldValue("tarjeta", archLoteConciDet.getTarjeta());
		dsCupon.fieldValue("nro_tarjeta", archLoteConciDet.getNro_tarjeta());
		dsCupon.fieldValue("banda_manual", archLoteConciDet.getBanda_manual());
		dsCupon.fieldValue("cod_autoriz", archLoteConciDet.getCod_autoriz());
		dsCupon.fieldValue("ticket", archLoteConciDet.getTicket());
		dsCupon.fieldValue("moneda", archLoteConciDet.getMoneda());
		dsCupon.fieldValue("Monto", archLoteConciDet.getMonto());
		dsCupon.fieldValue("tipo_cta_deb", archLoteConciDet.getTipo_cta_deb());
		dsCupon.fieldValue("plan_y_cuota", archLoteConciDet.getPlan_y_cuota());
		dsCupon.fieldValue("cod_comercio", archLoteConciDet.getCod_comercio());
		dsCupon.fieldValue("nro_terminal", archLoteConciDet.getNro_terminal());
		dsCupon.fieldValue("ticket_sec", archLoteConciDet.getTicket_sec());
		dsCupon.fieldValue("codigo_lista", archLoteConciDet.getCodigo_lista());
		dsCupon.fieldValue("monto_sec", archLoteConciDet.getMonto_sec());
		dsCupon.fieldValue("fecha_sec", archLoteConciDet.getFecha_sec());
		dsCupon.fieldValue("factura", archLoteConciDet.getFactura());
		dsCupon.fieldValue("nro_host", archLoteConciDet.getNro_host());
		dsCupon.fieldValue("nro_lote", archLoteConciDet.getNro_lote());
		dsCupon.fieldValue("activo", archLoteConciDet.isActivo());
		dsCupon.fieldValue("presentado", archLoteConciDet.isPresentado());
		if (archLoteConciDet.getEmpresa()!=null)
			dsCupon.fieldValue("oid_empresa", archLoteConciDet.getEmpresa().getOIDInteger());
		else
			dsCupon.fieldValue("oid_empresa", "");
		if (archLoteConciDet.getUnidad_negocio()!=null)
			dsCupon.fieldValue("oid_uni_neg", archLoteConciDet.getUnidad_negocio().getOIDInteger());
		else
			dsCupon.fieldValue("oid_uni_neg", "");
		dsCupon.fieldValue("fec_oper_date", archLoteConciDet.getFecOperDate());
		dsCupon.fieldValue("fec_cierre", archLoteConciDet.getFecCierre());		
		dsCupon.fieldValue("fec_presen_cupon", archLoteConciDet.getFecPresenCupo());
		dsCupon.fieldValue("conciliado", archLoteConciDet.isConciliado()); 
		dsCupon.fieldValue("fec_conciliado", archLoteConciDet.getFecConciliado());
		dsCupon.fieldValue("liquidado", archLoteConciDet.isLiquidado());
		dsCupon.fieldValue("fec_liquidado", archLoteConciDet.getFecLiquidado());
		dsCupon.fieldValue("preContabilizado", archLoteConciDet.isPreContabilizado());
		dsCupon.fieldValue("fecPreContabilizado", archLoteConciDet.getFecPreContabilizado());
		dsCupon.fieldValue("contabilizado" , archLoteConciDet.isContabilizado()); 
		dsCupon.fieldValue("fecContabilizado",  archLoteConciDet.getFecContabilizado());
		String agrupador = "";
		if ((archLoteConciDet.getTarjetaConciTar()!=null) && (archLoteConciDet.getTarjetaConciTar().getAgrupador()!=null))
			agrupador = archLoteConciDet.getTarjetaConciTar().getAgrupador().getDescripcion();
		dsCupon.fieldValue("agrupador",  agrupador);
		dsCupon.fieldValue("ult_nros_tarj", archLoteConciDet.getUltimosNrosTarjeta());
		dsCupon.fieldValue("marcar_preconci", archLoteConciDet.isMarcarPreconci());
		dsCupon.fieldValue("nro_conciliacion", archLoteConciDet.getNroConciliacion());
		dsCupon.fieldValue("pre_conci", archLoteConciDet.isPreconci());
		dsCupon.fieldValue("fec_preconci", archLoteConciDet.getFecPreconci());
		if (archLoteConciDet.getCabConciAut()!=null)
			dsCupon.fieldValue("nro_conci_aut", archLoteConciDet.getCabConciAut().getOIDInteger());
		else
			dsCupon.fieldValue("nro_conci_aut", "");
		if (archLoteConciDet.isPreconciDudoso())
			dsCupon.fieldValue("preconci_dudoso", "?");
		else
			dsCupon.fieldValue("preconci_dudoso", "");
	}	
  
}
