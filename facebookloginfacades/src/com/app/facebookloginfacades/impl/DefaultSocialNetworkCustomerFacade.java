package com.app.facebookloginfacades.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.core.model.user.CustomerModel;

import javax.annotation.Resource;

import com.app.facebookloginfacades.FacebookLoginFacade;
import com.app.facebookloginfacades.SocialNetworkCustomerFacade;
import com.app.facebookloginfacades.enums.ProviderType;
import com.app.facebookloginfacades.util.FacebookLoginUtil;

/**
 * The Class DefaultSocialNetworkCustomerFacade.
 */
public class DefaultSocialNetworkCustomerFacade extends DefaultCustomerFacade implements SocialNetworkCustomerFacade
{

	/** The facebookLoginUtil . */
	@Resource(name = "facebookLoginUtil")
	private FacebookLoginUtil facebookLoginUtil;

	/** The facebook login facade. */
	@Resource(name = "facebookLoginFacade")
	private FacebookLoginFacade facebookLoginFacade;

	/**
	 * Login success.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade#loginSuccess()
	 */
	@Override
	public void loginSuccess()
	{
		super.loginSuccess();
		if (facebookLoginUtil.isFacebookAttributesAvailable())
		{
			facebookLoginFacade.addFacebookAttributesInCustomerModel(facebookLoginUtil.getFacebookUserId());
			facebookLoginUtil.removeFacebookAttributes();
		}
	}

	/**
	 * Sets the uid for register.
	 *
	 * @param registerData
	 *           the register data
	 * @param customer
	 *           the custome
	 */
	@Override
	protected void setUidForRegister(final RegisterData registerData, final CustomerModel customer)
	{
		super.setUidForRegister(registerData, customer);
		if (ProviderType.FACEBOOK.toString().equals(registerData.getSocialNetworkProvider()))
		{
			customer.setFacebookUserId(registerData.getSocialNetworkUserId());
		}
	}

}
