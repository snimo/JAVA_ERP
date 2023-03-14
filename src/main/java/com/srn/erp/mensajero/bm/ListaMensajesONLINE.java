package com.srn.erp.mensajero.bm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaMensajesONLINE {
	
	public static int cantMens = 0;
	
	private List listaMensajes = null;

	public ListaMensajesONLINE() {
		listaMensajes = Collections.synchronizedList(new LinkedList());
	}

	public void addMensaje(MensajeONLINE aMensaje) {
		++cantMens;
		synchronized (listaMensajes) {
			listaMensajes.add(aMensaje);
		}
	}

	public void removeMensaje(MensajeONLINE aMensaje) {
		synchronized (listaMensajes) {
			listaMensajes.remove(aMensaje);
		}
	}

	public List getListaMensajes() {
		return this.listaMensajes;
	}

	public void eliminarMensajes() {
		synchronized (listaMensajes) {
			
			List mensABorrar = new ArrayList();
			
			for (int i = 0; i < listaMensajes.size(); i++) {
				MensajeONLINE aMensaje = (MensajeONLINE) listaMensajes.get(i);
				if (aMensaje.isEliminar())
					mensABorrar.add(aMensaje);
			}
			
			// Remover los objetos
			Iterator iterMensABorar = mensABorrar.iterator();
			while (iterMensABorar.hasNext()) {
				MensajeONLINE mens = (MensajeONLINE) iterMensABorar.next();
				listaMensajes.remove(mens);
			}
			
			mensABorrar = null;
			
		}

	}
	
	public static void setCantMens(int aCantMens) {
		ListaMensajesONLINE.cantMens = aCantMens;
	}
	
	public static int getCantMens() {
		return ListaMensajesONLINE.cantMens;
	}
}
