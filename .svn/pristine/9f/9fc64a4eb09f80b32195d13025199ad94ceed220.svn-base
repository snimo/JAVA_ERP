package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
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

public class DBRecluBusqueda extends DBObjetoPersistente {

  public static final String OID_BUSQUEDA_ACT = "oid_busqueda_act";
  public static final String OID_PUESTO_BUSQUEDA = "oid_puesto_busqueda";
  public static final String FEC_INICIO_BUSQ = "fec_inicio_busq";
  public static final String CANT_VACANTES = "cant_vacantes";
  public static final String OID_MOTIVO_BUSQ = "oid_motivo_busq";
  public static final String OBSERVACIONES = "observaciones";
  public static final String OID_OPERACION = "oid_operacion";
  public static final String SUELDO_BRUTO = "sueldo_bruto";
  public static final String ESTADO_BUSQUEDA = "estado_busqueda";
  public static final String SEXO = "sexo";
  public static final String OID_TIPO_CONTRATO = "oid_tipo_contrato";
  public static final String OID_SELECTOR = "oid_selector";
  public static final String OID_EST_APROB_BUSQ = "oid_est_aprob_busq";
  public static final String OID_SECTOR = "oid_sector";
  public static final String FEC_EST_APROB = "fec_est_aprob";
  public static final String OID_CONVENIO = "oid_convenio";
  public static final String FEC_ALTA = "fec_alta";
  public static final String ACTIVO = "activo";
  public static final String OID_MOT_EST_BUSQ = "oid_mot_est_busq";
  public static final String FEC_CIERRE = "fec_cierre";
  
  
  
  private static final int SELECT_BY_CONDICIONES = 100;

  public DBRecluBusqueda() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BUSQUEDA_ACT = 1;
    final int OID_PUESTO_BUSQUEDA = 2;
    final int FEC_INICIO_BUSQ = 3;
    final int CANT_VACANTES = 4;
    final int OID_MOTIVO_BUSQ = 5;
    final int OBSERVACIONES = 6;
    final int OID_OPERACION = 7;
    final int SUELDO_BRUTO = 8;
    final int ESTADO_BUSQUEDA = 9;
    final int SEXO = 10;
    final int OID_TIPO_CONTRATO = 11;
    final int OID_SELECTOR = 12;
    final int OID_EST_APROB_BUSQ = 13;
    final int OID_SECTOR = 14;
    final int FEC_EST_APROB = 15;
    final int OID_CONVENIO = 16;
    final int FEC_ALTA = 17;
    final int ACTIVO = 18;
    final int OID_MOT_EST_BUSQ = 19;
    final int FEC_CIERRE = 20;

    RecluBusqueda pers = (RecluBusqueda) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsBusquedaActiva "+
                     " ( "+
                      "OID_BUSQUEDA_ACT,"+
                      "OID_PUESTO_BUSQUEDA,"+
                      "FEC_INICIO_BUSQ,"+
                      "CANT_VACANTES,"+
                      "OID_MOTIVO_BUSQ,"+
                      "OBSERVACIONES,"+
                      "OID_OPERACION,"+
                      "SUELDO_BRUTO,"+
                      "ESTADO_BUSQUEDA,"+
                      "SEXO,"+
                      "OID_TIPO_CONTRATO,"+
                      "OID_SELECTOR,"+
                      "OID_EST_APROB_BUSQ,"+
                      "OID_SECTOR,"+
                      "FEC_EST_APROB,"+
                      "OID_CONVENIO,"+
                      "FEC_ALTA,"+
                      "ACTIVO,OID_MOT_EST_BUSQ,FEC_CIERRE)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_BUSQUEDA_ACT,pers.getOID());
    qInsert.setInt(OID_PUESTO_BUSQUEDA,pers.getPuesto().getOID());
    qInsert.setDate(FEC_INICIO_BUSQ,new java.sql.Date(pers.getFec_inicio_busq().getTime()));
    qInsert.setInt(CANT_VACANTES,pers.getCant_vacantes().intValue());
    qInsert.setInt(OID_MOTIVO_BUSQ,pers.getMotivo_busq().getOID());
    qInsert.setString(OBSERVACIONES,pers.getObservaciones());
    qInsert.setInt(OID_OPERACION,pers.getOperacion().getOID());
    if (pers.getSueldo_buto()!=null) 
      qInsert.setDouble(SUELDO_BRUTO,pers.getSueldo_buto().doubleValue());
    else
      qInsert.setNull(SUELDO_BRUTO,java.sql.Types.DOUBLE);
    qInsert.setString(ESTADO_BUSQUEDA,pers.getEstado_busqueda());
    qInsert.setString(SEXO,pers.getSexo());
    if (pers.getTipo_contrato()!=null) 
      qInsert.setInt(OID_TIPO_CONTRATO,pers.getTipo_contrato().getOID());
    else
      qInsert.setNull(OID_TIPO_CONTRATO,java.sql.Types.INTEGER);
    if (pers.getSelector()!=null) 
      qInsert.setInt(OID_SELECTOR,pers.getSelector().getOID());
    else
      qInsert.setNull(OID_SELECTOR,java.sql.Types.INTEGER);
    qInsert.setInt(OID_EST_APROB_BUSQ,pers.getEst_aprob_busq().getOID());
    qInsert.setInt(OID_SECTOR,pers.getSector().getOID());
    if (pers.getFec_est_aprob()!=null)
    	qInsert.setDate(FEC_EST_APROB,new java.sql.Date(pers.getFec_est_aprob().getTime()));
    else
    	qInsert.setNull(FEC_EST_APROB,java.sql.Types.DATE);
    if (pers.getConvenio()!=null) 
      qInsert.setInt(OID_CONVENIO,pers.getConvenio().getOID());
    else
      qInsert.setNull(OID_CONVENIO,java.sql.Types.INTEGER);
    qInsert.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMotivoEstado()!=null)
    	qInsert.setInt(OID_MOT_EST_BUSQ,pers.getMotivoEstado().getOID());
    else
    	qInsert.setNull(OID_MOT_EST_BUSQ,Types.INTEGER);
    if (pers.getFechaCierre()!=null)
    	qInsert.setDate(FEC_CIERRE, new java.sql.Date(pers.getFechaCierre().getTime()));
    else
    	qInsert.setNull(FEC_CIERRE, Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PUESTO_BUSQUEDA = 1;
    final int FEC_INICIO_BUSQ = 2;
    final int CANT_VACANTES = 3;
    final int OID_MOTIVO_BUSQ = 4;
    final int OBSERVACIONES = 5;
    final int OID_OPERACION = 6;
    final int SUELDO_BRUTO = 7;
    final int ESTADO_BUSQUEDA = 8;
    final int SEXO = 9;
    final int OID_TIPO_CONTRATO = 10;
    final int OID_SELECTOR = 11;
    final int OID_EST_APROB_BUSQ = 12;
    final int OID_SECTOR = 13;
    final int FEC_EST_APROB = 14;
    final int OID_CONVENIO = 15;
    final int FEC_ALTA = 16;
    final int ACTIVO = 17;
    final int OID_MOT_EST_BUSQ = 18;
    final int FEC_CIERRE = 19;
    final int OID_BUSQUEDA_ACT = 20;

    RecluBusqueda pers = (RecluBusqueda) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsBusquedaActiva set "+
              "oid_puesto_busqueda=?"+ 
              ",fec_inicio_busq=?"+ 
              ",cant_vacantes=?"+ 
              ",oid_motivo_busq=?"+ 
              ",observaciones=?"+ 
              ",oid_operacion=?"+ 
              ",sueldo_bruto=?"+ 
              ",estado_busqueda=?"+ 
              ",sexo=?"+ 
              ",oid_tipo_contrato=?"+ 
              ",oid_selector=?"+ 
              ",oid_est_aprob_busq=?"+ 
              ",oid_sector=?"+ 
              ",fec_est_aprob=?"+ 
              ",oid_convenio=?"+ 
              ",fec_alta=?"+ 
              ",activo=?"+ 
              ",oid_mot_est_busq=?"+
              ",fec_cierre=?"+
                 " where " +
                 " oid_busqueda_act=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BUSQUEDA_ACT,pers.getOID());
    qUpdate.setInt(OID_PUESTO_BUSQUEDA,pers.getPuesto().getOID());
    qUpdate.setDate(FEC_INICIO_BUSQ,new java.sql.Date(pers.getFec_inicio_busq().getTime()));
    qUpdate.setInt(CANT_VACANTES,pers.getCant_vacantes().intValue());
    qUpdate.setInt(OID_MOTIVO_BUSQ,pers.getMotivo_busq().getOID());
    qUpdate.setString(OBSERVACIONES,pers.getObservaciones());
    qUpdate.setInt(OID_OPERACION,pers.getOperacion().getOID());
    if (pers.getSueldo_buto()!=null) 
      qUpdate.setDouble(SUELDO_BRUTO,pers.getSueldo_buto().doubleValue());
    else
      qUpdate.setNull(SUELDO_BRUTO,java.sql.Types.DOUBLE);
    qUpdate.setString(ESTADO_BUSQUEDA,pers.getEstado_busqueda());
    qUpdate.setString(SEXO,pers.getSexo());
    if (pers.getTipo_contrato()!=null) 
      qUpdate.setInt(OID_TIPO_CONTRATO,pers.getTipo_contrato().getOID());
    else
      qUpdate.setNull(OID_TIPO_CONTRATO,java.sql.Types.INTEGER);
    if (pers.getSelector()!=null) 
      qUpdate.setInt(OID_SELECTOR,pers.getSelector().getOID());
    else
      qUpdate.setNull(OID_SELECTOR,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_EST_APROB_BUSQ,pers.getEst_aprob_busq().getOID());
    qUpdate.setInt(OID_SECTOR,pers.getSector().getOID());
    if (pers.getFec_est_aprob()!=null)
    	qUpdate.setDate(FEC_EST_APROB,new java.sql.Date(pers.getFec_est_aprob().getTime()));
    else
    	qUpdate.setNull(FEC_EST_APROB,java.sql.Types.DATE);
    if (pers.getConvenio()!=null) 
      qUpdate.setInt(OID_CONVENIO,pers.getConvenio().getOID());
    else
      qUpdate.setNull(OID_CONVENIO,java.sql.Types.INTEGER);
    qUpdate.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getMotivoEstado()!=null)
    	qUpdate.setInt(OID_MOT_EST_BUSQ,pers.getMotivoEstado().getOID());
    else
    	qUpdate.setNull(OID_MOT_EST_BUSQ,Types.INTEGER);
    if (pers.getFechaCierre()!=null)
    	qUpdate.setDate(FEC_CIERRE, new java.sql.Date(pers.getFechaCierre().getTime()));
    else
    	qUpdate.setNull(FEC_CIERRE, Types.DATE);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BUSQUEDA_ACT = 1; 
    RecluBusqueda pers = (RecluBusqueda) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsBusquedaActiva "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_busqueda_act=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BUSQUEDA_ACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BUSQUEDA_ACT = 1; 
    RecluBusqueda pers = (RecluBusqueda) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsBusquedaActiva "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_busqueda_act=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BUSQUEDA_ACT, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_BUSQUEDA_ACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsBusquedaActiva "); 
    textSQL.append(" WHERE oid_busqueda_act = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BUSQUEDA_ACT, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 
	    int param = 0;
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsBusquedaActiva "); 
	    textSQL.append(" WHERE activo=1 ");
	    
	    RecluOperacion recluOperacion = (RecluOperacion) condiciones.get(RecluOperacion.NICKNAME);
	    if (recluOperacion!=null)
	    	textSQL.append(" and oid_operacion = "+recluOperacion.getOIDInteger().toString()+" ");
	    
	    RecluSectores recluSector = (RecluSectores) condiciones.get(RecluSectores.NICKNAME);
	    if (recluSector!=null)
	    	textSQL.append(" and oid_sector = "+recluSector.getOIDInteger().toString()+" ");	    
	    
	    RecluBusqueda recluBusqueda = (RecluBusqueda) condiciones.get(RecluBusqueda.NICKNAME);
	    if (recluBusqueda!=null)
	    	textSQL.append(" and oid_busqueda_act = "+recluBusqueda.getOIDInteger().toString()+" ");
	    
	    RecluSelector recluSelector = (RecluSelector) condiciones.get(RecluSelector.NICKNAME);
	    if (recluSelector!=null)
	    	textSQL.append(" and oid_selector = "+recluSelector.getOIDInteger().toString()+" ");	    
	    
	    RecluPuesto recluPuesto = (RecluPuesto) condiciones.get(RecluPuesto.NICKNAME);
	    if (recluPuesto!=null)
	    	textSQL.append(" and oid_puesto_busqueda = "+recluPuesto.getOIDInteger().toString()+" ");
	    
	    
	    if (condiciones.containsKey("CODIGO_SEXO")) {
	    	String codigoSexo = condiciones.getString("CODIGO_SEXO");
	    	if (!codigoSexo.equals(RecluBusqueda.getSexoIndistinto()))
	    		textSQL.append(" and sexo in ('"+codigoSexo+"','"+RecluBusqueda.getSexoIndistinto()+"') ");
	    }
	    
	    String buscar = (String) condiciones.get("BUSCAR");
	    if (buscar!=null) {
	    	textSQL.append(" and ");
	    	textSQL.append(" ( ");
	    	textSQL.append(" (oid_puesto_busqueda in (select oid_puesto_busqueda from rsPuestoBusqueda where activo=1 and upper(descripcion) like '%"+buscar.toUpperCase()+"%'))  ");
	    	textSQL.append(" or ");
	    	textSQL.append(" (oid_busqueda_act in ( select oid_busqueda_act from rsCandidatoBusq a1 , rspostulante b1 ");
	    	textSQL.append(" where a1.activo=1 and b1.activo=1 and a1.oid_postulante=b1.oid_postulante and upper(b1.ape_y_nom) like '%"+buscar.toUpperCase()+"%' )) ");
	    	textSQL.append(" or ");
	    	textSQL.append(" (oid_busqueda_act in ( select oid_busqueda_act from rsCandidatoBusq a1 , rspostulante b1 ");
	    	textSQL.append(" where a1.activo=1 and b1.activo=1 and a1.oid_postulante=b1.oid_postulante and upper(b1.nro_docu) like '%"+buscar.toUpperCase()+"%' )) ");	    	
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
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rspostulante b1 , rsCompePostu c1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and b1.activo=1 and c1.activo=1 ");
	    	textSQL.append("   and a1.oid_postulante = b1.oid_postulante "); 
	    	textSQL.append("   and c1.oid_postulante = b1.oid_postulante "); 
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
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rspostulante b1 , rsPuestoAplica c1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and b1.activo=1 and c1.activo=1 ");
	    	textSQL.append("   and a1.oid_postulante = b1.oid_postulante "); 
	    	textSQL.append("   and c1.oid_postulante = b1.oid_postulante "); 
	    	textSQL.append("   and c1.oid_puesto_busqueda in "+listaIdPostuAplica+") ");
	    }	    
	    
	    
	    // Obtener el listado de Operaciones a la cual puede acceder
	    
	    String condINOperacion = " oid_operacion in (-1";
	    Iterator iterOperacionesVisualizar = 
	    		RecluOperacion.getOperacionesParaVisualizarDelUsuario(this.getSesion()).iterator();
	    while (iterOperacionesVisualizar.hasNext()) {
	    	RecluOperacion recluOperVisu = (RecluOperacion) iterOperacionesVisualizar.next();
	    	condINOperacion = condINOperacion +","+recluOperVisu.getOIDInteger(); 
	    }
	    condINOperacion = condINOperacion + ") ";
	    textSQL.append(" and "+condINOperacion);
	    
	    
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
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
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
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rsProcesoSelec a2 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and a2.activo = 1 and a1.oid_candidato_busq = a2.oid_candidato_busq  ");
	    	textSQL.append("   and a2.oid_est_proc_sel in "+listaIdEstadoProceso+") ");
	    }	    
	    
	    
	    // Aplicar filtro si es ES_REFERIDO
	    if (condiciones.containsKey(RecluEstadoPostulante.NICKNAME)) {

	    	RecluEstadoPostulante recluEstadoPostulante = (RecluEstadoPostulante) condiciones.get(RecluEstadoPostulante.NICKNAME);
	    	
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rspostulante b1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and b1.activo=1  ");
	    	textSQL.append("   and a1.oid_postulante = b1.oid_postulante ");
	    	textSQL.append("   and b1.oid_estado_postu = "+recluEstadoPostulante.getOIDInteger()+" ) ");
	    }	    
	    
	    // Aplicar filtro si es ES_REFERIDO
	    if (condiciones.containsKey("ES_REFERIDO")) {

	    	String esReferido = (String) condiciones.get("ES_REFERIDO");
	    	
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rspostulante b1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and b1.activo=1  ");
	    	textSQL.append("   and a1.oid_postulante = b1.oid_postulante ");
	    	
	    	if (esReferido.toUpperCase().equals("SI"))
	    		textSQL.append("   and b1.es_referido = 1 ) ");
	    	else 
	    		textSQL.append("   and b1.es_referido = 0 ) ");
	    }
	    
	    if (condiciones.containsKey("GENERO_POSTULANTE")) {

	    	String generoPostulante = (String) condiciones.get("GENERO_POSTULANTE");
	    	
	    	textSQL.append(" and oid_busqueda_act in ( ");
	    	textSQL.append(" select "); 
	    	textSQL.append("   oid_busqueda_act "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("   rsCandidatoBusq a1 , rspostulante b1 "); 
	    	textSQL.append("  where "); 
	    	textSQL.append("   a1.activo=1 and b1.activo=1  ");
	    	textSQL.append("   and a1.oid_postulante = b1.oid_postulante ");
	    	
	    	if (generoPostulante.toUpperCase().equals("M"))
	    		textSQL.append("   and b1.sexo = 'M' ) ");
	    	else 
	    		textSQL.append("   and b1.sexo = 'F' ) ");
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
	    	textSQL.append(" and oid_busqueda_act in (select oid_busqueda_act from rsCompeBusqAct where activo=1 and oid_competencia in "+listaIdCompe+") ");
	    }	 
	    
	    
	    
	    if ((condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) &&
	    		(condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada()))) {
	    	
	    	textSQL.append(" and (estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"' ");
	    	textSQL.append(" or (estado_busqueda='"+RecluBusqueda.getEstadoBusqCerrada()+"' and fec_cierre>=? and fec_cierre<=?)) ");
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) {
	    
	    	textSQL.append(" and estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"' ");
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada())) {
	    	textSQL.append(" and (estado_busqueda='"+RecluBusqueda.getEstadoBusqCerrada()+"' and fec_cierre>=? and fec_cierre<=?) ");
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
    textSQL.append("SELECT * FROM  rsBusquedaActiva "); 
    textSQL.append(" WHERE oid_puesto_busqueda = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_busqueda_act oid,oid_puesto_busqueda codigo, fec_inicio_busq descripcion ,activo ");
    textSQL.append(" from rsBusquedaActiva");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  
  public static List getCondicionesBusquedas(
		  HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluBusqueda.NICKNAME,
             DBRecluBusqueda.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
