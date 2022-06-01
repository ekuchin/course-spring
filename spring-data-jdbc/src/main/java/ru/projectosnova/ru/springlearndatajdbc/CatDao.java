package ru.projectosnova.ru.springlearndatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CatDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){

        //Создаем таблицу
        jdbcTemplate.execute("CREATE TABLE cats(" +
                "id SERIAL, name VARCHAR(255), breed VARCHAR(255))");

        //Создаем котов
        jdbcTemplate.update("INSERT INTO cats(name, breed) VALUES (?,?)", "Мурзик", "Манул");
        jdbcTemplate.update("INSERT INTO cats(name, breed) VALUES (?,?)", "Рамзес", "Сфинкс");
    }

     public List<Cat> findAll(){
        return new ArrayList<>(jdbcTemplate.query("SELECT * from cats",
                (rs, rowNum) -> new Cat(rs.getLong("id"), rs.getString("name"), rs.getString("breed"))));
    }

    public Cat findOne(Long id){
        return jdbcTemplate.query("SELECT * from cats WHERE id = "+id.toString(),
                new BeanPropertyRowMapper<>(Cat.class)).get(0);
    }

    public void save(Cat cat) {
        String query = "INSERT INTO cats (id, name, breed) VALUES (?,?,?)";
        Object[] args = new Object[] {cat.getId(), cat.getName(), cat.getBreed()};
        int out = jdbcTemplate.update(query, args);
        if(out !=0){
            System.out.println("Cat saved with id="+cat.getId());
        }else System.out.println("Cat save failed with id="+cat.getId());
    }

    public void delete (Long id){
        jdbcTemplate.update("DELETE from cats WHERE id = ?", id);
    }



}
