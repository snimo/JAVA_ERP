package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ConfConsGenStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConfConsGenStock extends DBObjetoPersistente {

  public static final String OID_CONF_CONS_STK = "oid_conf_cons_stk";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String TIPO_VALOR_FILA = "tipo_valor_fila";
  public static final String OID_CLASIF_ENT_AGRUP = "oid_clasif_ent_agrup";
  public static final String TOTALIZAR = "totalizar";
  public static final String OID_CLASIF_ENT_FILA = "oid_clasif_ent_fila";
  public static final String FIL_PROD_STK_COD = "fil_prod_stk_cod";
  public static final String FIL_PROD_STK_DES = "fil_prod_stk_des";
  public static final String CONSOLIDAR_STOCK = "consolidar_stock";
  public static final String VER_COL_TOT_FILA = "ver_col_tot_fila";
  
  

  public DBConfConsGenStock() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_CONS_STK = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int TIPO_VALOR_FILA = 5;
    final int OID_CLASIF_ENT_AGRUP = 6;
    final int TOTALIZAR = 7;
    final int OID_CLASIF_ENT_FILA = 8;
    final int FIL_PROD_STK_COD = 9;
    final int FIL_PROD_STK_DES = 10;
    final int CONSOLIDAR_STOCK = 11;
    final int VER_COL_TOT_FILA = 12;

    ConfConsGenStock pers = (ConfConsGenStock) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skConfConsStk "+
                     " ( "+
                      "OID_CONF_CONS_STK,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "TIPO_VALOR_FILA,"+
                      "OID_CLASIF_ENT_AGRUP,"+
                      "TOTALIZAR,"+
                      "OID_CLASIF_ENT_FILA,FIL_PROD_STK_COD,FIL_PROD_STK_DES,CONSOLIDAR_STOCK,VER_COL_TOT_FILA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONF_CONS_STK,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(TIPO_VALOR_FILA,pers.getTipo_valor_fila());
    if (pers.getClasif_ent_grupo()!=null) 
      qInsert.setInt(OID_CLASIF_ENT_AGRUP,pers.getClasif_ent_grupo().getOID());
    else
      qInsert.setNull(OID_CLASIF_ENT_AGRUP,java.sql.Types.INTEGER);
    qInsert.setBoolean(TOTALIZAR,pers.isTotalizar().booleanValue());
    if (pers.getClasif_ent_fila()!=null) 
      qInsert.setInt(OID_CLASIF_ENT_FILA,pers.getClasif_ent_fila().getOID());
    else
      qInsert.setNull(OID_CLASIF_ENT_FILA,java.sql.Types.INTEGER);
    if (pers.isFiltrarProdStockPorCodigo()!=null)
    	qInsert.setBoolean(FIL_PROD_STK_COD, pers.isFiltrarProdStockPorCodigo().booleanValue());
    else
    	qInsert.setBoolean(FIL_PROD_STK_COD, false);
    if (pers.isFiltrarProdStockPorDesc()!=null)
    	qInsert.setBoolean(FIL_PROD_STK_DES, pers.isFiltrarProdStockPorDesc().booleanValue());
    else
    	qInsert.setBoolean(FIL_PROD_STK_DES, false);
    if (pers.isConsolidarStock()!=null)
    	qInsert.setBoolean(CONSOLIDAR_STOCK, pers.isConsolidarStock().booleanValue());
    else
    	qInsert.setBoolean(CONSOLIDAR_STOCK, false);
    if (pers.isVerColTotFila()!=null)
    	qInsert.setBoolean(VER_COL_TOT_FILA, pers.isVerColTotFila().booleanValue());
    else
    	qInsert.setBoolean(VER_COL_TOT_FILA, false);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int TIPO_VALOR_FILA = 4;
    final int OID_CLASIF_ENT_AGRUP = 5;
    final int TOTALIZAR = 6;
    final int OID_CLASIF_ENT_FILA = 7;
    final int FIL_PROD_STK_COD = 8;
    final int FIL_PROD_STK_DES = 9;
    final int CONSOLIDAR_STOCK = 10;
    final int VER_COL_TOT_FILA = 11;
    final int OID_CONF_CONS_STK = 12;

    ConfConsGenStock pers = (ConfConsGenStock) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skConfConsStk set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",tipo_valor_fila=?"+ 
              ",oid_clasif_ent_agrup=?"+ 
              ",totalizar=?"+ 
              ",oid_clasif_ent_fila=?"+ 
              ",FIL_PROD_STK_COD=?"+
              ",FIL_PROD_STK_DES=?"+
              ",consolidar_stock=?"+
              ",ver_col_tot_fila=?"+
                 " where " +
                 " oid_conf_cons_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_CONS_STK,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO_VALOR_FILA,pers.getTipo_valor_fila());
    if (pers.getClasif_ent_grupo()!=null) 
      qUpdate.setInt(OID_CLASIF_ENT_AGRUP,pers.getClasif_ent_grupo().getOID());
    else
      qUpdate.setNull(OID_CLASIF_ENT_AGRUP,java.sql.Types.INTEGER);
    qUpdate.setBoolean(TOTALIZAR,pers.isTotalizar().booleanValue());
    if (pers.getClasif_ent_fila()!=null) 
      qUpdate.setInt(OID_CLASIF_ENT_FILA,pers.getClasif_ent_fila().getOID());
    else
      qUpdate.setNull(OID_CLASIF_ENT_FILA,java.sql.Types.INTEGER);
    if (pers.isFiltrarProdStockPorCodigo()!=null)
    	qUpdate.setBoolean(FIL_PROD_STK_COD, pers.isFiltrarProdStockPorCodigo().booleanValue());
    else
    	qUpdate.setBoolean(FIL_PROD_STK_COD, false);
    if (pers.isFiltrarProdStockPorDesc()!=null)
    	qUpdate.setBoolean(FIL_PROD_STK_DES, pers.isFiltrarProdStockPorDesc().booleanValue());
    else
    	qUpdate.setBoolean(FIL_PROD_STK_DES, false);
    if (pers.isConsolidarStock()!=null)
    	qUpdate.setBoolean(CONSOLIDAR_STOCK, pers.isConsolidarStock().booleanValue());
    else
    	qUpdate.setBoolean(CONSOLIDAR_STOCK, false);
    if (pers.isVerColTotFila()!=null)
    	qUpdate.setBoolean(VER_COL_TOT_FILA, pers.isVerColTotFila().booleanValue());
    else
    	qUpdate.setBoolean(VER_COL_TOT_FILA, false);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_CONS_STK = 1; 
    ConfConsGenStock pers = (ConfConsGenStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skConfConsStk "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conf_cons_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_CONS_STK, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_CONS_STK = 1; 
    ConfConsGenStock pers = (ConfConsGenStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skConfConsStk "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conf_cons_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_CONS_STK, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
          ps = this.selectAllActivos(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONF_CONS_STK = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skConfConsStk "); 
    textSQL.append(" WHERE oid_conf_cons_stk = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONF_CONS_STK, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skConfConsStk "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  skConfConsStk "); 
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect; 
  }
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conf_cons_stk oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from skConfConsStk");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllActivos(
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConfConsGenStock.NICKNAME,
             DBConfConsGenStock.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
