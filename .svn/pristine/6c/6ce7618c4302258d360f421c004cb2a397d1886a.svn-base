package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.BaseException;

public class DBFechaCIP extends DBObjetoPersistente {

	@Override
	public PreparedStatement prepararSelect(int select, Object condiciones) throws BaseException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static final int SELECT_FECHA_ACTUAL = 100;

	@Override
	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	public static java.util.Date getFechaActual(ISesion aSesion) throws BaseException {

		java.util.Date fecha = null;
		try {

			StringBuffer textSQL = new StringBuffer();
			if (aSesion.getServicios().getValueParameter("tipoBD").toUpperCase().equals(IPoolBD.ORACLE.toUpperCase()))
				textSQL.append("SELECT sysdate fecha FROM sys.dual ");
			else
				if (aSesion.getServicios().getValueParameter("tipoBD").toUpperCase().equals(IPoolBD.MSSQLServer.toUpperCase()))
					textSQL.append("select getDate() fecha from dual ");				
			
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			ResultSet rs = querySelect.executeQuery();
			if (rs.next())
				fecha = rs.getTimestamp(1);
			rs.close();
			querySelect.close();

			return fecha;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}

	}

}
