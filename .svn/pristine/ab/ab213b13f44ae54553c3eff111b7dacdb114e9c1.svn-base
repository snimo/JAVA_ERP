package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;

public class PINIUpgradeList extends PINIEventoBase {

	private static String UPGRADELIST = "UPGRADELIST";
	private static String ID = "ID";
	private static String LISTID = "LISTID";
	private static String UPGRADE = "UPGRADE";
	
	private static String LISTCONFIRM = "LISTCONFIRM";

	private int valor_ID = -1;
	private Integer valor_LIST_ID = -1;

	public void inicializar() {
		valor_ID = -1;
		valor_LIST_ID = -1;
	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else if (clave.equals(LISTID)) {
			try {
				valor_LIST_ID = new Integer(valor);
			} catch (Exception e) {
				valor_LIST_ID = 1;
			}
			
		}
	}

	public void internalRun(PINIAccess response) throws BaseException {
		response.clear();
		response.setSeccion(PINIUpgradeList.LISTCONFIRM);
		response.addClave(PINIUpgradeList.UPGRADE,"1");
		//if (valor_LIST_ID.intValue()!=1)
		//	response.addClave(PINIUpgradeList.UPGRADE,"1");
	//	else
		//	response.addClave(PINIUpgradeList.UPGRADE,"0");
		//response.addClave(PINIUpgradeList.UPGRADE,valor_LIST_ID.toString());
	}

}
