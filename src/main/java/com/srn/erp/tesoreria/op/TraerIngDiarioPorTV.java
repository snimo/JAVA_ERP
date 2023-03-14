package com.srn.erp.tesoreria.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIngDiarioPorTV extends Operation {

  HashTableDatos registros = new HashTableDatos();	

  class RegistroConsulta {
	  public String moneda;
	  public java.util.Date fecha;
	  public String tipoValor;
	  public CalculadorMoney calcTotal = new CalculadorMoney(new Money(0));
	  
	  public void acumularImporte(double aImporte) {
		  calcTotal.sumar(new Money(aImporte));
	  }
  }

  public TraerIngDiarioPorTV() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Integer signo = mapaDatos.getInteger("signo");
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("signo", signo);
	  
	  java.util.Date fecDesde = null;
	  if (mapaDatos.containsKey("fecDesde"))
		  fecDesde = mapaDatos.getDate("fecDesde");
	  
	  java.util.Date fecHasta = null;
	  if (mapaDatos.containsKey("fecHasta"))
		  fecHasta = mapaDatos.getDate("fecHasta");
	  
	  if (mapaDatos.containsKey("oid_grupo_caja"))
		  condiciones.put(GrupoCajas.NICKNAME,mapaDatos.getInteger("oid_grupo_caja"));
	  
	  if (mapaDatos.containsKey("oid_sujeto"))
		  condiciones.put(Sujeto.NICKNAME,mapaDatos.getInteger("oid_sujeto"));
	  
	  if (fecDesde!=null)
		  condiciones.put("FEC_DESDE",fecDesde);
	  
	  if (fecHasta!=null)
		  condiciones.put("FEC_HASTA",fecHasta);
	  
	  List listaCompro = new ArrayList();
	  IDataSet dsTipoCompro = mapaDatos.getDataSet("TTipoComproMovArqueo");
	  dsTipoCompro.first();
	  while (!dsTipoCompro.EOF()) {
		  if (dsTipoCompro.getBoolean("sel")) {
			  TipoComprobante tc = TipoComprobante.findByOidProxy(dsTipoCompro.getInteger("oid_tc"), this.getSesion());
			  listaCompro.add(tc);
		  }
		  dsTipoCompro.next();
	  }
	  
	  if (listaCompro.size() != 0)
		  condiciones.put("LISTA_TC", listaCompro);
	  
	  IDataSet ds = this.getDSIngDiarioPorTCyTC();
	  Iterator iterMovCaja = 
		  MovimientoCaja.getMovCajaByCondiciones(condiciones, this.getSesion()).iterator();
	  while (iterMovCaja.hasNext()) {
		  MovimientoCaja movimientoCaja = (MovimientoCaja) iterMovCaja.next();
		  cargar(movimientoCaja);
	  }
	  
	  int secu = 1;
	  Iterator iteratorReg  = this.registros.values().iterator();
	  while (iteratorReg.hasNext()) {
		  RegistroConsulta regCons = (RegistroConsulta) iteratorReg.next();
		  cargarRegistroIngDiarioPorTCyTV(ds, ++secu, regCons.moneda,  regCons.fecha, regCons.tipoValor, regCons.calcTotal.getResult());
	  }
	  
	  writeCliente(ds);
	  
  }

  private IDataSet getDSIngDiarioPorTCyTC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TIngDiarioPorTV");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("tipo_valor", Field.STRING, 50));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 50));
    return dataset;
  }

  private void cargarRegistroIngDiarioPorTCyTV(
		  IDataSet dataset,
          Integer secu,
          String moneda,
          java.util.Date fecha,
          String tipoValor,
          double importe) throws BaseException {
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("moneda", moneda);
    dataset.fieldValue("fecha", fecha);
    dataset.fieldValue("tipo_valor", tipoValor);
    dataset.fieldValue("importe", importe);
  }
  
  private String getClave(TipoValor tv,java.util.Date fecha) throws BaseException {
	return   tv.getOIDInteger()+"_"+Fecha.getddmmyyyy(fecha);
  }
  
  private void cargar(MovimientoCaja movimientoCaja) throws BaseException {
	  String clave = getClave(movimientoCaja.getTipovalor(), movimientoCaja.getFechacaja());
	  RegistroConsulta registroConsulta = (RegistroConsulta)registros.get(clave);
	  if (registroConsulta == null) {
		  registroConsulta = new RegistroConsulta();
		  registroConsulta.moneda = movimientoCaja.getMoneda().getDescripcion();
		  registroConsulta.tipoValor = movimientoCaja.getTipovalor().getDescripcion();
		  registroConsulta.fecha = movimientoCaja.getFechacaja();
		  this.registros.put(clave, registroConsulta);
	  }
	  registroConsulta.acumularImporte(movimientoCaja.getImporte().doubleValue());
	  
  }
  
  
}
