package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.pagos.bm.MotivoPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class DBCuenta extends DBObjetoPersistente {

  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ES_PATRIMONIAL = "es_patrimonial";
  public static final String ES_CTA_INTERNA = "es_cta_interna";
  public static final String OID_ESTRUC = "oid_estruc";
  public static final String OID_TIPO_CAMBIO = "oid_tipo_cambio";
  public static final String OID_INDICE = "oid_indice";
  public static final String ACTIVO = "activo";
  public static final String SUBSISTEMA = "subsistema";
  public static final String ES_IMPUESTO = "es_impuesto";

  public static final int SELECT_BY_RANGO_CUENTAS = 100;
  public static final int SELECT_HELP_CUENTAS     = 101;
  public static final int SELECT_HELP_CUENTAS_CON_COMPO     = 102;
  public final static int SELECT_BY_CODIGO_CON_COMPO = 103;
  

  public DBCuenta() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_ANA_CON = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ES_PATRIMONIAL = 4;
    final int ES_CTA_INTERNA = 5;
    final int OID_ESTRUC = 6;
    final int OID_TIPO_CAMBIO = 7;
    final int OID_INDICE = 8;
    final int ACTIVO = 9;
    final int SUBSISTEMA = 10;
    final int ES_IMPUESTO = 11;

    Cuenta pers = (Cuenta) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgAnaCon "+
                     " ( "+
                      "OID_ANA_CON,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ES_PATRIMONIAL,"+
                      "ES_CTA_INTERNA,"+
                      "OID_ESTRUC,"+
                      "OID_TIPO_CAMBIO,"+
                      "OID_INDICE,"+
                      "ACTIVO,"+
                      "SUBSISTEMA,ES_IMPUESTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_ANA_CON,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ES_PATRIMONIAL,pers.isEspatrimonial().booleanValue());
    qInsert.setBoolean(ES_CTA_INTERNA,pers.isEsctainterna().booleanValue());
    if (pers.getEstructura()!=null)
      qInsert.setInt(OID_ESTRUC,pers.getEstructura().getOID());
    else
      qInsert.setNull(OID_ESTRUC,java.sql.Types.INTEGER);
    if (pers.getTipocambio()!=null)
      qInsert.setInt(OID_TIPO_CAMBIO,pers.getTipocambio().getOID());
    else
      qInsert.setNull(OID_TIPO_CAMBIO,java.sql.Types.INTEGER);
    if (pers.getIndice()!=null)
      qInsert.setInt(OID_INDICE,pers.getIndice().getOID());
    else
      qInsert.setNull(OID_INDICE,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getSubsistema()!=null)
      qInsert.setString(SUBSISTEMA,pers.getSubsistema());
    else
      qInsert.setNull(SUBSISTEMA,java.sql.Types.VARCHAR);
    qInsert.setBoolean(ES_IMPUESTO, pers.esImpuesto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ES_PATRIMONIAL = 3;
    final int ES_CTA_INTERNA = 4;
    final int OID_ESTRUC = 5;
    final int OID_TIPO_CAMBIO = 6;
    final int OID_INDICE = 7;
    final int ACTIVO = 8;
    final int SUBSISTEMA = 9;
    final int ES_IMPUESTO = 10;
    final int OID_ANA_CON = 11;

    Cuenta pers = (Cuenta) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgAnaCon set "+
              "codigo=?"+
              ",descripcion=?"+
              ",es_patrimonial=?"+
              ",es_cta_interna=?"+
              ",oid_estruc=?"+
              ",oid_tipo_cambio=?"+
              ",oid_indice=?"+
              ",activo=?"+
              ",subsistema=?"+
              ",es_impuesto=?"+
                 " where " +
                 " oid_ana_con=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ANA_CON,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ES_PATRIMONIAL,pers.isEspatrimonial().booleanValue());
    qUpdate.setBoolean(ES_CTA_INTERNA,pers.isEsctainterna().booleanValue());
    if (pers.getEstructura()!=null)
      qUpdate.setInt(OID_ESTRUC,pers.getEstructura().getOID());
    else
      qUpdate.setNull(OID_ESTRUC,java.sql.Types.INTEGER);
    if (pers.getTipocambio()!=null)
      qUpdate.setInt(OID_TIPO_CAMBIO,pers.getTipocambio().getOID());
    else
      qUpdate.setNull(OID_TIPO_CAMBIO,java.sql.Types.INTEGER);
    if (pers.getIndice()!=null)
      qUpdate.setInt(OID_INDICE,pers.getIndice().getOID());
    else
      qUpdate.setNull(OID_INDICE,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getSubsistema()!=null)
      qUpdate.setString(SUBSISTEMA,pers.getSubsistema());
    else
      qUpdate.setNull(SUBSISTEMA,java.sql.Types.VARCHAR);
    qUpdate.setBoolean(ES_IMPUESTO, pers.esImpuesto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_ANA_CON = 1;
    Cuenta pers = (Cuenta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgAnaCon "+
                     " set activo=0 " +
                     " where " +
                     " oid_ana_con=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ANA_CON, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_ANA_CON = 1;
    Cuenta pers = (Cuenta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgAnaCon "+
                     " set activo=1 " +
                     " where " +
                     " oid_ana_con=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ANA_CON, pers.getOID());
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
      case SELECT_BY_CODIGO_CON_COMPO: {
          ps = this.selectByCodigoConCompo(aCondiciones);
          break;
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
          ps = this.selectAllActivos(aCondiciones);
          break;
        }
      case SELECT_HELP_CUENTAS_CON_COMPO: {
          ps = this.selectAllHelpConCompo(aCondiciones);
          break;
      }      
      case SELECT_BY_RANGO_CUENTAS: {
        ps = this.selectRangoCuentas(aCondiciones);
        break;
      }
      case SELECT_HELP_CUENTAS: {
        ps = this.selectHelpCuentas(aCondiciones);
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_ANA_CON = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgAnaCon ");
    textSQL.append(" WHERE oid_ana_con = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_ANA_CON, oid);
    return querySelect;
  }

  private PreparedStatement selectRangoCuentas(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO_DESDE = 1;
    final int CODIGO_HASTA = 2;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgAnaCon ");
    textSQL.append(" WHERE codigo >= ? and codigo<= ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    HashTableDatos hsDatos = (HashTableDatos)aCondiciones;
    String codigoDesde = hsDatos.getString("codigo_desde");
    String codigoHasta = hsDatos.getString("codigo_hasta");

    querySelect.setString(CODIGO_DESDE, codigoDesde);
    querySelect.setString(CODIGO_HASTA, codigoHasta);
    return querySelect;
  }

  private PreparedStatement selectHelpCuentas(Object aCondiciones) throws BaseException, SQLException {

    MapDatos mapDatos = (MapDatos)aCondiciones;
    StringBuffer condWhere = new StringBuffer();

    
	// Descripcion del producto
	if (mapDatos.containsKey("descripcion") && 
		 (mapDatos.getString("descripcion").length()>0)) {			
		StringTokenizer st = new StringTokenizer(mapDatos.getString("descripcion"), " ");
		while (st.hasMoreTokens()) {
			String next = st.nextToken().toUpperCase();
			condWhere.append(" and descripcion like '%" + next + "%' ");
		}
	}			
        

    if (mapDatos.containsKey("oid_estruc"))
      condWhere.append(" and oid_estruc =" +
                       mapDatos.getInteger("oid_estruc").toString() + " ");

    if (mapDatos.containsKey("codigo"))
      condWhere.append(" and codigo like '%" +
                       mapDatos.getString("codigo") + "%' ");

    if (mapDatos.containsKey("codigo_exacto"))
      condWhere.append(" and codigo = '" +mapDatos.getString("codigo_exacto")+ "'");
    
    if (mapDatos.containsKey("oid_compo")) {
    	Integer oidCompo = mapDatos.getInteger("oid_compo"); 
        condWhere.append(" and oid_estruc in (select oid_estruc from cgEstrucCompo where oid_compo="+oidCompo+") ");
    }

    if (mapDatos.containsKey("RESTRINGIR_CUENTAS")) {
    	
    	// Si es ingresos varios
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("ING_VAR")) {
    		MotivoComprobante motivoComprobante = 
    			MotivoComprobante.findByOidProxy(mapDatos.getInteger("oid_motivo_recibo"),this.getSesion());
    		condWhere.append(" and oid_ana_con in (select oid_ana_con from cgAnaImpCon where oid_ai in ("+DBCuentaImputable.getRestCuentasParaIngVarios(motivoComprobante,this.getSesion())+")) ");  
    	}
    	
    	// Si es ingresos varios
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("OP_VARIAS")) {
    		MotivoPago motivoPago = 
    			MotivoPago.findByOidProxy(mapDatos.getInteger("oid_motivo_op"),this.getSesion());
    		condWhere.append(" and oid_ana_con in (select oid_ana_con from opCtasHabMotPagVar where oid_motivo_pago = "+motivoPago.getOIDInteger()+" ) ");  
    	}
    	
    	// Restringir al Modulo de Bancos
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("MODULO_BANCOS")) {
    		condWhere.append(" and oid_ana_con in (select oid_ana_con from cgAnaImpCon where oid_ai in ( ");
        Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
        Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
        Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
        condWhere.append(" select ");
        condWhere.append("    oid_ai ");
        condWhere.append("  from vaCtasHabBancos a ");
        condWhere.append("  where ");
        condWhere.append("  a.activo=1 and a.oid_uni_org in ");        
        condWhere.append("  (select oid_uni_org from seUniOrgHabUsu where oid_empresa="+oidEmpresa+" and oid_sucursal="+oidSucursal+" and oid_usuario="+oidUsuario+"))) ");
    	}
    	
    	
    	// Si es Rendicion de Fondo Fijo
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("REND_FONDO_FIJO")) {
    		condWhere.append(" and oid_ana_con in ( ");
        Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
        Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
        Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
        condWhere.append(" select ");
        condWhere.append("    oid_ana_con ");
        condWhere.append("  from opUniOrgFFCta a,opUniOrgFF b ");
        condWhere.append("  where ");
        condWhere.append("  a.oid_uni_org_ff = b.oid_uni_org_ff  ");
        condWhere.append("  and b.activo=1 and a.activo=1 and b.oid_uni_org in ");        
        condWhere.append("  (select oid_uni_org from seUniOrgHabUsu where oid_empresa="+oidEmpresa+" and oid_sucursal="+oidSucursal+" and oid_usuario="+oidUsuario+")) ");
    	}
    	
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("REND_FONDO_FIJO_Y_CONC_FACT_PROV")) {
    		condWhere.append(" and (oid_ana_con in ( ");
        Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
        Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
        Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
        condWhere.append(" select ");
        condWhere.append("    oid_ana_con ");
        condWhere.append("  from opUniOrgFFCta a,opUniOrgFF b ");
        condWhere.append("  where ");
        condWhere.append("  a.oid_uni_org_ff = b.oid_uni_org_ff  ");
        condWhere.append("  and b.activo=1 and a.activo=1 and b.oid_uni_org in ");        
        condWhere.append("  (select oid_uni_org from seUniOrgHabUsu where oid_empresa="+oidEmpresa+" and oid_sucursal="+oidSucursal+" and oid_usuario="+oidUsuario+")) ");
        condWhere.append("  OR ");
		Integer oidConcepto = mapDatos.getInteger("oid_concepto");
		condWhere.append("  oid_ana_con in ( ");
		condWhere.append(" select ");
		condWhere.append("    oid_ana_con ");
		condWhere.append("  from cpCtasConcFactProv a ");
		condWhere.append("    where ");
		condWhere.append("  a.oid_conc_fact_prov = "+oidConcepto.toString()+")) ");        
    	}
    	
    	
    	// Si es Rendicion de Fondo Fijo
    	if (mapDatos.getString("RESTRINGIR_CUENTAS").equals("CONC_COMPRO_PROV")) {
    		Integer oidConcepto = mapDatos.getInteger("oid_concepto");
    		condWhere.append(" and oid_ana_con in ( ");
        //Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
        //Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
        //Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
        condWhere.append(" select ");
        condWhere.append("    oid_ana_con ");
        condWhere.append("  from cpCtasConcFactProv a ");
        condWhere.append("    where ");
        condWhere.append("  a.oid_conc_fact_prov = "+oidConcepto.toString()+")");
    	}
    	
    	
    	
    }
    
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgAnaCon Where activo=1 ");
    if (condWhere.length()>0)
      textSQL.append(condWhere.toString());

    PreparedStatement querySelect =
        getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;

  }
  
  

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO = 1;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgAnaCon ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgAnaCon ");
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }

  private PreparedStatement selectByCodigoConCompo(Object aCondiciones) throws BaseException, SQLException {
	    final int CODIGO = 1;
	    final int OID_COMPO = 2;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgAnaCon ");
	    textSQL.append(" WHERE codigo = ? and oid_estruc IN (select oid_estruc from cgEstrucCompo where oid_compo=?) ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    String codigo =  condiciones.getString("codigo");
	    Integer oidCompo = condiciones.getInteger("oid_compo");
	    querySelect.setString(CODIGO, codigo);
	    querySelect.setInt(OID_COMPO, oidCompo);
	    return querySelect;
  }
  

  private PreparedStatement selectAllHelpConCompo(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_ana_con oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cgAnaCon where 1=1 ");
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    if (condiciones.containsKey("oid_compo")) {
	    	Integer oidCompo = condiciones.getInteger("oid_compo"); 
	    	textSQL.append(" and oid_estruc in (select oid_estruc from cgEstrucCompo where oid_compo="+oidCompo+") ");
	    }	    

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	  }
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ana_con oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cgAnaCon");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCuentas(String codigoDesde,
                                String codigoHasta,
                                ISesion aSesion) throws BaseException {
    HashTableDatos hs = new HashTableDatos();
    hs.put("codigo_desde",codigoDesde);
    hs.put("codigo_hasta",codigoHasta);
    return (List) ObjetoLogico.getObjects(Cuenta.NICKNAME,
                                          SELECT_BY_RANGO_CUENTAS,
                                          hs,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getHelpCuentas(MapDatos mapaDatos,
                                    ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Cuenta.NICKNAME,
                                          SELECT_HELP_CUENTAS,
                                          mapaDatos,
                                          new ListObserver(),
                                          aSesion);

  }
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Cuenta.NICKNAME,
                SELECT_ALL_ACTIVOS,
                null,
                new ListObserver(),
                aSesion);

  }
  



}
