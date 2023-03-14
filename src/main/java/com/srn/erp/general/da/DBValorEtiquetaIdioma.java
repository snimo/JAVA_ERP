package com.srn.erp.general.da;

import java.sql.*;
import com.srn.erp.general.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBValorEtiquetaIdioma extends DBObjetoPersistente {

  public static final String OID_VAL_ETI_IDIOMA = "oid_val_eti_idioma";
  public static final String OID_ETI_IDIOMA = "oid_eti_idioma";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_IDIOMA = "oid_idioma";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ETIQUETA_IDIOMA = 100;

  public DBValorEtiquetaIdioma() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_ETI_IDIOMA = 1;
    final int OID_ETI_IDIOMA = 2;
    final int DESCRIPCION = 3;
    final int OID_IDIOMA = 4;
    final int ACTIVO = 5;

    ValorEtiquetaIdioma pers = (ValorEtiquetaIdioma) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geValEtiIdioma "+
                     " ( "+
                      "OID_VAL_ETI_IDIOMA,"+
                      "OID_ETI_IDIOMA,"+
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
    qInsert.setInt(OID_VAL_ETI_IDIOMA,pers.getOID());
    qInsert.setInt(OID_ETI_IDIOMA,pers.getEtiqueta_idioma().getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ETI_IDIOMA = 1;
    final int DESCRIPCION = 2;
    final int OID_IDIOMA = 3;
    final int ACTIVO = 4;
    final int OID_VAL_ETI_IDIOMA = 5;

    ValorEtiquetaIdioma pers = (ValorEtiquetaIdioma) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geValEtiIdioma set "+
              "oid_eti_idioma=?"+ 
              ",descripcion=?"+ 
              ",oid_idioma=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_val_eti_idioma=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ETI_IDIOMA,pers.getOID());
    qUpdate.setInt(OID_ETI_IDIOMA,pers.getEtiqueta_idioma().getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_ETI_IDIOMA = 1; 
    ValorEtiquetaIdioma pers = (ValorEtiquetaIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geValEtiIdioma "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_val_eti_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ETI_IDIOMA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_ETI_IDIOMA = 1; 
    ValorEtiquetaIdioma pers = (ValorEtiquetaIdioma) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geValEtiIdioma "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_eti_idioma=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ETI_IDIOMA, pers.getOID()); 
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
      case SELECT_BY_ETIQUETA_IDIOMA: {
        ps = this.selectByEtiquetaIdioma(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAL_ETI_IDIOMA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geValEtiIdioma "); 
    textSQL.append(" WHERE oid_val_eti_idioma = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAL_ETI_IDIOMA, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geValEtiIdioma "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEtiquetaIdioma(Object aCondiciones) throws BaseException, SQLException { 

  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) condiciones.get(EtiquetaIdioma.NICKNAME);
  	Idioma idioma = (Idioma) condiciones.get(Idioma.NICKNAME);
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geValEtiIdioma "); 
    textSQL.append(" WHERE oid_eti_idioma = ? and oid_idioma = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, etiquetaIdioma.getOID());
    querySelect.setInt(2, idioma.getOID());
    return querySelect; 
  }
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_eti_idioma oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geValEtiIdioma");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ValorEtiquetaIdioma getValorEtiquetaIdioma(EtiquetaIdioma etiquetaIdioma,
  		                                                     Idioma idioma,
  		                                                     ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(EtiquetaIdioma.NICKNAME, etiquetaIdioma);
  	
  	if (idioma == null)
  		throw new ExceptionValidation(null,"Debe ingresar el idioma");
  	
  	condiciones.put(Idioma.NICKNAME, idioma);
  	return (ValorEtiquetaIdioma) ObjetoLogico.getObjects(ValorEtiquetaIdioma.NICKNAME,
	  				DBValorEtiquetaIdioma.SELECT_BY_ETIQUETA_IDIOMA,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  
  
} 
