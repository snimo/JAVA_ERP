package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormaPagoVtas extends Operation {

  public TraerFormaPagoVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet ds = this.getDataSetFormaPagoVtas();
  	
  	Empresa empresa = Empresa.findByOidProxy(this.getSesion().getLogin().getOidEmpresa(),this.getSesion());
  	Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),this.getSesion());
  	Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),this.getSesion());
  	
  	Iterator iterCondPago = CondicionPago.getCondicionesDePago(this.getSesion(),empresa,sucursal,usuario).iterator();
  	while (iterCondPago.hasNext()) {
  		CondicionPago condPago = (CondicionPago)(iterCondPago.next());
  		cargarFormaPago(ds,condPago);
  	}
  	
  	writeCliente(ds);
  }

  private IDataSet getDataSetFormaPagoVtas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFormaPagoVtas");
    dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarFormaPago(IDataSet dataset,
                               CondicionPago condPago) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_forma_pago", condPago.getOIDInteger());
    dataset.fieldValue("codigo", condPago.getCodigo());
    dataset.fieldValue("descripcion", condPago.getDescripcion());
    dataset.fieldValue("activo", condPago.isActivo());
  }
}
