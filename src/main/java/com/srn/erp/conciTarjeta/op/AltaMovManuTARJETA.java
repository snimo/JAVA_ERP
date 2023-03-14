package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AltaMovManuTARJETA extends Operation { 

  EmpresaConciTar empresa = null;	
	
  public AltaMovManuTARJETA() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	if (empresa == null)
		throw new ExceptionValidation(null,"Debe seleccionar la empresa");
    IDataSet dataset = mapaDatos.getDataSet("TInput"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	DetTarConciEnt detArchConciDet = null;   
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
  		TarjetaConciTar tarjeta =
			TarjetaConciTar.findByOidProxy(dataset.getInteger("oid_tarjeta"), this.getSesion());
		
		if (tarjeta == null) 
			throw new ExceptionValidation(null,"Debe ingresar la Tarjeta");    	  
    	  
    	detArchConciDet = (DetTarConciEnt) DetTarConciEnt.getNew(DetTarConciEnt.NICKNAME, this.getSesion());
    	detArchConciDet.setAltaManual(true);
    	detArchConciDet.setTar_info_cab(null);
    	detArchConciDet.setEmpresa(empresa);
    	detArchConciDet.setTipo_operacion("MANUAL");
    	detArchConciDet.setFec_present(dataset.getDate("fec_cierre"));
    	detArchConciDet.setLote(dataset.getInteger("lote"));
    	detArchConciDet.setFec_pago(null);
    	detArchConciDet.setDescripcion("Mov. Manual");
    	detArchConciDet.setFec_origen(dataset.getDate("fec_origen"));
    	detArchConciDet.setNro_comprobante(null);
    	if (dataset.getInteger("nro_tarjeta")!=null)
    		detArchConciDet.setNro_tarjeta(dataset.getInteger("nro_tarjeta"));
    	else
    		detArchConciDet.setNro_tarjeta(null);
    	
    	detArchConciDet.setPlan(null);
    	detArchConciDet.setCuota(null);
    	detArchConciDet.setMoneda("-$-");
    	detArchConciDet.setImporte(new Money(dataset.getDouble("importe")));
    	detArchConciDet.setComercio("");
    	detArchConciDet.setNro_cupon(dataset.getInteger("cupon"));
    	detArchConciDet.setActivo(true);
    	detArchConciDet.setTipoTarjeta(tarjeta.getTipoTarjeta());
    	detArchConciDet.setConciliado(false);
    	if (tarjeta.getEquivIdentif() == null)
    		throw new ExceptionValidation(null,"No se pudo tomar la equivalencia para la tarjeta "+tarjeta.getDescripcion());
    	detArchConciDet.setTarjeta(tarjeta.getEquivIdentif());
    	detArchConciDet.save();    	  
    	  
    	
        dataset.next();
    }
      
    IDataSet ds = getDataSetNuevoRegCupon();
    cargarRegCupon(ds, detArchConciDet);
    writeCliente(ds);
      
  }
  
	private IDataSet getDataSetNuevoRegCupon() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetNuevoCuponTARJETA");
		dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tar_info_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_operacion", Field.STRING, 20));
		dataset.fieldDef(new Field("fec_present", Field.DATE, 0));
		dataset.fieldDef(new Field("lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_pago", Field.DATE, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_origen", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_comprobante", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("plan", Field.STRING, 5));
		dataset.fieldDef(new Field("cuota", Field.STRING, 2));
		dataset.fieldDef(new Field("moneda", Field.STRING, 10));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comercio", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_cupon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_tarjeta", Field.STRING, 10));
		dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_conciliado", Field.DATE, 0));
		dataset.fieldDef(new Field("tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("marcar_preconci", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("pre_conci", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_conci_aut", Field.INTEGER, 0));
		dataset.fieldDef(new Field("preconci_dudoso", Field.BOOLEAN, 0));		
		return dataset;
	}
	
	private void cargarRegCupon(IDataSet dataset, DetTarConciEnt aDetTarConciEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tar_info_det", aDetTarConciEnt.getOIDInteger());
		if (aDetTarConciEnt.getTar_info_cab()!=null)
			dataset.fieldValue("oid_tar_info_cab", aDetTarConciEnt.getTar_info_cab().getOIDInteger());
		else
			dataset.fieldValue("oid_tar_info_cab", "");
		dataset.fieldValue("oid_empresa", aDetTarConciEnt.getEmpresa().getOIDInteger());
		dataset.fieldValue("tipo_operacion", aDetTarConciEnt.getTipo_operacion());
		dataset.fieldValue("fec_present", aDetTarConciEnt.getFec_present());
		dataset.fieldValue("lote", aDetTarConciEnt.getLote());
		dataset.fieldValue("fec_pago", aDetTarConciEnt.getFec_pago());
		dataset.fieldValue("descripcion", aDetTarConciEnt.getDescripcion());
		dataset.fieldValue("fec_origen", aDetTarConciEnt.getFec_origen());
		dataset.fieldValue("nro_comprobante", aDetTarConciEnt.getNro_comprobante());
		dataset.fieldValue("nro_tarjeta", aDetTarConciEnt.getNro_tarjeta());
		dataset.fieldValue("plan", aDetTarConciEnt.getPlan());
		dataset.fieldValue("cuota", aDetTarConciEnt.getCuota());
		dataset.fieldValue("moneda", aDetTarConciEnt.getMoneda());
		dataset.fieldValue("importe", aDetTarConciEnt.getImporte());
		dataset.fieldValue("comercio", aDetTarConciEnt.getComercio());
		dataset.fieldValue("nro_cupon", aDetTarConciEnt.getNro_cupon());
		dataset.fieldValue("tipo_tarjeta", aDetTarConciEnt.getTipoTarjeta());
		dataset.fieldValue("conciliado", aDetTarConciEnt.isConciliado());
		dataset.fieldValue("fec_conciliado", aDetTarConciEnt.getFecConciliado());
		dataset.fieldValue("tarjeta", aDetTarConciEnt.getTarjeta());
		dataset.fieldValue("activo", aDetTarConciEnt.isActivo());
		dataset.fieldValue("marcar_preconci", aDetTarConciEnt.isMarcarPreconci());
		dataset.fieldValue("nro_conciliacion", aDetTarConciEnt.getNroConciliacion());
		dataset.fieldValue("pre_conci", aDetTarConciEnt.isPreConciliado());
		dataset.fieldValue("fec_preconci", aDetTarConciEnt.getFecPreconci());
		if (aDetTarConciEnt.getCabConciAut()!=null)
			dataset.fieldValue("nro_conci_aut", aDetTarConciEnt.getCabConciAut().getOIDInteger());
		else
			dataset.fieldValue("nro_conci_aut", "");
		dataset.fieldValue("preconci_dudoso", aDetTarConciEnt.isPreconciDudoso());
	}	
	
  
}
