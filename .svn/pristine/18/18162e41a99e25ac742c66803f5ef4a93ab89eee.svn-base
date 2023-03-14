package com.srn.erp.bancos.op;

import java.util.Iterator;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.bancos.bm.NotaBancariaDet;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerNotasBancaria extends Operation {

  public TraerNotasBancaria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oid = mapaDatos.getInteger("oid");
		NotaBancaria notaBancaria = NotaBancaria.findByOid(oid, getSesion());
		
		IDataSet dsNotaCab = this.getDSNotaCab();
		IDataSet dsNotaDet = this.getDSNotaDet();
		IDataSet dsTalonarios = this.getDataSetTalonarios();
		
		cargarTalonario(dsTalonarios,notaBancaria.getTalonario());
		cargarNotaCab(dsNotaCab,notaBancaria);
		
		Iterator iterDetalles = 
			notaBancaria.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			NotaBancariaDet notaBancariaDet = (NotaBancariaDet) iterDetalles.next();
			cargarNotaDet(dsNotaDet,notaBancariaDet);
		}
		
		writeCliente(dsTalonarios);
		writeCliente(dsNotaCab);
		writeCliente(dsNotaDet);
  }
  
  private void cargarNotaCab(IDataSet ds,NotaBancaria nota) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_nota_bancaria", nota.getOIDInteger());
  	ds.fieldValue("fecha", nota.getEmision());
  	ds.fieldValue("oid_cta_bancaria", nota.getCuenta_bancaria().getOIDInteger());
  	ds.fieldValue("cod_cta_bancaria",nota.getCuenta_bancaria().getCodigo());
  	ds.fieldValue("desc_cta_bancaria",nota.getCuenta_bancaria().getDescripcion());
  	ds.fieldValue("oid_moneda", nota.getMoneda_cta().getOIDInteger());
  	ds.fieldValue("cotizacion", nota.getCotizacion());
  	ds.fieldValue("oid_tc", nota.getTipoCompro().getOIDInteger());
  	ds.fieldValue("cod_tc", nota.getTipoCompro().getCodigo());
  	ds.fieldValue("letra", nota.getLetra());
  	ds.fieldValue("oid_lug_emi", nota.getLugarEmision().getOIDInteger());
  	ds.fieldValue("lug_emi", nota.getLugarEmision().getLugemi());
  	ds.fieldValue("nro_ext",nota.getNroExt());
  	ds.fieldValue("oid_talonario", nota.getTalonario().getOIDInteger());
  	ds.fieldValue("cod_moneda", nota.getMoneda_cta().getCodigo());
  	ds.fieldValue("comentario", nota.getComentario());
  	ds.fieldValue("activo", nota.isActivo());
  	ds.fieldValue("tot_mon_cta", nota.getTot_mon_cta());
  	
  }
  
  
  private IDataSet getDSNotaCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TNotaBancaria");
    dataset.fieldDef(new Field("oid_nota_bancaria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_cta_bancaria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cta_bancaria", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cta_bancaria", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tot_mon_cta", Field.CURRENCY, 0));
    return dataset;
  }
  
  
  private IDataSet getDSNotaDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TNotaBancariaDet");
    dataset.fieldDef(new Field("oid_nd_nc_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_nc_nd",Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("debe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_ai",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_imp",Field.STRING, 100));
    dataset.fieldDef(new Field("desc_ana_imp",Field.STRING, 255));
    return dataset;
  }
  
  private void cargarNotaDet(IDataSet ds,NotaBancariaDet notaDet) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_nd_nc_det", notaDet.getOIDInteger());
  	ds.fieldValue("oid_nc_nd", notaDet.getNota_bancaria().getOIDInteger());
  	ds.fieldValue("secu", notaDet.getOIDInteger());
  	ds.fieldValue("debe",notaDet.getDebe());
  	ds.fieldValue("haber",notaDet.getHaber());
  	ds.fieldValue("comentario",notaDet.getComentario());
  	ds.fieldValue("oid_ai", notaDet.getCuenta_imputable().getOIDInteger());
  	ds.fieldValue("codigo_ana_imp", notaDet.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
  	ds.fieldValue("desc_ana_imp", notaDet.getCuenta_imputable().getDescCuentaMasDescValCompo());
  }
  

  private IDataSet getDataSetTalonarios() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonarios");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }
  
  private void cargarTalonario(IDataSet ds,Talonario talonario) throws BaseException {
  	ds.append();  	
  	ds.fieldValue("oid_talonario", talonario.getOIDInteger());
  	ds.fieldValue("codigo", talonario.getCodigo());
  	ds.fieldValue("descripcion", talonario.getDescripcion());
  }
  
}
