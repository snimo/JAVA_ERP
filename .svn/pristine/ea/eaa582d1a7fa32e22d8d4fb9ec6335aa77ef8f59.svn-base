package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.GrupoComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCompoPresupuestario extends DBObjetoPersistente {

  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO = "tipo";
  public static final String NRO_INTERNO_COMPO = "nro_interno_compo";
  public static final String OID_GRUPO_COMPO = "oid_grupo_compo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_COMPO = 100;

  public DBCompoPresupuestario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPO_PRESU = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO = 4;
    final int NRO_INTERNO_COMPO = 5;
    final int OID_GRUPO_COMPO = 6;
    final int ACTIVO = 7;

    CompoPresupuestario pers = (CompoPresupuestario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plCompoPresu "+
                     " ( "+
                      "OID_COMPO_PRESU,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO,"+
                      "NRO_INTERNO_COMPO,"+
                      "OID_GRUPO_COMPO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPO_PRESU,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO,pers.getTipo());
    int proxNroInterno = getUltimoNroInterno(this.getSesion())+1;
    qInsert.setInt(NRO_INTERNO_COMPO,proxNroInterno);
    qInsert.setInt(OID_GRUPO_COMPO,pers.getGrupo_compo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO = 3;
    final int NRO_INTERNO_COMPO = 4;
    final int OID_GRUPO_COMPO = 5;
    final int ACTIVO = 6;
    final int OID_COMPO_PRESU = 7;

    CompoPresupuestario pers = (CompoPresupuestario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plCompoPresu set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo=?"+ 
              ",nro_interno_compo=?"+ 
              ",oid_grupo_compo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_compo_presu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_PRESU,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setInt(NRO_INTERNO_COMPO,pers.getNro_interno_compo().intValue());
    qUpdate.setInt(OID_GRUPO_COMPO,pers.getGrupo_compo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_PRESU = 1; 
    CompoPresupuestario pers = (CompoPresupuestario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCompoPresu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_compo_presu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_PRESU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_PRESU = 1; 
    CompoPresupuestario pers = (CompoPresupuestario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCompoPresu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compo_presu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_PRESU, pers.getOID()); 
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
      case SELECT_BY_GRUPO_COMPO: {
        ps = this.selectByGrupoCompo(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMPO_PRESU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCompoPresu "); 
    textSQL.append(" WHERE oid_compo_presu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPO_PRESU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCompoPresu "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoCompo(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("select * from  plCompoPresu "); 
    textSQL.append(" where oid_grupo_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    GrupoComponente grupoComponente = (GrupoComponente) aCondiciones;
    querySelect.setInt(1, grupoComponente.getOID()); 
    return querySelect;     
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_presu oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plCompoPresu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static int getUltimoNroInterno(ISesion aSesion) throws BaseException {

		 try { 
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_interno_compo) nro_interno_compo ");
		    textSQL.append(" from plCompoPresu ");

		    PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		    
		    ResultSet rs = querySelect.executeQuery();
		    int ultimoNro = 0;
		    if (rs.next())
		    	ultimoNro = rs.getInt(1);
		    rs.close();
		    querySelect.close();	    
		    
		    return ultimoNro;
		 }
		 catch(Exception e) {
			 throw new BaseException(null,e.getMessage());
		 }
		 
	}
  
  public static List getComponentesByGrupo(GrupoComponente grupoComponente,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CompoPresupuestario.NICKNAME,
         DBCompoPresupuestario.SELECT_BY_GRUPO_COMPO,
         grupoComponente,
         new ListObserver(),
         aSesion);
  }
  
} 
