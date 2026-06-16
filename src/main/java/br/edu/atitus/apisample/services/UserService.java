package br.edu.atitus.apisample.services;

import br.edu.atitus.apisample.entities.User;
import br.edu.atitus.apisample.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Esta classe será um Bean do Spring
// Ou seja, os objetos serão criados e gerenciados pelo Spring IOC

@Service
public class UserService {
    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User save(User newUser) throws Exception {
        if (newUser == null)
            throw new Exception("Objeto nulo!");

        if (newUser.getName() == null || newUser.getName().isBlank())
            throw new Exception("Nome informado inválido!");

        newUser.setName(newUser.getName().trim());

        if (newUser.getEmail() == null || newUser.getEmail().isBlank())
            throw new Exception("Email informado inválido!");

        newUser.setEmail(newUser.getEmail().trim().toLowerCase());

        //TODO fazer a validação do formato do email

        if (repository.existsByEmail(newUser.getEmail()))
            throw new Exception("Já existe um usuário cadastrado com esse email");

        if (newUser.getPassword() == null || newUser.getPassword().length() < 8)
            throw new Exception("Password informado inválido!");

        newUser.setPassword(encoder.encode(newUser.getPassword()));

        //TODO fazer a validação de qualidade da senha

        if (newUser.getType() == null)
            throw new Exception("Tipo de usuário inválido!");

        return repository.save(newUser);

}
}
