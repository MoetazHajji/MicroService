package tn.esprit.hrservice.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.hrservice.Repository.Leave_AuthorizationRepository;


@Service
@Slf4j
@AllArgsConstructor
public class Leave_AuthService {

    Leave_AuthorizationRepository leave_authorizationRepository;

}

