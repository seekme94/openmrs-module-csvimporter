/**
 * Copyright(C) 2015 Interactive Health Solutions, Pvt. Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 3 of the License (GPLv3), or any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Interactive Health Solutions, info@ihsinformatics.com
 * You can also access the license on the internet at the address: http://www.gnu.org/licenses/gpl-3.0.html
 * Interactive Health Solutions, hereby disclaims all copyright interest in this program written by the contributors.
 * Contributors: Owais
 */
package org.openmrs.module.csvimporter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.csvimporter.model.CsvImporterConfiguration;
import org.openmrs.module.csvimporter.model.CsvImporterDAO;
import org.openmrs.module.csvimporter.model.CsvImporterDAOImpl;
import org.openmrs.module.csvimporter.model.CsvImporterMapping;

/**
 * @author owais.hussain@irdresearch.org
 */
public class CsvImporterServiceImpl extends BaseOpenmrsService implements CsvImporterService {
	
	public static final String MODULE_NAME = "org.openmrs.csvimporter";
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	private CsvImporterDAO dao;
	
	
    /**
     * 
     */
    public CsvImporterServiceImpl() {
    	dao = new CsvImporterDAOImpl();
    }
	
	/**
	 * Returns module by its qualified name
	 */
	public CsvImporterService getMyModuleByName(String name) {
		if (name.equals(MODULE_NAME))
			return this;
		return null;
	}
	
	public CsvImporterDAO getDao() {
		return dao;
	}
	
	public void setDao(CsvImporterDAO dao) {
		this.dao = dao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#saveConfiguration(org.openmrs.module.csvimporter.model.CsvImporterConfiguration)
	 */
	public CsvImporterConfiguration saveConfiguration(CsvImporterConfiguration configuration) throws DAOException {
		if (configuration.getId() == null) {
			dao.createConfiguration(configuration);
		} else {
			dao.updateConfiguration(configuration);
		}
		return configuration;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#deleteConfiguration(org.openmrs.module.csvimporter.model.CsvImporterConfiguration)
	 */
	public void deleteConfiguration(CsvImporterConfiguration configuration) throws DAOException {
		dao.deleteConfiguration(configuration);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getConfigurationById(java.lang.Integer)
	 */
	public CsvImporterConfiguration getConfigurationById(Integer id) throws DAOException {
		if (id == null) {
			return null;
		}
		return dao.getConfigurationById(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getConfigurationByName(java.lang.String)
	 */
	public CsvImporterConfiguration getConfigurationByName(String name) throws DAOException {
		if ("".equals(name)) {
			return null;
		}
		return dao.getConfigurationByName(name);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getAllConfigurations()
	 */
	public List<CsvImporterConfiguration> getAllConfigurations() throws DAOException {
		return dao.getAllConfigurations();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#saveMapping(org.openmrs.module.csvimporter.model.CsvImporterMapping)
	 */
	public CsvImporterMapping saveMapping(CsvImporterMapping mapping) throws DAOException {
		if (mapping.getId() == null) {
			dao.createMapping(mapping);
		} else {
			dao.updateMapping(mapping);
		}
		return mapping;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#saveMappings(java.util.List)
	 */
	public List<CsvImporterMapping> saveMappings(List<CsvImporterMapping> mappings) throws DAOException {
		for (CsvImporterMapping m : mappings) {
			saveMapping(m);
		}
		return mappings;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#deleteMapping(org.openmrs.module.csvimporter.model.CsvImporterMapping)
	 */
	public void deleteMapping(CsvImporterMapping mapping) throws DAOException {
		dao.deleteMapping(mapping);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getCsvImporterMappingById(java.lang.Integer)
	 */
	public CsvImporterMapping getCsvImporterMappingById(Integer id) throws DAOException {
		return dao.getCsvImporterMappingById(id);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getCsvImporterMappingByColumnName(java.lang.String)
	 */
	public CsvImporterMapping getCsvImporterMappingByColumnName(String name) throws DAOException {
		return dao.getCsvImporterMappingByColumnName(name);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getCsvImporterMappingByObjectCategory(java.lang.String)
	 */
	public List<CsvImporterMapping> getCsvImporterMappingByObjectCategory(String objectCategory) throws DAOException {
		return dao.getCsvImporterMappingByObjectCategory(objectCategory);
	}
	
	/* (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.CsvImporterService#getCsvImporterMappingByObjectName(java.lang.String)
	 */
	public List<CsvImporterMapping> getCsvImporterMappingByObjectName(String objectName) throws DAOException {
		return dao.getCsvImporterMappingByObjectName(objectName);
	}
	
}
