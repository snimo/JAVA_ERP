package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.SeguExcPeligrosidad;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
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

public class DBSeguExcPeligrosidad extends DBObjetoPersistente {

  public static final String OID_SEGU_PELIGRO = "oid_segu_peligro";
  public static final String OID_SEGU_PERFIL = "oid_segu_perfil";
  public static final String OID_PELIGROSIDAD = "oid_peligrosidad";
  public static final String VISUALIZA = "visualiza";
  public static final String ALTA = "alta";
  public static final String BAJA = "baja";
  public static final String MODIFICA = "modifica";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PERFIL = 100;
  public static final int SELECT_BY_PERFIL_PELIGROSIDAD = 101;

  public DBSeguExcPeligrosidad() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEGU_PELIGRO = 1;
    final int OID_SEGU_PERFIL = 2;
    final int OID_PELIGROSIDAD = 3;
    final int VISUALIZA = 4;
    final int ALTA = 5;
    final int BAJA = 6;
    final int MODIFICA = 7;
    final int ACTIVO = 8;

    SeguExcPeligrosidad pers = (SeguExcPeligrosidad) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excSeguPeligro "+
                     " ( "+
                      "OID_SEGU_PELIGRO,"+
                      "OID_SEGU_PERFIL,"+
                      "OID_PELIGROSIDAD,"+
                      "VISUALIZA,"+
                      "ALTA,"+
                      "BAJA,"+
                      "MODIFICA,"+
                      "ACTIVO)"+ 
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
    qInsert.setInt(OID_SEGU_PELIGRO,pers.getOID());
    qInsert.setInt(OID_SEGU_PERFIL,pers.getPerfil().getOID());
    qInsert.setInt(OID_PELIGROSIDAD,pers.getPeligrosidad().getOID());
    qInsert.setBoolean(VISUALIZA,pers.isVisualiza().booleanValue());
    qInsert.setBoolean(ALTA,pers.isAlta().booleanValue());
    qInsert.setBoolean(BAJA,pers.isBaja().booleanValue());
    qInsert.setBoolean(MODIFICA,pers.isModifica().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEGU_PERFIL = 1;
    final int OID_PELIGROSIDAD = 2;
    final int VISUALIZA = 3;
    final int ALTA = 4;
    final int BAJA = 5;
    final int MODIFICA = 6;
    final int ACTIVO = 7;
    final int OID_SEGU_PELIGRO = 8;

    SeguExcPeligrosidad pers = (SeguExcPeligrosidad) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excSeguPeligro set "+
              "oid_segu_perfil=?"+ 
              ",oid_peligrosidad=?"+ 
              ",visualiza=?"+ 
              ",alta=?"+ 
              ",baja=?"+ 
              ",modifica=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_segu_peligro=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_PELIGRO,pers.getOID());
    qUpdate.setInt(OID_SEGU_PERFIL,pers.getPerfil().getOID());
    qUpdate.setInt(OID_PELIGROSIDAD,pers.getPeligrosidad().getOID());
    qUpdate.setBoolean(VISUALIZA,pers.isVisualiza().booleanValue());
    qUpdate.setBoolean(ALTA,pers.isAlta().booleanValue());
    qUpdate.setBoolean(BAJA,pers.isBaja().booleanValue());
    qUpdate.setBoolean(MODIFICA,pers.isModifica().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGU_PELIGRO = 1; 
    SeguExcPeligrosidad pers = (SeguExcPeligrosidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguPeligro "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_segu_peligro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_PELIGRO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGU_PELIGRO = 1; 
    SeguExcPeligrosidad pers = (SeguExcPeligrosidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguPeligro "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_segu_peligro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_PELIGRO, pers.getOID()); 
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
      case SELECT_BY_PERFIL: {
          ps = this.selectByPerfil(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_PERFIL_PELIGROSIDAD: {
          ps = this.selectByPerfilPeligrosidad(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SEGU_PELIGRO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguPeligro "); 
    textSQL.append(" WHERE oid_segu_peligro = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SEGU_PELIGRO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPerfil(Object aCondiciones) throws BaseException, SQLException { 

	  	SeguPerfilExcluido seguPerfilExcluido =   (SeguPerfilExcluido) aCondiciones;
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguPeligro "); 
	    textSQL.append(" WHERE oid_segu_perfil  = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, seguPerfilExcluido.getOID());
	    
	    return querySelect; 
	    
  }  
  
  private PreparedStatement selectByPerfilPeligrosidad(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 
	    SeguPerfilExcluido seguPerfilExcluido = (SeguPerfilExcluido) condiciones.get(SeguPerfilExcluido.NICKNAME);
	    PeligrosidadExcluido peligrosidad = (PeligrosidadExcluido) condiciones.get(PeligrosidadExcluido.NICKNAME);
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguPeligro "); 
	    textSQL.append(" WHERE oid_segu_perfil = ? and oid_peligrosidad = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	     
	    querySelect.setInt(1, seguPerfilExcluido.getOID());
	    querySelect.setInt(2, peligrosidad.getOID());
	    
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguPeligro "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_segu_peligro oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excSeguPeligro");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPeligrosidades(SeguPerfilExcluido seguPerfilExcluido,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SeguExcPeligrosidad.NICKNAME,
             DBSeguExcPeligrosidad.SELECT_BY_PERFIL,
             seguPerfilExcluido,
             new ListObserver(),
             aSesion);
  }
  
  public static SeguExcPeligrosidad getSeguExcPeligrosidad(
		  SeguPerfilExcluido seguPerfilExcluido,
		  PeligrosidadExcluido peligrosidad,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SeguPerfilExcluido.NICKNAME,seguPerfilExcluido);
	  condiciones.put(PeligrosidadExcluido.NICKNAME,peligrosidad);
	  
	  return (SeguExcPeligrosidad) ObjetoLogico.getObjects(SeguExcPeligrosidad.NICKNAME,
			  				DBSeguExcPeligrosidad.SELECT_BY_PERFIL_PELIGROSIDAD,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
