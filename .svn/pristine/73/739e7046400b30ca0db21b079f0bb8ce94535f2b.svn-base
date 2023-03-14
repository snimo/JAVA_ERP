package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBMaqPuertasVisita extends DBObjetoPersistente {

  public static final String OID_MAQ_PUE_VIS = "oid_maq_pue_vis";
  public static final String MAQUINA = "maquina";
  public static final String OID_PUERTA_ENT = "oid_puerta_ent";
  public static final String OID_PUERTA_SAL = "oid_puerta_sal";
  public static final String ACTIVO = "activo";
  public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
  
  public DBMaqPuertasVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MAQ_PUE_VIS = 1;
    final int MAQUINA = 2;
    final int OID_PUERTA_ENT = 3;
    final int OID_PUERTA_SAL = 4;
    final int ACTIVO = 5;
    final int OID_GRUPO_PUERTA = 6;

    MaqPuertasVisita pers = (MaqPuertasVisita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMaqPuertaVis "+
                     " ( "+
                      "OID_MAQ_PUE_VIS,"+
                      "MAQUINA,"+
                      "OID_PUERTA_ENT,"+
                      "OID_PUERTA_SAL,"+
                      "ACTIVO,OID_GRUPO_PUERTA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MAQ_PUE_VIS,pers.getOID());
    qInsert.setString(MAQUINA,pers.getMaquina());
    if (pers.getPuerta_entrada()!=null) 
      qInsert.setInt(OID_PUERTA_ENT,pers.getPuerta_entrada().getOID());
    else
      qInsert.setNull(OID_PUERTA_ENT,java.sql.Types.INTEGER);
    if (pers.getPuerta_salida()!=null) 
      qInsert.setInt(OID_PUERTA_SAL,pers.getPuerta_salida().getOID());
    else
      qInsert.setNull(OID_PUERTA_SAL,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoPuerta()!=null)
    	qInsert.setInt(OID_GRUPO_PUERTA , pers.getGrupoPuerta().getOIDInteger());
    else
    	qInsert.setNull(OID_GRUPO_PUERTA , Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int MAQUINA = 1;
    final int OID_PUERTA_ENT = 2;
    final int OID_PUERTA_SAL = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_PUERTA = 5;
    final int OID_MAQ_PUE_VIS = 6;

    MaqPuertasVisita pers = (MaqPuertasVisita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMaqPuertaVis set "+
              "maquina=?"+ 
              ",oid_puerta_ent=?"+ 
              ",oid_puerta_sal=?"+ 
              ",activo=?"+ 
              ",oid_grupo_puerta=?"+
                 " where " +
                 " oid_maq_pue_vis=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MAQ_PUE_VIS,pers.getOID());
    qUpdate.setString(MAQUINA,pers.getMaquina());
    if (pers.getPuerta_entrada()!=null) 
      qUpdate.setInt(OID_PUERTA_ENT,pers.getPuerta_entrada().getOID());
    else
      qUpdate.setNull(OID_PUERTA_ENT,java.sql.Types.INTEGER);
    if (pers.getPuerta_salida()!=null) 
      qUpdate.setInt(OID_PUERTA_SAL,pers.getPuerta_salida().getOID());
    else
      qUpdate.setNull(OID_PUERTA_SAL,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getGrupoPuerta()!=null)
    	qUpdate.setInt(OID_GRUPO_PUERTA , pers.getGrupoPuerta().getOIDInteger());
    else
    	qUpdate.setNull(OID_GRUPO_PUERTA , Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MAQ_PUE_VIS = 1; 
    MaqPuertasVisita pers = (MaqPuertasVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMaqPuertaVis "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_maq_pue_vis=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MAQ_PUE_VIS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MAQ_PUE_VIS = 1; 
    MaqPuertasVisita pers = (MaqPuertasVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMaqPuertaVis "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_maq_pue_vis=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MAQ_PUE_VIS, pers.getOID()); 
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

    final int OID_MAQ_PUE_VIS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMaqPuertaVis "); 
    textSQL.append(" WHERE oid_maq_pue_vis = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MAQ_PUE_VIS, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMaqPuertaVis "); 
    textSQL.append(" WHERE maquina = ?  ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_maq_pue_vis oid, '' codigo,  maquina descripcion ,activo ");
    textSQL.append(" from cipMaqPuertaVis");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
