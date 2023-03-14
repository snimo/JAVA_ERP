package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConceptoLiqTarjeta extends DBObjetoPersistente {

  public static final String OID_CONC_LIQ_TC = "oid_conc_liq_tc";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String ACTIVO = "activo";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  
  public static final int SELECT_BY_CONCEPTOS_TAR_CREDITO = 100;
  public static final int SELECT_BY_CONCEPTOS_TAR_DEBITO = 101;

  public DBConceptoLiqTarjeta() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_LIQ_TC = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_ANA_CON = 4;
    final int COMPORTAMIENTO = 5;
    final int ACTIVO = 6;
    final int OID_TIPO_VALOR = 7;

    ConceptoLiqTarjeta pers = (ConceptoLiqTarjeta) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaConcLiqTC "+
                     " ( "+
                      "OID_CONC_LIQ_TC,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_ANA_CON,"+
                      "COMPORTAMIENTO,"+
                      "ACTIVO,OID_TIPO_VALOR)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONC_LIQ_TC,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getCuenta()!=null)
    	qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
    	qInsert.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTipoValor()!=null)
    	qInsert.setInt(OID_TIPO_VALOR, pers.getTipoValor().getOIDInteger());
    else
    	qInsert.setNull(OID_TIPO_VALOR, java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_ANA_CON = 3;
    final int COMPORTAMIENTO = 4;
    final int ACTIVO = 5;
    final int OID_TIPO_VALOR = 6;
    final int OID_CONC_LIQ_TC = 7;

    ConceptoLiqTarjeta pers = (ConceptoLiqTarjeta) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaConcLiqTC set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_ana_con=?"+ 
              ",comportamiento=?"+ 
              ",activo=?"+
              ",oid_tipo_valor=?"+ 
                 " where " +
                 " oid_conc_liq_tc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_LIQ_TC,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getCuenta()!=null)
    	qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
    	qUpdate.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTipoValor()!=null)
    	qUpdate.setInt(OID_TIPO_VALOR, pers.getTipoValor().getOIDInteger());
    else
    	qUpdate.setNull(OID_TIPO_VALOR, java.sql.Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_LIQ_TC = 1; 
    ConceptoLiqTarjeta pers = (ConceptoLiqTarjeta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConcLiqTC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conc_liq_tc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_LIQ_TC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_LIQ_TC = 1; 
    ConceptoLiqTarjeta pers = (ConceptoLiqTarjeta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConcLiqTC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_liq_tc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_LIQ_TC, pers.getOID()); 
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
      case SELECT_BY_CONCEPTOS_TAR_CREDITO: {
          ps = this.selectByConceptosTarCredito(aCondiciones); 
          break; 
      }
      case SELECT_BY_CONCEPTOS_TAR_DEBITO: {
          ps = this.selectByConceptosTarDebito(aCondiciones); 
          break; 
      }
      case SELECT_ALL_ACTIVOS: {
          ps = this.selectAllActivos(aCondiciones); 
          break; 
      }
      
      
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_LIQ_TC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConcLiqTC "); 
    textSQL.append(" WHERE oid_conc_liq_tc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_LIQ_TC, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByConceptosTarCredito(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConcLiqTC "); 
	    textSQL.append(" WHERE comportamiento='TAR_CRE' and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }

  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConcLiqTC where activo=1 "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }

  private PreparedStatement selectByConceptosTarDebito(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConcLiqTC "); 
	    textSQL.append(" WHERE comportamiento='TAR_DEB' and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConcLiqTC "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_liq_tc oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from vaConcLiqTC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConceptosTarjetasCredito(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConceptoLiqTarjeta.NICKNAME,
             DBConceptoLiqTarjeta.SELECT_BY_CONCEPTOS_TAR_CREDITO,
             null,
             new ListObserver(),
             aSesion);
  }
  
  public static List getConceptosTarjetasDebito(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConceptoLiqTarjeta.NICKNAME,
             DBConceptoLiqTarjeta.SELECT_BY_CONCEPTOS_TAR_DEBITO,
             null,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAllConceptosActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConceptoLiqTarjeta.NICKNAME,
             SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
