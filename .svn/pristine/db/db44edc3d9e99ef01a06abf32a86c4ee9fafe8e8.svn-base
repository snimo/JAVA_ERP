package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.ObsCodifVtasIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBObsCodifVtasIdioma extends DBObjetoPersistente {

  public static final String OID_OBS_IDIOMA = "oid_obs_idioma";
  public static final String OID_OBS_COD = "oid_obs_cod";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_IDIOMA = "oid_idioma";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_OBS_COD = 100;
  public static final int SELECT_BY_COD_OBS_IDIOMA = 101;

  public DBObsCodifVtasIdioma() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OBS_IDIOMA = 1;
    final int OID_OBS_COD = 2;
    final int DESCRIPCION = 3;
    final int OID_IDIOMA = 4;
    final int ACTIVO = 5;

    ObsCodifVtasIdioma pers = (ObsCodifVtasIdioma) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veObsCodVtasIdi "+
                     " ( "+
                      "OID_OBS_IDIOMA,"+
                      "OID_OBS_COD,"+
                      "DESCRIPCION,"+
                      "OID_IDIOMA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OBS_IDIOMA,pers.getOID());
    qInsert.setInt(OID_OBS_COD,pers.getCodigo_observacion().getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OBS_COD = 1;
    final int DESCRIPCION = 2;
    final int OID_IDIOMA = 3;
    final int ACTIVO = 4;
    final int OID_OBS_IDIOMA = 5;

    ObsCodifVtasIdioma pers = (ObsCodifVtasIdioma) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veObsCodVtasIdi set "+
              "oid_obs_cod=?"+ 
              ",descripcion=?"+ 
              ",oid_idioma=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_obs_idioma=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_IDIOMA,pers.getOID());
    qUpdate.setInt(OID_OBS_COD,pers.getCodigo_observacion().getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_IDIOMA = 1; 
    ObsCodifVtasIdioma pers = (ObsCodifVtasIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veObsCodVtasIdi "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_obs_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_IDIOMA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_IDIOMA = 1; 
    ObsCodifVtasIdioma pers = (ObsCodifVtasIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veObsCodVtasIdi "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_obs_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_IDIOMA, pers.getOID()); 
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
      case SELECT_BY_OBS_COD: {
          ps = this.selectByObsCod(aCondiciones); 
          break; 
      }
      case SELECT_BY_COD_OBS_IDIOMA: {
          ps = this.selectByObsCodIdioma(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_OBS_IDIOMA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veObsCodVtasIdi "); 
    textSQL.append(" WHERE oid_obs_idioma = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OBS_IDIOMA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByObsCod(Object aCondiciones) throws BaseException, SQLException { 


	    ObsCodifVtas obsCod = (ObsCodifVtas) aCondiciones;
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veObsCodVtasIdi "); 
	    textSQL.append(" WHERE oid_obs_cod  = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, obsCod.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectByObsCodIdioma(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veObsCodVtasIdi "); 
	    textSQL.append(" WHERE oid_obs_cod  = ? and oid_idioma = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ObsCodifVtas obsCodifVtas = (ObsCodifVtas) condiciones.get(ObsCodifVtas.NICKNAME);
	    Idioma idioma = (Idioma) condiciones.get(Idioma.NICKNAME);
	    
	    querySelect.setInt(1, obsCodifVtas.getOID());
	    querySelect.setInt(2, idioma.getOID());
	    
	    return querySelect; 
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veObsCodVtasIdi "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_obs_idioma oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veObsCodVtasIdi");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getObsCodIdioma(ObsCodifVtas obsCodifVtas,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ObsCodifVtasIdioma.NICKNAME,
             DBObsCodifVtasIdioma.SELECT_BY_OBS_COD,
             obsCodifVtas,
             new ListObserver(),
             aSesion);
  }
  
  public static ObsCodifVtasIdioma getObsCodifVtasIdioma(
		  ObsCodifVtas obsCodif,
		  Idioma idioma,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ObsCodifVtas.NICKNAME, obsCodif);
	  condiciones.put(Idioma.NICKNAME, idioma);
	  return (ObsCodifVtasIdioma) ObjetoLogico.getObjects(ObsCodifVtasIdioma.NICKNAME,
			  				DBObsCodifVtasIdioma.SELECT_BY_COD_OBS_IDIOMA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
