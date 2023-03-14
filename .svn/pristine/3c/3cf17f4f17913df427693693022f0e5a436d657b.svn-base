package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.ConsultaEstadoRequisiciones;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaEstadoRequisiciones extends DBObjetoPersistente {

	public static final String OID_CCO = "oid_cco";

	public static final String OID_TC = "oid_tc";

	public static final String TC_EXT = "tc_ext";

	public static final String LETRA = "letra";

	public static final String OID_LUG_EMI = "oid_lug_emi";

	public static final String LUG_EMI = "lug_emi";
	
	public static final String NRO_EXT = "nro_ext";

	public static final String COMENTARIO_REQUI = "comentario_requi";

	public static final String OID_USUARIO = "oid_usuario";
	
	public static final String OID_SECTOR_COMPRA = "oid_sector_compra";

	public static final String OID_TALONARIO = "oid_talonario";

	public static final String OID_SUCURSAL = "oid_sucursal";

	public static final String OID_REQ_DET = "oid_req_det";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String COD_PRODUCTO = "cod_producto";

	public static final String DESC_PRODUCTO = "desc_producto";

	public static final String DESC_ADIC_SKU = "desc_adic_sku";

	public static final String NRO_RENGLON = "nro_renglon";

	public static final String CANT_SOLICITADA= "cant_solicitada";

	public static final String CANT_COMPRADA = "cant_comprada";

	public static final String OID_UM_REQ = "oid_um_req";

	public static final String FEC_EMISION = "fec_emision";

	public static final String FEC_REQUERIDA = "fec_requerida";

	public static final String DECISION_AUTORIZ = "decision_autoriz";

	public static final String ANULADA = "anulada";

	public static final String SOLO_COTIZAR = "solo_cotizar";

	public static final String COMENTARIO_DET = "comentario_det";

	public static final String PEND_SOL_COTIZ = "pend_sol_cotiz";
	
	public static final String PEND_COMPRA = "pend_compra";

	public static final int SELECT_BY_CONDICIONES = 100;
	
	
	

	public DBConsultaEstadoRequisiciones() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// NO Aplica
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// NO Aplica
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// NO Aplica
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// NO Aplica
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
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT ");
		textSQL.append(" a.oid_cco,a.oid_tc,a.tc_ext,a.letra,a.oid_lug_emi,a.lug_emi,a.nro_ext,a.comentario comentario_requi,d.oid_usuario,");
		textSQL.append(" a.oid_talonario,a.oid_sucursal,");
		textSQL.append(" d.oid_sector_compra,b.oid_req_det,b.oid_producto,c.codigo cod_producto,c.descripcion desc_producto,b.desc_adic_sku,b.nro_renglon,b.cant_solicitada,");
		textSQL.append(" b.cant_comprada,b.oid_um_req,b.fec_emision,b.fec_requerida,b.decision_autoriz,b.anulada,b.solo_cotizar,b.comentario comentario_det,");
		textSQL.append(" b.pend_sol_cotiz, b.pend_compra ");
		textSQL.append(" FROM  geComproCab a, cpRequiDet b , stProducto c , cpRequiCab d where a.oid_cco = d.oid_cco_requi and a.oid_cco = b.oid_cco_requi and b.oid_producto = c.oid_producto ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT ");
		textSQL.append(" a.oid_cco,a.oid_tc,a.tc_ext,a.letra,a.oid_lug_emi,a.lug_emi,a.nro_ext,a.comentario comentario_requi,d.oid_usuario,");
		textSQL.append(" a.oid_talonario,a.oid_sucursal,");
		textSQL.append(" d.oid_sector_compra,b.oid_req_det,b.oid_producto,c.codigo cod_producto,c.descripcion desc_producto,b.desc_adic_sku,b.nro_renglon,b.cant_solicitada,");
		textSQL.append(" b.cant_comprada,b.oid_um_req,b.fec_emision,b.fec_requerida,b.decision_autoriz,b.anulada,b.solo_cotizar,b.comentario comentario_det,");
		textSQL.append(" b.pend_sol_cotiz , b.pend_compra ");		
		textSQL.append(" FROM  geComproCab a, cpRequiDet b , stProducto c , cpRequiCab d where a.oid_cco = d.oid_cco_requi and a.oid_cco = b.oid_cco_requi and b.oid_producto = c.oid_producto ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		if (condiciones.get(Sucursal.NICKNAME)!=null) {
			Sucursal sucursal = (Sucursal) condiciones.get(Sucursal.NICKNAME);
			textSQL.append(" and a.oid_sucursal = "+ sucursal.getOIDInteger().toString());
		}
		if (condiciones.get(SectorCompra.NICKNAME)!=null) {
			SectorCompra sectorCompra = (SectorCompra) condiciones.get(SectorCompra.NICKNAME);
			textSQL.append(" and d.oid_sector_compra = "+ sectorCompra.getOIDInteger().toString());
		}			
		if (condiciones.get(Usuario.NICKNAME)!=null) {
			Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
			textSQL.append(" and a.oid_usuario = "+ usuario.getOIDInteger().toString());
		}
		if (condiciones.get("FEC_EMI_DESDE")!=null) {
			textSQL.append(" and a.emision >=? ");
		}
		if (condiciones.get("FEC_EMI_HASTA")!=null) {
			textSQL.append(" and a.emision <=? ");
		}
		if (condiciones.get("FEC_REQ_DESDE")!=null) {
			textSQL.append(" and b.fec_requerida >=? ");
		}
		if (condiciones.get("FEC_REQ_HASTA")!=null) {
			textSQL.append(" and b.fec_requerida <=? ");
		}		
		if (condiciones.get(Talonario.NICKNAME)!=null) {
			Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
			textSQL.append(" and a.oid_talonario = "+ talonario.getOIDInteger().toString());
		}
		if (condiciones.get("NRO_DESDE")!=null) {
			Integer nroDesde = (Integer) condiciones.get("NRO_DESDE"); 
			textSQL.append(" and a.nro_ext >= "+ nroDesde.toString());
		}
		if (condiciones.get("NRO_HASTA")!=null) {
			Integer nroHasta = (Integer) condiciones.get("NRO_HASTA"); 
			textSQL.append(" and a.nro_ext <= "+ nroHasta.toString());
		}
		if (condiciones.get(Producto.NICKNAME)!=null) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and b.oid_producto = "+ producto.getOIDInteger().toString());
		}		
		
		if (condiciones.get(RequisicionDet.NICKNAME)!=null) {
			RequisicionDet requiDet = (RequisicionDet) condiciones.get(RequisicionDet.NICKNAME);
			textSQL.append(" and b.oid_req_det = "+ requiDet.getOIDInteger().toString());
		}		
		
		
		if (condiciones.get("SOLO_PEND_COTIZ")!=null) {
			Boolean soloPendCotiz = (Boolean) condiciones.get("SOLO_PEND_COTIZ");
			if (soloPendCotiz.booleanValue())
			    textSQL.append(" and b.pend_sol_cotiz = 0 and b.anulada = 0 and a.activo = 1 ");
		}		
		
		if (condiciones.containsKey("SOLO_PEND_COMPRA")) {
			 textSQL.append(" and b.pend_compra = 1 and b.anulada = 0 and a.activo = 1 and b.solo_cotizar=0 and b.decision_autoriz <> 2 ");
		}				
		
		
		if (condiciones.get("MIS_PEND_AUTORIZ")!=null) {
			Boolean misPendAutoriz = (Boolean) condiciones.get("MIS_PEND_AUTORIZ");
			if (misPendAutoriz.booleanValue()) {
			    textSQL.append(" and b.anulada = 0 and a.activo = 1 and  b.decision_autoriz = 0 and b.oid_req_det ");
			    textSQL.append(" in (select oid_req_det from cpRequiDetAutoriz where ");
			    textSQL.append(" oid_rol_autoriz in (select oid_rol_autoriz from cpUsuRolAutoriz where oid_usuario=");
			    textSQL.append(getSesion().getLogin().getUsuario().getOIDInteger().toString()+")) ");
			}
		}
		if (condiciones.get("TODOS_PEND_AUTORIZ")!=null) {
			Boolean todosPendAutoriz = (Boolean) condiciones.get("TODOS_PEND_AUTORIZ");
			if (todosPendAutoriz.booleanValue()) 
			    textSQL.append(" and b.decision_autoriz = 0 and b.anulada = 0 and a.activo = 1");
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		
		int nroParametro = 0;
		if (condiciones.get("FEC_EMI_DESDE")!=null) {
			++nroParametro;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_DESDE");
			querySelect.setDate(nroParametro,new java.sql.Date(fecha.getTime()));
		}
		if (condiciones.get("FEC_EMI_HASTA")!=null) {
			++nroParametro;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_HASTA");
			querySelect.setDate(nroParametro,new java.sql.Date(fecha.getTime()));
		}
		if (condiciones.get("FEC_REQ_DESDE")!=null) {
			++nroParametro;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_REQ_DESDE");
			querySelect.setDate(nroParametro,new java.sql.Date(fecha.getTime()));
		}
		if (condiciones.get("FEC_REQ_HASTA")!=null) {
			++nroParametro;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_REQ_HASTA");
			querySelect.setDate(nroParametro,new java.sql.Date(fecha.getTime()));
		}		
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {
		// NO Aplica
		return null;
	}

	public static List getEstadosRequisiciones(HashTableDatos condiciones, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ConsultaEstadoRequisiciones.NICKNAME,
				DBConsultaEstadoRequisiciones.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}

}
