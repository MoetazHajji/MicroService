package com.example.commande.Controller;


import com.example.commande.Entity.Command;
import com.example.commande.Interfaces.ICommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Tag(name = "Command Management")
@AllArgsConstructor
@RestController
@RequestMapping("/command")
public class CommandController {
    ICommandService commandService;



    @Operation(description = "Add new Command")
    @PostMapping("add")
    public Command addCommand(@RequestBody Command command){
        return commandService.addCommand(command);
    }

    @Operation(description = "Modify Command")
    @PutMapping("modify")
    public Command modifyCommand(@RequestBody Command command ) {
        return commandService.modifyCommand(command);
    }

    @Operation(description = "Delete Command")
    @DeleteMapping("delete/{id}")
    public void deleteCommand(@PathVariable("id") Long id){
        commandService.deleteCommand(id);
    }

    @Operation(description = "Retreive Command by Id")
    @GetMapping("getAdress/{id}")
    public Command getCommandById(@PathVariable("id") Long id){
        return commandService.getCommandById(id);
    }

    @Operation(description = "Retreive all Commands")
    @GetMapping("getAllCommands")
    public Set<Command> getAllCommand(){
        return commandService.getAllCommands();
    }
    @PostMapping("AddCommandAndAssignToCommandLigne/{id}")
    public Command addCommandAndAffectProducts(@RequestBody Command command, @PathVariable("id") List<Long> idCommandLignes){
        return commandService.affectCommandToCommandLine(command,idCommandLignes);
    }







}
