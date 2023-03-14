package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBInformeRecepcionDet extends DBObjetoPersistente {

	public static final String OID_INF_REC_DET = "oid_inf_rec_det";

	public static final String OID_INF_REC = "oid_inf_Rec";

	public static final String NRO_ITEM = "nro_item";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String CANT_RECIBIDA = "cant_recibida";

	public static final String OID_UM_RECIBIDO = "oid_um_recibido";

	public static final String CANT_REC_UC = "cant_rec_uc";

	public static final String CANT_REC_US = "cant_rec_us";

	public static final String CONTROLAR_CALIDAD = "controlar_calidad";

	public static final String PEND_CC = "pend_cc";

	public static final String CANT_OK_US = "cant_ok_us";

	public static final String CANT_MAL_US = "cant_mal_us";

	public static final String CANT_OK_UC = "cant_ok_uc";

	public static final String CANT_MAL_UC = "cant_mal_uc";

	public static final String COMENTARIO = "comentario";

	public static final String PRECIO_ORI = "precio_ori";

	public static final String OID_MONEDA_ORI = "oid_moneda_ori";

	public static final String PRECIO_MON_ORI = "precio_mon_ori";

	public static final String PRECIO_MON_LOCAL = "precio_mon_local";

	public static final String PRECIO_MON_EXT1 = "precio_mon_ext1";

	public static final String PRECIO_MON_EXT2 = "precio_mon_ext2";

	public static final String VALORIZ_MON_ORI = "valoriz_mon_ori";

	public static final String VALORIZ_MON_LOCAL = "valoriz_mon_local";

	public static final String VALORIZ_MON_EXT1 = "valoriz_mon_ext1";

	public static final String VALORIZ_MON_EXT2 = "valoriz_mon_ext2";

	public static final String ANULADO = "anulado";

	public static final String OID_UM_STOCK = "oid_um_stk";

	public static final String OID_UM_CPRA = "oid_um_cpra";

	public static final String OID_OC_DET = "oid_oc_det";

	public static final String COTIZ_MON_ORI = "cotiz_mon_ori";

	public static final String COTIZ_MON_EXT_1 = "cotiz_mon_ext_1";

	public static final String COTIZ_MON_EXT_2 = "cotiz_mon_ext_2";
	
	public static final String CANT_FACT_UC = "cant_fact_uc";
	
	public static final String CANT_FACT_US = "cant_fact_us";
	
	public static final String PEND_FACT = "pend_fact";
	
	public static final String OID_REMITO_DET = "oid_remito_det";

	public static final int SELECT_BY_INFORME_RECEPCION = 100;

	public static final int SELECT_BY_CONDICIONES = 101;

	public static final int SELECT_BY_INF_REC_DET_PEND_CC = 102;
	
	

	public DBInformeRecepcionDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_INF_REC_DET = 1;
		final int OID_INF_REC = 2;
		final int NRO_ITEM = 3;
		final int OID_PRODUCTO = 4;
		final int CANT_RECIBIDA = 5;
		final int OID_UM_RECIBIDO = 6;
		final int CANT_REC_UC = 7;
		final int CANT_REC_US = 8;
		final int CONTROLAR_CALIDAD = 9;
		final int PEND_CC = 10;
		final int CANT_OK_US = 11;
		final int CANT_MAL_US = 12;
		final int CANT_OK_UC = 13;
		final int CANT_MAL_UC = 14;
		final int COMENTARIO = 15;
		final int PRECIO_ORI = 16;
		final int OID_MONEDA_ORI = 17;
		final int PRECIO_MON_LOCAL = 18;
		final int PRECIO_MON_EXT1 = 19;
		final int PRECIO_MON_EXT2 = 20;
		final int VALORIZ_MON_ORI = 21;
		final int VALORIZ_MON_LOCAL = 22;
		final int VALORIZ_MON_EXT1 = 23;
		final int VALORIZ_MON_EXT2 = 24;
		final int ANULADO = 25;
		final int OID_UM_STK = 26;
		final int OID_UM_CPRA = 27;
		final int OID_OC_DET = 28;
		final int COTIZ_MON_ORI = 29;
		final int COTIZ_MON_EXT_1 = 30;
		final int COTIZ_MON_EXT_2 = 31;
		final int CANT_FACT_US = 32;
		final int CANT_FACT_UC = 33;
		final int PEND_FACT = 34;
		final int OID_REMITO_DET = 35;
		

		InformeRecepcionDet pers = (InformeRecepcionDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into cpInfRecepdet "
						+ " ( "
						+ "OID_INF_REC_DET,"
						+ "OID_INF_REC,"
						+ "NRO_ITEM,"
						+ "OID_PRODUCTO,"
						+ "CANT_RECIBIDA,"
						+ "OID_UM_RECIBIDO,"
						+ "CANT_REC_UC,"
						+ "CANT_REC_US,"
						+ "CONTROLAR_CALIDAD,"
						+ "PEND_CC,"
						+ "CANT_OK_US,"
						+ "CANT_MAL_US,"
						+ "CANT_OK_UC,"
						+ "CANT_MAL_UC,"
						+ "COMENTARIO,"
						+ "PRECIO_ORI,"
						+ "OID_MONEDA_ORI,"
						+ "PRECIO_MON_LOCAL,"
						+ "PRECIO_MON_EXT1,"
						+ "PRECIO_MON_EXT2,"
						+ "VALORIZ_MON_ORI,"
						+ "VALORIZ_MON_LOCAL,"
						+ "VALORIZ_MON_EXT1,"
						+ "VALORIZ_MON_EXT2,"
						+ "ANULADO , OID_UM_STK , OID_UM_CPRA , OID_OC_DET , COTIZ_MON_ORI ,COTIZ_MON_EXT_1 , COTIZ_MON_EXT_2,"+
						" CANT_FACT_US,CANT_FACT_UC,PEND_FACT,OID_REMITO_DET)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"
						+ "?," + "?,?,?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_INF_REC_DET, pers.getOID());
		qInsert.setInt(OID_INF_REC, pers.getInforme_recepcion().getOID());
		qInsert.setInt(NRO_ITEM, pers.getNro_item().intValue());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setDouble(CANT_RECIBIDA, pers.getCant_recibida().doubleValue());
		qInsert.setInt(OID_UM_RECIBIDO, pers.getUnidad_medida_recibido()
				.getOID());
		qInsert.setDouble(CANT_REC_UC, pers.getCant_rec_en_uc().doubleValue());
		qInsert.setDouble(CANT_REC_US, pers.getCant_rec_en_us().doubleValue());
		qInsert.setBoolean(CONTROLAR_CALIDAD, pers.isControlar_calidad()
				.booleanValue());
		qInsert.setBoolean(PEND_CC, pers.isPendiente_cc().booleanValue());
		qInsert.setDouble(CANT_OK_US, pers.getCant_ok_us().doubleValue());
		qInsert.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qInsert.setDouble(CANT_OK_UC, pers.getCant_ok_uc().doubleValue());
		qInsert.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qInsert.setString(COMENTARIO, pers.getComentario());
		if (pers.getPrecio_ori() != null)
			qInsert.setDouble(PRECIO_ORI, pers.getPrecio_ori().doubleValue());
		else
			qInsert.setNull(PRECIO_ORI, java.sql.Types.DOUBLE);
		if (pers.getMoneda_origen() != null)
			qInsert.setInt(OID_MONEDA_ORI, pers.getMoneda_origen().getOID());
		else
			qInsert.setNull(OID_MONEDA_ORI, java.sql.Types.INTEGER);
		if (pers.getPrecio_mon_local() != null)
			qInsert.setDouble(PRECIO_MON_LOCAL, pers.getPrecio_mon_local()
					.doubleValue());
		else
			qInsert.setNull(PRECIO_MON_LOCAL, java.sql.Types.DOUBLE);
		if (pers.getPrecio_mon_ext1() != null)
			qInsert.setDouble(PRECIO_MON_EXT1, pers.getPrecio_mon_ext1()
					.doubleValue());
		else
			qInsert.setNull(PRECIO_MON_EXT1, java.sql.Types.DOUBLE);
		if (pers.getPrecio_mon_ext2() != null)
			qInsert.setDouble(PRECIO_MON_EXT2, pers.getPrecio_mon_ext2()
					.doubleValue());
		else
			qInsert.setNull(PRECIO_MON_EXT2, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_ori() != null)
			qInsert.setDouble(VALORIZ_MON_ORI, pers.getValoriz_mon_ori()
					.doubleValue());
		else
			qInsert.setNull(VALORIZ_MON_ORI, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_local() != null)
			qInsert.setDouble(VALORIZ_MON_LOCAL, pers.getValoriz_mon_local()
					.doubleValue());
		else
			qInsert.setNull(VALORIZ_MON_LOCAL, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_ext1() != null)
			qInsert.setDouble(VALORIZ_MON_EXT1, pers.getValoriz_mon_ext1()
					.doubleValue());
		else
			qInsert.setNull(VALORIZ_MON_EXT1, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_ext2() != null)
			qInsert.setDouble(VALORIZ_MON_EXT2, pers.getValoriz_mon_ext2()
					.doubleValue());
		else
			qInsert.setNull(VALORIZ_MON_EXT2, java.sql.Types.DOUBLE);
		if (pers.getUnidadMedidaStock() != null)
			qInsert.setInt(OID_UM_STK, pers.getUnidadMedidaStock().getOID());
		else
			qInsert.setNull(OID_UM_STK, Types.INTEGER);
		if (pers.getUnidadMedidaCompra() != null)
			qInsert.setInt(OID_UM_CPRA, pers.getUnidadMedidaCompra().getOID());
		else
			qInsert.setNull(OID_UM_CPRA, Types.INTEGER);
		qInsert.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		if (pers.getOrdenDeCompraDet()!=null)
			qInsert.setInt(OID_OC_DET, pers.getOrdenDeCompraDet().getOID());
		else
			qInsert.setNull(OID_OC_DET, java.sql.Types.INTEGER);

		if (pers.getValorCotizMonOri() != null)
			qInsert.setDouble(COTIZ_MON_ORI, pers.getValorCotizMonOri()
					.doubleValue());
		else
			qInsert.setNull(COTIZ_MON_ORI, Types.DOUBLE);

		if (pers.getValorCotizMonExt1() != null)
			qInsert.setDouble(COTIZ_MON_EXT_1, pers.getValorCotizMonExt1()
					.doubleValue());
		else
			qInsert.setNull(COTIZ_MON_EXT_1, Types.DOUBLE);

		if (pers.getValorCotizMonExt2() != null)
			qInsert.setDouble(COTIZ_MON_EXT_2, pers.getValorCotizMonExt2()
					.doubleValue());
		else
			qInsert.setNull(COTIZ_MON_EXT_2, Types.DOUBLE);
		
		if (pers.getCantFactUS() != null)
			qInsert.setDouble(CANT_FACT_US,pers.getCantFactUS().doubleValue());
		else
			qInsert.setNull(CANT_FACT_US,Types.DOUBLE);
		if (pers.getCantFactUC() != null)
			qInsert.setDouble(CANT_FACT_UC,pers.getCantFactUC().doubleValue());
		else
			qInsert.setNull(CANT_FACT_UC,Types.DOUBLE);
		qInsert.setBoolean(PEND_FACT,pers.isPendFacturar().booleanValue());
		if (pers.getRemitoDet()!=null)
			qInsert.setInt(OID_REMITO_DET, pers.getRemitoDet().getOID());
		else
			qInsert.setNull(OID_REMITO_DET, java.sql.Types.INTEGER);
		
				qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_INF_REC = 1;
		final int NRO_ITEM = 2;
		final int OID_PRODUCTO = 3;
		final int CANT_RECIBIDA = 4;
		final int OID_UM_RECIBIDO = 5;
		final int CANT_REC_UC = 6;
		final int CANT_REC_US = 7;
		final int CONTROLAR_CALIDAD = 8;
		final int PEND_CC = 9;
		final int CANT_OK_US = 10;
		final int CANT_MAL_US = 11;
		final int CANT_OK_UC = 12;
		final int CANT_MAL_UC = 13;
		final int COMENTARIO = 14;
		final int PRECIO_ORI = 15;
		final int OID_MONEDA_ORI = 16;
		final int PRECIO_MON_LOCAL = 17;
		final int PRECIO_MON_EXT1 = 18;
		final int PRECIO_MON_EXT2 = 19;
		final int VALORIZ_MON_ORI = 20;
		final int VALORIZ_MON_LOCAL = 21;
		final int VALORIZ_MON_EXT1 = 22;
		final int VALORIZ_MON_EXT2 = 23;
		final int ANULADO = 24;
		final int OID_UM_STK = 25;
		final int OID_UM_CPRA = 26;
		final int OID_OC_DET = 27;
		final int CANT_FACT_US = 28;
		final int CANT_FACT_UC = 29;
		final int PEND_FACT = 30;		
		final int OID_INF_REC_DET = 31;

		InformeRecepcionDet pers = (InformeRecepcionDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpInfRecepdet set " + "oid_inf_Rec=?"
				+ ",nro_item=?" + ",oid_producto=?" + ",cant_recibida=?"
				+ ",oid_um_recibido=?" + ",cant_rec_uc=?" + ",cant_rec_us=?"
				+ ",controlar_calidad=?" + ",pend_cc=?" + ",cant_ok_us=?"
				+ ",cant_mal_us=?" + ",cant_ok_uc=?" + ",cant_mal_uc=?"
				+ ",comentario=?" + ",precio_ori=?" + ",oid_moneda_ori=?"
				+ ",precio_mon_local=?" + ",precio_mon_ext1=?"
				+ ",precio_mon_ext2=?" + ",valoriz_mon_ori=?"
				+ ",valoriz_mon_local=?" + ",valoriz_mon_ext1=?"
				+ ",valoriz_mon_ext2=?" + ",anulado=?" + ",oid_um_stk=?"
				+ ",oid_um_cpra=?,oid_oc_det=?, " 
				+ "cant_fact_us = ? , cant_fact_uc = ? , pend_fact = ? "
				+ " where "
				+ " oid_inf_rec_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC_DET, pers.getOID());
		qUpdate.setInt(OID_INF_REC, pers.getInforme_recepcion().getOID());
		qUpdate.setInt(NRO_ITEM, pers.getNro_item().intValue());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setDouble(CANT_RECIBIDA, pers.getCant_recibida().doubleValue());
		qUpdate.setInt(OID_UM_RECIBIDO, pers.getUnidad_medida_recibido()
				.getOID());
		qUpdate.setDouble(CANT_REC_UC, pers.getCant_rec_en_uc().doubleValue());
		qUpdate.setDouble(CANT_REC_US, pers.getCant_rec_en_us().doubleValue());
		qUpdate.setBoolean(CONTROLAR_CALIDAD, pers.isControlar_calidad()
				.booleanValue());
		qUpdate.setBoolean(PEND_CC, pers.isPendiente_cc().booleanValue());
		qUpdate.setDouble(CANT_OK_US, pers.getCant_ok_us().doubleValue());
		qUpdate.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qUpdate.setDouble(CANT_OK_UC, pers.getCant_ok_uc().doubleValue());
		qUpdate.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		if (pers.getPrecio_ori() != null)
			qUpdate.setDouble(PRECIO_ORI, pers.getPrecio_ori().doubleValue());
		else
			qUpdate.setNull(PRECIO_ORI, java.sql.Types.DOUBLE);
		if (pers.getMoneda_origen() != null)
			qUpdate.setInt(OID_MONEDA_ORI, pers.getMoneda_origen().getOID());
		else
			qUpdate.setNull(OID_MONEDA_ORI, java.sql.Types.INTEGER);
		if (pers.getPrecio_mon_local() != null)
			qUpdate.setDouble(PRECIO_MON_LOCAL, pers.getPrecio_mon_local()
					.doubleValue());
		else
			qUpdate.setNull(PRECIO_MON_LOCAL, java.sql.Types.DOUBLE);
		if (pers.getPrecio_mon_ext1() != null)
			qUpdate.setDouble(PRECIO_MON_EXT1, pers.getPrecio_mon_ext1()
					.doubleValue());
		else
			qUpdate.setNull(PRECIO_MON_EXT1, java.sql.Types.DOUBLE);
		if (pers.getPrecio_mon_ext2() != null)
			qUpdate.setDouble(PRECIO_MON_EXT2, pers.getPrecio_mon_ext2()
					.doubleValue());
		else
			qUpdate.setNull(PRECIO_MON_EXT2, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_ori() != null)
			qUpdate.setDouble(VALORIZ_MON_ORI, pers.getValoriz_mon_ori()
					.doubleValue());
		else
			qUpdate.setNull(VALORIZ_MON_ORI, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_local() != null)
			qUpdate.setDouble(VALORIZ_MON_LOCAL, pers.getValoriz_mon_local()
					.doubleValue());
		else
			qUpdate.setNull(VALORIZ_MON_LOCAL, java.sql.Types.DOUBLE);
		if (pers.getValoriz_mon_ext1() != null)
			qUpdate.setDouble(VALORIZ_MON_EXT1, pers.getValoriz_mon_ext1()
					.doubleValue());
		else
			qUpdate.setNull(VALORIZ_MON_EXT1, java.sql.Types.INTEGER);
		if (pers.getValoriz_mon_ext2() != null)
			qUpdate.setDouble(VALORIZ_MON_EXT2, pers.getValoriz_mon_ext2()
					.doubleValue());
		else
			qUpdate.setNull(VALORIZ_MON_EXT2, java.sql.Types.INTEGER);
		if (pers.getUnidadMedidaStock() != null)
			qUpdate.setInt(OID_UM_STK, pers.getUnidadMedidaStock().getOID());
		else
			qUpdate.setNull(OID_UM_STK, Types.INTEGER);
		if (pers.getUnidadMedidaCompra() != null)
			qUpdate.setInt(OID_UM_CPRA, pers.getUnidadMedidaCompra().getOID());
		else
			qUpdate.setNull(OID_UM_CPRA, Types.INTEGER);
		qUpdate.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		if (pers.getOrdenDeCompraDet()!=null)
			qUpdate.setInt(OID_OC_DET, pers.getOrdenDeCompraDet().getOID());
		else
			qUpdate.setNull(OID_OC_DET, java.sql.Types.INTEGER);
		if (pers.getCantFactUS() != null)
			qUpdate.setDouble(CANT_FACT_US,pers.getCantFactUS().doubleValue());
		else
			qUpdate.setNull(CANT_FACT_US,Types.DOUBLE);
		if (pers.getCantFactUC() != null)
			qUpdate.setDouble(CANT_FACT_UC,pers.getCantFactUC().doubleValue());
		else
			qUpdate.setNull(CANT_FACT_UC,Types.DOUBLE);
		qUpdate.setBoolean(PEND_FACT,pers.isPendFacturar().booleanValue());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_INF_REC_DET = 1;
		InformeRecepcionDet pers = (InformeRecepcionDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpInfRecepdet " + " set anulado=1 " + " where "
				+ " oid_inf_rec_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_INF_REC_DET = 1;
		InformeRecepcionDet pers = (InformeRecepcionDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpInfRecepdet " + " set anulado=0 " + " where "
				+ " oid_inf_rec_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC_DET, pers.getOID());
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
		case SELECT_BY_INFORME_RECEPCION: {
			ps = this.selectByInformeRecepcion(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_INF_REC_DET_PEND_CC: {
			ps = this.selectByInfRecDetPendCC(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_INF_REC_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecepdet ");
		textSQL.append(" WHERE oid_inf_rec_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_INF_REC_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecepdet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByInformeRecepcion(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecepdet ");
		textSQL.append(" WHERE oid_inf_rec = ? and anulado=0");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		InformeRecepcion informeRecepcion = (InformeRecepcion) aCondiciones;
		querySelect.setInt(1, informeRecepcion.getOID());
		return querySelect;
	}

	private PreparedStatement selectByInfRecDetPendCC(Object aCondiciones)
			throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL
				.append("SELECT a.* FROM  cpInfRecepdet a, cpInfRecep b , geComproCab c ");
		textSQL
				.append(" WHERE c.oid_cco = b.oid_inf_rec and a.oid_inf_rec = b.oid_inf_rec and a.pend_cc = 1 and a.anulado = 0 and c.activo = 1 ");

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones
					.get(Proveedor.NICKNAME);
			textSQL.append(" and b.oid_proveedor = "
					+ proveedor.getOIDInteger().toString());
		}

		if (condiciones.containsKey(InformeRecepcion.NICKNAME)) {
			InformeRecepcion informeRecepcion = (InformeRecepcion) condiciones
					.get(InformeRecepcion.NICKNAME);
			textSQL.append(" and a.oid_inf_rec = "
					+ informeRecepcion.getOIDInteger().toString());
		}

		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto = "
					+ producto.getOIDInteger().toString());
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones)
			throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpInfRecepdet a, cpInfRecep b , geComproCab c ");
		textSQL.append(" WHERE c.oid_cco = b.oid_inf_rec and a.oid_inf_rec = b.oid_inf_rec ");

		if (condiciones.containsKey("estado")) {
			if (((String) condiciones.get("estado")).equals("PEND_CC"))
				textSQL.append(" and a.pend_cc = 1 and a.anulado = 0 ");
		}

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones
					.get(Proveedor.NICKNAME);
			textSQL.append(" and b.oid_proveedor = "
					+ proveedor.getOIDInteger().toString());
		}

		if (condiciones.containsKey(InformeRecepcion.NICKNAME)) {
			InformeRecepcion informeRecepcion = (InformeRecepcion) condiciones
					.get(InformeRecepcion.NICKNAME);
			textSQL.append(" and a.oid_inf_rec = "
					+ informeRecepcion.getOIDInteger().toString());
		}
		
		if (condiciones.containsKey(OrdenDeCompraCab.NICKNAME)) {
			OrdenDeCompraCab oc = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);
			textSQL.append(" and a.oid_oc_det in (select oid_oc_det from cpOCDet where oid_cco_cpra = "+oc.getOIDInteger()+") ");
		}
		
		if (condiciones.containsKey("NRO_EXT_DESDE")) {
			Integer nroExtDesde = (Integer) condiciones.get("NRO_EXT_DESDE");
			textSQL.append(" and c.nro_ext >= " + nroExtDesde);
		}
		
		java.util.Date fecDesde = null;
		if (condiciones.containsKey("FEC_DESDE")) {
			fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
			textSQL.append(" and c.emision >= ? ");
		}
		
		java.util.Date fecHasta = null;
		if (condiciones.containsKey("FEC_HASTA")) {
			fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			textSQL.append(" and c.emision <= ? ");
		}
		
		if (condiciones.containsKey("NRO_EXT_HASTA")) {
			Integer nroExtHasta = (Integer) condiciones.get("NRO_EXT_HASTA");
			textSQL.append(" and c.nro_ext <= " + nroExtHasta);
		}
		
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto = "+ producto.getOIDInteger().toString());
		}
		
		if (condiciones.containsKey("REMITO_PROVEEDOR")) {
			String remitoProveedor = (String) condiciones.get("REMITO_PROVEEDOR");
			textSQL.append(" and b.remito_prov like '%" + condiciones.getString("REMITO_PROVEEDOR")+"%' ");
		}
		
		if (condiciones.containsKey("REFERENCIA")) {
			String referencia = (String) condiciones.get("REFERENCIA");
			textSQL.append(" and b.referencia like '%" + condiciones.getString("REFERENCIA")+"%' ");
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int nroParam = 1;
		
		if (fecDesde!=null) {
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
			++nroParam;
		}
		
		if (fecHasta!=null) {
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
			++nroParam;
		}
		
		
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_inf_rec_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpInfRecepdet");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetallesInfRec(InformeRecepcion informeRecepcion,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeRecepcionDet.NICKNAME,
				DBInformeRecepcionDet.SELECT_BY_INFORME_RECEPCION,
				informeRecepcion, new ListObserver(), aSesion);
	}

	public static List getDetallesInfRec(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeRecepcionDet.NICKNAME,
				DBInformeRecepcionDet.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getDetallesInfRecPendCC(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeRecepcionDet.NICKNAME,
				DBInformeRecepcionDet.SELECT_BY_INF_REC_DET_PEND_CC,
				condiciones, new ListObserver(), aSesion);
	}

}
