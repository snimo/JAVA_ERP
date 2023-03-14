package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.GrupoVisita;
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

public class DBDocumentacionVisitaCIP extends DBObjetoPersistente {

  public static final String OID_DOCU_VISITA = "oid_docu_visita";
  public static final String OID_VISITA = "oid_visita";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String CONTROLA_FECHA = "controla_fecha";
  public static final String FEC_VTO = "fec_vto";
  public static final String OBSERVACION = "observacion";
  public static final String ACTIVO = "activo";
  public static final String PRESENTADO = "presentado";
  public static final String FEC_PRESENT = "fec_present";
  public static final String FEC_EMISION = "fec_emision";
  public static final String OID_GRUPO_VISITA = "oid_grupo_visita";
  
  public static final int SELECT_BY_VISITA = 100;
  public static final int SELECT_BY_GRUPOVISITA = 101;
  public static final int SELECT_VIS_TIPO_FEC = 102;
  
  
  public DBDocumentacionVisitaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DOCU_VISITA = 1;
    final int OID_VISITA = 2;
    final int OID_TIPO_DOCU = 3;
    final int CONTROLA_FECHA = 4;
    final int FEC_VTO = 5;
    final int OBSERVACION = 6;
    final int ACTIVO = 7;
    final int PRESENTADO = 8;
    final int FEC_PRESENT = 9;
    final int FEC_EMISION = 10;
    final int OID_GRUPO_VISITA = 11;

    DocumentacionVisitaCIP pers = (DocumentacionVisitaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipDocuVisita "+
                     " ( "+
                      "OID_DOCU_VISITA,"+
                      "OID_VISITA,"+
                      "OID_TIPO_DOCU,"+
                      "CONTROLA_FECHA,"+
                      "FEC_VTO,"+
                      "OBSERVACION,"+
                      "ACTIVO , PRESENTADO , FEC_PRESENT , FEC_EMISION , OID_GRUPO_VISITA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DOCU_VISITA,pers.getOID());
    if (pers.getVistat()!=null)
    	qInsert.setInt(OID_VISITA,pers.getVistat().getOID());
    else
    	qInsert.setNull(OID_VISITA,Types.INTEGER);
    qInsert.setInt(OID_TIPO_DOCU,pers.getTipo_documentacion().getOID());
    qInsert.setBoolean(CONTROLA_FECHA,pers.isControla_fecha().booleanValue());
    if (pers.getFec_vto()!=null) 
      qInsert.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    else
      qInsert.setNull(FEC_VTO,java.sql.Types.DATE);
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isPresentado()!=null)
    	qInsert.setBoolean(PRESENTADO, pers.isPresentado());
    else
    	qInsert.setBoolean(PRESENTADO, false);
    if (pers.getFecPresentacion()!=null)
    	qInsert.setDate(FEC_PRESENT, new java.sql.Date(pers.getFecPresentacion().getTime()));
    else
    	qInsert.setNull(FEC_PRESENT, java.sql.Types.DATE);
    if (pers.getFecEmision()!=null)
    	qInsert.setDate(FEC_EMISION, new java.sql.Date(pers.getFecEmision().getTime()));
    else
    	qInsert.setNull(FEC_EMISION, java.sql.Types.DATE);
    if (pers.getGrupoVisita()!=null)
    	qInsert.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qInsert.setNull(OID_GRUPO_VISITA, java.sql.Types.INTEGER);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VISITA = 1;
    final int OID_TIPO_DOCU = 2;
    final int CONTROLA_FECHA = 3;
    final int FEC_VTO = 4;
    final int OBSERVACION = 5;
    final int ACTIVO = 6;
    final int PRESENTADO = 7;
    final int FEC_PRESENT = 8;
    final int FEC_EMISION = 9;
    final int OID_GRUPO_VISITA = 10;
    final int OID_DOCU_VISITA = 11;

    DocumentacionVisitaCIP pers = (DocumentacionVisitaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipDocuVisita set "+
              "oid_visita=?"+ 
              ",oid_tipo_docu=?"+ 
              ",controla_fecha=?"+ 
              ",fec_vto=?"+ 
              ",observacion=?"+ 
              ",activo=? , presentado=? , fec_present=? , fec_emision = ? , oid_grupo_visita = ? "+ 
                 " where " +
                 " oid_docu_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DOCU_VISITA,pers.getOID());
    if (pers.getVistat()!=null)
    	qUpdate.setInt(OID_VISITA,pers.getVistat().getOID());
    else
    	qUpdate.setNull(OID_VISITA,Types.INTEGER);
    qUpdate.setInt(OID_TIPO_DOCU,pers.getTipo_documentacion().getOID());
    qUpdate.setBoolean(CONTROLA_FECHA,pers.isControla_fecha().booleanValue());
    if (pers.getFec_vto()!=null) 
      qUpdate.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    else
      qUpdate.setNull(FEC_VTO,java.sql.Types.DATE);
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isPresentado()!=null)
    	qUpdate.setBoolean(PRESENTADO, pers.isPresentado());
    else
    	qUpdate.setBoolean(PRESENTADO, false);
    if (pers.getFecPresentacion()!=null)
    	qUpdate.setDate(FEC_PRESENT, new java.sql.Date(pers.getFecPresentacion().getTime()));
    else
    	qUpdate.setNull(FEC_PRESENT, java.sql.Types.DATE);    
    if (pers.getFecEmision()!=null)
    	qUpdate.setDate(FEC_EMISION, new java.sql.Date(pers.getFecEmision().getTime()));
    else
    	qUpdate.setNull(FEC_EMISION, java.sql.Types.DATE);
    if (pers.getGrupoVisita()!=null)
    	qUpdate.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qUpdate.setNull(OID_GRUPO_VISITA, java.sql.Types.INTEGER);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DOCU_VISITA = 1; 
    DocumentacionVisitaCIP pers = (DocumentacionVisitaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipDocuVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_docu_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DOCU_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DOCU_VISITA = 1; 
    DocumentacionVisitaCIP pers = (DocumentacionVisitaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipDocuVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_docu_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DOCU_VISITA, pers.getOID()); 
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
      case SELECT_BY_VISITA: {
          ps = this.selectByVisita(aCondiciones); 
          break; 
      }
      case SELECT_BY_GRUPOVISITA: {
          ps = this.selectByGrupoVisita(aCondiciones); 
          break; 
      }   
      case SELECT_VIS_TIPO_FEC: {
          ps = this.selectByVisTipFec(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DOCU_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipDocuVisita "); 
    textSQL.append(" WHERE oid_docu_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DOCU_VISITA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByGrupoVisita(Object aCondiciones) throws BaseException, SQLException { 
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cipDocuVisita "); 
		textSQL.append(" WHERE oid_grupo_visita = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		GrupoVisita grupoVisita = (GrupoVisita) aCondiciones; 
		querySelect.setInt(1, grupoVisita.getOID()); 
		return querySelect; 
  }

  
  private PreparedStatement selectByVisTipFec(Object aCondiciones) throws BaseException, SQLException { 
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	TipoDocumentacionCIP tipoDocumentacion = (TipoDocumentacionCIP) condiciones.get(TipoDocumentacionCIP.NICKNAME);
	  	Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	  	java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	  	
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cipDocuVisita "); 
		textSQL.append(" WHERE ");
		textSQL.append(" (oid_visita = ? and oid_tipo_docu = ? activo=1 and controla_fecha = 0) ");
		textSQL.append(" or ");
		textSQL.append(" WHERE (oid_visita = ? and oid_tipo_docu = ? activo=1 and controla_fecha = 1 and ?<=fec_vto ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		querySelect.setInt(1, visita.getOID()); 
		querySelect.setInt(2, tipoDocumentacion.getOID());
		querySelect.setInt(3, visita.getOID());
		querySelect.setInt(4, tipoDocumentacion.getOID());
		querySelect.setDate(5, new java.sql.Date(fecha.getTime()));
		return querySelect; 
  }
  
  private PreparedStatement selectByVisita(Object aCondiciones) throws BaseException, SQLException { 
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  cipDocuVisita "); 
		textSQL.append(" WHERE oid_visita = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		Visita visita = (Visita) aCondiciones; 
		querySelect.setInt(1, visita.getOID()); 
		return querySelect; 
  }
		  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipDocuVisita "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_docu_visita oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipDocuVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDocumentacion(Visita aVisita,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DocumentacionVisitaCIP.NICKNAME,
			  DBDocumentacionVisitaCIP.SELECT_BY_VISITA,
			  aVisita,
			  new ListObserver(),
			  aSesion);
  }
  
  public static List getDocumentacion(GrupoVisita aGrupoVisita,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DocumentacionVisitaCIP.NICKNAME,
			  DBDocumentacionVisitaCIP.SELECT_BY_GRUPOVISITA,
			  aGrupoVisita,
			  new ListObserver(),
			  aSesion);
  }
  
  public static DocumentacionVisitaCIP getDocumentacion(
		  java.util.Date fecha,
		  Visita visita,
		  TipoDocumentacionCIP tipoDocu,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA", fecha);
	  condiciones.put(Visita.NICKNAME, visita);
	  condiciones.put(TipoDocumentacionCIP.NICKNAME, tipoDocu);
	  return (DocumentacionVisitaCIP) ObjetoLogico.getObjects(DocumentacionVisitaCIP.NICKNAME,
			  				DBDocumentacionVisitaCIP.SELECT_VIS_TIPO_FEC,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
