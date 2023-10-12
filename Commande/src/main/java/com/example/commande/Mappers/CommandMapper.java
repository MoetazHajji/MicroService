package com.example.commande.Mappers;


import com.example.commande.Dto.CommandDto;
import com.example.commande.Entity.Command;

public class CommandMapper {
    public static CommandDto mapToDo(Command command){
        CommandDto commandDto=CommandDto.builder()
                .id(command.getId())
                //.date(command.getDate())
                .notice(command.getNotice())
                .build();
        return commandDto;
    }
    public static Command mapToEntity(CommandDto commandDto){
        Command command=Command.builder()
                .id(commandDto.getId())
                //.date(commandDto.getDate())
                .notice(commandDto.getNotice())
                .build();

        return command;
    }
}
