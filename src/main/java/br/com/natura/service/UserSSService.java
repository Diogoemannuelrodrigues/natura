package br.com.natura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Cliente;
import br.com.natura.repository.ClienteRepository;
import br.com.natura.security.UserSS;

@Service
public class UserSSService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepo.findByEmail(email);

        if (cliente == null) {
            throw new UsernameNotFoundException("E-mail não encontrado." + email);
        }

        return new UserSS(cliente.getId_cliente(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
    }

}
