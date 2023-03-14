package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBImpresoraFiscal extends DBObjetoPersistente {

	public static final String	OID_IMP_FISCAL			= "oid_imp_fiscal";

	public static final String	CODIGO							= "codigo";

	public static final String	DESCRIPCION					= "descripcion";

	public static final String	COMPO_IMP_FISCAL		= "compo_imp_fiscal";

	public static final String	ACTIVO							= "activo";

	public static final String	OID_UNI_ORG					= "oid_uni_org";
	
	public static final String	PUERTO							= "puerto";
	
	public static final String	BAUDIOS							= "baudios";
	
	public static final String	DRIVER							= "driver";
	
	public static final String COMPO_IMPRESION = "compo_impresion";
	
	public static final String PATH_GEN_ARCH_IMP = "path_gen_arch_imp";

	public static final int			SELECT_BY_SUCURSAL	= 100;

	public DBImpresoraFiscal() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_IMP_FISCAL = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int COMPO_IMP_FISCAL = 4;
		final int ACTIVO = 5;
		final int OID_UNI_ORG = 6;
		final int PUERTO = 7;
		final int BAUDIOS = 8;
		final int DRIVER = 9;
		final int COMPO_IMPRESION = 10;
		final int PATH_GEN_ARCH_IMP = 11;

		ImpresoraFiscal pers = (ImpresoraFiscal) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geImpFiscal " + " ( " + "OID_IMP_FISCAL," + "CODIGO," + "DESCRIPCION,"
				+ "COMPO_IMP_FISCAL," + "ACTIVO,OID_UNI_ORG,PUERTO,BAUDIOS,DRIVER,COMPO_IMPRESION,PATH_GEN_ARCH_IMP)" + " values " + "(" + "?," +"?," +"?," + "?," + "?," + "?," + "?,"+ "?,?,?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_IMP_FISCAL, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(COMPO_IMP_FISCAL, pers.getCompo_imp_fiscal());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_UNI_ORG, pers.getUnidadOrganizativa().getOID());
		qInsert.setInt(PUERTO, pers.getPuerto().intValue());
		qInsert.setInt(BAUDIOS, pers.getBaudios().intValue());
		qInsert.setString(DRIVER, pers.getDriver());
		if (pers.getComportamiento()!=null)
			qInsert.setString(COMPO_IMPRESION, pers.getComportamiento());
		else
			qInsert.setNull(COMPO_IMPRESION, java.sql.Types.VARCHAR);
		if (pers.getPathGenArch()!=null)
			qInsert.setString(PATH_GEN_ARCH_IMP, pers.getPathGenArch());
		else
			qInsert.setNull(PATH_GEN_ARCH_IMP, java.sql.Types.VARCHAR);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int COMPO_IMP_FISCAL = 3;
		final int ACTIVO = 4;
		final int OID_UNI_ORG = 5;
		final int PUERTO = 6;
		final int BAUDIOS = 7;
		final int DRIVER = 8;
		final int COMPO_IMPRESION = 9;
		final int PATH_GEN_ARCH_IMP = 10;
		final int OID_IMP_FISCAL = 11;

		ImpresoraFiscal pers = (ImpresoraFiscal) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geImpFiscal set " + "codigo=?" + ",descripcion=?" + 
				",compo_imp_fiscal=?" + ",activo=?"
				+ ",oid_uni_org=?" 
				+ ",puerto=? , baudios = ? , driver = ? , compo_impresion = ? , path_gen_arch_imp = ? " +
				" where " + " oid_imp_fiscal=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_FISCAL, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(COMPO_IMP_FISCAL, pers.getCompo_imp_fiscal());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_UNI_ORG, pers.getUnidadOrganizativa().getOID());
		qUpdate.setInt(PUERTO, pers.getPuerto().intValue());
		qUpdate.setString(DRIVER, pers.getDriver());
		qUpdate.setInt(BAUDIOS, pers.getBaudios().intValue());
		if (pers.getComportamiento()!=null)
			qUpdate.setString(COMPO_IMPRESION, pers.getComportamiento());
		else
			qUpdate.setNull(COMPO_IMPRESION, java.sql.Types.VARCHAR);
		if (pers.getPathGenArch()!=null)
			qUpdate.setString(PATH_GEN_ARCH_IMP, pers.getPathGenArch());
		else
			qUpdate.setNull(PATH_GEN_ARCH_IMP, java.sql.Types.VARCHAR);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMP_FISCAL = 1;
		ImpresoraFiscal pers = (ImpresoraFiscal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geImpFiscal " + " set activo = 0 where  " + " oid_imp_fiscal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_FISCAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMP_FISCAL = 1;
		ImpresoraFiscal pers = (ImpresoraFiscal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geImpFiscal " + " set activo=1 " + " where " + " oid_imp_fiscal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_FISCAL, pers.getOID());
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
		case SELECT_BY_SUCURSAL: {
			ps = this.selectBySucursal(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_IMP_FISCAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpFiscal ");
		textSQL.append(" WHERE oid_imp_fiscal = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_IMP_FISCAL, oid);
		return querySelect;
	}
	
	private PreparedStatement selectBySucursal(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpFiscal ");
		textSQL.append(" WHERE oid_uni_org ");
		textSQL.append(" in (select oid_uni_org from geUnidadOrg where oid_sucursal=?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Sucursal sucursal = (Sucursal) aCondiciones;
		querySelect.setInt(1, sucursal.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpFiscal ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpFiscal ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_imp_fiscal oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geImpFiscal");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getImpresoras(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ImpresoraFiscal.NICKNAME, DBImpresoraFiscal.SELECT_BY_SUCURSAL,
				sucursal, new ListObserver(), aSesion);
	}
	
	public static List getAllImpresorasActivas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ImpresoraFiscal.NICKNAME, DBImpresoraFiscal.SELECT_ALL_ACTIVOS,
				null, new ListObserver(), aSesion);
	}
	
	

}
