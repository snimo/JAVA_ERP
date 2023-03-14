package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
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

public class DBLegajoRotaFecha extends DBObjetoPersistente {

	public static final String OID_LEG_ROT_FEC = "oid_leg_rot_fec";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_ROTA = "oid_rota";
	public static final String FECHA = "fecha";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CONDICIONES = 100;
	public static final int SELECT_BY_LEGAJO_FECHA = 101;
	public static final int SELECT_BY_LEGAJO_FECHA_ACTIVO = 102;
	public static final int SELECT_BY_FECHA = 103;
	public static final int SELECT_BY_LEG_ROT_FEC = 104;
	public static final int SELECT_BY_LEGA_Y_MAYIGUAFEC = 105;
	public static final int SELECT_BY_CONDI_DIST_MESAS = 106;

	public DBLegajoRotaFecha() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEG_ROT_FEC = 1;
		final int OID_LEGAJO = 2;
		final int OID_ROTA = 3;
		final int FECHA = 4;
		final int ACTIVO = 5;

		LegajoRotaFecha pers = (LegajoRotaFecha) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipLegRotFec " + " ( " + "OID_LEG_ROT_FEC," + "OID_LEGAJO," + "OID_ROTA," + "FECHA," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LEG_ROT_FEC, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setInt(OID_ROTA, pers.getRota().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int OID_ROTA = 2;
		final int FECHA = 3;
		final int ACTIVO = 4;
		final int OID_LEG_ROT_FEC = 5;

		LegajoRotaFecha pers = (LegajoRotaFecha) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipLegRotFec set " + "oid_legajo=?" + ",oid_rota=?" + ",fecha=?" + ",activo=?" + " where "
				+ " oid_leg_rot_fec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEG_ROT_FEC, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setInt(OID_ROTA, pers.getRota().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LEG_ROT_FEC = 1;
		LegajoRotaFecha pers = (LegajoRotaFecha) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipLegRotFec " + " set activo=0 " + " where " + " oid_leg_rot_fec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEG_ROT_FEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LEG_ROT_FEC = 1;
		LegajoRotaFecha pers = (LegajoRotaFecha) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipLegRotFec " + " set activo=1 " + " where " + " oid_leg_rot_fec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEG_ROT_FEC, pers.getOID());
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
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_FECHA: {
			ps = this.selectByLegajoFecha(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_FECHA_ACTIVO: {
			ps = this.selectByLegajoFechaActivo(aCondiciones);
			break;
		}
		case SELECT_BY_FECHA: {
			ps = this.selectByFecha(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_ROT_FEC: {
			ps = this.selectByLegajoRotaFecha(aCondiciones);
			break;
		}
		case SELECT_BY_LEGA_Y_MAYIGUAFEC: {
			ps = this.selectByLegajoMayIgualFec(aCondiciones);
			break;
		}
		case SELECT_BY_CONDI_DIST_MESAS: {
			ps = this.selectByCondiDistMesas(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LEG_ROT_FEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE oid_leg_rot_fec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LEG_ROT_FEC, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByLegajoMayIgualFec(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE oid_legajo=? and fecha>=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByLegajoRotaFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE oid_legajo=? and fecha=? and oid_rota=? AND activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setInt(3, rota.getOID());
		return querySelect;
	}
	
	

	private PreparedStatement selectByLegajoFechaActivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE oid_legajo=? and fecha=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE fecha=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByLegajoFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE oid_legajo=? and fecha=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCondiDistMesas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		FiltroLegCab filtro = (FiltroLegCab)  condiciones.get(FiltroLegCab.NICKNAME);
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());		
		
		
		Rota rota = (Rota) condiciones.get(Rota.NICKNAME);		
		
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE fecha  >= ? and fecha<=? and activo=1   ");
		
		if (rota!=null)
			textSQL.append(" and oid_rota="+rota.getOIDInteger()+" ");
		
		List listaValEmp = filtro.getValoresFiltroEmpresa();
		if (listaValEmp.size()>0) {
			String armarCondIN = "";
			Iterator iterValEmp = listaValEmp.iterator();
			while (iterValEmp.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEmp.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEmpresa.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		
		if (condiciones.containsKey("JUEGOS")) {
			List listaJuegos = new ArrayList();
			String juegos = (String) condiciones.get("JUEGOS");
			StringTokenizer st =
				new StringTokenizer(juegos,",");
			int i=1;
			while (st.hasMoreTokens()) {
			    String valor = st.nextToken();
			    listaJuegos.add(valor);
			}
		
			String armarCondIN = " and oid_legajo in (select b.oid_legajo from rhGradosLeg a , sulegajo b where a.oid_grado_leg = b.oid_grado_leg ";
			armarCondIN = armarCondIN + " and (";
			
			boolean firstTime = true;
			Iterator iterJuegos = 
				listaJuegos.iterator();
			while (iterJuegos.hasNext()) {
				String juego = (String) iterJuegos.next();
				if (firstTime) {
					armarCondIN = armarCondIN + "descripcion like '%"+juego+"%'";
					firstTime = false;
				} else {
					armarCondIN = armarCondIN + " or descripcion like '%"+juego+"%'";
				}
			}
			armarCondIN = armarCondIN + " )";
			armarCondIN = armarCondIN + " ) ";
			textSQL.append(armarCondIN);			
			
		}
		
		List listaTareas = filtro.getValoresFiltroTareas();
		if (listaTareas.size()>0) {
			String armarCondIN = "";
			Iterator iterValTarea = listaTareas.iterator();
			while (iterValTarea.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValTarea.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_tarea_desemp IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		
		List listaSindicatos = filtro.getValoresFiltroSindicatos();
		if (listaSindicatos.size()>0) {
			String armarCondIN = "";
			Iterator iterValSindicatos = listaSindicatos.iterator();
			while (iterValSindicatos.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSindicatos.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_clase_sind IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValSec = filtro.getValoresFiltroSector();
		if (listaValSec.size()>0) {
			String armarCondIN = "";
			Iterator iterValSec = listaValSec.iterator();
			while (iterValSec.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSec.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifSector.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValPue = filtro.getValoresFiltroPuesto();
		if (listaValPue.size()>0) {
			String armarCondIN = "";
			Iterator iterValPue = listaValPue.iterator();
			while (iterValPue.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValPue.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifPuesto.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		List listaValEst = filtro.getValoresFiltroEstado();
		if (listaValEst.size()>0) {
			String armarCondIN = "";
			Iterator iterValEst = listaValEst.iterator();
			while (iterValEst.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEst.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEstado.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		
		
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE fecha  >= ? and fecha<=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLegRotFec ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_leg_rot_fec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipLegRotFec");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static LegajoRotaFecha getLegajoFechaRota(Legajo legajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put("FECHA", fecha);
		return (LegajoRotaFecha) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME, DBLegajoRotaFecha.SELECT_BY_LEGAJO_FECHA, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getLegajosFechaRotas(java.util.Date fechaDesde, java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fechaDesde);
		condiciones.put("FEC_HASTA", fechaHasta);
		return (List) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME, DBLegajoRotaFecha.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}

	public static LegajoRotaFecha getLegajoRotaFecha(Legajo legajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put("FECHA", fecha);
		return (LegajoRotaFecha) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME, DBLegajoRotaFecha.SELECT_BY_LEGAJO_FECHA_ACTIVO,
				condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getLegajosFechaRotas(java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME, DBLegajoRotaFecha.SELECT_BY_FECHA, condiciones, new ListObserver(),
				aSesion);
	}

	public static List getLegajoMayIgualFecha(
			java.util.Date fecha,
			Legajo legajo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA", fecha);
		condiciones.put(Legajo.NICKNAME, legajo);
		return (List) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME, DBLegajoRotaFecha.SELECT_BY_LEGA_Y_MAYIGUAFEC, condiciones, new ListObserver(),
				aSesion);
	}
	
	public static List getConsPlanifDistMesas(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			Rota rota,
			FiltroLegCab filtro,
			String juegos,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		
		if ((juegos!=null) && (juegos.trim().length()!=0))
			condiciones.put("JUEGOS", juegos);
		
		if (filtro!=null)
			condiciones.put(FiltroLegCab.NICKNAME, filtro);
		
		if (rota!=null)
			condiciones.put(Rota.NICKNAME, rota);
		return (List) ObjetoLogico.getObjects(
				LegajoRotaFecha.NICKNAME, 
				DBLegajoRotaFecha.SELECT_BY_CONDI_DIST_MESAS, 
				condiciones, 
				new ListObserver(),
				aSesion);
	}	
	
	
	public static int getCantLegPorFecha(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT count(*) ");
			textSQL.append(" from cipLegRotFec where  oid_rota = ? and fecha = ? and activo=1 ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			
			HashTableDatos condiciones = (HashTableDatos) aCondiciones;
			Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
			java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

			querySelect.setInt(1, rota.getOID());
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
			
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	  public static LegajoRotaFecha getLegajoFechaRota(
			  java.util.Date fecha,
			  Legajo legajo,
			  Rota rota,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("FECHA", fecha);
		  condiciones.put(Legajo.NICKNAME, legajo);
		  condiciones.put(Rota.NICKNAME, rota);
		  return (LegajoRotaFecha) ObjetoLogico.getObjects(LegajoRotaFecha.NICKNAME,
				  				DBLegajoRotaFecha.SELECT_BY_LEG_ROT_FEC,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	

}
