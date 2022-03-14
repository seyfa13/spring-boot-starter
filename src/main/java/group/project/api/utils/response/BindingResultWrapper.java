package group.project.api.utils.response;

import group.project.api.exceptions.FormException;
import group.project.api.utils.constants.ExceptionConstants;
import org.springframework.validation.BindingResult;

public class BindingResultWrapper {

    public static void checkFormErrors(BindingResult bindingResult)  {

        if(bindingResult.hasErrors()) {

            System.out.println("binding result has erros");
            bindingResult.getAllErrors().forEach(e -> {
                System.err.println(e.getCode() + "(" + e.getDefaultMessage() + ") : " + e.getDefaultMessage());
            });

            throw new FormException(ExceptionConstants.formErrors());
        }

    }
}
