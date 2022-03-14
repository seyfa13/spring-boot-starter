package group.project.api.utils.response;

import group.project.api.exceptions.FormException;
import group.project.api.utils.constants.ExceptionConstants;
import org.springframework.validation.BindingResult;

public class BindingResultWrapper {

    public static void checkFormErrors(BindingResult bindingResult)  {

        System.err.println("binding result");
        if(bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(e -> {
                System.err.println(e.getCode() + "(" + e.getDefaultMessage() + ") : " + e.getDefaultMessage());
            });

            throw new FormException(ExceptionConstants.formErrors());
        }

    }
}
