package br.com.springboot.curso_SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import br.com.springboot.curso_SpringBoot.model.Usuario;
import br.com.springboot.curso_SpringBoot.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired // IC/CD  ou CDI - Injeção de Dependencia
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    @RequestMapping(value = "/olamundo/{nome}", method =  RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String metodoHelloWord(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome_usuario(nome);
    	
    	usuarioRepository.save(usuario);// grava no banco de dados
    	return "Ola mundo " + nome;
		
	}
    
    @GetMapping(value = "listatodos")// primeiro metodo de API
    @ResponseBody // retorna os dados par ao corpo da resposta
    public ResponseEntity<java.util.List<Usuario>> listaUsuario(){
    	java.util.List<Usuario> usuarios =	usuarioRepository.findAll();// executa a consulta no banco de dados
    	
    	return new ResponseEntity<java.util.List<Usuario>>(usuarios, HttpStatus.OK);// retorna a lista em JSON
    }
    
    
    @PostMapping(value = "salvar")//mapeia a URL
    @ResponseBody // descrição da resposta
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){// RECEBE OS DADOS PARA SALVAR
    	Usuario user = usuarioRepository.save(usuario);
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    	
    }
    
    @DeleteMapping(value = "deletar")//mapeia a URL
    @ResponseBody // descrição da resposta
    public ResponseEntity<String> deletar(@RequestParam Long id_usuario){// RECEBE OS DADOS PARA SALVAR
    	usuarioRepository.deleteById(id_usuario);
    	return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "buscar_usuario_id")//mapeia a URL
    @ResponseBody // descrição da resposta
    public ResponseEntity<Usuario> buscar_user_id(@RequestParam(name = "iduser") Long iduser){// RECEBE OS DADOS PARA SALVAR
    	Usuario usuario = usuarioRepository.findById(iduser).get();
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
