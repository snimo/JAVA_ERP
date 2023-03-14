package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AutorizacionOC;
import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAutorizacionOC extends DBObjetoPersistente {

	public static final String	OID_AUTORIZ_OC		= "oid_autoriz_oc";

	public static final String	DECISION_AUTORIZ	= "decision_autoriz";

	public static final String	OID_CCO_CPRA			= "oid_cco_cpra";

	public static final String	OID_USUARIO				= "oid_usuario";

	public static final String	FEC_DEC_AUTORIZ		= "fec_dec_autoriz";

	public static final String	COMENTARIO				= "comentario";

	public static final String	DESC_MOTIVO				= "desc_motivo";

	public static final String	ACTIVO						= "activo";

	public static final String	TIPO_MOTIVO				= "tipo_motivo";

	public static final String	OID_OC_DET				= "oid_oc_det";

	public static final String	OID_ROL_AUTORIZ		= "oid_rol_autoriz";

	public static final String	FEC_ALTA					= "fec_alta";

	public static final int			SELECT_BY_OC			= 100;

	public DBAutorizacionOC() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUTORIZ_OC = 1;
		final int DECISION_AUTORIZ = 2;
		final int OID_CCO_CPRA = 3;
		final int OID_USUARIO = 4;
		final int FEC_DEC_AUTORIZ = 5;
		final int COMENTARIO = 6;
		final int DESC_MOTIVO = 7;
		final int ACTIVO = 8;
		final int TIPO_MOTIVO = 9;
		final int OID_OC_DET = 10;
		final int OID_ROL_AUTORIZ = 11;
		final int FEC_ALTA = 12;

		AutorizacionOC pers = (AutorizacionOC) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpOCCabAutoriz " + " ( " + "OID_AUTORIZ_OC," + "DECISION_AUTORIZ," + "OID_CCO_CPRA,"
				+ "OID_USUARIO," + "FEC_DEC_AUTORIZ," + "COMENTARIO," + "DESC_MOTIVO," + "ACTIVO," + "TIPO_MOTIVO,"
				+ "OID_OC_DET," + "OID_ROL_AUTORIZ," + "FEC_ALTA)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUTORIZ_OC, pers.getOID());
		qInsert.setInt(DECISION_AUTORIZ, pers.getDecision_autoriz().intValue());
		qInsert.setInt(OID_CCO_CPRA, pers.getOrden_de_compra().getOID());
		if (pers.getUsuario() != null)
			qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qInsert.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		if (pers.getFec_dec_autoriz()!=null)
			qInsert.setDate(FEC_DEC_AUTORIZ, new Date(pers.getFec_dec_autoriz().getTime()));
		else
			qInsert.setNull(FEC_DEC_AUTORIZ, java.sql.Types.DATE);
		if (pers.getComentario()!=null)
			qInsert.setString(COMENTARIO, pers.getComentario());
		else
			qInsert.setNull(COMENTARIO, java.sql.Types.VARCHAR);
		if (pers.getDesc_motivo()!=null)
			qInsert.setString(DESC_MOTIVO, pers.getDesc_motivo());
		else
			qInsert.setNull(DESC_MOTIVO,java.sql.Types.VARCHAR); 
		
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(TIPO_MOTIVO, pers.getTipo_motivo());
		if (pers.getDetalle_oc() != null)
			qInsert.setInt(OID_OC_DET, pers.getDetalle_oc().getOID());
		else
			qInsert.setNull(OID_OC_DET, java.sql.Types.INTEGER);
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qInsert.setDate(FEC_ALTA, new Date(pers.getFec_alta().getTime()));
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int DECISION_AUTORIZ = 1;
		final int OID_CCO_CPRA = 2;
		final int OID_USUARIO = 3;
		final int FEC_DEC_AUTORIZ = 4;
		final int COMENTARIO = 5;
		final int DESC_MOTIVO = 6;
		final int ACTIVO = 7;
		final int TIPO_MOTIVO = 8;
		final int OID_OC_DET = 9;
		final int OID_ROL_AUTORIZ = 10;
		final int FEC_ALTA = 11;
		final int OID_AUTORIZ_OC = 12;

		AutorizacionOC pers = (AutorizacionOC) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpOCCabAutoriz set " + "decision_autoriz=?" + ",oid_cco_cpra=?" + ",oid_usuario=?"
				+ ",fec_dec_autoriz=?" + ",comentario=?" + ",desc_motivo=?" + ",activo=?" + ",tipo_motivo=?" + ",oid_oc_det=?"
				+ ",oid_rol_autoriz=?" + ",fec_alta=?" + " where " + " oid_autoriz_oc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_OC, pers.getOID());
		qUpdate.setInt(DECISION_AUTORIZ, pers.getDecision_autoriz().intValue());
		qUpdate.setInt(OID_CCO_CPRA, pers.getOrden_de_compra().getOID());
		if (pers.getUsuario() != null)
			qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		qUpdate.setDate(FEC_DEC_AUTORIZ, new Date(pers.getFec_dec_autoriz().getTime()));
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setString(DESC_MOTIVO, pers.getDesc_motivo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(TIPO_MOTIVO, pers.getTipo_motivo());
		if (pers.getDetalle_oc() != null)
			qUpdate.setInt(OID_OC_DET, pers.getDetalle_oc().getOID());
		else
			qUpdate.setNull(OID_OC_DET, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qUpdate.setDate(FEC_ALTA, new Date(pers.getFec_alta().getTime()));
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_OC = 1;
		AutorizacionOC pers = (AutorizacionOC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpOCCabAutoriz where oid_autoriz_oc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_OC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_OC = 1;
		AutorizacionOC pers = (AutorizacionOC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpOCCabAutoriz " + " set activo=1 " + " where " + " oid_autoriz_oc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_OC, pers.getOID());
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
		case SELECT_BY_OC: {
			ps = this.selectByOC(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOC(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCCabAutoriz ");
		textSQL.append(" WHERE oid_cco_cpra = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		OrdenDeCompraCab ocCab = ((OrdenDeCompraCab) aCondiciones);
		querySelect.setInt(1, ocCab.getOID());
		return querySelect;

	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AUTORIZ_OC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCCabAutoriz ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUTORIZ_OC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCCabAutoriz ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_autoriz_oc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpOCCabAutoriz");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAutorizacionOC(OrdenDeCompraCab ocCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AutorizacionOC.NICKNAME, DBAutorizacionOC.SELECT_BY_OC, ocCab,
				new ListObserver(), aSesion);
	}

}
