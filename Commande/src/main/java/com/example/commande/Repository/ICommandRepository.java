package com.example.commande.Repository;

import com.example.commande.Entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandRepository extends JpaRepository<Command,Long> {


}
