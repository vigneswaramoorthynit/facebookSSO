package com.app.facebookloginfacades.service.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.util.Config;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.facebookloginfacades.data.SocialCustomerData;
import com.app.facebookloginfacades.service.FacebookRegistrationService;


/**
 * The Class DefaultFacebookRegistrationService.
 */
public class DefaultFacebookRegistrationService implements FacebookRegistrationService
{
	/** The facebook O auth 2 parameters. */
	@Autowired
	private OAuth2Parameters facebookOAuth2Parameters;

	/** The facebook data converter. */
	@Resource(name = "facebookDataConverter")
	private Converter<User, SocialCustomerData> facebookDataConverter;

	/** The facebook connection factory. */
	@Resource(name = "facebookConnectionFactory")
	private FacebookConnectionFactory facebookConnectionFactory;


  /**
   * The sessionService.
   **/
  @Resource(name = "sessionService")
  private SessionService sessionService;


	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DefaultFacebookRegistrationService.class);

	/**
	 * Gets the facebook connection factory.
	 *
	 * @return the facebook connection factory
	 */
	public FacebookConnectionFactory getFacebookConnectionFactory()
	{
		return facebookConnectionFactory;
	}

	/**
	 * (non-Javadoc)
	 *
	 * </code>
	 */
	@Override
	public String getFacebookProvider()
	{
	  final Locale locale = sessionService.getCurrentSession().getAttribute("locale");
	  final OAuth2Template oauthOperations = (OAuth2Template) facebookConnectionFactory.getOAuthOperations();
		facebookOAuth2Parameters.setState(Config.getParameter("spring.social.facebook.state"));
		facebookOAuth2Parameters.set("client_id", Config.getParameter("spring.social.facebook.appId"));
		facebookOAuth2Parameters.set("clientSecret", Config.getParameter("spring.social.facebook.appSecret"));
		facebookOAuth2Parameters.setRedirectUri(Config.getParameter(String.format("spring.social.facebook.callback.%s", locale.getLanguage())));
		facebookOAuth2Parameters.setScope(Config.getParameter("spring.social.facebook.scope"));
		return oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, facebookOAuth2Parameters);
	}

	/**
	 * (non-Javadoc)
	 *
	 */
	@Override
	public SocialCustomerData getFacebookRegistrationSuccessCallback(final String code, final RedirectAttributes redirectAttributes)
	{
	  final Locale locale = sessionService.getCurrentSession().getAttribute("locale");
	  final AccessGrant accessGrant = facebookConnectionFactory.getOAuthOperations().exchangeForAccess(code,
		    Config.getParameter(String.format("spring.social.facebook.callback.%s", locale.getLanguage())), null);
		final String accessToken = accessGrant.getAccessToken();
		final Facebook facebook = new FacebookTemplate(accessToken);
		final User userDetails = facebook.userOperations().getUserProfile();
		return facebookDataConverter.convert(userDetails);
	}

	/**
	 * (non-Javadoc)
	 *
	 */
	@Override
	public void getFacebookRegistrationErrorCallback(final String errorReason)
	{
		LOG.error("Facebook registration failed due to ERR_NTFY_AST_INT08 - {}", errorReason);
	}
}
