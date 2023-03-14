package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBProyecto extends DBObjetoPersistente {

  public static final String OID_PROYECTO = "oid_proyecto";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String CERRADO = "cerrado";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String ACTIVO = "activo";
  public static final String OID_CLASIF_01 = "oid_clasif_01";
  public static final String OID_CLASIF_02 = "oid_clasif_02";
  public static final String OID_CLASIF_03 = "oid_clasif_03";
  public static final String OID_CLASIF_04 = "oid_clasif_04";
  public static final String OID_CLASIF_05 = "oid_clasif_05";
  public static final String OID_CLASIF_06 = "oid_clasif_06";
  public static final String OID_CLASIF_07 = "oid_clasif_07";
  public static final String OID_CLASIF_08 = "oid_clasif_08";
  public static final String OID_CLASIF_09 = "oid_clasif_09";
  public static final String OID_CLASIF_10 = "oid_clasif_10";
  public static final String OID_CLASIF_11 = "oid_clasif_11";
  public static final String OID_CLASIF_12 = "oid_clasif_12";
  public static final String OID_CLASIF_13 = "oid_clasif_13";
  public static final String OID_CLASIF_14 = "oid_clasif_14";
  public static final String OID_CLASIF_15 = "oid_clasif_15";
  public static final String OID_CLASIF_16 = "oid_clasif_16";
  public static final String OID_CLASIF_17 = "oid_clasif_17";
  public static final String OID_CLASIF_18 = "oid_clasif_18";
  public static final String OID_CLASIF_19 = "oid_clasif_19";
  public static final String OID_CLASIF_20 = "oid_clasif_20";
  
  public static final int SELECT_BY_SUJETO = 100;
  public static final int SELECT_SIN_SUJETO = 101;
  
  public DBProyecto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROYECTO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int CERRADO = 4;
    final int OID_SUJETO = 5;
    final int ACTIVO = 6;
    
    final int OID_CLASIF_01 = 7;
    final int OID_CLASIF_02 = 8;
    final int OID_CLASIF_03 = 9;
    final int OID_CLASIF_04 = 10;
    final int OID_CLASIF_05 = 11;
    final int OID_CLASIF_06 = 12;
    final int OID_CLASIF_07 = 13;
    final int OID_CLASIF_08 = 14;
    final int OID_CLASIF_09 = 15;
    final int OID_CLASIF_10 = 16;
    final int OID_CLASIF_11 = 17;
    final int OID_CLASIF_12 = 18;
    final int OID_CLASIF_13 = 19;
    final int OID_CLASIF_14 = 20;
    final int OID_CLASIF_15 = 21;
    final int OID_CLASIF_16 = 22;
    final int OID_CLASIF_17 = 23;
    final int OID_CLASIF_18 = 24;
    final int OID_CLASIF_19 = 25;
    final int OID_CLASIF_20 = 26;
    

    Proyecto pers = (Proyecto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veProyecto "+
                     " ( "+
                      "OID_PROYECTO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "CERRADO,"+
                      "OID_SUJETO,"+
                      "ACTIVO,"+
                      "OID_CLASIF_01,"+
                      "OID_CLASIF_02,"+
                      "OID_CLASIF_03,"+
                      "OID_CLASIF_04,"+
                      "OID_CLASIF_05,"+
                      "OID_CLASIF_06,"+
                      "OID_CLASIF_07,"+
                      "OID_CLASIF_08,"+
                      "OID_CLASIF_09,"+
                      "OID_CLASIF_10,"+
                      "OID_CLASIF_11,"+
                      "OID_CLASIF_12,"+
                      "OID_CLASIF_13,"+
                      "OID_CLASIF_14,"+
                      "OID_CLASIF_15,"+
                      "OID_CLASIF_16,"+
                      "OID_CLASIF_17,"+
                      "OID_CLASIF_18,"+
                      "OID_CLASIF_19,"+
                      "OID_CLASIF_20) "+                      
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROYECTO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(CERRADO,pers.isCerrado().booleanValue());
    if (pers.getSujeto()!=null) 
      qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    else
      qInsert.setNull(OID_SUJETO,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    qInsert.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qInsert.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qInsert.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qInsert.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qInsert.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qInsert.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qInsert.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qInsert.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qInsert.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qInsert.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qInsert.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qInsert.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qInsert.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qInsert.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qInsert.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qInsert.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qInsert.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qInsert.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qInsert.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qInsert.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int CERRADO = 3;
    final int OID_SUJETO = 4;
    final int ACTIVO = 5;
    
    final int OID_CLASIF_01 = 6;
    final int OID_CLASIF_02 = 7;
    final int OID_CLASIF_03 = 8;
    final int OID_CLASIF_04 = 9;
    final int OID_CLASIF_05 = 10;
    final int OID_CLASIF_06 = 11;
    final int OID_CLASIF_07 = 12;
    final int OID_CLASIF_08 = 13;
    final int OID_CLASIF_09 = 14;
    final int OID_CLASIF_10 = 15;
    final int OID_CLASIF_11 = 16;
    final int OID_CLASIF_12 = 17;
    final int OID_CLASIF_13 = 18;
    final int OID_CLASIF_14 = 19;
    final int OID_CLASIF_15 = 20;
    final int OID_CLASIF_16 = 21;
    final int OID_CLASIF_17 = 22;
    final int OID_CLASIF_18 = 23;
    final int OID_CLASIF_19 = 24;
    final int OID_CLASIF_20 = 25;
    
    
    final int OID_PROYECTO = 26;

    Proyecto pers = (Proyecto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veProyecto set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",cerrado=?"+ 
              ",oid_sujeto=?"+ 
              ",activo=?,"+ 
              "oid_clasif_01 = ?,"+
              "oid_clasif_02 = ?,"+
              "oid_clasif_03 = ?,"+
              "oid_clasif_04 = ?,"+
              "oid_clasif_05 = ?,"+
              "oid_clasif_06 = ?,"+
              "oid_clasif_07 = ?,"+
              "oid_clasif_08 = ?,"+
              "oid_clasif_09 = ?,"+
              "oid_clasif_10 = ?,"+
              "oid_clasif_11 = ?,"+
              "oid_clasif_12 = ?,"+
              "oid_clasif_13 = ?,"+
              "oid_clasif_14 = ?,"+
              "oid_clasif_15 = ?,"+
              "oid_clasif_16 = ?,"+
              "oid_clasif_17 = ?,"+
              "oid_clasif_18 = ?,"+
              "oid_clasif_19 = ?,"+
              "oid_clasif_20 = ? "+              
                 " where " +
                 " oid_proyecto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROYECTO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(CERRADO,pers.isCerrado().booleanValue());
    if (pers.getSujeto()!=null) 
      qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    else
      qUpdate.setNull(OID_SUJETO,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    qUpdate.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qUpdate.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qUpdate.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qUpdate.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qUpdate.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qUpdate.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qUpdate.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qUpdate.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qUpdate.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qUpdate.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qUpdate.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qUpdate.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qUpdate.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qUpdate.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qUpdate.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qUpdate.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qUpdate.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qUpdate.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qUpdate.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qUpdate.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROYECTO = 1; 
    Proyecto pers = (Proyecto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veProyecto "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proyecto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROYECTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROYECTO = 1; 
    Proyecto pers = (Proyecto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veProyecto "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proyecto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROYECTO, pers.getOID()); 
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
      case SELECT_BY_SUJETO: { 
          ps = this.selectBySujeto(aCondiciones); 
          break; 
      }
      case SELECT_SIN_SUJETO: { 
          ps = this.selectBySinSujeto(aCondiciones); 
          break; 
      } 
      
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROYECTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veProyecto "); 
    textSQL.append(" WHERE oid_proyecto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROYECTO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veProyecto "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veProyecto "); 
	    textSQL.append(" WHERE oid_sujeto = ? ");
	    
	    
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
	    
	    if (condiciones.containsKey("ACTIVO"))
	    	textSQL.append(" and activo = 1 ");
	    	
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, sujeto.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectBySinSujeto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veProyecto "); 
	    textSQL.append(" WHERE oid_sujeto is null ");
	    
	    
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    if (condiciones.containsKey("ACTIVO"))
	    	textSQL.append(" and activo = 1 ");
	    	
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
}
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proyecto oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from veProyecto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProyectosDelSujeto(Sujeto sujeto,boolean soloActivos,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  
	  condiciones.put(Sujeto.NICKNAME, sujeto);
	  if (soloActivos)
		  condiciones.put("ACTIVOS", "");
	  
	  return (List) ObjetoLogico.getObjects(Proyecto.NICKNAME,
             DBProyecto.SELECT_BY_SUJETO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getProyectosSinSujeto(boolean soloActivos,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  
	  if (soloActivos)
		  condiciones.put("ACTIVOS", "");
	  
	  return (List) ObjetoLogico.getObjects(Proyecto.NICKNAME,
             DBProyecto.SELECT_SIN_SUJETO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
