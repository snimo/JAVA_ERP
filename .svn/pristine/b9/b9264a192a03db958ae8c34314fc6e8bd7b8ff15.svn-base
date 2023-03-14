package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluCurriPostu extends DBObjetoPersistente {

  public static final String OID_CURRICULUM = "oid_curriculum";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String FECHA_RECEPCION = "fecha_recepcion";
  public static final String ENTREGADO_POR = "entregado_por";
  public static final String OBSERVACION = "observacion";
  public static final String ACTIVO = "activo";
  public static final String NRO_ARCHIVO_CV = "nro_archivo_cv";
  public static final String NOMBRE_ARCHIVO = "nombre_archivo";
  
  public static final int SELECT_BY_POSTULANTE = 100;

  public DBRecluCurriPostu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CURRICULUM = 1;
    final int OID_POSTULANTE = 2;
    final int FECHA_RECEPCION = 3;
    final int ENTREGADO_POR = 4;
    final int OBSERVACION = 5;
    final int ACTIVO = 6;
    final int NRO_ARCHIVO_CV = 7;
    final int NOMBRE_ARCHIVO = 8;

    RecluCurriPostu pers = (RecluCurriPostu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsCurriculum "+
                     " ( "+
                      "OID_CURRICULUM,"+
                      "OID_POSTULANTE,"+
                      "FECHA_RECEPCION,"+
                      "ENTREGADO_POR,"+
                      "OBSERVACION,"+
                      "ACTIVO,NRO_ARCHIVO_CV,NOMBRE_ARCHIVO)"+ 
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
    qInsert.setInt(OID_CURRICULUM,pers.getOID());
    qInsert.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qInsert.setDate(FECHA_RECEPCION,new java.sql.Date(pers.getFecha_recepcion().getTime()));
    if (pers.getEntregado_por()!=null)
    	qInsert.setString(ENTREGADO_POR,pers.getEntregado_por());
    else
    	qInsert.setNull(ENTREGADO_POR,Types.VARCHAR);
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroArchivoCV()!=null)
    	qInsert.setInt(NRO_ARCHIVO_CV, pers.getNroArchivoCV().intValue());
    else
    	qInsert.setNull(NRO_ARCHIVO_CV, Types.INTEGER);
    if (pers.getNombreArchivo()!=null)
    	qInsert.setString(NOMBRE_ARCHIVO, pers.getNombreArchivo());
    else
    	qInsert.setNull(NOMBRE_ARCHIVO, Types.VARCHAR);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1;
    final int FECHA_RECEPCION = 2;
    final int ENTREGADO_POR = 3;
    final int OBSERVACION = 4;
    final int ACTIVO = 5;
    final int NRO_ARCHIVO_CV = 6;
    final int NOMBRE_ARCHIVO = 7;
    final int OID_CURRICULUM = 8;

    RecluCurriPostu pers = (RecluCurriPostu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsCurriculum set "+
              "oid_postulante=?"+ 
              ",fecha_recepcion=?"+ 
              ",entregado_por=?"+ 
              ",observacion=?"+ 
              ",activo=?"+ 
              ",nro_archivo_cv=?"+
              ",nombre_archivo=?"+
                 " where " +
                 " oid_curriculum=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CURRICULUM,pers.getOID());
    qUpdate.setInt(OID_POSTULANTE,pers.getPostulante().getOID());
    qUpdate.setDate(FECHA_RECEPCION,new java.sql.Date(pers.getFecha_recepcion().getTime()));
    if (pers.getEntregado_por()!=null)
    	qUpdate.setString(ENTREGADO_POR,pers.getEntregado_por());
    else
    	qUpdate.setNull(ENTREGADO_POR,Types.VARCHAR);
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroArchivoCV()!=null)
    	qUpdate.setInt(NRO_ARCHIVO_CV, pers.getNroArchivoCV().intValue());
    else
    	qUpdate.setNull(NRO_ARCHIVO_CV, Types.INTEGER);
    if (pers.getNombreArchivo()!=null)
    	qUpdate.setString(NOMBRE_ARCHIVO, pers.getNombreArchivo());
    else
    	qUpdate.setNull(NOMBRE_ARCHIVO, Types.VARCHAR);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CURRICULUM = 1; 
    RecluCurriPostu pers = (RecluCurriPostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCurriculum "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_curriculum=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CURRICULUM, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CURRICULUM = 1; 
    RecluCurriPostu pers = (RecluCurriPostu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCurriculum "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_curriculum=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CURRICULUM, pers.getOID()); 
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

    final int OID_CURRICULUM = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCurriculum "); 
    textSQL.append(" WHERE oid_curriculum = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CURRICULUM, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPostulante(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsCurriculum "); 
	    textSQL.append(" WHERE oid_postulante  = ? and activo=1 order by fecha_recepcion desc , oid_curriculum desc ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluPostulante recluPostulante = (RecluPostulante) aCondiciones; 
	    querySelect.setInt(1, recluPostulante.getOID()); 
	    return querySelect;
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCurriculum "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_curriculum oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsCurriculum");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRecluCurriculumns(
		  RecluPostulante postulante,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCurriPostu.NICKNAME,
             DBRecluCurriPostu.SELECT_BY_POSTULANTE,
             postulante,
             new ListObserver(),
             aSesion);
  }  
  
} 
