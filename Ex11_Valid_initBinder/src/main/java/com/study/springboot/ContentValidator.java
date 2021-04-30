package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDto.class.isAssignableFrom(arg0); //검증할 객체의 클래스 타입 정보	
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		
		ContentDto dto = (ContentDto)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"writer","writer is empty.");
		String sWriter= dto.getWriter();
		if(sWriter.length() < 3) {
			errors.rejectValue("writer","writer is too short.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content","content is empty.");
	}
}
