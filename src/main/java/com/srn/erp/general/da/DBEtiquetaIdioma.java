package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEtiquetaIdioma extends DBObjetoPersistente {

  public static final String OID_ETI_IDIOMA = "oid_eti_idioma";
  public static final String NICKNAME = "nickname";
  public static final String ETIQUETA = "etiqueta";
  public static final String ACTIVO = "activo";
  public static final String DESCRIPCION = "descripcion";
  
  public static final int SELECT_ETIQUETAS_BY_NICKNAME = 100;
  public static final int SELECT_BY_ETIQUETA_NICKNAME = 101;

  public DBEtiquetaIdioma() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ETI_IDIOMA = 1;
    final int NICKNAME = 2;
    final int ETIQUETA = 3;
    final int ACTIVO = 4;
    final int DESCRIPCION = 5;

    EtiquetaIdioma pers = (EtiquetaIdioma) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geEtiquetaIdioma "+
                     " ( "+
                      "OID_ETI_IDIOMA,"+
                      "NICKNAME,"+
                      "ETIQUETA,"+
                      "ACTIVO,DESCRIPCION)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ETI_IDIOMA,pers.getOID());
    qInsert.setString(NICKNAME,pers.getNickname());
    qInsert.setString(ETIQUETA,pers.getEtiqueta());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(DESCRIPCION, pers.getDescripcion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NICKNAME = 1;
    final int ETIQUETA = 2;
    final int ACTIVO = 3;
    final int DESCRIPCION = 4;
    final int OID_ETI_IDIOMA = 5;

    EtiquetaIdioma pers = (EtiquetaIdioma) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geEtiquetaIdioma set "+
              "nickname=?"+ 
              ",etiqueta=?"+ 
              ",activo=?"+
              ",descripcion=?"+ 
                 " where " +
                 " oid_eti_idioma=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ETI_IDIOMA,pers.getOID());
    qUpdate.setString(NICKNAME,pers.getNickname());
    qUpdate.setString(ETIQUETA,pers.getEtiqueta());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ETI_IDIOMA = 1; 
    EtiquetaIdioma pers = (EtiquetaIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geEtiquetaIdioma "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_eti_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ETI_IDIOMA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ETI_IDIOMA = 1; 
    EtiquetaIdioma pers = (EtiquetaIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geEtiquetaIdioma "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_eti_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ETI_IDIOMA, pers.getOID()); 
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
      case SELECT_ETIQUETAS_BY_NICKNAME: {
        ps = this.selectEtiquetasByNickName(aCondiciones); 
        break; 
      }
      case SELECT_BY_ETIQUETA_NICKNAME: {
        ps = this.selectByEtiquetasNickName(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ETI_IDIOMA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geEtiquetaIdioma "); 
    textSQL.append(" WHERE oid_eti_idioma = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ETI_IDIOMA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectEtiquetasByNickName(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geEtiquetaIdioma "); 
    textSQL.append(" WHERE nickname = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String nickname = (String) aCondiciones; 
    querySelect.setString(1, nickname); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEtiquetasNickName(Object aCondiciones) throws BaseException, SQLException {
  	
  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	String nickname = (String) condiciones.get("nickname");
  	String etiqueta = (String) condiciones.get("etiqueta");
  	
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geEtiquetaIdioma "); 
    textSQL.append(" WHERE nickname = ? and etiqueta = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setString(1, nickname); 
    querySelect.setString(2, etiqueta);
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geEtiquetaIdioma "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_eti_idioma oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geEtiquetaIdioma");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEtiquetasComprobante(String nickname,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(EtiquetaIdioma.NICKNAME,
         DBEtiquetaIdioma.SELECT_ETIQUETAS_BY_NICKNAME,
         nickname,
         new ListObserver(),
         aSesion);
  }
  
  public static EtiquetaIdioma getEtiquetaIdioma(String aNickName,
  																							 String aLabel,			
  																							 ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put("nickname",aNickName);
  	condiciones.put("etiqueta",aLabel);
  	return (EtiquetaIdioma) ObjetoLogico.getObjects(EtiquetaIdioma.NICKNAME,
	  				DBEtiquetaIdioma.SELECT_BY_ETIQUETA_NICKNAME,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
} 
