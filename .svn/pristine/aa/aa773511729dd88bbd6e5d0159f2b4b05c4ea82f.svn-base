package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstAlgunaVez;
import com.srn.erp.excluidos.bm.SeguExcPredio;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSeguExcEstAlgunaVez extends DBObjetoPersistente {

  public static final String OID_SEGU_EXCLUIR = "oid_segu_excluir";
  public static final String OID_SEGU_PERFIL = "oid_segu_perfil";
  public static final String OID_ESTADO = "oid_estado";
  public static final String VISUALIZA = "visualiza";
  public static final String ALTA = "alta";
  public static final String BAJA = "baja";
  public static final String MODIFICA = "modifica";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PERFIL = 100;
  public static final int SELECT_BY_PERFIL_ESTADO = 101;

  public DBSeguExcEstAlgunaVez() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEGU_EXCLUIR = 1;
    final int OID_SEGU_PERFIL = 2;
    final int OID_ESTADO = 3;
    final int VISUALIZA = 4;
    final int ALTA = 5;
    final int BAJA = 6;
    final int MODIFICA = 7;
    final int ACTIVO = 8;

    SeguExcEstAlgunaVez pers = (SeguExcEstAlgunaVez) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excSeguExcluir "+
                     " ( "+
                      "OID_SEGU_EXCLUIR,"+
                      "OID_SEGU_PERFIL,"+
                      "OID_ESTADO,"+
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
    qInsert.setInt(OID_SEGU_EXCLUIR,pers.getOID());
    qInsert.setInt(OID_SEGU_PERFIL,pers.getPerfil().getOID());
    qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
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
    final int OID_ESTADO = 2;
    final int VISUALIZA = 3;
    final int ALTA = 4;
    final int BAJA = 5;
    final int MODIFICA = 6;
    final int ACTIVO = 7;
    final int OID_SEGU_EXCLUIR = 8;

    SeguExcEstAlgunaVez pers = (SeguExcEstAlgunaVez) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excSeguExcluir set "+
              "oid_segu_perfil=?"+ 
              ",oid_estado=?"+ 
              ",visualiza=?"+ 
              ",alta=?"+ 
              ",baja=?"+ 
              ",modifica=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_segu_excluir=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_EXCLUIR,pers.getOID());
    qUpdate.setInt(OID_SEGU_PERFIL,pers.getPerfil().getOID());
    qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    qUpdate.setBoolean(VISUALIZA,pers.isVisualiza().booleanValue());
    qUpdate.setBoolean(ALTA,pers.isAlta().booleanValue());
    qUpdate.setBoolean(BAJA,pers.isBaja().booleanValue());
    qUpdate.setBoolean(MODIFICA,pers.isModifica().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGU_EXCLUIR = 1; 
    SeguExcEstAlgunaVez pers = (SeguExcEstAlgunaVez) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguExcluir "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_segu_excluir=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_EXCLUIR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGU_EXCLUIR = 1; 
    SeguExcEstAlgunaVez pers = (SeguExcEstAlgunaVez) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguExcluir "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_segu_excluir=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGU_EXCLUIR, pers.getOID()); 
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
      case SELECT_BY_PERFIL_ESTADO: { 
          ps = this.selectByPerfilEStado(aCondiciones); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SEGU_EXCLUIR = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguExcluir "); 
    textSQL.append(" WHERE oid_segu_excluir = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SEGU_EXCLUIR, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPerfilEStado(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    SeguPerfilExcluido seguPerfilExcluido = (SeguPerfilExcluido) condiciones.get(SeguPerfilExcluido.NICKNAME);
	    EstadoExcluido estado = (EstadoExcluido) condiciones.get(EstadoExcluido.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguExcluir "); 
	    textSQL.append(" WHERE  oid_segu_perfil = ? and oid_estado=?	");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, seguPerfilExcluido.getOID());
	    querySelect.setInt(2, estado.getOID());
	    
	    return querySelect; 
	  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguExcluir "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPerfil(Object aCondiciones) throws BaseException, SQLException { 

	    SeguPerfilExcluido seguPerfilExcluido = (SeguPerfilExcluido) aCondiciones; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguExcluir "); 
	    textSQL.append(" WHERE oid_segu_perfil = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, seguPerfilExcluido.getOID()); 
	    return querySelect; 
	  }  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_segu_excluir oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excSeguExcluir");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getExcAlgunaVez(
		  SeguPerfilExcluido seguPerfilExcluido,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SeguExcEstAlgunaVez.NICKNAME,
             DBSeguExcEstAlgunaVez.SELECT_BY_PERFIL,
             seguPerfilExcluido,
             new ListObserver(),
             aSesion);
  }
  
  public static SeguExcEstAlgunaVez getExcEstAlgunaVez(
		  SeguPerfilExcluido seguPerfilExcluido,
		  EstadoExcluido estado,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(SeguPerfilExcluido.NICKNAME, seguPerfilExcluido);
	  condiciones.put(EstadoExcluido.NICKNAME, estado);
	  
	  return (SeguExcEstAlgunaVez) ObjetoLogico.getObjects(SeguExcEstAlgunaVez.NICKNAME,
			  				DBSeguExcEstAlgunaVez.SELECT_BY_PERFIL_ESTADO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
