package com.curso.reactividad.introtospring.repository;

import com.curso.reactividad.introtospring.repository.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {
    public static int counter = 0;

    private List<ToDo> list;

    public ToDoRepository(){
        list = new ArrayList<>();
    }

    public ToDo addTask(String task){
        counter++;
        ToDo newTask = new ToDo(counter, task);
        list.add(newTask);
        return newTask;
    }

    public String updateTask(int id, String task){
        //list.set(id-1,task);
        String confirmation = new String();

        if(list.stream().anyMatch(toDo -> toDo.id==id)){
            ToDo updatedTask = list.stream().filter(toDo -> toDo.id==id).findFirst().get();
            updatedTask.task=task;
            confirmation = "La tarea "+ id +" fue actualizada con "+task;
        }
        else{
            confirmation = "No se encontró la Tarea "+ id;
        }

        return confirmation;

    }

    public String deleteTask(int id){
        //list.remove(id-1);
        String confirmation = new String();

        if(list.stream().anyMatch(toDo -> toDo.id==id)){
            list.removeIf(toDo -> toDo.id==id);
            confirmation = "Tarea "+ id +" eliminada con exito";
        }
        else{
            confirmation = "No se encontró la Tarea "+ id;
        }

        return confirmation;
    }

    public List<ToDo> getTasks(){
        return list;
    }
}
