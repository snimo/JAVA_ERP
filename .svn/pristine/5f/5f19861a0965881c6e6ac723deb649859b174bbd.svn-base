package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoTipoUPCDet;
import com.srn.erp.presupuesto.bm.TipoUPC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoTipoUPCDet extends DBObjetoPersistente {

  public static final String OID_GRUPO_DET = "oid_grupo_det";
  public static final String OID_GRUPO_TIPO_UPC = "oid_grupo_tipo_upc";
  public static final String OID_TIPO_UPC = "oid_tipo_upc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_TIPO_UPC = 100;
  public static final int SELECT_BY_GRUPO_Y_TIPO_UPC = 101;

  public DBGrupoTipoUPCDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_DET = 1;
    final int OID_GRUPO_TIPO_UPC = 2;
    final int OID_TIPO_UPC = 3;
    final int ACTIVO = 4;

    GrupoTipoUPCDet pers = (GrupoTipoUPCDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plGrupoTipoUPCDet "+
                     " ( "+
                      "OID_GRUPO_DET,"+
                      "OID_GRUPO_TIPO_UPC,"+
                      "OID_TIPO_UPC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_DET,pers.getOID());
    qInsert.setInt(OID_GRUPO_TIPO_UPC,pers.getGrupo_tipo_upc().getOID());
    qInsert.setInt(OID_TIPO_UPC,pers.getTipo_upc().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_TIPO_UPC = 1;
    final int OID_TIPO_UPC = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_DET = 4;

    GrupoTipoUPCDet pers = (GrupoTipoUPCDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plGrupoTipoUPCDet set "+
              "oid_grupo_tipo_upc=?"+ 
              ",oid_tipo_upc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET,pers.getOID());
    qUpdate.setInt(OID_GRUPO_TIPO_UPC,pers.getGrupo_tipo_upc().getOID());
    qUpdate.setInt(OID_TIPO_UPC,pers.getTipo_upc().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_DET = 1; 
    GrupoTipoUPCDet pers = (GrupoTipoUPCDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from plGrupoTipoUPCDet "+
                     " where " + 
                     " oid_grupo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_DET = 1; 
    GrupoTipoUPCDet pers = (GrupoTipoUPCDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plGrupoTipoUPCDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_DET, pers.getOID()); 
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
      case SELECT_BY_GRUPO_TIPO_UPC: {
        ps = this.selectByGrupoTipoUPC(aCondiciones); 
        break; 
      }
      case SELECT_BY_GRUPO_Y_TIPO_UPC: {
        ps = this.selectByGrupoYTipoUPC(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGrupoTipoUPCDet "); 
    textSQL.append(" WHERE oid_grupo_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoTipoUPC(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGrupoTipoUPCDet "); 
    textSQL.append(" WHERE oid_grupo_tipo_upc = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) aCondiciones; 
    querySelect.setInt(1, grupoTipoUPC.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoYTipoUPC(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer();
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) condiciones.get(GrupoTipoUPC.NICKNAME);
    TipoUPC tipoUPC = (TipoUPC) condiciones.get(TipoUPC.NICKNAME);
    textSQL.append("SELECT * FROM  plGrupoTipoUPCDet "); 
    textSQL.append(" WHERE oid_grupo_tipo_upc = ? and oid_tipo_upc = ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, grupoTipoUPC.getOID());
    querySelect.setInt(2, tipoUPC.getOID());
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plGrupoTipoUPCDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plGrupoTipoUPCDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDetallesByGrupoTipoUPC(GrupoTipoUPC grupo,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(GrupoTipoUPCDet.NICKNAME,
         DBGrupoTipoUPCDet.SELECT_BY_GRUPO_TIPO_UPC,
         grupo,
         new ListObserver(),
         aSesion);
  }
  
  public static GrupoTipoUPCDet getGrupoTipoUPCDet(GrupoTipoUPC grupo,TipoUPC tipo,
      ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(GrupoTipoUPC.NICKNAME,grupo);
  	condiciones.put(TipoUPC.NICKNAME,tipo);
  	return (GrupoTipoUPCDet) ObjetoLogico.getObjects(GrupoTipoUPCDet.NICKNAME,
	  				DBGrupoTipoUPCDet.SELECT_BY_GRUPO_Y_TIPO_UPC,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
} 
