package com.app.facebookloginfacades;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.facebookloginfacades.data.SocialCustomerData;


/**
 * The Interface FacebookRegistrationFacade.
 */
public interface FacebookRegistrationFacade
{

	/**
	 * Gets the facebook provider.
	 *
	 * @return the facebook provider
	 */
	String getFacebookProvider();

	/**
	 * Gets the facebook registration success callback.
	 *
	 * @param code the code
	 * @param redirectAttributes the redirect attributes
	 * @return the facebook registration success callback
	 */
	SocialCustomerData getFacebookRegistrationSuccessCallback(final String code, final RedirectAttributes redirectAttributes);

	/**
	 * Gets the facebook registration error callback.
	 *
	 * @param errorReason the error reason
	 * @return the facebook registration error callback
	 */
	void getFacebookRegistrationErrorCallback(final String errorReason);

}
