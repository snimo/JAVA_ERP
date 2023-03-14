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

public class DBRecluPostulante extends DBObjetoPersistente {

  public static final String OID_POSTULANTE = "oid_postulante";
  public static final String APE_Y_NOM = "ape_y_nom";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String NRO_DOCU = "nro_docu";
  public static final String FEC_NACIMIENTO = "fec_nacimiento";
  public static final String DIRECCION = "direccion";
  public static final String LOCALIDAD = "localidad";
  public static final String COD_POSTAL = "cod_postal";
  public static final String TELEFONO_FIJO = "telefono_fijo";
  public static final String TELEFONO_CELULAR = "telefono_celular";
  public static final String REFERIDO_POR = "referido_por";
  public static final String SEXO = "sexo";
  public static final String ACTIVO = "activo";
  public static final String ES_REFERIDO = "es_referido";
  public static final String NRO_REFERIDO = "nro_referido";
  public static final String OID_FUENTE = "oid_fuente";
  public static final String OID_ESTADO_POSTU = "oid_estado_postu";
  public static final String FEC_EST_POSTU = "fec_est_postu";
  
  private static final int SELECT_BY_CONDICIONES = 100;
  private static final int SELECT_BY_NRO_LOTE = 101;
  
  

  public DBRecluPostulante() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1;
    final int APE_Y_NOM = 2;
    final int OID_TIPO_DOCU = 3;
    final int NRO_DOCU = 4;
    final int FEC_NACIMIENTO = 5;
    final int DIRECCION = 6;
    final int LOCALIDAD = 7;
    final int COD_POSTAL = 8;
    final int TELEFONO_FIJO = 9;
    final int TELEFONO_CELULAR = 10;
    final int REFERIDO_POR = 11;
    final int SEXO = 12;
    final int ACTIVO = 13;
    final int ES_REFERIDO = 14;
    final int NRO_REFERIDO = 15;
    final int OID_FUENTE = 16;
    final int OID_ESTADO_POSTU = 17;
    final int FEC_EST_POSTU = 18;
    

    RecluPostulante pers = (RecluPostulante) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsPostulante "+
                     " ( "+
                      "OID_POSTULANTE,"+
                      "APE_Y_NOM,"+
                      "OID_TIPO_DOCU,"+
                      "NRO_DOCU,"+
                      "FEC_NACIMIENTO,"+
                      "DIRECCION,"+
                      "LOCALIDAD,"+
                      "COD_POSTAL,"+
                      "TELEFONO_FIJO,"+
                      "TELEFONO_CELULAR,"+
                      "REFERIDO_POR,"+
                      "SEXO,"+
                      "ACTIVO,ES_REFERIDO,NRO_REFERIDO,OID_FUENTE,OID_ESTADO_POSTU,FEC_EST_POSTU)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_POSTULANTE,pers.getOID());
    qInsert.setString(APE_Y_NOM,pers.getApe_y_nom());
    if (pers.getTipo_documento()!=null) 
      qInsert.setInt(OID_TIPO_DOCU,pers.getTipo_documento().getOID());
    else
      qInsert.setNull(OID_TIPO_DOCU,java.sql.Types.INTEGER);
    qInsert.setString(NRO_DOCU,pers.getNro_docu());
    if (pers.getFec_nacimiento()!=null) 
      qInsert.setDate(FEC_NACIMIENTO,new java.sql.Date(pers.getFec_nacimiento().getTime()));
    else
      qInsert.setNull(FEC_NACIMIENTO,java.sql.Types.DATE);
    if (pers.getDireccion()!=null)
    	qInsert.setString(DIRECCION,pers.getDireccion());
    else
    	qInsert.setNull(DIRECCION,Types.VARCHAR);
    if (pers.getLocalidad()!=null)
    	qInsert.setString(LOCALIDAD,pers.getLocalidad());
    else
    	qInsert.setNull(LOCALIDAD,Types.VARCHAR);
    if (pers.getCod_postal()!=null)
    	qInsert.setString(COD_POSTAL,pers.getCod_postal());
    else
    	qInsert.setNull(COD_POSTAL,Types.VARCHAR);
    if (pers.getTelefono_fijo()!=null)
    	qInsert.setString(TELEFONO_FIJO,pers.getTelefono_fijo());
    else
    	qInsert.setNull(TELEFONO_FIJO,Types.VARCHAR);
    if (pers.getTelefono_celular()!=null)
    	qInsert.setString(TELEFONO_CELULAR,pers.getTelefono_celular());
    else
    	qInsert.setNull(TELEFONO_CELULAR,Types.VARCHAR);
    if (pers.getReferido_por()!=null)
    	qInsert.setString(REFERIDO_POR,pers.getReferido_por());
    else
    	qInsert.setNull(REFERIDO_POR,Types.VARCHAR);
    if (pers.getSexo()!=null)
    	qInsert.setString(SEXO,pers.getSexo());
    else
    	qInsert.setNull(SEXO,Types.VARCHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.isReferido()!=null)
    	qInsert.setBoolean(ES_REFERIDO, pers.isReferido().booleanValue());
    else
    	qInsert.setBoolean(ES_REFERIDO, false);
    
    if (pers.getNroReferido()!=null)
    	qInsert.setInt(NRO_REFERIDO, pers.getNroReferido().intValue());
    else
    	qInsert.setNull(NRO_REFERIDO, Types.INTEGER);    
    
    if (pers.getFuente()!=null)
    	qInsert.setInt(OID_FUENTE, pers.getFuente().getOID());
    else
    	qInsert.setNull(OID_FUENTE, Types.INTEGER);
    
    if (pers.getEstadoPostulante()!=null)
    	qInsert.setInt(OID_ESTADO_POSTU, pers.getEstadoPostulante().getOID());
    else
    	qInsert.setNull(OID_ESTADO_POSTU, Types.INTEGER);
    
    if (pers.getFecEstadoPostulante()!=null)
    	qInsert.setDate(FEC_EST_POSTU, new java.sql.Date(pers.getFecEstadoPostulante().getTime()));
    else
    	qInsert.setNull(OID_ESTADO_POSTU, Types.DATE);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int APE_Y_NOM = 1;
    final int OID_TIPO_DOCU = 2;
    final int NRO_DOCU = 3;
    final int FEC_NACIMIENTO = 4;
    final int DIRECCION = 5;
    final int LOCALIDAD = 6;
    final int COD_POSTAL = 7;
    final int TELEFONO_FIJO = 8;
    final int TELEFONO_CELULAR = 9;
    final int REFERIDO_POR = 10;
    final int SEXO = 11;
    final int ACTIVO = 12;
    final int ES_REFERIDO = 13;
    final int NRO_REFERIDO = 14;
    final int OID_FUENTE = 15;
    final int OID_ESTADO_POSTU = 16;
    final int FEC_EST_POSTU = 17;    
    final int OID_POSTULANTE = 18;

    RecluPostulante pers = (RecluPostulante) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsPostulante set "+
              "ape_y_nom=?"+ 
              ",oid_tipo_docu=?"+ 
              ",nro_docu=?"+ 
              ",fec_nacimiento=?"+ 
              ",direccion=?"+ 
              ",localidad=?"+ 
              ",cod_postal=?"+ 
              ",telefono_fijo=?"+ 
              ",telefono_celular=?"+ 
              ",referido_por=?"+ 
              ",sexo=?"+ 
              ",activo=?"+ 
              ",es_referido=?"+
              ",nro_referido=?"+
              ",oid_fuente=?"+
              " ,OID_ESTADO_POSTU=?,FEC_EST_POSTU=? "+
                 " where " +
                 " oid_postulante=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_POSTULANTE,pers.getOID());
    qUpdate.setString(APE_Y_NOM,pers.getApe_y_nom());
    if (pers.getTipo_documento()!=null) 
      qUpdate.setInt(OID_TIPO_DOCU,pers.getTipo_documento().getOID());
    else
      qUpdate.setNull(OID_TIPO_DOCU,java.sql.Types.INTEGER);
    qUpdate.setString(NRO_DOCU,pers.getNro_docu());
    if (pers.getFec_nacimiento()!=null) 
      qUpdate.setDate(FEC_NACIMIENTO,new java.sql.Date(pers.getFec_nacimiento().getTime()));
    else
      qUpdate.setNull(FEC_NACIMIENTO,java.sql.Types.DATE);
    if (pers.getDireccion()!=null)
    	qUpdate.setString(DIRECCION,pers.getDireccion());
    else
    	qUpdate.setNull(DIRECCION,Types.VARCHAR);
    if (pers.getLocalidad()!=null)
    	qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    else
    	qUpdate.setNull(LOCALIDAD,Types.VARCHAR);
    if (pers.getCod_postal()!=null)
    	qUpdate.setString(COD_POSTAL,pers.getCod_postal());
    else
    	qUpdate.setNull(COD_POSTAL,Types.VARCHAR);
    if (pers.getTelefono_fijo()!=null)
    	qUpdate.setString(TELEFONO_FIJO,pers.getTelefono_fijo());
    else
    	qUpdate.setNull(TELEFONO_FIJO,Types.VARCHAR);
    if (pers.getTelefono_celular()!=null)
    	qUpdate.setString(TELEFONO_CELULAR,pers.getTelefono_celular());
    else
    	qUpdate.setNull(TELEFONO_CELULAR,Types.VARCHAR);
    if (pers.getReferido_por()!=null)
    	qUpdate.setString(REFERIDO_POR,pers.getReferido_por());
    else
    	qUpdate.setNull(REFERIDO_POR,Types.VARCHAR);
    qUpdate.setString(SEXO,pers.getSexo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isReferido()!=null)
    	qUpdate.setBoolean(ES_REFERIDO, pers.isReferido().booleanValue());
    else
    	qUpdate.setBoolean(ES_REFERIDO, false);
    
    if (pers.getNroReferido()!=null)
    	qUpdate.setInt(NRO_REFERIDO, pers.getNroReferido().intValue());
    else
    	qUpdate.setNull(NRO_REFERIDO, Types.INTEGER);
    
    if (pers.getFuente()!=null)
    	qUpdate.setInt(OID_FUENTE, pers.getFuente().getOID());
    else
    	qUpdate.setNull(OID_FUENTE, Types.INTEGER);
    
    if (pers.getEstadoPostulante()!=null)
    	qUpdate.setInt(OID_ESTADO_POSTU, pers.getEstadoPostulante().getOID());
    else
    	qUpdate.setNull(OID_ESTADO_POSTU, Types.INTEGER);
    
    if (pers.getFecEstadoPostulante()!=null)
    	qUpdate.setDate(FEC_EST_POSTU, new java.sql.Date(pers.getFecEstadoPostulante().getTime()));
    else
    	qUpdate.setNull(FEC_EST_POSTU, Types.DATE);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_POSTULANTE = 1; 
    RecluPostulante pers = (RecluPostulante) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsPostulante "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_postulante=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_POSTULANTE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_POSTULANTE = 1; 
    RecluPostulante pers = (RecluPostulante) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsPostulante "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_postulante=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_POSTULANTE, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllActivos(aCondiciones); 
          break; 
        }      
      case SELECT_BY_CONDICIONES: { 
          ps = this.selectByCondiciones(aCondiciones); 
          break; 
        } 
      case SELECT_BY_NRO_LOTE: {
          ps = this.selectByNroLote(aCondiciones); 
          break;    	  
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_POSTULANTE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsPostulante "); 
    textSQL.append(" WHERE oid_postulante = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_POSTULANTE, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByNroLote(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT a.* FROM  rsPostulante a ,  rsResulBusq b  "); 
	    textSQL.append(" WHERE a.oid_postulante = b.oid_obj_neg and a.activo=1 and b.activo = 1 and b.nro_lote = ? and b.nro_orden>=? and b.nro_orden<=? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Integer nrolote = (Integer) condiciones.get("NRO_LOTE");
	    Integer nroOrdenDesde = (Integer) condiciones.get("NRO_ORDEN_DESDE");
	    Integer nroOrdenHasta = (Integer) condiciones.get("NRO_ORDEN_HASTA");
	    querySelect.setInt(1, nrolote); 
	    querySelect.setInt(2, nroOrdenDesde);
	    querySelect.setInt(3, nroOrdenHasta);
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    int param = 0;
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsPostulante "); 
	    textSQL.append(" WHERE activo = 1 ");
	    
	    RecluOperacion recluOperacion = (RecluOperacion) condiciones.get(RecluOperacion.NICKNAME);
	    if (recluOperacion!=null) {
	    	textSQL.append(" and oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_operacion = "+recluOperacion.getOIDInteger().toString()+") ");
	    }
	    						
	    
	    RecluSectores recluSector = (RecluSectores) condiciones.get(RecluSectores.NICKNAME);
	    if (recluSector!=null) {
	    	textSQL.append(" and oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_sector = "+recluSector.getOIDInteger().toString()+") ");	    	
	    	
	    }
	    		    
	    
	    RecluBusqueda recluBusqueda = (RecluBusqueda) condiciones.get(RecluBusqueda.NICKNAME);
	    if (recluBusqueda!=null)
	    	textSQL.append(" and oid_busqueda_act = "+recluBusqueda.getOIDInteger().toString()+" ");
	    
	    RecluSelector recluSelector = (RecluSelector) condiciones.get(RecluSelector.NICKNAME);
	    if (recluSelector!=null) {
	    	textSQL.append(" and oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_selector = "+recluSelector.getOIDInteger().toString()+") ");	    	
	    }
	    
	    RecluPuesto recluPuesto = (RecluPuesto) condiciones.get(RecluPuesto.NICKNAME);
	    if (recluPuesto!=null) {
	    	textSQL.append(" and oid_postulante in ( ");
	    	textSQL.append("						select a2.oid_postulante from rsBusquedaActiva a1, rsCandidatoBusq a2 ");
	    	textSQL.append("						where a1.oid_busqueda_act = a2.oid_busqueda_act and ");
	    	textSQL.append("						a1.activo = 1 and a2.activo=1 "); 
	    	textSQL.append("                        and oid_puesto_busqueda = "+recluPuesto.getOIDInteger().toString()+") ");	    	
	    }
	    
	    
	    if (condiciones.containsKey("CODIGO_SEXO")) {
	    	String codigoSexo = condiciones.getString("CODIGO_SEXO");
	    	
	    	
	    	textSQL.append(" and oid_postulante in ( ");
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
	    	textSQL.append(" (upper(APE_Y_NOM) like '%"+buscar.toUpperCase()+"%')  ");
	    	textSQL.append(" or ");
	    	textSQL.append(" (nro_docu = '"+buscar+"' )");
	    	textSQL.append(" or ");
	    	textSQL.append(" ( oid_postulante in (select a3.oid_postulante from rsBusquedaActiva a1, rsPuestoBusqueda a2 , rsCandidatoBusq a3 ");
	    	textSQL.append("                      where a1.oid_puesto_busqueda = a2.oid_puesto_busqueda and a1.oid_busqueda_act = a3.oid_busqueda_act and ");
	    	textSQL.append("                      a1.activo = 1 and a2.activo=1 and a3.activo=1 and Upper(a2.descripcion) like '%"+buscar+"%')) ");
	    	textSQL.append(" or ");
	    	textSQL.append(" ( oid_postulante in (select a1.oid_postulante from rspuestoaplica a1, rsPuestoBusqueda a2 "); 
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
	    	textSQL.append(" and oid_postulante in ( ");
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
	    	textSQL.append(" and oid_postulante in ( ");
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
	    	textSQL.append(" and oid_postulante in ( ");
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
	    	textSQL.append(" and oid_postulante in ( ");
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
	    	textSQL.append("   and oid_estado_postu = "+recluEstadoPostulante.getOIDInteger()+" ");
	    }
	    
	    // Aplicar filtro si es ES_REFERIDO
	    if (condiciones.containsKey("ES_REFERIDO")) {

	    	String esReferido = (String) condiciones.get("ES_REFERIDO");
	    	
	    	if (esReferido.toUpperCase().equals("SI"))
	    		textSQL.append("   and es_referido = 1  ");
	    	else 
	    		textSQL.append("   and es_referido = 0  ");
	    }
	    
	    if (condiciones.containsKey("GENERO_POSTULANTE")) {

	    	String generoPostulante = (String) condiciones.get("GENERO_POSTULANTE");
	    	
	    	if (generoPostulante.toUpperCase().equals("M"))
	    		textSQL.append("   and sexo = 'M'  ");
	    	else 
	    		textSQL.append("   and sexo = 'F'  ");
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
	    	
	    	textSQL.append("  and oid_postulante in ( select "); 
	    	textSQL.append("    a2.oid_postulante "); 
	    	textSQL.append("  from "); 
	    	textSQL.append("    rsCompeBusqAct a1 , rscandidatobusq a2 ");
	    	textSQL.append("  where "); 
	    	textSQL.append("    a1.oid_busqueda_act = a2.oid_busqueda_act and a1.activo=1 and a2.activo=1 and a1.oid_competencia in "+listaIdCompe+") "); 
	    	
	    }	 
	    
	    
	    
	    if ((condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) &&
	    		(condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada()))) {
	    	
	    	textSQL.append(" and (oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"') ");
	    	textSQL.append(" or ");
	    	textSQL.append(" 	 oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqCerrada()+"' and fec_cierre>=? and fec_cierre<=? )) ");	    	
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqAbierta())) {
	    
	    	textSQL.append(" and oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
	    	textSQL.append("                        and a1.activo=1 and a2.activo=1 and a1.estado_busqueda='"+RecluBusqueda.getEstadoBusqAbierta()+"') ");
	    	
	    } else if (condiciones.containsKey(RecluBusqueda.getEstadoBusqCerrada())) {
	    	textSQL.append("  and oid_postulante in (select a2.oid_postulante from rsbusquedaactiva a1 , rscandidatobusq a2 where a1.oid_busqueda_act = a2.oid_busqueda_act ");
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
    textSQL.append("SELECT * FROM  rsPostulante "); 
    textSQL.append(" WHERE nro_docu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsPostulante "); 
	    textSQL.append(" where activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect;
	    
	  }  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_postulante oid, nro_docu codigo, ape_y_nom descripcion ,activo ");
    textSQL.append(" from rsPostulante");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPostulantesActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluPostulante.NICKNAME,
             DBRecluPostulante.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getPostulantesByCondiciones(HashTableDatos condiciones,ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluPostulante.NICKNAME,
             SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  public static List getPostulantesByNroLote(Integer nroLote,Integer nroDesde,Integer nroHasta,ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("NRO_LOTE", nroLote);
	  condiciones.put("NRO_ORDEN_DESDE", nroDesde);
	  condiciones.put("NRO_ORDEN_HASTA", nroHasta);
	  
	  return (List) ObjetoLogico.getObjects(RecluPostulante.NICKNAME,
             SELECT_BY_NRO_LOTE,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
