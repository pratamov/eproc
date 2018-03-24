package id.noeandfriends.eproc.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import id.noeandfriends.eproc.controller.AbstractOwnerController;
import id.noeandfriends.eproc.controller.rest.ContractorRestController;

@Controller
public class OwnerController extends ContractorRestController{
	
	@Autowired
	AbstractOwnerController controller;
	
}
