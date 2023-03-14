package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBDefEstrucLPDet extends DBObjetoPersistente {

  public static final String OID_DEF_DET_LP = "oid_def_det_lp";
  public static final String OID_DEF_ESTRUC_LP = "oid_def_estruc_lp";
  public static final String OID_CLASIF_ART_1 = "oid_clasif_art_1";
  public static final String OID_CLASIF_ART_2 = "oid_clasif_art_2";
  public static final String ORDEN = "orden";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESTRUC_LP = 100;
  public static final int SELECT_BY_ESTRUC_LP_DET_NOT_IN_LP = 101;
  public static final int SELECT_BY_DEF_ESTRUC_LP_CLASIF_ART_1_Y_2 = 102;
  

  public DBDefEstrucLPDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEF_DET_LP = 1;
    final int OID_DEF_ESTRUC_LP = 2;
    final int OID_CLASIF_ART_1 = 3;
    final int OID_CLASIF_ART_2 = 4;
    final int ORDEN = 5;
    final int ACTIVO = 6;

    DefEstrucLPDet pers = (DefEstrucLPDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veDefEstrucLPDet "+
                     " ( "+
                      "OID_DEF_DET_LP,"+
                      "OID_DEF_ESTRUC_LP,"+
                      "OID_CLASIF_ART_1,"+
                      "OID_CLASIF_ART_2,"+
                      "ORDEN,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DEF_DET_LP,pers.getOID());
    qInsert.setInt(OID_DEF_ESTRUC_LP,pers.getDef_estruc_lp().getOID());
    if (pers.getValor_clasif_art_1()!=null) 
      qInsert.setInt(OID_CLASIF_ART_1,pers.getValor_clasif_art_1().getOID());
    else
      qInsert.setNull(OID_CLASIF_ART_1,java.sql.Types.INTEGER);
    if (pers.getValor_clasif_art_2()!=null) 
      qInsert.setInt(OID_CLASIF_ART_2,pers.getValor_clasif_art_2().getOID());
    else
      qInsert.setNull(OID_CLASIF_ART_2,java.sql.Types.INTEGER);
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEF_ESTRUC_LP = 1;
    final int OID_CLASIF_ART_1 = 2;
    final int OID_CLASIF_ART_2 = 3;
    final int ORDEN = 4;
    final int ACTIVO = 5;
    final int OID_DEF_DET_LP = 6;

    DefEstrucLPDet pers = (DefEstrucLPDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veDefEstrucLPDet set "+
              "oid_def_estruc_lp=?"+ 
              ",oid_clasif_art_1=?"+ 
              ",oid_clasif_art_2=?"+ 
              ",orden=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_def_det_lp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEF_DET_LP,pers.getOID());
    qUpdate.setInt(OID_DEF_ESTRUC_LP,pers.getDef_estruc_lp().getOID());
    if (pers.getValor_clasif_art_1()!=null) 
      qUpdate.setInt(OID_CLASIF_ART_1,pers.getValor_clasif_art_1().getOID());
    else
      qUpdate.setNull(OID_CLASIF_ART_1,java.sql.Types.INTEGER);
    if (pers.getValor_clasif_art_2()!=null) 
      qUpdate.setInt(OID_CLASIF_ART_2,pers.getValor_clasif_art_2().getOID());
    else
      qUpdate.setNull(OID_CLASIF_ART_2,java.sql.Types.INTEGER);
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEF_DET_LP = 1; 
    DefEstrucLPDet pers = (DefEstrucLPDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from veDefEstrucLPDet "+
                     " where " + 
                     " oid_def_det_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEF_DET_LP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEF_DET_LP = 1; 
    DefEstrucLPDet pers = (DefEstrucLPDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veDefEstrucLPDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_def_det_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEF_DET_LP, pers.getOID()); 
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
      case SELECT_BY_ESTRUC_LP: {
        ps = this.selectByEstrucLP(aCondiciones); 
        break; 
      }
      case SELECT_BY_ESTRUC_LP_DET_NOT_IN_LP: {
        ps = this.selectByEstrucLPDetNotInLP(aCondiciones); 
        break; 
      }
      case SELECT_BY_DEF_ESTRUC_LP_CLASIF_ART_1_Y_2: {
        ps = this.selectByDefEstrucLPClasifArt1y2(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DEF_DET_LP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veDefEstrucLPDet "); 
    textSQL.append(" WHERE oid_def_det_lp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DEF_DET_LP, oid); 
    return querySelect; 
  }
  
  		
  private PreparedStatement selectByDefEstrucLPClasifArt1y2(Object aCondiciones) throws BaseException, SQLException { 

  	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	 DefEstrucLPCab defEstrucLPCab = 
  		 (DefEstrucLPCab)condiciones.get(DefEstrucLPCab.NICKNAME);
  	 ValorClasificadorEntidad valorClasifEnt1 = 
  		 (ValorClasificadorEntidad) condiciones.get("VALOR_CLASIF_ENT_1");
  	 ValorClasificadorEntidad valorClasifEnt2 = 
  		 (ValorClasificadorEntidad) condiciones.get("VALOR_CLASIF_ENT_2");  	 
  	
  	 StringBuffer textSQL = new StringBuffer(); 
  	 textSQL.append("SELECT * FROM  veDefEstrucLPDet "); 
  	 textSQL.append(" WHERE oid_def_estruc_lp = ? and oid_clasif_art_1 = ? and oid_clasif_art_2 = ?");
  	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
  	 querySelect.setInt(1, defEstrucLPCab.getOID());
  	 querySelect.setInt(2, valorClasifEnt1.getOID());
  	 querySelect.setInt(3, valorClasifEnt2.getOID());
  	 return querySelect; 
  	 
  }
  		
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veDefEstrucLPDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstrucLP(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veDefEstrucLPDet "); 
    textSQL.append(" WHERE oid_def_estruc_lp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    DefEstrucLPCab defEstrucLPCab = (DefEstrucLPCab) aCondiciones; 
    querySelect.setInt(1, defEstrucLPCab.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstrucLPDetNotInLP(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    
    textSQL.append(" SELECT * FROM  veDefEstrucLPDet a "); 
    textSQL.append(" where a.oid_def_estruc_lp = ? and  NOT exists ");
    textSQL.append(" (select * from vePreciosEstLP b where a.oid_clasif_art_1=b.oid_clasif_art_1 "); 
    textSQL.append(" and a.oid_clasif_art_2=b.oid_clasif_art_2 and oid_precio_cab = ?) ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos cond = (HashTableDatos) aCondiciones;
    
    ListaPrecios listaPrecios = (ListaPrecios) cond.get(ListaPrecios.NICKNAME);
    DefEstrucLPCab defEstrucLPCab = (DefEstrucLPCab) cond.get(DefEstrucLPCab.NICKNAME);
    
    querySelect.setInt(1, defEstrucLPCab.getOID());
    querySelect.setInt(2, listaPrecios.getOID());
    return querySelect; 
  }
    
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_def_det_lp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veDefEstrucLPDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDefEstrucLP(DefEstrucLPCab defEstrucLPCab,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(DefEstrucLPDet.NICKNAME,
         DBDefEstrucLPDet.SELECT_BY_ESTRUC_LP,
         defEstrucLPCab,
         new ListObserver(),
         aSesion);
  }
  
  public static List getListaDefEstrucLPNotInListaPrecios(ListaPrecios listaPrecios,
  		                                                    DefEstrucLPCab defEstrucLPCab, 
      ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(ListaPrecios.NICKNAME,listaPrecios);
  	condiciones.put(DefEstrucLPCab.NICKNAME,defEstrucLPCab);
  	return (List) ObjetoLogico.getObjects(DefEstrucLPDet.NICKNAME,
         DBDefEstrucLPDet.SELECT_BY_ESTRUC_LP_DET_NOT_IN_LP,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  public static DefEstrucLPDet getDefEstrucLPDet(DefEstrucLPCab defEstrucLPCab,
  																							 ValorClasificadorEntidad valClasifEnt1,
  																							 ValorClasificadorEntidad valClasifEnt2,
  																							 ISesion aSesion)
      throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(DefEstrucLPCab.NICKNAME,defEstrucLPCab);
  	condiciones.put("VALOR_CLASIF_ENT_1",valClasifEnt1);
  	condiciones.put("VALOR_CLASIF_ENT_2",valClasifEnt2);
  	return (DefEstrucLPDet) ObjetoLogico.getObjects(DefEstrucLPDet.NICKNAME,
	  																								DBDefEstrucLPDet.SELECT_BY_DEF_ESTRUC_LP_CLASIF_ART_1_Y_2,
	  																								condiciones,
	  																								new ObjetoObservado(),
	  																								aSesion);
  }
  
  
  
  
  
} 
