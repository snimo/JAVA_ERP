package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.Rota;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRota extends DBObjetoPersistente {

  public static final String OID_ROTA = "oid_rota";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String HORARIO_DESDE = "horario_desde";
  public static final String HORARIO_HASTA = "horario_hasta";
  public static final String MIN_ENT_ANTES = "min_ent_antes";
  public static final String ACTIVO = "activo";
  public static final String MIN_ENT_DESP = "min_ent_desp";
  public static final String MIN_SAL_ANTES = "min_sal_antes";
  public static final String TIPO_ACCESO = "tipo_acceso";
  public static final String TIPO_EGRESO = "tipo_egreso";
  public static final String MIN_SAL_DESPUES = "min_sal_despues";
  public static final String LEY_NO_INGRESA = "ley_no_ingresa";
  public static final String LEY_NO_EGRESA = "ley_no_egresa";

  public DBRota() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int HORARIO_DESDE = 4;
    final int HORARIO_HASTA = 5;
    final int MIN_ENT_ANTES = 6;
    final int ACTIVO = 7;
    final int MIN_ENT_DESP = 8;
    final int MIN_SAL_ANTES = 9;
    final int TIPO_ACCESO = 10;
    final int TIPO_EGRESO = 11;
    final int MIN_SAL_DESPUES = 12;
    final int LEY_NO_INGRESA = 13;
    final int LEY_NO_EGRESA = 14;

    Rota pers = (Rota) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipRotas "+
                     " ( "+
                      "OID_ROTA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "HORARIO_DESDE,"+
                      "HORARIO_HASTA,"+
                      "MIN_ENT_ANTES,"+
                      "ACTIVO,"+
                      "MIN_ENT_DESP,"+
                      "MIN_SAL_ANTES,"+
                      "TIPO_ACCESO,"+
                      "TIPO_EGRESO,"+
                      "MIN_SAL_DESPUES,LEY_NO_INGRESA,LEY_NO_EGRESA)"+ 
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
    qInsert.setInt(OID_ROTA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(HORARIO_DESDE,pers.getHorario_desde());
    qInsert.setString(HORARIO_HASTA,pers.getHorario_hasta());
    if (pers.getMin_ent_antes()!=null)
    	qInsert.setInt(MIN_ENT_ANTES,pers.getMin_ent_antes().intValue());
    else
    	qInsert.setInt(MIN_ENT_ANTES,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMin_ent_desp()!=null)
    	qInsert.setInt(MIN_ENT_DESP,pers.getMin_ent_desp().intValue());
    else
    	qInsert.setInt(MIN_ENT_DESP,0);
    if (pers.getMin_sal_antes()!=null)
    	qInsert.setInt(MIN_SAL_ANTES,pers.getMin_sal_antes().intValue());
    else
    	qInsert.setInt(MIN_SAL_ANTES,0);
    qInsert.setString(TIPO_ACCESO,pers.getTipo_acceso());
    qInsert.setString(TIPO_EGRESO,pers.getTipo_egreso());
    if (pers.getMin_sal_despues()!=null)
    	qInsert.setInt(MIN_SAL_DESPUES,pers.getMin_sal_despues().intValue());
    else
    	qInsert.setInt(MIN_SAL_DESPUES,0);
    if (pers.getLeyendaNoIngresa()!=null)
    	qInsert.setString(LEY_NO_INGRESA , pers.getLeyendaNoIngresa());
    else
    	qInsert.setString(LEY_NO_INGRESA , "");
    if (pers.getLeyendaNoEgresa()!=null)
    	qInsert.setString(LEY_NO_EGRESA , pers.getLeyendaNoEgresa());
    else
    	qInsert.setString(LEY_NO_EGRESA , "");
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int HORARIO_DESDE = 3;
    final int HORARIO_HASTA = 4;
    final int MIN_ENT_ANTES = 5;
    final int ACTIVO = 6;
    final int MIN_ENT_DESP = 7;
    final int MIN_SAL_ANTES = 8;
    final int TIPO_ACCESO = 9;
    final int TIPO_EGRESO = 10;
    final int MIN_SAL_DESPUES = 11;
    final int LEY_NO_INGRESA = 12;
    final int LEY_NO_EGRESA = 13;
    final int OID_ROTA = 14;

    Rota pers = (Rota) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipRotas set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",horario_desde=?"+ 
              ",horario_hasta=?"+ 
              ",min_ent_antes=?"+ 
              ",activo=?"+ 
              ",min_ent_desp=?"+ 
              ",min_sal_antes=?"+ 
              ",tipo_acceso=?"+ 
              ",tipo_egreso=?"+ 
              ",min_sal_despues=?"+
              ",ley_no_ingresa=?"+
              ",ley_no_egresa=?"+
                 " where " +
                 " oid_rota=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(HORARIO_DESDE,pers.getHorario_desde());
    qUpdate.setString(HORARIO_HASTA,pers.getHorario_hasta());
    if (pers.getMin_ent_antes()!=null)
    	qUpdate.setInt(MIN_ENT_ANTES,pers.getMin_ent_antes().intValue());
    else
    	qUpdate.setInt(MIN_ENT_ANTES,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMin_ent_desp()!=null)
    	qUpdate.setInt(MIN_ENT_DESP,pers.getMin_ent_desp().intValue());
    else
    	qUpdate.setInt(MIN_ENT_DESP,0);
    if (pers.getMin_sal_antes()!=null)
    	qUpdate.setInt(MIN_SAL_ANTES,pers.getMin_sal_antes().intValue());
    else
    	qUpdate.setInt(MIN_SAL_ANTES,0);
    qUpdate.setString(TIPO_ACCESO,pers.getTipo_acceso());
    qUpdate.setString(TIPO_EGRESO,pers.getTipo_egreso());
    if (pers.getMin_sal_despues()!=null)
    	qUpdate.setInt(MIN_SAL_DESPUES,pers.getMin_sal_despues().intValue());
    else
    	qUpdate.setInt(MIN_SAL_DESPUES,0);
    if (pers.getLeyendaNoIngresa()!=null)
    	qUpdate.setString(LEY_NO_INGRESA , pers.getLeyendaNoIngresa());
    else
    	qUpdate.setString(LEY_NO_INGRESA , "");
    if (pers.getLeyendaNoEgresa()!=null)
    	qUpdate.setString(LEY_NO_EGRESA , pers.getLeyendaNoEgresa());
    else
    	qUpdate.setString(LEY_NO_EGRESA , "");
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA = 1; 
    Rota pers = (Rota) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA = 1; 
    Rota pers = (Rota) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: {
          ps = this.selectAll(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ROTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotas "); 
    textSQL.append(" WHERE oid_rota = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ROTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cipRotas "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotas "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rota oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipRotas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllRotas(ISesion aSesion) throws BaseException {
	  
	  return (List) ObjetoLogico.getObjects(Rota.NICKNAME,
             DBRota.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
