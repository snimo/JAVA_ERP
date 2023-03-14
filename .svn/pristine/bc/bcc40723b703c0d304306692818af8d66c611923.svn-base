package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.RelacionSujetoTurno;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSujetoTurno extends Operation { 
	
  public SaveSujetoTurno() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	    IDataSet dataset = mapaDatos.getDataSet("TSujetosTurnos"); 
	    procesarRegistros(dataset);	  
  }
  
  private void procesarRegistros(IDataSet dataset) throws BaseException { 
	    dataset.first(); 
	      while (!dataset.EOF()) { 
	        Sujeto sujeto = Sujeto.findByOid(dataset.getInteger("oid_sujeto"),getSesion());
	        sujeto.setCodigo(dataset.getString("codigo"));
	        sujeto.setRazon_social(dataset.getString("descripcion"));
	        sujeto.setCategoriaSujetoTurno(CategoriaSujetoTurno.findByOidProxy(dataset.getInteger("oid_turno_categ"), this.getSesion()));
	        sujeto.setRelacionSujetoTurno(RelacionSujetoTurno.findByOidProxy(dataset.getInteger("oid_turno_relacion"), this.getSesion()));
	        sujeto.setSuspendidoParaTurno(dataset.getBoolean("suspend_para_turno"));
	        sujeto.setFecSuspendidoDesde(dataset.getDate("fec_susp_desde"));
	        sujeto.setFecSuspendidoHasta(dataset.getDate("fec_susp_hasta"));
	        sujeto.setMotivoTurnoSuspension(dataset.getString("motivo_turno_susp"));
	        sujeto.setActivo(dataset.getBoolean("activo"));
	        sujeto.setTipo_documento(TipoDocumento.getTipoDocumentoImportacionSujTurnos(this.getSesion()));
	        sujeto.setFisica_juridica("F");
			sujeto.setDeshabilitarCodigoAutomatico(true);
			sujeto.setEs_cliente(new Boolean(true));
			sujeto.setFecha_ingreso(Fecha.getFechaActual());
	        
	        
	        
	        if (sujeto.isActivo()==false)
	        	sujeto.delete();
	        
	        addTransaccion(sujeto);
	        dataset.next();
	    }
	  }
  

    
}
