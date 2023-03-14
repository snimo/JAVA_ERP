package com.srn.erp.tesoreria.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Entidad;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.TipoValorCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcLiqTarByTalonario extends Operation {

  public TraerConcLiqTarByTalonario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
 
	Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"),this.getSesion());  
	  
    IDataSet ds = this.getDataSetConcLiqTar();
    IDataSet dsTipoVal = this.getDataSetTipoTarjetas();
    IDataSet dsEntidad = getDataSetEntidades();
    IDataSet dsParamsLiq = getDataSetParamsLiq();
    
    List listConceptos = null;
    List tiposValores = null;
    List entidades = null;
    
    
    
    
    if (talonario.getTipo_comprobante().getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_CREDITO)) {
    	listConceptos = ConceptoLiqTarjeta.getConceptosTarjetasCredito(this.getSesion());
    	tiposValores = TipoValor.getTiposValoresByComportamiento(TipoValorCompo.TV_TARJETA_CREDITO,this.getSesion());
    	entidades = TarjetaCredito.getAllActivos(this.getSesion());
    }
    else if (talonario.getTipo_comprobante().getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_DEBITO)) {
    	listConceptos = ConceptoLiqTarjeta.getConceptosTarjetasDebito(this.getSesion());
    	tiposValores = TipoValor.getTiposValoresByComportamiento(TipoValorCompo.TV_TAR_DEBITO,this.getSesion());
    	entidades = Banco.getAllBancosActivos(this.getSesion());
    }
    
    Iterator iterConceptos = 
    	listConceptos.iterator();
    while (iterConceptos.hasNext()) {
    	ConceptoLiqTarjeta concepto = (ConceptoLiqTarjeta) iterConceptos.next();
    	cargarRegistroConcLiqTar(ds, concepto);
    }

    Iterator iterTiposValores = 
    	tiposValores.iterator();
    while (iterTiposValores.hasNext()) {
    	TipoValor tipoValor = (TipoValor) iterTiposValores.next();
    	cargarRegistroTipoValor(dsTipoVal,tipoValor);
    }
    
    Iterator iterEntidades = 
    	entidades.iterator();
    while (iterEntidades.hasNext()) {
    	IObjetoLogico entidad = (IObjetoLogico) iterEntidades.next();
    	cargarRegistroEntidad(dsEntidad,entidad);
    }
    
    cargarRegistroParamsLiq(dsParamsLiq, talonario.getTipo_comprobante().getIdentificacion());
   
    writeCliente(ds);
    writeCliente(dsTipoVal);
    writeCliente(dsEntidad);
    writeCliente(dsParamsLiq);
    
  }

  private IDataSet getDataSetConcLiqTar() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConcLiqTar");
    dataset.fieldDef(new Field("oid_concepto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_concepto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_concepto", Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataSetTipoTarjetas() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TTiposTarjetas");
	    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
	    return dataset;
  }
  
  private IDataSet getDataSetParamsLiq() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TParamsLiq");
	    dataset.fieldDef(new Field("compor_tipo_compro", Field.STRING, 100));
	    return dataset;
}
  
  
  private IDataSet getDataSetEntidades() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TEntidades");
	    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_entidad", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_entidad", Field.STRING, 100));
	    return dataset;
  }
  
  private void cargarRegistroConcLiqTar(
		  IDataSet ds,
		  ConceptoLiqTarjeta concepto) throws BaseException {
    ds.append();
    ds.fieldValue("oid_concepto", concepto.getOIDInteger());
    ds.fieldValue("cod_concepto", concepto.getCodigo());
    ds.fieldValue("desc_concepto", concepto.getDescripcion());
  }
  
  private void cargarRegistroTipoValor(
		  IDataSet ds,
		  TipoValor tipoValor) throws BaseException {
    ds.append();
    ds.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    ds.fieldValue("cod_tipo_valor", tipoValor.getCodigo());
    ds.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
  }
  
  private void cargarRegistroEntidad(
		  IDataSet ds,
		  IObjetoLogico entidad) throws BaseException {
    ds.append();
    ds.fieldValue("oid_entidad", entidad.getOIDInteger());
    ds.fieldValue("cod_entidad", entidad.getCodigo());
    ds.fieldValue("desc_entidad", entidad.getDescripcion());
  }
  
  private void cargarRegistroParamsLiq(
		  IDataSet ds,
		  String compoTipoValor) throws BaseException {
    ds.append();
    ds.fieldValue("compor_tipo_compro", compoTipoValor);
  }  
  
}
