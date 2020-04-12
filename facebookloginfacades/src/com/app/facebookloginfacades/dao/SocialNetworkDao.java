package com.app.facebookloginfacades.dao;

import de.hybris.platform.core.model.user.CustomerModel;


/**
 * The Interface SocialNetworkDao.
 */
public interface SocialNetworkDao
{

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
	 * @param customerModel the customer model
	 * @param facebookEmailId the facebook email id
	 */
	void addFacebookAttributesInCustomerModel(CustomerModel customerModel, String facebookEmailId);


}
