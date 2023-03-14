package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.DiccionarioPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDiccionarioPlanificacion extends DBObjetoPersistente {

  public static final String OID_DICCIONARIO = "oid_diccionario";
  public static final String NRO_RELACION = "nro_relacion";
  public static final String NRO_RELACION_PADRE = "nro_relacion_padre";
  public static final String TIPO_ITEM = "tipo_item";
  public static final String TITULO = "titulo";
  public static final String OID_ATRI_DICC = "oid_atri_dicc";
  public static final String ORDEN = "orden";
  public static final String ACTIVO = "activo";

  public DBDiccionarioPlanificacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DICCIONARIO = 1;
    final int NRO_RELACION = 2;
    final int NRO_RELACION_PADRE = 3;
    final int TIPO_ITEM = 4;
    final int TITULO = 5;
    final int OID_ATRI_DICC = 6;
    final int ORDEN = 7;
    final int ACTIVO = 8;

    DiccionarioPlanificacion pers = (DiccionarioPlanificacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plDiccionario "+
                     " ( "+
                      "OID_DICCIONARIO,"+
                      "NRO_RELACION,"+
                      "NRO_RELACION_PADRE,"+
                      "TIPO_ITEM,"+
                      "TITULO,"+
                      "OID_ATRI_DICC,"+
                      "ORDEN,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DICCIONARIO,pers.getOID());
    qInsert.setInt(NRO_RELACION,pers.getNro_relacion().intValue());
    qInsert.setInt(NRO_RELACION_PADRE,pers.getNro_relacion_padre().intValue());
    qInsert.setString(TIPO_ITEM,pers.getTipo_item());
    qInsert.setString(TITULO,pers.getTitulo());
    if (pers.getAtributo_diccionario()!=null) 
      qInsert.setInt(OID_ATRI_DICC,pers.getAtributo_diccionario().getOID());
    else
      qInsert.setNull(OID_ATRI_DICC,java.sql.Types.INTEGER);
    if (pers.getOrden()!=null)
    	qInsert.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qInsert.setInt(ORDEN,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_RELACION = 1;
    final int NRO_RELACION_PADRE = 2;
    final int TIPO_ITEM = 3;
    final int TITULO = 4;
    final int OID_ATRI_DICC = 5;
    final int ORDEN = 6;
    final int ACTIVO = 7;
    final int OID_DICCIONARIO = 8;

    DiccionarioPlanificacion pers = (DiccionarioPlanificacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plDiccionario set "+
              "nro_relacion=?"+ 
              ",nro_relacion_padre=?"+ 
              ",tipo_item=?"+ 
              ",titulo=?"+ 
              ",oid_atri_dicc=?"+ 
              ",orden=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_diccionario=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DICCIONARIO,pers.getOID());
    qUpdate.setInt(NRO_RELACION,pers.getNro_relacion().intValue());
    qUpdate.setInt(NRO_RELACION_PADRE,pers.getNro_relacion_padre().intValue());
    qUpdate.setString(TIPO_ITEM,pers.getTipo_item());
    qUpdate.setString(TITULO,pers.getTitulo());
    if (pers.getAtributo_diccionario()!=null) 
      qUpdate.setInt(OID_ATRI_DICC,pers.getAtributo_diccionario().getOID());
    else
      qUpdate.setNull(OID_ATRI_DICC,java.sql.Types.INTEGER);
    if (pers.getOrden()!=null)
    	qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qUpdate.setInt(ORDEN,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DICCIONARIO = 1; 
    DiccionarioPlanificacion pers = (DiccionarioPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plDiccionario "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_diccionario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DICCIONARIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DICCIONARIO = 1; 
    DiccionarioPlanificacion pers = (DiccionarioPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plDiccionario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_diccionario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DICCIONARIO, pers.getOID()); 
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
      case SELECT_ALL_ACTIVOS: {
        ps = this.selectAllActivos(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DICCIONARIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plDiccionario "); 
    textSQL.append(" WHERE oid_diccionario = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DICCIONARIO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plDiccionario "); 
    textSQL.append(" WHERE activo = 1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plDiccionario "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_diccionario oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plDiccionario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllActivos(
      ISesion aSesion) throws BaseException {
 	 return (List) ObjetoLogico.getObjects(DiccionarioPlanificacion.NICKNAME,
         DBDiccionarioPlanificacion.SELECT_ALL_ACTIVOS,
         null,
         new ListObserver(),
         aSesion);
  }
  
  
} 
