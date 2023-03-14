package com.srn.erp.cip.op;

import java.sql.Connection;
import java.sql.SQLException;

import com.srn.erp.cip.bm.HipoImpotacionManager;
import com.srn.erp.cip.bm.LogImpDatosCIP;
import com.srn.erp.cip.bm.SemaforoImpAllHipo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class HipoImportarPlanifRotas extends Operation {

	com.microsoft.sqlserver.jdbc.SQLServerXADataSource dataSource = new com.microsoft.sqlserver.jdbc.SQLServerXADataSource();

	public HipoImportarPlanifRotas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		boolean seEjecuto = false;
		boolean huboError = false;
		String motivoNoEjecuto = "";
		String motivoError = "";
		String observacion = "";
		
		
		if (SemaforoImpAllHipo.getSemaforo().estaImportando()) {
			
			motivoNoEjecuto = "Proceso ya en Ejecución";
			
			LogImpDatosCIP.insLogs(LogImpDatosCIP.TIPO_IMP_HIP, 
					               seEjecuto, huboError, motivoNoEjecuto, 
					               observacion,motivoError, this.getSesion());
			
			return;
		}
		
		seEjecuto = true;
		
		SemaforoImpAllHipo.getSemaforo().bloquear();

		try {

			try {
				
				HipoImpotacionManager hipoImportacionManager = new HipoImpotacionManager();
				hipoImportacionManager.setSesion(this.getSesion());
				
				Connection conexion = hipoImportacionManager.conectarSQLServer();
				
				try {
					
					
					hipoImportacionManager.importarDatosPlanifRotas(null,true,conexion);
					hipoImportacionManager.actualizarNovedadesPlanifRotas(null,true);
					
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
