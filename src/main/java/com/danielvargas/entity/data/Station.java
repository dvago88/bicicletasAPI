package com.danielvargas.entity.data;

import com.danielvargas.entity.historial.Historial;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Station {

    @Id
    private Integer id;
    private boolean available;
    private int numberOfUses;

   /* @OneToMany(mappedBy = "station")
    private List<Historial> historial;*/

    public Station() {
    }

    public Station(int id, boolean available, int numberOfUses) {
        this.id = id;
        this.available = available;
        this.numberOfUses = numberOfUses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

}
