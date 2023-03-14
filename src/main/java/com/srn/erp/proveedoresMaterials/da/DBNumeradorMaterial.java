package com.srn.erp.proveedoresMaterials.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.proveedoresMaterials.bm.NumeradorMaterial;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBNumeradorMaterial extends DBObjetoPersistente {

  public static final String STB_NAME = "stb_name";
  public static final String STB_IDENTNR = "stb_identnr";
  
  private static final int SELECT_BY_OWNER_DBLINK_CODIGO = 100;

  public DBNumeradorMaterial() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int STB_NAME = 1;
    final int STB_IDENTNR = 2;

    NumeradorMaterial pers = (NumeradorMaterial) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into steuertb "+
                     " ( "+
                      "STB_NAME,"+
                      "STB_IDENTNR)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setString(STB_NAME,pers.getStb_name());
    qInsert.setInt(STB_IDENTNR,pers.getStb_identnr().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    NumeradorMaterial pers = (NumeradorMaterial) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update "+pers.getOwner()+"steuertb"+pers.getDbLink()+" set "+
              " stb_identnr=? "+ 
                 " where " +
                 " stb_name=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1,pers.getStb_identnr().intValue());
    qUpdate.setString(2,pers.getStb_name());
    qUpdate.executeUpdate(); 
    qUpdate.close();
    
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    NumeradorMaterial pers = (NumeradorMaterial) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update steuertb "+
                     " set activo=0 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    NumeradorMaterial pers = (NumeradorMaterial) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update steuertb "+
                     " set activo=1 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
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
      case SELECT_BY_OWNER_DBLINK_CODIGO: {
          ps = this.selectByOwnerDBLinkCodigo(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  steuertb "); 
    textSQL.append(" WHERE  = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByOwnerDBLinkCodigo(Object aCondiciones) throws BaseException, SQLException {
	  
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    String codigo = (String) condiciones.get("CODIGO");
	    String owner = (String) condiciones.get("OWNER");
	    String dbLink = (String) condiciones.get("DBLINK");
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  "+owner+"steuertb"+dbLink+" "); 
	    textSQL.append(" WHERE stb_name = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setString(1, codigo); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  steuertb "); 
    textSQL.append(" WHERE stb_name = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(1, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
    textSQL.append(" from steuertb");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static NumeradorMaterial getNumeradorMaterial(
		  HashTableDatos condiciones,
          ISesion aSesion)
          throws BaseException {
	  return (NumeradorMaterial) ObjetoLogico.getObjects(NumeradorMaterial.NICKNAME,
			  				DBNumeradorMaterial.SELECT_BY_OWNER_DBLINK_CODIGO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
