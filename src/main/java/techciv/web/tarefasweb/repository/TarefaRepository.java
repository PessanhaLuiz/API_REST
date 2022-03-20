package techciv.web.tarefasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import techciv.web.tarefasweb.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
