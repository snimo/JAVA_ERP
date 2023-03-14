package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.contabilidad.bl.CrearTablaCompo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBComponente extends DBObjetoPersistente {

	public static final String OID_COMPO = "oid_compo";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String TIPO = "tipo";

	public static final String ACTIVO = "activo";

	public static final String NRO_CLASIFICADOR = "nro_clasificador";

	public static final String NOMBRE_NICKNAME = "nombre_nickname";
	
	public static final String LONGITUD = "longitud";
	
	public static final String PRECISION = "decimales";

	public static final int SELECT_BY_NICKNAME_NROCLASIF = 100;

	public static final int SELECT_BY_TIPO_NICKNAME = 101;
	
	public static final int SELECT_BY_HELP_COMPO_ESTANDAR = 102;
	
	
	
	

	public DBComponente() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_COMPO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int TIPO = 4;
		final int ACTIVO = 5;
		final int NRO_CLASIFICADOR = 6;
		final int NOMBRE_NICKNAME = 7;
		final int LONGITUD = 8;
		final int PRECISION = 9;

		Componente pers = (Componente) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgCompo " + " ( " + "OID_COMPO,"
				+ "CODIGO," + "DESCRIPCION," + "TIPO," + "ACTIVO,"
				+ "NRO_CLASIFICADOR," + "NOMBRE_NICKNAME , LONGITUD , DECIMALES)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "? , ? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COMPO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(TIPO, pers.getTipo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getNroClasificador() != null)
			qInsert.setInt(NRO_CLASIFICADOR, pers.getNroClasificador()
					.intValue());
		else
			qInsert.setNull(NRO_CLASIFICADOR, java.sql.Types.INTEGER);
		if (pers.getNombreNickName() != null)
			qInsert.setString(NOMBRE_NICKNAME, pers.getNombreNickName());
		else
			qInsert.setNull(NOMBRE_NICKNAME, java.sql.Types.VARCHAR);
		if (pers.getLongitud()!=null)
			qInsert.setInt(LONGITUD,pers.getLongitud().intValue());
		else
			qInsert.setNull(LONGITUD,Types.INTEGER);
		if (pers.getPrecision()!=null)
			qInsert.setInt(PRECISION,pers.getPrecision().intValue());
		else
			qInsert.setNull(PRECISION,Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();

		CrearTablaCompo crearTablaCompo = new CrearTablaCompo();
		crearTablaCompo.setComponente(pers);

		// Crear Dinamicamente la Tabla de Componentes
		PreparedStatement qCrearTabla = getSesion().getConexionBD()
				.prepareStatement(crearTablaCompo.getScriptCrearTabla());
		qCrearTabla.executeUpdate();
		qCrearTabla.close();

		// Crear Dinamincamente el Indice
		PreparedStatement qCrearIndice = getSesion().getConexionBD()
				.prepareStatement(crearTablaCompo.getScriptCrearIndice());
		qCrearIndice.executeUpdate();
		qCrearIndice.close();

		// Agregar el campo del componente a la tabla de analiticas imputables
		PreparedStatement qCrearCampoCompo = getSesion().getConexionBD()
				.prepareStatement(
						crearTablaCompo.getScriptAddCampoCompoToTableAnaImp());
		qCrearCampoCompo.executeUpdate();
		qCrearCampoCompo.close();

	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int TIPO = 3;
		final int ACTIVO = 4;
		final int NRO_CLASIFICADOR = 5;
		final int NOMBRE_NICKNAME = 6;
		final int LONGITUD = 7;
		final int PRECISION = 8;
		final int OID_COMPO = 9;

		Componente pers = (Componente) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgCompo set " + "codigo=?" + ",descripcion=?"
				+ ",tipo=?" + ",activo=?" + ",nro_clasificador=?"
				+ ",nombre_nickname=? , longitud=? , decimales=? " + " where " + " oid_compo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMPO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getNroClasificador() != null)
			qUpdate.setInt(NRO_CLASIFICADOR, pers.getNroClasificador()
					.intValue());
		else
			qUpdate.setNull(NRO_CLASIFICADOR, java.sql.Types.INTEGER);
		if (pers.getNombreNickName() != null)
			qUpdate.setString(NOMBRE_NICKNAME, pers.getNombreNickName());
		else
			qUpdate.setNull(NOMBRE_NICKNAME, java.sql.Types.VARCHAR);
		if (pers.getLongitud()!=null)
			qUpdate.setInt(LONGITUD,pers.getLongitud().intValue());
		else
			qUpdate.setNull(LONGITUD,Types.INTEGER);
		if (pers.getPrecision()!=null)
			qUpdate.setInt(PRECISION,pers.getPrecision().intValue());
		else
			qUpdate.setNull(PRECISION,Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_COMPO = 1;
		Componente pers = (Componente) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgCompo " + " set activo=0 " + " where "
				+ " oid_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_COMPO = 1;
		Componente pers = (Componente) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgCompo " + " set activo=1 " + " where "
				+ " oid_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMPO, pers.getOID());
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
		case SELECT_BY_HELP_COMPO_ESTANDAR : {
			ps = this.selectByHelpCompoEstandar(aCondiciones);
			break;
		}
		case SELECT_BY_NICKNAME_NROCLASIF: {
			ps = this.selectByNickNameNroClasif(aCondiciones);
			break;
		}
		case SELECT_BY_TIPO_NICKNAME: {
			ps = this.selectByTipoNickName(aCondiciones);
			break;
		}
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_COMPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCompo ");
		textSQL.append(" WHERE oid_compo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COMPO, oid);
		return querySelect;
	}

	private PreparedStatement selectByTipoNickName(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCompo ");
		textSQL.append(" WHERE tipo = ? and nombre_nickname = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String tipo = (String) condiciones.get("tipo");
		String nickname = (String) condiciones.get("nickname");
		querySelect.setString(1, tipo);
		querySelect.setString(2, nickname);
		return querySelect;
	}
	
	private PreparedStatement selectAll(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCompo ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCompo ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByNickNameNroClasif(Object aCondiciones)
			throws BaseException, SQLException {
		final int CODIGO = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCompo ");
		textSQL.append(" WHERE nombre_nickname = ? and nro_clasificador = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String nickname = (String) condiciones.get("nickname");
		Integer nroClasificador = (Integer) condiciones.get("nro_clasificador");
		;
		querySelect.setString(1, nickname);
		querySelect.setInt(2, nroClasificador.intValue());
		return querySelect;
	}
	
	private PreparedStatement selectByHelpCompoEstandar(Object aCondiciones)
		throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_compo oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cgCompo where tipo = 'STD' order by oid_compo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_compo oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cgCompo order by oid_compo");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllComponentes(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Componente.NICKNAME, SELECT_ALL,
				null, new ListObserver(), aSesion);

	}

	public static Componente getComponente(String nickname,
			Integer nroClasificador, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("nickname", nickname);
		condiciones.put("nro_clasificador", nroClasificador);
		return (Componente) ObjetoLogico.getObjects(Componente.NICKNAME,
				DBComponente.SELECT_BY_NICKNAME_NROCLASIF, condiciones,
				new ObjetoObservado(), aSesion);
	}
	
	public static Componente getComponente(String tipo,String nickname,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("tipo", tipo);
		condiciones.put("nickname", nickname);
		return (Componente) ObjetoLogico.getObjects(Componente.NICKNAME,
				DBComponente.SELECT_BY_TIPO_NICKNAME, condiciones,
				new ObjetoObservado(), aSesion);
	}	
	
	

}
