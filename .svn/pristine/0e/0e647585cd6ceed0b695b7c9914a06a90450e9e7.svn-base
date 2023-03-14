package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBCotizacionCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBComproAjusteStk extends DBObjetoPersistente {

  public static final String OID_AJU_STK_CAB = "oid_aju_stk_cab";
  public static final String TIPO_AJU_STK = "tipo_aju_stk";
  public static final String OID_TALONARIO = "oid_talonario";
  public static final String OID_CONF_MOV_STK = "oid_conf_mov_stk";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String OID_COMPO_STK_AJU = "oid_compo_stk_aju";
  
  public static final int SELECT_BY_PROD_FEC_NRO = 100;


  public DBComproAjusteStk() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_CAB = 1;
    final int TIPO_AJU_STK = 2;
    final int OID_TALONARIO = 3;
    final int OID_CONF_MOV_STK = 4;
    final int OID_TIPO_CONF_MOV = 5;
    final int OID_COMPO_STK_AJU = 6;

    ComproAjusteStk pers = (ComproAjusteStk) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjusteStkCab "+
                     " ( "+
                      "OID_AJU_STK_CAB,"+
                      "TIPO_AJU_STK,"+
                      "OID_TALONARIO,"+
                      "OID_CONF_MOV_STK,"+
                      "OID_TIPO_CONF_MOV,"+
                      "OID_COMPO_STK_AJU)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_AJU_STK_CAB,pers.getOID());
    qInsert.setString(TIPO_AJU_STK,pers.getTipo_aju_stk());
    qInsert.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    if (pers.getConf_mov_stk_tal()!=null)
      qInsert.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk_tal().getOID());
    else
      qInsert.setNull(OID_CONF_MOV_STK,java.sql.Types.INTEGER);
    if (pers.getTipo_conf_mov()!=null)
      qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    else
      qInsert.setNull(OID_TIPO_CONF_MOV,java.sql.Types.INTEGER);
    qInsert.setInt(OID_COMPO_STK_AJU,pers.getCompoStkTalonarioAjuStk().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int TIPO_AJU_STK = 1;
    final int OID_TALONARIO = 2;
    final int OID_CONF_MOV_STK = 3;
    final int OID_TIPO_CONF_MOV = 4;
    final int OID_COMPO_STK_AJU = 5;
    final int OID_AJU_STK_CAB = 6;

    ComproAjusteStk pers = (ComproAjusteStk) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjusteStkCab set "+
              "tipo_aju_stk=?"+
              ",oid_talonario=?"+
              ",oid_conf_mov_stk=?"+
              ",oid_tipo_conf_mov=?"+
              ",oid_compo_stk_aju=?"+
                 " where " +
                 " oid_aju_stk_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_CAB,pers.getOID());
    qUpdate.setString(TIPO_AJU_STK,pers.getTipo_aju_stk());
    qUpdate.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    if (pers.getConf_mov_stk_tal()!=null)
      qUpdate.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk_tal().getOID());
    else
      qUpdate.setNull(OID_CONF_MOV_STK,java.sql.Types.INTEGER);
    if (pers.getTipo_conf_mov()!=null)
      qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    else
      qUpdate.setNull(OID_TIPO_CONF_MOV,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_COMPO_STK_AJU,pers.getCompoStkTalonarioAjuStk().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_CAB = 1;
    ComproAjusteStk pers = (ComproAjusteStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_CAB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_CAB = 1;
    ComproAjusteStk pers = (ComproAjusteStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjusteStkCab "+
                     " set activo=1 " +
                     " where " +
                     " oid_aju_stk_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_CAB, pers.getOID());
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
      case SELECT_BY_PROD_FEC_NRO: {
      	ps = selectByProdFecNro(aCondiciones);
      	break;
      }
    }
    return ps;
  }
  
	private PreparedStatement selectByProdFecNro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  skAjusteStkCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_aju_stk_cab = b.oid_cco ");

		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_aju_stk_cab in (select oid_aju_stk_cab from skAjusteStkdet where oid_producto  = " + producto.getOIDInteger().toString()+") ");
		}

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}

		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");
		
		if (condiciones.containsKey("comportamiento")) {
			
			if (condiciones.getString("comportamiento").equals(IdentificacionTipoComprobante.AJU_STK))
				textSQL.append(" and b.comportamiento = '"+IdentificacionTipoComprobante.AJU_STK+"' ");
			else
				if (condiciones.getString("comportamiento").equals(IdentificacionTipoComprobante.TRANSFERENCIAS_INTERNAS_STOCK))
					textSQL.append(" and b.comportamiento = '"+IdentificacionTipoComprobante.TRANSFERENCIAS_INTERNAS_STOCK+"' ");
			
		}		
					
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		
		
		
		return querySelect;
	}
  
  
	public static List getComproAjuStk(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Producto producto, String comportamiento,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		if (comportamiento != null)
			condiciones.put("comportamiento", comportamiento);
		
		return (List) ObjetoLogico.getObjects(ComproAjusteStk.NICKNAME, DBComproAjusteStk.SELECT_BY_PROD_FEC_NRO, condiciones,
				new ListObserver(), aSesion);
	}
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_AJU_STK_CAB = 1;

    StringBuffer textSQL = new StringBuffer();
    
    textSQL.append("SELECT a.*,b.* FROM  skAjusteStkCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_aju_stk_cab = b.oid_cco and a.oid_aju_stk_cab = ?  ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AJU_STK_CAB, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjusteStkCab ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_stk_cab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjusteStkCab");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
