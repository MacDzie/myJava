package domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "graphicsCard.all", query = "SELECT gpu FROM GraphicsCard gpu"),
        @NamedQuery(name = "graphicsCard.id" , query = "SELECT OBJECT(gpu) FROM GraphicsCard gpu WHERE gpu.id=:gpuId"),
        @NamedQuery(name = "graphicsCard.model", query = "SELECT OBJECT(gpu) FROM GraphicsCard gpu WHERE gpu.model=:gpuModel"),
        @NamedQuery(name = "graphicsCard.price", query = "SELECT OBJECT(gpu) FROM GraphicsCard gpu WHERE gpu.price > :gpuPriceFrom AND gpu.price < :gpuPriceTo")
})
public class GraphicsCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
