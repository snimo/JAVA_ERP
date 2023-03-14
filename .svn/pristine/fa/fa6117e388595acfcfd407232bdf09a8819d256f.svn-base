package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.bm.ValorCompo;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.MotivoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCuentaImputable extends DBObjetoPersistente {

	public static final String	OID_AI																	= "oid_ai";

	public static final String	OID_ANA_CON															= "oid_ana_con";

	public static final String	ACTIVO																	= "activo";

	public static final int			SELECT_BY_CUENTA												= 100;

	public static final int			SELECT_BY_CUENTA_Y_VAL_COMPO						= 101;

	public static final int			SELECT_BY_CUENTA_Y_VALORES_COMPO				= 102;

	public static final int			SELECT_BY_CUENTA_Y_NOT_IN_VALORES_COMPO	= 103;

	public static final int			SELECT_BY_CUENTA_IS_HAB_MOTINGVAR				= 104;

	public static final int			SELECT_BY_CUENTA_IS_HAB_REND_FF					= 105;

	public static final int			SELECT_BY_CUENTA_IS_HAB_CONC_FACT				= 106;
	
	public static final int 		SELECT_BY_CUENTA_IS_HAB_MOD_BANCOS			= 107;			

	public DBCuentaImputable() {
	}

	private String getCamposUpdateActuValCompo(CuentaImputable cuentaImputable) throws BaseException {
		/*
		 * String returnCamposActuValCompo = ""; if (cuentaImputable.getValoresDeComponentes()!=null) { StringBuffer
		 * actuCampos = new StringBuffer(); Iterator iterValCompos = cuentaImputable.getValoresDeComponentes().iterator();
		 * while (iterValCompos.hasNext()) { String actu = ""; ValorCompo valorCompo = (ValorCompo) iterValCompos.next();
		 * actu = ","+valorCompo.getComponente().getCampoFisicoAnaImp()+"="+valorCompo.getOIDInteger().toString();
		 * actuCampos.append(actu); } returnCamposActuValCompo = actuCampos.toString(); }
		 */
		// return returnCamposActuValCompo;
		return null;
	}

	private String getListaValoresCompo(CuentaImputable cuentaImputable) throws BaseException {
		StringBuffer listaValCompo = new StringBuffer("");
		if (cuentaImputable.getCuenta().getEstructura() != null) {
			Iterator iterEstrcCompo = cuentaImputable.getCuenta().getEstructura().getEstrucComponenentes().iterator();
			while (iterEstrcCompo.hasNext()) {
				EstructuraCompo estCompo = (EstructuraCompo) iterEstrcCompo.next();
				IObjetoLogico valorCompo = cuentaImputable.getValorCompo(estCompo.getComponente());
				if (valorCompo == null) {
					String descEstruc = "";
					if (cuentaImputable.getCuenta().getEstructura()!=null)
						descEstruc = "Estructura Cuenta:"+cuentaImputable.getCuenta().getDescEstrucCta()+Util.ENTER();
					
					throw new ExceptionValidation(null, "No se ha ingresado valor para el componente "
							+ estCompo.getComponente().getDescripcion()+"."+Util.ENTER()+
							descEstruc+
							"Cuenta ingresada:"+Util.ENTER()+cuentaImputable.getCodigoCuentaMasCodigosValCompo()+Util.ENTER()+
							cuentaImputable.getDescCuentaMasDescValCompo());
				}
				listaValCompo.append(estCompo.getComponente().getCondWhereListaValores(valorCompo));
			}
		}
		return listaValCompo.toString();
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AI = 1;
		final int OID_ANA_CON = 2;
		final int ACTIVO = 3;

		CuentaImputable pers = (CuentaImputable) objetoPersistente;
		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgAnaImpCon " + " ( " + "OID_AI," + "OID_ANA_CON," + "ACTIVO"
				+ pers.getCuenta().getListaCamposComponentes() + ") " + " values " + "(" + "?," + "?," + "?"
				+ getListaValoresCompo(pers) + ") ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AI, pers.getOID());
		qInsert.setInt(OID_ANA_CON, pers.getCuenta().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ANA_CON = 1;
		final int ACTIVO = 2;
		final int OID_AI = 3;

		CuentaImputable pers = (CuentaImputable) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgAnaImpCon set " + "oid_ana_con=?" + ",activo=?" + getCamposUpdateActuValCompo(pers)
				+ " where " + " oid_ai=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AI, pers.getOID());
		qUpdate.setInt(OID_ANA_CON, pers.getCuenta().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AI = 1;

		CuentaImputable pers = (CuentaImputable) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgAnaImpCon " + " set activo=0 " + " where " + " oid_ai=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();

	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AI = 1;
		CuentaImputable pers = (CuentaImputable) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgAnaImpCon " + " set activo=1 " + " where " + " oid_ai=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AI, pers.getOID());
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
		case SELECT_BY_CUENTA: {
			ps = this.selectByCuenta(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_Y_VAL_COMPO: {
			ps = this.selectByCuentayValCompo(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_Y_VALORES_COMPO: {
			ps = this.selectByValoresCompo(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_Y_NOT_IN_VALORES_COMPO: {
			ps = this.selectByNotINValoresCompo(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_IS_HAB_MOTINGVAR: {
			ps = this.selectByCuentaHabMotIngVar(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_IS_HAB_REND_FF: {
			ps = this.selectByCuentaHabRendFF(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_IS_HAB_CONC_FACT: {
			ps = this.selectByCuentaHabConcFactProv(aCondiciones);
			break;
		}
		case SELECT_BY_CUENTA_IS_HAB_MOD_BANCOS: {
			ps = this.selectByCuentaHabModuloBancos(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ai = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AI, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCuentayValCompo(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ANA_CON = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ana_con = ? ");

		Hashtable params = (Hashtable) aCondiciones;
		Cuenta cuenta = (Cuenta) params.get(Cuenta.NICKNAME);
		HashTableDatos valoresCompo = (HashTableDatos) params.get(ValorCompo.NICKNAME);
		StringBuffer condValCompo = new StringBuffer("");
		
		HashTableDatos valoresDeComponentes = new HashTableDatos();
		
		if (cuenta.getEstructura()!=null) {
			
			Iterator iterEstrucCompo =
				cuenta.getEstructura().getEstrucComponenentes().iterator();
			while (iterEstrucCompo.hasNext()) {
				
				EstructuraCompo estrucCompo  = 
					(EstructuraCompo) iterEstrucCompo.next();
				
				// Recorrer los valores de componentes enviados
				boolean encontroValorCompo = false;
				Iterator iterComponentes = valoresCompo.keySet().iterator();
				while (iterComponentes.hasNext()) {
					Componente componente = (Componente) iterComponentes.next();
					if (componente.getOID() == estrucCompo.getComponente().getOIDInteger()) {
						IObjetoLogico objLog = (IObjetoLogico) valoresCompo.get(componente);
						condValCompo.append(" and " + componente.getCondWhereValor(objLog));
						encontroValorCompo = true;
						valoresDeComponentes.put(estrucCompo.getComponente(), objLog);
						break;
					}
				}
				
				if (!encontroValorCompo) {
					IObjetoLogico objLog = Componente.getDeducirValorComponente(valoresDeComponentes, estrucCompo.getComponente(), this.getSesion());
					if (objLog == null)
						objLog = estrucCompo.getValorDefault();
					if (objLog!=null) {
						condValCompo.append(" and " + estrucCompo.getComponente().getCondWhereValor(objLog));
						valoresDeComponentes.put(estrucCompo.getComponente(), objLog);
					} else {
						String descEstruc = "";
						if (cuenta.getEstructura()!=null)
							descEstruc = "Estructura Cuenta:"+cuenta.getDescEstrucCta()+Util.ENTER();
						
						StringBuffer valoresConcat = new StringBuffer();
						Iterator iterCompo = valoresCompo.keySet().iterator();
						while (iterCompo.hasNext()) {
							Componente componente = (Componente) iterCompo.next();
							IObjetoLogico objLogIng = (IObjetoLogico) valoresCompo.get(componente);
							if (valoresConcat.length()>0)
								valoresConcat.append(".");
							valoresConcat.append(objLogIng.getCodigo());
							}
						
						
						throw new ExceptionValidation(null, "No se ha ingresado valor para el componente "
								+ estrucCompo.getComponente().getDescripcion()+"."+Util.ENTER()+
								descEstruc+
								"Cuenta ingresada:"+Util.ENTER()+cuenta.getCodigo()+"-"+cuenta.getDescripcion()+Util.ENTER()+
								"Valores ingresados:"+valoresConcat.toString());

					}
				}
				
				
			}
		}
		
		textSQL.append(condValCompo.toString());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID_ANA_CON, cuenta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCuentaHabMotIngVar(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaImputable cuentaImputable = (CuentaImputable) condiciones.get(CuentaImputable.NICKNAME);
		MotivoComprobante motivoCompro = (MotivoComprobante) condiciones.get(MotivoComprobante.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ai = " + cuentaImputable.getOIDInteger());
		textSQL.append(" and oid_ai in (" + getRestCuentasParaIngVarios(motivoCompro, this.getSesion()) + ")");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCuentaHabConcFactProv(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaImputable cuentaImputable = (CuentaImputable) condiciones.get(CuentaImputable.NICKNAME);
		ConcFactProv concFactProv = (ConcFactProv) condiciones.get(ConcFactProv.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ai = " + cuentaImputable.getOIDInteger());
		textSQL.append(" and oid_ana_con in (" + getRestCuentasParaConcFactProv(this.getSesion(), concFactProv) + ")");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCuentaHabRendFF(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaImputable cuentaImputable = (CuentaImputable) condiciones.get(CuentaImputable.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ai = " + cuentaImputable.getOIDInteger());
		textSQL.append(" and oid_ana_con in (" + getRestCuentasParaRendFF(this.getSesion()) + ")");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCuentaHabModuloBancos(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaImputable cuentaImputable = (CuentaImputable) condiciones.get(CuentaImputable.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ai = " + cuentaImputable.getOIDInteger());
		textSQL.append(" and oid_ai in (" + getRestCuentasParaModuloBancos(this.getSesion()) + ")");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
		
	}
	

	private PreparedStatement selectByCuenta(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ANA_CON = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ana_con = ?");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Cuenta cuenta = (Cuenta) aCondiciones;
		querySelect.setInt(OID_ANA_CON, cuenta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByValoresCompo(Object aCondiciones) throws BaseException, SQLException {

		Hashtable condiciones = (Hashtable) aCondiciones;
		Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
		HashTableDatos valoresCompo = (HashTableDatos) condiciones.get(ValorCompo.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ana_con = ? ");

		Iterator iterCompo = valoresCompo.keySet().iterator();
		while (iterCompo.hasNext()) {
			Componente componente = (Componente) iterCompo.next();
			IObjetoLogico valorCompo = (IObjetoLogico) valoresCompo.get(componente);
			textSQL.append(" and " + componente.getCampoFisicoAnaImp() + "=" + valorCompo.getOIDInteger().toString());
		}
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, cuenta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByNotINValoresCompo(Object aCondiciones) throws BaseException, SQLException {

		Hashtable condiciones = (Hashtable) aCondiciones;
		Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
		HashTableDatos valoresCompo = (HashTableDatos) condiciones.get(ValorCompo.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAnaImpCon ");
		textSQL.append(" WHERE oid_ana_con = ? and oid_ai not in (select oid_ai from cgAnaImpCon where oid_ana_con = ? ");

		Iterator iterCompo = valoresCompo.keySet().iterator();
		while (iterCompo.hasNext()) {
			Componente componente = (Componente) iterCompo.next();
			IObjetoLogico valorCompo = (IObjetoLogico) valoresCompo.get(componente);
			textSQL.append(" and " + componente.getCampoFisicoAnaImp() + "=" + valorCompo.getOIDInteger().toString());
		}
		textSQL.append(" ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, cuenta.getOID());
		querySelect.setInt(2, cuenta.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ai oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cgAnaImpCon");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getImputablesByCuenta(Cuenta cuenta, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(CuentaImputable.NICKNAME, SELECT_BY_CUENTA, cuenta, new ListObserver(),
				aSesion);

	}

	public static CuentaImputable getImputableByCuentayValCompo(Cuenta cuenta, HashTableDatos valoresCompo,
			ISesion aSesion) throws BaseException {
		
		

		Hashtable params = new Hashtable();
		params.put(Cuenta.NICKNAME, cuenta);
		params.put(ValorCompo.NICKNAME, valoresCompo);
		return (CuentaImputable) ObjetoLogico.getObjects(CuentaImputable.NICKNAME, SELECT_BY_CUENTA_Y_VAL_COMPO, params,
				new ObjetoObservado(), aSesion);

	}

	public static List getImputablesByCuentayValoresCompo(Cuenta cuenta, HashTableDatos valoresCompo, ISesion aSesion)
			throws BaseException {

		Hashtable params = new Hashtable();
		params.put(Cuenta.NICKNAME, cuenta);
		params.put(ValorCompo.NICKNAME, valoresCompo);
		return (List) ObjetoLogico.getObjects(CuentaImputable.NICKNAME, SELECT_BY_CUENTA_Y_VALORES_COMPO, params,
				new ListObserver(), aSesion);

	}

	public static List getImputablesByCuentayNotInValoresCompo(Cuenta cuenta, HashTableDatos valoresCompo, ISesion aSesion)
			throws BaseException {

		Hashtable params = new Hashtable();
		params.put(Cuenta.NICKNAME, cuenta);
		params.put(ValorCompo.NICKNAME, valoresCompo);
		return (List) ObjetoLogico.getObjects(CuentaImputable.NICKNAME, SELECT_BY_CUENTA_Y_NOT_IN_VALORES_COMPO, params,
				new ListObserver(), aSesion);

	}

	public static String getRestCuentasParaIngVarios(MotivoComprobante motivoComprobante, ISesion sesion)
			throws BaseException {
		StringBuffer condIngVar = new StringBuffer("");
		condIngVar.append(" select oid_ai from teCtasIngVar where activo = 1 and ");
		condIngVar.append(" oid_cta_int_iv in ( ");
		condIngVar.append("    select ");
		condIngVar.append("     oid_cta_int_iv ");
		condIngVar.append("    from ");
		condIngVar.append("      teIngVarUniOrg where oid_uni_org in ( ");
		condIngVar.append("         select ");
		condIngVar.append("           oid_uni_org ");
		condIngVar.append("         from ");
		condIngVar.append("           seUniOrgHabUsu ");
		condIngVar.append("         where ");
		condIngVar.append("           oid_empresa = " + sesion.getLogin().getOidEmpresa() + " and ");
		condIngVar.append("           oid_sucursal = " + sesion.getLogin().getOidSucursal() + " and ");
		condIngVar.append("           oid_usuario = " + sesion.getLogin().getUsuario().getOIDInteger() + ") ");
		condIngVar.append(") ");
		condIngVar.append(" and ");
		condIngVar.append(" oid_mot_hab_iv in ( ");
		condIngVar.append("  select oid_mot_hab_iv from teMotHabIngVar where habilitado=1 and oid_motivo_tc in ( ");
		condIngVar.append("   select ");
		condIngVar.append("      oid_motivo_tc ");
		condIngVar.append("   from ");
		condIngVar.append("      geMotivosTC ");
		condIngVar.append("   where ");
		condIngVar.append("      oid_motivo_compro = " + motivoComprobante.getOIDInteger() + " and ");
		condIngVar.append("      oid_tc in (select oid_tc from geTipoCompro where identificacion='RECIB'))) ");
		return condIngVar.toString();
	}

	public static String getRestCuentasParaRendFF(ISesion sesion) throws BaseException {
		StringBuffer condRenfFF = new StringBuffer("");
		condRenfFF.append(" select a.oid_ana_con from opUniOrgFFCta a,opUniOrgFF b ");
		condRenfFF.append(" where a.oid_uni_org_ff = b.oid_uni_org_ff and a.activo=1 and b.activo=1 and ");
		condRenfFF.append("          b.oid_uni_org in ( ");
		condRenfFF.append("         select ");
		condRenfFF.append("           oid_uni_org ");
		condRenfFF.append("         from ");
		condRenfFF.append("           seUniOrgHabUsu ");
		condRenfFF.append("         where ");
		condRenfFF.append("           oid_empresa = " + sesion.getLogin().getOidEmpresa() + " and ");
		condRenfFF.append("           oid_sucursal = " + sesion.getLogin().getOidSucursal() + " and ");
		condRenfFF.append("           oid_usuario = " + sesion.getLogin().getUsuario().getOIDInteger() + ") ");

		return condRenfFF.toString();
	}
	
	
	public static String getRestCuentasParaModuloBancos(ISesion sesion) throws BaseException {
		StringBuffer condRenfFF = new StringBuffer("");
		condRenfFF.append(" select a.oid_ai from vaCtasHabBancos a ");
		condRenfFF.append(" where a.activo=1 and ");
		condRenfFF.append("          a.oid_uni_org in ( ");
		condRenfFF.append("         select ");
		condRenfFF.append("           oid_uni_org ");
		condRenfFF.append("         from ");
		condRenfFF.append("           seUniOrgHabUsu ");
		condRenfFF.append("         where ");
		condRenfFF.append("           oid_empresa = " + sesion.getLogin().getOidEmpresa() + " and ");
		condRenfFF.append("           oid_sucursal = " + sesion.getLogin().getOidSucursal() + " and ");
		condRenfFF.append("           oid_usuario = " + sesion.getLogin().getUsuario().getOIDInteger() + ") ");

		return condRenfFF.toString();
	}
	

	public static String getRestCuentasParaConcFactProv(ISesion sesion, ConcFactProv concFactProv) throws BaseException {
		StringBuffer condRenfFF = new StringBuffer("");
		condRenfFF.append(" select a.oid_ana_con from cpCtasConcFactProv a ");
		condRenfFF.append(" where a.oid_conc_fact_prov = " + concFactProv.getOIDInteger().toString());
		return condRenfFF.toString();
	}

	public static CuentaImputable getCuentaimputableHabIngVar(CuentaImputable cuentaImputable,
			MotivoComprobante motivoComprobante, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaImputable.NICKNAME, cuentaImputable);
		condiciones.put(MotivoComprobante.NICKNAME, motivoComprobante);
		return (CuentaImputable) ObjetoLogico.getObjects(CuentaImputable.NICKNAME,
				DBCuentaImputable.SELECT_BY_CUENTA_IS_HAB_MOTINGVAR, condiciones, new ObjetoObservado(), aSesion);
	}

	public static CuentaImputable getCuentaimputableHabRendFF(CuentaImputable cuentaImputable, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaImputable.NICKNAME, cuentaImputable);
		return (CuentaImputable) ObjetoLogico.getObjects(CuentaImputable.NICKNAME,
				DBCuentaImputable.SELECT_BY_CUENTA_IS_HAB_REND_FF, condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static CuentaImputable getCuentaimputableHabModuloBancos(CuentaImputable cuentaImputable, ISesion aSesion)
	throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaImputable.NICKNAME, cuentaImputable);
		
		return (CuentaImputable) ObjetoLogico.getObjects(CuentaImputable.NICKNAME,
				DBCuentaImputable.SELECT_BY_CUENTA_IS_HAB_MOD_BANCOS, 
				condiciones, 
				new ObjetoObservado(), aSesion);
		
	}
	

	public static CuentaImputable getCuentaimputableHabConcFactProv(CuentaImputable cuentaImputable,
			ConcFactProv concFactProv, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaImputable.NICKNAME, cuentaImputable);
		condiciones.put(ConcFactProv.NICKNAME, concFactProv);
		return (CuentaImputable) ObjetoLogico.getObjects(CuentaImputable.NICKNAME,
				DBCuentaImputable.SELECT_BY_CUENTA_IS_HAB_CONC_FACT, condiciones, new ObjetoObservado(), aSesion);
	}

}
