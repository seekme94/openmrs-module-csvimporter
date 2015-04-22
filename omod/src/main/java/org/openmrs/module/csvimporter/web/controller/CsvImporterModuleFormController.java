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

package org.openmrs.module.csvimporter.web.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.csvimporter.CsvImporterService;
import org.openmrs.module.csvimporter.model.CsvImporterConfiguration;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/basicmodule/basicmoduleLink.form'.
 */
@Controller
@RequestMapping(value = "module/basicmodule/basicmoduleLink.form")
public class CsvImporterModuleFormController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(CsvImporterModuleFormController.class);
	
	/** Success form view name */
	private final String SUCCESS_FORM_VIEW = "/module/csvimporter/csvimporterForm";
	
	/**
	 * Initially called after the formBackingObject method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return SUCCESS_FORM_VIEW;
	}
	
	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	                       BindingResult errors) {
		if (errors.hasErrors()) {
			// return error view
		}
		return SUCCESS_FORM_VIEW;
	}
	
	protected void populateModel(HttpServletRequest request, Map<String, Object> model) {
		// TODO: My code here
	}
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The bean name defined in the ModelAttribute annotation and the type can be just defined
	 * by the return type of this method
	 */
	@ModelAttribute("configList")
	protected Collection<CsvImporterConfiguration> formBackingObject(HttpServletRequest request) throws Exception {
		// This is the object returned and used in the jsp as ${levelFormBackingObject} because it is defined as such in the /metadata/moduleApplicationContext
		List<CsvImporterConfiguration> configurations = Context.getService(CsvImporterService.class).getAllConfigurations();
		return configurations;
	}
	
	@RequestMapping(value = "/module/csvimporter/csvimporterForm.form", method = RequestMethod.POST)
	public String submitCsvImporterConfiguration(WebRequest request, HttpSession httpSession, ModelMap model,
	                                             @RequestParam(required = false, value = "action") String action,
	                                             @ModelAttribute("department") CsvImporterConfiguration configuration,
	                                             BindingResult errors) {
		
		MessageSourceService mss = Context.getMessageSourceService();
		CsvImporterService csvImporterService = Context.getService(CsvImporterService.class);

		if (!Context.isAuthenticated()) {
			errors.reject("csvimporter.auth.failed");
		}
		else if (mss.getMessage("save.configuration").equals(action)) {
			csvImporterService.saveConfiguration(configuration);
			try {
	            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "csvimporter.config.save.success");
	            return "redirect:csvimporterList.list";
            }
            catch (Exception e) {
	            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "csvimporter.config.save.fail");
	            log.error(e);
				return "redirect:departmentForm.form?configId=" + request.getParameter("configId");
            }
		}
		
		else if (mss.getMessage("delete.configuration").equals(action)) {
		}
		return "redirect:csvimporterList";
	}
}
