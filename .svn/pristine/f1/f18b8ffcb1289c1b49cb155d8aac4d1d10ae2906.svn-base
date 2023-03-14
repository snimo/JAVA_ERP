package com.srn.erp.estadisticaRaciones.op;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Date;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveActuResumenEstadRaciones extends Operation {

	public SaveActuResumenEstadRaciones() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		int cantidad = 1;// parametro

		Date fecha = Fecha.getFechaActual();

		for (int i = 0; i < cantidad; i++) {
			
			String fechaEnviar = Fecha.getyyyymmdd(fecha);
			
			fechaEnviar = fechaEnviar.replaceAll("/", "");
			
			CallableStatement cStmt = null;
			try {
				
				cStmt = getSesion().getConexionBD().prepareCall("{call raciones(?)}");
				cStmt.setString(1, fechaEnviar);
				cStmt.execute();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			} finally {

				if (cStmt != null) {
					try {
						cStmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

			fecha = Fecha.getFechaDiaAnterior(fecha);
		}

	}

}
