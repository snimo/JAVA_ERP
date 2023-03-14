package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluNovedadPostu extends DBObjetoPersistente {

  public static final String OID_NOV_POSTU = "oid_nov_postu";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String FECHA = "fecha";
  public static final String NOVEDAD = "novedad";
  public static final String EXC_FUT_POSTU = "exc_fut_postu";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String ACTIVO = "activo";
  public static final String FEC_VIGENCIA = "fec_vigencia";
  
  private static final int SELECT_BY_POSTULANTE = 100;

  public DBRecluNovedadPostu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NOV_POSTU = 1;
    final int OID_POSTULANTE = 2;
    final int FECHA = 3;
    final int NOVEDAD = 4;
    final int EXC_FUT_POSTU = 5;
    final int OID_USUARIO = 6;
    final int ACTIVO = 7;
    final int FEC_VIGENCIA = 8;

    RecluNovedadPostu pers = (RecluNovedadPostu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSNOVPOSTULANTE "+
                     " ( "+
                      "OID_NOV_POSTU,"+
                      "OID_POSTULANTE,"+
                      "FECHA,"+
                      "NOVEDAD,"+
                      "EXC_FUT_POSTU,"+
                      "OID_USUARIO,"+
                      "ACTIVO , FEC_VIGENCIA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_NOV_POSTU,pers.getOID());
    qInsert.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(NOVEDAD,pers.getNovedad());
    qInsert.setBoolean(EXC_FUT_POSTU,pers.isExc_fut_postu().booleanValue());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getFecVigencia()!=null)
    	qInsert.setDate(FEC_VIGENCIA, new java.sql.Date(pers.getFecVigencia().getTime()));
    else
    	qInsert.setNull(FEC_VIGENCIA, Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1;
    final int FECHA = 2;
    final int NOVEDAD = 3;
    final int EXC_FUT_POSTU = 4;
    final int OID_USUARIO = 5;
    final int ACTIVO = 6;
    final int FEC_VIGENCIA = 7;
    final int OID_NOV_POSTU = 8;

    RecluNovedadPostu pers = (RecluNovedadPostu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSNOVPOSTULANTE set "+
              "oid_postulante=?"+ 
              ",fecha=?"+ 
              ",novedad=?"+ 
              ",exc_fut_postu=?"+ 
              ",oid_usuario=?"+ 
              ",activo=?"+ 
              ",fec_vigencia=?"+
                 " where " +
                 " oid_nov_postu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NOV_POSTU,pers.getOID());
    qUpdate.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(NOVEDAD,pers.getNovedad());
    qUpdate.setBoolean(EXC_FUT_POSTU,pers.isExc_fut_postu().booleanValue());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getFecVigencia()!=null)
    	qUpdate.setDate(FEC_VIGENCIA, new java.sql.Date(pers.getFecVigencia().getTime()));
    else
    	qUpdate.setNull(FEC_VIGENCIA, Types.DATE);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NOV_POSTU = 1; 
    RecluNovedadPostu pers = (RecluNovedadPostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSNOVPOSTULANTE "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nov_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NOV_POSTU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NOV_POSTU = 1; 
    RecluNovedadPostu pers = (RecluNovedadPostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSNOVPOSTULANTE "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nov_postu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NOV_POSTU, pers.getOID()); 
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
      case SELECT_BY_POSTULANTE: {
          ps = this.selectByPostulante(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_NOV_POSTU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSNOVPOSTULANTE "); 
    textSQL.append(" WHERE oid_nov_postu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_NOV_POSTU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPostulante(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  RSNOVPOSTULANTE "); 
	    textSQL.append(" WHERE oid_postulante  = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluPostulante postulante = (RecluPostulante) aCondiciones; 
	    querySelect.setInt(1, postulante.getOID()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSNOVPOSTULANTE "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nov_postu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from RSNOVPOSTULANTE");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getNovedadesPostulantes(RecluPostulante postulante,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluNovedadPostu.NICKNAME,
             DBRecluNovedadPostu.SELECT_BY_POSTULANTE,
             postulante,
             new ListObserver(),
             aSesion);
  }  
  
} 
