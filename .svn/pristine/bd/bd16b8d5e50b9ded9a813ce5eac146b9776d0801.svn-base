package com.srn.erp.schedule.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class JobSchedule extends ObjetoLogico { 


@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

	@Override
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

public JobSchedule() { 
  }

  public static String NICKNAME = "sc.JobSchedule";

  private String codigo;
  private String descripcion;
  private String operacion;
  private Boolean activo;
  private GrupoJobSchedule grupo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getOperacion() throws BaseException { 
    supportRefresh();
    return operacion;
  }

  public void setOperacion(String aOperacion) { 
    this.operacion =  aOperacion;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public GrupoJobSchedule getGrupo() throws BaseException { 
    supportRefresh();
    return grupo;
  }

  public void setGrupo(GrupoJobSchedule aGrupo) { 
    this.grupo =  aGrupo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static JobSchedule findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (JobSchedule) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static JobSchedule findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (JobSchedule) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static JobSchedule findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (JobSchedule) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(operacion, "Debe ingresar la Operación");
    Validar.noNulo(grupo, "Debe ingresar el Grupo");
 }

}
