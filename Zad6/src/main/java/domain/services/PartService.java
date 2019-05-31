package domain.services;

import domain.GraphicsCard;

import java.util.ArrayList;
import java.util.List;

public class PartService {

    private static List<GraphicsCard> db = new ArrayList<>();

    public void update(GraphicsCard graphicsCard) {
        for (GraphicsCard gpu : db) {
            if(gpu.getId()==graphicsCard.getId()){
                gpu.setModel(graphicsCard.getModel());
                gpu.setPrice(graphicsCard.getPrice());
            }
        }
    }
}
