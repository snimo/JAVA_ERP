package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.RemplesPayroll;
import com.srn.erp.cip.da.DBRemplesPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemplesPayroll extends FactoryObjetoLogico {

	public FactoryRemplesPayroll() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

		RemplesPayroll remplespayroll = (RemplesPayroll) objLog;
		remplespayroll.setOID(db.getInteger(DBRemplesPayroll.OID_REMPLES));
		remplespayroll.setEmpresa(db.getString(DBRemplesPayroll.EMPRESA));
		remplespayroll.setCodigo(db.getString(DBRemplesPayroll.CODIGO));
		remplespayroll.setNombre(db.getString(DBRemplesPayroll.NOMBRE));
		remplespayroll.setEstado(db.getString(DBRemplesPayroll.ESTADO));
		remplespayroll.setFecha_ing(db.getDate(DBRemplesPayroll.FECHA_GRA));
		remplespayroll.setFecha_ret(db.getDate(DBRemplesPayroll.FECHA_RET));
		remplespayroll.setCencos(db.getInteger(DBRemplesPayroll.CENCOS));
		remplespayroll.setActivo(db.getBoolean(DBRemplesPayroll.ACTIVO));
		remplespayroll.setCredenc(db.getString(DBRemplesPayroll.CREDENC));
		remplespayroll.setCargo(db.getInteger(DBRemplesPayroll.CARGO));

		remplespayroll.setRUT(db.getString(DBRemplesPayroll.RUT));
		remplespayroll.setSexo(db.getString(DBRemplesPayroll.SEXO));
		remplespayroll.setDireccion(db.getString(DBRemplesPayroll.DIRECCION));
		remplespayroll.setEstadoCivil(db.getString(DBRemplesPayroll.EST_CIVIL));
		remplespayroll.setFecNacimiento(db.getDate(DBRemplesPayroll.FECHA_NAC));
		remplespayroll.setTipoDocumento(db.getInteger(DBRemplesPayroll.TIPO_DOC));
		remplespayroll.setNroDocumento(db.getString(DBRemplesPayroll.NUMDOC));
		remplespayroll.setTelParticular(db.getString(DBRemplesPayroll.FONO));
		remplespayroll.setTelCelular(db.getString(DBRemplesPayroll.CELULAR));
		remplespayroll.setClaseSindicato(db.getInteger(DBRemplesPayroll.CLASE));
		remplespayroll.setMotivoEgresoEmp(db.getInteger(DBRemplesPayroll.MOTI_RET));
		remplespayroll.setUbica(db.getInteger(DBRemplesPayroll.UBICA));

		remplespayroll.setFecAntReconocida(db.getDate(DBRemplesPayroll.FECHA_ING));
		remplespayroll.setFecVencProt(db.getDate(DBRemplesPayroll.FECHA_ISA));
		remplespayroll.setFecIngUTE(db.getDate(DBRemplesPayroll.FECHA_XTR));
		remplespayroll.setGrado(db.getInteger(DBRemplesPayroll.GRADO));
		remplespayroll.setUbica(db.getInteger(DBRemplesPayroll.UBICA));
		remplespayroll.setClasif(db.getInteger(DBRemplesPayroll.CLASIF));
		remplespayroll.setCatego(db.getInteger(DBRemplesPayroll.CATEGO));
		remplespayroll.setCargoUnificado(db.getInteger(DBRemplesPayroll.CARGO_UNIFICADO));
		remplespayroll.setSeccion(db.getInteger(DBRemplesPayroll.SECCION));
		
		
		

	}
}
