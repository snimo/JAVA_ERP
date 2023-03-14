package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRecluProcesoCandidato extends DBObjetoPersistente {

  public static final String OID_PROCESO_SELEC = "oid_proceso_selec";
  public static final String OID_CANDIDATO_BUSQ = "oid_candidato_busq";
  public static final String ORDEN = "orden";
  public static final String OID_PROCESO = "oid_proceso";
  public static final String OID_CONC_PROCESO = "oid_conc_proceso";
  public static final String COSTO = "costo";
  public static final String OID_EST_PROC_SEL = "oid_est_proc_sel";
  public static final String FECHA_PLANIF = "fecha_planif";
  public static final String HORA_PLANIF = "hora_planif";
  public static final String PERSONA = "persona";
  public static final String OBSERVACIONES = "observaciones";
  public static final String PUEDE_INICIAR = "puede_iniciar";
  public static final String ACTIVO = "activo";
  public static final String NRO_ARCHIVO = "nro_archivo";
  public static final String NOMBRE_ARCHIVO = "nombre_archivo";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String OID_TIPO_FORMU = "oid_tipo_formu";
  public static final String COMPLETO_TIPO_FORMU = "completo_tipo_formu";
  public static final String FEC_COMPLETO_TF = "fec_completo_tf";
  public static final String SE_ANUNCIO = "se_anuncio";
  public static final String FEC_HOR_SE_ANUNCIO = "fec_hor_se_anuncio";
  
  public static final String OID_OPERACION = "oid_operacion";
  public static final String OID_SECTOR = "oid_sector";
  public static final String OID_SELECTOR = "oid_selector";
  
  
  private static final int SELECT_BY_CANDIDATO_BUSQ = 100;
  private static final int SELECT_BY_POSTULANTE = 101;
  private static final int SELECT_BY_CANDIDATO_PROCESO = 102;
  private static final int SELECT_BY_CONDICIONES = 103;
  private static final int SELECT_BY_CONS_RECEPCION = 104;
  

  public DBRecluProcesoCandidato() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROCESO_SELEC = 1;
    final int OID_CANDIDATO_BUSQ = 2;
    final int ORDEN = 3;
    final int OID_PROCESO = 4;
    final int OID_CONC_PROCESO = 5;
    final int COSTO = 6;
    final int OID_EST_PROC_SEL = 7;
    final int FECHA_PLANIF = 8;
    final int HORA_PLANIF = 9;
    final int PERSONA = 10;
    final int OBSERVACIONES = 11;
    final int PUEDE_INICIAR = 12;
    final int ACTIVO = 13;
    final int NRO_ARCHIVO = 14;
    final int NOMBRE_ARCHIVO = 15;
    final int OID_POSTULANTE = 16;
    final int OID_TIPO_FORMU = 17;
    final int COMPLETO_TIPO_FORMU = 18;
    final int FEC_COMPLETO_TF = 19;    
    final int SE_ANUNCIO = 20;
    final int FEC_HOR_SE_ANUNCIO = 21;
    final int OID_OPERACION = 22;
    final int OID_SECTOR = 23;
    final int OID_SELECTOR = 24;

    RecluProcesoCandidato pers = (RecluProcesoCandidato) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsProcesoSelec "+
                     " ( "+
                      "OID_PROCESO_SELEC,"+
                      "OID_CANDIDATO_BUSQ,"+
                      "ORDEN,"+
                      "OID_PROCESO,"+
                      "OID_CONC_PROCESO,"+
                      "COSTO,"+
                      "OID_EST_PROC_SEL,"+
                      "FECHA_PLANIF,"+
                      "HORA_PLANIF,"+
                      "PERSONA,"+
                      "OBSERVACIONES,"+
                      "PUEDE_INICIAR,"+
                      "ACTIVO,NRO_ARCHIVO,NOMBRE_ARCHIVO,OID_POSTULANTE,OID_TIPO_FORMU,COMPLETO_TIPO_FORMU,FEC_COMPLETO_TF,SE_ANUNCIO,FEC_HOR_SE_ANUNCIO,OID_OPERACION,OID_SECTOR,OID_SELECTOR) "+ 
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
    qInsert.setInt(OID_PROCESO_SELEC,pers.getOID());
    if (pers.getCandidato_busq()!=null)
    	qInsert.setInt(OID_CANDIDATO_BUSQ,pers.getCandidato_busq().getOID());
    else
    	qInsert.setNull(OID_CANDIDATO_BUSQ,Types.INTEGER);
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setInt(OID_PROCESO,pers.getProceso().getOID());
    qInsert.setInt(OID_CONC_PROCESO,pers.getConcepto_proceso().getOID());
    if (pers.getCosto()!=null)
    	qInsert.setDouble(COSTO,pers.getCosto().doubleValue());
    else
    	qInsert.setNull(COSTO,Types.DOUBLE);
    qInsert.setInt(OID_EST_PROC_SEL,pers.getEstado().getOID());
    if (pers.getFecha_planif()!=null) 
      qInsert.setDate(FECHA_PLANIF,new java.sql.Date(pers.getFecha_planif().getTime()));
    else
      qInsert.setNull(FECHA_PLANIF,java.sql.Types.DATE);
    qInsert.setString(HORA_PLANIF,pers.getHora_planif());
    qInsert.setString(PERSONA,pers.getPersona());
    qInsert.setString(OBSERVACIONES,pers.getObservaciones());
    if (pers.isPuede_iniciar()!=null)
    	qInsert.setBoolean(PUEDE_INICIAR,pers.isPuede_iniciar().booleanValue());
    else
    	qInsert.setBoolean(PUEDE_INICIAR,false);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroArchivo()!=null)
    	qInsert.setInt(NRO_ARCHIVO, pers.getNroArchivo().intValue());
    else
    	qInsert.setNull(NRO_ARCHIVO, Types.INTEGER);
    if (pers.getNombreArchivo()!=null)
    	qInsert.setString(NOMBRE_ARCHIVO, pers.getNombreArchivo());
    else
    	qInsert.setNull(NOMBRE_ARCHIVO, Types.VARCHAR);
    if (pers.getRecluPostulante()!=null)
    	qInsert.setInt(OID_POSTULANTE, pers.getRecluPostulante().getOIDInteger());
    else
    	qInsert.setNull(OID_POSTULANTE, Types.INTEGER);
    
    if (pers.getTipoFormulario()!=null)
    	qInsert.setInt(OID_TIPO_FORMU , pers.getTipoFormulario().getOID());
    else
    	qInsert.setNull(OID_TIPO_FORMU , Types.INTEGER);
    if (pers.isCompletoTipoFormulario()!=null)
    	qInsert.setBoolean(COMPLETO_TIPO_FORMU , pers.isCompletoTipoFormulario());
    else
    	qInsert.setBoolean(COMPLETO_TIPO_FORMU , false);
    if (pers.getCompletoTipoFormulario()!=null)
    	qInsert.setDate(FEC_COMPLETO_TF , new java.sql.Date(pers.getCompletoTipoFormulario().getTime()));
    else
    	qInsert.setNull(FEC_COMPLETO_TF , Types.DATE);
    
    if (pers.isSeAnuncio()!=null)
    	qInsert.setBoolean(SE_ANUNCIO , pers.isSeAnuncio());
    else
    	qInsert.setBoolean(SE_ANUNCIO , false);    
    
    if (pers.getFecHorSeAnuncio()!=null)
    	qInsert.setTimestamp(FEC_HOR_SE_ANUNCIO, new java.sql.Timestamp(pers.getFecHorSeAnuncio().getTime()));
    else
    	qInsert.setNull(FEC_HOR_SE_ANUNCIO, Types.TIMESTAMP);    
    
    if (pers.getOperacion()!=null)
    	qInsert.setInt(OID_OPERACION, pers.getOperacion().getOID()); 
    else
    	qInsert.setNull(OID_OPERACION, Types.INTEGER);    
    
    if (pers.getSector()!=null)
    	qInsert.setInt(OID_SECTOR, pers.getSector().getOID()); 
    else
    	qInsert.setNull(OID_SECTOR, Types.INTEGER);    
    
    if (pers.getSelector()!=null)
    	qInsert.setInt(OID_SELECTOR, pers.getSelector().getOID()); 
    else
    	qInsert.setNull(OID_SELECTOR, Types.INTEGER);    
    
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CANDIDATO_BUSQ = 1;
    final int ORDEN = 2;
    final int OID_PROCESO = 3;
    final int OID_CONC_PROCESO = 4;
    final int COSTO = 5;
    final int OID_EST_PROC_SEL = 6;
    final int FECHA_PLANIF = 7;
    final int HORA_PLANIF = 8;
    final int PERSONA = 9;
    final int OBSERVACIONES = 10;
    final int PUEDE_INICIAR = 11;
    final int ACTIVO = 12;
    final int NRO_ARCHIVO = 13;
    final int NOMBRE_ARCHIVO = 14;
    final int OID_POSTULANTE = 15;
    final int OID_TIPO_FORMU = 16;
    final int COMPLETO_TIPO_FORMU = 17;
    final int FEC_COMPLETO_TF = 18;   
    final int SE_ANUNCIO = 19;
    final int FEC_HOR_SE_ANUNCIO = 20;
    final int OID_OPERACION = 21;
    final int OID_SECTOR = 22;
    final int OID_SELECTOR = 23;    
    final int OID_PROCESO_SELEC = 24;

    RecluProcesoCandidato pers = (RecluProcesoCandidato) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsProcesoSelec set "+
              "oid_candidato_busq=?"+ 
              ",orden=?"+ 
              ",oid_proceso=?"+ 
              ",oid_conc_proceso=?"+ 
              ",costo=?"+ 
              ",oid_est_proc_sel=?"+ 
              ",fecha_planif=?"+ 
              ",hora_planif=?"+ 
              ",persona=?"+ 
              ",observaciones=?"+ 
              ",puede_iniciar=?"+ 
              ",activo=?"+ 
              ",nro_archivo=?"+
              ",nombre_archivo=?"+
              ",oid_postulante=?"+
              ",oid_tipo_formu=?,completo_tipo_formu=?,fec_completo_tf=?,SE_ANUNCIO=?,FEC_HOR_SE_ANUNCIO=? , oid_operacion = ? , oid_sector = ? , oid_selector = ? "+
                 " where " +
                 " oid_proceso_selec=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_SELEC,pers.getOID());
    if (pers.getCandidato_busq()!=null)
    	qUpdate.setInt(OID_CANDIDATO_BUSQ,pers.getCandidato_busq().getOID());
    else
    	qUpdate.setNull(OID_CANDIDATO_BUSQ,Types.INTEGER);
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setInt(OID_PROCESO,pers.getProceso().getOID());
    qUpdate.setInt(OID_CONC_PROCESO,pers.getConcepto_proceso().getOID());
    if (pers.getCosto()!=null)
    	qUpdate.setDouble(COSTO,pers.getCosto().doubleValue());
    else
    	qUpdate.setNull(COSTO,Types.DOUBLE);
    qUpdate.setInt(OID_EST_PROC_SEL,pers.getEstado().getOID());
    if (pers.getFecha_planif()!=null) 
      qUpdate.setDate(FECHA_PLANIF,new java.sql.Date(pers.getFecha_planif().getTime()));
    else
      qUpdate.setNull(FECHA_PLANIF,java.sql.Types.DATE);
    qUpdate.setString(HORA_PLANIF,pers.getHora_planif());
    qUpdate.setString(PERSONA,pers.getPersona());
    qUpdate.setString(OBSERVACIONES,pers.getObservaciones());
    if (pers.isPuede_iniciar()!=null)
    	qUpdate.setBoolean(PUEDE_INICIAR,pers.isPuede_iniciar().booleanValue());
    else
    	qUpdate.setBoolean(PUEDE_INICIAR,false);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroArchivo()!=null)
    	qUpdate.setInt(NRO_ARCHIVO, pers.getNroArchivo().intValue());
    else
    	qUpdate.setNull(NRO_ARCHIVO, Types.INTEGER);
    if (pers.getNombreArchivo()!=null)
    	qUpdate.setString(NOMBRE_ARCHIVO, pers.getNombreArchivo());
    else
    	qUpdate.setNull(NOMBRE_ARCHIVO, Types.VARCHAR);    
    if (pers.getRecluPostulante()!=null)
    	qUpdate.setInt(OID_POSTULANTE, pers.getRecluPostulante().getOIDInteger());
    else
    	qUpdate.setNull(OID_POSTULANTE, Types.INTEGER);
    
    if (pers.getTipoFormulario()!=null)
    	qUpdate.setInt(OID_TIPO_FORMU , pers.getTipoFormulario().getOID());
    else
    	qUpdate.setNull(OID_TIPO_FORMU , Types.INTEGER);
    if (pers.isCompletoTipoFormulario()!=null)
    	qUpdate.setBoolean(COMPLETO_TIPO_FORMU , pers.isCompletoTipoFormulario());
    else
    	qUpdate.setBoolean(COMPLETO_TIPO_FORMU , false);
    if (pers.getCompletoTipoFormulario()!=null)
    	qUpdate.setDate(FEC_COMPLETO_TF , new java.sql.Date(pers.getCompletoTipoFormulario().getTime()));
    else
    	qUpdate.setNull(FEC_COMPLETO_TF , Types.DATE);    
    if (pers.isSeAnuncio()!=null)
    	qUpdate.setBoolean(SE_ANUNCIO , pers.isSeAnuncio());
    else
    	qUpdate.setBoolean(SE_ANUNCIO , false);    
    
    if (pers.getFecHorSeAnuncio()!=null)
    	qUpdate.setTimestamp(FEC_HOR_SE_ANUNCIO, new java.sql.Timestamp(pers.getFecHorSeAnuncio().getTime()));
    else
    	qUpdate.setNull(FEC_HOR_SE_ANUNCIO, Types.TIMESTAMP);
    
    if (pers.getOperacion()!=null)
    	qUpdate.setInt(OID_OPERACION, pers.getOperacion().getOID()); 
    else
    	qUpdate.setNull(OID_OPERACION, Types.INTEGER);    
    
    if (pers.getSector()!=null)
    	qUpdate.setInt(OID_SECTOR, pers.getSector().getOID()); 
    else
    	qUpdate.setNull(OID_SECTOR, Types.INTEGER);    
    
    if (pers.getSelector()!=null)
    	qUpdate.setInt(OID_SELECTOR, pers.getSelector().getOID()); 
    else
    	qUpdate.setNull(OID_SELECTOR, Types.INTEGER);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO_SELEC = 1; 
    RecluProcesoCandidato pers = (RecluProcesoCandidato) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProcesoSelec "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proceso_selec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_SELEC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO_SELEC = 1; 
    RecluProcesoCandidato pers = (RecluProcesoCandidato) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProcesoSelec "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proceso_selec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_SELEC, pers.getOID()); 
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
      case SELECT_BY_CANDIDATO_BUSQ: {
          ps = this.selectByCandidatoBusq(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_POSTULANTE: {
          ps = this.selectByPostulante(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CANDIDATO_PROCESO: {
          ps = this.selectByCandidatoProceso(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CONS_RECEPCION: {
          ps = this.selectByConsRecepcion(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROCESO_SELEC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
    textSQL.append(" WHERE oid_proceso_selec = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROCESO_SELEC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCandidatoProceso(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	RecluCandidatoBusq candidatoBusq = (RecluCandidatoBusq) condiciones.get(RecluCandidatoBusq.NICKNAME);
	  	RecluProceso proceso = (RecluProceso) condiciones.get(RecluProceso.NICKNAME);
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
	    textSQL.append(" WHERE oid_candidato_busq  = ? and oid_proceso = ? and activo=1  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, candidatoBusq.getOID());
	    querySelect.setInt(2, proceso.getOID());
	    
	    return querySelect;
	    
  }  
  
  
  private PreparedStatement selectByCandidatoBusq(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
	    textSQL.append(" WHERE oid_candidato_busq  = ? and activo=1 order by oid_proceso_selec desc   "); // Para que traiga el ultimo procesado
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluCandidatoBusq candidatoBusq = (RecluCandidatoBusq) aCondiciones; 
	    querySelect.setInt(1, candidatoBusq.getOID()); 
	    return querySelect;
	    
  }  
  
  private PreparedStatement selectByConsRecepcion(Object aCondiciones) throws BaseException, SQLException {
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcesoSelec where activo=1 and fecha_planif>=? and fecha_planif<=? and oid_proceso in (select oid_proceso from rsProceso where visu_cons_recepcion=1) "); 
	    
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByPostulante(Object aCondiciones) throws BaseException, SQLException {
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
	    textSQL.append(" WHERE oid_postulante = ? and activo=1   ");
	    textSQL.append(" union ");
	    textSQL.append("SELECT a.* FROM  rsProcesoSelec a, rsCandidatoBusq b "); 
	    textSQL.append(" WHERE a.oid_candidato_busq = b.oid_candidato_busq and b.oid_postulante = ? and a.activo=1 and b.activo=1  ");	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluPostulante postulante = (RecluPostulante) aCondiciones; 
	    querySelect.setInt(1, postulante.getOID()); 
	    querySelect.setInt(2, postulante.getOID());
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  
	  	java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	  	java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	  	
	  	RecluOperacion operacion = (RecluOperacion) condiciones.get(RecluOperacion.NICKNAME);
	  	RecluSectores sector = (RecluSectores) condiciones.get(RecluSectores.NICKNAME);
	  	RecluSelector selector = (RecluSelector) condiciones.get(RecluSelector.NICKNAME);
	  	
	  	List listaEstados = (List) condiciones.get("LISTA_ESTADOS_PROCESOS");
	  	List listaProcesos = (List) condiciones.get("LISTA_PROCESOS");
	  	
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
	    
	    if (condiciones.containsKey("INCLUIR_PROC_SIN_FEC_PLANIF")) {
	    	textSQL.append(" WHERE ((fecha_planif  >=? and fecha_planif<=?) or (fecha_planif is null))  and activo=1 ");
	    } else
	    	textSQL.append(" WHERE fecha_planif  >=? and fecha_planif<=? and activo=1 ");
	    
	    
	    
	    
	    if ((listaEstados!=null) && (listaEstados.size()>0)) {
	    	String oidEstados = "-1";
	    	Iterator iterEstados = listaEstados.iterator();
	    	while (iterEstados.hasNext()) {
	    		RecluEstadoProceso recluEstadoProceso = (RecluEstadoProceso) iterEstados.next();
	    		oidEstados = oidEstados + ","+recluEstadoProceso.getOIDInteger().toString();
	    	}
	    	textSQL.append(" and oid_est_proc_sel in ("+oidEstados+") "); 
	    }
	    
	    if ((listaProcesos!=null) && (listaProcesos.size()>0)) {
	    	String oidProcesos = "-1";
	    	Iterator iterProcesos = listaProcesos.iterator();
	    	while (iterProcesos.hasNext()) {
	    		RecluProceso recluProceso = (RecluProceso) iterProcesos.next();
	    		oidProcesos = oidProcesos+ ","+recluProceso.getOIDInteger().toString();
	    	}
	    	textSQL.append(" and oid_proceso in ("+oidProcesos+") "); 
	    }	    
	    
	    // Restringir segun perfiles del Usuario
	    String oidOperHabilitada = " (-1";
	    Iterator iterOperacion = RecluOperacion.getOperacionesParaVisualizarDelUsuario(this.getSesion()).iterator();
	    while (iterOperacion.hasNext()) {
	    	RecluOperacion operHabilitada = (RecluOperacion) iterOperacion.next();
	    	oidOperHabilitada = oidOperHabilitada + ","+operHabilitada.getOIDInteger();
	    }
	    oidOperHabilitada = oidOperHabilitada + ") ";
	    textSQL.append(" and oid_candidato_busq in (  select a2.oid_candidato_busq from rsBusquedaActiva a1 , rsCandidatoBusq a2 where a1.activo=1 and a2.activo=1 and a1.oid_busqueda_act = a2.oid_busqueda_act and a1.oid_operacion in "+oidOperHabilitada+") ");
	    
	    if ((operacion!=null) || (sector!=null) || (selector!=null)) {
	    	
	    	textSQL.append(" and ((oid_candidato_busq in (  select a2.oid_candidato_busq from rsBusquedaActiva a1 , rsCandidatoBusq a2 where a1.activo=1 and a2.activo=1 and a1.oid_busqueda_act = a2.oid_busqueda_act  ");
	    	if (operacion!=null)
	    		textSQL.append("  and a1.oid_operacion = "+operacion.getOIDInteger()+" ");
	    	if (sector!=null)
	    		textSQL.append("  and a1.oid_sector = "+sector.getOIDInteger()+" ");
	    	if (selector!=null)
	    		textSQL.append("  and a1.oid_selector = "+selector.getOIDInteger()+" ");
	    	textSQL.append(" )) ");

	    	
	    	textSQL.append(" or (");
	    	
	    	boolean agregoCond = false;
	    	if (operacion!=null) {
	    		if (agregoCond==true)
	    			textSQL.append(" and ");
	    		textSQL.append("   oid_operacion = "+operacion.getOIDInteger()+" ");
	    		agregoCond = true;
	    	}
	    	if (sector!=null) {
	    		if (agregoCond==true)
	    			textSQL.append(" and ");	    		
	    		textSQL.append("   oid_sector = "+sector.getOIDInteger()+" ");
	    		agregoCond = true;
	    	}
	    	if (selector!=null) {
	    		if (agregoCond==true)
	    			textSQL.append(" and ");	    		
	    		textSQL.append("   oid_selector = "+selector.getOIDInteger()+" ");
	    		agregoCond = true;
	    	}
	    	
	    	textSQL.append(")) ");
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	    if (condiciones.containsKey("ABIERTAS") || condiciones.containsKey("CERRADAS")) {
	    	
	    	String condEstadoBusq = "''";
	    	if (condiciones.containsKey("ABIERTAS")) {
	    		if (condEstadoBusq.length()>0)
	    			condEstadoBusq = condEstadoBusq + ",";	    		
	    		condEstadoBusq = condEstadoBusq + "'"+RecluBusqueda.getEstadoBusqAbierta()+"' ";
	    	}
	    	if (condiciones.containsKey("CERRADAS")) {
	    		if (condEstadoBusq.length()>0)
	    			condEstadoBusq = condEstadoBusq + ",";
	    		condEstadoBusq = condEstadoBusq + "'"+RecluBusqueda.getEstadoBusqCerrada()+"' ";
	    	}
	    	
	    	textSQL.append(" and oid_candidato_busq in (  select a2.oid_candidato_busq from rsBusquedaActiva a1 , rsCandidatoBusq a2 where a1.activo=1 and a2.activo=1 and a1.oid_busqueda_act = a2.oid_busqueda_act and a1.estado_busqueda in ("+condEstadoBusq+")) ");	
	    	
	    	
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProcesoSelec "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proceso_selec oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsProcesoSelec");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProcesosCandidato(RecluCandidatoBusq aRecluCandidatoBusq,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcesoCandidato.NICKNAME,
             DBRecluProcesoCandidato.SELECT_BY_CANDIDATO_BUSQ,
             aRecluCandidatoBusq,
             new ListObserver(),
             aSesion);
  }
  
  public static List getRecluProcesoCandidato(RecluPostulante postulante,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcesoCandidato.NICKNAME,
             DBRecluProcesoCandidato.SELECT_BY_POSTULANTE,
             postulante,
             new ListObserver(),
             aSesion);
  }
  
  public static List getRecluProcesoCandidatoByCondiciones(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcesoCandidato.NICKNAME,
             DBRecluProcesoCandidato.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getRecluProcesosRecepcion(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcesoCandidato.NICKNAME,
             DBRecluProcesoCandidato.SELECT_BY_CONS_RECEPCION,
             condiciones,
             new ListObserver(),
             aSesion);
  }   
  
  public static RecluProcesoCandidato getProcesoCandidato(
		  RecluCandidatoBusq recluCandidatoBusq,
		  RecluProceso recluProceso,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(RecluCandidatoBusq.NICKNAME, recluCandidatoBusq);
	  condiciones.put(RecluProceso.NICKNAME, recluProceso);
	  
	  return (RecluProcesoCandidato) ObjetoLogico.getObjects(RecluProcesoCandidato.NICKNAME,
			  				DBRecluProcesoCandidato.SELECT_BY_CANDIDATO_PROCESO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
  
} 
