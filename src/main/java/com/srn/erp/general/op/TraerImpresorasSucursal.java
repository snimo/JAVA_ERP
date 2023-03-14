package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.TipoImpresora;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerImpresorasSucursal extends Operation {

  public TraerImpresorasSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsImpresora = getDataSetImpresoras();
  	String tipoImpresora = mapaDatos.getString("tipo_impresora");
  	
  	if (tipoImpresora.equals(TipoImpresora.COMUN)) 
  		traerImpresorasComunes(dsImpresora);
  	else
  		traerImpresorasFiscales(dsImpresora);
    writeCliente(dsImpresora);
  }
  
  private void traerImpresorasComunes(IDataSet dsImpresoras) throws BaseException {
  	Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),getSesion());
  	Iterator iterImpresoras = ImpresoraComun.getImpresoras(sucursal,getSesion()).iterator();
  	while (iterImpresoras.hasNext()) {
  		ImpresoraComun impresoraComun = (ImpresoraComun) iterImpresoras.next();
  		cargarRegistroImpresora(dsImpresoras,impresoraComun.getOIDInteger(),impresoraComun.getImpresora_sistema(),impresoraComun.getDescripcion());
  	}
  }

  private void traerImpresorasFiscales(IDataSet dsImpresoras) throws BaseException {
  	Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),getSesion());
  	Iterator iterImpresoras = ImpresoraFiscal.getImpresoras(sucursal,getSesion()).iterator();
  	while (iterImpresoras.hasNext()) {
  		ImpresoraFiscal impresoraFiscal = (ImpresoraFiscal) iterImpresoras.next();
  		cargarRegistroImpresora(dsImpresoras,impresoraFiscal.getOIDInteger(),impresoraFiscal.getCompo_imp_fiscal(),impresoraFiscal.getDescripcion());
  	}
  }
  
  private IDataSet getDataSetImpresoras() {
    IDataSet dataset = new TDataSet();
    dataset.create("TImpresoras");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 255));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistroImpresora(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
