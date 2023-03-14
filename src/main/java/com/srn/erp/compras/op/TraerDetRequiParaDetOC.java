package com.srn.erp.compras.op;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionDet;
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

public class TraerDetRequiParaDetOC extends Operation {

	private HashTableDatos listaDetOC = new HashTableDatos();
	private HashTableDatos listaEntregas = new HashTableDatos();
	
	private class EntregaOC {
		
		Producto producto = null;
		UnidadMedida uniMed = null;
		Money cantAComprar = new Money(0);
		Date fecEntrega = null;
		List listaItemsRequi = new ArrayList();
		
		public void addRequisicionDet(RequisicionDet aRequisicionDet) throws BaseException {
			listaItemsRequi.add(aRequisicionDet);
		}
		
		public List getRequisicionesDet() throws BaseException {
			return listaItemsRequi;
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
		
		public void addItemRequisicion(RequisicionDet requiDet) throws BaseException {
			
		  java.util.Date fecha = requiDet.getFec_requerida();
		  String claveFecha    = Fecha.getddmmyyyy(fecha);
		  EntregaOC entregaOC  = (EntregaOC) listaEntregas.get(claveFecha);
		  
		  if (entregaOC == null) {
			  entregaOC = new EntregaOC();
			  entregaOC.setProducto(requiDet.getProducto());
			  entregaOC.setUniMed(requiDet.getUnidad_medida_req());
			  entregaOC.setFecEntrega(fecha);
			  listaEntregas.put(claveFecha,entregaOC);
		  }
		  
		  entregaOC.setCantAComprar(new Money(requiDet.getCant_solicitada().doubleValue()));
		  
		  // Agregar la Requisicion Detalle
		  entregaOC.addRequisicionDet(requiDet);
		  
		}
		
		public HashTableDatos getEntregas() throws BaseException {
			return listaEntregas;
		}
		
		public void setProducto(Producto aProducto) throws BaseException {
			if (aProducto == null)
				throw new ExceptionValidation(null,"Debe ingresar un producto");
			this.producto = aProducto;
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
	
	
	public TraerDetRequiParaDetOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsArmadoDetOC = getDataArmadoDetOC();
		IDataSet dsEntregaOC   = getDataEntregaOC();
		IDataSet dsItemsRequiDetOC  = getDataItemsRequi();
		
		// Recorrer los items de Requisiciones
		IDataSet dsItemsRequi = mapaDatos.getDataSet("TItemsRequi");
		dsItemsRequi.first();
		while (!dsItemsRequi.EOF()) {
			armarDetOC(dsItemsRequi.getInteger("oid_req_det"));
			dsItemsRequi.next();
		}
		
		// Enviar Detalles de OC
		enviarDetOC(dsArmadoDetOC,dsEntregaOC,dsItemsRequiDetOC);
		
		writeCliente(dsArmadoDetOC);
		writeCliente(dsEntregaOC);
		writeCliente(dsItemsRequiDetOC);
		
	}
	
	private void armarDetOC(Integer oidItemRequi) throws BaseException {
		RequisicionDet requiDet = RequisicionDet.findByOid(oidItemRequi,getSesion());
		if (!requiDet.isAutorizado())
			throw new ExceptionValidation(null,"El item "+requiDet.getRenglon().toString()+" de la "+requiDet.getRequisicion().getCodigo()+" - "+
					                           " producto "+requiDet.getProducto().getCodigo()+" - "+
					                           requiDet.getProducto().getDescripcion()+" no esta autorizado.");
		String clave = getClave(requiDet.getProducto(),requiDet.getUnidad_medida_req(),requiDet.getDesc_adic_sku());
		cargarDetOC(requiDet,clave);
	}
	
	public void cargarDetOC(RequisicionDet requiDet,String clave) throws BaseException {
		
		ArmadoDetOC armadoDetOC = (ArmadoDetOC) listaDetOC.get(clave);
		if (armadoDetOC == null) {
			armadoDetOC = new ArmadoDetOC();
			armadoDetOC.setProducto(requiDet.getProducto());
			armadoDetOC.setUnidadMedida(requiDet.getUnidad_medida_req());
			armadoDetOC.setDescAdic(requiDet.getDesc_adic_sku());
			listaDetOC.put(clave,armadoDetOC);
		}
		armadoDetOC.setCantRequerida(new Money(requiDet.getcantPendCompra().doubleValue()));
		armadoDetOC.addItemRequisicion(requiDet);
	}
		
	private void enviarDetOC(IDataSet dsArmadoDetOC,
			                 IDataSet dsArmadoEntrega,
			                 IDataSet dsItemsRequi) throws BaseException {
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
									  armadoDetOC.getCantRequerida());
			
			// Enviar las Entregas del Detalle
			Iterator iterEntregas = armadoDetOC.getEntregas().values().iterator();
			while (iterEntregas.hasNext()) {
				EntregaOC entregaOC = (EntregaOC) iterEntregas.next();
				cargarRegistroEntregaOC(dsArmadoEntrega,
						                new Integer(++secuDetEnt),
						                new Integer(secuDetOC),
						                entregaOC);
				
				// Enviar los Items de Requisiciones correspondientes a las entregas
				Iterator iterRequiDet = entregaOC.getRequisicionesDet().iterator();
				while (iterRequiDet.hasNext()) {
					RequisicionDet requiDet = (RequisicionDet) iterRequiDet.next();
					cargarItemRequi(dsItemsRequi, new Integer(++secuDetRequi), new Integer(secuDetEnt) , requiDet); 
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
		return dataset;
	}

	private void cargarRegistroArmadoDetOC(IDataSet dataset, Integer secuDetOC,
			Producto producto, String descAdicProd, UnidadMedida uniMedCpra,
			Money cantAComprar) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu_det_oc", secuDetOC);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("desc_adic_prod", descAdicProd);
		dataset.fieldValue("oid_um", uniMedCpra.getOIDInteger());
		dataset.fieldValue("cant_a_comprar", cantAComprar);
	}
	
	private IDataSet getDataItemsRequi() {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemsRequiEntOC");
		dataset.fieldDef(new Field("secu_det_item_requi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu_det_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_requi_det",Field.INTEGER, 0));
		return dataset;
	}
	
	public void cargarItemRequi(IDataSet dataset,Integer secuItemRequi , Integer secuDetEnt,RequisicionDet requiDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu_det_item_requi", secuItemRequi);
		dataset.fieldValue("secu_det_ent", secuDetEnt);
		dataset.fieldValue("oid_requi_det", requiDet.getOIDInteger());
	}

}
