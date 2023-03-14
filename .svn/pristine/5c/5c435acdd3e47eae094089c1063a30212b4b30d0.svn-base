package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoComprobante extends Operation {

  public TraerTipoComprobante() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoComprobante tipocomprobante = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipocomprobante = TipoComprobante.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipocomprobante = TipoComprobante.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoComprobante = getDataSetTipoComprobante();
    IDataSet datasetMotivos 		= getDataSetMotivos();    
    
    if (tipocomprobante != null) {
        cargarRegistroTipoComprobante(datasetTipoComprobante,
                         tipocomprobante.getOIDInteger(),
                         tipocomprobante.getTcexterno(),
                         tipocomprobante.getDescripcion(),
                         tipocomprobante.getIdentificacion(),
                         tipocomprobante.getLeyenda().getOIDInteger(),
                         tipocomprobante.getLeyenda().getCodigo(),
                         tipocomprobante.getLeyenda().getDescripcion(),
                         tipocomprobante.isActivo(),
                         tipocomprobante.getCodigoParaCodigoBarra(),
                         tipocomprobante.getDescTituAsiLibroDiario()
                         );
        Iterator iterMotivosTC = tipocomprobante.getMotivosTC().iterator();
        while (iterMotivosTC.hasNext()) {
        	MotivoTC motivoTC = (MotivoTC) iterMotivosTC.next();
        	cargarRegistroMotivo(datasetMotivos,motivoTC);
        }
    }
    writeCliente(datasetTipoComprobante);
    writeCliente(datasetMotivos);
  }

  private IDataSet getDataSetTipoComprobante() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoComprobante");
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tc_ext", Field.STRING, 6));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("identificacion", Field.STRING, 5));
    dataset.fieldDef(new Field("oid_leyenda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_leyenda", Field.STRING, 15));
    dataset.fieldDef(new Field("desc_leyenda", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("codigo_para_cod_barra", Field.STRING, 10));
    dataset.fieldDef(new Field("desc_titu_asi_libro_diario", Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataSetMotivos() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TMotivoTC");
	    dataset.fieldDef(new Field("oid_motivo_tc", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_motivo_compro", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_motivo_compro", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_motivo_compro", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarRegistroMotivo(IDataSet dataset,
		  							MotivoTC motivoTC) throws BaseException {
	    dataset.append();
	    dataset.fieldValue("oid_motivo_tc", motivoTC.getOIDInteger());
	    dataset.fieldValue("oid_motivo_compro", motivoTC.getMotivo_comprobante().getOIDInteger());
	    dataset.fieldValue("cod_motivo_compro", motivoTC.getMotivo_comprobante().getCodigo());
	    dataset.fieldValue("desc_motivo_compro", motivoTC.getMotivo_comprobante().getDescripcion());
	    dataset.fieldValue("oid_tc", motivoTC.getTipo_comprobate().getOIDInteger());
	    dataset.fieldValue("activo", motivoTC.isActivo());
	  
  }
  

  private void cargarRegistroTipoComprobante(IDataSet dataset,
                         Integer oid_tc,
                         String tc_ext,
                         String descripcion,
                         String identificacion,
                         Integer oid_leyenda,
                         String codigoLeyenda,
                         String descLeyenda,
                         Boolean activo,
                         String codigoParaCodBarra,
                         String descTituAsiLibroDiario) {
    dataset.append();
    dataset.fieldValue("oid_tc", oid_tc);
    dataset.fieldValue("tc_ext", tc_ext);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("identificacion", identificacion);
    dataset.fieldValue("oid_leyenda", oid_leyenda);
    dataset.fieldValue("codigo_leyenda", codigoLeyenda);
    dataset.fieldValue("desc_leyenda", descLeyenda);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("codigo_para_cod_barra", codigoParaCodBarra);
    dataset.fieldValue("desc_titu_asi_libro_diario", descTituAsiLibroDiario);
  }
}
