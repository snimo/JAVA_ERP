package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotAccInterClasifLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotAccInterClasifLeg extends DBObjetoPersistente {

	public static final String OID_MOT_INT_CLEG = "oid_mot_int_cleg";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String OID_VAL_CLASIF = "oid_val_clasif";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_VALCLASIF_MOTIVO = 100;

	public DBMotAccInterClasifLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_MOT_INT_CLEG = 1;
		final int OID_MOTIVO = 2;
		final int OID_VAL_CLASIF = 3;
		final int ACTIVO = 4;

		MotAccInterClasifLeg pers = (MotAccInterClasifLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipMotEntIntCLeg " + " ( "
				+ "OID_MOT_INT_CLEG," + "OID_MOTIVO," + "OID_VAL_CLASIF,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOT_INT_CLEG, pers.getOID());
		qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qInsert.setInt(OID_VAL_CLASIF, pers.getValorclasificador().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int OID_VAL_CLASIF = 2;
		final int ACTIVO = 3;
		final int OID_MOT_INT_CLEG = 4;

		MotAccInterClasifLeg pers = (MotAccInterClasifLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipMotEntIntCLeg set " + "oid_motivo=?"
				+ ",oid_val_clasif=?" + ",activo=?" + " where "
				+ " oid_mot_int_cleg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_INT_CLEG, pers.getOID());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qUpdate.setInt(OID_VAL_CLASIF, pers.getValorclasificador().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_INT_CLEG = 1;
		MotAccInterClasifLeg pers = (MotAccInterClasifLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotEntIntCLeg " + " set activo=0 "
				+ " where " + " oid_mot_int_cleg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_INT_CLEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_INT_CLEG = 1;
		MotAccInterClasifLeg pers = (MotAccInterClasifLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotEntIntCLeg " + " set activo=1 "
				+ " where " + " oid_mot_int_cleg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_INT_CLEG, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		case SELECT_BY_VALCLASIF_MOTIVO: {
			ps = this.selectByValoClasifMot(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_MOT_INT_CLEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntCLeg ");
		textSQL.append(" WHERE oid_mot_int_cleg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOT_INT_CLEG, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntCLeg ");
		textSQL.append(" WHERE  activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByValoClasifMot(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntCLeg ");
		textSQL.append(" WHERE oid_val_clasif  = ? and oid_motivo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		MotivoEntIntermedias motivo = (MotivoEntIntermedias)condiciones.get(MotivoEntIntermedias.NICKNAME);
		querySelect.setInt(1, valClasifEnt.getOID());
		querySelect.setInt(2, motivo.getOID());
		return querySelect;
	}
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntCLeg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_mot_int_cleg oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotEntIntCLeg");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotAccInterClasifLeg.NICKNAME,
				DBMotAccInterClasifLeg.SELECT_ALL_ACTIVOS, null,
				new ListObserver(), aSesion);
	}
	
	  public static MotAccInterClasifLeg getMotAccInterClasifLeg(ValorClasificadorEntidad valor, MotivoEntIntermedias motivo,
	          ISesion aSesion)
	          throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
  		condiciones.put(ValorClasificadorEntidad.NICKNAME, valor);
  	 	condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
  	 	return (MotAccInterClasifLeg) ObjetoLogico.getObjects(MotAccInterClasifLeg.NICKNAME,
				DBMotAccInterClasifLeg.SELECT_BY_VALCLASIF_MOTIVO,
				condiciones,
				new ObjetoObservado(),
				aSesion);
	  }
	

}
