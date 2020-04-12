package com.app.facebookloginaddon.controllers.pages;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.app.facebookloginaddon.strategy.SocialNetworkLoginStrategy;
import com.app.facebookloginfacades.FacebookLoginFacade;
import com.app.facebookloginfacades.data.SocialCustomerData;
import com.app.facebookloginfacades.util.FacebookLoginUtil;


/**
 * The Class FacebookLoginPageController.
 *
 * @author vigneswaramoorthy.n
 */
@Controller
public class FacebookLoginPageController extends SocialNetworkAddonPageController
{

	/** The facebook login facade. */
	@Resource(name = "facebookLoginFacade")
	private FacebookLoginFacade facebookLoginFacade;

	/** The social network login strategy. */
	@Resource(name = "socialNetworkLoginStrategy")
	private SocialNetworkLoginStrategy socialNetworkLoginStrategy;

	/** The facebook Login Util. */
	@Resource(name = "facebookLoginUtil")
	private FacebookLoginUtil facebookLoginUtil;

	/** The customer facade. */
	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "commonI18NService")
	private CommonI18NService commonI18NService;

	/**
	 * Login using facebook.
	 *
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/connect-facebook/login", method = RequestMethod.GET)
	public ModelAndView loginUsingFacebook() throws Exception
	{
		final String authorizeUrl = facebookLoginFacade.getFacebookLoginProvider();
		final RedirectView redirectView = new RedirectView(authorizeUrl, true, true, true);
		return new ModelAndView(redirectView);
	}

	/**
	 * Gets the facebook login success callback.
	 *
	 * @param code the code
	 * @param request the request
	 * @param response the response
	 * @param redirectAttributes the redirect attributes
	 * @return the facebook login success callback
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/facebook/login-callback", method = RequestMethod.GET)
	public String getFacebookLoginSuccessCallback(@RequestParam("code") final String code, final HttpServletRequest request,
			final HttpServletResponse response,final RedirectAttributes redirectAttributes)
			throws Exception
	{
		try
		{
			final SocialCustomerData socialCustomerData = facebookLoginFacade.getFacebookLoginSuccessCallback(code);
			final CustomerModel customerModel = facebookLoginFacade
					.getCustomerLinkedToFacebookAccount(socialCustomerData.getFacebookUserId());

				final Authentication authentication = socialNetworkLoginStrategy.login(socialCustomerData, request,
						response);
				customerFacade.loginSuccess();
				customerModel.setSessionLanguage(commonI18NService.getCurrentLanguage());
				getGuidCookieStrategy().setCookie(request, response);
				getRememberMeServices().loginSuccess(request, response, authentication);
				return getRedirectToHomePage();
		}
		catch (final Exception e)
		{
			LOGGER.error("Error in Facebook login ERR_NTFY_AST_INT08 - {}",e);
			return getRedirectToLoginPage();
		}
	}

	/**
	 * Gets the facebook login error callback.
	 *
	 * @param errorReason the error reason
	 * @return the facebook login error callback
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/facebook/login-callback", params = "error_reason", method = RequestMethod.GET)
	public String getFacebookLoginErrorCallback(@RequestParam("error_reason") final String errorReason)
			throws Exception
	{
		facebookLoginFacade.getFacebookLoginErrorCallback(errorReason);
		return getRedirectToLoginPage();
	}

}
