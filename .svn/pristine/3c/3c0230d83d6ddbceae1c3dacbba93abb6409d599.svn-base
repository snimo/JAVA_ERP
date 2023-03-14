package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverComponenteCta;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Redondear;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBComproContaDet extends DBObjetoPersistente {

  public static final String OID_DCO = "oid_dco";
  public static final String OID_CCO = "oid_cco";
  public static final String SECU = "secu";
  public static final String SIGNO = "signo";
  public static final String OID_AI = "oid_ai";
  public static final String OID_MONEDA_ORI = "oid_moneda_ori";
  public static final String CANTIDAD = "cantidad";
  public static final String IMPO_ORI = "impo_ori";
  public static final String COMENTARIO = "comentario";
  public static final String OID_MAY_DIA = "oid_may_dia";
  public static final String OID_MAY_PERI = "oid_may_peri";
  public static final String IMPO_LOC_HIST = "impo_loc_his";
  public static final String IMPO_LOC_AJU = "impo_loc_aju";
  public static final String IMPOMONEXT1 = "impo_Mon_Ext_1";
  public static final String IMPOMONEXT2 = "impo_Mon_Ext_2";
  public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT_1 = "cotiz_mon_ext_1";
  public static final String COTIZ_MON_EXT_2 = "cotiz_mon_ext_2";
  public static final String NRO_ASIENTO = "nro_asiento";

  public static final int SELECT_ITEMS_BY_COMPROCONTA = 100;
  public static final int SELECT_BY_CONDICIONES = 101;
  public static final int SELECT_BY_DRIVER = 102;
  public static final int SELECT_BY_CUENTAS_COMPONENTES  =103;
  public static final int SELECT_BY_EJERCICIO  =104;
  public static final int SELECT_BY_EJERCICIO_ORDER_FEC_OIDCCO  =105;
  public static final int SELECT_BY_FEC_DES_HAS_ORDER_NRO_ASI  =106;
  public static final int SELECT_BY_MAYOR_A_OID  =107;
  

  public DBComproContaDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_DCO = 1;
    final int OID_CCO = 2;
    final int SECU = 3;
    final int SIGNO = 4;
    final int OID_AI = 5;
    final int OID_MONEDA_ORI = 6;
    final int CANTIDAD = 7;
    final int IMPO_ORI = 8;
    final int COMENTARIO = 9;
    final int OID_MAY_DIA = 10;
    final int OID_MAY_PERI = 11;
    final int IMPO_LOC_HIST = 12;
    final int IMPO_LOC_AJU = 13;
    final int IMPOMONEXT1 = 14;
    final int IMPOMONEXT2 = 15;
    final int COTIZ_MON_ORI = 16;
    final int COTIZ_MON_EXT_1 = 17;
    final int COTIZ_MON_EXT_2 = 18;
    final int NRO_ASIENTO = 19;

    ComproContaDet pers = (ComproContaDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproContaDet "+
                     " ( "+
                      "OID_DCO,"+
                      "OID_CCO,"+
                      "SECU,"+
                      "SIGNO,"+
                      "OID_AI,"+
                      "OID_MONEDA_ORI,"+
                      "CANTIDAD,"+
                      "IMPO_ORI,"+
                      "COMENTARIO,"+
                      "OID_MAY_DIA,"+
                      "OID_MAY_PERI,"+
                      "IMPO_LOC_HIS,"+
                      "IMPO_LOC_AJU,"+
                      "IMPO_MON_EXT_1,"+
                      "IMPO_MON_EXT_2,"+
                      "COTIZ_MON_ORI,"+
                      "COTIZ_MON_EXT_1,"+
                      "COTIZ_MON_EXT_2,"+
                      "NRO_ASIENTO"+
                      ")"+
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
    qInsert.setInt(OID_DCO,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setInt(OID_AI,pers.getCuentaImputable().getOID());
    if (pers.getMoneda()!=null)
    	qInsert.setInt(OID_MONEDA_ORI,pers.getMoneda().getOID());
    else
    	qInsert.setNull(OID_MONEDA_ORI,java.sql.Types.INTEGER);
    qInsert.setInt(CANTIDAD,pers.getCantidad().intValue());
    if (pers.getImporteOriginal()!=null)
    	qInsert.setDouble(IMPO_ORI,pers.getImporteOriginal().doubleValue());
    else
    	qInsert.setDouble(IMPO_ORI,0);
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO,pers.getComentario());
    else
    	qInsert.setString(COMENTARIO,"");
    if (pers.getMayorDia()!=null)
      qInsert.setInt(OID_MAY_DIA,pers.getMayorDia().getOID());
    else
      qInsert.setNull(OID_MAY_DIA,java.sql.Types.INTEGER);
    if (pers.getMayorPeri()!=null)
      qInsert.setInt(OID_MAY_PERI,pers.getMayorPeri().getOID());
    else
      qInsert.setNull(OID_MAY_PERI,java.sql.Types.INTEGER);

    qInsert.setDouble(IMPO_LOC_HIST,Redondear.round(pers.getImpoLocHist().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPO_LOC_AJU,Redondear.round(pers.getImpoLocAju().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPOMONEXT1,Redondear.round(pers.getImpoMonExt1().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPOMONEXT2,Redondear.round(pers.getImpoMonExt2().doubleValue(),2).doubleValue());
    if (pers.getCotizMonOri()!=null)
    	qInsert.setDouble(COTIZ_MON_ORI,Redondear.round(pers.getCotizMonOri().doubleValue(),8).doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_ORI,0);
    if (pers.getCotizMonExt1()!=null)
    	qInsert.setDouble(COTIZ_MON_EXT_1,Redondear.round(pers.getCotizMonExt1().doubleValue(),8).doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_EXT_1,0);
    if (pers.getCotizMonExt2()!=null)
    	qInsert.setDouble(COTIZ_MON_EXT_2,Redondear.round(pers.getCotizMonExt2().doubleValue(),8).doubleValue());
    else
    	qInsert.setDouble(COTIZ_MON_EXT_2,0);
    if (pers.getNroAsiento()!=null)
    	qInsert.setInt(NRO_ASIENTO,pers.getNroAsiento().intValue());
    else
    	qInsert.setNull(NRO_ASIENTO,java.sql.Types.INTEGER);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int SECU = 2;
    final int SIGNO = 3;
    final int OID_AI = 4;
    final int OID_MONEDA_ORI = 5;
    final int CANTIDAD = 6;
    final int IMPO_ORI = 7;
    final int COMENTARIO = 8;
    final int OID_MAY_DIA = 9;
    final int OID_MAY_PERI = 10;
    final int IMPO_LOC_HIST = 11;
    final int IMPO_LOC_AJU = 12;
    final int IMPOMONEXT1 = 13;
    final int IMPOMONEXT2 = 14;
    final int NRO_ASIENTO = 15;
    final int OID_DCO = 16;

    ComproContaDet pers = (ComproContaDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproContaDet set "+
              "oid_cco=?"+
              ",secu=?"+
              ",signo=?"+
              ",oid_ai=?"+
              ",oid_moneda_ori=?"+
              ",cantidad=?"+
              ",impo_ori=?"+
              ",comentario=?"+
              ",oid_may_dia=?"+
              ",oid_may_peri=?"+
              ",impo_loc_his=?"+
              ",impo_loc_aju=?"+
              ",impo_Mon_Ext_1=?"+
              ",impo_Mon_Ext_2=?"+
              ",nro_asiento=?"+
                 " where " +
                 " oid_dco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(SIGNO,pers.getSigno().intValue());
    qUpdate.setInt(OID_AI,pers.getCuentaImputable().getOID());
    if (pers.getMoneda()!=null)
    	qUpdate.setInt(OID_MONEDA_ORI,pers.getMoneda().getOID());
    else
    	qUpdate.setNull(OID_MONEDA_ORI,java.sql.Types.INTEGER);
    
    qUpdate.setInt(CANTIDAD,pers.getCantidad().intValue());
    if (pers.getImporteOriginal()!=null)
    	qUpdate.setDouble(IMPO_ORI,pers.getImporteOriginal().doubleValue());
    else
    	qUpdate.setDouble(IMPO_ORI,0);
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO,pers.getComentario());
    else
    	qUpdate.setString(COMENTARIO,"");
    
    if (pers.getMayorDia()!=null)
    	qUpdate.setInt(OID_MAY_DIA,pers.getMayorDia().getOID());
    else
    	qUpdate.setNull(OID_MAY_DIA,java.sql.Types.INTEGER);
    
    if (pers.getMayorPeri()!=null)
    	  qUpdate.setInt(OID_MAY_PERI,pers.getMayorPeri().getOID());
      else
    	  qUpdate.setNull(OID_MAY_PERI,java.sql.Types.INTEGER);
    
    	
    	
    qUpdate.setDouble(IMPO_LOC_HIST,Redondear.round(pers.getImpoLocHist().doubleValue(),2).doubleValue());
    qUpdate.setDouble(IMPO_LOC_AJU,Redondear.round(pers.getImpoLocAju().doubleValue(),2).doubleValue());
    qUpdate.setDouble(IMPOMONEXT1,Redondear.round(pers.getImpoMonExt1().doubleValue(),2).doubleValue());
    qUpdate.setDouble(IMPOMONEXT2,Redondear.round(pers.getImpoMonExt2().doubleValue(),2).doubleValue());
    if (pers.getNroAsiento()!=null)
    	qUpdate.setInt(NRO_ASIENTO,pers.getNroAsiento().intValue());
    else
    	qUpdate.setNull(NRO_ASIENTO,java.sql.Types.INTEGER);    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DCO = 1;
    ComproContaDet pers = (ComproContaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgComproContaDet "+
                     " where " +
                     " oid_dco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DCO = 1;
    ComproContaDet pers = (ComproContaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproContaDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_dco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO, pers.getOID());
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
      case SELECT_ITEMS_BY_COMPROCONTA: {
        ps = this.selecItemsByComproConta(aCondiciones);
        break;
      }
      case SELECT_BY_CONDICIONES: {
        ps = this.selectByCondiciones(aCondiciones);
        break;
      }
      case SELECT_BY_DRIVER: {
          ps = this.selectByDriver(aCondiciones);
          break;
      }   
      case SELECT_BY_CUENTAS_COMPONENTES: {
          ps = this.selectByCuentasComponentes(aCondiciones);
          break;
      }
      case SELECT_BY_EJERCICIO: {
    	  ps = this.selectByEjercicio(aCondiciones);
          break;    	  
      }
      case SELECT_BY_EJERCICIO_ORDER_FEC_OIDCCO: {
    	  ps = this.selectByEjercicioOrderByFechaOidCCO(aCondiciones);
          break;    	  
      }
      case SELECT_BY_FEC_DES_HAS_ORDER_NRO_ASI: {
    	  ps = this.selectByFecDesdeHastaOrderByNroAsi(aCondiciones);
          break;    	  
      }
      case SELECT_ALL: {
    	  ps = this.selectAll(aCondiciones);
          break;    	  
      }
      case SELECT_BY_MAYOR_A_OID: {
    	  ps = this.selectByMayorAOID(aCondiciones);
          break;    	  
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_DCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproContaDet ");
    textSQL.append(" WHERE oid_dco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_DCO, oid);
    return querySelect;
  }
  
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgComproContaDet ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  private PreparedStatement selectByMayorAOID(Object aCondiciones) throws BaseException, SQLException {
	    Integer oid = (Integer) aCondiciones;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgComproContaDet where oid_dco>"+oid+" order by oid_dco ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
	  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproContaDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer();
	textSQL.append("SELECT a.* FROM  cgComproContaDet a, cgComproConta b where a.oid_cco=b.oid_cco ");
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	if (condiciones.containsKey(Cuenta.NICKNAME)) {
  	  Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
  	  textSQL.append(" and a.oid_ai in (select oid_ai from cgAnaImpcon where oid_ana_con ="+cuenta.getOIDInteger().toString()+") ");
	}
	if (condiciones.containsKey("DEBITO")) 
	  textSQL.append(" and a.signo=1 ");
	if (condiciones.containsKey("CREDITO")) 
	  textSQL.append(" and a.signo=-1 ");
	if (condiciones.containsKey("FEC_DESDE"))
		textSQL.append(" and b.imputac>=? ");
	if (condiciones.containsKey("FEC_HASTA"))
		textSQL.append(" and b.imputac<=? ");	
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	int nroParam = 0;
	if (condiciones.containsKey("FEC_DESDE")) {
		++nroParam;
		Date fecha = (java.util.Date)condiciones.get("FEC_DESDE"); 
		querySelect.setDate(nroParam,new java.sql.Date(fecha.getTime()));
	}
	if (condiciones.containsKey("FEC_HASTA")) {
		++nroParam;
		Date fecha = (java.util.Date)condiciones.get("FEC_HASTA");
		querySelect.setDate(nroParam,new java.sql.Date(fecha.getTime()));
	}	
	return querySelect;	  
  }
  
  private PreparedStatement selectByFecDesdeHastaOrderByNroAsi(Object aCondiciones) throws BaseException, SQLException {
	    
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    
	    StringBuffer textSQL = new StringBuffer();
	    
	    textSQL.append(" select ");
	    textSQL.append("   b.*,a.imputac ");
	    textSQL.append(" from ");
	    textSQL.append("   cgComproConta a, ");
	    textSQL.append("   cgComproContaDet b ");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco and a.imputac>=? and a.imputac<=? ");
	    textSQL.append(" order by b.nro_asiento,a.imputac");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    
	    return querySelect;
	    
  }
  
  
  
  
  private PreparedStatement selectByEjercicioOrderByFechaOidCCO(Object aCondiciones) throws BaseException, SQLException {
	    
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Ejercicio ejercicio = (Ejercicio) condiciones.get(Ejercicio.NICKNAME);
	    
	    StringBuffer textSQL = new StringBuffer();
	    
	    textSQL.append(" select ");
	    textSQL.append("   b.*,a.imputac ");
	    textSQL.append(" from ");
	    textSQL.append("   cgComproConta a, ");
	    textSQL.append("   cgComproContaDet b ");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco and a.oid_peri in ( ");
	    textSQL.append(" select "); 
	    textSQL.append("   c1.oid_peri "); 
	    textSQL.append(" from "); 
	    textSQL.append("    cgEjercicio b1, ");
	    textSQL.append("    cgEjercicioPeri c1 ");
	    textSQL.append("    where b1.oid_ejercicio = c1.oid_ejercicio and b1.oid_ejercicio = ? ) order by a.imputac, b.oid_cco  , b.secu ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, ejercicio.getOID());
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByEjercicio(Object aCondiciones) throws BaseException, SQLException {
	    
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Ejercicio ejercicio = (Ejercicio) condiciones.get(Ejercicio.NICKNAME);
	    
	    boolean esResultado = false;
	    boolean esPatrimonial = false;
	    
	    if (condiciones.containsKey("PATRIMONIAL"))
	    	esPatrimonial = true;
	    else if (condiciones.containsKey("RESULTADO"))
	    		esResultado = true;
	    
	    StringBuffer textSQL = new StringBuffer();
	    
	    textSQL.append(" select ");
	    textSQL.append(" b.* ");
	    textSQL.append(" from ");
	    textSQL.append("   cgComproConta a, ");
	    textSQL.append("   cgComproContaDet b, ");
	    textSQL.append("   cgAnaImpCon c, ");
	    textSQL.append("   cgAnaCon d "); 
	    textSQL.append(" where ");
	    textSQL.append("   b.oid_ai = c.oid_ai ");
	    if (esResultado)
	    	textSQL.append("   and d.es_patrimonial = 0 ");
	    else if (esPatrimonial)
	    	textSQL.append("   and d.es_patrimonial = 1 ");
	    textSQL.append("   and c.oid_ana_con = d.oid_ana_con and ");
	    textSQL.append("   a.oid_cco = b.oid_cco and a.oid_peri in ( ");
	    textSQL.append(" select "); 
	    textSQL.append("   c1.oid_peri "); 
	    textSQL.append(" from "); 
	    textSQL.append("    cgEjercicio b1, ");
	    textSQL.append("    cgEjercicioPeri c1 ");
	    textSQL.append("    where b1.oid_ejercicio = c1.oid_ejercicio and b1.oid_ejercicio = ? )");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, ejercicio.getOID());
	    return querySelect;
	    
  }
  
  
  
  

  private PreparedStatement selecItemsByComproConta(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproContaDet ");
    textSQL.append(" WHERE  oid_cco = ? order by secu ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproConta comproConta = (ComproConta) aCondiciones;
    querySelect.setInt(1, comproConta.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproContaDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getDetallesByComproConta(ComproConta comproConta,
                                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                                          DBComproContaDet.SELECT_ITEMS_BY_COMPROCONTA,
                                          comproConta,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getDetallesByEjercicio(Ejercicio ejercicio,
		  boolean patrimoniales,boolean resultado,
          ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Ejercicio.NICKNAME, ejercicio);
	  if (patrimoniales)
		  condiciones.put("PATRIMONIAL", "");
	  if (resultado)
		  condiciones.put("RESULTADO", "");	  
	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
			  DBComproContaDet.SELECT_BY_EJERCICIO,
			  condiciones,
			  new ListObserver(),
			  aSesion);
	  
  }
  

  public static List getDetallesByComproConta(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
      DBComproContaDet.SELECT_BY_CONDICIONES,
      condiciones,
      new ListObserver(),
      aSesion);
  }
  
  public static List getImputacionesByDriverSubReparto(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  DriverSubreparto driver,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  condiciones.put(DriverSubreparto.NICKNAME, driver);
	  
	  
	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
             DBComproContaDet.SELECT_BY_DRIVER,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  private PreparedStatement selectByDriver(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date)condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date)condiciones.get("FECHA_HASTA");
	    DriverSubreparto driverSubReparto = (DriverSubreparto) condiciones.get(DriverSubreparto.NICKNAME);

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgComproContaDet a , cgAnaImpCon b , cgComproConta c ");
	    textSQL.append(" WHERE ");
	    textSQL.append(" a.oid_cco = c.oid_cco  ");
	    textSQL.append(" and a.oid_ai = b.oid_ai ");
	    textSQL.append(" and c.imputac >= ? and c.imputac<=? ");
	    
	    // Filtrar para el conjunto de cuentas especificado
	    boolean primerCuenta = true;
	    if (driverSubReparto.isCuentas()) {
	    	Iterator iterDriverCuentas =
	    		driverSubReparto.getDriversCuentas().iterator();
	    	while (iterDriverCuentas.hasNext()) {
	    		
	    		if (primerCuenta) {
	    			primerCuenta = false;
	    			textSQL.append("  and ( ");
	    		} else
	    			textSQL.append("  or ");
	    		
	    		textSQL.append("  ( ");
	    		DriverCuentaSubreparto driverCuenta = (DriverCuentaSubreparto) iterDriverCuentas.next();
	    		textSQL.append("  b.oid_ana_con ="+driverCuenta.getCuenta().getOIDInteger()+" ");
	    		
	    		Iterator iterCompoCtas = 
	    			driverCuenta.getComponentesCuentaDriver().iterator();
	    		while (iterCompoCtas.hasNext()) {
	    			DriverCuentaComponente driverCtaCompo = (DriverCuentaComponente) iterCompoCtas.next();
	    			textSQL.append(" and b."+driverCtaCompo.getComponente().getCampoFisicoAnaImp()+"="+driverCtaCompo.getValor_componente().getOIDInteger());
	    		}
	    		textSQL.append("  ) ");
	    		
	    		if (iterDriverCuentas.hasNext()==false) {
	    			textSQL.append("  ) ");
	    		}
	    	}
	    }
	    
	    if (driverSubReparto.isComponentes()) {
	    	
	    	primerCuenta = true;
	    	Iterator iterDriverComponentes = 
	    		driverSubReparto.getDriversComponentes().iterator();
	    	while (iterDriverComponentes.hasNext()) {
	    		
	    		if (primerCuenta) {
	    			primerCuenta = false;
	    			textSQL.append("  and ( ");
	    		} else
	    			textSQL.append("  or ");
	    		
	    		
	    		DriverComponente driverComponente = (DriverComponente) iterDriverComponentes.next();
	    		textSQL.append(" ( ");
	    		textSQL.append("  b."+driverSubReparto.getComponente().getCampoFisicoAnaImp()+"="+driverComponente.getValor_compo().getOIDInteger());
	    		
	    		StringBuffer condCtasIN = new StringBuffer("");
	    		Iterator iterCuentasCompo =
	    			driverComponente.getCuentasCompo().iterator();
	    		while (iterCuentasCompo.hasNext()) {
	    			DriverComponenteCta driverCompoCta = (DriverComponenteCta) iterCuentasCompo.next();
	    			condCtasIN.append(","+driverCompoCta.getCuenta().getOIDInteger());
	    		}
	    		
	    		if (condCtasIN.length()>0) {
	    	    	textSQL.append(" and b.oid_ana_con in (-1");
	    	    	textSQL.append(condCtasIN.toString());
	    	    	textSQL.append(") ");
	    		}
	    		textSQL.append(" ) ");
	    		
	    		if (iterDriverComponentes.hasNext()==false) 
	    			textSQL.append("  ) ");
	    	}
	    	
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect;
 }
  
  
  
  private PreparedStatement selectByCuentasComponentes(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date)condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date)condiciones.get("FECHA_HASTA");
	    List listaCuentas = (List) condiciones.get("LISTA_CUENTAS");
	    HashTableDatos listaValoresComponentes = (HashTableDatos) condiciones.get("LISTA_VALORES_COMPO");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgComproContaDet a , cgAnaImpCon b  , cgComproConta c ");
	    textSQL.append(" WHERE ");
	    textSQL.append(" a.oid_cco = c.oid_cco ");
	    textSQL.append(" and a.oid_ai = b.oid_ai ");
	    textSQL.append(" and c.imputac >= ? and c.imputac<=? ");
	    
	    // Filtrar para el conjunto de cuentas especificado
	    if (listaCuentas!=null) {
	    	StringBuffer CondINCtas = new StringBuffer("");
	    	Iterator iterCuentas =
	    		listaCuentas.iterator();
	    	while (iterCuentas.hasNext()) {
	    		Cuenta cuenta = (Cuenta) iterCuentas.next();
	    		CondINCtas.append(","+cuenta.getOIDInteger());
	    	}
	    	if (CondINCtas.length()>0) {
	    		textSQL.append(" and b.oid_ana_con in (-1");
	    		textSQL.append(CondINCtas.toString());
	    		textSQL.append(") ");
	    	}
	    }
	    
	    // Filtrar a los valores de Componentes Correspondientes
	    if (listaValoresComponentes!=null) {
	    	Iterator iterComponentes = 
	    		listaValoresComponentes.keySet().iterator();
	    	while (iterComponentes.hasNext()) {
	    		StringBuffer valoresComponenteCondIN = new StringBuffer("");
	    		Componente componente = (Componente) iterComponentes.next();
	    		List listaValoresCompo = (List) listaValoresComponentes.get(componente);
	    		Iterator iterValoresCompo = listaValoresCompo.iterator();
	    		while (iterValoresCompo.hasNext()) {
	    			IObjetoLogico objLog = (IObjetoLogico) iterValoresCompo.next();
	    			valoresComponenteCondIN.append(","+objLog.getOIDInteger());
	    		}
	    		if (valoresComponenteCondIN.length()>0) {
	    			textSQL.append(" and b."+componente.getCampoFisicoAnaImp()+" in ");
	    			textSQL.append("(-1");
	    			textSQL.append(valoresComponenteCondIN.toString());
	    			textSQL.append(") ");
	    		}
	    	}
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect;
  }
  
  public static List getImputacionesByCuentasValoresCompo(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  List listaCuentas,
		  HashTableDatos listaValoresCompo,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  condiciones.put("LISTA_CUENTAS", listaCuentas);
	  condiciones.put("LISTA_VALORES_COMPO",listaValoresCompo);

	    return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                DBComproContaDet.SELECT_BY_CUENTAS_COMPONENTES,
                condiciones,
                new ListObserver(),
                aSesion);
  }
  
  public static List getImpuEjercicioOrderFecOIDCCO(
		  Ejercicio ejercicio,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Ejercicio.NICKNAME, ejercicio);

	    return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                DBComproContaDet.SELECT_BY_EJERCICIO_ORDER_FEC_OIDCCO,
                condiciones,
                new ListObserver(),
                aSesion);
  }
  
  public static List getImpuFecDesdeHastaOrderByNroAsi(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);

	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                DBComproContaDet.SELECT_BY_FEC_DES_HAS_ORDER_NRO_ASI,
                condiciones,
                new ListObserver(),
                aSesion);
  }
  
  public static List getAllComproContaDet(ISesion aSesion) throws BaseException {
	  
	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                DBComproContaDet.SELECT_ALL,
                null,
                new ListObserver(),
                aSesion);
  }  
  
  public static List getAllComproContaDetHastaOID(ISesion aSesion,Integer OID) throws BaseException {
	  
	  return (List) ObjetoLogico.getObjects(ComproContaDet.NICKNAME,
                DBComproContaDet.SELECT_BY_MAYOR_A_OID,
                OID,
                new ListObserver(),
                aSesion);
  }  
  
  
  
  

}
