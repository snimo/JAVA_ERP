package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.TablaPercIBBsAs;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTablaPercIBBsAs extends DBObjetoPersistente {

	public static final String OID_PERC_IB = "oid_perc_ib";
	public static final String FEC_PUBLIC = "fec_public";
	public static final String FEC_VIG_DESDE = "fec_vig_desde";
	public static final String FEC_VIG_HASTA = "fec_vig_hasta";
	public static final String CUIT = "cuit";
	public static final String TIPO = "tipo";
	public static final String MARCA_AB_SUJETO = "marca_ab_sujeto";
	public static final String MARCA_CAMBIO_ALI = "marca_cambio_ali";
	public static final String ALI_PERCEPCION = "ali_percepcion";
	public static final String ALI_RETENCION = "ali_retencion";
	public static final String NRO_GR_RET = "nro_gr_ret";
	public static final String NRO_GR_PER = "nro_gr_per";

	public static final int SELECT_BY_CUIT_Y_FECHA = 100;
	public static final int SELECT_BY_CUIT_Y_FECHA_PUBLICACION = 101;
	public static final int SELECT_CONS_MASIVA = 102;

	public DBTablaPercIBBsAs() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PERC_IB = 1;
		final int FEC_PUBLIC = 2;
		final int FEC_VIG_DESDE = 3;
		final int FEC_VIG_HASTA = 4;
		final int CUIT = 5;
		final int TIPO = 6;
		final int MARCA_AB_SUJETO = 7;
		final int MARCA_CAMBIO_ALI = 8;
		final int ALI_PERCEPCION = 9;
		final int ALI_RETENCION = 10;
		final int NRO_GR_RET = 11;
		final int NRO_GR_PER = 12;

		TablaPercIBBsAs pers = (TablaPercIBBsAs) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vePercIBBsAs " + " ( " + "OID_PERC_IB,"
				+ "FEC_PUBLIC," + "FEC_VIG_DESDE," + "FEC_VIG_HASTA," + "CUIT,"
				+ "TIPO," + "MARCA_AB_SUJETO," + "MARCA_CAMBIO_ALI,"
				+ "ALI_PERCEPCION," + "ALI_RETENCION," + "NRO_GR_RET,"
				+ "NRO_GR_PER)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PERC_IB, pers.getOID());
		if (pers.getFec_public() != null)
			qInsert.setDate(FEC_PUBLIC,
					new Date(pers.getFec_public().getTime()));
		else
			qInsert.setNull(FEC_PUBLIC, java.sql.Types.DATE);
		if (pers.getFec_vig_desde() != null)
			qInsert.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde()
					.getTime()));
		else
			qInsert.setNull(FEC_VIG_DESDE, java.sql.Types.DATE);
		if (pers.getFec_vig_hasta() != null)
			qInsert.setDate(FEC_VIG_HASTA, new java.sql.Date(pers
					.getFec_vig_hasta().getTime()));
		else
			qInsert.setNull(FEC_VIG_HASTA, java.sql.Types.DATE);
		if (pers.getCuit() != null)
			qInsert.setString(CUIT, pers.getCuit());
		else
			qInsert.setString(CUIT, "");
		if (pers.getTipo() != null)
			qInsert.setString(TIPO, pers.getTipo());
		else
			qInsert.setString(TIPO, "");
		if (pers.getMarca_ab_sujeto() != null)
			qInsert.setString(MARCA_AB_SUJETO, pers.getMarca_ab_sujeto());
		else
			qInsert.setString(MARCA_AB_SUJETO, "");
		if (pers.getMarca_cambio_ali() != null)
			qInsert.setString(MARCA_CAMBIO_ALI, pers.getMarca_cambio_ali());
		else
			qInsert.setString(MARCA_CAMBIO_ALI, "");
		if (pers.getAli_percepcion() != null)
			qInsert.setDouble(ALI_PERCEPCION, pers.getAli_percepcion()
					.doubleValue());
		else
			qInsert.setNull(ALI_PERCEPCION, java.sql.Types.DOUBLE);
		if (pers.getAli_retencion() != null)
			qInsert.setDouble(ALI_RETENCION, pers.getAli_retencion()
					.doubleValue());
		else
			qInsert.setNull(ALI_RETENCION, java.sql.Types.DOUBLE);
		if (pers.getNro_gr_ret() != null)
			qInsert.setInt(NRO_GR_RET, pers.getNro_gr_ret().intValue());
		else
			qInsert.setInt(NRO_GR_RET, 0);
		if (pers.getNro_gr_per() != null)
			qInsert.setInt(NRO_GR_PER, pers.getNro_gr_per().intValue());
		else
			qInsert.setInt(NRO_GR_PER, 0);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int FEC_PUBLIC = 1;
		final int FEC_VIG_DESDE = 2;
		final int FEC_VIG_HASTA = 3;
		final int CUIT = 4;
		final int TIPO = 5;
		final int MARCA_AB_SUJETO = 6;
		final int MARCA_CAMBIO_ALI = 7;
		final int ALI_PERCEPCION = 8;
		final int ALI_RETENCION = 9;
		final int NRO_GR_RET = 10;
		final int NRO_GR_PER = 11;
		final int OID_PERC_IB = 12;

		TablaPercIBBsAs pers = (TablaPercIBBsAs) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vePercIBBsAs set " + "fec_public=?"
				+ ",fec_vig_desde=?" + ",fec_vig_hasta=?" + ",cuit=?"
				+ ",tipo=?" + ",marca_ab_sujeto=?" + ",marca_cambio_ali=?"
				+ ",ali_percepcion=?" + ",ali_retencion=?" + ",nro_gr_ret=?"
				+ ",nro_gr_per=?" + " where " + " oid_perc_ib=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERC_IB, pers.getOID());
		if (pers.getFec_public() != null)
			qUpdate.setDate(FEC_PUBLIC, new java.sql.Date(pers.getFec_public()
					.getTime()));
		else
			qUpdate.setNull(FEC_PUBLIC, java.sql.Types.DATE);
		if (pers.getFec_vig_desde() != null)
			qUpdate.setDate(FEC_VIG_DESDE, new Date(pers.getFec_vig_desde()
					.getTime()));
		else
			qUpdate.setNull(FEC_VIG_DESDE, java.sql.Types.DATE);
		if (pers.getFec_vig_hasta() != null)
			qUpdate.setDate(FEC_VIG_HASTA, new Date(pers.getFec_vig_hasta()
					.getTime()));
		else
			qUpdate.setNull(FEC_VIG_HASTA, java.sql.Types.DATE);
		if (pers.getCuit() != null)
			qUpdate.setString(CUIT, pers.getCuit());
		else
			qUpdate.setString(CUIT, "");
		if (pers.getTipo() != null)
			qUpdate.setString(TIPO, pers.getTipo());
		else
			qUpdate.setString(TIPO, "");
		if (pers.getMarca_ab_sujeto() != null)
			qUpdate.setString(MARCA_AB_SUJETO, pers.getMarca_ab_sujeto());
		else
			qUpdate.setString(MARCA_AB_SUJETO, "");
		if (pers.getMarca_cambio_ali() != null)
			qUpdate.setString(MARCA_CAMBIO_ALI, pers.getMarca_cambio_ali());
		else
			qUpdate.setString(MARCA_CAMBIO_ALI, "");
		if (pers.getAli_percepcion() != null)
			qUpdate.setDouble(ALI_PERCEPCION, pers.getAli_percepcion()
					.doubleValue());
		else
			qUpdate.setNull(ALI_PERCEPCION, java.sql.Types.DOUBLE);
		if (pers.getAli_retencion() != null)
			qUpdate.setDouble(ALI_RETENCION, pers.getAli_retencion()
					.doubleValue());
		else
			qUpdate.setNull(ALI_RETENCION, java.sql.Types.DOUBLE);
		if (pers.getNro_gr_ret() != null)
			qUpdate.setInt(NRO_GR_RET, pers.getNro_gr_ret().intValue());
		else
			qUpdate.setInt(NRO_GR_RET, 0);
		if (pers.getNro_gr_per() != null)
			qUpdate.setInt(NRO_GR_PER, pers.getNro_gr_per().intValue());
		else
			qUpdate.setInt(NRO_GR_PER, 0);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_PERC_IB = 1;
		TablaPercIBBsAs pers = (TablaPercIBBsAs) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from vePercIBBsAs  where "
				+ " oid_perc_ib=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERC_IB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_PERC_IB = 1;
		TablaPercIBBsAs pers = (TablaPercIBBsAs) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePercIBBsAs " + " set activo=1 " + " where "
				+ " oid_perc_ib=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERC_IB, pers.getOID());
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
		case SELECT_BY_CUIT_Y_FECHA: {
			ps = this.selectByCUITyFeca(aCondiciones);
			break;
		}
		case SELECT_BY_CUIT_Y_FECHA_PUBLICACION: {
			ps = this.selectByCUITyFechaPublicacion(aCondiciones);
			break;
		}
		case SELECT_CONS_MASIVA: {
			ps = this.selectByConsultaMasiva(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_PERC_IB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePercIBBsAs ");
		textSQL.append(" WHERE oid_perc_ib = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PERC_IB, oid);
		return querySelect;
	}

	private PreparedStatement selectByConsultaMasiva(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePercIBBsAs ");
		textSQL.append(" WHERE 1=1");
		
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String cuit = (String) condiciones.get("CUIT");
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		int nroParams = 0;
		
		if (cuit!=null) 
			textSQL.append(" and cuit=? ");
		
		if (fechaDesde!=null)
			textSQL.append(" and fec_vig_desde>=? ");
		
		if (fechaHasta!=null)
			textSQL.append(" and fec_vig_hasta<=? ");
		

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		
		if (cuit!=null) {
			++nroParams;
			querySelect.setString(nroParams, cuit);
		}
		
		if (fechaDesde!=null) {
			++nroParams;
			querySelect.setDate(nroParams, new java.sql.Date(fechaDesde.getTime()));
		}
		
		if (fechaHasta!=null) {
			++nroParams;
			querySelect.setDate(nroParams, new java.sql.Date(fechaHasta.getTime()));
		}

		return querySelect;
	}

	private PreparedStatement selectByCUITyFechaPublicacion(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePercIBBsAs ");
		textSQL.append(" WHERE cuit = ? and fec_public = ? ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String cuit = (String) condiciones.get("CUIT");
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, cuit);
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByCUITyFeca(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePercIBBsAs ");
		textSQL.append(" WHERE cuit = ? and marca_ab_sujeto<>'B' and fec_public = (select max(fec_public) from vePercIBBsAs where cuit=? and fec_public<=? ) ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String cuit = (String) condiciones.get("CUIT");
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

		querySelect.setString(1, cuit);
		querySelect.setString(2, cuit);
		querySelect.setDate(3, new Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePercIBBsAs ");
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

		textSQL.append("SELECT oid_perc_ib oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vePercIBBsAs");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static TablaPercIBBsAs getTablePercIBBsAs(String cuit,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CUIT", cuit);
		condiciones.put("FECHA", fecha);

		return (TablaPercIBBsAs) ObjetoLogico.getObjects(
				TablaPercIBBsAs.NICKNAME,
				DBTablaPercIBBsAs.SELECT_BY_CUIT_Y_FECHA, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static TablaPercIBBsAs getRegistroPorCUITyFecPub(String cuit,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CUIT", cuit);
		condiciones.put("FECHA", fecha);
		return (TablaPercIBBsAs) ObjetoLogico.getObjects(
				TablaPercIBBsAs.NICKNAME,
				DBTablaPercIBBsAs.SELECT_BY_CUIT_Y_FECHA_PUBLICACION,
				condiciones, new ObjetoObservado(), aSesion);
	}
	
	  public static List getConsultaMasiva(String cuit,
			  java.util.Date fecVigDesde,
			  java.util.Date fecVigHasta,
			  ISesion aSesion) throws BaseException {
		  
		  HashTableDatos condiciones = new HashTableDatos();
		  if (cuit!=null)
			  condiciones.put("CUIT", cuit);
		  if (fecVigDesde!=null)
			  condiciones.put("FEC_DESDE", fecVigDesde);
		  if (fecVigHasta!=null)
			  condiciones.put("FEC_HASTA", fecVigHasta);
		  
		  return (List) ObjetoLogico.getObjects(TablaPercIBBsAs.NICKNAME,
                 DBTablaPercIBBsAs.SELECT_CONS_MASIVA,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	  }
	

}
