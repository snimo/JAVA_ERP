package com.srn.erp.ventas.bm;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;

public class ItemFactDetProdGral implements Comparable {

	public int compareTo(Object arg0) {

		return nro_renglon.compareTo(((ItemFactDetProdGral) arg0).nro_renglon);

	}

	public Integer nro_renglon;
	public int oid_fact_det;
	public int oid_cco_fact;
	public int oid_art;
	public String cod_producto;
	public String desc_producto;
	public int oid_um_ori;
	public String desc_um_ori;
	public Money cantidad = new Money(0);
	public Money precio = new Money(0);
	public Money precio_lista = new Money(0);
	public Money precio_sugerido = new Money(0);
	public Money precio_bonif = new Money(0);
	public Money importe = new Money(0);
	public int oid_moneda;
	public boolean activo;
	public Porcentaje bonif1 = new Porcentaje(0);
	public Porcentaje bonif2 = new Porcentaje(0);
	public Porcentaje bonif3 = new Porcentaje(0);
	public String comentario;
	public int oid_conc_imp_iva;
	public int oid_conc_imp_perc_iva;
	public int oid_conc_imp_int;
	public int oid_conc_imp_perc_ib;
	public String subtotal;

	public Money acum_bruto = new Money(0);
	public Money acum_descuento = new Money(0);
	public Money acum_recargo = new Money(0);
	public Money acum_neto = new Money(0);
	public Money acum_iva = new Money(0);
	public Money acum_iva_2 = new Money(0);
	public Money acum_perc_iva = new Money(0);
	public Money acum_imp_int = new Money(0);
	public Money acum_perc_ib = new Money(0);
	public Money acum_perc_ib_ba = new Money(0);
	public Money acum_total = new Money(0);
	
	public static String getClave(
			String oidProducto,
			String observacion,
			Integer oidUM,
			Money precio,
			Money precioLista,
			Money precioSugerido,
			Money precioBonif,
			Porcentaje bonif1,
			Porcentaje bonif2,
			Porcentaje bonif3,
			Integer oidConcImpIVA,
			Integer oidConcImpPercIVA,
			Integer oidConcImpInt,
			Integer oidConcImpPercIB) {
		
		StringBuffer clave = new StringBuffer("");
		if (oidProducto!=null)
			clave.append(oidProducto+"_");
		else
			clave.append("?");
		
		if (observacion!=null)
			clave.append(observacion+"_");
		else
			clave.append("?");
		
		if (oidUM!=null)
			clave.append(oidUM+"_");
		else
			clave.append("?");
		
		if (precio!=null)
			clave.append(precio.doubleValue()+"_");
		else
			clave.append("?");
		
		if (precioLista!=null)
			clave.append(precioLista.doubleValue()+"_");
		else
			clave.append("?");
		
		if (precioSugerido!=null)
			clave.append(precioSugerido.doubleValue()+"_");
		else
			clave.append("?");
		
		if (precioBonif!=null)
			clave.append(precioBonif.doubleValue()+"_");
		else
			clave.append("?");
				
		if (bonif1!=null)
			clave.append(bonif1.doubleValue()+"_");
		else
			clave.append("?");

		if (bonif2!=null)
			clave.append(bonif2.doubleValue()+"_");
		else
			clave.append("?");

		if (bonif3!=null)
			clave.append(bonif3.doubleValue()+"_");
		else
			clave.append("?");

		if (oidConcImpIVA!=null)
			clave.append(oidConcImpIVA+"_");
		else
			clave.append("?");
		
		if (oidConcImpPercIVA!=null)
			clave.append(oidConcImpPercIVA+"_");
		else
			clave.append("?");
		
		if (oidConcImpInt!=null)
			clave.append(oidConcImpInt+"_");
		else
			clave.append("?");
		
		if (oidConcImpPercIVA!=null)
			clave.append(oidConcImpPercIVA+"_");
		else
			clave.append("?");
				
		
		return clave.toString();
	}

}
