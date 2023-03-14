package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCuenta extends Operation {

  public SaveCuenta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCuenta");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Cuenta cuenta = Cuenta.findByOid(dataset.getInteger("oid_ana_con"),getSesion());
        cuenta.setOID(dataset.getInteger("oid_ana_con"));
        cuenta.setCodigo(dataset.getString("codigo"));
        cuenta.setDescripcion(dataset.getString("descripcion"));
        cuenta.setEspatrimonial(dataset.getBoolean("es_patrimonial"));
        cuenta.setEsctainterna(dataset.getBoolean("es_cta_interna"));
        cuenta.setEstructura(Estructura.findByOidProxy(dataset.getInteger("oid_estruc"),getSesion()));
        cuenta.setTipocambio(TipoCambio.findByOidProxy(dataset.getInteger("oid_tipo_cambio"),getSesion()));
        cuenta.setIndice(Indice.findByOidProxy(dataset.getInteger("oid_indice"),getSesion()));
        cuenta.setActivo(dataset.getBoolean("activo"));
        cuenta.setSubsistema(dataset.getString("subsistema"));
        cuenta.setEsImpuesto(dataset.getBoolean("es_impuesto"));
        
        // Recorrer los Reportes
        IDataSet dsReportes = dataset.getDataSet("TReportesContables");
        dsReportes.first();
        while (!dsReportes.EOF()) {
        	
        	ReporteContable reporte = ReporteContable.findByOid(dsReportes.getInteger("oid"), this.getSesion());
        	int maxOidTitu = reporte.getMaxOidTituReporte();
        	
        	IDataSet dsReporteDet = dsReportes.getDataSet("TReporteContaDet");
        	dsReporteDet.first();
        	while (!dsReporteDet.EOF()) {
        		
        		// Trabajar a nivel titulo
        		ReporteContableDet repContaDet = 
        			ReporteContableDet.findByOid(dsReporteDet.getInteger("secu"), this.getSesion());
        		if (dsReporteDet.getString("tipo_valor_compo").equals("INCLUIR"))
        			repContaDet.setTipo(ReporteContableDet.TIPO_COMPO);
        		else if (dsReporteDet.getString("tipo_valor_compo").equals("EXCLUIR"))
        				repContaDet.setTipo(ReporteContableDet.TIPO_NCOMPO);
        		else if (dsReporteDet.getString("tipo_valor_compo").equals("NO_APLICA"))
        				repContaDet.setTipo(ReporteContableDet.TIPO_CTA);

        		repContaDet.setReporteContable(reporte);
        		repContaDet.setCuenta(cuenta);
        		
        		Integer oidRepContaDet = dsReporteDet.getInteger("oid_rep_conta_det");
        		ReporteContableDet reporteContableDetNuevo = 
        			ReporteContableDet.findByOid(oidRepContaDet, this.getSesion());
        		
        		
        		repContaDet.setOidtitulopadre(reporteContableDetNuevo.getOidtitulo());
        		
        		if (repContaDet.isNew()) {
        			repContaDet.setDesctitulo("");
        			repContaDet.setCodigodesde("");
        			repContaDet.setCodigohasta("");
        			repContaDet.setOrden(new Integer(0));
        			repContaDet.setActivo(new Boolean(true));
        		}
        		++maxOidTitu;
        		repContaDet.setOidtitulo(maxOidTitu);
        		
        		
        		if (dsReporteDet.getBoolean("activo")==false)
        			repContaDet.delete();
        		
        		cuenta.addReporteContableDet(repContaDet);
        		
        		IDataSet dsValRepDet = dsReporteDet.getDataSet("TValoresReporteDet");
        		dsValRepDet.first();
        		while (!dsValRepDet.EOF()) {
        			
        			// Procesar los Valores de Componentes
        			Integer oidComponente =  dsValRepDet.getInteger("oid_componente");
        			
        			Componente compo = 
        				Componente.findByOidProxy(oidComponente, this.getSesion());
        			
        			IObjetoLogico valorCompo = 
        				(IObjetoLogico)compo.getValorCompo(dsValRepDet.getInteger("oid_val_compo"));
        			
        			ReporteContaCompo reporteContaCompo = 
        				repContaDet.getReporteContaCompo(compo);
        			
        			if (reporteContaCompo == null)
        				reporteContaCompo = (ReporteContaCompo) ReporteContaCompo.getNew(ReporteContaCompo.NICKNAME, this.getSesion());
        			reporteContaCompo.setReportecontadet(repContaDet);
        			reporteContaCompo.setComponente(compo);
        			reporteContaCompo.setValorcomponente(valorCompo);
        			
        			if (reporteContaCompo.getValorcomponente() == null)
        				reporteContaCompo.delete();
        			
        			repContaDet.addItemReporte(reporteContaCompo);
        			
        			dsValRepDet.next();
        		}
        		
        		
        		
        		
        		dsReporteDet.next();
        	}
        	
        	
        	
        	
        	dsReportes.next();
        }
        

        addTransaccion(cuenta);
        dataset.next();
    }
  }

}
