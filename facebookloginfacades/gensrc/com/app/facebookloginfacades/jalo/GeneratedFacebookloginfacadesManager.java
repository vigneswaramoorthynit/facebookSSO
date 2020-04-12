/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 12-Apr-2020 01:26:10                        ---
 * ----------------------------------------------------------------
 */
package com.app.facebookloginfacades.jalo;

import com.app.facebookloginfacades.constants.FacebookloginfacadesConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.store.BaseStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>FacebookloginfacadesManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedFacebookloginfacadesManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("facebookUserId", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("facebookLoginEnabled", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.store.BaseStore", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseStore.facebookLoginEnabled</code> attribute.
	 * @return the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public Boolean isFacebookLoginEnabled(final SessionContext ctx, final BaseStore item)
	{
		return (Boolean)item.getProperty( ctx, FacebookloginfacadesConstants.Attributes.BaseStore.FACEBOOKLOGINENABLED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseStore.facebookLoginEnabled</code> attribute.
	 * @return the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public Boolean isFacebookLoginEnabled(final BaseStore item)
	{
		return isFacebookLoginEnabled( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @return the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public boolean isFacebookLoginEnabledAsPrimitive(final SessionContext ctx, final BaseStore item)
	{
		Boolean value = isFacebookLoginEnabled( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @return the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public boolean isFacebookLoginEnabledAsPrimitive(final BaseStore item)
	{
		return isFacebookLoginEnabledAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @param value the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public void setFacebookLoginEnabled(final SessionContext ctx, final BaseStore item, final Boolean value)
	{
		item.setProperty(ctx, FacebookloginfacadesConstants.Attributes.BaseStore.FACEBOOKLOGINENABLED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @param value the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public void setFacebookLoginEnabled(final BaseStore item, final Boolean value)
	{
		setFacebookLoginEnabled( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @param value the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public void setFacebookLoginEnabled(final SessionContext ctx, final BaseStore item, final boolean value)
	{
		setFacebookLoginEnabled( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseStore.facebookLoginEnabled</code> attribute. 
	 * @param value the facebookLoginEnabled - Facebook SNS login/Registration is enabled
	 */
	public void setFacebookLoginEnabled(final BaseStore item, final boolean value)
	{
		setFacebookLoginEnabled( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.facebookUserId</code> attribute.
	 * @return the facebookUserId - Facebook Email Id
	 */
	public String getFacebookUserId(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, FacebookloginfacadesConstants.Attributes.Customer.FACEBOOKUSERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.facebookUserId</code> attribute.
	 * @return the facebookUserId - Facebook Email Id
	 */
	public String getFacebookUserId(final Customer item)
	{
		return getFacebookUserId( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.facebookUserId</code> attribute. 
	 * @param value the facebookUserId - Facebook Email Id
	 */
	public void setFacebookUserId(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, FacebookloginfacadesConstants.Attributes.Customer.FACEBOOKUSERID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.facebookUserId</code> attribute. 
	 * @param value the facebookUserId - Facebook Email Id
	 */
	public void setFacebookUserId(final Customer item, final String value)
	{
		setFacebookUserId( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return FacebookloginfacadesConstants.EXTENSIONNAME;
	}
	
}
