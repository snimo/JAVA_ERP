package com.srn.erp.impuestos.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.impuestos.bm.LiberacionImpuestoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBLiberacionImpuestoSujeto extends DBObjetoPersistente {

	public static final String	OID_LIB_IMPU						= "oid_lib_impu";

	public static final String	OID_SUJETO							= "oid_sujeto";

	public static final String	FEC_VIG_DESDE						= "fec_vig_desde";

	public static final String	FEC_VIG_HASTA						= "fec_vig_hasta";

	public static final String	PORC_LIB								= "porc_lib";

	public static final String	NUEVO_PORC							= "nuevo_porc";

	public static final String	TIPO_IMPUESTO						= "tipo_impuesto";

	public static final String	ACTIVO									= "activo";

	public static final int			SELECT_BY_SUJETO				= 100;

	public static final int			SELECT_BY_SUJETO_FECHA	= 101;

	public DBLiberacionImpuestoSujeto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LIB_IMPU = 1;
		final int OID_SUJETO = 2;
		final int FEC_VIG_DESDE = 3;
		final int FEC_VIG_HASTA = 4;
		final int PORC_LIB = 5;
		final int NUEVO_PORC = 6;
		final int TIPO_IMPUESTO = 7;
		final int ACTIVO = 8;

		LiberacionImpuestoSujeto pers = (LiberacionImpuestoSujeto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veLibImpuSuj " + " ( " + "OID_LIB_IMPU," + "OID_SUJETO," + "FEC_VIG_DESDE,"
				+ "FEC_VIG_HASTA," + "PORC_LIB," + "NUEVO_PORC," + "TIPO_IMPUESTO," + "ACTIVO)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LIB_IMPU, pers.getOID());
		qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qInsert.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde().getTime()));
		qInsert.setDate(FEC_VIG_HASTA, new Date(pers.getFec_vig_hasta().getTime()));
		if (pers.getPorc_lib() != null)
			qInsert.setDouble(PORC_LIB, pers.getPorc_lib().doubleValue());
		else
			qInsert.setDouble(PORC_LIB, 0);
		if (pers.getNuevo_porc() != null)
			qInsert.setDouble(NUEVO_PORC, pers.getNuevo_porc().doubleValue());
		else
			qInsert.setDouble(NUEVO_PORC, 0);
		qInsert.setString(TIPO_IMPUESTO, pers.getTipo_impuesto());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SUJETO = 1;
		final int FEC_VIG_DESDE = 2;
		final int FEC_VIG_HASTA = 3;
		final int PORC_LIB = 4;
		final int NUEVO_PORC = 5;
		final int TIPO_IMPUESTO = 6;
		final int ACTIVO = 7;
		final int OID_LIB_IMPU = 8;

		LiberacionImpuestoSujeto pers = (LiberacionImpuestoSujeto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veLibImpuSuj set " + "oid_sujeto=?" + ",fec_vig_desde=?" + ",fec_vig_hasta=?"
				+ ",porc_lib=?" + ",nuevo_porc=?" + ",tipo_impuesto=?" + ",activo=?" + " where " + " oid_lib_impu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LIB_IMPU, pers.getOID());
		qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qUpdate.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde().getTime()));
		qUpdate.setDate(FEC_VIG_HASTA, new Date(pers.getFec_vig_hasta().getTime()));
		if (pers.getPorc_lib() != null)
			qUpdate.setDouble(PORC_LIB, pers.getPorc_lib().doubleValue());
		else
			qUpdate.setDouble(PORC_LIB, 0);
		if (pers.getNuevo_porc() != null)
			qUpdate.setDouble(NUEVO_PORC, pers.getNuevo_porc().doubleValue());
		else
			qUpdate.setDouble(NUEVO_PORC, 0);
		qUpdate.setString(TIPO_IMPUESTO, pers.getTipo_impuesto());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LIB_IMPU = 1;
		LiberacionImpuestoSujeto pers = (LiberacionImpuestoSujeto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from veLibImpuSuj " + " where oid_lib_impu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LIB_IMPU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LIB_IMPU = 1;
		LiberacionImpuestoSujeto pers = (LiberacionImpuestoSujeto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veLibImpuSuj " + " set activo=1 " + " where " + " oid_lib_impu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LIB_IMPU, pers.getOID());
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
		case SELECT_BY_SUJETO: {
			ps = this.selectBySujeto(aCondiciones);
			break;
		}
		case SELECT_BY_SUJETO_FECHA: {
			ps = this.selectBySujetoFecha(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LIB_IMPU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veLibImpuSuj ");
		textSQL.append(" WHERE oid_lib_impu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LIB_IMPU, oid);
		return querySelect;
	}

	private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veLibImpuSuj ");
		textSQL.append(" WHERE oid_sujeto = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Sujeto sujeto = (Sujeto) aCondiciones;
		querySelect.setInt(1, sujeto.getOID());
		return querySelect;
	}

	private PreparedStatement selectBySujetoFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA"); 
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veLibImpuSuj ");
		textSQL.append(" WHERE oid_sujeto = ? and fec_vig_desde>=? and fec_vig_hasta<=? and activo=1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, sujeto.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		querySelect.setDate(3, new Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veLibImpuSuj ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_lib_impu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veLibImpuSuj");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getLiberacionesSujeto(Sujeto sujeto, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(LiberacionImpuestoSujeto.NICKNAME,
				DBLiberacionImpuestoSujeto.SELECT_BY_SUJETO, sujeto, new ListObserver(), aSesion);
	}
	
  public static LiberacionImpuestoSujeto getLiberacionImpuestoSujeto(
  		Sujeto sujeto,
  		java.util.Date fecha,
      ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(Sujeto.NICKNAME,sujeto);
  	condiciones.put("FECHA",fecha);
  	return (LiberacionImpuestoSujeto) ObjetoLogico.getObjects(LiberacionImpuestoSujeto.NICKNAME,
	  				DBLiberacionImpuestoSujeto.SELECT_BY_SUJETO_FECHA,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
	

}
