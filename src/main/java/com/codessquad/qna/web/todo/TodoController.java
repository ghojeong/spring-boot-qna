package com.codessquad.qna.web.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {
    TodoRepository todoRepository = new TodoRepository();

    @PostMapping(value = "/{columnId}")
    public ResponseEntity<TodoCard> addCard(@PathVariable("columnId") int columnId, @RequestBody TodoCard todoCard) {
        System.out.println(">>>>>>>>>>>>>" + todoCard);
        TodoCard newCard = todoRepository.add(columnId, todoCard);
        return ResponseEntity.created(
                URI.create(String.format("/todos/%d/%d", columnId, newCard.getId()))
        ).body(newCard);
    }

    @PutMapping(value = "/{columnId}")
    public ResponseEntity<Void> updateCard(@PathVariable("columnId") int columnId, @RequestBody TodoCard todoCard) {
        System.out.println(">>>>>>>>>>>>>" + todoCard);
        todoRepository.update(columnId, todoCard);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{columnId}/{todoCardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable("columnId") int columnId, @PathVariable("todoCardId") long todoCardId) {
        todoRepository.delete(columnId, todoCardId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/move")
    public ResponseEntity<Void> moveCard(@RequestBody MoveDto moveDto) {
        todoRepository.move(moveDto.getBeforeColumnId(),
                moveDto.getAfterColumnId(),
                moveDto.getCardData(),
                moveDto.getTargetCardId());
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<Map<Integer, Column>> getTodos() {
        return ResponseEntity.ok().body(todoRepository.columns);
    }

}
