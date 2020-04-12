package com.app.facebookloginfacades.service;

import de.hybris.platform.core.model.user.CustomerModel;

import com.app.facebookloginfacades.data.SocialCustomerData;



/**
 * The Interface FacebookLoginService.
 */
public interface FacebookLoginService
{

	/**
	 * Gets the facebook login provider.
	 *
	 * @return the facebook login provider
	 */
	String getFacebookLoginProvider();

	/**
	 * Gets the facebook login success callback.
	 *
	 * @param code the code
	 * @return the facebook login success callback
	 */
	SocialCustomerData getFacebookLoginSuccessCallback(final String code);

	/**
	 * Gets the facebook login error callback.
	 *
	 * @param errorReason the error reason
	 * @return the facebook login error callback
	 */
	void getFacebookLoginErrorCallback(final String errorReason);

	/**
	 * Gets the customer linked to facebook account.
	 *
	 * @param facebookEmailId the facebook email id
	 * @return the customer linked to facebook account
	 */
	CustomerModel getCustomerLinkedToFacebookAccount(String facebookEmailId);

	/**
	 * Adds the facebook attributes in customer model.
	 *
	 * @param facebookEmailId the facebook email id
	 */
	void addFacebookAttributesInCustomerModel(String facebookEmailId);
}
