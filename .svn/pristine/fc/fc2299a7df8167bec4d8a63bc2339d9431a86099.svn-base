package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ventas.bm.EsquemaBonificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaBonificacion extends DBObjetoPersistente {

	public static final String OID_ESQ_BONIF = "oid_esq_bonif";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String FEC_VIG_DESDE = "fec_vig_desde";

	public static final String OID_CLASIF_ENT = "oid_clasif_ent";

	public static final String FEC_VIG_HASTA = "fec_vig_hasta";

	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ESQUEMA_VIG_A_FECHA = 100;

	public DBEsquemaBonificacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ESQ_BONIF = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int FEC_VIG_DESDE = 4;
		final int OID_CLASIF_ENT = 5;
		final int FEC_VIG_HASTA = 6;
		final int ACTIVO = 7;

		EsquemaBonificacion pers = (EsquemaBonificacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veEsquemaBonif " + " ( "
				+ "OID_ESQ_BONIF," + "CODIGO," + "DESCRIPCION,"
				+ "FEC_VIG_DESDE," + "OID_CLASIF_ENT," + "FEC_VIG_HASTA,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_BONIF, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde()
				.getTime()));
		qInsert.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		qInsert.setDate(FEC_VIG_HASTA, new Date(pers.getFec_vig_hasta()
				.getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int FEC_VIG_DESDE = 3;
		final int OID_CLASIF_ENT = 4;
		final int FEC_VIG_HASTA = 5;
		final int ACTIVO = 6;
		final int OID_ESQ_BONIF = 7;

		EsquemaBonificacion pers = (EsquemaBonificacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veEsquemaBonif set " + "codigo=?"
				+ ",descripcion=?" + ",fec_vig_desde=?" + ",oid_clasif_ent=?"
				+ ",fec_vig_hasta=?" + ",activo=?" + " where "
				+ " oid_esq_bonif=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BONIF, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde()
				.getTime()));
		qUpdate.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		qUpdate.setDate(FEC_VIG_HASTA, new Date(pers.getFec_vig_hasta()
				.getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESQ_BONIF = 1;
		EsquemaBonificacion pers = (EsquemaBonificacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veEsquemaBonif " + " set activo=0 "
				+ " where " + " oid_esq_bonif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BONIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESQ_BONIF = 1;
		EsquemaBonificacion pers = (EsquemaBonificacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veEsquemaBonif " + " set activo=1 "
				+ " where " + " oid_esq_bonif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BONIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_ESQUEMA_VIG_A_FECHA: {
			ps = this.selectByEsquemaVigAFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ESQ_BONIF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsquemaBonif ");
		textSQL.append(" WHERE oid_esq_bonif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_BONIF, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsquemaBonif ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByEsquemaVigAFecha(Object aCondiciones)
			throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecha = (java.util.Date) condiciones
				.get("FECHA");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsquemaBonif ");
		textSQL
				.append(" WHERE fec_vig_desde >= ? and fec_vig_hasta <= ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setDate(1, new Date(fecha.getTime()));
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;

	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_esq_bonif oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from veEsquemaBonif");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static EsquemaBonificacion getEsquemaBonificacionVigAFecha(java.util.Date fecha,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("FECHA",fecha);
		  return (EsquemaBonificacion) ObjetoLogico.getObjects(EsquemaBonificacion.NICKNAME,
				  				DBEsquemaBonificacion.SELECT_BY_ESQUEMA_VIG_A_FECHA,
				  				fecha,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	

}
