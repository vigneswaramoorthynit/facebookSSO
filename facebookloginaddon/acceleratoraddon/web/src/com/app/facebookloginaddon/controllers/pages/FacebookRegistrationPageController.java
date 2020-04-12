/**
 *
 */
package com.app.facebookloginaddon.controllers.pages;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.app.facebookloginfacades.FacebookRegistrationFacade;
import com.app.facebookloginfacades.data.SocialCustomerData;



/**
 * The Class FacebookRegistrationPageController.
 *
 * @author vigneswaramoorthy.n
 */
@Controller
public class FacebookRegistrationPageController extends SocialNetworkAddonPageController
{

	/** The facebook registration facade. */
	@Resource(name = "facebookRegistrationFacade")
	private FacebookRegistrationFacade facebookRegistrationFacade;

	/**
	 * Register using facebook.
	 *
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/connect-facebook/register", method = RequestMethod.GET)
	public ModelAndView registerUsingFacebook() throws Exception
	{
		final String authorizeUrl = facebookRegistrationFacade.getFacebookProvider();
		final RedirectView redirectView = new RedirectView(authorizeUrl, true, true, true);
		return new ModelAndView(redirectView);
	}

	/**
	 * Gets the facebook registration success callback.
	 *
	 * @param code the code
	 * @param redirectAttributes the redirect attributes
	 * @param request the request
	 * @param response the response
	 * @return the facebook registration success callback
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/facebook/register-callback", method = RequestMethod.GET)
	public String getFacebookRegistrationSuccessCallback(@RequestParam("code") final String code,
			final RedirectAttributes redirectAttributes,
			final HttpServletRequest request, final HttpServletResponse response)
			throws Exception
	{
		final SocialCustomerData socialCustomerData = facebookRegistrationFacade.getFacebookRegistrationSuccessCallback(code,
				redirectAttributes);

		return getRedirectToRegisterPage();
	}

	/**
	 * Gets the facebook registration error callback.
	 *
	 * @param errorReason the error reason
	 * @return the facebook registration error callback
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/facebook/register-callback", params = "error_reason", method = RequestMethod.GET)
	public String getFacebookRegistrationErrorCallback(@RequestParam("error_reason") final String errorReason)
			throws Exception
	{
		facebookRegistrationFacade.getFacebookRegistrationErrorCallback(errorReason);
		return getRedirectToRegisterPage();
	}


}
