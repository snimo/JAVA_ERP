package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorVariableEscenario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorVariableEscenario extends DBObjetoPersistente {

  public static final String OID_VALOR_VAR_ESCE = "oid_valor_var_esce";
  public static final String OID_PERI = "oid_peri";
  public static final String OID_VALOR_COMPO_1 = "oid_valor_compo_1";
  public static final String OID_VALOR_COMPO_2 = "oid_valor_compo_2";
  public static final String OID_VALOR_COMPO_3 = "oid_valor_compo_3";
  public static final String OID_VALOR_COMPO_4 = "oid_valor_compo_4";
  public static final String OID_VALOR_COMPO_5 = "oid_valor_compo_5";
  public static final String OID_VALOR_COMPO_6 = "oid_valor_compo_6";
  public static final String OID_VALOR_COMPO_7 = "oid_valor_compo_7";
  public static final String OID_VALOR_COMPO_8 = "oid_valor_compo_8";
  public static final String OID_VALOR_COMPO_9 = "oid_valor_compo_9";
  public static final String VALOR = "valor";
  public static final String OID_VAR_ESC_CAB = "oid_var_esc_cab"; 
  
  public static final int SELECT_COMPONENTES_PERI = 100;
  public static final int SELECT_VAR_ESCE_CAB = 101;

  public DBValorVariableEscenario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VALOR_VAR_ESCE = 1;
    final int OID_PERI = 2;
    final int OID_VALOR_COMPO_1 = 3;
    final int OID_VALOR_COMPO_2 = 4;
    final int OID_VALOR_COMPO_3 = 5;
    final int OID_VALOR_COMPO_4 = 6;
    final int OID_VALOR_COMPO_5 = 7;
    final int OID_VALOR_COMPO_6 = 8;
    final int OID_VALOR_COMPO_7 = 9;
    final int OID_VALOR_COMPO_8 = 10;
    final int OID_VALOR_COMPO_9 = 11;
    final int VALOR = 12;
    final int OID_VAR_ESC_CAB = 13;

    ValorVariableEscenario pers = (ValorVariableEscenario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plValorVarEsce "+
                     " ( "+
                      "OID_VALOR_VAR_ESCE,"+
                      "OID_PERI,"+
                      "OID_VALOR_COMPO_1,"+
                      "OID_VALOR_COMPO_2,"+
                      "OID_VALOR_COMPO_3,"+
                      "OID_VALOR_COMPO_4,"+
                      "OID_VALOR_COMPO_5,"+
                      "OID_VALOR_COMPO_6,"+
                      "OID_VALOR_COMPO_7,"+
                      "OID_VALOR_COMPO_8,"+
                      "OID_VALOR_COMPO_9,"+
                      "VALOR,OID_VAR_ESC_CAB)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VALOR_VAR_ESCE,pers.getOID());
    if (pers.getPeriodo()!=null) 
      qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    else
      qInsert.setNull(OID_PERI,java.sql.Types.INTEGER);
    if (pers.getValor_compo_1()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_1,pers.getValor_compo_1().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_1,java.sql.Types.INTEGER);
    if (pers.getValor_compo_2()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_2,pers.getValor_compo_2().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_2,java.sql.Types.INTEGER);
    if (pers.getValor_compo_3()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_3,pers.getValor_compo_3().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_3,java.sql.Types.INTEGER);
    if (pers.getValor_compo_4()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_4,pers.getValor_compo_4().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_4,java.sql.Types.INTEGER);
    if (pers.getValor_compo_5()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_5,pers.getValor_compo_5().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_5,java.sql.Types.INTEGER);
    if (pers.getValor_compo_6()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_6,pers.getValor_compo_6().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_6,java.sql.Types.INTEGER);
    if (pers.getValor_compo_7()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_7,pers.getValor_compo_7().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_7,java.sql.Types.INTEGER);
    if (pers.getValor_compo_8()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_8,pers.getValor_compo_8().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_8,java.sql.Types.INTEGER);
    if (pers.getValor_compo_9()!=null) 
      qInsert.setInt(OID_VALOR_COMPO_9,pers.getValor_compo_9().getOID());
    else
      qInsert.setNull(OID_VALOR_COMPO_9,java.sql.Types.INTEGER);
    if (pers.getValor()!=null) 
      qInsert.setDouble(VALOR,pers.getValor().doubleValue());
    else
      qInsert.setNull(VALOR,java.sql.Types.DOUBLE);
    if (pers.getVariableEscenario()!=null) 
      qInsert.setDouble(OID_VAR_ESC_CAB,pers.getVariableEscenario().getOID());
    else
      qInsert.setNull(OID_VAR_ESC_CAB,java.sql.Types.INTEGER);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERI = 1;
    final int OID_VALOR_COMPO_1 = 2;
    final int OID_VALOR_COMPO_2 = 3;
    final int OID_VALOR_COMPO_3 = 4;
    final int OID_VALOR_COMPO_4 = 5;
    final int OID_VALOR_COMPO_5 = 6;
    final int OID_VALOR_COMPO_6 = 7;
    final int OID_VALOR_COMPO_7 = 8;
    final int OID_VALOR_COMPO_8 = 9;
    final int OID_VALOR_COMPO_9 = 10;
    final int VALOR = 11;
    final int OID_VAR_ESC_CAB = 12;
    final int OID_VALOR_VAR_ESCE = 13;

    ValorVariableEscenario pers = (ValorVariableEscenario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plValorVarEsce set "+
              "oid_peri=?"+ 
              ",oid_valor_compo_1=?"+ 
              ",oid_valor_compo_2=?"+ 
              ",oid_valor_compo_3=?"+ 
              ",oid_valor_compo_4=?"+ 
              ",oid_valor_compo_5=?"+ 
              ",oid_valor_compo_6=?"+ 
              ",oid_valor_compo_7=?"+ 
              ",oid_valor_compo_8=?"+ 
              ",oid_valor_compo_9=?"+ 
              ",valor=?"+ 
              ",oid_var_esc_cab=?"+ 
                 " where " +
                 " oid_valor_var_esce=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_VAR_ESCE,pers.getOID());
    if (pers.getPeriodo()!=null) 
      qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    else
      qUpdate.setNull(OID_PERI,java.sql.Types.INTEGER);
    if (pers.getValor_compo_1()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_1,pers.getValor_compo_1().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_1,java.sql.Types.INTEGER);
    if (pers.getValor_compo_2()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_2,pers.getValor_compo_2().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_2,java.sql.Types.INTEGER);
    if (pers.getValor_compo_3()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_3,pers.getValor_compo_3().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_3,java.sql.Types.INTEGER);
    if (pers.getValor_compo_4()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_4,pers.getValor_compo_4().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_4,java.sql.Types.INTEGER);
    if (pers.getValor_compo_5()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_5,pers.getValor_compo_5().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_5,java.sql.Types.INTEGER);
    if (pers.getValor_compo_6()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_6,pers.getValor_compo_6().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_6,java.sql.Types.INTEGER);
    if (pers.getValor_compo_7()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_7,pers.getValor_compo_7().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_7,java.sql.Types.INTEGER);
    if (pers.getValor_compo_8()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_8,pers.getValor_compo_8().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_8,java.sql.Types.INTEGER);
    if (pers.getValor_compo_9()!=null) 
      qUpdate.setInt(OID_VALOR_COMPO_9,pers.getValor_compo_9().getOID());
    else
      qUpdate.setNull(OID_VALOR_COMPO_9,java.sql.Types.INTEGER);
    if (pers.getValor()!=null) 
      qUpdate.setDouble(VALOR,pers.getValor().doubleValue());
    else
      qUpdate.setNull(VALOR,java.sql.Types.DOUBLE);
    if (pers.getVariableEscenario()!=null) 
      qUpdate.setInt(OID_VAR_ESC_CAB,pers.getVariableEscenario().getOID());
    else
      qUpdate.setNull(OID_VAR_ESC_CAB,java.sql.Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VALOR_VAR_ESCE = 1; 
    ValorVariableEscenario pers = (ValorVariableEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValorVarEsce "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_valor_var_esce=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_VAR_ESCE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VALOR_VAR_ESCE = 1; 
    ValorVariableEscenario pers = (ValorVariableEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValorVarEsce "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_valor_var_esce=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VALOR_VAR_ESCE, pers.getOID()); 
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
      case SELECT_COMPONENTES_PERI: {
        ps = this.selectByComponentesPeri(aCondiciones); 
        break; 
      }
      case SELECT_VAR_ESCE_CAB: {
        ps = this.selectByVarEsceCab(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VALOR_VAR_ESCE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorVarEsce "); 
    textSQL.append(" WHERE oid_valor_var_esce = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VALOR_VAR_ESCE, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorVarEsce "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_valor_var_esce oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plValorVarEsce");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  
  }
  
  private PreparedStatement selectByVarEsceCab(Object aCondiciones) throws BaseException, SQLException { 

    VarEscenarioCab varEscenario = (VarEscenarioCab) aCondiciones;

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorVarEsce "); 
    textSQL.append(" WHERE ");
    textSQL.append(" oid_var_esc_cab = "+varEscenario.getOIDInteger().toString());
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  
  
  
  private PreparedStatement selectByComponentesPeri(Object aCondiciones) throws BaseException, SQLException { 

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    HashTableDatos valoresCompoConNroInt = (HashTableDatos)condiciones.get("ValoresCompoConNroInterno");
    PeriodoPresupuestario periodo = (PeriodoPresupuestario) condiciones.get(PeriodoPresupuestario.NICKNAME);
    VarEscenarioCab varEscenario = (VarEscenarioCab) condiciones.get(VarEscenarioCab.NICKNAME);

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorVarEsce "); 
    textSQL.append(" WHERE ");
    textSQL.append(" oid_var_esc_cab = "+varEscenario.getOIDInteger().toString());
    if (periodo!=null)
    	textSQL.append(" and oid_peri = "+periodo.getOIDInteger());
    
    Iterator iterValoresCompoConNroInt = valoresCompoConNroInt.keySet().iterator();
    while (iterValoresCompoConNroInt.hasNext()) {
    	Integer nroInterno = (Integer)iterValoresCompoConNroInt.next();
    	ValorCompoPresu valorCompoPresu = (ValorCompoPresu) valoresCompoConNroInt.get(nroInterno);
    	
    	// Agregar las condiciones de Valores de Componentes
    	textSQL.append(" and oid_valor_compo_"+nroInterno.toString()+"="+valorCompoPresu.getOIDInteger()+" "); 
    	
    }
    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ValorVariableEscenario getValorByComponentesPeriodos(
  				HashTableDatos valorComponentesConNroInt,
  				PeriodoPresupuestario periodo,
  				VarEscenarioCab varEscenarioCab,
  				ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put("ValoresCompoConNroInterno",valorComponentesConNroInt);
  	if (periodo!=null)
  		condiciones.put(PeriodoPresupuestario.NICKNAME,periodo);
  	condiciones.put(VarEscenarioCab.NICKNAME,varEscenarioCab);
  	
  	return (ValorVariableEscenario) ObjetoLogico.getObjects(ValorVariableEscenario.NICKNAME,
	  				DBValorVariableEscenario.SELECT_COMPONENTES_PERI,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
  public static List getValoresVarByEscenarioCab(VarEscenarioCab varEscenarioCab,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ValorVariableEscenario.NICKNAME,
         DBValorVariableEscenario.SELECT_VAR_ESCE_CAB,
         varEscenarioCab,
         new ListObserver(),
         aSesion);
  }

  
  
  
  
  
  
} 
