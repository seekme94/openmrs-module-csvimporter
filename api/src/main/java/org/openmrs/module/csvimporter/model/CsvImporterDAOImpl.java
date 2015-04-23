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
package org.openmrs.module.csvimporter.model;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.DAOException;

/**
 * @author owais.hussain@irdresearch.org
 */
public class CsvImporterDAOImpl implements CsvImporterDAO {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Hibernate session factory
	 */
	private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#createConfiguration(org.openmrs.module.csvimporter.model.CsvImporterConfiguration)
	 */
	public CsvImporterConfiguration createConfiguration(CsvImporterConfiguration configuration) throws DAOException {
		sessionFactory.getCurrentSession().save(configuration);
		return configuration;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#updateConfiguration(org.openmrs.module.csvimporter.model.CsvImporterConfiguration)
	 */
	public CsvImporterConfiguration updateConfiguration(CsvImporterConfiguration configuration) throws DAOException {
		sessionFactory.getCurrentSession().update(configuration);
		return configuration;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#deleteConfiguration(org.openmrs.module.csvimporter.model.CsvImporterConfiguration)
	 */
	public void deleteConfiguration(CsvImporterConfiguration configuration) throws DAOException {
		if (configuration.getId() != null)
			sessionFactory.getCurrentSession().delete(configuration);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getConfigurationById(java.lang.Integer)
	 */
	public CsvImporterConfiguration getConfigurationById(Integer id) throws DAOException {
		return (CsvImporterConfiguration) sessionFactory.getCurrentSession().get(CsvImporterConfiguration.class, id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getConfigurationByName(java.lang.String)
	 */
	public CsvImporterConfiguration getConfigurationByName(String name) throws DAOException {
		CsvImporterConfiguration config = (CsvImporterConfiguration) sessionFactory.getCurrentSession()
		        .createQuery("from CsvImporterConfiguration c where c.configName = :configName")
		        .setString("configName", name).uniqueResult();
		return config;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getAllConfigurations()
	 */
	@SuppressWarnings("unchecked")
	public List<CsvImporterConfiguration> getAllConfigurations() throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CsvImporterConfiguration.class);
		return criteria.list();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#createMapping(org.openmrs.module.csvimporter.model.CsvImporterMapping)
	 */
	public CsvImporterMapping createMapping(CsvImporterMapping mapping) throws DAOException {
		sessionFactory.getCurrentSession().save(mapping);
		return mapping;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#updateMapping(org.openmrs.module.csvimporter.model.CsvImporterMapping)
	 */
	public CsvImporterMapping updateMapping(CsvImporterMapping mapping) throws DAOException {
		sessionFactory.getCurrentSession().update(mapping);
		return mapping;
	}
	
	/*
	 * 	(non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#deleteMapping(org.openmrs.module.csvimporter.model.CsvImporterMapping)
	 */
	public void deleteMapping(CsvImporterMapping mapping) throws DAOException {
		sessionFactory.getCurrentSession().delete(mapping);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getCsvImporterMappingById(java.lang.Integer)
	 */
	public CsvImporterMapping getCsvImporterMappingById(Integer id) throws DAOException {
		return (CsvImporterMapping) sessionFactory.getCurrentSession().get(CsvImporterMapping.class, id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getCsvImporterMappingByColumnName(java.lang.String)
	 */
	public CsvImporterMapping getCsvImporterMappingByColumnName(String name) throws DAOException {
		CsvImporterMapping mapping = (CsvImporterMapping) sessionFactory.getCurrentSession()
		        .createQuery("from CsvImporterMapping m where m.columnName = :columnName").setString("columnName", name)
		        .uniqueResult();
		return mapping;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getCsvImporterMappingByObjectCategory(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<CsvImporterMapping> getCsvImporterMappingByObjectCategory(String objectCategory) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CsvImporterConfiguration.class)
		        .add(Restrictions.eq("objectCategory", objectCategory));
		return criteria.list();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.csvimporter.model.CsvImporterDAO#getCsvImporterMappingByObjectName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<CsvImporterMapping> getCsvImporterMappingByObjectName(String objectName) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CsvImporterConfiguration.class)
		        .add(Restrictions.eq("objectName", objectName));
		return criteria.list();
	}
}
