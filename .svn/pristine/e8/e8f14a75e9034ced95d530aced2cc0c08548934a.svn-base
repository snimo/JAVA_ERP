package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class DBTipoComprobante extends DBObjetoPersistente {

	public static final String	OID_TC													= "oid_tc";

	public static final String	TC_EXT													= "tc_ext";

	public static final String	DESCRIPCION											= "descripcion";

	public static final String	IDENTIFICACION									= "identificacion";

	public static final String	OID_LEYENDA											= "oid_leyenda";

	public static final String	ACTIVO													= "activo";

	public static final String	OID_TIPO_COMPRO_ANU							= "oid_tipo_comp_anu";
	
	public static final String  TC_PARA_COD_BARRA 							= "tc_para_cod_barra";
	
	public static final String  DESC_TITU_ASI_LIBRO_DIARIO 							= "desc_tit_asi_dia";
	

	public static final int			SELECT_BY_COMPO_ING_ASI					= 100;

	public static final int			SELECT_BY_CODIGO_COMPO_ING_ASI	= 101;

	public static final int			SELECT_BY_FAC_ND_NC_ANT_PROV		= 102;

	public static final int			SELECT_BY_FAC_ND_NC_ANT_PROV_1	= 103;
	
	public static final int			SELECT_BY_MOV_ARQ_CON_SIGNO_IGUAL_A = 104;

	public DBTipoComprobante() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TC = 1;
		final int TC_EXT = 2;
		final int DESCRIPCION = 3;
		final int IDENTIFICACION = 4;
		final int OID_LEYENDA = 5;
		final int ACTIVO = 6;
		final int OID_TIPO_COMPRO_ANU = 7;
		final int CODIGO_PARA_CODIGO_BARRA = 8;
		final int DESC_TITU_ASI_LIBRO_DIARIO = 9;

		TipoComprobante pers = (TipoComprobante) objetoPersistente;
		
		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geTipoCompro " + " ( " + "OID_TC," + "TC_EXT," + "DESCRIPCION," + "IDENTIFICACION,"
				+ "OID_LEYENDA," + "ACTIVO,OID_TIPO_COMP_ANU , TC_PARA_COD_BARRA , desc_tit_asi_dia)" + " values " + "(" + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TC, pers.getOID());
		qInsert.setString(TC_EXT, pers.getTcexterno());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(IDENTIFICACION, pers.getIdentificacion());
		qInsert.setInt(OID_LEYENDA, pers.getLeyenda().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getTipoComproAnulador() != null)
			qInsert.setInt(OID_TIPO_COMPRO_ANU, pers.getTipoComproAnulador().getOID());
		else
			qInsert.setNull(OID_TIPO_COMPRO_ANU, Types.INTEGER);
		if (pers.getCodigoParaCodigoBarra()!=null)
			qInsert.setString(CODIGO_PARA_CODIGO_BARRA, pers.getCodigoParaCodigoBarra());
		else
			qInsert.setNull(CODIGO_PARA_CODIGO_BARRA, java.sql.Types.VARCHAR);
		
		if (pers.getDescTituAsiLibroDiario()!=null)
			qInsert.setString(DESC_TITU_ASI_LIBRO_DIARIO, pers.getDescTituAsiLibroDiario());
		else
			qInsert.setNull(DESC_TITU_ASI_LIBRO_DIARIO, java.sql.Types.VARCHAR);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TC_EXT = 1;
		final int DESCRIPCION = 2;
		final int IDENTIFICACION = 3;
		final int OID_LEYENDA = 4;
		final int ACTIVO = 5;
		final int OID_TIPO_COMPRO_ANU = 6;
		final int CODIGO_PARA_CODIGO_BARRA = 7;
		final int DESC_TITU_ASI_LIBRO_DIARIO = 8;
		final int OID_TC = 9;

		TipoComprobante pers = (TipoComprobante) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geTipoCompro set " + "tc_ext=?" + ",descripcion=?" + ",identificacion=?"
				+ ",oid_leyenda=?" + ",activo=?" + ",oid_tipo_comp_anu=? , tc_para_cod_barra = ? , desc_tit_asi_dia = ? " + " where " + " oid_tc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TC, pers.getOID());
		qUpdate.setString(TC_EXT, pers.getTcexterno());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(IDENTIFICACION, pers.getIdentificacion());
		qUpdate.setInt(OID_LEYENDA, pers.getLeyenda().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getTipoComproAnulador() != null)
			qUpdate.setInt(OID_TIPO_COMPRO_ANU, pers.getTipoComproAnulador().getOID());
		else
			qUpdate.setNull(OID_TIPO_COMPRO_ANU, Types.INTEGER);
		if (pers.getCodigoParaCodigoBarra()!=null)
			qUpdate.setString(CODIGO_PARA_CODIGO_BARRA, pers.getCodigoParaCodigoBarra());
		else
			qUpdate.setNull(CODIGO_PARA_CODIGO_BARRA, java.sql.Types.VARCHAR);
		
		if (pers.getDescTituAsiLibroDiario()!=null)
			qUpdate.setString(DESC_TITU_ASI_LIBRO_DIARIO, pers.getDescTituAsiLibroDiario());
		else
			qUpdate.setNull(DESC_TITU_ASI_LIBRO_DIARIO, java.sql.Types.VARCHAR);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TC = 1;
		TipoComprobante pers = (TipoComprobante) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geTipoCompro " + " set activo=0 " + " where " + " oid_tc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TC = 1;
		TipoComprobante pers = (TipoComprobante) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geTipoCompro " + " set activo=1 " + " where " + " oid_tc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TC, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_COMPO_ING_ASI: {
			ps = this.selectByCompoIngresoManual(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_COMPO_ING_ASI: {
			ps = this.selectByCodigoCompoIngManual(aCondiciones);
			break;
		}
		case SELECT_BY_FAC_ND_NC_ANT_PROV: {
			ps = this.selectHelpFact_ND_NC_ANT_Prov(aCondiciones);
			break;
		}
		case SELECT_BY_FAC_ND_NC_ANT_PROV_1: {
			ps = this.selectHelpFact_ND_NC_ANT_Prov1(aCondiciones);
			break;
		}
		case SELECT_BY_MOV_ARQ_CON_SIGNO_IGUAL_A: {
			ps = this.selectMovArqConSignoIgualA(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geTipoCompro ");
		textSQL.append(" WHERE oid_tc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TC, oid);
		return querySelect;
	}

	private PreparedStatement selectMovArqConSignoIgualA(Object aCondiciones) throws BaseException, SQLException {

		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer signo = (Integer) condiciones.get("SIGNO");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geTipoCompro ");
		textSQL.append(" WHERE oid_tc in (select distinct a.oid_tc from gecomprocab a,vaArqueo b where a.oid_cco = b.oid_cco and b.signo="+signo.intValue()+" ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
		
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geTipoCompro ");
		textSQL.append(" WHERE tc_ext = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geTipoCompro ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigoCompoIngManual(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geTipoCompro ");
		textSQL.append(" WHERE tc_ext = ? and identificacion='ASIMA' and activo=1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		MapDatos mapaDatos = (MapDatos) aCondiciones;

		String codigo = mapaDatos.getString("codigo");
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tc oid,tc_ext codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geTipoCompro");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectHelpFact_ND_NC_ANT_Prov(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tc oid,tc_ext codigo, descripcion descripcion ,activo ");
		textSQL
				.append(" from geTipoCompro where identificacion in ('FAPRO','NDPRO','NCPRO','ANTPR','NDPIN','NCPIN') and activo = 1");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectHelpFact_ND_NC_ANT_Prov1(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT * ");
		textSQL
				.append(" from geTipoCompro where identificacion in ('FAPRO','NDPRO','NCPRO','ANTPR','NDPIN','NCPIN') and activo = 1");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCompoIngresoManual(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tc oid,tc_ext codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geTipoCompro where identificacion='ASIMA' and activo=1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllTiposComprobantes(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoComprobante.NICKNAME, IDBObjetoPersistente.SELECT_ALL, null,
				new ListObserver(), aSesion);
	}

	public static List getAllTiposComprobantesProveedor(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoComprobante.NICKNAME, DBTipoComprobante.SELECT_BY_FAC_ND_NC_ANT_PROV_1,
				null, new ListObserver(), aSesion);
	}
	
	public static List getTiposComproConMovArqueoSigno(ISesion aSesion,Integer signo) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("SIGNO", signo);
		return (List) ObjetoLogico.getObjects(TipoComprobante.NICKNAME, DBTipoComprobante.SELECT_BY_MOV_ARQ_CON_SIGNO_IGUAL_A,
				condiciones, new ListObserver(), aSesion);
	}
	

}
