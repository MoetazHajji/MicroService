package tn.esprit.hrservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("LeaveAuth")
@CrossOrigin(origins = "http://localhost:4200")
public class Leave_AuthRestController {
}
