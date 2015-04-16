/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.csvimporter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ModuleActivator;

/**
 * This class contains the logic that is run every time this module is either
 * started or shutdown
 */
public class CsvImporterModuleActivator implements ModuleActivator {

    private Log log = LogFactory.getLog(this.getClass());

    /*
     * @see org.openmrs.module.ModuleActivator#willRefreshContext()
     */
    public void willRefreshContext() {
	// Called for each module just before spring's application context is
	// refreshed. This method could be called multiple times in a module
	// lifecycle i.e. whenever a new module gets started, at application
	// startup or a developer chooses to refresh the context
	// programatically.
    }

    /*
     * @see org.openmrs.module.ModuleActivator#contextRefreshed()
     */
    public void contextRefreshed() {
	// Called for each module after spring's application context is
	// refreshed , this method is also called multiple times i.e. whenever a
	// new module gets started and at application startup.
    	log.info("Module context refreshed");
    }

    /*
     * @see org.openmrs.module.ModuleActivator#willStart()
     */
    public void willStart() {
	// Called after a module has been loaded but before the application
	// context is refreshed, at this point the module's service methods
	// aren't yet available so they can't be called, so calls like
	// 'Context.getService(MyService.class)' will return null. This is
	// called once per module per time it is started. This method will be
	// authenticated as the Daemon user and have all privileges.
    }

    /*
     * @see org.openmrs.module.ModuleActivator#started()
     */
    public void started() {
	// Called after a module is started, the application context has been
	// refreshed and the module's service methods are ready to be called.
	// This is called once per module per time it is started.
    	log.info("Module started");
    }

    /*
     * @see org.openmrs.module.ModuleActivator#willStop()
     */
    public void willStop() {
	// Called just before a module is stopped. This is called once per
	// module per time it is started.
    }

    /*
     * @see org.openmrs.module.ModuleActivator#stopped()
     */
    public void stopped() {
	// Called after a module is stopped. This is called once per module per
	// time it is started.
    	log.info("Module stopped");
    }
}
