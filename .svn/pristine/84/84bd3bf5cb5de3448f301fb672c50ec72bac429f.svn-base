package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.stock.bm.ConfGenMasProd;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBConfGenMasProd extends DBObjetoPersistente {

  public static final String OID_GEN_MASIVA = "oid_gen_masiva";
  public static final String OID_CLASIFICADOR = "oid_clasificador";
  public static final String INCLUIR_CODIGO = "incluir_codigo";
  public static final String ORDEN_CODIGO = "orden_codigo";
  public static final String PRE_CODIGO = "pre_codigo";
  public static final String SUF_CODIGO = "suf_codigo";
  public static final String INCLUIR_DESC = "incluir_desc";
  public static final String ORDEN_DESC = "orden_desc";
  public static final String PRE_DESC = "pre_desc";
  public static final String SUF_DESC = "suf_desc";
  public static final String INCLUIR_SINO = "incluir_sino";
  public static final String ORDEN_SINO = "orden_sino";
  public static final String PRE_SINO = "pre_sino";
  public static final String SUF_SINO = "suf_sino";
  public static final String INCLUIR_BARRA = "incluir_barra";
  public static final String ORDEN_BARRA = "orden_barra";
  public static final String PRE_BARRA = "pre_barra";
  public static final String SUF_BARRA = "suf_barra";
  
  public static final int SELECT_BY_CLASIFICADOR = 100;

  public DBConfGenMasProd() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GEN_MASIVA = 1;
    final int OID_CLASIFICADOR = 2;
    final int INCLUIR_CODIGO = 3;
    final int ORDEN_CODIGO = 4;
    final int PRE_CODIGO = 5;
    final int SUF_CODIGO = 6;
    final int INCLUIR_DESC = 7;
    final int ORDEN_DESC = 8;
    final int PRE_DESC = 9;
    final int SUF_DESC = 10;
    final int INCLUIR_SINO = 11;
    final int ORDEN_SINO = 12;
    final int PRE_SINO = 13;
    final int SUF_SINO = 14;
    final int INCLUIR_BARRA = 15;
    final int ORDEN_BARRA = 16;
    final int PRE_BARRA = 17;
    final int SUF_BARRA = 18;

    ConfGenMasProd pers = (ConfGenMasProd) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geConfGenMasProd "+
                     " ( "+
                      "OID_GEN_MASIVA,"+
                      "OID_CLASIFICADOR,"+
                      "INCLUIR_CODIGO,"+
                      "ORDEN_CODIGO,"+
                      "PRE_CODIGO,"+
                      "SUF_CODIGO,"+
                      "INCLUIR_DESC,"+
                      "ORDEN_DESC,"+
                      "PRE_DESC,"+
                      "SUF_DESC,"+
                      "INCLUIR_SINO,"+
                      "ORDEN_SINO,"+
                      "PRE_SINO,"+
                      "SUF_SINO,"+
                      "INCLUIR_BARRA,"+
                      "ORDEN_BARRA,"+
                      "PRE_BARRA,"+
                      "SUF_BARRA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GEN_MASIVA,pers.getOID());
    qInsert.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qInsert.setBoolean(INCLUIR_CODIGO,pers.isIncluir_codigo().booleanValue());
    qInsert.setInt(ORDEN_CODIGO,pers.getOrden_codigo().intValue());
    qInsert.setString(PRE_CODIGO,pers.getPre_codigo());
    qInsert.setString(SUF_CODIGO,pers.getSuf_codigo());
    qInsert.setBoolean(INCLUIR_DESC,pers.isIncluir_desc().booleanValue());
    qInsert.setInt(ORDEN_DESC,pers.getOrden_desc().intValue());
    qInsert.setString(PRE_DESC,pers.getPre_desc());
    qInsert.setString(SUF_DESC,pers.getSuf_desc());
    qInsert.setBoolean(INCLUIR_SINO,pers.isIncluir_sino().booleanValue());
    qInsert.setInt(ORDEN_SINO,pers.getOrden_sino().intValue());
    qInsert.setString(PRE_SINO,pers.getPre_sino());
    qInsert.setString(SUF_SINO,pers.getSuf_sino());
    qInsert.setBoolean(INCLUIR_BARRA,pers.isIncluir_barra().booleanValue());
    qInsert.setInt(ORDEN_BARRA,pers.getOrden_barra().intValue());
    qInsert.setString(PRE_BARRA,pers.getPre_barra());
    qInsert.setString(SUF_BARRA,pers.getSuf_barra());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CLASIFICADOR = 1;
    final int INCLUIR_CODIGO = 2;
    final int ORDEN_CODIGO = 3;
    final int PRE_CODIGO = 4;
    final int SUF_CODIGO = 5;
    final int INCLUIR_DESC = 6;
    final int ORDEN_DESC = 7;
    final int PRE_DESC = 8;
    final int SUF_DESC = 9;
    final int INCLUIR_SINO = 10;
    final int ORDEN_SINO = 11;
    final int PRE_SINO = 12;
    final int SUF_SINO = 13;
    final int INCLUIR_BARRA = 14;
    final int ORDEN_BARRA = 15;
    final int PRE_BARRA = 16;
    final int SUF_BARRA = 17;
    final int OID_GEN_MASIVA = 18;

    ConfGenMasProd pers = (ConfGenMasProd) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geConfGenMasProd set "+
              "oid_clasificador=?"+ 
              ",incluir_codigo=?"+ 
              ",orden_codigo=?"+ 
              ",pre_codigo=?"+ 
              ",suf_codigo=?"+ 
              ",incluir_desc=?"+ 
              ",orden_desc=?"+ 
              ",pre_desc=?"+ 
              ",suf_desc=?"+ 
              ",incluir_sino=?"+ 
              ",orden_sino=?"+ 
              ",pre_sino=?"+ 
              ",suf_sino=?"+ 
              ",incluir_barra=?"+ 
              ",orden_barra=?"+ 
              ",pre_barra=?"+ 
              ",suf_barra=?"+ 
                 " where " +
                 " oid_gen_masiva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GEN_MASIVA,pers.getOID());
    qUpdate.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qUpdate.setBoolean(INCLUIR_CODIGO,pers.isIncluir_codigo().booleanValue());
    qUpdate.setInt(ORDEN_CODIGO,pers.getOrden_codigo().intValue());
    qUpdate.setString(PRE_CODIGO,pers.getPre_codigo());
    qUpdate.setString(SUF_CODIGO,pers.getSuf_codigo());
    qUpdate.setBoolean(INCLUIR_DESC,pers.isIncluir_desc().booleanValue());
    qUpdate.setInt(ORDEN_DESC,pers.getOrden_desc().intValue());
    qUpdate.setString(PRE_DESC,pers.getPre_desc());
    qUpdate.setString(SUF_DESC,pers.getSuf_desc());
    qUpdate.setBoolean(INCLUIR_SINO,pers.isIncluir_sino().booleanValue());
    qUpdate.setInt(ORDEN_SINO,pers.getOrden_sino().intValue());
    qUpdate.setString(PRE_SINO,pers.getPre_sino());
    qUpdate.setString(SUF_SINO,pers.getSuf_sino());
    qUpdate.setBoolean(INCLUIR_BARRA,pers.isIncluir_barra().booleanValue());
    qUpdate.setInt(ORDEN_BARRA,pers.getOrden_barra().intValue());
    qUpdate.setString(PRE_BARRA,pers.getPre_barra());
    qUpdate.setString(SUF_BARRA,pers.getSuf_barra());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GEN_MASIVA = 1; 
    ConfGenMasProd pers = (ConfGenMasProd) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geConfGenMasProd "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_gen_masiva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GEN_MASIVA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GEN_MASIVA = 1; 
    ConfGenMasProd pers = (ConfGenMasProd) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geConfGenMasProd "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_gen_masiva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GEN_MASIVA, pers.getOID()); 
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
      case SELECT_BY_CLASIFICADOR: {
        ps = this.selectByClasificador(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GEN_MASIVA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geConfGenMasProd "); 
    textSQL.append(" WHERE oid_gen_masiva = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GEN_MASIVA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geConfGenMasProd "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByClasificador(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geConfGenMasProd "); 
    textSQL.append(" WHERE oid_clasificador = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    ClasificadorEntidad clasificador = (ClasificadorEntidad) aCondiciones; 
    querySelect.setInt(1, clasificador.getOID()); 
    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_gen_masiva oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geConfGenMasProd");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ConfGenMasProd getConfGenMasProd(ClasificadorEntidad clasificadorEntidad,
      ISesion aSesion)
      throws BaseException {
  	return (ConfGenMasProd) ObjetoLogico.getObjects(ConfGenMasProd.NICKNAME,
	  				DBConfGenMasProd.SELECT_BY_CLASIFICADOR,
	  				clasificadorEntidad,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
} 
