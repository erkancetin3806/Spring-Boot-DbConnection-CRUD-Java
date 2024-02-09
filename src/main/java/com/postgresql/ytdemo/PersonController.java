package com.postgresql.ytdemo;

import com.postgresql.ytdemo.model.Person;
import com.postgresql.ytdemo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    PersonRepository repo;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person) {
        repo.save(person);
    }

    @PostMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable long id) {
        System.out.println("Delete request received for ID: " + id);

        if (repo.existsById(id)) {
            repo.deleteById(id);
            System.out.println("Veritabanı Kayıt Silme İşlemi Başarılı.. Silinen Kayıt: "+id);
        } else {
            System.out.println("Belirtilen ID'ye sahip bir kayıt bulunamadı: " + id);
        }
    }
}

