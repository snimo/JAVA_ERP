package com.srn.erp.compras.op;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetCotizProvParaDetOC extends Operation {

	private HashTableDatos listaDetOC = new HashTableDatos();
	private HashTableDatos listaEntregas = new HashTableDatos();
	private Proveedor proveedor = null;
	
	private class EntregaOC {
		
		Producto producto = null;
		UnidadMedida uniMed = null;
		Money cantAComprar = new Money(0);
		Date fecEntrega = null;
		List listaItemsCotizProv = new ArrayList();
		
		public void addCotizProvDet(CotizacionProveedorDet aCotizProvDet) throws BaseException {
			listaItemsCotizProv.add(aCotizProvDet);
		}
		
		public List getCotizacionesProvDet() throws BaseException {
			return listaItemsCotizProv;
		}
		
		public Money getCantAComprar() {
			return cantAComprar;
		}
		
		public void setCantAComprar(Money cantAComprar) {
			CalculadorMoney calc = new CalculadorMoney(this.cantAComprar);
			calc.sumar(cantAComprar);
			this.cantAComprar = calc.getResultMoney();
		}
		public Date getFecEntrega() {
			return fecEntrega;
		}
		public void setFecEntrega(Date fecEntrega) {
			this.fecEntrega = fecEntrega;
		}
		public Producto getProducto() {
			return producto;
		}
		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		public UnidadMedida getUniMed() {
			return uniMed;
		}
		public void setUniMed(UnidadMedida uniMed) {
			this.uniMed = uniMed;
		}
		
	}
	
	private class ArmadoDetOC {
		
		Producto producto;
		Money cantRequerida = new Money(0);
		UnidadMedida uniMedRequi;
		String descAdic = "";
		HashTableDatos listaItemsRequi = new HashTableDatos();
		Moneda moneda = null;
		Money precio = new Money(0);
		
		public void addItemCotizProv(CotizacionProveedorDet cotizProvDet) throws BaseException {				
		  java.util.Date fecha = cotizProvDet.getFec_ent();
		  String claveFecha    = Fecha.getddmmyyyy(fecha);
		  EntregaOC entregaOC  = (EntregaOC) listaEntregas.get(claveFecha);
		  
		  if (entregaOC == null) {
			  entregaOC = new EntregaOC();
			  entregaOC.setProducto(cotizProvDet.getProducto());
			  entregaOC.setUniMed(cotizProvDet.getUnidad_medida());
			  entregaOC.setFecEntrega(fecha);
			  listaEntregas.put(claveFecha,entregaOC);
		  }
		  
		  entregaOC.setCantAComprar(new Money(cotizProvDet.getCant_presu().doubleValue()));
		  
		  // Agregar la Requisicion Detalle
		  entregaOC.addCotizProvDet(cotizProvDet);
		  
		}
		
		public HashTableDatos getEntregas() throws BaseException {
			return listaEntregas;
		}
		
		public void setProducto(Producto aProducto) throws BaseException {
			if (aProducto == null)
				throw new ExceptionValidation(null,"Debe ingresar un producto");
			this.producto = aProducto;
		}
		
		public void setMoneda(Moneda aMoneda) throws BaseException {
			this.moneda = aMoneda;
		}
		
		public void setPrecio(Money aPrecio) throws BaseException {
			if (aPrecio == null)
				throw new ExceptionValidation(null,"Debe ingresar el precio");
			CalculadorMoney calcPrecio = new CalculadorMoney(new NumeroBase(0));
			calcPrecio.sumar(this.precio);
			calcPrecio.sumar(aPrecio);
			this.precio = calcPrecio.getResultMoney();
		}
		
		public Moneda getMoneda() throws BaseException {
			return moneda;
		}
		
		public Money getPrecio() throws BaseException {
			return precio;
		}
		
		public void setCantRequerida(Money aCantRequerida) throws BaseException {
			if (aCantRequerida == null)
				throw new ExceptionValidation(null,"Debe ingresar la cantidad requerida");
			CalculadorMoney calcCantReq = new CalculadorMoney(new NumeroBase(0));
			calcCantReq.sumar(this.cantRequerida);
			calcCantReq.sumar(aCantRequerida);
			this.cantRequerida = calcCantReq.getResultMoney();
		}
		
		public void setUnidadMedida(UnidadMedida aUniMed) throws BaseException {
			this.uniMedRequi = aUniMed;
		}
		
		public void setDescAdic(String aDescAdic) throws BaseException {
			if (aDescAdic!=null)
				this.descAdic = aDescAdic;
			else
				this.descAdic = "";
		}
		
		public Producto getProducto() throws BaseException {
			return this.producto;
		}
		
		public UnidadMedida getUniMed() throws BaseException {
			return this.uniMedRequi;
		}
		
		public Money getCantRequerida() throws BaseException {
			return this.cantRequerida;
		}
		
		public String getDescAdic() throws BaseException {
			return this.descAdic;
		}
		
		
	}
	
	
	public TraerDetCotizProvParaDetOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsArmadoDetOC      = getDataArmadoDetOC();
		IDataSet dsEntregaOC        = getDataEntregaOC();
		IDataSet dsItemsCotizProv   = getDataItemsCotizProv();
		IDataSet dsCotizProvCab     = getDataCotizProvCab();
		
		// Recorrer las cotizaciones de Proveedores
		IDataSet dsCotizProv = mapaDatos.getDataSet("TCotizacionesProveedores");
		dsCotizProv.first();
		while (!dsCotizProv.EOF()) {
			
			CotizacionProveedorCab cotizProvCab = CotizacionProveedorCab.findByOid(dsCotizProv.getInteger("oid_cotiz_prov"),getSesion());  
			armarDetOC(cotizProvCab);
			
			// Enviar Cabecera Cotizacion
			cargarCotizProvCab(dsCotizProvCab,cotizProvCab);
			dsCotizProv.next();
		}
		
		// Enviar Detalles de OC
		enviarDetOC(dsArmadoDetOC,dsEntregaOC,dsItemsCotizProv);				
		
		writeCliente(dsArmadoDetOC);
		writeCliente(dsEntregaOC);
		writeCliente(dsItemsCotizProv);
		writeCliente(dsCotizProvCab);
		
	}
	
	private void armarDetOC(CotizacionProveedorCab cotizProvCab) throws BaseException {
		
		// Verificar que el comprobante no este anulado
		if (cotizProvCab.isActivo().booleanValue() == false)
			throw new ExceptionValidation(null,"El comprobante "+cotizProvCab.getCodigo()+ " se encuentra anulado.");
		
		// Verificar que las Cotizacion de Proveedor se encuentran Adjudicadas
		if (!cotizProvCab.isAdjudicado())
			throw new ExceptionValidation(null,"La cotización "+cotizProvCab.getCodigo()+" no se encuentra adjudicada.");
		
		// Verificar que todas las cotizaciones correspondan al mismo proveedor
		if (proveedor == null)
			proveedor = cotizProvCab.getProveedor();
		else {
			if (proveedor.getOID() != cotizProvCab.getProveedor().getOID())
				throw new ExceptionValidation(null,"Las cotizaciones seleccionadas deben corresponder al mismo proveedor");
		}
		
		// Procesar los detalles de las cotizaciones del Proveedor
		Iterator iterDetallesCotizaciones = cotizProvCab.getDetallesCotizaciones().iterator();
		while (iterDetallesCotizaciones.hasNext()) {
			CotizacionProveedorDet cotizProvDet = (CotizacionProveedorDet) iterDetallesCotizaciones.next();
			String clave = getClave(cotizProvDet.getProducto(),cotizProvDet.getUnidad_medida(),cotizProvDet.getComentario());
			cargarDetOC(cotizProvDet,clave);
		}	
	}
	
	public void cargarDetOC(CotizacionProveedorDet cotizProvDet,String clave) throws BaseException {
		
		ArmadoDetOC armadoDetOC = (ArmadoDetOC) listaDetOC.get(clave);
		if (armadoDetOC == null) {
			armadoDetOC = new ArmadoDetOC();
			armadoDetOC.setProducto(cotizProvDet.getProducto());
			armadoDetOC.setUnidadMedida(cotizProvDet.getUnidad_medida());
			armadoDetOC.setDescAdic(cotizProvDet.getComentario());
			armadoDetOC.setMoneda(cotizProvDet.getMoneda());
			listaDetOC.put(clave,armadoDetOC);
		}
		
		armadoDetOC.setPrecio(new Money(cotizProvDet.getPrecio().doubleValue()));
		armadoDetOC.setCantRequerida(new Money(cotizProvDet.getCant_presu().doubleValue()));
		armadoDetOC.addItemCotizProv(cotizProvDet);
	}
		
	private void enviarDetOC(IDataSet dsArmadoDetOC,
			                 IDataSet dsArmadoEntrega,
			                 IDataSet dsItemsCotizProv) throws BaseException {
		int secuDetOC = 0;
		int secuDetEnt = 0;
		int secuDetRequi = 0;
		
		Iterator iterArmadoDetOC = listaDetOC.values().iterator();
		while (iterArmadoDetOC.hasNext()) {
			ArmadoDetOC armadoDetOC = (ArmadoDetOC) iterArmadoDetOC.next();
			cargarRegistroArmadoDetOC(dsArmadoDetOC,
									  new Integer(++secuDetOC),
									  armadoDetOC.getProducto(),
									  armadoDetOC.getDescAdic(),
									  armadoDetOC.getUniMed(),
									  armadoDetOC.getCantRequerida(),
									  armadoDetOC.getMoneda(),
									  armadoDetOC.getPrecio()
									  );
			
			// Enviar las Entregas del Detalle
			Iterator iterEntregas = armadoDetOC.getEntregas().values().iterator();
			while (iterEntregas.hasNext()) {
				EntregaOC entregaOC = (EntregaOC) iterEntregas.next();
				cargarRegistroEntregaOC(dsArmadoEntrega,
						                new Integer(++secuDetEnt),
						                new Integer(secuDetOC),
						                entregaOC);
				
				// Enviar los Items de Cotizaciones del Proveedor
				Iterator iterCotizProvDet = entregaOC.getCotizacionesProvDet().iterator();
				while (iterCotizProvDet.hasNext()) {
					CotizacionProveedorDet cotizProvDet = (CotizacionProveedorDet) iterCotizProvDet.next();
					cargarItemCotizProv(dsItemsCotizProv, new Integer(++secuDetRequi), new Integer(secuDetEnt) , cotizProvDet); 
				}
				
			}
			
		}
		
	}
	
	private String getClave(Producto producto,UnidadMedida uniMedRequi,String descAdic) throws BaseException {
		String clave = "";
		clave = clave + producto.getOIDInteger().toString();
		clave = clave + "_"+uniMedRequi.getOIDInteger().toString();
		if (descAdic == null)
			clave = clave +"_";
		else
			clave = clave +"_"+descAdic;
		return clave;
	}

	private IDataSet getDataEntregaOC() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemArmadoEntOC");
		dataset.fieldDef(new Field("secu_det_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu_det_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("cant_requerida", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroEntregaOC(IDataSet dataset, 
			Integer secuDetEnt, 
			Integer secuDetOC,
			EntregaOC entregaOC) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu_det_ent", secuDetEnt);
		dataset.fieldValue("secu_det_oc", secuDetOC);
		dataset.fieldValue("fecha",entregaOC.getFecEntrega());
		dataset.fieldValue("cant_requerida", entregaOC.getCantAComprar());
		
		
	}

	private IDataSet getDataArmadoDetOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TArmadoDetOC");
		dataset.fieldDef(new Field("secu_det_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_prod", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_a_comprar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio",Field.CURRENCY, 0));
		
		return dataset;
	}

	private void cargarRegistroArmadoDetOC(IDataSet dataset, Integer secuDetOC,
			Producto producto, String descAdicProd, UnidadMedida uniMedCpra,
			Money cantAComprar,
			Moneda moneda,
			Money precio) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu_det_oc", secuDetOC);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("desc_adic_prod", descAdicProd);
		dataset.fieldValue("oid_um", uniMedCpra.getOIDInteger());
		dataset.fieldValue("cant_a_comprar", cantAComprar);
		dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
		dataset.fieldValue("precio",precio);
		
	}
	
	private IDataSet getDataItemsCotizProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemsCotizProvEntOC");
		dataset.fieldDef(new Field("secu_det_item_requi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu_det_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cotiz_prov_det",Field.INTEGER, 0));
		return dataset;
	}
	
	public void cargarItemCotizProv(IDataSet dataset,
									Integer secuItemRequi , 
									Integer secuDetEnt,
									CotizacionProveedorDet cotizProvDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu_det_item_requi", secuItemRequi);
		dataset.fieldValue("secu_det_ent", secuDetEnt);
		dataset.fieldValue("oid_cotiz_prov_det", cotizProvDet.getOIDInteger());
	}
	
	private IDataSet getDataCotizProvCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCotizProvCab");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario",Field.STRING, 255));
		return dataset;
	}
	
	public void cargarCotizProvCab(IDataSet dataset,
								   CotizacionProveedorCab cotizProvCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_proveedor", cotizProvCab.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor", cotizProvCab.getProveedor().getCodigo());
		dataset.fieldValue("rs_proveedor", cotizProvCab.getProveedor().getRazonsocial());
		dataset.fieldValue("oid_moneda", cotizProvCab.getMoneda().getOIDInteger());
		dataset.fieldValue("oid_cond_pago", cotizProvCab.getCond_pago_1().getOIDInteger());
		dataset.fieldValue("dto",cotizProvCab.getDto_cond_pago_1());
		dataset.fieldValue("comentario",cotizProvCab.getComentario());
	}	

}
