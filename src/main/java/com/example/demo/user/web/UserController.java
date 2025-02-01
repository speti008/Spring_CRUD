/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user.web;

import com.example.demo.user.Gender;
import com.example.demo.user.User;
import com.example.demo.user.UserId;
import com.example.demo.user.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.user.UserNotFoundException;
import com.example.demo.infrastructure.web.EditMode;
import org.springframework.validation.annotation.Validated;
//import com.example.demo.user.web.EditUserValidationGroupSequence;

/**
 *
 * @author stephensonpetit-homme
 */

@Controller
@RequestMapping("/users")
public class UserController {
    
    private final UserService service;
    
    public UserController(UserService service)
    {
        this.service = service;
    }
    
    @GetMapping
    public String index(Model model,
                        @SortDefault.SortDefaults({
                                @SortDefault("userName.lastName"),
                                @SortDefault("userName.firstName")}) Pageable pageable)
    {
        Page<User> users = service.getUsers(pageable);
        model.addAttribute("users", users);
        model.addAttribute("page",users);
        model.addAttribute("hasPrevious", users.hasPrevious());
        model.addAttribute("hasNext", users.hasNext());
        return "users/list";
    }
    
    @GetMapping("/create")
    public String createUserForm(Model model)
    {
        model.addAttribute("user", new CreateUserFormData());
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
        return "users/edit";
    }
    
    @PostMapping("/create") //<.>
    public String doCreateUser(@Valid @ModelAttribute("user") CreateUserFormData formData, //<.>
                               BindingResult bindingResult, Model model) { //<.>
        if (bindingResult.hasErrors()) { //<.>
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER)); //<.>
            return "users/edit"; //<.>
        }
        try {
            service.createUser(formData.toParameters()); //<.>
        }
        catch(IllegalArgumentException ex)
        {
            bindingResult.rejectValue("email", "error.user.email", ex.getMessage());
            //model.addAttribute(attributeName, bindingResult)
            return "users/edit";
        }

        return "redirect:/users"; //<.>
    }
    
    
    @GetMapping("/{id}")
    public String editUserForm(@PathVariable("id") UserId userId, Model model)
    {
        User user = service.getUser(userId)
                        .orElseThrow(() -> new UserNotFoundException(userId));
        model.addAttribute("user", EditUserFormData.fromUser(user));
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE));
        model.addAttribute("editMode", EditMode.UPDATE);
        
        return "users/edit";
    }
    
    @PostMapping("/{id}")
    public String doEditUser(@PathVariable("id") UserId userId,
                             @Validated(EditUserValidationGroupSequence.class) @ModelAttribute("user") EditUserFormData formData, //<.>
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "users/edit";
        }

        service.editUser(userId, formData.toParameters());

        return "redirect:/users";
    }
    
    @PostMapping("{id}/delete")
    public String doDeleteUser(@PathVariable("id") UserId userId)
    {
        service.deleteUser(userId);
        return "redirect:/users";
    }
    
    @GetMapping("/ex")
    public String throwException() {
    throw new RuntimeException("This is a fake exception for testing");
    }
    
    
}
