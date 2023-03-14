package com.srn.erp.ctasAPagar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.AutorizRolesFactProv;
import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAutorizRolesFactProv extends DBObjetoPersistente {

	public static final String	OID_AUTORIZ_FP_ROL						= "oid_autoriz_fp_rol";

	public static final String	OID_AUTORIZ_FACT							= "oid_autoriz_fact";

	public static final String	OID_ROL_AUTORIZ								= "oid_rol_autoriz";

	public static final String	FEC_ALTA											= "fec_alta";

	public static final String	TIPO_AUTORIZ									= "tipo_autoriz";

	public static final String	FEC_RESP_AUT									= "fec_resp_aut";

	public static final String	PORC_AUT_REC									= "porc_aut_rec";

	public static final String	MONTO_AUT_REC									= "monto_aut_rec";

	public static final String	ESTADO												= "estado";
	
	public static final String  MOTIVO_AUTORIZACION					  = "motivo_autorizacion";
	
	public static final String OID_USUARIO									  = "oid_usuario";

	public static final int			SELECT_BY_PROV_TIPO_CTA_FECHA	= 100;
	public static final int     SELECT_BY_AUTORIZ_FACT        = 101;
	
	

	public DBAutorizRolesFactProv() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUTORIZ_FP_ROL = 1;
		final int OID_AUTORIZ_FACT = 2;
		final int OID_ROL_AUTORIZ = 3;
		final int FEC_ALTA = 4;
		final int TIPO_AUTORIZ = 5;
		final int FEC_RESP_AUT = 6;
		final int PORC_AUT_REC = 7;
		final int MONTO_AUT_REC = 8;
		final int ESTADO = 9;
		final int MOTIVO_AUTORIZACION = 10;
		final int OID_USUARIO = 11;

		AutorizRolesFactProv pers = (AutorizRolesFactProv) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAutorizFPRoles " + " ( " + "OID_AUTORIZ_FP_ROL," + "OID_AUTORIZ_FACT,"
				+ "OID_ROL_AUTORIZ," + "FEC_ALTA," + "TIPO_AUTORIZ," + "FEC_RESP_AUT," + "PORC_AUT_REC," + "MONTO_AUT_REC,"
				+ "ESTADO,MOTIVO_AUTORIZACION,OID_USUARIO)" + " values " + "(" + "?,"+ "?,"+"?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUTORIZ_FP_ROL, pers.getOID());
		qInsert.setInt(OID_AUTORIZ_FACT, pers.getAutorizacion_fact_prov().getOID());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qInsert.setDate(FEC_ALTA, new Date(pers.getFec_lta().getTime()));
		qInsert.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		if (pers.getFecha_resp_aut() != null)
			qInsert.setDate(FEC_RESP_AUT, new Date(pers.getFecha_resp_aut().getTime()));
		else
			qInsert.setNull(FEC_RESP_AUT, java.sql.Types.DATE);
		if (pers.getPorc_aut_rec() != null)
			qInsert.setDouble(PORC_AUT_REC, pers.getPorc_aut_rec().doubleValue());
		else
			qInsert.setNull(PORC_AUT_REC, Types.DOUBLE);
		if (pers.getMonto_aut_rec() != null)
			qInsert.setDouble(MONTO_AUT_REC, pers.getMonto_aut_rec().doubleValue());
		else
			qInsert.setNull(MONTO_AUT_REC, Types.DOUBLE);
		if (pers.getEstado() != null)
			qInsert.setInt(ESTADO, pers.getEstado().intValue());
		else
			qInsert.setNull(ESTADO, Types.INTEGER);
		qInsert.setString(MOTIVO_AUTORIZACION,pers.getMotivoAutorizacion());
		if (pers.getUsuario()!=null)
			qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qInsert.setNull(OID_USUARIO,Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUTORIZ_FACT = 1;
		final int OID_ROL_AUTORIZ = 2;
		final int FEC_ALTA = 3;
		final int TIPO_AUTORIZ = 4;
		final int FEC_RESP_AUT = 5;
		final int PORC_AUT_REC = 6;
		final int MONTO_AUT_REC = 7;
		final int ESTADO = 8;
		final int MOTIVO_AUTORIZACION = 9;
		final int OID_USUARIO = 10;
		final int OID_AUTORIZ_FP_ROL = 11;

		AutorizRolesFactProv pers = (AutorizRolesFactProv) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAutorizFPRoles set " + "oid_autoriz_fact=?" + ",oid_rol_autoriz=?" + ",fec_alta=?"
				+ ",tipo_autoriz=?" + ",fec_resp_aut=?" + ",porc_aut_rec=?" + ",monto_aut_rec=?" + ",estado=? , motivo_autorizacion=? ,oid_usuario=? " + " where "
				+ " oid_autoriz_fp_rol=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_FP_ROL, pers.getOID());
		qUpdate.setInt(OID_AUTORIZ_FACT, pers.getAutorizacion_fact_prov().getOID());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qUpdate.setDate(FEC_ALTA, new Date(pers.getFec_lta().getTime()));
		qUpdate.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		if (pers.getFecha_resp_aut() != null)
			qUpdate.setDate(FEC_RESP_AUT, new Date(pers.getFecha_resp_aut().getTime()));
		else
			qUpdate.setNull(FEC_RESP_AUT, java.sql.Types.DATE);
		if (pers.getPorc_aut_rec() != null)
			qUpdate.setDouble(PORC_AUT_REC, pers.getPorc_aut_rec().doubleValue());
		else
			qUpdate.setNull(PORC_AUT_REC, Types.DOUBLE);
		if (pers.getMonto_aut_rec() != null)
			qUpdate.setDouble(MONTO_AUT_REC, pers.getMonto_aut_rec().doubleValue());
		else
			qUpdate.setNull(MONTO_AUT_REC, Types.DOUBLE);
		if (pers.getEstado() != null)
			qUpdate.setInt(ESTADO, pers.getEstado().intValue());
		else
			qUpdate.setNull(ESTADO, Types.INTEGER);
		qUpdate.setString(MOTIVO_AUTORIZACION,pers.getMotivoAutorizacion());		
		if (pers.getUsuario()!=null)
			qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(OID_USUARIO,Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_FP_ROL = 1;
		AutorizRolesFactProv pers = (AutorizRolesFactProv) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAutorizFPRoles " + " set activo=0 " + " where " + " oid_autoriz_fp_rol=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_FP_ROL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_FP_ROL = 1;
		AutorizRolesFactProv pers = (AutorizRolesFactProv) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAutorizFPRoles " + " set activo=1 " + " where " + " oid_autoriz_fp_rol=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_FP_ROL, pers.getOID());
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
		case SELECT_BY_PROV_TIPO_CTA_FECHA: {
			ps = this.selectByProvTipoCtaFecha(aCondiciones);
			break;
		}
		case SELECT_BY_AUTORIZ_FACT: {
			ps = this.selectByAutorizFact(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AUTORIZ_FP_ROL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizFPRoles ");
		textSQL.append(" WHERE oid_autoriz_fp_rol = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUTORIZ_FP_ROL, oid);
		return querySelect;
	}

	private PreparedStatement selectByProvTipoCtaFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		
		int nroParam = 0;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		TipoCtaCteProv tipoCtaCteProv = (TipoCtaCteProv) condiciones.get(TipoCtaCteProv.NICKNAME);
		java.util.Date fecha = (java.util.Date) (condiciones.get("FECHA"));

		textSQL.append(" select * from cpAutorizFPRoles where ");
		textSQL.append(" oid_autoriz_fact in (");		
		textSQL.append(" select "); 
		textSQL.append(" 	oid_autoriz_fact"); 
		textSQL.append(" from ");
		textSQL.append(" 	cpAutorizFactProv a , cpComproProv b , geComproCab c , geTipoCompro d ");
		textSQL.append(" where ");
		textSQL.append(" 	a.oid_cco = b.oid_cco   ");
		textSQL.append(" 	and b.oid_cco = c.oid_cco ");
		textSQL.append(" 	and c.activo = 1  ");
		if (proveedor != null)
			textSQL.append("  and b.oid_proveedor = " + proveedor.getOIDInteger().toString() );		
		
		textSQL.append(" 	and d.oid_tc = c.oid_tc and d.identificacion = 'ANTPR') ");
		textSQL.append(" 	OR ");
		textSQL.append(" oid_autoriz_fact in ");
		textSQL.append(" ( ");
		textSQL.append("  select ");
		textSQL.append("   oid_autoriz_fact ");
		textSQL.append("  from ");
		textSQL.append("   cpAutorizFactProv ");
		textSQL.append("  where ");
		textSQL.append("   oid_tran_vto in ");
		textSQL.append("  ( ");
		textSQL.append("    select oid_tran_vto from cpTranProvVto , cpTranProv ");
		textSQL.append("      where cpTranProv.oid_tran_prov = cpTranProvVto.oid_tran_prov  ");
		
		if (proveedor != null)
			textSQL.append("  and cpTranProv.oid_proveedor = " + proveedor.getOIDInteger().toString() );
		if (tipoCtaCteProv != null)
			textSQL.append("  and cpTranProv.oid_tipo_cta_prov = " + tipoCtaCteProv.getOIDInteger().toString());
		textSQL.append("            and cpTranProv.pendiente=1  ");
		
		if (fecha!=null) 
		  textSQL.append(" and cpTranProvVto.vto<=? ");
		
		textSQL.append(" )) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (fecha!=null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}
		return querySelect;
	}
	
	
	private PreparedStatement selectByAutorizFact(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizFPRoles ");
		textSQL.append(" WHERE oid_autoriz_fact = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AutorizacionFactProv autorizacionFactProv = (AutorizacionFactProv) aCondiciones;
		querySelect.setInt(1, autorizacionFactProv.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizFPRoles ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_autoriz_fp_rol oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAutorizFPRoles");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAutorizRolesFactProv(Proveedor proveedor, TipoCtaCteProv tipoCtaCteProv, java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (proveedor!=null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		if (tipoCtaCteProv!=null)
			condiciones.put(TipoCtaCteProv.NICKNAME, tipoCtaCteProv);
		if (fecha!=null)
			condiciones.put("FECHA", fecha);

		return (List) ObjetoLogico.getObjects(AutorizRolesFactProv.NICKNAME,
				DBAutorizRolesFactProv.SELECT_BY_PROV_TIPO_CTA_FECHA, condiciones, new ListObserver(), aSesion);
	}
	
	public static List getAutorizRolesFactProv(AutorizacionFactProv autorizFactProv,ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AutorizRolesFactProv.NICKNAME,
				DBAutorizRolesFactProv.SELECT_BY_AUTORIZ_FACT, autorizFactProv, new ListObserver(), aSesion);
	}
	

}
