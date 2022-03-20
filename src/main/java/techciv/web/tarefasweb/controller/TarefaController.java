package techciv.web.tarefasweb.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import techciv.web.tarefasweb.model.Tarefa;
import techciv.web.tarefasweb.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;
	
	@GetMapping()
	public List<Tarefa> getTarefas() {
		return service.getTodasTarefas();
	}
	
	@PostMapping
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		return service.salvarTarefa(tarefa);
	}
	
	@PutMapping(value = "{id}")
	public Tarefa autalziarTarefa(
			@PathVariable Integer id,
			@RequestBody Tarefa tarefa) {
		
		return service.atualizarTarefa(id, tarefa);
	}
	
	@DeleteMapping(value = "{id}")
	public void excluirTarefa(@PathVariable Integer id) {
		service.excluirPorId(id);
	}
}
