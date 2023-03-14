package com.srn.erp.excluidos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.excluidos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEstadoPredioExc extends DBObjetoPersistente {

  public static final String OID_ESTADO_PREDIO = "oid_estado_predio";
  public static final String OID_ESTADO = "oid_estado";
  public static final String OID_PREDIO = "oid_predio";
  public static final String PROPONER_NRO = "proponer_nro";
  public static final String ULT_NRO_PROPU = "ult_nro_propu";
  public static final String NRO_ACTA_OBLI = "nro_acta_obli";
  public static final String PERMITE_MODIF_NRO = "permite_modif_nro";
  public static final String ACTIVO = "activo";
  public static final String CONSERVA_NRO = "conserva_nro";
  
  public static final int SELECT_BY_ESTADO = 100;

  public DBEstadoPredioExc() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO_PREDIO = 1;
    final int OID_ESTADO = 2;
    final int OID_PREDIO = 3;
    final int PROPONER_NRO = 4;
    final int ULT_NRO_PROPU = 5;
    final int NRO_ACTA_OBLI = 6;
    final int PERMITE_MODIF_NRO = 7;
    final int ACTIVO = 8;
    final int CONSERVA_NRO = 9;

    EstadoPredioExc pers = (EstadoPredioExc) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excEstadosPredio "+
                     " ( "+
                      "OID_ESTADO_PREDIO,"+
                      "OID_ESTADO,"+
                      "OID_PREDIO,"+
                      "PROPONER_NRO,"+
                      "ULT_NRO_PROPU,"+
                      "NRO_ACTA_OBLI,"+
                      "PERMITE_MODIF_NRO,"+
                      "ACTIVO,"+
                      "CONSERVA_NRO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTADO_PREDIO,pers.getOID());
    qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
    qInsert.setInt(OID_PREDIO,pers.getPredio().getOID());
    if (pers.getProponer_nro()!=null)
    	qInsert.setBoolean(PROPONER_NRO,pers.getProponer_nro().booleanValue());
    else
    	qInsert.setBoolean(PROPONER_NRO,false);
    if (pers.getUlt_nro_propu()!=null)
    	qInsert.setInt(ULT_NRO_PROPU,pers.getUlt_nro_propu().intValue());
    else
    	qInsert.setInt(ULT_NRO_PROPU,0);
    if (pers.getNro_acta_obli()!=null)
    	qInsert.setBoolean(NRO_ACTA_OBLI,pers.getNro_acta_obli().booleanValue());
    else
    	qInsert.setBoolean(NRO_ACTA_OBLI,false);
    if (pers.getPermite_modif_nro()!=null)
    	qInsert.setBoolean(PERMITE_MODIF_NRO,pers.getPermite_modif_nro().booleanValue());
    else
    	qInsert.setBoolean(PERMITE_MODIF_NRO,false);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getConserva_nro()!=null)
    	qInsert.setBoolean(CONSERVA_NRO,pers.getConserva_nro().booleanValue());
    else
    	qInsert.setBoolean(CONSERVA_NRO,false);

    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO = 1;
    final int OID_PREDIO = 2;
    final int PROPONER_NRO = 3;
    final int ULT_NRO_PROPU = 4;
    final int NRO_ACTA_OBLI = 5;
    final int PERMITE_MODIF_NRO = 6;
    final int ACTIVO = 7;
    final int CONSERVA_NRO = 8;
    final int OID_ESTADO_PREDIO = 9;

    EstadoPredioExc pers = (EstadoPredioExc) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excEstadosPredio set "+
              "oid_estado=?"+ 
              ",oid_predio=?"+ 
              ",proponer_nro=?"+ 
              ",ult_nro_propu=?"+ 
              ",nro_acta_obli=?"+ 
              ",permite_modif_nro=?"+ 
              ",activo=?"+ 
              ",conserva_nro=?"+ 
                 " where " +
                 " oid_estado_predio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_PREDIO,pers.getOID());
    qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    qUpdate.setInt(OID_PREDIO,pers.getPredio().getOID());
    if (pers.getProponer_nro()!=null)
    	qUpdate.setBoolean(PROPONER_NRO,pers.getProponer_nro().booleanValue());
    else
    	qUpdate.setBoolean(PROPONER_NRO,false);
    if (pers.getUlt_nro_propu()!=null)
    	qUpdate.setInt(ULT_NRO_PROPU,pers.getUlt_nro_propu().intValue());
    else
    	qUpdate.setInt(ULT_NRO_PROPU,0);
    if (pers.getNro_acta_obli()!=null)
    	qUpdate.setBoolean(NRO_ACTA_OBLI,pers.getNro_acta_obli().booleanValue());
    else
    	qUpdate.setBoolean(NRO_ACTA_OBLI,false);
    if (pers.getPermite_modif_nro()!=null)
    	qUpdate.setBoolean(PERMITE_MODIF_NRO,pers.getPermite_modif_nro().booleanValue());
    else
    	qUpdate.setBoolean(PERMITE_MODIF_NRO,false);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getConserva_nro()!=null)
    	qUpdate.setBoolean(CONSERVA_NRO,pers.getConserva_nro().booleanValue());
    else
    	qUpdate.setBoolean(CONSERVA_NRO,false);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_PREDIO = 1; 
    EstadoPredioExc pers = (EstadoPredioExc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excEstadosPredio "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estado_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_PREDIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO_PREDIO = 1; 
    EstadoPredioExc pers = (EstadoPredioExc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excEstadosPredio "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estado_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO_PREDIO, pers.getOID()); 
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
      case DBEstadoPredioExc.SELECT_BY_ESTADO: { 
          ps = this.selectByEstado(aCondiciones); 
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

    final int OID_ESTADO_PREDIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excEstadosPredio "); 
    textSQL.append(" WHERE oid_estado_predio = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTADO_PREDIO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excEstadosPredio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstado(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excEstadosPredio "); 
	    textSQL.append(" WHERE oid_estado  = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EstadoExcluido estado = (EstadoExcluido) aCondiciones; 
	    querySelect.setInt(1, estado.getOID()); 
	    return querySelect; 
	  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estado_predio oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excEstadosPredio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEstadosExcluidos(
			  	EstadoExcluido estado,
			  	ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoPredioExc.NICKNAME,
               DBEstadoPredioExc.SELECT_BY_ESTADO,
               estado
               ,
               new ListObserver(),
               aSesion);
  }
  
  
} 
