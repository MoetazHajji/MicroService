package com.example.commande.Interfaces;

import com.example.commande.Entity.Command;
import com.example.commande.Entity.CommandLigne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ICommandService {
    Command addCommand(Command command);




    Command modifyCommand(Command command);

    void deleteCommand(Long id);
    Command getCommandById(Long id);
    Set<Command> getAllCommands();
    Command affectCommandToCommandLine(Command command, List<Long> idCommandLines);



    Set<CommandLigne> getCommandLigneOfCommand(Long idCom);

}