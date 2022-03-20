package techciv.web.tarefasweb.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techciv.web.tarefasweb.model.Tarefa;
import techciv.web.tarefasweb.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repo;

	public List<Tarefa> getTodasTarefas() {
		return repo.findAll();
	}

	public Tarefa salvarTarefa(Tarefa tarefa) {
		return repo.save(tarefa);
	}

	public Tarefa atualizarTarefa(Integer id, Tarefa tarefa) {
		Optional<Tarefa> tarefaOptional = repo.findById(id);
		if (!tarefaOptional.isPresent())
			throw new EntityNotFoundException("Recurso não encontrado");
		
		Tarefa tarefaBanco = tarefaOptional.get();
		
		tarefa.setId(tarefaBanco.getId());
		
		return repo.save(tarefa);
	}

	public void excluirPorId(Integer id) {
		repo.deleteById(id);
		
	}
	
}
