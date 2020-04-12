package com.app.facebookloginfacades.impl;

import javax.annotation.Resource;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.facebookloginfacades.FacebookRegistrationFacade;
import com.app.facebookloginfacades.data.SocialCustomerData;
import com.app.facebookloginfacades.service.FacebookRegistrationService;


/**
 * The Class DefaultFacebookRegistrationFacade.
 */
public class DefaultFacebookRegistrationFacade implements FacebookRegistrationFacade
{

	/** The facebook registration service. */
	@Resource(name = "facebookRegistrationService")
	private FacebookRegistrationService facebookRegistrationService;

	/* (non-Javadoc)
	 * getFacebookProvider()
	 */
	@Override
	public String getFacebookProvider()
	{
		return facebookRegistrationService.getFacebookProvider();
	}

	/* (non-Javadoc)
	 *
	 * SocialCustomerData getFacebookRegistrationSuccessCallback(final String code, final RedirectAttributes redirectAttributes)
	 */
	@Override
	public SocialCustomerData getFacebookRegistrationSuccessCallback(final String code, final RedirectAttributes redirectAttributes)
	{
		return facebookRegistrationService.getFacebookRegistrationSuccessCallback(code, redirectAttributes);
	}

	/* (non-Javadoc)
	 * getFacebookRegistrationErrorCallback(final String errorReason)
	 */
	@Override
	public void getFacebookRegistrationErrorCallback(final String errorReason)
	{
		facebookRegistrationService.getFacebookRegistrationErrorCallback(errorReason);
	}

}
