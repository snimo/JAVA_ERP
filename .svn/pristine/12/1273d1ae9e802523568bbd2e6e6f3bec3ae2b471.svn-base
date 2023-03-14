package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.bm.VarEscenarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBVarEscenarioDet extends DBObjetoPersistente {

  public static final String OID_VAR_ESC_DET = "oid_var_esc_det";
  public static final String OID_VAR_ESC_CAB = "oid_var_esc_cab";
  public static final String SECU = "secu";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String ACTIVO = "activo";
  public static final String NRO_INT_VAL_COMPO = "nro_int_val_compo";
  
  public static final int SELECT_BY_VAR_ESCENARIO_CAB = 100;
  public static final int SELECT_BY_VAR_ESCENARIO_CAB_ORDER_NRO_INT = 101;

  public DBVarEscenarioDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAR_ESC_DET = 1;
    final int OID_VAR_ESC_CAB = 2;
    final int SECU = 3;
    final int OID_COMPO_PRESU = 4;
    final int ACTIVO = 5;
    final int NRO_INT_VAL_COMPO = 6;

    VarEscenarioDet pers = (VarEscenarioDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plVarEsceDet "+
                     " ( "+
                      "OID_VAR_ESC_DET,"+
                      "OID_VAR_ESC_CAB,"+
                      "SECU,"+
                      "OID_COMPO_PRESU,"+
                      "ACTIVO,NRO_INT_VAL_COMPO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAR_ESC_DET,pers.getOID());
    qInsert.setInt(OID_VAR_ESC_CAB,pers.getVar_escenario_cab().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    int ultNroInt = getUltimoNroInterno(this.getSesion(),pers.getVar_escenario_cab());
    qInsert.setInt(NRO_INT_VAL_COMPO,ultNroInt+1);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAR_ESC_CAB = 1;
    final int SECU = 2;
    final int OID_COMPO_PRESU = 3;
    final int ACTIVO = 4;
    final int OID_VAR_ESC_DET = 5;

    VarEscenarioDet pers = (VarEscenarioDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plVarEsceDet set "+
              "oid_var_esc_cab=?"+ 
              ",secu=?"+ 
              ",oid_compo_presu=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_var_esc_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_DET,pers.getOID());
    qUpdate.setInt(OID_VAR_ESC_CAB,pers.getVar_escenario_cab().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAR_ESC_DET = 1; 
    VarEscenarioDet pers = (VarEscenarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plVarEsceDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_var_esc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAR_ESC_DET = 1; 
    VarEscenarioDet pers = (VarEscenarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plVarEsceDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_var_esc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_DET, pers.getOID()); 
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
      case SELECT_BY_VAR_ESCENARIO_CAB: {
        ps = this.selectByEscenarioCab(aCondiciones); 
        break; 
      }
      case SELECT_BY_VAR_ESCENARIO_CAB_ORDER_NRO_INT: {
        ps = this.selectByEscenarioCabOrderByNroInt(aCondiciones); 
        break; 
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAR_ESC_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceDet "); 
    textSQL.append(" WHERE oid_var_esc_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAR_ESC_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenarioCab(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceDet "); 
    textSQL.append(" WHERE oid_var_esc_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    VarEscenarioCab varEscenarioCab = (VarEscenarioCab) aCondiciones; 
    querySelect.setInt(1, varEscenarioCab.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenarioCabOrderByNroInt(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceDet "); 
    textSQL.append(" WHERE oid_var_esc_cab = ? order by nro_int_val_compo ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    VarEscenarioCab varEscenarioCab = (VarEscenarioCab) aCondiciones; 
    querySelect.setInt(1, varEscenarioCab.getOID()); 
    return querySelect; 
  }
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_var_esc_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plVarEsceDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getVariablesEscenarioDet(VarEscenarioCab varEscenarioCab,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(VarEscenarioDet.NICKNAME,
         DBVarEscenarioDet.SELECT_BY_VAR_ESCENARIO_CAB,
         varEscenarioCab,
         new ListObserver(),
         aSesion);
  }
  
  public static List getVariablesEscenarioDetOrderByNroInt(VarEscenarioCab varEscenarioCab,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(VarEscenarioDet.NICKNAME,
         DBVarEscenarioDet.SELECT_BY_VAR_ESCENARIO_CAB_ORDER_NRO_INT,
         varEscenarioCab,
         new ListObserver(),
         aSesion);
  }
  
  
  public static int getUltimoNroInterno(ISesion aSesion , VarEscenarioCab varEscenarioCab) throws BaseException {

		 try { 
			 	
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_int_val_compo) nro_interno ");
		    textSQL.append(" from plVarEsceDet where oid_var_esc_cab="+varEscenarioCab.getOIDInteger().toString());

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
  
  
  
} 
