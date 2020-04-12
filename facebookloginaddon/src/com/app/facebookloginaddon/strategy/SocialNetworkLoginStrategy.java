package com.app.facebookloginaddon.strategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.app.facebookloginfacades.data.SocialCustomerData;


/**
 * The Interface SocialNetworkLoginStrategy.
 */
public interface SocialNetworkLoginStrategy
{

	/**
	 * Login.
	 *
	 * @param socialCustomerData the social customer data
	 * @param request the request
	 * @param response the response
	 * @return the authentication
	 */
	Authentication login(final SocialCustomerData socialCustomerData, final HttpServletRequest request, final HttpServletResponse response);
}
