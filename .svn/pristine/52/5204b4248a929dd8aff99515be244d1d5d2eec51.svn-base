package com.srn.erp.cip.op;

import java.sql.Connection;
import java.sql.SQLException;

import com.srn.erp.cip.bm.HipoImpotacionManager;
import com.srn.erp.cip.bm.LogImpDatosCIP;
import com.srn.erp.cip.bm.SemaforoImpAllHipo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ActuNovedadCASLeg extends Operation { 

  public ActuNovedadCASLeg() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
		boolean seEjecuto = false;
		boolean huboError = false;
		String motivoNoEjecuto = "";
		String motivoError = "";
		String observacion = "";
		
		if (SemaforoImpAllHipo.getSemaforo().estaImportando()) {

			throw new ExceptionValidation(null,"Por el momento no se puede ejecutar la actualizción. Reintente nuevamente en unos segundos.");
			
		}

		
		SemaforoImpAllHipo.getSemaforo().bloquear();
		
		
		String legajo = mapaDatos.getString("legajo");
		
		seEjecuto = true;
		
		try {

			try {
				
				HipoImpotacionManager hipoImportacionManager = new HipoImpotacionManager();
				hipoImportacionManager.setSesion(this.getSesion());
				
				Connection conexion = hipoImportacionManager.conectarSQLServer();
				
				try {
					
					hipoImportacionManager.importarDatosLegajos(legajo,conexion);
					hipoImportacionManager.actualizarNovedadesLegajo(legajo);
					
					observacion = observacion + " Legajos ";
					
					hipoImportacionManager.importarDatosPlanifRotas(legajo,false,conexion);
					hipoImportacionManager.actualizarNovedadesPlanifRotas(legajo,false);
					
					observacion = observacion + " Rotas ";
					
				} finally {
					hipoImportacionManager.cerrarConexionPayroll(conexion);
					try {
						this.getSesion().getConexionBD().commit();
					} catch (SQLException e) {
						try {
							this.getSesion().getConexionBD().rollback();
						} catch (SQLException e1) {
						// 	TODO Auto-generated catch block
						}

					}
					
				}
			} catch (Exception e) {
				huboError = true;
				motivoError = e.getMessage();
			}
			
			
		} finally {
			
			SemaforoImpAllHipo.getSemaforo().Desbloquear();
			
			if (observacion.length()!=0) {
				observacion = "Se importaron "+ observacion;
			} else {
				observacion = "No se importaron datos";
			}
			
			LogImpDatosCIP.insLogs(LogImpDatosCIP.TIPO_IMP_HIP, 
		               			   seEjecuto, 
		               			   huboError, 
		               			   motivoNoEjecuto, 
		               			   observacion,
		               			   motivoError, 
		               			   this.getSesion());
			
		}

		
	  
  } 

  
}
