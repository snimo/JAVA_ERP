package com.srn.erp.cip.bm;

import java.util.Comparator;

import framework.request.bl.Utils.BaseException;

public class OrdenarFichadasPorFecha implements Comparator<CIPFichadaOficina>{

	@Override
	public int compare(CIPFichadaOficina fichada1, CIPFichadaOficina fichada2){
		try {
			return fichada1.getFec_hor().compareTo(fichada2.getFec_hor());
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
