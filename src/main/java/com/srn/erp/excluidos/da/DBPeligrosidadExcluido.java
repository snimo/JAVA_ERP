package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.PeligrosidadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPeligrosidadExcluido extends DBObjetoPersistente {

  public static final String OID_PELIGROSIDAD = "oid_peligrosidad";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String GRADO = "grado";
  public static final String ACTIVO = "activo";
  public static final String COLOR = "color";
  

  public DBPeligrosidadExcluido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PELIGROSIDAD = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int GRADO = 4;
    final int ACTIVO = 5;
    final int COLOR = 6;

    PeligrosidadExcluido pers = (PeligrosidadExcluido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excPeligrosidad "+
                     " ( "+
                      "OID_PELIGROSIDAD,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "GRADO,"+
                      "ACTIVO,COLOR)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PELIGROSIDAD,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(GRADO,pers.getGrado().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qInsert.setString(COLOR,pers.getColor());
    else
    	qInsert.setString(COLOR,"");
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int GRADO = 3;
    final int ACTIVO = 4;
    final int COLOR = 5;
    final int OID_PELIGROSIDAD = 6;

    PeligrosidadExcluido pers = (PeligrosidadExcluido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excPeligrosidad set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",grado=?"+ 
              ",activo=?"+ 
              ",color=?"+
                 " where " +
                 " oid_peligrosidad=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PELIGROSIDAD,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(GRADO,pers.getGrado().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getColor()!=null)
    	qUpdate.setString(COLOR,pers.getColor());
    else
    	qUpdate.setString(COLOR,"");    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PELIGROSIDAD = 1; 
    PeligrosidadExcluido pers = (PeligrosidadExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excPeligrosidad "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_peligrosidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PELIGROSIDAD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PELIGROSIDAD = 1; 
    PeligrosidadExcluido pers = (PeligrosidadExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excPeligrosidad "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_peligrosidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PELIGROSIDAD, pers.getOID()); 
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

    final int OID_PELIGROSIDAD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excPeligrosidad "); 
    textSQL.append(" WHERE oid_peligrosidad = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PELIGROSIDAD, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excPeligrosidad "); 
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excPeligrosidad "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peligrosidad oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from excPeligrosidad");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PeligrosidadExcluido.NICKNAME,
             DBPeligrosidadExcluido.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
}  
  
} 
