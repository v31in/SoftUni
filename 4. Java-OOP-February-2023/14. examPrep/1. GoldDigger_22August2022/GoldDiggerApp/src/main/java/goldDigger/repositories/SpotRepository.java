package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SpotRepository implements Repository<Spot> {
    private List<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public void add(Spot entity) {
        this.spots.add(entity);
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots);
    }

    @Override
    public boolean remove(Spot entity) {
        return this.spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        return this.spots.stream()
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
