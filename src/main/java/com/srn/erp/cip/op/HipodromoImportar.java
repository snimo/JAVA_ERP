package com.srn.erp.cip.op;

import java.sql.Connection;
import java.sql.SQLException;

import com.srn.erp.cip.bm.HipoImpotacionManager;
import com.srn.erp.cip.bm.LogImpDatosCIP;
import com.srn.erp.cip.bm.SemaforoImpAllHipo;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class HipodromoImportar extends Operation {

	//com.microsoft.sqlserver.jdbc.SQLServerXADataSource dataSource = new com.microsoft.sqlserver.jdbc.SQLServerXADataSource();

	public HipodromoImportar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		boolean seEjecuto = false;
		boolean huboError = false;
		String motivoNoEjecuto = "";
		String motivoError = "";
		String observacion = "";
		
		
		if (SemaforoImpAllHipo.getSemaforo().estaImportando()) {
			
			LogImpDatosCIP.insLogs(LogImpDatosCIP.TIPO_IMP_HIP, 
					               seEjecuto, huboError, motivoNoEjecuto, 
					               "Ejecución Manual por "+Usuario.findByOid(this.getSesion().getLogin().getUsuario().getOID(), this.getSesion()).getLogin(),motivoError, this.getSesion());
			
			throw new ExceptionValidation("El proceso no puede ejecutarse porque ya se encuentra en ejecución.");
		}
		
		seEjecuto = true;
		
		SemaforoImpAllHipo.getSemaforo().bloquear();

		try {

			try {
				
				HipoImpotacionManager hipoImportacionManager = new HipoImpotacionManager();
				hipoImportacionManager.setSesion(this.getSesion());
				
				Connection conexion = hipoImportacionManager.conectarSQLServer();
				
				try {
					
					hipoImportacionManager.importarDatosLegajos(null,conexion);
					hipoImportacionManager.actualizarNovedadesLegajo(null);
					
					observacion = observacion + " Legajos ";
					
					hipoImportacionManager.importarDatosPlanifRotas(null,true,conexion);
					hipoImportacionManager.actualizarNovedadesPlanifRotas(null,true);
					
					observacion = observacion + " Rotas ";
					
				} finally {
					hipoImportacionManager.cerrarConexionPayroll(conexion);
					hipoImportacionManager = null;
					try {
						this.getSesion().getConexionBD().commit();
					} catch (SQLException e) {
						try {
							this.getSesion().getConexionBD().rollback();
						} catch (SQLException e1) {
						// 	TODO Auto-generated catch block
						}

					}
					
					try {
						conexion.close();
						conexion = null;
					} 
					catch(Exception e) 
					{						
					};
					
					
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

		if (mapaDatos.containsKey("mostrar_errores"))
			if (huboError)
				throw new ExceptionValidation(null,observacion+"."+motivoError);
		

	}

}
