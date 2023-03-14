package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
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

public class DBRecluCandidatoBusq extends DBObjetoPersistente {

  public static final String OID_CANDIDATO_BUSQ = "oid_candidato_busq";
  public static final String OID_BUSQUEDA_ACT = "oid_busqueda_act";
  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String FEC_ASIGNO = "fec_asigno";
  public static final String HORA_ASIGNO = "hora_asigno";
  public static final String OID_USU_ASIGNO = "oid_usu_asigno";
  public static final String OID_EST_CAND_BUSQ = "oid_est_cand_busq";
  public static final String COMENTARIO = "comentario";
  public static final String OID_MOT_EST_CAND = "oid_mot_est_cand";
  public static final String ACTIVO = "activo";
  public static final String FEC_INGRESO = "fec_ingreso";
  
  
  private static final int SELECT_BY_BUSQUEDA_ACT = 100;
  private static final int SELECT_BY_CONDICIONES = 101;
  private static final int SELECT_BY_RESULT_BUSQUEDA = 102;	

  public DBRecluCandidatoBusq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CANDIDATO_BUSQ = 1;
    final int OID_BUSQUEDA_ACT = 2;
    final int OID_POSTULANTE = 3;
    final int FEC_ASIGNO = 4;
    final int HORA_ASIGNO = 5;
    final int OID_USU_ASIGNO = 6;
    final int OID_EST_CAND_BUSQ = 7;
    final int COMENTARIO = 8;
    final int ACTIVO = 9;
    final int OID_MOT_EST_CAND = 10;
    final int FEC_INGRESO = 11;

    RecluCandidatoBusq pers = (RecluCandidatoBusq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsCandidatoBusq "+
                     " ( "+
                      "OID_CANDIDATO_BUSQ,"+
                      "OID_BUSQUEDA_ACT,"+
                      "OID_POSTULANTE,"+
                      "FEC_ASIGNO,"+
                      "HORA_ASIGNO,"+
                      "OID_USU_ASIGNO,"+
                      "OID_EST_CAND_BUSQ,"+
                      "COMENTARIO,"+
                      "ACTIVO,OID_MOT_EST_CAND,FEC_INGRESO)"+ 
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
    qInsert.setInt(OID_CANDIDATO_BUSQ,pers.getOID());
    qInsert.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qInsert.setInt(OID_POSTULANTE,pers.getOid_postulante().getOID());
    qInsert.setDate(FEC_ASIGNO,new java.sql.Date(pers.getFec_asigno().getTime()));
    qInsert.setString(HORA_ASIGNO,pers.getHora_asigno());
    qInsert.setInt(OID_USU_ASIGNO,pers.getUsuario_asigno().getOID());
    qInsert.setInt(OID_EST_CAND_BUSQ,pers.getEstado_busqueda().getOID());
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO,pers.getComentario());
    else
    	qInsert.setNull(COMENTARIO,Types.VARCHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMotivo()!=null)
    	qInsert.setInt(OID_MOT_EST_CAND, pers.getMotivo().getOID());
    else
    	qInsert.setNull(OID_MOT_EST_CAND, Types.INTEGER);
    if (pers.getFechaIngreso()!=null)
    	qInsert.setDate(FEC_INGRESO, new java.sql.Date(pers.getFechaIngreso().getTime()));
    else
    	qInsert.setNull(FEC_INGRESO, Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BUSQUEDA_ACT = 1;
    final int OID_POSTULANTE = 2;
    final int FEC_ASIGNO = 3;
    final int HORA_ASIGNO = 4;
    final int OID_USU_ASIGNO = 5;
    final int OID_EST_CAND_BUSQ = 6;
    final int COMENTARIO = 7;
    final int ACTIVO = 8;
    final int OID_MOT_EST_CAND = 9;
    final int FEC_INGRESO = 10;
    final int OID_CANDIDATO_BUSQ = 11;
    
     

    RecluCandidatoBusq pers = (RecluCandidatoBusq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsCandidatoBusq set "+
              "oid_busqueda_act=?"+ 
              ",oid_postulante=?"+ 
              ",fec_asigno=?"+ 
              ",hora_asigno=?"+ 
              ",oid_usu_asigno=?"+ 
              ",oid_est_cand_busq=?"+ 
              ",comentario=?"+ 
              ",activo=?"+ 
              ",oid_mot_est_cand=?"+
              ",fec_ingreso=?"+
                 " where " +
                 " oid_candidato_busq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CANDIDATO_BUSQ,pers.getOID());
    qUpdate.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qUpdate.setInt(OID_POSTULANTE,pers.getOid_postulante().getOID());
    qUpdate.setDate(FEC_ASIGNO,new java.sql.Date(pers.getFec_asigno().getTime()));
    qUpdate.setString(HORA_ASIGNO,pers.getHora_asigno());
    qUpdate.setInt(OID_USU_ASIGNO,pers.getUsuario_asigno().getOID());
    qUpdate.setInt(OID_EST_CAND_BUSQ,pers.getEstado_busqueda().getOID());
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO,pers.getComentario());
    else
    	qUpdate.setNull(COMENTARIO,Types.VARCHAR);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMotivo()!=null)
    	qUpdate.setInt(OID_MOT_EST_CAND, pers.getMotivo().getOID());
    else
    	qUpdate.setNull(OID_MOT_EST_CAND, Types.INTEGER);
    if (pers.getFechaIngreso()!=null)
    	qUpdate.setDate(FEC_INGRESO, new java.sql.Date(pers.getFechaIngreso().getTime()));
    else
    	qUpdate.setNull(FEC_INGRESO, Types.DATE);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CANDIDATO_BUSQ = 1; 
    RecluCandidatoBusq pers = (RecluCandidatoBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCandidatoBusq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_candidato_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CANDIDATO_BUSQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CANDIDATO_BUSQ = 1; 
    RecluCandidatoBusq pers = (RecluCandidatoBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsCandidatoBusq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_candidato_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CANDIDATO_BUSQ, pers.getOID()); 
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
      case SELECT_BY_BUSQUEDA_ACT: {
          ps = this.selectByBusquedaActiva(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_RESULT_BUSQUEDA: {
          ps = this.selectByResultBusq(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CANDIDATO_BUSQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCandidatoBusq "); 
    textSQL.append(" WHERE oid_candidato_busq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CANDIDATO_BUSQ, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByBusquedaActiva(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsCandidatoBusq "); 
	    textSQL.append(" WHERE oid_busqueda_act = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluBusqueda busqueda = (RecluBusqueda) aCondiciones; 
	    querySelect.setInt(1, busqueda.getOID()); 
	    return querySelect; 
	  }  
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
	  
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 
	    int param = 0;
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT a.* FROM  rsCandidatoBusq a , rsBusquedaActiva b , rspostulante c "); 
	    textSQL.append(" WHERE a.activo = 1 and a.oid_busqueda_act = b.oid_busqueda_act and b.activo = 1 and c.activo=1 and a.oid_postulante = c.oid_postulante  ");
	    
	    
	    RecluPostulante recluPostulante = (RecluPostulante) condiciones.get(RecluPostulante.NICKNAME);
	    if (recluPostulante!=null) {
	    	textSQL.append(" and a.oid_postulante="+recluPostulante.getOIDInteger().toString()+" ");
	    }
	    
	    RecluOperacion recluOperacion = (RecluOperacion) condiciones.get(RecluOperacion.NICKNAME);
	    if (recluOperacion!=null) {
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_operacion = "+recluOperacion.getOIDInteger().toString()+") ");
	    }
	    
	    String condINOperacion = " b.oid_operacion in (-1";
	    Iterator iterOperacionesVisualizar = 
	    		RecluOperacion.getOperacionesParaVisualizarDelUsuario(this.getSesion()).iterator();
	    while (iterOperacionesVisualizar.hasNext()) {
	    	RecluOperacion recluOperVisu = (RecluOperacion) iterOperacionesVisualizar.next();
	    	condINOperacion = condINOperacion +","+recluOperVisu.getOIDInteger(); 
	    }
	    condINOperacion = condINOperacion + ") ";
	    textSQL.append(" and "+condINOperacion);	    
	    						
	    
	    RecluSectores recluSector = (RecluSectores) condiciones.get(RecluSectores.NICKNAME);
	    if (recluSector!=null) {
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_sector = "+recluSector.getOIDInteger().toString()+") ");	    	
	    	
	    }
	    		    
	    
	    RecluBusqueda recluBusqueda = (RecluBusqueda) condiciones.get(RecluBusqueda.NICKNAME);
	    if (recluBusqueda!=null)
	    	textSQL.append(" and a.oid_busqueda_act = "+recluBusqueda.getOIDInteger().toString()+" ");
	    
	    RecluSelector recluSelector = (RecluSelector) condiciones.get(RecluSelector.NICKNAME);
	    if (recluSelector!=null) {
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_selector = "+recluSelector.getOIDInteger().toString()+") ");	    	
	    }
	    
	    RecluPuesto recluPuesto = (RecluPuesto) condiciones.get(RecluPuesto.NICKNAME);
	    if (recluPuesto!=null) {
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_puesto_busqueda = "+recluPuesto.getOIDInteger().toString()+") ");	    	
	    }
	    
	    
	    if (condiciones.containsKey("CODIGO_SEXO")) {
	    	String codigoSexo = condiciones.getString("CODIGO_SEXO");
	    	
	    	
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 ");
	    	if (!codigoSexo.equals(RecluBusqueda.getSexoIndistinto()))
	    			textSQL.append(" and sexo in ('"+codigoSexo+"','"+RecluBusqueda.getSexoIndistinto()+"') ");
	    	textSQL.append(" ) ");
	    	
	    }
	    
	    String buscar = (String) condiciones.get("BUSCAR");
	    if (buscar!=null) {
	    	textSQL.append(" and ");
	    	textSQL.append(" ( ");
	    	textSQL.append(" (upper(c.APE_Y_NOM) like '%"+buscar.toUpperCase()+"%')  ");
	    	textSQL.append(" or ");
	    	textSQL.append(" (c.nro_docu = '"+buscar+"' )");
	    	textSQL.append(" or ");
	    	textSQL.append(" ( a.oid_postulante in (select a3.oid_postulante from rsBusquedaActiva a1, rsPuestoBusqueda a2 , rsCandidatoBusq a3 ");
	    	textSQL.append("                      where a1.oid_puesto_busqueda = a2.oid_puesto_busqueda and a1.oid_busqueda_act = a3.oid_busqueda_act and ");
	    	textSQL.append("                      a1.activo = 1 and a2.activo=1 and a3.activo=1 and Upper(a2.descripcion) like '%"+buscar+"%')) ");
	    	textSQL.append(" or ");
	    	textSQL.append(" ( a.oid_postulante in (select a1.oid_postulante from rspuestoaplica a1, rsPuestoBusqueda a2 "); 
	    	textSQL.append("                      where a1.oid_puesto_busqueda = a2.oid_puesto_busqueda "); 
	    	textSQL.append("                      and a1.activo=1  and a2.activo = 1 and upper(a2.descripcion) like '%"+buscar.toUpperCase()+"%')) ");
	    	
	    	textSQL.append(" ) ");
	    	
	    }
	    
	    // Filtrar por competencias del postulante 
	    String listaIdCompePostu = "";
	    if (condiciones.containsKey("LISTA_COMPE_POSTU")) {
	    	
	    	List listaCompetenciasPostu = (List) condiciones.get("LISTA_COMPE_POSTU");
	    	Iterator iterCompetencias = listaCompetenciasPostu.iterator();
	    	while (iterCompetencias.hasNext()) {
	    		RecluCompetencias recluCompetencia = (RecluCompetencias) iterCompetencias.next();
	    		if (listaIdCompePostu.length()==0)
	    			listaIdCompePostu = recluCompetencia.getOIDInteger().toString();
	    		else
	    			listaIdCompePostu = listaIdCompePostu + ","+recluCompetencia.getOIDInteger().toString();	    			
	    	}
	    	listaIdCompePostu = " ("+listaIdCompePostu+") ";
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("    rsCompePostu c1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("    c1.activo=1 ");
	    	textSQL.append("   and c1.oid_competencia in "+listaIdCompePostu+") ");
	    }	 
	    
	    
	    // Filtrar por postulanciones que aplica
	    String listaIdPostuAplica = "";
	    if (condiciones.containsKey("LISTA_POSTU_APLICA")) {
	    	
	    	List listaPostuAplica = (List) condiciones.get("LISTA_POSTU_APLICA");
	    	Iterator iterPostuAplica = listaPostuAplica.iterator();
	    	while (iterPostuAplica.hasNext()) {
	    		RecluPuesto recluPuestoAplica = (RecluPuesto) iterPostuAplica.next();
	    		if (listaIdPostuAplica.length()==0)
	    			listaIdPostuAplica = recluPuestoAplica.getOIDInteger().toString();
	    		else
	    			listaIdPostuAplica = listaIdPostuAplica + ","+recluPuestoAplica.getOIDInteger().toString();	    			
	    	}
	    	listaIdPostuAplica = " ("+listaIdPostuAplica+") ";
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsPuestoAplica c1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   c1.activo=1 ");
	    	textSQL.append("   and c1.oid_puesto_busqueda in "+listaIdPostuAplica+") ");
	    }	    
	    
	    
	    // Filtrar por postulanciones que aplica
	    String listaIdEstadoCandidato = "";
	    if (condiciones.containsKey("LISTA_ESTADO_CAND")) {
	    	
	    	List listaEstadosCandidaro = (List) condiciones.get("LISTA_ESTADO_CAND");
	    	Iterator iterEstadosCandidatos = listaEstadosCandidaro.iterator();
	    	while (iterEstadosCandidatos.hasNext()) {
	    		RecluEstCandidatoBusq recluEstCandidatoBusq = (RecluEstCandidatoBusq) iterEstadosCandidatos.next();
	    		if (listaIdEstadoCandidato.length()==0)
	    			listaIdEstadoCandidato = recluEstCandidatoBusq.getOIDInteger().toString();
	    		else
	    			listaIdEstadoCandidato = listaIdEstadoCandidato + ","+recluEstCandidatoBusq.getOIDInteger().toString();	    			
	    	}
	    	listaIdEstadoCandidato = " ("+listaIdEstadoCandidato+") ";
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1  ");
	    	textSQL.append("   and a1.oid_est_cand_busq in "+listaIdEstadoCandidato+") ");
	    }
	    
	    
	    // Filtrar por estado de los Procesos
	    String listaIdEstadoProceso = "";
	    if (condiciones.containsKey("LISTA_ESTADO_PROCESO")) {
	    	
	    	List listaEstadosProceso = (List) condiciones.get("LISTA_ESTADO_PROCESO");
	    	Iterator iterEstadosProcesos = listaEstadosProceso.iterator();
	    	while (iterEstadosProcesos.hasNext()) {
	    		RecluEstadoProceso recluEstadoProceso = (RecluEstadoProceso) iterEstadosProcesos.next();
	    		if (listaIdEstadoProceso.length()==0)
	    			listaIdEstadoProceso = recluEstadoProceso.getOIDInteger().toString();
	    		else
	    			listaIdEstadoProceso = listaIdEstadoProceso + ","+recluEstadoProceso.getOIDInteger().toString();	    			
	    	}
	    	listaIdEstadoProceso = " ("+listaIdEstadoProceso+") ";
	    	textSQL.append(" and a.oid_postulante in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   a1.oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rsProcesoSelec a2 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and a2.activo = 1 and a1.oid_candidato_busq = a2.oid_candidato_busq  ");
	    	textSQL.append("   and a2.oid_est_proc_sel in "+listaIdEstadoProceso+") ");
	    }	    
	    
	    
	    
	    if (condiciones.containsKey(RecluEstadoPostulante.NICKNAME)) {
	    	RecluEstadoPostulante recluEstadoPostulante = (RecluEstadoPostulante) condiciones.get(RecluEstadoPostulante.NICKNAME);
	    	textSQL.append("   and c.oid_estado_postu = "+recluEstadoPostulante.getOIDInteger()+" ");
	    }	    
	    
	    
	    // Aplicar filtro si es ES_REFERIDO
	    if (condiciones.containsKey("ES_REFERIDO")) {

	    	String esReferido = (String) condiciones.get("ES_REFERIDO");
	    	
	    	if (esReferido.toUpperCase().equals("SI"))
	    		textSQL.append("   and c.es_referido = 1  ");
	    	else 
	    		textSQL.append("   and c.es_referido = 0  ");
	    }
	    
	    if (condiciones.containsKey("GENERO_POSTULANTE")) {

	    	String generoPostulante = (String) condiciones.get("GENERO_POSTULANTE");
	    	
	    	if (generoPostulante.toUpperCase().equals("M"))
	    		textSQL.append("   and c.sexo = 'M'  ");
	    	else 
	    		textSQL.append("   and c.sexo = 'F'  ");
	    }
	    
	    
	    
	    
	    

	    String listaIdCompe = "";
	    if (condiciones.containsKey("LISTA_COMPETENCIAS")) {
	    	
	    	List listaCompetencias = (List) condiciones.get("LISTA_COMPETENCIAS");
	    	Iterator iterCompetencias = listaCompetencias.iterator();
	    	while (iterCompetencias.hasNext()) {
	    		RecluCompetencias recluCompetencia = (RecluCompetencias) iterCompetencias.next();
	    		if (listaIdCompe.length()==0)
	    			listaIdCompe = recluCompetencia.getOIDInteger().toString();
	    		else
	    			listaIdCompe = listaIdCompe + ","+recluCompetencia.getOIDInteger().toString();	    			
	    	}
	    	listaIdCompe = " ("+listaIdCompe+") ";
	    	
	    	textSQL.append("  and a.oid_postulante in ( select "); 
	    	textSQL.append("    a2.oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("    rsCompeBusqAct a1 , rscandidatobusq a2 ");
	    	textSQL.append("  where "); 
	    	textSQL.append("    a1.oid_busqueda_act = a2.oid_busqueda_act and a1.activo=1 and a2.activo=1 and a1.oid_competencia in "+listaIdCompe+") "); 
	    	
	    }	 
	    
	    
	    
	    if ((condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) &&
	    		(condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada()))) {
	    	
	    	textSQL.append(" and (a.oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"') ");
	    	textSQL.append(" or ");
	    	textSQL.append(" 	 a.oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqCerrada()+"' and fec_cierre>=? and fec_cierre<=? )) ");	    	
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) {
	    
	    	textSQL.append(" and a.oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"') ");
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada())) {
	    	textSQL.append("  and a.oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqCerrada()+"' and fec_cierre>=? and fec_cierre<=? ) ");
	    }
	    

	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    if ((condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada()))) {
	    	
    		java.util.Date fecDesde = (java.util.Date)condiciones.get("FEC_DESDE");
    		java.util.Date fecHasta = (java.util.Date)condiciones.get("FEC_HASTA");
    		++param;
	    	querySelect.setDate(param, new java.sql.Date(fecDesde.getTime()));
	    	++param;
	    	querySelect.setDate(param, new java.sql.Date(fecHasta.getTime()));
	    }	    
	    
	    return querySelect;
	    

	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsCandidatoBusq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByResultBusq(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Integer nroLote = (Integer) condiciones.get("NRO_LOTE");
	    Integer nroDesde = (Integer) condiciones.get("NRO_DESDE");
	    Integer nroHasta = (Integer) condiciones.get("NRO_HASTA");

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT a.* FROM  rsCandidatoBusq a, rsResulBusq b  "); 
	    textSQL.append(" WHERE a.oid_candidato_busq = b.oid_obj_neg  and a.activo=1 and b.activo=1 and b.nro_lote = ? and b.nro_orden>=? and b.nro_orden<=? order by b.nro_orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, nroLote.intValue()); 
	    querySelect.setInt(2, nroDesde.intValue());
	    querySelect.setInt(3, nroHasta.intValue());
	    return querySelect; 
	    
	  }  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_candidato_busq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsCandidatoBusq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCandidatosBusqueda(RecluBusqueda busqueda,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCandidatoBusq.NICKNAME,
			  DBRecluCandidatoBusq.SELECT_BY_BUSQUEDA_ACT,
             busqueda,
             new ListObserver(),
             aSesion);
  }
  
  public static List getCandidatosEnBusqueda(ISesion aSesion,HashTableDatos condiciones) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCandidatoBusq.NICKNAME,
             DBRecluCandidatoBusq.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getCandidatosResultadoBusqueda(ISesion aSesion,HashTableDatos condiciones) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCandidatoBusq.NICKNAME,
             DBRecluCandidatoBusq.SELECT_BY_RESULT_BUSQUEDA,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
