/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.reference.page;

import org.openqa.selenium.By;

public class FormEntryPage extends FindPatientPage{

	/**
	 * At OpenMRS version: 2.0.3 Build ad3b45 the FormEntry page is likely 
	 * derived from the existing FindPatient page. Therefore, it makes more
	 * sense to extend FormEntryPage class from FindPatientPage class,
	 * thus avoiding to duplicate the code. 
	 * Of course some methods available in FindPatientPage if they 
	 * are invoked are prone to fail at run-time, e.g. 
	 * the method clickOnFirstPatientAppointment() redirects to another page which
	 * is not reachable from FormEntry page.
	 * Eventually, FindPatientPage class need to be designed again 
	 * to make it more reusable. 
	 * For instance the method "clickOnFirstPatient" should return 
	 * a Page object, in this case FormEntryPage class would have
	 * override that method rather than declaring the method 
	 * clickOnFirstPatientResult that executes the same operations.
	 *  
	 */

	private static final String FORM_ENTRY_PAGE_URL ="/coreapps/findpatient/findPatient.page?app=xforms.formentry"; 
    private static final By PATIENT_NAME_SEARCH_RESULT = By.cssSelector("#patient-search-results-table tbody tr:first-child td:nth-child(2)");
	
	
	public FormEntryPage(HomePage homePage){
		super(homePage);
	}

	
	public FormEntryPatientPage clickOnFirstPatientResult() {
		clickOn(PATIENT_NAME_SEARCH_RESULT);
		return new FormEntryPatientPage(this);
	}


	@Override
	public String getPageUrl() {
        return FORM_ENTRY_PAGE_URL;
	}

}
