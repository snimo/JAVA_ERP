package com.srn.erp.general.op;

import com.srn.erp.contabilidad.bm.Leyenda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoComprobante extends Operation {

  public SaveTipoComprobante() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoComprobante");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoComprobante tipocomprobante = TipoComprobante.findByOid(dataset.getInteger("oid_tc"),getSesion());
        tipocomprobante.setOID(dataset.getInteger("oid_tc"));
        tipocomprobante.setTcexterno(dataset.getString("tc_ext"));
        tipocomprobante.setDescripcion(dataset.getString("descripcion"));
        tipocomprobante.setIdentificacion(dataset.getString("identificacion"));
        tipocomprobante.setLeyenda(Leyenda.findByOidProxy(dataset.getInteger("oid_leyenda"),getSesion()));
        tipocomprobante.setActivo(dataset.getBoolean("activo"));
        tipocomprobante.setCodigoParaCodigoBarra(dataset.getString("codigo_para_cod_barra"));
        tipocomprobante.setDescTituAsiLibroDiario(dataset.getString("desc_titu_asi_libro_diario"));
        
        
        IDataSet dsMotivos = dataset.getDataSet("TMotivoTC");
        dsMotivos.first();
        while (!dsMotivos.EOF()) {
        	MotivoTC motivoTC = MotivoTC.findByOid(dsMotivos.getInteger("oid_motivo_tc"),getSesion());
        	motivoTC.setTipo_comprobate(tipocomprobante);
        	motivoTC.setMotivo_comprobante(MotivoComprobante.findByOidProxy(dsMotivos.getInteger("oid_motivo_compro"),getSesion()));
        	motivoTC.setActivo(dsMotivos.getBoolean("activo"));
        	tipocomprobante.addMotivoTC(motivoTC);
        	dsMotivos.next();
        }
        
        addTransaccion(tipocomprobante);
        dataset.next();
    }
  }

}
