package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBMovimientoCaja extends DBObjetoPersistente {

	public static final String OID_ARQUEO = "oid_arqueo";
	public static final String OID_CAJA = "oid_caja";
	public static final String OID_CCO = "oid_cco";
	public static final String FECHA_CAJA = "fecha_caja";
	public static final String OID_VALOR = "oid_valor";
	public static final String SIGNO = "signo";
	public static final String IMPORTE = "importe";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String OID_TIPO_VALOR = "oid_tipo_valor";
	public static final String COMPO_TIPO_VALOR = "compo_tipo_valor";
	public static final String COTIZACION = "cotizacion";
	public static final String ENTRADA = "entrada";
	public static final String SALIDA = "salida";
	public static final String ACTIVO = "activo";
	public static final String FECHA_REAL = "fecha_real";
	public static final String HORA_REAL = "hora_real";
	public static final String USUARIO = "oid_usuario";
	public static final String OID_SUJETO = "oid_sujeto";

	public static final int SELECT_BY_MOVIN_DESDE_HASTA = 100;
	public static final int SELECT_BY_VALOR = 101;
	public static final int SELECT_BY_CONDICIONES = 102;

	public DBMovimientoCaja() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ARQUEO = 1;
		final int OID_CAJA = 2;
		final int OID_CCO = 3;
		final int FECHA_CAJA = 4;
		final int OID_VALOR = 5;
		final int SIGNO = 6;
		final int IMPORTE = 7;
		final int OID_MONEDA = 8;
		final int OID_TIPO_VALOR = 9;
		final int COMPO_TIPO_VALOR = 10;
		final int COTIZACION = 11;
		final int ENTRADA = 12;
		final int SALIDA = 13;
		final int ACTIVO = 14;
		final int FECHA_REAL = 15;
		final int HORA_REAL = 16;
		final int USUARIO = 17;
		final int OID_SUJETO = 18;

		MovimientoCaja pers = (MovimientoCaja) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vaArqueo " + " ( " + "OID_ARQUEO," + "OID_CAJA," + "OID_CCO," + "FECHA_CAJA," + "OID_VALOR,"
				+ "SIGNO," + "IMPORTE," + "OID_MONEDA," + "OID_TIPO_VALOR," + "COMPO_TIPO_VALOR," + "COTIZACION," + "ENTRADA," + "SALIDA,"
				+ "ACTIVO," + "FECHA_REAL," + "HORA_REAL," + "OID_USUARIO , OID_SUJETO" + ")" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ARQUEO, pers.getOID());
		qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setDate(FECHA_CAJA, new java.sql.Date(pers.getFechacaja().getTime()));
		if (pers.getValor() != null)
			qInsert.setInt(OID_VALOR, pers.getValor().getOID());
		else
			qInsert.setNull(OID_VALOR, java.sql.Types.INTEGER);
		qInsert.setInt(SIGNO, pers.getSigno().intValue());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setInt(OID_TIPO_VALOR, pers.getTipovalor().getOID());
		qInsert.setString(COMPO_TIPO_VALOR, pers.getCompotipovalor());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.setDouble(ENTRADA, pers.getEntrada().doubleValue());
		qInsert.setDouble(SALIDA, pers.getSalida().doubleValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setDate(FECHA_REAL, new java.sql.Date(pers.getFechaReal().getTime()));
		qInsert.setString(HORA_REAL, pers.getHora());
		qInsert.setInt(USUARIO, pers.getUsuario().getOID());
		if (pers.getSujeto()!=null)
			qInsert.setInt(OID_SUJETO, pers.getSujeto().getOIDInteger());
		else
			qInsert.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CAJA = 1;
		final int OID_CCO = 2;
		final int FECHA_CAJA = 3;
		final int OID_VALOR = 4;
		final int SIGNO = 5;
		final int IMPORTE = 6;
		final int OID_MONEDA = 7;
		final int OID_TIPO_VALOR = 8;
		final int COMPO_TIPO_VALOR = 9;
		final int COTIZACION = 10;
		final int ENTRADA = 11;
		final int SALIDA = 12;
		final int ACTIVO = 13;
		final int FECHA_REAL = 14;
		final int HORA_REAL = 15;
		final int USUARIO = 16;
		final int OID_SUJETO = 17;
		final int OID_ARQUEO = 18;

		MovimientoCaja pers = (MovimientoCaja) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vaArqueo set " + "oid_caja=?" + ",oid_cco=?" + ",fecha_caja=?" + ",oid_valor=?" + ",signo=?"
				+ ",importe=?" + ",oid_moneda=?" + ",oid_tipo_valor=?" + ",compo_tipo_valor=?" + ",cotizacion=?" + ",entrada=?"
				+ ",salida=?" + ",activo=?" + ",fecha_real=?" + ",hora_real=?" + ",oid_usuario=? , oid_sujeto=? " + " where " + " oid_arqueo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARQUEO, pers.getOID());
		qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setDate(FECHA_CAJA, new java.sql.Date(pers.getFechacaja().getTime()));
		if (pers.getValor() != null)
			qUpdate.setInt(OID_VALOR, pers.getValor().getOID());
		else
			qUpdate.setNull(OID_VALOR, java.sql.Types.INTEGER);
		qUpdate.setInt(SIGNO, pers.getSigno().intValue());
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getTipovalor().getOID());
		qUpdate.setString(COMPO_TIPO_VALOR, pers.getCompotipovalor());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setDouble(ENTRADA, pers.getEntrada().doubleValue());
		qUpdate.setDouble(SALIDA, pers.getSalida().doubleValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setDate(FECHA_REAL, new java.sql.Date(pers.getFechaReal().getTime()));
		qUpdate.setString(HORA_REAL, pers.getHora());
		qUpdate.setInt(USUARIO, pers.getUsuario().getOID());
		if (pers.getSujeto()!=null)
			qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOIDInteger());
		else
			qUpdate.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARQUEO = 1;
		MovimientoCaja pers = (MovimientoCaja) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaArqueo " + " set activo=0 " + " where " + " oid_arqueo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARQUEO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARQUEO = 1;
		MovimientoCaja pers = (MovimientoCaja) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaArqueo " + " set activo=1 " + " where " + " oid_arqueo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARQUEO, pers.getOID());
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
		case SELECT_BY_MOVIN_DESDE_HASTA: {
			ps = this.selectByMovinFecDesdeHasta(aCondiciones);
			break;
		}
		case SELECT_BY_VALOR: {
			ps = this.selectByValor(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ARQUEO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaArqueo ");
		textSQL.append(" WHERE oid_arqueo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ARQUEO, oid);
		return querySelect;
	}

	private PreparedStatement selectByMovinFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
		TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME);
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaArqueo ");
		textSQL.append(" WHERE  oid_caja = " + caja.getOIDInteger().toString());
		textSQL.append(" and oid_tipo_valor = " + tipoValor.getOIDInteger().toString());
		textSQL.append(" and fecha_caja>=? and fecha_caja<=? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		final int CODIGO = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaArqueo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByValor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaArqueo ");
		textSQL.append(" WHERE oid_valor  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Valor valor = (Valor) aCondiciones;
		querySelect.setInt(1, valor.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT * ");
		textSQL.append(" from vaArqueo a,gecomprocab b where a.oid_cco=b.oid_cco and b.activo=1  ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		if (condiciones.containsKey("signo")) {
			Integer signo = (Integer) condiciones.get("signo");
			textSQL.append(" and a.signo = "+signo.intValue());
		}
		
		if (condiciones.containsKey(GrupoCajas.NICKNAME)) {
			Integer oidGrupoCaja = (Integer) condiciones.get(GrupoCajas.NICKNAME);
			textSQL.append(" and a.oid_caja in (select oid_caja from vaGrupoCajaDet where oid_grupo_caja="+oidGrupoCaja+") ");
		}
		
		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Integer oidSujeto = (Integer) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto="+oidSujeto);
		}
		
		java.util.Date fecDesde = null;
		if (condiciones.containsKey("FEC_DESDE")) {
			fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
			textSQL.append(" and a.fecha_caja>=?");
		}
		
		java.util.Date fecHasta = null; 
		if (condiciones.containsKey("FEC_HASTA")) {
			fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			textSQL.append(" and a.fecha_caja<=?");
		}
		
		if (condiciones.containsKey("LISTA_TC")) {
			StringBuffer inTC = new StringBuffer("");
			List listaCompro = (List) condiciones.get("LISTA_TC");
			Iterator iterTC = 
				listaCompro.iterator();
			while (iterTC.hasNext()) {
				TipoComprobante tc = (TipoComprobante) iterTC.next();
				if (inTC.length()==0)
					inTC.append("(");
				if (inTC.length()>1)
					inTC.append(",");
				inTC.append(tc.getOIDInteger());
			}
			if (inTC.length()>0)
				inTC.append(") ");
			if (inTC.length()>0)
				textSQL.append(" and b.oid_tc in "+inTC.toString()); 
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int nroParam = 0;
		if (fecDesde!=null) {
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		
		if (fecHasta!=null) {
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		
		
		
		return querySelect;
	}
	
	
		

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_arqueo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vaArqueo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMovCajaFecDesdeHasta(Caja caja, TipoValor tipoValor, Date fechaDesde, Date fechaHasta, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Caja.NICKNAME, caja);
		condiciones.put(TipoValor.NICKNAME, tipoValor);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);

		return (List) ObjetoLogico.getObjects(MovimientoCaja.NICKNAME, DBMovimientoCaja.SELECT_BY_MOVIN_DESDE_HASTA, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getMovCajaValor(Valor valor, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico
				.getObjects(MovimientoCaja.NICKNAME, DBMovimientoCaja.SELECT_BY_VALOR, valor, new ListObserver(), aSesion);
	}
	
	public static List getMovCajaByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico
				.getObjects(MovimientoCaja.NICKNAME, DBMovimientoCaja.SELECT_BY_CONDICIONES, condiciones, new ListObserver(), aSesion);
	}
	

}
