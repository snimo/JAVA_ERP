package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorCompoReal extends DBObjetoPersistente {

  public static final String OID_VALOR_REAL = "oid_valor_real";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String ACTIVO = "activo";
  public static final String OID_VALOR_COMPO = "oid_valor_compo";
  
  public static final int SELECT_BY_COMPO_PRESU = 100;
  public static final int SELECT_BY_COMPO_PRESU_COD_DESC = 101;
  public static final int SELECT_BY_COMPO_PRESU_CODIGO = 102;

  public DBValorCompoReal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VALOR_REAL = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_COMPO_PRESU = 4;
    final int ACTIVO = 5;
    final int OID_VALOR_COMPO = 6;

    ValorCompoReal pers = (ValorCompoReal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plValorCompoReal "+
                     " ( "+
                      "OID_VALOR_REAL,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_COMPO_PRESU,"+
                      "ACTIVO,OID_VALOR_COMPO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VALOR_REAL,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorCompoPresu()!=null)
    	qInsert.setInt(OID_VALOR_COMPO, pers.getValorCompoPresu().getOID());
    else
    	qInsert.setNull(OID_VALOR_COMPO, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_COMPO_PRESU = 3;
    final int ACTIVO = 4;
    final int OID_VALOR_COMPO = 5;
    final int OID_VALOR_REAL = 6;

    ValorCompoReal pers = (ValorCompoReal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plValorCompoReal set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_compo_presu=?"+ 
              ",activo=?"+
              ",oid_valor_compo=?"+
                 " where " +
                 " oid_valor_real=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_REAL,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorCompoPresu()!=null)
    	qUpdate.setInt(OID_VALOR_COMPO, pers.getValorCompoPresu().getOID());
    else
    	qUpdate.setNull(OID_VALOR_COMPO, Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VALOR_REAL = 1; 
    ValorCompoReal pers = (ValorCompoReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from plValorCompoReal "+
                     " where " + 
                     " oid_valor_real=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_REAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VALOR_REAL = 1; 
    ValorCompoReal pers = (ValorCompoReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValorCompoReal "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_valor_real=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_REAL, pers.getOID()); 
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
      case SELECT_BY_COMPO_PRESU: {
        ps = this.selectByCompoPresu(aCondiciones); 
        break; 
      }
      case SELECT_BY_COMPO_PRESU_COD_DESC: {
        ps = this.selectByCompoPresuCodigoDesc(aCondiciones); 
        break; 
      }
      case SELECT_BY_COMPO_PRESU_CODIGO: {
        ps = this.selectByCompoPresuCodigo(aCondiciones); 
        break; 
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VALOR_REAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorCompoReal "); 
    textSQL.append(" WHERE oid_valor_real = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VALOR_REAL, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCompoPresu(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorCompoReal "); 
  	textSQL.append(" WHERE oid_compo_presu = ? ");
  	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  	CompoPresupuestario compoPresu = (CompoPresupuestario) aCondiciones;
  	querySelect.setInt(1, compoPresu.getOID()); 
  	return querySelect; 
  }
  
  
  private PreparedStatement selectByCompoPresuCodigo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorCompoReal "); 
  	textSQL.append(" WHERE oid_compo_presu = ? and codigo = ? ");
  	
  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	CompoPresupuestario compoPresu = (CompoPresupuestario) condiciones.get(CompoPresupuestario.NICKNAME);
  	String codigo = (String)condiciones.get("codigo");
  	
  	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  	querySelect.setInt(1, compoPresu.getOID());
  	querySelect.setString(2, codigo);
  	return querySelect; 
  }
  
  		
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorCompoReal "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_valor_real oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plValorCompoReal");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCompoPresuCodigoDesc(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorCompoReal "); 
    textSQL.append(" WHERE codigo oid_compo_presu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    CompoPresupuestario compoPresu = (CompoPresupuestario) condiciones.get(CompoPresupuestario.NICKNAME);
    querySelect.setInt(1, compoPresu.getOID());
    
    if (condiciones.contains("codigo"))
    	textSQL.append(" codigo like '%"+ (String) condiciones.get("codigo")+"%' ");
    
    if (condiciones.contains("descripcion"))
    	textSQL.append(" descripcion like '%"+ (String) condiciones.get("descripcion")+"%' ");
    
    return querySelect; 
  }
  
  
  public static List getValoresComponentesRealesByCompoPresu(CompoPresupuestario compoPresu,
  		                                                       ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ValorCompoReal.NICKNAME,
         DBValorCompoReal.SELECT_BY_COMPO_PRESU,
         compoPresu,
         new ListObserver(),
         aSesion);
  }
  
  public static List getValoresComponentesRealesByCompoPresuCodDesc(CompoPresupuestario compoPresu,
  																																  String codigo,
  																																  String descripcion,
      ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(CompoPresupuestario.NICKNAME,compoPresu);
  	
  	if (codigo!=null)
  		condiciones.put("codigo",codigo);
  	if (descripcion!=null)
  		condiciones.put("descripcion",codigo);
  	
  	return (List) ObjetoLogico.getObjects(ValorCompoReal.NICKNAME,
  			DBValorCompoReal.SELECT_BY_COMPO_PRESU,
  			compoPresu,
  			new ListObserver(),
  			aSesion);
  }
  
  public static ValorCompoReal getPeriodoValorRealByCodigo(CompoPresupuestario compoPresu,
  																												 String codigo,
  																												 ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(CompoPresupuestario.NICKNAME, compoPresu);
  	condiciones.put("codigo",codigo);
  	
  	return (ValorCompoReal) ObjetoLogico.getObjects(ValorCompoReal.NICKNAME,
	  				DBValorCompoReal.SELECT_BY_COMPO_PRESU_CODIGO,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
} 
