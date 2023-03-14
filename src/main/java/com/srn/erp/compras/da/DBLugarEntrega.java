package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.compras.bm.LugarEntrega;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBLugarEntrega extends DBObjetoPersistente {

  public static final String OID_LUG_ENTREGA = "oid_lug_entrega";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String DIRECCION = "direccion";
  public static final String LOCALIDAD = "localidad";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String TELEFONOS = "telefonos"; 
  
  

  public DBLugarEntrega() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LUG_ENTREGA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int DIRECCION = 5;
    final int LOCALIDAD = 6;
    final int OID_PROVINCIA = 7;
    final int OID_PAIS = 8;
    final int CODIGO_POSTAL = 9;
    final int TELEFONOS = 10;

    LugarEntrega pers = (LugarEntrega) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpLugEntrega "+
                     " ( "+
                      "OID_LUG_ENTREGA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "DIRECCION,"+
                      "LOCALIDAD,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "CODIGO_POSTAL,"+
                      "TELEFONOS)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LUG_ENTREGA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getDireccion()!=null)
    	qInsert.setString(DIRECCION,pers.getDireccion());
    else
    	qInsert.setNull(DIRECCION,Types.VARCHAR);
    if (pers.getLocalidad()!=null)
    	qInsert.setString(LOCALIDAD,pers.getLocalidad());
    else
    	qInsert.setNull(LOCALIDAD,Types.VARCHAR);
    if (pers.getProvincia()!=null) 
    	qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
    	qInsert.setNull(OID_PROVINCIA,Types.INTEGER);
    if (pers.getPais()!=null)
    	qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
    	qInsert.setNull(OID_PAIS,Types.INTEGER);
    if (pers.getCodigoPostal()!=null)
    	qInsert.setString(CODIGO_POSTAL,pers.getCodigoPostal());
    else
    	qInsert.setNull(CODIGO_POSTAL,Types.VARCHAR);
    if (pers.getTelefonos()!=null)
    	qInsert.setString(TELEFONOS,pers.getTelefonos());
    else
    	qInsert.setNull(TELEFONOS,Types.VARCHAR);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int DIRECCION = 4;
    final int LOCALIDAD = 5;
    final int OID_PROVINCIA = 6;
    final int OID_PAIS = 7;
    final int CODIGO_POSTAL = 8;
    final int TELEFONOS = 9;
    final int OID_LUG_ENTREGA = 10;

    LugarEntrega pers = (LugarEntrega) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpLugEntrega set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+
              ",direccion=?"+
              ",localidad=?"+
              ",oid_provincia=?"+
              ",oid_pais=?"+
              ",codigo_postal=?"+
              ",telefonos=?"+
                 " where " +
                 " oid_lug_entrega=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LUG_ENTREGA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getDireccion()!=null)
    	qUpdate.setString(DIRECCION,pers.getDireccion());
    else
    	qUpdate.setNull(DIRECCION,Types.VARCHAR);
    if (pers.getLocalidad()!=null)
    	qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    else
    	qUpdate.setNull(LOCALIDAD,Types.VARCHAR);
    if (pers.getProvincia()!=null) 
    	qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
    	qUpdate.setNull(OID_PROVINCIA,Types.INTEGER);
    if (pers.getPais()!=null)
    	qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
    	qUpdate.setNull(OID_PAIS,Types.INTEGER);
    if (pers.getCodigoPostal()!=null)
    	qUpdate.setString(CODIGO_POSTAL,pers.getCodigoPostal());
    else
    	qUpdate.setNull(CODIGO_POSTAL,Types.VARCHAR);
    if (pers.getTelefonos()!=null)
    	qUpdate.setString(TELEFONOS,pers.getTelefonos());
    else
    	qUpdate.setNull(TELEFONOS,Types.VARCHAR);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LUG_ENTREGA = 1; 
    LugarEntrega pers = (LugarEntrega) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpLugEntrega "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_lug_entrega=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LUG_ENTREGA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LUG_ENTREGA = 1; 
    LugarEntrega pers = (LugarEntrega) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpLugEntrega "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_lug_entrega=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LUG_ENTREGA, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LUG_ENTREGA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpLugEntrega "); 
    textSQL.append(" WHERE oid_lug_entrega = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LUG_ENTREGA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpLugEntrega "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_lug_entrega oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cpLugEntrega");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
