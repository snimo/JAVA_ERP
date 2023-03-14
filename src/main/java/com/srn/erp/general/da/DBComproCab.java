package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBComproCab extends DBObjetoPersistente {

	public static final String	OID_CCO															= "oid_cco";

	public static final String	OID_TC															= "oid_tc";

	public static final String	TC_EXT															= "tc_ext";

	public static final String	LETRA																= "letra";

	public static final String	OID_LUG_EMI													= "oid_lug_emi";

	public static final String	LUG_EMI															= "lug_emi";

	public static final String	NROEXT															= "nro_Ext";

	public static final String	EMISION															= "emision";

	public static final String	ESTADO															= "estado";

	public static final String	COMENTARIO													= "comentario";

	public static final String	FEC_ALTA														= "fec_alta";

	public static final String	OID_USUARIO													= "oid_usuario";

	public static final String	ACTIVO															= "activo";

	public static final String	OID_TALONARIO												= "oid_talonario";

	public static final String	OID_SUCURSAL												= "oid_sucursal";

	public static final String	IMPUTAC															= "imputac";

	public static final String	ESTADO_ANULADO											= "ANU";

	public static final String	ESTADO_ALTA													= "ALTA";
	
	public static final String  OID_CCO_ANULADOR                    = "OID_CCO_ANULADOR";

	public static final String	OID_MOTIVO_COMPRO										= "oid_motivo_compro";
	
	public static final String	COMPORTAMIENTO  										= "comportamiento";
	
	public static final String NRO_INTERNO = "nro_interno";
	

	public static final int			SELECT_BY_TC_LETRA_LE_NROEXT				= 100;

	public static final int			UPDATE_CAMBIAR_ESTADO								= 101;

	public static final int			SELECT_BY_TALONARIO_NRO_EXT					= 102;

	public static final int			SELECT_BY_TC_LETRA_LE_NROEXT_ACTIVO	= 103;
	
	public static final int			SELECT_BY_TALONARIO_NRO_EXT_ACTIVO	= 104;
	
	

	public DBComproCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int OID_TC = 2;
		final int TC_EXT = 3;
		final int LETRA = 4;
		final int OID_LUG_EMI = 5;
		final int LUG_EMI = 6;
		final int NROEXT = 7;
		final int EMISION = 8;
		final int ESTADO = 9;
		final int COMENTARIO = 10;
		final int FEC_ALTA = 11;
		final int OID_USUARIO = 12;
		final int ACTIVO = 13;
		final int OID_TALONARIO = 14;
		final int OID_SUCURSAL = 15;
		final int IMPUTAC = 16;
		final int OID_MOTIVO_COMPRO = 17;
		final int OID_CCO_ANULADOR = 18;
		final int COMPORTAMIENTO = 19;
		final int NRO_INTERNO = 20;

		ComproCab pers = (ComproCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geComproCab " + " ( " + "OID_CCO," + "OID_TC," + "TC_EXT," + "LETRA,"
				+ "OID_LUG_EMI," + "LUG_EMI," + "NRO_EXT," + "EMISION," + "ESTADO," + "COMENTARIO," + "FEC_ALTA,"
				+ "OID_USUARIO," + "ACTIVO," + "OID_TALONARIO," + "OID_SUCURSAL," + "IMPUTAC,OID_MOTIVO_COMPRO , OID_CCO_ANULADOR , COMPORTAMIENTO , NRO_INTERNO)" + " values "
				+ "(" + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO, pers.getOID());
		qInsert.setInt(OID_TC, pers.getTipoCompro().getOID());
		qInsert.setString(TC_EXT, pers.getTcExt());
		qInsert.setString(LETRA, pers.getLetra());
		if (pers.getLugarEmision() != null)
			qInsert.setInt(OID_LUG_EMI, pers.getLugarEmision().getOID());
		else
			qInsert.setNull(OID_LUG_EMI, Types.INTEGER);
		qInsert.setInt(LUG_EMI, pers.getNroLugEmision().intValue());
		qInsert.setInt(NROEXT, pers.getNroExt().intValue());
		qInsert.setDate(EMISION, new java.sql.Date(pers.getEmision().getTime()));
		qInsert.setString(ESTADO, pers.getEstado());
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setDate(FEC_ALTA, new java.sql.Date(Fecha.getFechaActual().getTime()));
		qInsert.setInt(OID_USUARIO, getSesion().getLogin().getUsuario().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getTalonario() != null)
			qInsert.setInt(OID_TALONARIO, pers.getTalonario().getOID());
		else
			qInsert.setNull(OID_TALONARIO, Types.INTEGER);
		qInsert.setInt(OID_SUCURSAL, pers.getSesion().getLogin().getOidSucursal().intValue());
		if (pers.getImputac() != null)
			qInsert.setDate(IMPUTAC, new java.sql.Date(pers.getImputac().getTime()));
		else
			qInsert.setDate(IMPUTAC, new java.sql.Date(pers.getEmision().getTime()));
		if (pers.getMotivoComprobante() != null)
			qInsert.setInt(OID_MOTIVO_COMPRO, pers.getMotivoComprobante().getOID());
		else
			qInsert.setNull(OID_MOTIVO_COMPRO, Types.INTEGER);
		if (pers.getComprobanteAnulador() != null)
			qInsert.setInt(OID_CCO_ANULADOR, pers.getComprobanteAnulador().getOID());
		else
			qInsert.setNull(OID_CCO_ANULADOR, Types.INTEGER);
		qInsert.setString(COMPORTAMIENTO, pers.getTipoCompro().getIdentificacion());
		
		if (pers.getNroInterno()!=null)
			qInsert.setInt(NRO_INTERNO , pers.getNroInterno().intValue());
		else
			qInsert.setNull(NRO_INTERNO , Types.INTEGER);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TC = 1;
		final int TC_EXT = 2;
		final int LETRA = 3;
		final int OID_LUG_EMI = 4;
		final int LUG_EMI = 5;
		final int NROEXT = 6;
		final int EMISION = 7;
		final int ESTADO = 8;
		final int COMENTARIO = 9;
		final int FEC_ALTA = 10;
		final int OID_USUARIO = 11;
		final int ACTIVO = 12;
		final int OID_TALONARIO = 13;
		final int IMPUTAC = 14;
		final int OID_MOTIVO_COMPRO = 15;
		final int OID_CCO_ANULADOR = 16;
		final int NRO_INTERNO = 17;
		final int OID_CCO = 18;

		ComproCab pers = (ComproCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geComproCab set " + "oid_tc=?" + ",tc_ext=?" + ",letra=?" + ",oid_lug_emi=?"
				+ ",lug_emi=?" + ",nro_Ext=?" + ",emision=?" + ",estado=?" + ",comentario=?" + ",fec_alta=?" + ",oid_usuario=?"
				+ ",activo=?" + ",oid_talonario=?" + ",imputac=?" + ",oid_motivo_compro=? , oid_cco_anulador = ? , nro_interno = ? " + " where " + " oid_cco=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.setInt(OID_TC, pers.getTipoCompro().getOID());
		qUpdate.setString(TC_EXT, pers.getTcExt());
		qUpdate.setString(LETRA, pers.getLetra());
		if (pers.getLugarEmision() != null)
			qUpdate.setInt(OID_LUG_EMI, pers.getLugarEmision().getOID());
		else
			qUpdate.setNull(OID_LUG_EMI, Types.INTEGER);
		qUpdate.setInt(LUG_EMI, pers.getNroLugEmision().intValue());
		qUpdate.setInt(NROEXT, pers.getNroExt().intValue());
		qUpdate.setDate(EMISION, new java.sql.Date(pers.getEmision().getTime()));
		qUpdate.setString(ESTADO, pers.getEstado());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setDate(FEC_ALTA, new java.sql.Date(pers.getFecAlta().getTime()));
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getTalonario() != null)
			qUpdate.setInt(OID_TALONARIO, pers.getTalonario().getOID());
		else
			qUpdate.setNull(OID_TALONARIO, Types.INTEGER);
		if (pers.getImputac() != null)
			qUpdate.setDate(IMPUTAC, new java.sql.Date(pers.getImputac().getTime()));
		else
			qUpdate.setDate(IMPUTAC, new java.sql.Date(pers.getEmision().getTime()));
		if (pers.getMotivoComprobante() != null)
			qUpdate.setInt(OID_MOTIVO_COMPRO, pers.getMotivoComprobante().getOID());
		else
			qUpdate.setNull(OID_MOTIVO_COMPRO, Types.INTEGER);
		if (pers.getComprobanteAnulador() != null)
			qUpdate.setInt(OID_CCO_ANULADOR, pers.getComprobanteAnulador().getOID());
		else
			qUpdate.setNull(OID_CCO_ANULADOR, Types.INTEGER);

		if (pers.getNroInterno()!=null)
			qUpdate.setInt(NRO_INTERNO , pers.getNroInterno().intValue());
		else
			qUpdate.setNull(NRO_INTERNO , Types.INTEGER);
				
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO = 1;
		ComproCab pers = (ComproCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0,estado=" + ESTADO_ANULADO + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO = 1;
		ComproCab pers = (ComproCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=1,estado=" + ESTADO_ALTA + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
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
		case SELECT_BY_TC_LETRA_LE_NROEXT: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NROEXT_ACTIVO: {
			ps = this.selectByCodigoActivo(aCondiciones);
			break;
		}

		case UPDATE_CAMBIAR_ESTADO: {
			ps = this.cambiarEstado(aCondiciones);
			break;
		}
		case SELECT_BY_TALONARIO_NRO_EXT: {
			ps = this.selectByTalonarioNro(aCondiciones);
			break;
		}
		case SELECT_BY_TALONARIO_NRO_EXT_ACTIVO: {
			ps = this.selectByTalonarioNroActivo(aCondiciones);
			break;
		}
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComproCab ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO, oid);
		return querySelect;
	}

	private PreparedStatement cambiarEstado(Object aCondiciones) throws BaseException, SQLException {

		final int ESTADO = 1;
		final int OID_CCO = 2;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update geComproCab set estado=? ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		MapDatos condiciones = (MapDatos) aCondiciones;
		ComproCab comproCab = (ComproCab) condiciones.get(DBComproCab.OID_CCO);
		String estado = (String) condiciones.get(DBComproCab.ESTADO);

		querySelect.setString(ESTADO, estado);
		querySelect.setInt(OID_CCO, comproCab.getOID());

		return querySelect;
	}

	private PreparedStatement selectByTalonarioNro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("select * from geComproCab ");
		textSQL.append(" WHERE oid_talonario = ? and nro_ext = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		MapDatos condiciones = (MapDatos) aCondiciones;
		Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
		Integer nroExt = (Integer) condiciones.get(DBComproCab.NROEXT);
		querySelect.setInt(1, talonario.getOID());
		querySelect.setInt(2, nroExt.intValue());
		return querySelect;
	}
	
	private PreparedStatement selectByTalonarioNroActivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("select * from geComproCab ");
		textSQL.append(" WHERE oid_talonario = ? and nro_ext = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		MapDatos condiciones = (MapDatos) aCondiciones;
		Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
		Integer nroExt = (Integer) condiciones.get(DBComproCab.NROEXT);
		querySelect.setInt(1, talonario.getOID());
		querySelect.setInt(2, nroExt.intValue());
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		MapDatos mapa = (MapDatos) aCondiciones;
		String tc = (String) mapa.get(DBComproCab.TC_EXT);
		String letra = (String) mapa.get(DBComproCab.LETRA);
		Integer lugEmi = (Integer) mapa.get(DBComproCab.LUG_EMI);
		Integer nroExt = (Integer) mapa.get(DBComproCab.NROEXT);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComproCab ");
		textSQL.append(" WHERE  tc_ext=? and letra=? and lug_emi=? and nro_ext=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, tc);
		querySelect.setString(2, letra);
		querySelect.setInt(3, lugEmi.intValue());
		querySelect.setInt(4, nroExt.intValue());
		return querySelect;
	}

	private PreparedStatement selectByCodigoActivo(Object aCondiciones) throws BaseException, SQLException {

		MapDatos mapa = (MapDatos) aCondiciones;
		String tc = (String) mapa.get(DBComproCab.TC_EXT);
		String letra = (String) mapa.get(DBComproCab.LETRA);
		Integer lugEmi = (Integer) mapa.get(DBComproCab.LUG_EMI);
		Integer nroExt = (Integer) mapa.get(DBComproCab.NROEXT);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComproCab ");
		textSQL.append(" WHERE  tc_ext=? and letra=? and lug_emi=? and nro_ext=? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, tc);
		querySelect.setString(2, letra);
		querySelect.setInt(3, lugEmi.intValue());
		querySelect.setInt(4, nroExt.intValue());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geComproCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static ComproCab getComproCab(String tc, String letra, Integer lugEmi, Integer nroExt, ISesion aSesion)
			throws BaseException {
		Map mapaDatos = new HashTableDatos();
		mapaDatos.put(DBComproCab.TC_EXT, tc);
		mapaDatos.put(DBComproCab.LETRA, letra);
		mapaDatos.put(DBComproCab.LUG_EMI, lugEmi);
		mapaDatos.put(DBComproCab.NROEXT, nroExt);

		return (ComproCab) ObjetoLogico.getObjects(ComproCab.NICKNAME, DBComproCab.SELECT_BY_TC_LETRA_LE_NROEXT, mapaDatos,
				new ObjetoObservado(), aSesion);

	}

	public static ComproCab getComproCabActivo(String tc, String letra, Integer lugEmi, Integer nroExt, ISesion aSesion)
			throws BaseException {
		Map mapaDatos = new HashTableDatos();
		mapaDatos.put(DBComproCab.TC_EXT, tc);
		mapaDatos.put(DBComproCab.LETRA, letra);
		mapaDatos.put(DBComproCab.LUG_EMI, lugEmi);
		mapaDatos.put(DBComproCab.NROEXT, nroExt);

		return (ComproCab) ObjetoLogico.getObjects(ComproCab.NICKNAME, DBComproCab.SELECT_BY_TC_LETRA_LE_NROEXT_ACTIVO, mapaDatos,
				new ObjetoObservado(), aSesion);

	}

	public static ComproCab getComproCab(Talonario talonario, Integer nroExt, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Talonario.NICKNAME, talonario);
		condiciones.put(DBComproCab.NROEXT, nroExt);
		return (ComproCab) ObjetoLogico.getObjects(ComproCab.NICKNAME, DBComproCab.SELECT_BY_TALONARIO_NRO_EXT,
				condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static ComproCab getComproCabActivo(Talonario talonario, Integer nroExt, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Talonario.NICKNAME, talonario);
		condiciones.put(DBComproCab.NROEXT, nroExt);
		return (ComproCab) ObjetoLogico.getObjects(ComproCab.NICKNAME, DBComproCab.SELECT_BY_TALONARIO_NRO_EXT_ACTIVO,
				condiciones, new ObjetoObservado(), aSesion);
	}	

}
