package com.app.facebookloginfacades.service.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
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

import com.app.facebookloginfacades.dao.SocialNetworkDao;
import com.app.facebookloginfacades.data.SocialCustomerData;
import com.app.facebookloginfacades.service.FacebookLoginService;


/**
 * The Class DefaultFacebookLoginService.
 */
public class DefaultFacebookLoginService implements FacebookLoginService
{

	/**
	 * The facebook connection factory.
	 **/
	@Resource(name = "facebookConnectionFactory")
	private FacebookConnectionFactory facebookConnectionFactory;

	/**
	 * The facebook data converter.
	 **/
	@Resource(name = "facebookDataConverter")
	private Converter<User, SocialCustomerData> facebookDataConverter;

	/**
	 * The facebook O auth 2 parameters.
	 **/
	@Autowired
	private OAuth2Parameters facebookOAuth2Parameters;

	/**
	 *  The social network dao.
	 **/
	@Resource(name = "socialNetworkDao")
	private SocialNetworkDao socialNetworkDao;

	/**
	 * The user service.
	 **/
	@Resource(name = "userService")
	private UserService userService;


	 /**
   * The sessionService.
   **/
  @Resource(name = "sessionService")
  private SessionService sessionService;


	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DefaultFacebookLoginService.class);

	/**
	 *  (non-Javadoc)
	 */
	@Override
	public String getFacebookLoginProvider()
	{
	  final Locale locale = sessionService.getCurrentSession().getAttribute("locale");
	  final OAuth2Template oauthOperations = (OAuth2Template) facebookConnectionFactory.getOAuthOperations();
		facebookOAuth2Parameters.setState("receivedfromfacebooktoken");
		facebookOAuth2Parameters.set("client_id", Config.getParameter("spring.social.facebook.appId"));
		facebookOAuth2Parameters.set("clientSecret", Config.getParameter("spring.social.facebook.appSecret"));
		facebookOAuth2Parameters.setRedirectUri(Config.getParameter(String.format("spring.social.facebook.logincallback.%s", locale.getLanguage())));

		facebookOAuth2Parameters.setScope(Config.getParameter("spring.social.facebook.scope"));
		return oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, facebookOAuth2Parameters);
	}

	/**
	 *  (non-Javadoc)
	 */
	@Override
	public SocialCustomerData getFacebookLoginSuccessCallback(final String code)
	{
	  final Locale locale = sessionService.getCurrentSession().getAttribute("locale");
	  final AccessGrant accessGrant = facebookConnectionFactory.getOAuthOperations().exchangeForAccess(code,
		    Config.getParameter(String.format("spring.social.facebook.logincallback.%s", locale.getLanguage())), null);
		final String accessToken = accessGrant.getAccessToken();
		final Facebook facebook = new FacebookTemplate(accessToken);
		final User userDetails = facebook.userOperations().getUserProfile();
		return facebookDataConverter.convert(userDetails);
	}

	/**
	 *  (non-Javadoc)
	 */
	@Override
	public void getFacebookLoginErrorCallback(final String errorReason)
	{
		LOG.error("Facebook Login failed due to ERR_NTFY_AST_INT08 - {}", errorReason);
	}

	/**
	 *  (non-Javadoc)
	 */
	@Override
	public CustomerModel getCustomerLinkedToFacebookAccount(final String facebookUserId)
	{
		return socialNetworkDao.getCustomerLinkedToFacebookAccount(facebookUserId);
	}

	/**
	 *  (non-Javadoc)
	 */
	@Override
	public void addFacebookAttributesInCustomerModel(final String facebookUserId)
	{
		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		socialNetworkDao.addFacebookAttributesInCustomerModel(customerModel, facebookUserId);
	}

}
