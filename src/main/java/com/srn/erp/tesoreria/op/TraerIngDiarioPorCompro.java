package com.srn.erp.tesoreria.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIngDiarioPorCompro extends Operation {

  public TraerIngDiarioPorCompro() {
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

	  int secu = 0;
	  IDataSet ds = this.getDSIngDiarioPorTCyTC();
	  Iterator iterMovCaja = 
		  MovimientoCaja.getMovCajaByCondiciones(condiciones, this.getSesion()).iterator();
	  while (iterMovCaja.hasNext()) {
		  MovimientoCaja movimientoCaja = (MovimientoCaja) iterMovCaja.next();
		  String descValor = "";
		  if (movimientoCaja.getValor()!=null)
			  descValor = movimientoCaja.getValor().getDescripcion();
		  
		  Banco banco = null;
		  java.util.Date fecEmision = null;
		  java.util.Date fecVto = null;
		  
		  Valor valor = movimientoCaja.getValor();
		  
		  if (valor!=null) {
			  banco = valor.getBanco();
			  fecEmision = valor.getFechaemision();
			  fecVto = valor.getFechavto();
		  }
			
		  Sujeto sujeto = null;
		  if (movimientoCaja.getSujeto()!=null)
			  sujeto = movimientoCaja.getSujeto();
		  else if (movimientoCaja.getValor()!=null)
			  		sujeto = movimientoCaja.getValor().getSujeto();
		  
		  Proveedor proveedor = null;
		  
		  if (movimientoCaja.getComprobante().getTipoCompro().esFactProv() ||
			  movimientoCaja.getComprobante().getTipoCompro().esNDProv() ||
			  movimientoCaja.getComprobante().getTipoCompro().esNCProv()) {
			  ComproProveedorBase comproProveedorBase = 
				  (ComproProveedorBase) ComproProveedorBase.findByOid(movimientoCaja.getComprobante().getOIDInteger(), this.getSesion());
			  proveedor = comproProveedorBase.getProveedor();
		  } if (movimientoCaja.getComprobante().getTipoCompro().esOrdenDePago()) {
			  ComproOrdenPagoCab comproOP = 
				  (ComproOrdenPagoCab) ComproOrdenPagoCab.findByOid(movimientoCaja.getComprobante().getOIDInteger(), this.getSesion());
			  proveedor = comproOP.getProveedor();			  
		  }
		  
		  cargarRegistroIngDiarioPorTCyTV(
				  ds, 
				  ++secu, 
				  movimientoCaja.getMoneda().getDescripcion(), 
				  movimientoCaja.getComprobante().getTipoCompro().getDescripcion(), 
				  movimientoCaja.getFechacaja(), 
				  movimientoCaja.getTipovalor().getDescripcion(),
				  movimientoCaja.getComprobante().getCodigo(),
				  descValor, 
				  movimientoCaja.getImporte().doubleValue(),
				  sujeto,
				  banco,
				  fecEmision,
				  fecVto,
				  proveedor
				  );
	  }
	  
	  writeCliente(ds);
	  
  }

  private IDataSet getDSIngDiarioPorTCyTC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TIngDiarioPorCompro");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo_comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("tipo_valor", Field.STRING, 50));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 50));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_valor", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
    dataset.fieldDef(new Field("banco", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    
    return dataset;
  }

  private void cargarRegistroIngDiarioPorTCyTV(
		  IDataSet dataset,
          Integer secu,
          String moneda,
          String tc,
          java.util.Date fecha,
          String tipoValor,
          String comprobante,
          String descValor,
          double importe,
          Sujeto sujeto,
          Banco banco,
          java.util.Date fecEmision,
          java.util.Date fecVto,
          Proveedor proveedor) throws BaseException {
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("moneda", moneda);
    dataset.fieldValue("tipo_comprobante", tc);
    dataset.fieldValue("fecha", fecha);
    dataset.fieldValue("tipo_valor", tipoValor);
    dataset.fieldValue("importe", importe);
    dataset.fieldValue("comprobante", comprobante);
    dataset.fieldValue("desc_valor", descValor);
    dataset.fieldValue("desc_valor", descValor);
    if (sujeto!=null) {
    	dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    	dataset.fieldValue("cod_sujeto", sujeto.getCodigo());
    	dataset.fieldValue("rs_sujeto", sujeto.getRazon_social());
    } else {
    	dataset.fieldValue("oid_sujeto", "");
    	dataset.fieldValue("cod_sujeto", "");
    	dataset.fieldValue("rs_sujeto", "");
    }
    
    if (banco!=null)
    	dataset.fieldValue("banco", banco.getDescripcion());
    else
    	dataset.fieldValue("banco", "");
    dataset.fieldValue("fec_emision", fecEmision);
    dataset.fieldValue("fec_vto", fecVto);
    if (proveedor!=null) {
    	dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
    	dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
    	dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
    } else {
    	dataset.fieldValue("oid_proveedor", "");
    	dataset.fieldValue("cod_proveedor", "");
    	dataset.fieldValue("rs_proveedor", "");
    }
    
    
  }
  
  private String getClave(TipoComprobante tc,TipoValor tv,java.util.Date fecha) throws BaseException {
	return   tc.getOIDInteger()+"_"+tv.getOIDInteger()+"_"+Fecha.getddmmyyyy(fecha);
  }
  
  
}
