package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.AtributosProducto;

import framework.request.bl.Utils.BaseException;

public class TablasDeEntidades {
	
	private List listaTablasDeEntidades = new ArrayList();
	
	public TablasDeEntidades() {
		addTablaDeEntidad(new TablaDeEntidad(AtributosProducto.NICKNAME,"stProductoAtri"));
	}
	
	public void addTablaDeEntidad(TablaDeEntidad aTablaDeEntidad) {
		this.listaTablasDeEntidades.add(aTablaDeEntidad);
	}
	
	public TablaDeEntidad getTablaDeEntidad(String aNombreNickname) throws BaseException {
		TablaDeEntidad tablaDeEntFound = null;
		Iterator iterTablasDeEntidades = this.listaTablasDeEntidades.iterator();
		while (iterTablasDeEntidades.hasNext()) {
			TablaDeEntidad tablaDeEntidad = (TablaDeEntidad) iterTablasDeEntidades.next();
			if (tablaDeEntidad.getNombreNickName().equals(aNombreNickname))
				 return tablaDeEntidad;
		}
		return tablaDeEntFound;
	}
		

}
