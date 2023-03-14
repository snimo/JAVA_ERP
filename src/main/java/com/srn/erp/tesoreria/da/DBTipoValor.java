package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTipoValor extends DBObjetoPersistente {

	public static final String	OID_TIPO_VALOR											= "oid_tipo_valor";

	public static final String	CODIGO															= "codigo";

	public static final String	DESCRIPCION													= "descripcion";

	public static final String	COMPO																= "compo";

	public static final String	OID_MONEDA													= "oid_moneda";

	public static final String	ACTIVO															= "activo";

	public static final String	OID_AI															= "oid_ai";
	
	public static final String  SEGUI_CAJA													= "segui_caja";
	
	public static final String  DEPOSITABLE													= "depositable";
	
	public static final String  DISC_VAL_BOL_DEP										= "disc_val_bol_dep";
	
	public static final String  ES_DEUDA_FINAN										= "es_deuda_finan";
	
	public static final String  ES_DEUDA_FINAN_PROVEEDOR		= "es_deu_fin_prov";
	
	public static final String USAR_OP_TOMAR_CAJA = "usar_op_tomar_caja";
	
	public static final String OID_ANA_CON = "oid_ana_con";
	
	public static final String OID_CAJA_FIJA = "oid_caja_fija";

	public static final int			SELECT_BY_FORMA_PAGO								= 100;

	public static final int			SELECT_VAL_FORMA_PAGO								= 101;

	public static final int			SELECT_BY_HELP_FORMA_PAGO						= 102;

	public static final int			SELECT_VAL_FORMA_PAGO_BY_COND_PAGO	= 103;

	public static final int			SELECT_BY_RECIBOS										= 104;

	public static final int			SELECT_BY_HELP_TV_EFECTIVO					= 105;
	
	public static final int 		SELECT_BY_CODIGO_TV_EFECTIVO        = 106;
	
    public static final int 		SELECT_BY_CODIGO_VARIOS			  			= 107;
  
    public static final int 		SELECT_BY_ALL_DEPOSITABLES			  	= 108;
    
    public static final int 		SELECT_BY_ES_DEUDA_FINAN				= 109;
    
    public static final int 		SELECT_BY_ES_DEUDA_FINAN_PROV				= 110;
    
    public static final int 		SELECT_BY_SEGUIMIENTO_CAJA	= 111;
    
    public static final int 		SELECT_BY_COMPORTAMIENTO	= 112;
    
    public static final int			SELECT_BY_ES_TC_O_TD = 113;

	public DBTipoValor() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_VALOR = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int COMPO = 4;
		final int OID_MONEDA = 5;
		final int ACTIVO = 6;
		final int OID_AI = 7;
		final int SEGUI_CAJA = 8;
		final int DEPOSITABLE = 9;
		final int DISC_VAL_BOL_DEP = 10;
		final int USAR_OP_TOMAR_CAJA = 11;
		final int ES_DEUDA_FINAN = 12;
		final int ES_DEU_FIN_PROV  = 13;
		final int OID_ANA_CON = 14;
		final int OID_CAJA_FIJA = 15;

		TipoValor pers = (TipoValor) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vaTipoValores " + " ( " + "OID_TIPO_VALOR," + "CODIGO," + "DESCRIPCION," + "COMPO,"
				+ "OID_MONEDA," + "ACTIVO," + "OID_AI , SEGUI_CAJA , DEPOSITABLE , DISC_VAL_BOL_DEP , USAR_OP_TOMAR_CAJA , ES_DEUDA_FINAN , es_deu_fin_prov , oid_ana_con , oid_caja_fija)" + " values " + "(" + "?,"+ "?,"+ "?,"+"?,"+ "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TIPO_VALOR, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(COMPO, pers.getCompo());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCuentaImputable()!=null)
			qInsert.setInt(OID_AI, pers.getCuentaImputable().getOID());
		else
			qInsert.setNull(OID_AI, java.sql.Types.INTEGER);
		qInsert.setBoolean(SEGUI_CAJA, pers.isSeguimientoCaja().booleanValue());
		qInsert.setBoolean(DEPOSITABLE, pers.isDepositable().booleanValue());
		qInsert.setBoolean(DISC_VAL_BOL_DEP, pers.isDiscValBolDep().booleanValue());
		if (pers.isUsarTipoValorEnOP()!=null)
			qInsert.setBoolean(USAR_OP_TOMAR_CAJA, pers.isUsarTipoValorEnOP().booleanValue());
		else
			qInsert.setNull(USAR_OP_TOMAR_CAJA, java.sql.Types.BOOLEAN);
		if (pers.isDeudaFinanciera()!=null)
			qInsert.setBoolean(ES_DEUDA_FINAN, pers.isDeudaFinanciera().booleanValue());
		else
			qInsert.setNull(ES_DEUDA_FINAN, java.sql.Types.BOOLEAN);
		if (pers.isDeudaFinancieraProveedor()!=null)
			qInsert.setBoolean(ES_DEU_FIN_PROV, pers.isDeudaFinancieraProveedor().booleanValue());
		else
			qInsert.setNull(ES_DEU_FIN_PROV, java.sql.Types.BOOLEAN);
		if (pers.getCuenta()!=null)
			qInsert.setInt(OID_ANA_CON, pers.getCuenta().getOID());
		else
			qInsert.setNull(OID_ANA_CON, java.sql.Types.INTEGER);

		if (pers.getCajaFija()!=null)
			qInsert.setInt(OID_CAJA_FIJA, pers.getCajaFija().getOID());
		else
			qInsert.setNull(OID_CAJA_FIJA, java.sql.Types.INTEGER);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int COMPO = 3;
		final int OID_MONEDA = 4;
		final int OID_AI = 5;
		final int ACTIVO = 6;
		final int SEGUI_CAJA = 7;
		final int DEPOSITABLE = 8;
		final int DISC_VAL_BOL_DEP = 9;
		final int USAR_OP_TOMAR_CAJA = 10;
		final int ES_DEUDA_FINAN = 11;
		final int ES_DEU_FIN_PROV = 12;
		final int OID_ANA_CON = 13;
		final int OID_CAJA_FIJA = 14;
		final int OID_TIPO_VALOR = 15;

		TipoValor pers = (TipoValor) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vaTipoValores set " + "codigo=?" + ",descripcion=?" + ",compo=?" + ",oid_moneda=?"
				+ ",oid_ai=?" + ",activo=? , segui_caja = ? , depositable = ? , disc_val_bol_dep = ? , usar_op_tomar_caja = ? , es_deuda_finan = ? , es_deu_fin_prov = ? , oid_ana_con = ? , oid_caja_fija = ? " + " where " + " oid_tipo_valor=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(COMPO, pers.getCompo());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		if (pers.getCuentaImputable()!=null)
			qUpdate.setInt(OID_AI, pers.getCuentaImputable().getOID());
		else
			qUpdate.setNull(OID_AI, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(DEPOSITABLE, pers.isDepositable().booleanValue());
		qUpdate.setBoolean(DISC_VAL_BOL_DEP, pers.isDiscValBolDep().booleanValue());
		qUpdate.setBoolean(SEGUI_CAJA, pers.isSeguimientoCaja().booleanValue());
		if (pers.isUsarTipoValorEnOP()!=null)
			qUpdate.setBoolean(USAR_OP_TOMAR_CAJA, pers.isUsarTipoValorEnOP().booleanValue());
		else
			qUpdate.setNull(USAR_OP_TOMAR_CAJA, java.sql.Types.BOOLEAN);
		if (pers.isDeudaFinanciera()!=null)
			qUpdate.setBoolean(ES_DEUDA_FINAN, pers.isDeudaFinanciera().booleanValue());
		else
			qUpdate.setNull(ES_DEUDA_FINAN, java.sql.Types.BOOLEAN);		
		if (pers.isDeudaFinancieraProveedor()!=null)
			qUpdate.setBoolean(ES_DEU_FIN_PROV, pers.isDeudaFinancieraProveedor().booleanValue());
		else
			qUpdate.setNull(ES_DEU_FIN_PROV, java.sql.Types.BOOLEAN);
		if (pers.getCuenta()!=null)
			qUpdate.setInt(OID_ANA_CON, pers.getCuenta().getOID());
		else
			qUpdate.setNull(OID_ANA_CON, java.sql.Types.INTEGER);
		
		if (pers.getCajaFija()!=null)
			qUpdate.setInt(OID_CAJA_FIJA, pers.getCajaFija().getOID());
		else
			qUpdate.setNull(OID_CAJA_FIJA, java.sql.Types.INTEGER);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_VALOR = 1;
		TipoValor pers = (TipoValor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaTipoValores " + " set activo=0 " + " where " + " oid_tipo_valor=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_VALOR = 1;
		TipoValor pers = (TipoValor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaTipoValores " + " set activo=1 " + " where " + " oid_tipo_valor=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectByAll(aCondiciones);
			break;
		}
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
		case SELECT_BY_CODIGO_VARIOS: {
			ps = this.selectByCodigoVarios(aCondiciones);
			break;
		}
		case SELECT_BY_FORMA_PAGO: {
			ps = this.selectByFormaPago(aCondiciones);
			break;
		}
		case SELECT_VAL_FORMA_PAGO: {
			ps = this.selectByValidarFormaPago(aCondiciones);
			break;
		}
		case SELECT_VAL_FORMA_PAGO_BY_COND_PAGO: {
			ps = this.selectByTipoValorByCondPago(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_FORMA_PAGO: {
			ps = this.selectByHelpFormaPago(aCondiciones);
			break;
		}
		case SELECT_BY_RECIBOS: {
			ps = this.selectByRecibos(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_TV_EFECTIVO: {
			ps = this.selectByHelpTipoValorEfectivo(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_TV_EFECTIVO: {
			ps = this.selectByCodigoTipoValorEfectivo(aCondiciones);
			break;
		}
		case SELECT_BY_ALL_DEPOSITABLES: {
			ps = this.selectByAllDepositables(aCondiciones);
			break;
		}
		case SELECT_BY_ES_DEUDA_FINAN: {
			ps = this.selectByDeudaFinan(aCondiciones);
			break;
		}
		case SELECT_BY_ES_TC_O_TD: {
			ps = this.selectByTarjetaCreditoOTarjetaDebito(aCondiciones);
			break;
		}
		case SELECT_BY_ES_DEUDA_FINAN_PROV: {
			ps = this.selectByDeudaFinanProv(aCondiciones);
			break;
		}
		case SELECT_BY_SEGUIMIENTO_CAJA: {
			ps = this.selectBySeguimientoCaja(aCondiciones);
			break;
		}
		case SELECT_BY_COMPORTAMIENTO: {
			ps = this.selectByComportamiento(aCondiciones);
			break;
		}
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TIPO_VALOR = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE oid_tipo_valor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TIPO_VALOR, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByDeudaFinan(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE es_deuda_finan = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	private PreparedStatement selectByComportamiento(Object aCondiciones) throws BaseException, SQLException {

		String comportamiento = (String) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE compo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, comportamiento);
		return querySelect;
	}
	
	private PreparedStatement selectBySeguimientoCaja(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE segui_caja = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByDeudaFinanProv(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE es_deu_fin_prov = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByTarjetaCreditoOTarjetaDebito(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE compo IN ('TAR_CRE','TAR_DEB') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
		
	}
	
	private PreparedStatement selectByAllDepositables(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE depositable = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByRecibos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE compo in ('EFE_ML','EFE_ME','CHE_TER','TAR_CRE','TICKET','DOC_CLI','TAR_DEB','CHE_CLI') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

		

	private PreparedStatement selectByCodigoVarios(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		MapDatos condiciones = (MapDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE codigo = ? ");
		
		if (condiciones.containsKey("SOLO_DEPOSITABLE"))
			textSQL.append(" and depositable = 1");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = condiciones.getString("codigo");
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE codigo = ? ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByCodigoTipoValorEfectivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE codigo = ? and  oid_tipo_valor in (select oid_tipo_valor from vatipovalores where compo in ('EFE_ML','EFE_ME'))  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String codigo = (String) condiciones.get("codigo");
		querySelect.setString(1, codigo);
		return querySelect;
	}
	
	
	private PreparedStatement selectByFormaPago(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL
				.append(" WHERE oid_tipo_valor" + " in (select oid_tipo_valor from cpFormaPagoTV where oid_forma_pago = ?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		FormaPago formaPago = (FormaPago) aCondiciones;
		querySelect.setInt(1, formaPago.getOID());
		return querySelect;
	}

	private PreparedStatement selectByValidarFormaPago(Object aCondiciones) throws BaseException, SQLException {
		Hashtable condiciones = (Hashtable) aCondiciones;
		String codigo = (String) condiciones.get(DBTipoValor.CODIGO);
		FormaPago formaPago = (FormaPago) condiciones.get(FormaPago.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE codigo = ? and oid_tipo_valor"
				+ " in (select oid_tipo_valor from cpFormaPagoTV where oid_forma_pago = ?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, codigo);
		querySelect.setInt(2, formaPago.getOID());
		return querySelect;
	}

	private PreparedStatement selectByAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByTipoValorByCondPago(Object aCondiciones) throws BaseException, SQLException {
		MapDatos mapaDatos = (MapDatos) aCondiciones;
		Integer oidCondPago = null;
		if (mapaDatos.containsKey("oid_cond_pago"))
			oidCondPago = mapaDatos.getInteger("oid_cond_pago");
		String codigo = mapaDatos.getString("codigo");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaTipoValores ");
		textSQL.append(" WHERE codigo=? and activo = 1 ");
		if ((oidCondPago != null) && (oidCondPago.intValue() != 0))
			textSQL.append(" and oid_tipo_valor in (select oid_tipo_valor from veCondPagoTipoVal where oid_cond_pago = "
					+ oidCondPago.intValue() + ") ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectByHelpTipoValorEfectivo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" select ");
		textSQL.append("    oid_tipo_valor oid,");
		textSQL.append("    codigo codigo, ");
		textSQL.append("    descripcion descripcion ,");
		textSQL.append("    activo ");
		textSQL.append(" from ");
		textSQL.append("    vaTipoValores ");
		textSQL.append(" where ");
		textSQL.append("    oid_tipo_valor in (select oid_tipo_valor from vatipovalores where compo in ('EFE_ML','EFE_ME')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}


	private PreparedStatement selectByHelpVarios(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_valor oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from vaTipoValores where 1=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		if (condiciones.containsKey("SOLO_DEPOSITABLE")) 
			textSQL.append(" and depositable = 1");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_valor oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from vaTipoValores where 1=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		if (condiciones.containsKey("SOLO_DEPOSITABLE")) 
			textSQL.append(" and depositable = 1");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByHelpFormaPago(Object aCondiciones) throws BaseException, SQLException {

		MapDatos mapaDatos = (MapDatos) aCondiciones;

		Integer oidCondPago = null;
		if (mapaDatos.containsKey("oid_cond_pago"))
			oidCondPago = mapaDatos.getInteger("oid_cond_pago");

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_valor oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from vaTipoValores where 1=1 ");

		if ((oidCondPago != null) && (oidCondPago.intValue() != 0))
			textSQL.append(" and oid_tipo_valor in (select oid_tipo_valor from veCondPagoTipoVal where oid_cond_pago="
					+ oidCondPago.intValue() + ") ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getTiposValorByFormaPago(FormaPago formaPago, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, SELECT_BY_FORMA_PAGO, formaPago, new ListObserver(),
				aSesion);
	}

	public static TipoValor getValidarTipoValorByFormaPago(String codigo, FormaPago formaPago, ISesion aSesion)
			throws BaseException {
		Hashtable condiciones = new Hashtable();
		condiciones.put(DBTipoValor.CODIGO, codigo);
		condiciones.put(FormaPago.NICKNAME, formaPago);

		return (TipoValor) ObjetoLogico.getObjects(TipoValor.NICKNAME, SELECT_VAL_FORMA_PAGO, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getAllTiposValores(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_ALL, null, new ListObserver(), aSesion);
	}

	public static List getValoresIngresoRecibo(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_RECIBOS, null, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresDepositables(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_ALL_DEPOSITABLES, null, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresDeudaFinanciera(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_ES_DEUDA_FINAN, null, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresDeudaFinancieraProveedor(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_ES_DEUDA_FINAN_PROV, null, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresConMoviEnCaja(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_SEGUIMIENTO_CAJA, null, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresByComportamiento(String comportamiento,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_COMPORTAMIENTO, comportamiento, new ListObserver(),
				aSesion);
	}
	
	public static List getTiposValoresByTCyTD(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoValor.NICKNAME, DBTipoValor.SELECT_BY_ES_TC_O_TD, null, new ListObserver(),
				aSesion);
	}

}
