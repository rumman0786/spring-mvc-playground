package com.mkyong.helloworld.web;

import com.mkyong.helloworld.service.HelloWorldService;
import com.processors.concert.Performance;
import com.processors.soundsystem.BlankDisc;
import com.processors.soundsystem.CompactDisc;
import com.util.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Random;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private Performance musicalPerformance;

	@Autowired
	private Performance theChosenOne;

	@Autowired
	private CompactDisc playDisc;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());

		musicalPerformance.perform();
		theChosenOne.perform();

		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

	@RequestMapping(value = "/playTrack", method = RequestMethod.GET)
	public String playTrack(ModelMap model) {

		model.put("track", playDisc.playTrack(NumberUtils.getRandomBetween(0,4)));

		return "playTrack";
	}
}