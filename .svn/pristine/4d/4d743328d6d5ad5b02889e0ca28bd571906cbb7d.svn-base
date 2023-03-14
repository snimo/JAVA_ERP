package com.srn.erp.cip.da;

import java.sql.*;

import com.srn.erp.cip.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBNovedadPayroll extends DBObjetoPersistente {

  public static final String OID_TBCAS_NMO = "oid_tbcas_nmo";
  public static final String NMONOVEDAD = "nmonovedad";
  public static final String NMOORDENPR = "nmoordenpr";
  public static final String NMOFECHA = "nmofecha";
  public static final String NMOLEGAJO = "nmolegajo";
  public static final String ACTIVO = "activo";
  public static final String NMOCEX = "nmocex";
  
  public static final int TRUNCATE_TABLE_NOVEDAD = 100;

  public DBNovedadPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TBCAS_NMO = 1;
    final int NMONOVEDAD = 2;
    final int NMOORDENPR = 3;
    final int NMOFECHA = 4;
    final int NMOLEGAJO = 5;
    final int ACTIVO = 6;
    final int NMOCEX = 7; 

    NovedadPayroll pers = (NovedadPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payTbcasnmo "+
                     " ( "+
                      "OID_TBCAS_NMO,"+
                      "NMONOVEDAD,"+
                      "NMOORDENPR,"+
                      "NMOFECHA,"+
                      "NMOLEGAJO,"+
                      "ACTIVO,NMOCEX)"+ 
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
    qInsert.setInt(OID_TBCAS_NMO,pers.getOID());
    if (pers.getNmonovedad()!=null)
    	qInsert.setInt(NMONOVEDAD,pers.getNmonovedad().intValue());
    else
    	qInsert.setNull(NMONOVEDAD, Types.INTEGER);
    if (pers.getNmoordenpr()!=null)
    	qInsert.setInt(NMOORDENPR,pers.getNmoordenpr().intValue());
    else
    	qInsert.setNull(NMOORDENPR, Types.INTEGER);
    if (pers.getNmofecha()!=null) 
      qInsert.setDate(NMOFECHA,new java.sql.Date(pers.getNmofecha().getTime()));
    else
      qInsert.setNull(NMOFECHA,java.sql.Types.DATE);
    if (pers.getNmolegajo()!=null)
    	qInsert.setString(NMOLEGAJO,pers.getNmolegajo());
    else
    	qInsert.setNull(NMOLEGAJO,Types.CHAR);
    
    if (pers.getNmoCex()!=null)
    	qInsert.setString(NMOCEX, pers.getNmoCex());
    else
    	qInsert.setNull(NMOCEX, Types.CHAR);
    
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NMONOVEDAD = 1;
    final int NMOORDENPR = 2;
    final int NMOFECHA = 3;
    final int NMOLEGAJO = 4;
    final int ACTIVO = 5;
    final int NMOCEX = 6;
    final int OID_TBCAS_NMO = 7;

    NovedadPayroll pers = (NovedadPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payTbcasnmo set "+
              "nmonovedad=?"+ 
              ",nmoordenpr=?"+ 
              ",nmofecha=?"+ 
              ",nmolegajo=?"+ 
              ",activo=?"+ 
              ",NMOCEX=? "+
                 " where " +
                 " oid_tbcas_nmo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBCAS_NMO,pers.getOID());
    if (pers.getNmonovedad()!=null)
    	qUpdate.setInt(NMONOVEDAD,pers.getNmonovedad().intValue());
    else
    	qUpdate.setNull(NMONOVEDAD,Types.INTEGER);
    if (pers.getNmoordenpr()!=null)
    	qUpdate.setInt(NMOORDENPR,pers.getNmoordenpr().intValue());
    else
    	qUpdate.setNull(NMOORDENPR,Types.INTEGER);
    if (pers.getNmofecha()!=null) 
      qUpdate.setDate(NMOFECHA,new java.sql.Date(pers.getNmofecha().getTime()));
    else
      qUpdate.setNull(NMOFECHA,java.sql.Types.DATE);
    if (pers.getNmolegajo()!=null)
    	qUpdate.setString(NMOLEGAJO,pers.getNmolegajo());
    else
    	qUpdate.setNull(NMOLEGAJO,Types.CHAR);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNmoCex()!=null)
    	qUpdate.setString(NMOCEX, pers.getNmoCex());
    else
    	qUpdate.setNull(NMOCEX, Types.CHAR);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TBCAS_NMO = 1; 
    NovedadPayroll pers = (NovedadPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payTbcasnmo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tbcas_nmo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBCAS_NMO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TBCAS_NMO = 1; 
    NovedadPayroll pers = (NovedadPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payTbcasnmo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tbcas_nmo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TBCAS_NMO, pers.getOID()); 
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
      case TRUNCATE_TABLE_NOVEDAD: {
          ps = this.truncarTablaNovedad(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TBCAS_NMO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payTbcasnmo "); 
    textSQL.append(" WHERE oid_tbcas_nmo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TBCAS_NMO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payTbcasnmo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tbcas_nmo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from payTbcasnmo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaNovedad(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payTbcasnmo ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
  }
  
  public static void truncarTablaNovedades(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(NovedadPayroll.NICKNAME,
		  				DBNovedadPayroll.TRUNCATE_TABLE_NOVEDAD,
		  				null,
		  				null,
		  				aSesion);
  }
  
  
} 
