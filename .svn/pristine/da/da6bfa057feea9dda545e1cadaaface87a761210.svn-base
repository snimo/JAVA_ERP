package com.srn.erp.general.op;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.ComprobanteImpreso;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVersionActualImpresion extends Operation {

  public TraerVersionActualImpresion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidCCO = mapaDatos.getInteger("oid_cco");
	ComproCab comprobante = ComproCab.findByOidProxyCompro(oidCCO, this.getSesion());
	
	IDataSet ds = this.getDataSetVersionExterna();
	if (comprobante.getComprobanteImpreso()!=null)
		cargar(ds, comprobante.getComprobanteImpreso());
	writeCliente(ds);
	
  }

  private IDataSet getDataSetVersionExterna() {
    IDataSet dataset = new TDataSet();
    dataset.create("TVersionActual");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_version", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("hora", Field.STRING, 5));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nom_y_ape", Field.STRING, 100));
    dataset.fieldDef(new Field("codigo_usuario", Field.STRING, 100));
    dataset.fieldDef(new Field("congelada", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargar(IDataSet dataset,
                         ComprobanteImpreso comproImpreso) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco", comproImpreso.getOIDInteger());
    dataset.fieldValue("nro_version", comproImpreso.getVersion_externa());
    dataset.fieldValue("fecha", comproImpreso.getVersion_fecha());
    dataset.fieldValue("hora", comproImpreso.getVersion_hora());
    dataset.fieldValue("oid_usuario", comproImpreso.getVersion_usu());
    if ((comproImpreso.getVersion_usu()!=null) && (comproImpreso.getVersion_usu().intValue()!=0)) {
    	dataset.fieldValue("nom_y_ape", Usuario.findByOid(comproImpreso.getVersion_usu(), this.getSesion()).getApellidoyNombre());
    	dataset.fieldValue("codigo_usuario", Usuario.findByOid(comproImpreso.getVersion_usu(), this.getSesion()).getLogin());
    }
    else {
    	dataset.fieldValue("nom_y_ape", "");
    	dataset.fieldValue("codigo_usuario", "");
    }
    dataset.fieldValue("congelada", comproImpreso.isVersionCongelada());
    
  }
}
