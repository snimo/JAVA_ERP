package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.DifImporteExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDifImporteExcluido extends DBObjetoPersistente {

	public static final String OID_DIF_IMPORTE = "oid_dif_importe";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String FECHA = "fecha";
	public static final String OID_MOT_DIF_IMP = "oid_mot_dif_imp";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String MONTO = "monto";
	public static final String OBSERVACION = "observacion";
	public static final String ORDEN = "orden";
	public static final String ACTIVO = "activo";
	public static final String OID_PREDIO = "oid_predio";
	
	public static final int SELECT_BY_INDIVIDUO = 100;

	public DBDifImporteExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_DIF_IMPORTE = 1;
		final int OID_INDIVIDUO = 2;
		final int FECHA = 3;
		final int OID_MOT_DIF_IMP = 4;
		final int OID_MONEDA = 5;
		final int MONTO = 6;
		final int OBSERVACION = 7;
		final int ORDEN = 8;
		final int ACTIVO = 9;
		final int OID_PREDIO = 10;

		DifImporteExcluido pers = (DifImporteExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excDifImportes " + " ( " + "OID_DIF_IMPORTE," + "OID_INDIVIDUO," + "FECHA," + "OID_MOT_DIF_IMP,"
				+ "OID_MONEDA," + "MONTO," + "OBSERVACION," + "ORDEN," + "ACTIVO , OID_PREDIO)" + " values " + "(" + "?,"+ "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DIF_IMPORTE, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		if (pers.getMotivo() != null)
			qInsert.setInt(OID_MOT_DIF_IMP, pers.getMotivo().getOID());
		else
			qInsert.setNull(OID_MOT_DIF_IMP, java.sql.Types.INTEGER);
		if (pers.getMoneda() != null)
			qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		else
			qInsert.setNull(OID_MONEDA, java.sql.Types.INTEGER);
		if (pers.getMonto()!=null)
			qInsert.setDouble(MONTO, pers.getMonto().doubleValue());
		else
			qInsert.setNull(MONTO, java.sql.Types.DOUBLE);
		if (pers.getObservacion()!=null)
			qInsert.setString(OBSERVACION, pers.getObservacion());
		else
			qInsert.setString(OBSERVACION, "");
		if (pers.getOrden()!=null)
			qInsert.setInt(ORDEN, pers.getOrden().intValue());
		else
			qInsert.setInt(ORDEN, 1);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		
		if (pers.getPredioExcluido()!=null)
			qInsert.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qInsert.setInt(OID_PREDIO, java.sql.Types.INTEGER);		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int FECHA = 2;
		final int OID_MOT_DIF_IMP = 3;
		final int OID_MONEDA = 4;
		final int MONTO = 5;
		final int OBSERVACION = 6;
		final int ORDEN = 7;
		final int ACTIVO = 8;
		final int OID_PREDIO = 9;
		final int OID_DIF_IMPORTE = 10;

		DifImporteExcluido pers = (DifImporteExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excDifImportes set " + "oid_individuo=?" + ",fecha=?" + ",oid_mot_dif_imp=?" + ",oid_moneda=?"
				+ ",monto=?" + ",observacion=?" + ",orden=?" + ",activo=? , oid_predio=? " + " where " + " oid_dif_importe=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIF_IMPORTE, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.DATE);
		if (pers.getMotivo() != null)
			qUpdate.setInt(OID_MOT_DIF_IMP, pers.getMotivo().getOID());
		else
			qUpdate.setNull(OID_MOT_DIF_IMP, java.sql.Types.INTEGER);
		if (pers.getMoneda() != null)
			qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		else
			qUpdate.setNull(OID_MONEDA, java.sql.Types.INTEGER);
		if (pers.getMonto()!=null)
			qUpdate.setDouble(MONTO, pers.getMonto().doubleValue());
		else
			qUpdate.setNull(MONTO, java.sql.Types.DOUBLE);
		if (pers.getObservacion()!=null)
			qUpdate.setString(OBSERVACION, pers.getObservacion());
		else
			qUpdate.setString(OBSERVACION, "");
		if (pers.getOrden()!=null)
			qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		else
			qUpdate.setInt(ORDEN, 1);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		
		if (pers.getPredioExcluido()!=null)
			qUpdate.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qUpdate.setInt(OID_PREDIO, java.sql.Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DIF_IMPORTE = 1;
		DifImporteExcluido pers = (DifImporteExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excDifImportes " + " set activo=0 " + " where " + " oid_dif_importe=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIF_IMPORTE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DIF_IMPORTE = 1;
		DifImporteExcluido pers = (DifImporteExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excDifImportes " + " set activo=1 " + " where " + " oid_dif_importe=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIF_IMPORTE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_INDIVIDUO: {
			ps = this.selectByIndividuo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DIF_IMPORTE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excDifImportes ");
		textSQL.append(" WHERE oid_dif_importe = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DIF_IMPORTE, oid);
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excDifImportes ");
		textSQL.append(" WHERE activo = 1 and oid_individuo=? ");
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excDifImportes ");
		textSQL.append(" WHERE oid_individuo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_dif_importe oid,oid_individuo codigo, fecha descripcion ,activo ");
		textSQL.append(" from excDifImportes");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getDifImportesExcluidos(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(DifImporteExcluido.NICKNAME, DBDifImporteExcluido.SELECT_BY_INDIVIDUO, individuo,
				new ListObserver(), aSesion);
	}
	

}
