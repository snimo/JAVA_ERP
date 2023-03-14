package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRemitoCab extends DBObjetoPersistente {

	public static final String OID_REMITO_CAB = "oid_remito_cab";

	public static final String COMPO_RTO = "compo_rto";

	public static final String OID_SUJETO = "oid_sujeto";

	public static final String DESTINATARIO = "destinatario";

	public static final String DESTINO = "destino";

	public static final String OID_DEPO_DEST = "oid_depo_dest";

	public static final String OID_UNI_EDI_DEST = "oid_uni_edi_dest";

	public static final String OID_UNI_ORG_DEST = "oid_uni_org_dest";

	public static final String PEND_FACT = "pend_fact";

	public static final String CALLE_Y_NRO = "calle_y_nro";

	public static final String LOCALIDAD = "localidad";

	public static final String CODIGO_POSTAL = "codigo_postal";

	public static final String OID_PROVINCIA = "oid_provincia";

	public static final String OID_PAIS = "oid_pais";

	public static final String OID_COMPO_STK_RTO = "oid_compo_stk_rto";

	public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";

	public static final String OID_PROVEEDOR = "oid_proveedor";

	public static final String COMENTARIO = "comentario";

	public static final String TIPO_REMITO = "tipo_remito";

	public static final String REFERENCIA1 = "referencia1";

	public static final String REFERENCIA2 = "referencia2";

	public static final int SELECT_BY_CONDICIONES = 100;
	public static final int UPDATE_REM_CAB_NO_PEND_FACT = 101;
	public static final int SELECT_BY_TC_LETRA_LE_NRO = 102;
	public static final int SELECT_BY_RTO_PEND_RECEP = 103;

	public DBRemitoCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REMITO_CAB = 1;
		final int COMPO_RTO = 2;
		final int OID_SUJETO = 3;
		final int DESTINATARIO = 4;
		final int DESTINO = 5;
		final int OID_DEPO_DEST = 6;
		final int OID_UNI_EDI_DEST = 7;
		final int OID_UNI_ORG_DEST = 8;
		final int PEND_FACT = 9;
		final int CALLE_Y_NRO = 10;
		final int LOCALIDAD = 11;
		final int CODIGO_POSTAL = 12;
		final int OID_PROVINCIA = 13;
		final int OID_PAIS = 14;
		final int OID_COMPO_STK_RTO = 15;
		final int OID_TIPO_CONF_MOV = 16;
		final int OID_PROVEEDOR = 17;
		final int TIPO_REMITO = 18;
		final int COMENTARIO = 19;
		final int REFERENCIA1 = 20;
		final int REFERENCIA2 = 21;

		RemitoCab pers = (RemitoCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veRemitoCab " + " ( " + "OID_REMITO_CAB," + "COMPO_RTO," + "OID_SUJETO," + "DESTINATARIO,"
				+ "DESTINO," + "OID_DEPO_DEST," + "OID_UNI_EDI_DEST," + "OID_UNI_ORG_DEST," + "PEND_FACT," + "CALLE_Y_NRO," + "LOCALIDAD,"
				+ "CODIGO_POSTAL," + "OID_PROVINCIA," + "OID_PAIS," + "OID_COMPO_STK_RTO,"
				+ "OID_TIPO_CONF_MOV,OID_PROVEEDOR, TIPO_REMITO , COMENTARIO , REFERENCIA1 , REFERENCIA2)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REMITO_CAB, pers.getOID());
		qInsert.setString(COMPO_RTO, pers.getComportamientoRto());
		if (pers.getSujeto() != null)
			qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qInsert.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		qInsert.setString(DESTINATARIO, pers.getDestinatario());
		qInsert.setString(DESTINO, pers.getDestino());
		if (pers.getDepo_destino() != null)
			qInsert.setInt(OID_DEPO_DEST, pers.getDepo_destino().getOID());
		else
			qInsert.setNull(OID_DEPO_DEST, java.sql.Types.INTEGER);
		if (pers.getUni_edi_dest() != null)
			qInsert.setInt(OID_UNI_EDI_DEST, pers.getUni_edi_dest().getOID());
		else
			qInsert.setNull(OID_UNI_EDI_DEST, java.sql.Types.INTEGER);
		if (pers.getUni_org_dest() != null)
			qInsert.setInt(OID_UNI_ORG_DEST, pers.getUni_org_dest().getOID());
		else
			qInsert.setNull(OID_UNI_ORG_DEST, java.sql.Types.INTEGER);
		qInsert.setBoolean(PEND_FACT, pers.isPend_fact().booleanValue());
		qInsert.setString(CALLE_Y_NRO, pers.getCalle_y_nro());
		qInsert.setString(LOCALIDAD, pers.getLocalidad());
		qInsert.setString(CODIGO_POSTAL, pers.getCodigo_postal());
		if (pers.getProvincia() != null)
			qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qInsert.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		if (pers.getPais() != null)
			qInsert.setInt(OID_PAIS, pers.getPais().getOID());
		else
			qInsert.setNull(OID_PAIS, java.sql.Types.INTEGER);
		qInsert.setInt(OID_COMPO_STK_RTO, pers.getCompoStkTalRto().getOID());
		qInsert.setInt(OID_TIPO_CONF_MOV, pers.getTipoConfMov().getOID());
		if (pers.getProveedor() != null)
			qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qInsert.setNull(OID_PROVEEDOR, Types.INTEGER);
		qInsert.setString(TIPO_REMITO, pers.getTipoRemito());
		if (pers.getComentario() != null)
			qInsert.setString(COMENTARIO, pers.getComentario());
		else
			qInsert.setNull(COMENTARIO, Types.VARCHAR);

		qInsert.setString(REFERENCIA1, pers.getReferencia1());
		qInsert.setString(REFERENCIA2, pers.getReferencia2());

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int COMPO_RTO = 1;
		final int OID_SUJETO = 2;
		final int DESTINATARIO = 3;
		final int DESTINO = 4;
		final int OID_DEPO_DEST = 5;
		final int OID_UNI_EDI_DEST = 6;
		final int OID_UNI_ORG_DEST = 7;
		final int PEND_FACT = 8;
		final int CALLE_Y_NRO = 9;
		final int LOCALIDAD = 10;
		final int CODIGO_POSTAL = 11;
		final int OID_PROVINCIA = 12;
		final int OID_PAIS = 13;
		final int OID_COMPO_STK_RTO = 14;
		final int OID_TIPO_CONF_MOV = 15;
		final int OID_PROVEEDOR = 16;
		final int TIPO_REMITO = 17;
		final int COMENTARIO = 18;
		final int REFERENCIA1 = 19;
		final int REFERENCIA2 = 20;
		final int OID_REMITO_CAB = 21;

		RemitoCab pers = (RemitoCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veRemitoCab set " + "compo_rto=?" + ",oid_sujeto=?" + ",destinatario=?" + ",destino=?"
				+ ",oid_depo_dest=?" + ",oid_uni_edi_dest=?" + ",oid_uni_org_dest=?" + ",pend_fact=?" + ",calle_y_nro=?" + ",localidad=?"
				+ ",codigo_postal=?" + ",oid_provincia=?" + ",oid_pais=?" + ",oid_compo_stk_rto=?"
				+ ",oid_tipo_conf_mov=?,oid_proveedor=?,tipo_remito = ? , comentario = ? , referencia1 = ? , referencia2 = ? " + " where "
				+ " oid_remito_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_CAB, pers.getOID());
		qUpdate.setString(COMPO_RTO, pers.getComportamientoRto());
		if (pers.getSujeto() != null)
			qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qUpdate.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		qUpdate.setString(DESTINATARIO, pers.getDestinatario());
		qUpdate.setString(DESTINO, pers.getDestino());
		if (pers.getDepo_destino() != null)
			qUpdate.setInt(OID_DEPO_DEST, pers.getDepo_destino().getOID());
		else
			qUpdate.setNull(OID_DEPO_DEST, java.sql.Types.INTEGER);
		if (pers.getUni_edi_dest() != null)
			qUpdate.setInt(OID_UNI_EDI_DEST, pers.getUni_edi_dest().getOID());
		else
			qUpdate.setNull(OID_UNI_EDI_DEST, java.sql.Types.INTEGER);
		if (pers.getUni_org_dest() != null)
			qUpdate.setInt(OID_UNI_ORG_DEST, pers.getUni_org_dest().getOID());
		else
			qUpdate.setNull(OID_UNI_ORG_DEST, java.sql.Types.INTEGER);
		qUpdate.setBoolean(PEND_FACT, pers.isPend_fact().booleanValue());
		qUpdate.setString(CALLE_Y_NRO, pers.getCalle_y_nro());
		qUpdate.setString(LOCALIDAD, pers.getLocalidad());
		qUpdate.setString(CODIGO_POSTAL, pers.getCodigo_postal());
		if (pers.getProvincia() != null)
			qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qUpdate.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		if (pers.getPais() != null)
			qUpdate.setInt(OID_PAIS, pers.getPais().getOID());
		else
			qUpdate.setNull(OID_PAIS, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_COMPO_STK_RTO, pers.getCompoStkTalRto().getOID());
		qUpdate.setInt(OID_TIPO_CONF_MOV, pers.getTipoConfMov().getOID());
		if (pers.getProveedor() != null)
			qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qUpdate.setNull(OID_PROVEEDOR, Types.INTEGER);
		qUpdate.setString(TIPO_REMITO, pers.getTipoRemito());
		if (pers.getComentario() != null)
			qUpdate.setString(COMENTARIO, pers.getComentario());
		else
			qUpdate.setNull(COMENTARIO, Types.VARCHAR);

		qUpdate.setString(REFERENCIA1, pers.getReferencia1());
		qUpdate.setString(REFERENCIA2, pers.getReferencia2());

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REMITO_CAB = 1;
		RemitoCab pers = (RemitoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REMITO_CAB = 1;
		RemitoCab pers = (RemitoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRemitoCab " + " set activo=1 " + " where " + " oid_remito_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_CAB, pers.getOID());
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
		case UPDATE_REM_CAB_NO_PEND_FACT: {
			updateRemitoFactANoPendFact(aCondiciones);
			ps = null;
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NRO: {
			ps = this.selectByTCLetraLENro(aCondiciones);
			break;
		}
		case SELECT_BY_RTO_PEND_RECEP: {
			ps = this.selectByRtoPendRecep(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REMITO_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.*  FROM  veRemitoCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_remito_cab = b.oid_cco and a.oid_remito_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REMITO_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  veRemitoCab a , geComproCab b ");
		textSQL.append(" WHERE a.oid_remito_cab = b.oid_cco  ");

		Integer nroDesde = (Integer) condiciones.get("NRO_DESDE");
		if (nroDesde != null)
			textSQL.append(" and b.nro_ext>=" + nroDesde.toString());

		if (condiciones.containsKey("pend_recep"))
			textSQL.append(" and a.oid_remito_cab in (select oid_remito_cab from veRemitoDet a1, geComproCab a2 where a1.oid_remito_cab=a2.oid_cco and a1.activo=1 and a1.pend_recep=1 and a2.activo = 1) ");

		Integer nroHasta = (Integer) condiciones.get("NRO_HASTA");
		if (nroHasta != null)
			textSQL.append(" and b.nro_ext<=" + nroHasta.toString());

		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		if (fecDesde != null)
			textSQL.append(" and b.emision>=?");

		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		if (fecHasta != null)
			textSQL.append(" and b.emision<=?");

		Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
		if (talonario != null)
			textSQL.append(" and b.oid_talonario=" + talonario.getOIDInteger().toString());

		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		if (proveedor != null)
			textSQL.append(" and a.oid_proveedor=" + proveedor.getOIDInteger().toString());

		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		if (sujeto != null)
			textSQL.append(" and a.oid_sujeto=" + sujeto.getOIDInteger().toString());

		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		if (producto != null)
			textSQL.append(" and a.oid_remito_cab in (select oid_remito_cab from veRemitoDet where oid_producto = "
					+ producto.getOIDInteger().toString() + ") ");

		String tipoRemito = (String) condiciones.get("tipo_remito");
		if (tipoRemito != null)
			textSQL.append(" and a.tipo_remito='" + tipoRemito + "' ");

		String tipo = (String) condiciones.get("tipo");
		if (tipo != null) {
			if (tipo.equals("PEND_FACT")) {
				textSQL
						.append("  and b.activo = 1 and a.oid_remito_cab in (select oid_remito_cab from veRemitoDet where activo = 1 and pend_fact = 1) ");
			}
		}

		PedidoCab pedido = (PedidoCab) condiciones.get(PedidoCab.NICKNAME);
		if (pedido != null)
			textSQL
					.append("  and a.oid_remito_cab in (select oid_remito_cab from veRemitoDet , vePedidosDet where veRemitoDet.oid_ped_det = vePedidosDet.oid_ped_det and veRemitoDet.activo = 1 and vePedidosDet.anulado = 0 and vePedidosDet.oid_cco_ped = "
							+ pedido.getOIDInteger() + ") ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		if (fecDesde != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecDesde.getTime()));
		}

		fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		if (fecHasta != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecHasta.getTime()));
		}

		return querySelect;
	}

	protected void updateRemitoFactANoPendFact(Object aCondiciones) throws BaseException, SQLException {
		RemitoCab pers = (RemitoCab) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRemitoCab " + " set PEND_FACT=0 " + " where " + " oid_remito_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(1, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	private PreparedStatement selectByRtoPendRecep(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  veRemitoCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_remito_cab = b.oid_cco ");
		textSQL.append(" and b.activo = 1 and (select oid_remito_cab from veRemitoDet where activo = 1 and pend_recep=1) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByTCLetraLENro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TipoComprobante tc = (TipoComprobante) condiciones.get(TipoComprobante.NICKNAME);
		String letra = condiciones.getString("LETRA");
		LugarEmision lugEmi = (LugarEmision) condiciones.get(LugarEmision.NICKNAME);
		Integer nroExt = condiciones.getInteger("NRO_EXT");

		boolean activo = true;
		if (condiciones.containsKey("ACTIVO"))
			activo = true;
		else if (condiciones.containsKey("ANULADO"))
			activo = false;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  veRemitoCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_remito_cab = b.oid_cco ");
		textSQL.append(" and b.oid_tc = ? ");
		textSQL.append(" and b.letra = ? ");
		textSQL.append(" and b.oid_lug_emi = ? ");
		textSQL.append(" and b.nro_ext = ? ");
		textSQL.append(" and b.activo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tc.getOID());
		querySelect.setString(2, letra);
		querySelect.setInt(3, lugEmi.getOID());
		querySelect.setInt(4, nroExt.intValue());
		querySelect.setBoolean(5, activo);
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRemitoCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_remito_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veRemitoCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRemitosByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemitoCab.NICKNAME, DBRemitoCab.SELECT_BY_CONDICIONES, condiciones, new ListObserver(),
				aSesion);
	}

	public static void marcaRemitoComoNoPendFact(RemitoCab remitoCab, ISesion sesion) throws BaseException {
		ObjetoLogico.getObjects(RemitoCab.NICKNAME, DBRemitoCab.UPDATE_REM_CAB_NO_PEND_FACT, remitoCab, null, sesion);
	}

	public static int getQueryCantItemsPendFact(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			RemitoCab remitoCab = (RemitoCab) aCondiciones;
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("SELECT count(*) ");
			textSQL.append(" from VEREMITODET where  activo = 1 and pend_fact = 1 and oid_remito_cab = ? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setInt(1, remitoCab.getOID());
			ResultSet rs = querySelect.executeQuery();
			int cantItemsPendFact = 0;
			if (rs.next())
				cantItemsPendFact = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cantItemsPendFact;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

	public static RemitoCab getRemitoCab(TipoComprobante tc, String letra, LugarEmision le, Integer nroExt, boolean activo, ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TipoComprobante.NICKNAME, tc);
		condiciones.put("LETRA", letra);
		condiciones.put(LugarEmision.NICKNAME, le);
		condiciones.put("NRO_EXT", nroExt.intValue());
		if (activo)
			condiciones.put("ACTIVO", "");
		else
			condiciones.put("NO_ACTIVO", "");
		return (RemitoCab) ObjetoLogico.getObjects(RemitoCab.NICKNAME, DBRemitoCab.SELECT_BY_TC_LETRA_LE_NRO, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getRemitosPendRecep(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemitoCab.NICKNAME, DBRemitoCab.SELECT_BY_RTO_PEND_RECEP, null, new ListObserver(), aSesion);
	}

}
