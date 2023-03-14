package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
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

public class DBConfProdGralPorLP extends DBObjetoPersistente {

  public static final String OID_CONF_PROD_LP = "oid_conf_prod_lp";
  public static final String OID_LISTA_PRECIO = "oid_lista_precio";
  public static final String OID_CLASIF_ENT = "oid_clasif_ent";
  public static final String PORC_RENT_SUG = "porc_rent_sug";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  
  public static final int SELECT_BY_CLASIF_VAL_CLASIF = 100;
  public static final int SELECT_BY_CLASIF_VAL_CLASIF_LP = 101;
  

  public DBConfProdGralPorLP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_PROD_LP = 1;
    final int OID_LISTA_PRECIO = 2;
    final int OID_CLASIF_ENT = 3;
    final int PORC_RENT_SUG = 4;
    final int OID_VAL_CLASIF_ENT = 5;

    ConfProdGralPorLP pers = (ConfProdGralPorLP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veConfProdGralLP "+
                     " ( "+
                      "OID_CONF_PROD_LP,"+
                      "OID_LISTA_PRECIO,"+
                      "OID_CLASIF_ENT,"+
                      "PORC_RENT_SUG,"+
                      "OID_VAL_CLASIF_ENT)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONF_PROD_LP,pers.getOID());
    qInsert.setInt(OID_LISTA_PRECIO,pers.getLista_precios().getOID());
    qInsert.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    if (pers.getPorc_rent_sug()!=null)
    	qInsert.setDouble(PORC_RENT_SUG,pers.getPorc_rent_sug().doubleValue());
    else
    	qInsert.setDouble(PORC_RENT_SUG,0.0);
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_ent().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LISTA_PRECIO = 1;
    final int OID_CLASIF_ENT = 2;
    final int PORC_RENT_SUG = 3;
    final int OID_VAL_CLASIF_ENT = 4;
    final int OID_CONF_PROD_LP = 5;

    ConfProdGralPorLP pers = (ConfProdGralPorLP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veConfProdGralLP set "+
              "oid_lista_precio=?"+ 
              ",oid_clasif_ent=?"+ 
              ",porc_rent_sug=?"+ 
              ",oid_val_clasif_ent=?"+ 
                 " where " +
                 " oid_conf_prod_lp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP,pers.getOID());
    qUpdate.setInt(OID_LISTA_PRECIO,pers.getLista_precios().getOID());
    qUpdate.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    if (pers.getPorc_rent_sug()!=null)
    	qUpdate.setDouble(PORC_RENT_SUG,pers.getPorc_rent_sug().doubleValue());
    else
    	qUpdate.setDouble(PORC_RENT_SUG,0.0);
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_ent().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_PROD_LP = 1; 
    ConfProdGralPorLP pers = (ConfProdGralPorLP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veConfProdGralLP "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conf_prod_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_PROD_LP = 1; 
    ConfProdGralPorLP pers = (ConfProdGralPorLP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veConfProdGralLP "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conf_prod_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP, pers.getOID()); 
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
      case DBConfProdGralPorLP.SELECT_BY_CLASIF_VAL_CLASIF: { 
          ps = this.selectByClasifValClasif(aCondiciones); 
          break; 
        } 
      case DBConfProdGralPorLP.SELECT_BY_CLASIF_VAL_CLASIF_LP: { 
          ps = this.selectByClasifValClasifLP(aCondiciones); 
          break; 
        } 
      
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONF_PROD_LP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veConfProdGralLP "); 
    textSQL.append(" WHERE oid_conf_prod_lp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONF_PROD_LP, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByClasifValClasif(Object aCondiciones) throws BaseException, SQLException { 

	HashTableDatos condiciones = (HashTableDatos) aCondiciones;  
	ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
	
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veConfProdGralLP "); 
	textSQL.append(" WHERE oid_val_clasif_ent = ? and oid_clasif_ent = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	querySelect.setInt(1, valClasifEnt.getOID());
	querySelect.setInt(2, clasifEnt.getOID());
	return querySelect;
	
  }
  
  private PreparedStatement selectByClasifValClasifLP(Object aCondiciones) throws BaseException, SQLException { 

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;  
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		ListaPrecios lp = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
		
		StringBuffer textSQL = new StringBuffer(); 
		textSQL.append("SELECT * FROM  veConfProdGralLP "); 
		textSQL.append(" WHERE oid_val_clasif_ent = ? and oid_clasif_ent = ? and oid_lista_precio = ?");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
		querySelect.setInt(1, valClasifEnt.getOID());
		querySelect.setInt(2, clasifEnt.getOID());
		querySelect.setInt(3, lp.getOID());
		return querySelect;
		
  }
  
		  
		  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veConfProdGralLP "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conf_prod_lp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veConfProdGralLP");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ConfProdGralPorLP getConfProdPorLP(ValorClasificadorEntidad valClasifEnt,
		  						 	  			   ListaPrecios lp,		  										  
		  										   ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  condiciones.put(ListaPrecios.NICKNAME, lp);
	  condiciones.put(ClasificadorEntidad.NICKNAME, valClasifEnt.getClasificador_entidad());
	  
	  return (ConfProdGralPorLP) ObjetoLogico.getObjects(ConfProdGralPorLP.NICKNAME,
			  				DBConfProdGralPorLP.SELECT_BY_CLASIF_VAL_CLASIF_LP,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getConfProdPorValorClasif(ValorClasificadorEntidad valClasifEnt,
		  													ISesion aSesion)
  throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  condiciones.put(ClasificadorEntidad.NICKNAME, valClasifEnt.getClasificador_entidad());

	  return (List) ObjetoLogico.getObjects(ConfProdGralPorLP.NICKNAME,
			  DBConfProdGralPorLP.SELECT_BY_CLASIF_VAL_CLASIF,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }
  
  
  
} 
