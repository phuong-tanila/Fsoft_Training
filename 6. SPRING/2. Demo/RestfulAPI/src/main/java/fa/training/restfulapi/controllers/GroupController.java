package fa.training.restfulapi.controllers;

import fa.training.restfulapi.entities.ProductGroup;
import fa.training.restfulapi.hateoas.GroupModel;
import fa.training.restfulapi.services.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController extends CoreController {
	@Autowired
	EcommerceService ecommerceService;
	@Autowired
	Validator groupValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(groupValidator);
	}

	@GetMapping
	public List<GroupModel> index() {
		List<ProductGroup> list = ecommerceService.getGroups();

		List<GroupModel> out = new ArrayList<GroupModel>();
		list.forEach(g -> {
			GroupModel gr = new GroupModel(g);
			gr.add(createHateoasLink(g.getId()));
			out.add(gr);
		});

		return out;
	}

	@GetMapping("/{id}")
	public GroupModel view(@PathVariable("id") long id) {
		GroupModel gr = new GroupModel(ecommerceService.getGroup(id));
		gr.add(createHateoasLink(id));
		return gr;
	}

	@PostMapping(value = "/{id}")
	public ProductGroup edit(@PathVariable(value = "id", required = false) long id,
			@RequestBody @Valid ProductGroup group) {

		Optional<ProductGroup> optionalProductGroup = ecommerceService.getGroup(id);
		ProductGroup updatedGroup = optionalProductGroup.get();

		if (updatedGroup == null) {
			return null;
		}

		updatedGroup.setGroupName(group.getGroupName());
		updatedGroup.setPrice(group.getPrice());
		updatedGroup.setGroupVariants(group.getGroupVariants());

		// We must do this manually b/c of Hibernate.
		if (updatedGroup.getGroupVariants() != null) {
			updatedGroup.getGroupVariants().forEach(gv -> gv.setGroup(updatedGroup));
		}

		return ecommerceService.saveGroup(updatedGroup);
	}

	@PostMapping
	public ProductGroup create(@RequestBody @Valid ProductGroup group) {

		// We must do this manually b/c of Hibernate.
		if (group.getGroupVariants() != null) {
			group.getGroupVariants().forEach(gv -> gv.setGroup(group));
		}

		return ecommerceService.saveGroup(group);
	}
	// Todo: add delete method
}
