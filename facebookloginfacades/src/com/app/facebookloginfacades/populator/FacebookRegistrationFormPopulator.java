package com.app.facebookloginfacades.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.springframework.social.facebook.api.User;

import com.app.facebookloginfacades.constants.GeneratedFacebookloginfacadesConstants.Enumerations.ProviderType;
import com.app.facebookloginfacades.data.SocialCustomerData;

/**
 * The Class FacebookRegistrationFormPopulator.
 */
public class FacebookRegistrationFormPopulator implements Populator<User, SocialCustomerData>
{

	/**
	 * (non-Javadoc)
	 *
	 */
	@Override
	public void populate(final User source, final SocialCustomerData target) throws ConversionException
	{
		target.setEmail(source.getEmail());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setGender(source.getGender());
		target.setFacebookUserId(source.getId());
		target.setSocialNetworkProvider(ProviderType.FACEBOOK);
	}
}
