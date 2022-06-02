package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SleepingPlace {
   private Cat cat;
   private Cat cat2;

    @Autowired
    public SleepingPlace(@Qualifier("manul") Cat cat, @Qualifier("sphynx") Cat cat2) {
        setCat(cat);
        setCat2(cat2);
    }

    public Cat getCat() {
        return cat;
    }

    //  @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setCat2(Cat cat2) {
        this.cat2 = cat2;
    }

    public String getStatus(){
        return "Место занято котом: "+cat.getName()+". Второй кот лежит вторым слоем: "+cat2.getName();
    }


}
