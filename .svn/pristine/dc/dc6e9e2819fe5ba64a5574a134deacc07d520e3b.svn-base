package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPaySectores;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PaySectores extends ObjetoLogico {

	public PaySectores() {
	}

	public static String NICKNAME = "admRRHH.paySectores";

	private Integer codigo;
	private String descripcion;

	public Integer getCodigoActual() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(Integer aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PaySectores findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PaySectores) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PaySectores findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PaySectores) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<PaySectores> findAll(ISesion aSesion) throws BaseException {
		return (List<PaySectores>) DBPaySectores.findAll(aSesion);
	}
	
	public static List<PaySectores> findByEmpresa(String oid_empresa, ISesion aSesion) throws BaseException {
		return (List<PaySectores>) DBPaySectores.findByEmpresa(oid_empresa, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
