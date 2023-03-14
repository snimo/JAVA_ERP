package com.srn.erp.mensajero.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.mensajero.bm.MensajeONLINE;
import com.srn.erp.mensajero.bm.MotorMensONLINE;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMensUsuMaq extends Operation {

	@Override
	public void finOperacion() throws BaseException {
		super.finOperacion();
	}

	public TraerMensUsuMaq() {
		
		
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		List lista = 
			MotorMensONLINE.getMotor().getListaMensajes();
		
		IDataSet dsMensCab = getDataSetMensCab();
		
		Iterator iterLista = 
			lista.iterator();
		while (iterLista.hasNext()) {
			
			MensajeONLINE aMensaje = (MensajeONLINE) iterLista.next();

			// Clave nodo
			String nodo = mapaDatos.getString("sys_computer").toUpperCase()+"_"+
						  mapaDatos.getString("sys_login_name").toUpperCase()+"_"+
						  mapaDatos.getString("sys_oid_thread").toUpperCase();
			
			// Verificar que sea el usuario, que es el login
			if ((aMensaje.hasMaquina(mapaDatos.getString("sys_computer").toUpperCase()))
				||
				(aMensaje.hasUsuario(mapaDatos.getString("sys_login_name").toUpperCase()))) {
				
				if ((!aMensaje.isNodoProcesado(nodo))) {
				
					if ((aMensaje.getAntiguedadEnSeg()<5)) {
						
						cargarRegistroMensCab(
								dsMensCab,
								aMensaje.getMensaje(), 
								Fecha.getddmmyyyy(Fecha.getFechaActual())+
								" "+ 
								Fecha.getHoraActual(),
								aMensaje.getPathSonido(),
								aMensaje.getIdSonido(),
								aMensaje.getPathImagen(),
								aMensaje.getIdImagen(),
								aMensaje.getImagenAlto(),
								aMensaje.getImagenAncho(),
								aMensaje.getFormulario(),
								aMensaje.getOidObjNeg(),
								aMensaje.getExternalCall()
								);
								
						
						aMensaje.addNodoProcesado(nodo);
						
					} else {
						aMensaje.setEliminar(true);
					}
					
				}
				
			}
			
		}
		
		writeCliente(dsMensCab);

	}
	
	private IDataSet getDataSetMensCab() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabMensaje");
		dataset.fieldDef(new Field("mensaje", Field.STRING, 5000));
		dataset.fieldDef(new Field("fecha_hora", Field.STRING, 100));
		dataset.fieldDef(new Field("path_arch_sonido", Field.STRING, 255));
		dataset.fieldDef(new Field("id_sonido", Field.INTEGER, 0));
		dataset.fieldDef(new Field("path_arch_imagen", Field.STRING, 255));
		dataset.fieldDef(new Field("id_imagen", Field.STRING, 100));		
		dataset.fieldDef(new Field("imagen_alto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("imagen_ancho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("formulario", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("external_call", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarRegistroMensCab(
			IDataSet dataset, 
			String mensaje , 
			String fechaHora , 
			String pathArchSonido,
			Integer idSonido,
			String pathArchImagen,
			String idImagen,
			Integer imagenAlto,
			Integer imagenAncho,
			String formulario,
			Integer oidObjNeg,
			String externalCall
			) throws BaseException {
		dataset.append();
		dataset.fieldValue("mensaje",  mensaje);
		dataset.fieldValue("fecha_hora", fechaHora);
		dataset.fieldValue("path_arch_sonido", pathArchSonido);
		dataset.fieldValue("id_sonido", idSonido);
		dataset.fieldValue("path_arch_imagen", pathArchImagen); 
		dataset.fieldValue("id_imagen", idImagen);
		dataset.fieldValue("imagen_alto", imagenAlto);
		dataset.fieldValue("imagen_ancho", imagenAncho);
		dataset.fieldValue("formulario", formulario);
		dataset.fieldValue("oid_obj_neg", oidObjNeg);
		dataset.fieldValue("external_call", externalCall);
		
		
				
		
	}	
	
	
}
