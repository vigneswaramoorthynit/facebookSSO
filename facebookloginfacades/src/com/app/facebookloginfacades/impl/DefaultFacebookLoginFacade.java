package com.app.facebookloginfacades.impl;

import de.hybris.platform.core.model.user.CustomerModel;

import javax.annotation.Resource;

import com.app.facebookloginfacades.FacebookLoginFacade;
import com.app.facebookloginfacades.data.SocialCustomerData;
import com.app.facebookloginfacades.service.FacebookLoginService;



/**
 * The Class DefaultFacebookLoginFacade.
 */
public class DefaultFacebookLoginFacade implements FacebookLoginFacade
{

	/** The facebook login service. */
	@Resource(name = "facebookLoginService")
	private FacebookLoginService facebookLoginService;

	/* (non-Javadoc)
	 */
	@Override
	public String getFacebookLoginProvider()
	{
		return facebookLoginService.getFacebookLoginProvider();
	}

	/* (non-Javadoc)
	 */
	@Override
	public SocialCustomerData getFacebookLoginSuccessCallback(final String code)
	{
		return facebookLoginService.getFacebookLoginSuccessCallback(code);
	}

	/* (non-Javadoc)
	 */
	@Override
	public void getFacebookLoginErrorCallback(final String errorReason)
	{
		facebookLoginService.getFacebookLoginErrorCallback(errorReason);
	}

	/* (non-Javadoc)
	 */
	@Override
	public CustomerModel getCustomerLinkedToFacebookAccount(final String facebookUserId)
	{
		return facebookLoginService.getCustomerLinkedToFacebookAccount(facebookUserId);
	}

	/* (non-Javadoc)
	 */
	@Override
	public void addFacebookAttributesInCustomerModel(final String facebookUserId)
	{
		facebookLoginService.addFacebookAttributesInCustomerModel(facebookUserId);
	}

}
