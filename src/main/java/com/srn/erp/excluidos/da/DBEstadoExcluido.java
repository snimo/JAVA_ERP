package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstadoExcluido extends DBObjetoPersistente {

	public static final String OID_ESTADO = "oid_estado";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String PESO = "peso";
	public static final String COLOR = "color";
	public static final String ACTIVO = "activo";
	public static final String PROPONER_NRO = "proponer_nro";
	public static final String ULT_NRO_PROPU = "ult_nro_propu";
	public static final String NRO_ACTA_OBLI = "nro_acta_obli";
	public static final String PERMITE_MODIF_NRO = "permite_modif_nro";
	public static final String CONSERVA_NRO = "conserva_nro";
	public static final String PUBLICAR_EN_FILTRO = "publicar_en_filtro";
	public static final String RESTRICCION_ACCESO = "restriccion_acceso";
	
	

	public DBEstadoExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTADO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int PESO = 4;
		final int COLOR = 5;
		final int ACTIVO = 6;
		final int PROPONER_NRO = 7;
		final int ULT_NRO_PROPU = 8;
		final int NRO_ACTA_OBLI = 9;
		final int PERMITE_MODIF_NRO = 10;
		final int CONSERVA_NRO = 11;
		final int PUBLICAR_EN_FILTRO = 12;
		final int RESTRICCION_ACCESO = 13;

		EstadoExcluido pers = (EstadoExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excEstados " + " ( " + "OID_ESTADO," + "CODIGO," + "DESCRIPCION," + "PESO," + "COLOR," + "ACTIVO , PROPONER_NRO , ULT_NRO_PROPU , NRO_ACTA_OBLI , PERMITE_MODIF_NRO , CONSERVA_NRO , PUBLICAR_EN_FILTRO, RESTRICCION_ACCESO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"+ "?," + "? , ? , ? , ? , ? , ?, ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTADO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(PESO, pers.getPeso().intValue());
		qInsert.setString(COLOR, pers.getColor());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isProponerNro()!=null)
			qInsert.setBoolean(PROPONER_NRO, pers.isProponerNro().booleanValue());
		else
			qInsert.setBoolean(PROPONER_NRO, false);
		if (pers.getUltNroPropuesto()!=null)
			qInsert.setInt(ULT_NRO_PROPU, pers.getUltNroPropuesto().intValue());
		else
			qInsert.setInt(ULT_NRO_PROPU, 0);		
		if (pers.isProponerNro()!=null)
			qInsert.setBoolean(NRO_ACTA_OBLI, pers.isNroActaObligatorio().booleanValue());
		else
			qInsert.setBoolean(NRO_ACTA_OBLI, false);
		
		if (pers.isPermiteModifNro()!=null)
			qInsert.setBoolean(PERMITE_MODIF_NRO, pers.isPermiteModifNro());
		else
			qInsert.setBoolean(PERMITE_MODIF_NRO, false);
		
		if (pers.isConservaNro()!=null)
			qInsert.setBoolean(CONSERVA_NRO, pers.isConservaNro());
		else
			qInsert.setBoolean(CONSERVA_NRO, false);
		
		if (pers.isPublicarEnFiltro()!=null)
			qInsert.setBoolean(PUBLICAR_EN_FILTRO, pers.isPublicarEnFiltro());
		else
			qInsert.setBoolean(PUBLICAR_EN_FILTRO, false);		
		
		if (pers.isRestriccionAcceso()!=null)
			qInsert.setBoolean(RESTRICCION_ACCESO, pers.isRestriccionAcceso());
		else
			qInsert.setBoolean(RESTRICCION_ACCESO, false);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int PESO = 3;
		final int COLOR = 4;
		final int ACTIVO = 5;
		final int PROPONER_NRO = 6;
		final int ULT_NRO_PROPU = 7;
		final int NRO_ACTA_OBLI = 8;		
		final int PERMITE_MODIF_NRO = 9;
		final int CONSERVA_NRO = 10;
		final int PUBLICAR_EN_FILTRO = 11;
		final int RESTRICCION_ACCESO = 12;
		final int OID_ESTADO = 13;

		EstadoExcluido pers = (EstadoExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excEstados set " + "codigo=?" + ",descripcion=?" + ",peso=?" + ",color=?" + ",activo=? , PROPONER_NRO=? , ULT_NRO_PROPU=? , NRO_ACTA_OBLI=? , permite_modif_nro = ? , conserva_nro = ? , publicar_en_filtro = ?, restriccion_acceso = ? " + " where "
				+ " oid_estado=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(PESO, pers.getPeso().intValue());
		qUpdate.setString(COLOR, pers.getColor());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isProponerNro()!=null)
			qUpdate.setBoolean(PROPONER_NRO, pers.isProponerNro().booleanValue());
		else
			qUpdate.setBoolean(PROPONER_NRO, false);
		if (pers.getUltNroPropuesto()!=null)
			qUpdate.setInt(ULT_NRO_PROPU, pers.getUltNroPropuesto().intValue());
		else
			qUpdate.setInt(ULT_NRO_PROPU, 0);		
		if (pers.isProponerNro()!=null)
			qUpdate.setBoolean(NRO_ACTA_OBLI, pers.isNroActaObligatorio().booleanValue());
		else
			qUpdate.setBoolean(NRO_ACTA_OBLI, false);	
		
		if (pers.isPermiteModifNro()!=null)
			qUpdate.setBoolean(PERMITE_MODIF_NRO, pers.isPermiteModifNro());
		else
			qUpdate.setBoolean(PERMITE_MODIF_NRO, false);
		
		if (pers.isConservaNro()!=null)
			qUpdate.setBoolean(CONSERVA_NRO, pers.isConservaNro());
		else
			qUpdate.setBoolean(CONSERVA_NRO, false);	
		
		if (pers.isPublicarEnFiltro()!=null)
			qUpdate.setBoolean(PUBLICAR_EN_FILTRO, pers.isPublicarEnFiltro());
		else
			qUpdate.setBoolean(PUBLICAR_EN_FILTRO, false);		
		
		if (pers.isRestriccionAcceso()!=null)
			qUpdate.setBoolean(RESTRICCION_ACCESO, pers.isRestriccionAcceso());
		else
			qUpdate.setBoolean(RESTRICCION_ACCESO, false);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTADO = 1;
		EstadoExcluido pers = (EstadoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excEstados " + " set activo=0 " + " where " + " oid_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTADO = 1;
		EstadoExcluido pers = (EstadoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excEstados " + " set activo=1 " + " where " + " oid_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESTADO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excEstados ");
		textSQL.append(" WHERE oid_estado = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTADO, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excEstados ");
		textSQL.append(" WHERE activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM excEstados ");
		textSQL.append(" WHERE activo=1 and codigo = ?  ");
		
		String codigo = (String) aCondiciones;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, codigo);
		return querySelect;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoExcluido.NICKNAME, DBEstadoExcluido.SELECT_ALL_ACTIVOS, null, new ListObserver(),
				aSesion);
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_estado oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from excEstados");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}


}
