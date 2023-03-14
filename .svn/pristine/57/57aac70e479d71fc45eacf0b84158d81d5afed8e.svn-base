package com.srn.erp.compras.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ManejadorImpresionResumenOC {
	
	HashTableDatos items = new HashTableDatos();
	
	public void addItem(	Integer oidOCDet,
							Integer oicOC,
							Integer nroItem,
							String codArtProv,
							String codProducto,
							String descProducto,
							String descAdicional,
							String unidadMedida,
							Double cantidad,
							Double precio,
							Double dto1,
							Double dto2,
							Double dto3,
							Double dtoGeneral,
							Double precioNeto,
							Double total,
							java.util.Date fecRequerida,
							String lugarEntrega) throws BaseException {
		
		String clave =
			getClave(codArtProv, 
					descAdicional, 
					unidadMedida, 
					precio, 
					dto1, dto2, dto3, dtoGeneral, precioNeto, fecRequerida, lugarEntrega);
		
		
		ImpresionItemResumenOC item = getItem(clave);
		if (item == null) {
			item = new ImpresionItemResumenOC();
			item.oidOCDet = oidOCDet; 
			item.oicOC = oicOC;
			item.nroItem = nroItem;
			item.codArtProv = codArtProv; 
			item.codProducto = codProducto; 
			item.descProducto = descProducto; 
			item.descAdicional = descAdicional;
			item.unidadMedida = unidadMedida;
			item.cantidad = cantidad;
			item.precio = precio;
			item.dto1 = dto1;
			item.dto2 = dto2; 
			item.dto3 = dto3; 
			item.dtoGeneral = dtoGeneral; 
			item.precioNeto = precioNeto; 
			item.total = total;
			item.fecRequerida = fecRequerida;
			item.lugarEntrega = lugarEntrega;
			items.put(clave, item);
		} else {
			CalculadorMoney calcTotCant = new CalculadorMoney(new Money(item.cantidad.doubleValue()));
			calcTotCant.sumar(new Money(cantidad));
			item.cantidad = calcTotCant.getResult();
			
			CalculadorMoney calcTotal = new CalculadorMoney(new Money(item.total));
			calcTotal.sumar(new Money(total));
			item.total = calcTotal.getResult();
			
		}
		
	}
	
	private ImpresionItemResumenOC getItem(String clave) throws BaseException {
		return (ImpresionItemResumenOC)this.items.get(clave);
	}
	
	private String getClave(String codArtProv,
			                     String descAdicional,
			                     String uniMed,
			                     Double precio,
			                     Double dto1,
			                     Double dto2,
			                     Double dto3,
			                     Double dtoGeneral,
			                     Double precioNeto,
			                     java.util.Date fecRequerida,
			                     String lugarEntrega) throws BaseException {
		StringBuffer armarClave = new StringBuffer("");
		
		
		armarClave.append("_"+codArtProv);
		armarClave.append("_"+descAdicional);
		armarClave.append("_"+uniMed);
		armarClave.append("_"+precio.toString());
		armarClave.append("_"+dto1.toString());
		armarClave.append("_"+dto2.toString());
		armarClave.append("_"+dto3.toString());
		armarClave.append("_"+dtoGeneral.toString());
		armarClave.append("_"+precioNeto.toString());
		armarClave.append("_"+Fecha.getddmmyyyy(fecRequerida));
		armarClave.append("_"+lugarEntrega);
		return armarClave.toString(); 
		
	}
	
	public HashTableDatos getItems() throws BaseException {
		return this.items;
	}


}
