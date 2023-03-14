package com.srn.erp.mensajero.bm;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MiSenialONLINE {

	private static MiSenialONLINE miSenialONLINE;

	protected boolean hasDataToProcess = false;
	public Timer mitimer = new Timer();

	boolean wasSignalled = false;
	private static  Lock mutex = null;

	MotorMensONLINE monitorMensOL = new MotorMensONLINE();

	public synchronized boolean hasDataToProcess() {
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData) {
		this.hasDataToProcess = hasData;
	}

	public void doWait() {
		synchronized (monitorMensOL) {
			if (!wasSignalled) {
				try {
					monitorMensOL.wait();
				} catch (InterruptedException e) {
				}
			}
			// clear signal and continue running.
			wasSignalled = false;
		}
	}

	public void doNotify() {
		synchronized (monitorMensOL) {
			wasSignalled = true;
			monitorMensOL.notifyAll();
		}

	}
	


	
	

	static public synchronized  MiSenialONLINE getMiSenialONLINE() {
		
		if (miSenialONLINE == null) {
			miSenialONLINE = new MiSenialONLINE();
			miSenialONLINE.mitimer.scheduleAtFixedRate(new TimerTask() {
		        public void run() {
		        	if (MiSenialONLINE.getMiSenialONLINE()!=null)
		        		MiSenialONLINE.getMiSenialONLINE().doNotify();
		        }
		    }, 1000, 1000*60*5);
			
			
		}
		return miSenialONLINE;
	}
	
	static public Lock getSemaphore() {
		if (mutex==null)
			mutex = new ReentrantLock(); 
		return mutex;
	}
	
	static public void bloquearCodigo() {
		getSemaphore().lock();
	}
	
	static public void DesbloquearCodigo() {
		getSemaphore().unlock();
	}
	

}
