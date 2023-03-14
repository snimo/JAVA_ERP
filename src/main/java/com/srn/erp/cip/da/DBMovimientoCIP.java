package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.MovimientoCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBMovimientoCIP extends DBObjetoPersistente {

	public static final String OID_MOV = "oid_mov";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String FECHA = "fecha";
	public static final String HORA = "hora";
	public static final String HORA_EN_MIN = "hora_en_min";
	public static final String SENTIDO = "sentido";
	public static final String ACTIVO = "activo";
	public static final String FEC_HOR = "fec_hor";
	public static final String OID_ZONA_ORIGEN = "oid_zona_origen";
	public static final String OID_ZONA_DESTINO = "oid_zona_destino";

	public static final int SELECT_BY_CONDICIONES = 100;
	public static final int SELECT_MOV_ULT_DIA_LEGAJO = 101;

	public DBMovimientoCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOV = 1;
		final int OID_LEGAJO = 2;
		final int OID_PUERTA = 3;
		final int FECHA = 4;
		final int HORA = 5;
		final int HORA_EN_MIN = 6;
		final int SENTIDO = 7;
		final int ACTIVO = 8;
		final int FEC_HOR = 9;
		final int OID_ZONA_ORIGEN = 10;
		final int OID_ZONA_DESTINO = 11;

		MovimientoCIP pers = (MovimientoCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipMovimientos " + " ( " + "OID_MOV," + "OID_LEGAJO," + "OID_PUERTA," + "FECHA," + "HORA,"
				+ "HORA_EN_MIN," + "SENTIDO," + "ACTIVO,FEC_HOR , OID_ZONA_ORIGEN , OID_ZONA_DESTINO)" + " values " + "(" + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOV, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setString(HORA, pers.getHora());
		qInsert.setInt(HORA_EN_MIN, pers.getHora_en_min().intValue());
		qInsert.setString(SENTIDO, pers.getSentido());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setTimestamp(FEC_HOR, new java.sql.Timestamp(pers.getFecHor().getTime()));
		if (pers.getZonaOrigen()!=null)
			qInsert.setInt(OID_ZONA_ORIGEN, pers.getZonaOrigen().getOID());
		else
			qInsert.setNull(OID_ZONA_ORIGEN,Types.INTEGER);
		if (pers.getZonaDestino()!=null)
			qInsert.setInt(OID_ZONA_DESTINO, pers.getZonaDestino().getOID());
		else
			qInsert.setNull(OID_ZONA_DESTINO,Types.INTEGER);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int OID_PUERTA = 2;
		final int FECHA = 3;
		final int HORA = 4;
		final int HORA_EN_MIN = 5;
		final int SENTIDO = 6;
		final int ACTIVO = 7;
		final int FEC_HOR = 8;
		final int OID_ZONA_ORIGEN = 9;
		final int OID_ZONA_DESTINO  =10;
		final int OID_MOV = 11;

		MovimientoCIP pers = (MovimientoCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipMovimientos set " + "oid_legajo=?" + ",oid_puerta=?" + ",fecha=?" + ",hora=?" + ",hora_en_min=?"
				+ ",sentido=?" + ",activo=? , fec_hor=? , oid_zona_origen = ? , oid_zona_destino = ? " + " where " + " oid_mov=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setString(HORA, pers.getHora());
		qUpdate.setInt(HORA_EN_MIN, pers.getHora_en_min().intValue());
		qUpdate.setString(SENTIDO, pers.getSentido());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setTimestamp(FEC_HOR, new java.sql.Timestamp(pers.getFecHor().getTime()));
		if (pers.getZonaOrigen()!=null)
			qUpdate.setInt(OID_ZONA_ORIGEN, pers.getZonaOrigen().getOID());
		else
			qUpdate.setNull(OID_ZONA_ORIGEN,Types.INTEGER);
		if (pers.getZonaDestino()!=null)
			qUpdate.setInt(OID_ZONA_DESTINO, pers.getZonaDestino().getOID());
		else
			qUpdate.setNull(OID_ZONA_DESTINO,Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOV = 1;
		MovimientoCIP pers = (MovimientoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMovimientos " + " set activo=0 " + " where " + " oid_mov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOV = 1;
		MovimientoCIP pers = (MovimientoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMovimientos " + " set activo=1 " + " where " + " oid_mov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV, pers.getOID());
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
		case SELECT_MOV_ULT_DIA_LEGAJO: {
			ps = this.selectMovUltDiaLegajo(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMovimientos a  ");
		textSQL.append(" WHERE oid_mov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOV, oid);
		return querySelect;
	}
	
	
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cipMovimientos a, suLegajo b WHERE a.oid_legajo=b.oid_legajo and a.fecha>=? and a.fecha<=? ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		List legajos = (List) condiciones.get("LISTA_LEGAJOS");
		StringBuffer condOIDLegajo = new StringBuffer("");
		if ((legajos != null) && (legajos.size() > 0)) {
			Iterator iterLegajos = legajos.iterator();
			while (iterLegajos.hasNext()) {
				Integer oidLegajo = (Integer) iterLegajos.next();
				if (condOIDLegajo.length() == 0)
					condOIDLegajo.append(oidLegajo.toString());
				else
					condOIDLegajo.append("," + oidLegajo.toString());
			}
			textSQL.append(" and a.oid_legajo in (" + condOIDLegajo.toString() + ") ");
		}
		
		
		// Filtrar por Valores de clasificador
		HashTableDatos hashTableClasif = new HashTableDatos();
		List listaValClasif = (List) condiciones.get("LISTA_VAL_CLASIF");
		if (listaValClasif != null) {

			Iterator iterValClasif = listaValClasif.iterator();
			while (iterValClasif.hasNext()) {
				ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
				HashTableDatos htValClasif = (HashTableDatos) hashTableClasif.get(valClasifEnt.getClasificador_entidad().getOIDInteger());
				if (htValClasif == null) {
					htValClasif = new HashTableDatos();
					hashTableClasif.put(valClasifEnt.getClasificador_entidad().getOIDInteger(), htValClasif);
				}
				htValClasif.put(valClasifEnt.getOIDInteger(), valClasifEnt);
			}

			Iterator iterGrupoValClasif = hashTableClasif.values().iterator();
			while (iterGrupoValClasif.hasNext()) {
				HashTableDatos datos = (HashTableDatos) iterGrupoValClasif.next();
				Iterator iterValClasif1 = datos.values().iterator();
				int j = 1;
				while (iterValClasif1.hasNext()) {
					ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif1.next();
					if (j == 1)
						textSQL.append(" and (");
					else
						textSQL.append(" or ");
					textSQL.append("b."+valClasifEnt.getClasificador_entidad().getCampoFisico() + "=" + valClasifEnt.getOIDInteger());
					++j;

				}
				if (j > 1)
					textSQL.append(" ) ");
			}

		}
		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		
		
		
		
		return querySelect;
	}

	
	private PreparedStatement selectMovUltDiaLegajo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from CIPMOVIMIENTOS where "); 
		textSQL.append(" fecha=(select max(fecha) from CIPMOVIMIENTOS where oid_legajo=? and activo=1 ) ");
		textSQL.append(" and oid_legajo=? and activo=1 order by fecha desc, hora desc ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, legajo.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMovimientos ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mov oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMovimientos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMovimientosCIP(java.util.Date fecDesde, java.util.Date fecHasta, ClasificadorEntidad titulo, List listaLegajos,
			List listaValoresClasif, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		if (titulo!=null)
			condiciones.put(ClasificadorEntidad.NICKNAME, titulo);
		condiciones.put("LISTA_LEGAJOS", listaLegajos);
		condiciones.put("LISTA_VAL_CLASIF", listaValoresClasif);

		return (List) ObjetoLogico.getObjects(MovimientoCIP.NICKNAME, DBMovimientoCIP.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getMovimientosLegajoUltDia(
			Legajo legajo,
			ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(MovimientoCIP.NICKNAME, DBMovimientoCIP.SELECT_MOV_ULT_DIA_LEGAJO, legajo,
				new ListObserver(), aSesion);
	}	

}
