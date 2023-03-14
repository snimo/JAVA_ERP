package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Diario;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverComponenteCta;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.bm.MayorDia;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMayorDia extends DBObjetoPersistente {

  public static final String OID_MAY_DIA = "oid_may_dia";
  public static final String OID_DIARIO = "oid_diario";
  public static final String OID_AI = "oid_ai";
  public static final String IMPUTAC = "imputac";
  public static final String SIGNO = "signo";
  public static final String CANTIDAD = "cantidad";
  public static final String IMPO_LOC_HIST = "impo_loc_his";
  public static final String IMPO_LOC_AJU = "impo_loc_aju";
  public static final String IMPO_MON_EXT_1 = "impo_mon_ext_1";
  public static final String IMPO_MON_EXT_2 = "impo_mon_ext_2";
  public static final String OID_MAYOR_PERI = "oid_may_peri";

  public static final int SELECT_BY_DIARIO_IMPUTABLE_FECHA_SIGNO = 100;
  public static final int SELECT_BY_CUENTAS_COMPONENTES = 101;
  public static final int SELECT_BY_DRIVER = 102;

  public DBMayorDia() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MAY_DIA = 1;
    final int OID_DIARIO = 2;
    final int OID_AI = 3;
    final int IMPUTAC = 4;
    final int SIGNO = 5;
    final int CANTIDAD = 6;
    final int IMPO_LOC_HIST = 7;
    final int IMPO_LOC_AJU = 8;
    final int IMPO_MON_EXT_1 = 9;
    final int IMPO_MON_EXT_2 = 10;
    final int OID_MAYOR_PERI = 11;

    MayorDia pers = (MayorDia) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgMayorDia "+
                     " ( "+
                      "OID_MAY_DIA,"+
                      "OID_DIARIO,"+
                      "OID_AI,"+
                      "IMPUTAC,"+
                      "SIGNO,"+
                      "CANTIDAD,"+
                      "IMPO_LOC_HIS,"+
                      "IMPO_LOC_AJU,"+
                      "IMPO_MON_EXT_1,"+
                      "IMPO_MON_EXT_2,"+
                      "OID_MAY_PERI)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_MAY_DIA,pers.getOID());
    qInsert.setInt(OID_DIARIO,pers.getDiario().getOID());
    qInsert.setInt(OID_AI,pers.getCuentaimputable().getOID());
    qInsert.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setInt(CANTIDAD,pers.getCantidad().intValue());
    qInsert.setDouble(IMPO_LOC_HIST,pers.getImpoLocHist().doubleValue());
    qInsert.setDouble(IMPO_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qInsert.setDouble(IMPO_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qInsert.setDouble(IMPO_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qInsert.setInt(OID_MAYOR_PERI,pers.getMayorPeri().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CANTIDAD = 1;
    final int IMPO_LOC_HIST = 2;
    final int IMPO_LOC_AJU = 3;
    final int IMPO_MON_EXT_1 = 4;
    final int IMPO_MON_EXT_2 = 5;
    final int OID_MAY_DIA = 6;

    MayorDia pers = (MayorDia) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgMayorDia set "+
              "cantidad=cantidad+?"+
              ",impo_loc_his=impo_loc_his+?"+
              ",impo_loc_aju=impo_loc_aju+?"+
              ",impo_mon_ext_1=impo_mon_ext_1+?"+
              ",impo_mon_ext_2=impo_mon_ext_2+?"+
                 " where " +
                 " oid_may_dia=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(CANTIDAD,pers.getCantidad().intValue());
    qUpdate.setDouble(IMPO_LOC_HIST,pers.getImpoLocHist().doubleValue());
    qUpdate.setDouble(IMPO_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qUpdate.setDouble(IMPO_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qUpdate.setDouble(IMPO_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qUpdate.setDouble(OID_MAY_DIA,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MAY_DIA = 1;
    MayorDia pers = (MayorDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgMayorDia "+
                     " where " +
                     " oid_may_dia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MAY_DIA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MAY_DIA = 1;
    MayorDia pers = (MayorDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgMayorDia "+
                     " set activo=1 " +
                     " where " +
                     " oid_may_dia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MAY_DIA, pers.getOID());
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
      case SELECT_BY_DIARIO_IMPUTABLE_FECHA_SIGNO: {
        ps = this.selectByDiarioImputableFechaSigno(aCondiciones);
        break;
      }
      case SELECT_BY_CUENTAS_COMPONENTES: {
          ps = this.selectByCuentasComponentes(aCondiciones);
          break;
      }
      case SELECT_BY_DRIVER: {
          ps = this.selectByDriver(aCondiciones);
          break;
      }      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MAY_DIA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorDia ");
    textSQL.append(" WHERE oid_may_dia = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MAY_DIA, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCuentasComponentes(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date)condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date)condiciones.get("FECHA_HASTA");
	    List listaCuentas = (List) condiciones.get("LISTA_CUENTAS");
	    HashTableDatos listaValoresComponentes = (HashTableDatos) condiciones.get("LISTA_VALORES_COMPO");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgMayorDia a , cgAnaImpCon b ");
	    textSQL.append(" WHERE ");
	    textSQL.append(" a.oid_ai = b.oid_ai ");
	    textSQL.append(" and a.imputac >= ? and a.imputac<=? ");
	    
	    // Filtrar para el conjunto de cuentas especificado
	    if (listaCuentas!=null) {
	    	StringBuffer CondINCtas = new StringBuffer("");
	    	Iterator iterCuentas =
	    		listaCuentas.iterator();
	    	while (iterCuentas.hasNext()) {
	    		Cuenta cuenta = (Cuenta) iterCuentas.next();
	    		CondINCtas.append(","+cuenta.getOIDInteger());
	    	}
	    	if (CondINCtas.length()>0) {
	    		textSQL.append(" and b.oid_ana_con in (-1");
	    		textSQL.append(CondINCtas.toString());
	    		textSQL.append(") ");
	    	}
	    }
	    
	    // Filtrar a los valores de Componentes Correspondientes
	    if (listaValoresComponentes!=null) {
	    	Iterator iterComponentes = 
	    		listaValoresComponentes.keySet().iterator();
	    	while (iterComponentes.hasNext()) {
	    		StringBuffer valoresComponenteCondIN = new StringBuffer("");
	    		Componente componente = (Componente) iterComponentes.next();
	    		List listaValoresCompo = (List) listaValoresComponentes.get(componente);
	    		Iterator iterValoresCompo = listaValoresCompo.iterator();
	    		while (iterValoresCompo.hasNext()) {
	    			IObjetoLogico objLog = (IObjetoLogico) iterValoresCompo.next();
	    			valoresComponenteCondIN.append(","+objLog.getOIDInteger());
	    		}
	    		if (valoresComponenteCondIN.length()>0) {
	    			textSQL.append(" and b."+componente.getCampoFisicoAnaImp()+" in ");
	    			textSQL.append("(-1");
	    			textSQL.append(valoresComponenteCondIN.toString());
	    			textSQL.append(") ");
	    		}
	    	}
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect;
  }
  
  private PreparedStatement selectByDriver(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date)condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date)condiciones.get("FECHA_HASTA");
	    DriverSubreparto driverSubReparto = (DriverSubreparto) condiciones.get(DriverSubreparto.NICKNAME);

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgMayorDia a , cgAnaImpCon b ");
	    textSQL.append(" WHERE ");
	    textSQL.append(" a.oid_ai = b.oid_ai ");
	    textSQL.append(" and a.imputac >= ? and a.imputac<=? ");
	    
	    // Filtrar para el conjunto de cuentas especificado
	    boolean primerCuenta = true;
	    if (driverSubReparto.isCuentas()) {
	    	Iterator iterDriverCuentas =
	    		driverSubReparto.getDriversCuentas().iterator();
	    	while (iterDriverCuentas.hasNext()) {
	    		
	    		if (primerCuenta) {
	    			primerCuenta = false;
	    			textSQL.append("  and ( ");
	    		} else
	    			textSQL.append("  or ");
	    		
	    		textSQL.append("  ( ");
	    		DriverCuentaSubreparto driverCuenta = (DriverCuentaSubreparto) iterDriverCuentas.next();
	    		textSQL.append("  b.oid_ana_con ="+driverCuenta.getCuenta().getOIDInteger()+" ");
	    		
	    		Iterator iterCompoCtas = 
	    			driverCuenta.getComponentesCuentaDriver().iterator();
	    		while (iterCompoCtas.hasNext()) {
	    			DriverCuentaComponente driverCtaCompo = (DriverCuentaComponente) iterCompoCtas.next();
	    			textSQL.append(" and b."+driverCtaCompo.getComponente().getCampoFisicoAnaImp()+"="+driverCtaCompo.getValor_componente().getOIDInteger());
	    		}
	    		textSQL.append("  ) ");
	    		
	    		if (iterDriverCuentas.hasNext()==false) {
	    			textSQL.append("  ) ");
	    		}
	    	}
	    }
	    
	    if (driverSubReparto.isComponentes()) {
	    	
	    	primerCuenta = true;
	    	Iterator iterDriverComponentes = 
	    		driverSubReparto.getDriversComponentes().iterator();
	    	while (iterDriverComponentes.hasNext()) {
	    		
	    		if (primerCuenta) {
	    			primerCuenta = false;
	    			textSQL.append("  and ( ");
	    		} else
	    			textSQL.append("  or ");
	    		
	    		
	    		DriverComponente driverComponente = (DriverComponente) iterDriverComponentes.next();
	    		textSQL.append(" ( ");
	    		textSQL.append("  b."+driverSubReparto.getComponente().getCampoFisicoAnaImp()+"="+driverComponente.getValor_compo().getOIDInteger());
	    		
	    		StringBuffer condCtasIN = new StringBuffer("");
	    		Iterator iterCuentasCompo =
	    			driverComponente.getCuentasCompo().iterator();
	    		while (iterCuentasCompo.hasNext()) {
	    			DriverComponenteCta driverCompoCta = (DriverComponenteCta) iterCuentasCompo.next();
	    			condCtasIN.append(","+driverCompoCta.getCuenta().getOIDInteger());
	    		}
	    		
	    		if (condCtasIN.length()>0) {
	    	    	textSQL.append(" and b.oid_ana_con in (-1");
	    	    	textSQL.append(condCtasIN.toString());
	    	    	textSQL.append(") ");
	    		}
	    		textSQL.append(" ) ");
	    		
	    		if (iterDriverComponentes.hasNext()==false) 
	    			textSQL.append("  ) ");
	    	}
	    	
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect;
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorDia ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
	public static void borrarTodo(ISesion aSesion)
	throws BaseException {

	try {

		StringBuffer sql = new StringBuffer(
				" delete from cgMayorDia");
		PreparedStatement update = aSesion.getConexionBD().prepareStatement(sql.toString());
		update.executeUpdate();
		update.close();

	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_may_dia oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgMayorDia");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByDiarioImputableFechaSigno(Object aCondiciones) throws BaseException, SQLException {

    MapDatos mapaDatos              = (HashTableDatos) aCondiciones;
    Diario diario                   = (Diario) mapaDatos.get(Diario.NICKNAME);
    CuentaImputable cuentaImputable = (CuentaImputable) mapaDatos.get(CuentaImputable.NICKNAME);
    java.util.Date fecha            = (java.util.Date) mapaDatos.get("fecha");
    Integer signo                   = (Integer) mapaDatos.get("signo");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorDia ");
    textSQL.append(" WHERE  oid_diario=? and oid_ai=? and imputac=? and signo=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    querySelect.setInt(1,diario.getOID());
    querySelect.setInt(2,cuentaImputable.getOID());
    querySelect.setDate(3,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(4,signo.intValue());

    return querySelect;

  }

  public static MayorDia getByDiarioImputableFechaSigno(Diario diario,
                                                        CuentaImputable cuentaImputable,
                                                        java.util.Date fecha,
                                                        Integer signo,
                                                        ISesion aSesion)
                                                        throws BaseException {
    MapDatos mapaDatos = new HashTableDatos();
    mapaDatos.put(Diario.NICKNAME,diario);
    mapaDatos.put(CuentaImputable.NICKNAME,cuentaImputable);
    mapaDatos.put("fecha",fecha);
    mapaDatos.put("signo",signo);
    return (MayorDia) ObjetoLogico.getObjects(MayorDia.NICKNAME,
                                              DBMayorDia.SELECT_BY_DIARIO_IMPUTABLE_FECHA_SIGNO,
                                              mapaDatos,
                                              new ObjetoObservado(),
                                              aSesion);

  }
  
  public static List getImputacionesByCuentasValoresCompo(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  List listaCuentas,
		  HashTableDatos listaValoresCompo,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  if (listaCuentas!=null)
		  condiciones.put("LISTA_CUENTAS", listaCuentas);
	  if (listaValoresCompo!=null)
		  condiciones.put("LISTA_VALORES_COMPO", listaValoresCompo);
	  
	  return (List) ObjetoLogico.getObjects(MayorDia.NICKNAME,
             DBMayorDia.SELECT_BY_CUENTAS_COMPONENTES,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getImputacionesByDriverSubReparto(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  DriverSubreparto driver,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  condiciones.put(DriverSubreparto.NICKNAME, driver);
	  
	  
	  return (List) ObjetoLogico.getObjects(MayorDia.NICKNAME,
             DBMayorDia.SELECT_BY_DRIVER,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  



}
