
package com.srn.erp.cip.da;

import java.sql.*;

import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBGrupoVisita extends DBObjetoPersistente {

  public static final String OID_GRUPO_VISITA = "oid_grupo_visita";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String ANTIPASSBACK = "antipassback";
  public static final String OID_GRU_PUE_ING = "oid_gru_pue_ing";
  public static final String OID_GRU_PUE_EGR = "oid_gru_pue_egr";
  public static final String OID_VISITA_A = "oid_visita_a";
  public static final String OID_AUTORIZA = "oid_autoriza";
  public static final String OID_PERMISO_SEM = "oid_permiso_sem";
  public static final String APLIC_VIGENCIA = "aplic_vig";
  public static final String FEC_DESDE_VIG = "fec_desde_vig";
  public static final String FEC_HASTA_VIG = "fec_hasta_vig";
  public static final String OID_CATEG_ACC_INT = "oid_categ_acc_int";
  

  public DBGrupoVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_VISITA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int ANTIPASSBACK = 5;
    final int OID_GRU_PUE_ING = 6;
    final int OID_GRU_PUE_EGR = 7;
    final int OID_VISITA_A = 8;
    final int OID_AUTORIZA = 9;
    final int OID_PERMISO_SEM = 10;
    final int APLIC_VIGENCIA = 11;
    final int FEC_DESDE_VIG = 12;
    final int FEC_HASTA_VIG = 13;
    final int OID_CATEG_ACC_INT = 14;
    

    GrupoVisita pers = (GrupoVisita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipGrupoVisita "+
                     " ( "+
                      "OID_GRUPO_VISITA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,antipassback,oid_gru_pue_ing,oid_gru_pue_egr,oid_visita_a,oid_autoriza,oid_permiso_sem,aplic_vig,fec_desde_vig,fec_hasta_vig,oid_categ_acc_int)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_VISITA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(ANTIPASSBACK,pers.isAntipassback());
    if (pers.getGrupoPuertaIngreso()!=null)
    	qInsert.setInt(OID_GRU_PUE_ING, pers.getGrupoPuertaIngreso().getOID());
    else
    	qInsert.setNull(OID_GRU_PUE_ING, Types.INTEGER);
    if (pers.getGrupoPuertaEgreso()!=null)
    	qInsert.setInt(OID_GRU_PUE_EGR, pers.getGrupoPuertaEgreso().getOID());
    else
    	qInsert.setNull(OID_GRU_PUE_EGR, Types.INTEGER);
    if (pers.getVisitaA()!=null)
    	qInsert.setInt(OID_VISITA_A,pers.getVisitaA().getOID());
    else
    	qInsert.setNull(OID_VISITA_A,Types.INTEGER);
    if (pers.getAutoriza()!=null)
    	qInsert.setInt(OID_AUTORIZA,pers.getAutoriza().getOID());
    else
    	qInsert.setNull(OID_AUTORIZA,Types.INTEGER);
    if (pers.getPermisoSemanal()!=null)
    	qInsert.setInt(OID_PERMISO_SEM,pers.getPermisoSemanal().getOID());
    else
    	qInsert.setNull(OID_PERMISO_SEM,Types.INTEGER);    
    qInsert.setBoolean(APLIC_VIGENCIA, pers.isAplicVigencia());
    if (pers.getFecDesdeVig()!=null)
    	qInsert.setDate(FEC_DESDE_VIG, new java.sql.Date(pers.getFecDesdeVig().getTime()));
    else
    	qInsert.setNull(FEC_DESDE_VIG, Types.DATE);
    if (pers.getFecHastaVig()!=null)
    	qInsert.setDate(FEC_HASTA_VIG, new java.sql.Date(pers.getFecHastaVig().getTime()));
    else
    	qInsert.setNull(FEC_HASTA_VIG, Types.DATE);
    if (pers.getCategoriaAcceso()!=null)
    	qInsert.setInt(OID_CATEG_ACC_INT, pers.getCategoriaAcceso().getOID());
    else
    	qInsert.setNull(OID_CATEG_ACC_INT, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int ANTIPASSBACK = 4;
    final int OID_GRU_PUE_ING = 5;
    final int OID_GRU_PUE_EGR = 6;
    final int OID_VISITA_A = 7;
    final int OID_AUTORIZA = 8;
    final int OID_PERMISO_SEM = 9;
    final int APLIC_VIGENCIA = 10;
    final int FEC_DESDE_VIG = 11;
    final int FEC_HASTA_VIG = 12;
    final int OID_CATEG_ACC_INT = 13;
    final int OID_GRUPO_VISITA = 14;

    GrupoVisita pers = (GrupoVisita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipGrupoVisita set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",antipassback=?,oid_gru_pue_ing=?,oid_gru_pue_egr=?, oid_visita_a = ?,oid_autoriza = ? , oid_permiso_sem = ?, aplic_vig = ?,fec_desde_vig = ?,fec_hasta_vig = ? , oid_categ_acc_int = ? "+
                 " where " +
                 " oid_grupo_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_VISITA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(ANTIPASSBACK,pers.isAntipassback());
    if (pers.getGrupoPuertaIngreso()!=null)
    	qUpdate.setInt(OID_GRU_PUE_ING, pers.getGrupoPuertaIngreso().getOID());
    else
    	qUpdate.setNull(OID_GRU_PUE_ING, Types.INTEGER);
    if (pers.getGrupoPuertaEgreso()!=null)
    	qUpdate.setInt(OID_GRU_PUE_EGR, pers.getGrupoPuertaEgreso().getOID());
    else
    	qUpdate.setNull(OID_GRU_PUE_EGR, Types.INTEGER);    
    if (pers.getVisitaA()!=null)
    	qUpdate.setInt(OID_VISITA_A,pers.getVisitaA().getOID());
    else
    	qUpdate.setNull(OID_VISITA_A,Types.INTEGER);
    if (pers.getAutoriza()!=null)
    	qUpdate.setInt(OID_AUTORIZA,pers.getAutoriza().getOID());
    else
    	qUpdate.setNull(OID_AUTORIZA,Types.INTEGER);
    if (pers.getPermisoSemanal()!=null)
    	qUpdate.setInt(OID_PERMISO_SEM,pers.getPermisoSemanal().getOID());
    else
    	qUpdate.setNull(OID_PERMISO_SEM,Types.INTEGER);    
    qUpdate.setBoolean(APLIC_VIGENCIA, pers.isAplicVigencia());
    if (pers.getFecDesdeVig()!=null)
    	qUpdate.setDate(FEC_DESDE_VIG, new java.sql.Date(pers.getFecDesdeVig().getTime()));
    else
    	qUpdate.setNull(FEC_DESDE_VIG, Types.DATE);
    if (pers.getFecHastaVig()!=null)
    	qUpdate.setDate(FEC_HASTA_VIG, new java.sql.Date(pers.getFecHastaVig().getTime()));
    else
    	qUpdate.setNull(FEC_HASTA_VIG, Types.DATE);
    if (pers.getCategoriaAcceso()!=null)
    	qUpdate.setInt(OID_CATEG_ACC_INT, pers.getCategoriaAcceso().getOID());
    else
    	qUpdate.setNull(OID_CATEG_ACC_INT, Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_VISITA = 1; 
    GrupoVisita pers = (GrupoVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipGrupoVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_VISITA = 1; 
    GrupoVisita pers = (GrupoVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipGrupoVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_VISITA, pers.getOID()); 
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

    final int OID_GRUPO_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipGrupoVisita "); 
    textSQL.append(" WHERE oid_grupo_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_VISITA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipGrupoVisita "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_visita oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipGrupoVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
