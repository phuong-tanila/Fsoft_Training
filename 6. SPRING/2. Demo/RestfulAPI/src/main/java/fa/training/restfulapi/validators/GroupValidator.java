package fa.training.restfulapi.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import fa.training.restfulapi.entities.ProductGroup;

public class GroupValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return ProductGroup.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "name.required");

		ProductGroup group = (ProductGroup) o;

		if (group.getGroupName().length() < 2) {
			errors.rejectValue("groupName", "name.required");
		}
	}
}