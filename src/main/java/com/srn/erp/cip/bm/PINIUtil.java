package com.srn.erp.cip.bm;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PINIUtil {

	public PINIUtil() {

	}

	public static String getFechaFomatoPINI(ISesion aSesion) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		try {
			return sdf.format(UtilCIP.getFechaHoraActual(aSesion));
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			return sdf.format(cal.getTime());
		}
	}

}
