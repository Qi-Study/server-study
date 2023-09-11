package dev.jombi.qiqt.repository;

import dev.jombi.qiqt.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    @Query("UPDATE TodoEntity entity SET entity.success = :isSuccess WHERE entity.id = :id") // UPDATE ~~ SET ~~ WHERE ~~
    int editTodoMark(@Param("id") int id, @Param("isSuccess") boolean isSuccess);
}