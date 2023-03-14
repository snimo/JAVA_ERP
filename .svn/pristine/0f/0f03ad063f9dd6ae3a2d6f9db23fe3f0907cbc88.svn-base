package com.srn.erp.general.da;

import java.sql.*;
import com.srn.erp.general.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBComprobanteImpreso extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String IMPRE_GENERADA = "impre_generada";
  public static final String IMPRE_FECHA = "impre_fecha";
  public static final String IMPRE_HORA = "impre_hora";
  public static final String IMPRE_USU = "impre_usu";
  public static final String IMPRE_CANT = "impre_cant";
  public static final String PDF_GENERADO = "pdf_generado";
  public static final String PDF_FECHA = "pdf_fecha";
  public static final String PDF_HORA = "pdf_hora";
  public static final String PDF_USU = "pdf_usu";
  public static final String PDF_CANT = "pdf_cant";
  public static final String VERSION_EXTERNA = "version_externa";
  public static final String VERSION_CONGELADA = "version_congelada";
  public static final String VERSION_FECHA = "version_fecha";
  public static final String VERSION_HORA = "version_hora";
  public static final String VERSION_USU = "version_usu";
  

  public DBComprobanteImpreso() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int IMPRE_GENERADA = 2;
    final int IMPRE_FECHA = 3;
    final int IMPRE_HORA = 4;
    final int IMPRE_USU = 5;
    final int IMPRE_CANT = 6;
    final int PDF_GENERADO = 7;
    final int PDF_FECHA = 8;
    final int PDF_HORA = 9;
    final int PDF_USU = 10;
    final int PDF_CANT = 11;
    final int VERSION_EXTERNA = 12;
    final int VERSION_CONGELADA = 13;
    final int VERSION_FECHA = 14;
    final int VERSION_HORA = 15;
    final int VERSION_USU = 16;

    ComprobanteImpreso pers = (ComprobanteImpreso) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geComproCab "+
                     " ( "+
                      "OID_CCO,"+
                      "IMPRE_GENERADA,"+
                      "IMPRE_FECHA,"+
                      "IMPRE_HORA,"+
                      "IMPRE_USU,"+
                      "IMPRE_CANT,"+
                      "PDF_GENERADO,"+
                      "PDF_FECHA,"+
                      "PDF_HORA,"+
                      "PDF_USU,"+
                      "PDF_CANT,"+
                      "VERSION_EXTERNA,VERSION_CONGELADA,VERSION_FECHA,VERSION_HORA,VERSION_USU)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO,pers.getOID());
    if (pers.isImpre_generada()!=null)
    	qInsert.setBoolean(IMPRE_GENERADA,pers.isImpre_generada().booleanValue());
    else
    	qInsert.setBoolean(IMPRE_GENERADA,false);
    if (pers.getImpre_fecha()!=null)
    	qInsert.setDate(IMPRE_FECHA,new java.sql.Date(pers.getImpre_fecha().getTime()));
    else
    	qInsert.setNull(IMPRE_FECHA,java.sql.Types.DATE);
    if (pers.getImpre_hora()!=null)	
    	qInsert.setString(IMPRE_HORA,pers.getImpre_hora());
    else
    	qInsert.setNull(IMPRE_HORA,java.sql.Types.VARCHAR);
    if (pers.getImpre_usu()!=null)	
    	qInsert.setInt(IMPRE_USU,pers.getImpre_usu().intValue());
    else
    	qInsert.setNull(IMPRE_USU,java.sql.Types.INTEGER);
    if (pers.getImpre_cant()!=null)
    	qInsert.setInt(IMPRE_CANT,pers.getImpre_cant().intValue());
    else
    	qInsert.setNull(IMPRE_CANT,java.sql.Types.INTEGER);
    if (pers.isPdf_generado()!=null)
    	qInsert.setBoolean(PDF_GENERADO,pers.isPdf_generado().booleanValue());
    else
    	qInsert.setBoolean(PDF_GENERADO,false);
    if (pers.getPdf_fecha()!=null)
    	qInsert.setDate(PDF_FECHA,new java.sql.Date(pers.getPdf_fecha().getTime()));
    else
    	qInsert.setNull(PDF_FECHA,java.sql.Types.DATE);
    if (pers.getPdf_hora()!=null)
    	qInsert.setString(PDF_HORA,pers.getPdf_hora());
    else
    	qInsert.setNull(PDF_HORA,java.sql.Types.VARCHAR);
    if (pers.getPdf_usu()!=null)
    	qInsert.setInt(PDF_USU,pers.getPdf_usu().intValue());
    else
    	qInsert.setNull(PDF_USU,java.sql.Types.INTEGER);
    if (pers.getPdf_cant()!=null)
    	qInsert.setInt(PDF_CANT,pers.getPdf_cant().intValue());
    else
    	qInsert.setNull(PDF_CANT,java.sql.Types.INTEGER);
    if (pers.getVersion_externa()!=null)
    	qInsert.setInt(VERSION_EXTERNA,pers.getVersion_externa().intValue());
    else
    	qInsert.setNull(VERSION_EXTERNA,java.sql.Types.INTEGER);
    if (pers.isVersionCongelada()!=null)
    	qInsert.setBoolean(VERSION_CONGELADA,pers.isVersionCongelada().booleanValue());
    else
    	qInsert.setNull(VERSION_CONGELADA,java.sql.Types.BOOLEAN);
    if (pers.getVersion_fecha()!=null)
    	qInsert.setDate(VERSION_FECHA,new java.sql.Date(pers.getVersion_fecha().getTime()));
    else
    	qInsert.setNull(VERSION_FECHA,java.sql.Types.DATE);
    if (pers.getVersion_hora()!=null)
    	qInsert.setString(VERSION_HORA,pers.getVersion_hora());
    else
    	qInsert.setNull(VERSION_HORA,java.sql.Types.VARCHAR);
    if (pers.getVersion_usu()!=null)
    	qInsert.setInt(VERSION_USU,pers.getVersion_usu().intValue());
    else
    	qInsert.setNull(VERSION_USU,java.sql.Types.INTEGER);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int IMPRE_GENERADA = 1;
    final int IMPRE_FECHA = 2;
    final int IMPRE_HORA = 3;
    final int IMPRE_USU = 4;
    final int IMPRE_CANT = 5;
    final int PDF_GENERADO = 6;
    final int PDF_FECHA = 7;
    final int PDF_HORA = 8;
    final int PDF_USU = 9;
    final int PDF_CANT = 10;
    final int VERSION_EXTERNA = 11;
    final int VERSION_CONGELADA = 12;
    final int VERSION_FECHA = 13;
    final int VERSION_HORA = 14;
    final int VERSION_USU = 15;
    final int OID_CCO = 16;

    ComprobanteImpreso pers = (ComprobanteImpreso) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geComproCab set "+
              "impre_generada=?"+ 
              ",impre_fecha=?"+ 
              ",impre_hora=?"+ 
              ",impre_usu=?"+ 
              ",impre_cant=?"+ 
              ",pdf_generado=?"+ 
              ",pdf_fecha=?"+ 
              ",pdf_hora=?"+ 
              ",pdf_usu=?"+ 
              ",pdf_cant=?"+ 
              ",version_externa=?"+
              ",version_congelada=?"+
              ",version_fecha=?"+
              ",version_hora=?"+
              ",version_usu=?"+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    if (pers.isImpre_generada()!=null)
    	qUpdate.setBoolean(IMPRE_GENERADA,pers.isImpre_generada().booleanValue());
    else
    	qUpdate.setBoolean(IMPRE_GENERADA,false);
    if (pers.getImpre_fecha()!=null)
    	qUpdate.setDate(IMPRE_FECHA,new java.sql.Date(pers.getImpre_fecha().getTime()));
    else
    	qUpdate.setNull(IMPRE_FECHA,java.sql.Types.DATE);
    if (pers.getImpre_hora()!=null)	
    	qUpdate.setString(IMPRE_HORA,pers.getImpre_hora());
    else
    	qUpdate.setNull(IMPRE_HORA,java.sql.Types.VARCHAR);
    if (pers.getImpre_usu()!=null)	
    	qUpdate.setInt(IMPRE_USU,pers.getImpre_usu().intValue());
    else
    	qUpdate.setNull(IMPRE_USU,java.sql.Types.INTEGER);
    if (pers.getImpre_cant()!=null)
    	qUpdate.setInt(IMPRE_CANT,pers.getImpre_cant().intValue());
    else
    	qUpdate.setNull(IMPRE_CANT,java.sql.Types.INTEGER);
    if (pers.isPdf_generado()!=null)
    	qUpdate.setBoolean(PDF_GENERADO,pers.isPdf_generado().booleanValue());
    else
    	qUpdate.setBoolean(PDF_GENERADO,false);
    if (pers.getPdf_fecha()!=null)
    	qUpdate.setDate(PDF_FECHA,new java.sql.Date(pers.getPdf_fecha().getTime()));
    else
    	qUpdate.setNull(PDF_FECHA,java.sql.Types.DATE);
    if (pers.getPdf_hora()!=null)
    	qUpdate.setString(PDF_HORA,pers.getPdf_hora());
    else
    	qUpdate.setNull(PDF_HORA,java.sql.Types.VARCHAR);
    if (pers.getPdf_usu()!=null)
    	qUpdate.setInt(PDF_USU,pers.getPdf_usu().intValue());
    else
    	qUpdate.setNull(PDF_USU,java.sql.Types.INTEGER);
    if (pers.getPdf_cant()!=null)
    	qUpdate.setInt(PDF_CANT,pers.getPdf_cant().intValue());
    else
    	qUpdate.setNull(PDF_CANT,java.sql.Types.INTEGER);
    if (pers.getVersion_externa()!=null)
    	qUpdate.setInt(VERSION_EXTERNA,pers.getVersion_externa().intValue());
    else
    	qUpdate.setNull(VERSION_EXTERNA,java.sql.Types.INTEGER);
    if (pers.isVersionCongelada()!=null)
    	qUpdate.setBoolean(VERSION_CONGELADA,pers.isVersionCongelada().booleanValue());
    else
    	qUpdate.setNull(VERSION_CONGELADA,java.sql.Types.BOOLEAN);
    if (pers.getVersion_fecha()!=null)
    	qUpdate.setDate(VERSION_FECHA,new java.sql.Date(pers.getVersion_fecha().getTime()));
    else
    	qUpdate.setNull(VERSION_FECHA,java.sql.Types.DATE);
    if (pers.getVersion_hora()!=null)
    	qUpdate.setString(VERSION_HORA,pers.getVersion_hora());
    else
    	qUpdate.setNull(VERSION_HORA,java.sql.Types.VARCHAR);
    if (pers.getVersion_usu()!=null)
    	qUpdate.setInt(VERSION_USU,pers.getVersion_usu().intValue());
    else
    	qUpdate.setNull(VERSION_USU,java.sql.Types.INTEGER);
    
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO = 1; 
    ComprobanteImpreso pers = (ComprobanteImpreso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO = 1; 
    ComprobanteImpreso pers = (ComprobanteImpreso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CCO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geComproCab "); 
    textSQL.append(" WHERE oid_cco = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geComproCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geComproCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
