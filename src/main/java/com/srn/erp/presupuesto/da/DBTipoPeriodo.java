package com.srn.erp.presupuesto.da;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.TipoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTipoPeriodo extends DBObjetoPersistente {

  public static final String OID_TIPO_PERI = "oid_tipo_peri";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String NRO_INTERNO = "nro_interno";
  
  public static final int SELECT_BY_NRO_INTERNO = 100;
  
  

  public DBTipoPeriodo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_PERI = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int NRO_INTERNO = 5;

    TipoPeriodo pers = (TipoPeriodo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plTipoPeri "+
                     " ( "+
                      "OID_TIPO_PERI,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,NRO_INTERNO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+                      
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TIPO_PERI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    int proxNroInterno = getUltimoNroInterno(this.getSesion())+1;
    qInsert.setInt(NRO_INTERNO,proxNroInterno);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_TIPO_PERI = 4;

    TipoPeriodo pers = (TipoPeriodo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plTipoPeri set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+
                 " where " +
                 " oid_tipo_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_PERI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_PERI = 1; 
    TipoPeriodo pers = (TipoPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plTipoPeri "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_PERI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_PERI = 1; 
    TipoPeriodo pers = (TipoPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plTipoPeri "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_PERI, pers.getOID()); 
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
      case SELECT_ALL: {
        ps = this.selectAll(aCondiciones); 
        break; 
      }
      case SELECT_BY_NRO_INTERNO: {
        ps = this.selectByNroInterno(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TIPO_PERI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plTipoPeri "); 
    textSQL.append(" WHERE oid_tipo_peri = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_PERI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByNroInterno(Object aCondiciones) throws BaseException, SQLException { 
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  plTipoPeri "); 
  	 textSQL.append(" WHERE nro_interno = ? ");
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 Integer nroInterno = (Integer) aCondiciones; 
  	 querySelect.setInt(1, nroInterno.intValue()); 
  	 return querySelect; 
  }
  		
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plTipoPeri "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_peri oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plTipoPeri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT * ");
    textSQL.append(" from plTipoPeri");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllTiposPediodos(ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(TipoPeriodo.NICKNAME,
         DBTipoPeriodo.SELECT_ALL,
         null,
         new ListObserver(),
         aSesion);
  }
  

  public static int getUltimoNroInterno(ISesion aSesion) throws BaseException {

		 try { 
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_interno) nro_interno ");
		    textSQL.append(" from plTipoPeri ");

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
  
  public static TipoPeriodo getTipoPeriodo(Integer aNroInterno,
				ISesion aSesion)
  	throws BaseException {
  	return (TipoPeriodo) ObjetoLogico.getObjects(TipoPeriodo.NICKNAME,
  			DBTipoPeriodo.SELECT_BY_NRO_INTERNO,
  			aNroInterno,
  			new ObjetoObservado(),
  			aSesion);
  }
  
  
  
} 
