package fa.training.restfulapi.controllers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class CoreController {
	protected Link createHateoasLink(long id) {
		Link link = WebMvcLinkBuilder.linkTo(getClass()).slash(id).withSelfRel();
		return link;
	}
}
