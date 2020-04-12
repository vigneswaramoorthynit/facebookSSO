package com.app.facebookloginfacades.dao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;

import com.app.facebookloginfacades.dao.SocialNetworkDao;


/**
 * The Class DefaultSocialNetworkDao.
 */
public class DefaultSocialNetworkDao implements SocialNetworkDao
{

	/** The flexible search service. */
	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	/** The model service. */
	@Resource(name = "modelService")
	private ModelService modelService;


	/**
	 * (non-Javadoc)
	 */
	@Override
	public CustomerModel getCustomerLinkedToFacebookAccount(final String facebookUserId)
	{
		final String query = "SELECT {" + CustomerModel.PK + "} FROM {" + CustomerModel._TYPECODE + "} WHERE {"
				+ CustomerModel.FACEBOOKUSERID
				+ "}=?facebookUserId";
		final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
		fQuery.addQueryParameter("facebookUserId", facebookUserId);
		final SearchResult<CustomerModel> result = flexibleSearchService.search(fQuery);
		if (CollectionUtils.isNotEmpty(result.getResult()))
		{
			return result.getResult().get(0);
		}
		return null;
	}


	/**
	 *  (non-Javadoc)
	 */
	@Override
	public void addFacebookAttributesInCustomerModel(final CustomerModel customerModel, final String facebookUserId)
	{
		customerModel.setFacebookUserId(facebookUserId);
		modelService.save(customerModel);
	}


}
