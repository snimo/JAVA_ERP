package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.FactConvProdGral;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFactConvProdGral extends DBObjetoPersistente {

  public static final String OID_EQUIV_PG = "oid_equiv_pg";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  public static final String OID_UM_ORI = "oid_um_ori";
  public static final String OID_UM_DEST = "oid_um_dest";
  public static final String FACT_CONV = "fact_conv";
  
  public static final int SELECT_BY_VALOR_CLASIFICADOR = 100;
  public static final int SELECT_BY_VAL_UM_ORI_DEST = 101;

  public DBFactConvProdGral() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EQUIV_PG = 1;
    final int OID_VAL_CLASIF_ENT = 2;
    final int OID_UM_ORI = 3;
    final int OID_UM_DEST = 4;
    final int FACT_CONV = 5;

    FactConvProdGral pers = (FactConvProdGral) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into stExtPGEquiv "+
                     " ( "+
                      "OID_EQUIV_PG,"+
                      "OID_VAL_CLASIF_ENT,"+
                      "OID_UM_ORI,"+
                      "OID_UM_DEST,"+
                      "FACT_CONV)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EQUIV_PG,pers.getOID());
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getValClasifEnt().getOID());
    qInsert.setInt(OID_UM_ORI,pers.getUnidad_origen().getOID());
    qInsert.setInt(OID_UM_DEST,pers.getUnidad_destino().getOID());
    qInsert.setDouble(FACT_CONV,pers.getFact_conv().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_CLASIF_ENT = 1;
    final int OID_UM_ORI = 2;
    final int OID_UM_DEST = 3;
    final int FACT_CONV = 4;
    final int OID_EQUIV_PG = 5;

    FactConvProdGral pers = (FactConvProdGral) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update stExtPGEquiv set "+
              "oid_val_clasif_ent=?"+ 
              ",oid_um_ori=?"+ 
              ",oid_um_dest=?"+ 
              ",fact_conv=?"+ 
                 " where " +
                 " oid_equiv_pg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_PG,pers.getOID());
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getValClasifEnt().getOID());
    qUpdate.setInt(OID_UM_ORI,pers.getUnidad_origen().getOID());
    qUpdate.setInt(OID_UM_DEST,pers.getUnidad_destino().getOID());
    qUpdate.setDouble(FACT_CONV,pers.getFact_conv().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV_PG = 1; 
    FactConvProdGral pers = (FactConvProdGral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from stExtPGEquiv "+
                     " where " + 
                     " oid_equiv_pg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_PG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EQUIV_PG = 1; 
    FactConvProdGral pers = (FactConvProdGral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update stExtPGEquiv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_equiv_pg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EQUIV_PG, pers.getOID()); 
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
      case SELECT_BY_VALOR_CLASIFICADOR: {
          ps = this.selectByValorClasificador(aCondiciones); 
          break; 
      }
      case SELECT_BY_VAL_UM_ORI_DEST: {
          ps = this.selectByValorUMOriDest(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EQUIV_PG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stExtPGEquiv "); 
    textSQL.append(" WHERE oid_equiv_pg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EQUIV_PG, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stExtPGEquiv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectByValorUMOriDest(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	  	UnidadMedida umOri = (UnidadMedida) condiciones.get("UM_ORI");
	  	UnidadMedida umDest = (UnidadMedida) condiciones.get("UM_DEST");
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stExtPGEquiv "); 
	    textSQL.append(" WHERE oid_val_clasif_ent = ? and oid_um_ori = ? and oid_um_dest = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, valClasifEnt.getOID()); 
	    querySelect.setInt(2, umOri.getOID());
	    querySelect.setInt(3, umDest.getOID());
	    return querySelect; 
	  }

  
  
  private PreparedStatement selectByValorClasificador(Object aCondiciones) throws BaseException, SQLException { 

	    ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stExtPGEquiv "); 
	    textSQL.append(" WHERE oid_val_clasif_ent = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, valClasifEnt.getOID()); 
	    return querySelect; 
	  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_equiv_pg oid, codigo,  descripcion ,activo ");
    textSQL.append(" from stExtPGEquiv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getFactoresConv(ValorClasificadorEntidad valClasifEnt,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FactConvProdGral.NICKNAME,
             DBFactConvProdGral.SELECT_BY_VALOR_CLASIFICADOR,
             valClasifEnt,
             new ListObserver(),
             aSesion);
  }
  
  public static FactConvProdGral getFactorConv(ValorClasificadorEntidad valClasifEnt,
		  UnidadMedida umOri,
		  UnidadMedida umDest,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  condiciones.put("UM_ORI", umOri);
	  condiciones.put("UM_DEST", umDest);
	  
	  return (FactConvProdGral) ObjetoLogico.getObjects(FactConvProdGral.NICKNAME,
             DBFactConvProdGral.SELECT_BY_VAL_UM_ORI_DEST,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
  
} 
