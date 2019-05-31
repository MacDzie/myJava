package domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "computerParts.all", query = "SELECT cp FROM ComputerParts cp")
})
public class ComputerParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private GraphicsCard graphicsCard;
    private HardDisc hardDisc;
    private Motherboard motherboard;
    private RAMMemory ramMemory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public HardDisc getHardDisc() {
        return hardDisc;
    }

    public void setHardDisc(HardDisc hardDisc) {
        this.hardDisc = hardDisc;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public RAMMemory getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(RAMMemory ramMemory) {
        this.ramMemory = ramMemory;
    }
}
