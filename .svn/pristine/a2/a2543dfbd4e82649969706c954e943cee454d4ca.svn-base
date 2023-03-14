package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoPuertaCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCategAccesoPuertaCIP extends DBObjetoPersistente {

	public static final String OID_CATEG_ACC_PUE = "oid_categ_acc_pue";
	public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String HAB_ENTRADA = "hab_entrada";
	public static final String HAB_SALIDA = "hab_salida";
	public static final String ACTIVO = "activo";

	public static final int SELECT_CATEGORIA_PUERTA = 100;
	public static final int SELECT_BY_CATEGORIA = 101;
	public static final int SELECT_BY_ENTHAB_CATEGACCESO_PUE = 102;
	public static final int SELECT_BY_LEGAJO_ENTRADA = 103;
	public static final int SELECT_BY_CATEGASIG_LEG = 104;
	public static final int SELECT_BY_SALHAB_CATEGACCESO_PUE = 105;

	public DBCategAccesoPuertaCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CATEG_ACC_PUE = 1;
		final int OID_CATEG_ACCESO = 2;
		final int OID_PUERTA = 3;
		final int HAB_ENTRADA = 4;
		final int HAB_SALIDA = 5;
		final int ACTIVO = 6;

		CategAccesoPuertaCIP pers = (CategAccesoPuertaCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipCategAccesoPue " + " ( "
				+ "OID_CATEG_ACC_PUE," + "OID_CATEG_ACCESO," + "OID_PUERTA,"
				+ "HAB_ENTRADA," + "HAB_SALIDA," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CATEG_ACC_PUE, pers.getOID());
		qInsert.setInt(OID_CATEG_ACCESO, pers.getCategoria().getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qInsert.setBoolean(HAB_ENTRADA, pers.isHab_entrada().booleanValue());
		qInsert.setBoolean(HAB_SALIDA, pers.isHab_salida().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CATEG_ACCESO = 1;
		final int OID_PUERTA = 2;
		final int HAB_ENTRADA = 3;
		final int HAB_SALIDA = 4;
		final int ACTIVO = 5;
		final int OID_CATEG_ACC_PUE = 6;

		CategAccesoPuertaCIP pers = (CategAccesoPuertaCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipCategAccesoPue set "
				+ "oid_categ_acceso=?" + ",oid_puerta=?" + ",hab_entrada=?"
				+ ",hab_salida=?" + ",activo=?" + " where "
				+ " oid_categ_acc_pue=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_ACC_PUE, pers.getOID());
		qUpdate.setInt(OID_CATEG_ACCESO, pers.getCategoria().getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qUpdate.setBoolean(HAB_ENTRADA, pers.isHab_entrada().booleanValue());
		qUpdate.setBoolean(HAB_SALIDA, pers.isHab_salida().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CATEG_ACC_PUE = 1;
		CategAccesoPuertaCIP pers = (CategAccesoPuertaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCategAccesoPue " + " set activo=0 "
				+ " where " + " oid_categ_acc_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_ACC_PUE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CATEG_ACC_PUE = 1;
		CategAccesoPuertaCIP pers = (CategAccesoPuertaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCategAccesoPue " + " set activo=1 "
				+ " where " + " oid_categ_acc_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_ACC_PUE, pers.getOID());
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
		case SELECT_CATEGORIA_PUERTA: {
			ps = this.selectByCategoriaPuerta(aCondiciones);
			break;
		}
		case SELECT_BY_CATEGORIA: {
			ps = this.selectByCategoria(aCondiciones);
			break;
		}
		case SELECT_BY_ENTHAB_CATEGACCESO_PUE: {
			ps = this.selectByEntHabCategAccesoPuerta(aCondiciones);
			break;
		}
		case SELECT_BY_SALHAB_CATEGACCESO_PUE: {
			ps = this.selectBySalHabCategAccesoPuerta(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_ENTRADA: {
			ps = this.selectByLegajoEntrada(aCondiciones);
			break;
		}
		case SELECT_BY_CATEGASIG_LEG: {
			ps = this.selectByLegajoCategAsig(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CATEG_ACC_PUE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
		textSQL.append(" WHERE oid_categ_acc_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CATEG_ACC_PUE, oid);
		return querySelect;
	}

	private PreparedStatement selectByEntHabCategAccesoPuerta(
			Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
		textSQL
				.append(" WHERE activo = 1 and hab_entrada = 1 and oid_categ_acceso = ? and oid_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CategAccesoCIP categAccesoCIP = (CategAccesoCIP) condiciones
				.get(CategAccesoCIP.NICKNAME);
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		querySelect.setInt(1, categAccesoCIP.getOID());
		querySelect.setInt(2, puerta.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectBySalHabCategAccesoPuerta(
			Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
		textSQL
				.append(" WHERE activo = 1 and hab_salida = 1 and oid_categ_acceso = ? and oid_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CategAccesoCIP categAccesoCIP = (CategAccesoCIP) condiciones
				.get(CategAccesoCIP.NICKNAME);
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		querySelect.setInt(1, categAccesoCIP.getOID());
		querySelect.setInt(2, puerta.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectByCategoriaPuerta(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
		textSQL
				.append(" WHERE oid_categ_acceso  = ? and oid_puerta = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CategAccesoCIP categAccesoCIP = (CategAccesoCIP) condiciones
				.get(CategAccesoCIP.NICKNAME);
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		querySelect.setInt(1, categAccesoCIP.getOID());
		querySelect.setInt(2, puerta.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByLegajoCategAsig(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from cipCategAccesoPue where activo = 1 and oid_categ_acceso in ( ");
		textSQL.append(" 		select ");
		textSQL.append("		  a2.oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccLeg a2 ");
		textSQL.append("		where ");
		textSQL.append("		  a2.activo = 1 and a2.oid_legajo = ? ");
		textSQL.append("		union all ");
		textSQL.append("		select  ");
		textSQL.append("		  a1.oid_categ_acceso "); 
		textSQL.append("		from  ");
		textSQL.append("		  cipCategAccEstado  a1, ");
		textSQL.append("		  suLegajo b1 ");
		textSQL.append("		where  ");
		textSQL.append("		  a1.oid_estado = b1.oid_estado and "); 
		textSQL.append("		  a1.activo = 1 and  ");
		textSQL.append("		  b1.oid_legajo = ? and  ");
		textSQL.append("		  b1.activo = 1 "); 
		textSQL.append("		union all ");
		textSQL.append("		select ");
		textSQL.append("		  oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccVClasif a3 , ");
		textSQL.append("		  suLegajo b3 ");
		textSQL.append("		where ");
		textSQL.append("		  a3.activo = 1 and ");
		textSQL.append("		  b3.activo = 1 and ");
		textSQL.append("		  b3.oid_legajo = ? and ");
		textSQL.append("		  (a3.oid_val_clasif_ent = b3.oid_clasif_01 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_02 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_03 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_04 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_05 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_06 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_07 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_08 or "); 
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_09 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_10 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_11 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_12 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_13 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_14 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_15 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_16 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_17 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_18 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_19 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_20) ");
		textSQL.append("		) ");		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, legajo.getOID());
		querySelect.setInt(3, legajo.getOID());
		return querySelect;
		
	}
	

	private PreparedStatement selectByLegajoEntrada(Object aCondiciones)
	throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from cipCategAccesoPue where activo = 1 and oid_puerta=? and hab_entrada = 1 and oid_categ_acceso in ( ");
		textSQL.append(" 		select ");
		textSQL.append("		  a2.oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccLeg a2 ");
		textSQL.append("		where ");
		textSQL.append("		  a2.activo = 1 and a2.oid_legajo = ? ");
		textSQL.append("		union all ");
		textSQL.append("		select  ");
		textSQL.append("		  a1.oid_categ_acceso "); 
		textSQL.append("		from  ");
		textSQL.append("		  cipCategAccEstado  a1, ");
		textSQL.append("		  suLegajo b1 ");
		textSQL.append("		where  ");
		textSQL.append("		  a1.oid_estado = b1.oid_estado and "); 
		textSQL.append("		  a1.activo = 1 and  ");
		textSQL.append("		  b1.oid_legajo = ? and  ");
		textSQL.append("		  b1.activo = 1 "); 
		textSQL.append("		union all ");
		textSQL.append("		select ");
		textSQL.append("		  oid_categ_acceso ");
		textSQL.append("		from ");
		textSQL.append("		  cipCategAccVClasif a3 , ");
		textSQL.append("		  suLegajo b3 ");
		textSQL.append("		where ");
		textSQL.append("		  a3.activo = 1 and ");
		textSQL.append("		  b3.activo = 1 and ");
		textSQL.append("		  b3.oid_legajo = ? and ");
		textSQL.append("		  (a3.oid_val_clasif_ent = b3.oid_clasif_01 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_02 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_03 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_04 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_05 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_06 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_07 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_08 or "); 
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_09 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_10 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_11 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_12 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_13 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_14 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_15 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_16 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_17 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_18 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_19 or ");
		textSQL.append("		   a3.oid_val_clasif_ent = b3.oid_clasif_20) ");
		textSQL.append("		) ");		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		querySelect.setInt(1, puerta.getOID());
		querySelect.setInt(2, legajo.getOID());
		querySelect.setInt(3, legajo.getOID());
		querySelect.setInt(4, legajo.getOID());
		return querySelect;
		
	}

	private PreparedStatement selectByCategoria(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
		textSQL.append(" WHERE oid_categ_acceso = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		CategAccesoCIP categoria = (CategAccesoCIP) aCondiciones;
		querySelect.setInt(1, categoria.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategAccesoPue ");
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
				.append("SELECT oid_categ_acc_pue oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipCategAccesoPue");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static CategAccesoPuertaCIP getCategAccesoPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CategAccesoCIP.NICKNAME, categoria);
		condiciones.put(Puerta.NICKNAME, puerta);

		return (CategAccesoPuertaCIP) ObjetoLogico.getObjects(
				CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_CATEGORIA_PUERTA, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getCategAccesoPuerta(CategAccesoCIP categoria,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_BY_CATEGORIA, categoria,
				new ListObserver(), aSesion);
	}
	
	public static List getCategAccesoEntradaByPuertaLegajo(Legajo legajo,Puerta puerta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Puerta.NICKNAME, puerta);
		condiciones.put(Legajo.NICKNAME, legajo);
		return (List) ObjetoLogico.getObjects(CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_BY_LEGAJO_ENTRADA, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getCategAccesoHabilitadasLeg(
			Legajo legajo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		return (List) ObjetoLogico.getObjects(CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_BY_CATEGASIG_LEG, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	public static CategAccesoPuertaCIP getCategAccesoEntradaPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CategAccesoCIP.NICKNAME, categoria);
		condiciones.put(Puerta.NICKNAME, puerta);
		return (CategAccesoPuertaCIP) ObjetoLogico.getObjects(
				CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_BY_ENTHAB_CATEGACCESO_PUE,
				condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static CategAccesoPuertaCIP getCategAccesoSalidaPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CategAccesoCIP.NICKNAME, categoria);
		condiciones.put(Puerta.NICKNAME, puerta);
		return (CategAccesoPuertaCIP) ObjetoLogico.getObjects(
				CategAccesoPuertaCIP.NICKNAME,
				DBCategAccesoPuertaCIP.SELECT_BY_SALHAB_CATEGACCESO_PUE,
				condiciones, new ObjetoObservado(), aSesion);
	}
	

}
