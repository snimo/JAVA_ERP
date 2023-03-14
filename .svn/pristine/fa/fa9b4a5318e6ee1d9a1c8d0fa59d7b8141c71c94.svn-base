package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEmpresaConciTar extends DBObjetoPersistente {

	public static final String OID_EMPRESA = "oid_empresa";
	public static final String RAZON_SOCIAL = "razon_social";
	public static final String CUIT = "cuit";
	public static final String ACTIVO = "activo";
	public static final String COD_COMERCIO = "cod_comercio";
	public static final String ULT_NRO_CONCI = "ult_nro_conci";
	public static final String COD_EMP_ARCH_TARJ = "cod_emp_arch_tarj";
	public static final String TIPO_ASI_COB = "tipo_asi_cob";
	public static final String TIPO_ASI_LIQUI = "tipo_asi_liqui";
	public static final String COD_EMP_INTERFAZ = "cod_emp_interfaz";
	
	public static final String TIPO_DOCU_ASI_COB = "tipo_docu_asi_cob";
	public static final String UNI_CONTA_ASI_COB = "uni_conta_asi_cob";
	public static final String TIPO_DOCU_ASI_LIQ = "tipo_docu_asi_liq";
	public static final String UNI_CONTA_ASI_LIQ = "uni_conta_asi_liq";
	
	public static final int SELECT_BY_COD_COMERCIO = 100;
	public static final int GET_PROX_NRO_CONCI = 101;

	public DBEmpresaConciTar() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EMPRESA = 1;
		final int RAZON_SOCIAL = 2;
		final int CUIT = 3;
		final int ACTIVO = 4;
		final int COD_COMERCIO = 5;
		final int ULT_NRO_CONCI = 6;
		final int COD_EMP_ARCH_TARJ = 7;
		final int TIPO_ASI_COB = 8;
		final int TIPO_ASI_LIQUI = 9;
		final int COD_EMP_INTERFAZ = 10;
		final int TIPO_DOCU_ASI_COB = 11;
		final int UNI_CONTA_ASI_COB = 12;
		final int TIPO_DOCU_ASI_LIQ = 13;
		final int UNI_CONTA_ASI_LIQ = 14;		

		EmpresaConciTar pers = (EmpresaConciTar) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cTarEmpresa " + " ( " + "OID_EMPRESA," + "RAZON_SOCIAL," + "CUIT,"
				+ "ACTIVO,COD_COMERCIO,ULT_NRO_CONCI,COD_EMP_ARCH_TARJ , tipo_asi_cob , tipo_asi_liqui , cod_emp_interfaz , tipo_docu_asi_cob , uni_conta_asi_cob , tipo_docu_asi_liq , uni_conta_asi_liq)" + " values " + "(" + "?,"+"?,"+ "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EMPRESA, pers.getOID());
		qInsert.setString(RAZON_SOCIAL, pers.getRazon_social());
		qInsert.setString(CUIT, pers.getCuit());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCodComercio() != null)
			qInsert.setString(COD_COMERCIO, pers.getCodComercio());
		else
			qInsert.setNull(COD_COMERCIO, Types.VARCHAR);
		if (pers.getUltNroConci() != null)
			qInsert.setInt(ULT_NRO_CONCI, pers.getUltNroConci().intValue());
		else
			qInsert.setInt(ULT_NRO_CONCI, 0);
		if (pers.getCodEmpArchImpTarj()!=null)
			qInsert.setString(COD_EMP_ARCH_TARJ, pers.getCodEmpArchImpTarj());
		else
			qInsert.setNull(COD_EMP_ARCH_TARJ, Types.VARCHAR);
		qInsert.setString(TIPO_ASI_COB , pers.getTipoAsiCob());
		qInsert.setString(TIPO_ASI_LIQUI , pers.getTipoAsiLiq());
		qInsert.setString(COD_EMP_INTERFAZ , pers.getCodEmpInterfaz());
		qInsert.setString(TIPO_DOCU_ASI_COB, pers.getTipoDocuAsiCobranza());
		qInsert.setString(UNI_CONTA_ASI_COB, pers.getUniContaAsiCobranza());
		qInsert.setString(TIPO_DOCU_ASI_LIQ, pers.getTipoDocuAsiLiquidacion());
		qInsert.setString(UNI_CONTA_ASI_LIQ, pers.getUnidadContaAsiLiq());		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int RAZON_SOCIAL = 1;
		final int CUIT = 2;
		final int ACTIVO = 3;
		final int COD_COMERCIO = 4;
		final int ULT_NRO_CONCI = 5;
		final int COD_EMP_ARCH_TARJ = 6;
		final int TIPO_ASI_COB = 7;
		final int TIPO_ASI_LIQUI = 8;
		final int COD_EMP_INTERFAZ = 9;
		final int TIPO_DOCU_ASI_COB = 10;
		final int UNI_CONTA_ASI_COB = 11;
		final int TIPO_DOCU_ASI_LIQ = 12;
		final int UNI_CONTA_ASI_LIQ = 13;		
		final int OID_EMPRESA = 14;

		EmpresaConciTar pers = (EmpresaConciTar) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cTarEmpresa set " + "razon_social=?" + ",cuit=?" + ",activo=?" + ",cod_comercio=?" + ",ult_nro_conci=? , cod_emp_arch_tarj = ? , tipo_asi_cob = ? , tipo_asi_liqui = ? , cod_emp_interfaz = ? , tipo_docu_asi_cob = ? , uni_conta_asi_cob = ? , tipo_docu_asi_liq = ? , uni_conta_asi_liq = ? "
				+ " where " + " oid_empresa=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EMPRESA, pers.getOID());
		qUpdate.setString(RAZON_SOCIAL, pers.getRazon_social());
		qUpdate.setString(CUIT, pers.getCuit());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCodComercio() != null)
			qUpdate.setString(COD_COMERCIO, pers.getCodComercio());
		else
			qUpdate.setNull(COD_COMERCIO, Types.VARCHAR);
		if (pers.getUltNroConci() != null)
			qUpdate.setInt(ULT_NRO_CONCI, pers.getUltNroConci().intValue());
		else
			qUpdate.setInt(ULT_NRO_CONCI, 0);
		if (pers.getCodEmpArchImpTarj()!=null)
			qUpdate.setString(COD_EMP_ARCH_TARJ, pers.getCodEmpArchImpTarj());
		else
			qUpdate.setNull(COD_EMP_ARCH_TARJ, Types.VARCHAR);	
		
		qUpdate.setString(TIPO_ASI_COB , pers.getTipoAsiCob());
		qUpdate.setString(TIPO_ASI_LIQUI , pers.getTipoAsiLiq());
		qUpdate.setString(COD_EMP_INTERFAZ , pers.getCodEmpInterfaz());
		qUpdate.setString(TIPO_DOCU_ASI_COB, pers.getTipoDocuAsiCobranza());
		qUpdate.setString(UNI_CONTA_ASI_COB, pers.getUniContaAsiCobranza());
		qUpdate.setString(TIPO_DOCU_ASI_LIQ, pers.getTipoDocuAsiLiquidacion());
		qUpdate.setString(UNI_CONTA_ASI_LIQ, pers.getUnidadContaAsiLiq());		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EMPRESA = 1;
		EmpresaConciTar pers = (EmpresaConciTar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarEmpresa " + " set activo=0 " + " where " + " oid_empresa=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EMPRESA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EMPRESA = 1;
		EmpresaConciTar pers = (EmpresaConciTar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarEmpresa " + " set activo=1 " + " where " + " oid_empresa=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EMPRESA, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: {
			ps = this.selectAllHelpActivos(aCondiciones);
			break;
		}		
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		case SELECT_BY_COD_COMERCIO: {
			ps = this.selectByCodComercio(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EMPRESA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarEmpresa ");
		textSQL.append(" WHERE oid_empresa = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EMPRESA, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarEmpresa ");
		textSQL.append(" WHERE activo  = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static int getProxNroConciliacion(EmpresaConciTar empresa,ISesion aSesion) throws BaseException {
		
		int nroConci = 0;
		
		try {
			
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update cTarEmpresa set ult_nro_conci = ult_nro_conci + 1 ");
		textSQL.append(" WHERE oid_empresa="+empresa.getOID());
		PreparedStatement querySelect;
		
		querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

		querySelect.executeUpdate();
		querySelect.close();
		
		StringBuffer textSQL1 = new StringBuffer();
		textSQL1.append("select ult_nro_conci from cTarEmpresa  ");
		textSQL1.append(" WHERE oid_empresa="+empresa.getOID());
		PreparedStatement querySelect1 = aSesion.getConexionBD().prepareStatement(textSQL1.toString());
		ResultSet rs = querySelect1.executeQuery();
		if (rs.next())
			nroConci = rs.getInt(1);
		rs.close();
		querySelect1.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return nroConci;
	}
	
	private PreparedStatement marcarComoPreconci(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update cTarEmpresa ");
		textSQL.append(" WHERE cod_comercio  = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}	
	
	

	private PreparedStatement selectByCodComercio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarEmpresa ");
		textSQL.append(" WHERE cod_comercio  = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarEmpresa ");
		textSQL.append(" WHERE razon_social  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_empresa oid, razon_social codigo,  razon_social descripcion ,activo ");
		textSQL.append(" from cTarEmpresa where activo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_empresa oid, razon_social codigo,  razon_social descripcion ,activo ");
		textSQL.append(" from cTarEmpresa");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EmpresaConciTar.NICKNAME, DBEmpresaConciTar.SELECT_ALL_ACTIVOS, null, new ListObserver(),
				aSesion);
	}

	public static EmpresaConciTar getEmpresa(String codComercio, ISesion aSesion) throws BaseException {
		return (EmpresaConciTar) ObjetoLogico.getObjects(EmpresaConciTar.NICKNAME, DBEmpresaConciTar.SELECT_BY_COD_COMERCIO, codComercio,
				new ObjetoObservado(), aSesion);
	}

}
