package com.app.facebookloginfacades.setup;

import static com.app.facebookloginfacades.constants.FacebookloginfacadesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.app.facebookloginfacades.constants.FacebookloginfacadesConstants;
import com.app.facebookloginfacades.service.FacebookloginfacadesService;


@SystemSetup(extension = FacebookloginfacadesConstants.EXTENSIONNAME)
public class FacebookloginfacadesSystemSetup
{
	private final FacebookloginfacadesService facebookloginfacadesService;

	public FacebookloginfacadesSystemSetup(final FacebookloginfacadesService facebookloginfacadesService)
	{
		this.facebookloginfacadesService = facebookloginfacadesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		facebookloginfacadesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return FacebookloginfacadesSystemSetup.class.getResourceAsStream("/facebookloginfacades/sap-hybris-platform.png");
	}
}
