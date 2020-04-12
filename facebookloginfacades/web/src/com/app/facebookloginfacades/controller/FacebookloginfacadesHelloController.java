package com.app.facebookloginfacades.controller;

import static com.app.facebookloginfacades.constants.FacebookloginfacadesConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.facebookloginfacades.service.FacebookloginfacadesService;


@Controller
public class FacebookloginfacadesHelloController
{
	@Autowired
	private FacebookloginfacadesService facebookloginfacadesService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", facebookloginfacadesService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
