package com.srn.erp.estadisticaRaciones.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.estadisticaRaciones.bm.EstadisticaRaciones;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstadisticaRaciones extends DBObjetoPersistente {

	public static final String EMPRESA = "EMPRESA";
	public static final String FECHA = "FECHA";
	public static final String TIPO_RACION = "TIPO_RACION";
	public static final String TIPO = "TIPO";
	public static final String CANTIDAD = "CANTIDAD";
	public static final String ANIO = "ANIO";
	public static final String MES = "MES";
	public static final String DIA = "DIA";

	private static final int SELECT_BY_FECHAS = 100;

	public DBEstadisticaRaciones() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
			case SELECT_BY_FECHAS: {
				ps = this.selectAllByFechas(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
		return null;
	}
	
	private PreparedStatement selectAllByFechas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("sELECT * FROM TOTAL_RACIONES where fecha >= ? and fecha <= ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Hashtable<String, Date> param = (Hashtable) aCondiciones;
		querySelect.setDate(1, new java.sql.Date(param.get("FECHA_DESDE").getTime()));
		querySelect.setDate(2, new java.sql.Date(param.get("FECHA_HASTA").getTime()));
		return querySelect;
	}

	public static List getEstadisticaRaciones(Date fechaDesde, Date fechaHasta, ISesion aSesion) throws BaseException {
		Hashtable<String, Date> param = new Hashtable();
		param.put("FECHA_DESDE", fechaDesde);
		param.put("FECHA_HASTA", fechaHasta);

		return (List) ObjetoLogico.getObjects(EstadisticaRaciones.NICKNAME, 
				DBEstadisticaRaciones.SELECT_BY_FECHAS, 
				param, 
				new ListObserver(), 
				aSesion);
	}

}
