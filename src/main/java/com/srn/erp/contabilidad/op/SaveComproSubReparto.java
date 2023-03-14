package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproSubReparto;
import com.srn.erp.contabilidad.bm.SubReparto;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveComproSubReparto extends Operation {

  public SaveComproSubReparto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEjecucionSubReparto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {    	  
    	ComproSubReparto comproSubReparto =
    		ComproSubReparto.findByOid(dataset.getInteger("oid_cco_subreparto"), this.getSesion());
    	
    	Talonario talonario = ComproSubReparto.getTalonarioDefaultSubRep(this.getSesion());
    	comproSubReparto.setTalonario(talonario);
    	comproSubReparto.setContabiliza(true);
    	comproSubReparto.setEmision(Fecha.getFechaActual());
    	comproSubReparto.setImputac(dataset.getDate("fec_imputacion"));
    	comproSubReparto.setTipoCompro(talonario.getTipo_comprobante());
    	comproSubReparto.setLetra(talonario.getLetra());
    	comproSubReparto.setLugarEmision(talonario.getLugar_emision());
    	comproSubReparto.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	comproSubReparto.setComentario("");
    	comproSubReparto.setFec_desde(dataset.getDate("fec_desde"));
    	comproSubReparto.setFec_hasta(dataset.getDate("fec_hasta"));
    	SubReparto subReparto = 
    		SubReparto.findByOidProxy(dataset.getInteger("oid_subreparto"), this.getSesion());
    	comproSubReparto.setDesc_ejecucion("Del "+Fecha.getddmmyyyy(dataset.getDate("fec_desde"))+" al "+Fecha.getddmmyyyy(dataset.getDate("fec_hasta"))+" - Sub.: "+subReparto.getCodigo());
    	comproSubReparto.setSubReparto(SubReparto.findByOidProxy(dataset.getInteger("oid_subreparto"), this.getSesion()));
    	comproSubReparto.setImputac(dataset.getDate("fec_imputacion"));
    	comproSubReparto.setActivo(dataset.getBoolean("activo"));
    	if (!comproSubReparto.isActivo())
    		comproSubReparto.delete();
    	
        addTransaccion(comproSubReparto);
        dataset.next();
    }
  }

}
