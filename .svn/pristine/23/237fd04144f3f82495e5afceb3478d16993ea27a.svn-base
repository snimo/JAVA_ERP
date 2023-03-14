package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFiltroValLegCab extends DBObjetoPersistente {

	public static final String OID_VAL_FILTRO_DET = "oid_val_filtro_det";
	public static final String OID_FILTRO_CAB = "oid_filtro_cab";
	public static final String OID_VALOR = "oid_valor";
	public static final String TIPO = "tipo";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_TIPO_FILTRO = 100;
	public static final int SELECT_BY_TIPO_FILTRO_VALOR = 101;
	public static final int SELECT_BY_FILTRO = 102;

	public DBFiltroValLegCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VAL_FILTRO_DET = 1;
		final int OID_FILTRO_CAB = 2;
		final int OID_VALOR = 3;
		final int TIPO = 4;
		final int ACTIVO = 5;

		FiltroValLegCab pers = (FiltroValLegCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into rhValFilLegCab " + " ( " + "OID_VAL_FILTRO_DET," + "OID_FILTRO_CAB," + "OID_VALOR," + "TIPO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VAL_FILTRO_DET, pers.getOID());
		qInsert.setInt(OID_FILTRO_CAB, pers.getFiltro_cab().getOID());
		qInsert.setInt(OID_VALOR, pers.getOid_valor().intValue());
		qInsert.setString(TIPO, pers.getTipo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FILTRO_CAB = 1;
		final int OID_VALOR = 2;
		final int TIPO = 3;
		final int ACTIVO = 4;
		final int OID_VAL_FILTRO_DET = 5;

		FiltroValLegCab pers = (FiltroValLegCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhValFilLegCab set " + "oid_filtro_cab=?" + ",oid_valor=?" + ",tipo=?" + ",activo=?" + " where " + " oid_val_filtro_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_FILTRO_DET, pers.getOID());
		qUpdate.setInt(OID_FILTRO_CAB, pers.getFiltro_cab().getOID());
		qUpdate.setInt(OID_VALOR, pers.getOid_valor().intValue());
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VAL_FILTRO_DET = 1;
		FiltroValLegCab pers = (FiltroValLegCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhValFilLegCab " + " set activo=0 " + " where " + " oid_val_filtro_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_FILTRO_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VAL_FILTRO_DET = 1;
		FiltroValLegCab pers = (FiltroValLegCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhValFilLegCab " + " set activo=1 " + " where " + " oid_val_filtro_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_FILTRO_DET, pers.getOID());
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
		case SELECT_BY_TIPO_FILTRO: {
			ps = this.selectByTipoFiltro(aCondiciones);
			break;			
		}
		case SELECT_BY_TIPO_FILTRO_VALOR: {
			ps = this.selectByTipoFiltroValor(aCondiciones);
			break;
		}
		case SELECT_BY_FILTRO: {
			ps = this.selectByFiltro(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VAL_FILTRO_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhValFilLegCab ");
		textSQL.append(" WHERE oid_val_filtro_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VAL_FILTRO_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByFiltro(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhValFilLegCab ");
		textSQL.append(" WHERE oid_filtro_cab = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		FiltroLegCab filtro = (FiltroLegCab) aCondiciones;
		querySelect.setInt(1, filtro.getOID());
		return querySelect;
		
	}	
	
	
	private PreparedStatement selectByTipoFiltro(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhValFilLegCab ");
		textSQL.append(" WHERE oid_filtro_cab = ? and tipo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		FiltroLegCab filtro = (FiltroLegCab) condiciones.get(FiltroLegCab.NICKNAME);
		String tipo = (String) condiciones.get("TIPO");
		querySelect.setInt(1, filtro.getOID());
		querySelect.setString(2, tipo);
		return querySelect;
		
	}	
	
	
	private PreparedStatement selectByTipoFiltroValor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhValFilLegCab ");
		textSQL.append(" WHERE oid_filtro_cab = ? and tipo = ? and oid_valor = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		FiltroLegCab filtro = (FiltroLegCab) condiciones.get(FiltroLegCab.NICKNAME);
		String tipo = (String) condiciones.get("TIPO");
		Integer oidValor = (Integer) condiciones.get("OID_VALOR"); 
		querySelect.setInt(1, filtro.getOID());
		querySelect.setString(2, tipo);
		querySelect.setInt(3, oidValor.intValue());
		
		return querySelect;
		
	}	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhValFilLegCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_val_filtro_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhValFilLegCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getFiltroValLegCab(
			  FiltroLegCab filtro,
			  String tipo,
              ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(FiltroLegCab.NICKNAME, filtro);
		condiciones.put("TIPO", tipo);
		
		return (List) ObjetoLogico.getObjects(FiltroValLegCab.NICKNAME,
                 DBFiltroValLegCab.SELECT_BY_TIPO_FILTRO,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}	
	
	public static List getFiltroValLegCab(
			  FiltroLegCab filtro,
            ISesion aSesion) throws BaseException {
		
		return (List) ObjetoLogico.getObjects(FiltroValLegCab.NICKNAME,
               DBFiltroValLegCab.SELECT_BY_FILTRO,
               filtro,
               new ListObserver(),
               aSesion);
	}	
	
	public static FiltroValLegCab getFiltroValLegCab(
			  FiltroLegCab filtro,
			  String tipo,
			  Integer oidValor,
	          ISesion aSesion)
	          throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(FiltroLegCab.NICKNAME, filtro);
		condiciones.put("TIPO", tipo);
		condiciones.put("OID_VALOR", oidValor);
		
		return (FiltroValLegCab) ObjetoLogico.getObjects(FiltroValLegCab.NICKNAME,
				  				DBFiltroValLegCab.SELECT_BY_TIPO_FILTRO_VALOR,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	}	

}
