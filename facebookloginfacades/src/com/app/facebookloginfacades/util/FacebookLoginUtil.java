package com.app.facebookloginfacades.util;

import de.hybris.platform.servicelayer.session.SessionService;

import javax.annotation.Resource;


/**
 * The Class FacebookLoginUtil.
 */
public class FacebookLoginUtil
{

	/** The session service. */
	@Resource(name = "sessionService")
	private SessionService sessionService;

	/**
	 * Initialize facebook attribute.
	 *
	 * @param facebookUserId the facebook user id
	 */
	public void initializeFacebookAttribute(final String facebookUserId)
	{
		sessionService.setAttribute("facebookUserId", facebookUserId);
	}


	/**
	 * Removes the facebook attributes.
	 */
	public void removeFacebookAttributes()
	{
		if (isFacebookAttributesAvailable())
		{
			sessionService.removeAttribute("facebookUserId");
		}
	}

	/**
	 * Checks if is facebook attributes available.
	 *
	 * @return true, if is facebook attributes available
	 */
	public boolean isFacebookAttributesAvailable()
	{
		return null != sessionService.getAttribute("facebookUserId");
	}

	/**
	 * Gets the facebook user id.
	 *
	 * @return the facebook user id
	 */
	public String getFacebookUserId()
	{
		return sessionService.getAttribute("facebookUserId");
	}

}
