package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class IniDetPedParaOC extends Operation {

	
  private Proveedor proveedor = null;
  private PedidoCab pedido = null;
	
  public IniDetPedParaOC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsIniDetPedParaOC = this.getDSIniDetPedParaOC();
	  IDataSet dsItemsPedido = this.getDSTraerItemsPediod();
	
	  cargarDSIniDetPedParaOC(dsIniDetPedParaOC, 
			  				  proveedor, 
			  				  AgrupadorDeposito.getAgruDepoDefaultAnalisisCompras(this.getSesion()), 
			  				  pedido);
	  
	  cargarTraerOpcionesDetPedido(dsItemsPedido);
	  
	  writeCliente(dsIniDetPedParaOC);
	  writeCliente(dsItemsPedido);
	  
  }

  @Override
  public void beforeExecute(MapDatos mapaDatos) throws BaseException {
	// TODO Auto-generated method stub
	super.beforeExecute(mapaDatos);
	
	if (mapaDatos.containsKey("oid_proveedor")) {
		if (mapaDatos.getInteger("oid_proveedor").intValue()>0) 
			proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
		
	}
	
	if ((!mapaDatos.containsKey("oid_cco_ped")) || (mapaDatos.getInteger("oid_cco_ped").intValue()<=0)) 
		throw new ExceptionValidation(null,"Debe ingresar el Nro. de Pedido");
	
	pedido = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco_ped"), this.getSesion());
	
  }

  
  private IDataSet getDSTraerItemsPediod() {
	 IDataSet dataset = new TDataSet();
	 dataset.create("TTraerItemsPedido");
	 dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	 dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	 return dataset;
  }
  
  private void cargarTraerItemsPedido(IDataSet ds,
		  							  int secu,
		  							  String codigo,
		  							  String descripcion) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid", new Integer(secu));
	  ds.fieldValue("codigo", codigo);
	  ds.fieldValue("descripcion", descripcion);
  }
  
  private void cargarTraerOpcionesDetPedido(IDataSet ds) throws BaseException {
	  cargarTraerItemsPedido(ds,1,"TODOS","1-Todos lo detalles del pedido comprables");
	  cargarTraerItemsPedido(ds,2,"PROV","2-Los detalles comprables del Pedido provistos por el proveedor indicado");
  }
  
  
  private IDataSet getDSIniDetPedParaOC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TIniDetPedParaOC");
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_agrupador_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_agrupador_depo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_agrupador_depo", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_exp_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cond_pago", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cond_pago", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_vendedor", Field.STRING, 150));
    dataset.fieldDef(new Field("dom_entrega", Field.MEMO, 0));
    dataset.fieldDef(new Field("tipo_traer", Field.STRING, 10));
    
    
    return dataset;
  }

  private void cargarDSIniDetPedParaOC(
		                 IDataSet dataset,
                         Proveedor proveedor,
                         AgrupadorDeposito agrupadorDeposito,
                         PedidoCab pedido) throws BaseException {
    dataset.append();
    if (proveedor!=null) {
      dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
      dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
      dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
    } else {
        dataset.fieldValue("oid_proveedor", new Integer(0));
        dataset.fieldValue("cod_proveedor", "");
        dataset.fieldValue("rs_proveedor", "");
    }
    dataset.fieldValue("oid_agrupador_depo", agrupadorDeposito.getOIDInteger());
    dataset.fieldValue("cod_agrupador_depo", agrupadorDeposito.getCodigo());
    dataset.fieldValue("desc_agrupador_depo", agrupadorDeposito.getDescripcion());
    dataset.fieldValue("oid_cco_ped", pedido.getOIDInteger());
    dataset.fieldValue("nro_exp_ped", pedido.getNroExt());
    dataset.fieldValue("oid_sujeto", pedido.getSujeto().getOIDInteger());
    dataset.fieldValue("cod_sujeto", pedido.getSujeto().getCodigo());
    dataset.fieldValue("rs_sujeto", pedido.getSujeto().getRazon_social());
    dataset.fieldValue("oid_cond_pago", pedido.getCondicionPago().getOIDInteger());
    dataset.fieldValue("cod_cond_pago", pedido.getCondicionPago().getCodigo());
    dataset.fieldValue("desc_cond_pago", pedido.getCondicionPago().getDescripcion());
    if (pedido.getVendedor()!=null) {
      dataset.fieldValue("oid_vendedor", pedido.getVendedor().getOIDInteger());
      dataset.fieldValue("cod_vendedor", pedido.getVendedor().getCodigo());
      dataset.fieldValue("rs_vendedor", pedido.getVendedor().getNombreyApellido());
    } else {
      dataset.fieldValue("oid_vendedor", new Integer(0));
      dataset.fieldValue("cod_vendedor", "");
      dataset.fieldValue("rs_vendedor", "");
    }
    if (pedido.getDomicilio_entrega()!=null)
    	dataset.fieldValue("dom_entrega", pedido.getDomicilio_entrega().getDirCompleta());
    else
    	dataset.fieldValue("dom_entrega", "");
    dataset.fieldValue("tipo_traer","TODOS");
    
  }
}
