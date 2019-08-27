package se.miknel.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.miknel.model.Worker;
import se.miknel.services.WorkerService;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final WorkerService workerService;

    public UserPrincipalDetailsService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        Worker worker = this.workerService.findByUsername(s);

        if (worker == null) {
            throw new UsernameNotFoundException(s);
        }
        return new UserPrincipal(worker);
    }
}
