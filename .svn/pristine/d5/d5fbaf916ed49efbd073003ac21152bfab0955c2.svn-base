package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.MotivoVisitaDoc;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotivoVisitaDoc extends DBObjetoPersistente {

  public static final String OID_MOT_VIS_DOC = "oid_mot_vis_doc";
  public static final String OID_MOT_VISITA = "oid_mot_visita";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String DIAS_AVISO_VENC = "dias_aviso_venc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_MOT_VISITA = 100;
  public static final int VISITA_DOCU = 101;

  public DBMotivoVisitaDoc() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_VIS_DOC = 1;
    final int OID_MOT_VISITA = 2;
    final int OID_TIPO_DOCU = 3;
    final int DIAS_AVISO_VENC = 4;
    final int ACTIVO = 5;

    MotivoVisitaDoc pers = (MotivoVisitaDoc) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotVisDoc "+
                     " ( "+
                      "OID_MOT_VIS_DOC,"+
                      "OID_MOT_VISITA,"+
                      "OID_TIPO_DOCU,"+
                      "DIAS_AVISO_VENC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_VIS_DOC,pers.getOID());
    qInsert.setInt(OID_MOT_VISITA,pers.getMotivo().getOID());
    qInsert.setInt(OID_TIPO_DOCU,pers.getTipo_docu().getOID());
    if (pers.getDias_aviso_venc()!=null)
    	qInsert.setInt(DIAS_AVISO_VENC,pers.getDias_aviso_venc().intValue());
    else
    	qInsert.setInt(DIAS_AVISO_VENC,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_VISITA = 1;
    final int OID_TIPO_DOCU = 2;
    final int DIAS_AVISO_VENC = 3;
    final int ACTIVO = 4;
    final int OID_MOT_VIS_DOC = 5;

    MotivoVisitaDoc pers = (MotivoVisitaDoc) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotVisDoc set "+
              "oid_mot_visita=?"+ 
              ",oid_tipo_docu=?"+ 
              ",dias_aviso_venc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mot_vis_doc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_VIS_DOC,pers.getOID());
    qUpdate.setInt(OID_MOT_VISITA,pers.getMotivo().getOID());
    qUpdate.setInt(OID_TIPO_DOCU,pers.getTipo_docu().getOID());
    if (pers.getDias_aviso_venc()!=null)
    	qUpdate.setInt(DIAS_AVISO_VENC,pers.getDias_aviso_venc().intValue());
    else
    	qUpdate.setInt(DIAS_AVISO_VENC,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_VIS_DOC = 1; 
    MotivoVisitaDoc pers = (MotivoVisitaDoc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotVisDoc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_vis_doc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_VIS_DOC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_VIS_DOC = 1; 
    MotivoVisitaDoc pers = (MotivoVisitaDoc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotVisDoc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_vis_doc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_VIS_DOC, pers.getOID()); 
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
      case SELECT_BY_MOT_VISITA: {
          ps = this.selectByMotVisita(aCondiciones); 
          break; 
      }
      case VISITA_DOCU: {
          ps = this.selectByVisitaDocu(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_VIS_DOC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotVisDoc "); 
    textSQL.append(" WHERE oid_mot_vis_doc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_VIS_DOC, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByVisitaDocu(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotVisDoc "); 
	    textSQL.append(" WHERE oid_mot_visita = ? and oid_tipo_docu = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    MotivoVisita motivo = (MotivoVisita) condiciones.get(MotivoVisita.NICKNAME);
	    TipoDocumentacionCIP tipo = (TipoDocumentacionCIP) condiciones.get(TipoDocumentacionCIP.NICKNAME);
	    querySelect.setInt(1, motivo.getOID()); 
	    querySelect.setInt(2, tipo.getOID());
	    return querySelect; 
  }
  
  private PreparedStatement selectByMotVisita(Object aCondiciones) throws BaseException, SQLException { 
	    final int CODIGO = 1; 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotVisDoc "); 
	    textSQL.append(" WHERE oid_mot_visita = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    MotivoVisita motivo = (MotivoVisita) aCondiciones; 
	    querySelect.setInt(CODIGO, motivo.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotVisDoc "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_vis_doc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMotVisDoc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotivosVisita(
		  MotivoVisita motivo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotivoVisitaDoc.NICKNAME,
             DBMotivoVisitaDoc.SELECT_BY_MOT_VISITA,
             motivo,
             new ListObserver(),
             aSesion);
  }
  
  public static MotivoVisitaDoc getMotivoVisitaDoc(
		  MotivoVisita motivoVisita,
		  TipoDocumentacionCIP tipoDocumentacion,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TipoDocumentacionCIP.NICKNAME, tipoDocumentacion);
	  condiciones.put(MotivoVisita.NICKNAME, motivoVisita);
	  return (MotivoVisitaDoc) ObjetoLogico.getObjects(MotivoVisitaDoc.NICKNAME,
			  				DBMotivoVisitaDoc.VISITA_DOCU,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
